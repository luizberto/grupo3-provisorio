import React, {useState} from "react";
import {useHistory} from "react-router-dom";
import {Button, Card, Form, Offcanvas} from "react-bootstrap";
import api from "../api";

function CardQuadras(props) {

    const history = useHistory();
    const [show, setShow] = useState(false);
    const [hora, setHora] = useState();
    const handleClose = () => setShow(false);
    let form = new FormData();

    function enviaFoto(e) {
        const file = document.getElementById("fotos");
        console.log("Cadastrando", file);

        form.append("foto", file.files[0]);

        api
            .patch("/quadras/foto/" + props.id, form, {

                headers: {
                    "Content-Type": "multpart/form-data",
                }

            }).then((response) => {
            if (response.status === 200) {
                alert("Foto cadastrada")
            }
        })
            .catch((err) => {
                console.error("ops! ocorreu um erro" + err);
            });
    }

    function enviaHora(e) {
      alert(hora)
      api.post("/horarios", {
        dataQuadra: hora,
        reserva:"NAO",
        fkQuadra: props.id,

      }).then((resposta) => {
        if (resposta.status === 201) {
          alert("aperte enter para se redirecionar");
          history.push('/cadastroEndereco');
        }
      }).catch((erro) => {
        console.log(erro);
      })
    }

    function quadra(e) {
        if (props.usuario == "atleta") {

            sessionStorage.setItem('idQuadra', props.id)
            sessionStorage.setItem('descricao', props.descricao)
            sessionStorage.setItem('nome', props.nome)
            sessionStorage.setItem('limitePessoas', props.limite)
            history.push('/visualizacaoAtleta');
        } else {
            setShow(true);
        }
    }

    return (
        <>
            <Offcanvas show={show} onHide={handleClose}>
                <Offcanvas.Header closeButton>
                    <Offcanvas.Title>{props.nome}</Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>
                    <Form onSubmit={enviaFoto}>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Upload de lista</Form.Label>
                            <Form.Control type="File" id="fotos"/>
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                    <Form onSubmit={enviaHora}>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Upload de Horario</Form.Label>
                            <Form.Control type="datetime-local" onChange={e => setHora(e.target.value)}/>
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Offcanvas.Body>

            </Offcanvas>
            <Card border="success" style={{width: '18rem', color: "black"}}>
                <Card.Img variant="top" src={"http://localhost:8080/quadras/foto/" + props.id}/>
                <Card.Body>
                    <Card.Title>{props.nome}</Card.Title>
                    <Card.Text style={{color: "black"}}>
                        Limite de pessoas: {props.limite}<br></br>
                        Descrição:{props.complemento}
                    </Card.Text>
                    <Button variant="primary" onClick={quadra}>Alugar</Button>
                </Card.Body>

            </Card>
        </>
    );
}

export default CardQuadras;
