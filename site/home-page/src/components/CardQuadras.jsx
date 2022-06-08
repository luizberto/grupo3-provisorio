import React, {useState} from "react";
import {useHistory} from "react-router-dom";
import {Button, Card, Form, Offcanvas} from "react-bootstrap";
import api from "../api";

function CardQuadras(props) {

    const history = useHistory();
    const [show, setShow] = useState(false);
    const [show2, setShow2] = useState(false);

    const [hora, setHora] = useState();
    const handleClose = () => setShow(false);
    const handleClose2 = () => setShow2(false);
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
        api.post("/horarios/"+props.id, {
            dataQuadra: hora,
            reserva: "NAO",

        }).then((resposta) => {
            if (resposta.status === 201) {
                alert("aperte enter para se redirecionar");
                history.push('/cadastroEndereco');
            }
        }).catch((erro) => {
            console.log(erro);
        })
    }

    function btnPrimario(e) {
        if (props.primario == "Alugar") {

            sessionStorage.setItem('idQuadra', props.id)
            sessionStorage.setItem('descricao', props.descricao)
            sessionStorage.setItem('nome', props.nome)
            sessionStorage.setItem('limitePessoas', props.limite)
            history.push('/visualizacaoAtleta');
        } else {
            setShow(true);
        }
    }
    function btnSecundario(e){
        if(props.secundario == "Favorito"){
            api.post("/favoritos", {
                idQuadra: props.id,
                idUsuario: sessionStorage.getItem("idAtleta"),

            }).then((resposta) => {
                if (resposta.status === 201) {
                    alert("Favoritado");
                }else if(resposta.status === 204){
                    alert("Quadra Já esta em favoritos")
                }
            }).catch((erro) => {
                console.log(erro);
            })
        }else{
            setShow2(true);
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
                            <Form.Label>Upload de Foto</Form.Label>
                            <Form.Control type="file" id="fotos"/>
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Enviar
                        </Button>
                    </Form>

                    <Form onSubmit={enviaHora}>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Upload de Horario</Form.Label>
                            <Form.Control type="datetime-local" onChange={e => setHora(e.target.value)}/>
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Enviar
                        </Button>
                    </Form>
                </Offcanvas.Body>

            </Offcanvas>

            <Offcanvas placement={"end"} show={show2} onHide={handleClose2}>
                <Offcanvas.Header closeButton>
                    <Offcanvas.Title>{props.nome}</Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>

                <Card.Img variant="top" src={"http://18.210.124.171:8080/quadras/foto/" + props.id}/>

                    <Form.Text>
                        Descrição: {props.descricao} <br/>
                    </Form.Text>

                    <Form.Text>
                        materiais espotivos: {props.complemento}
                    </Form.Text>

                </Offcanvas.Body>
            </Offcanvas>

            <Card border="success" style={{width: '18rem', color: "black"}}>
                <Card.Body>
                    <Card.Title>{props.nome}</Card.Title>

                    <Card.Text style={{color: "black"}}>
                        Limite de pessoas: {props.limite}<br></br>
                        Descrição:{props.descricao}
                    </Card.Text>
                    <Button variant="primary" onClick={btnPrimario}>{props.primario}</Button>
                    <Button variant="primary" style={{float: "right"}} onClick={btnSecundario}>{props.secundario}</Button>
                </Card.Body>

            </Card>
        </>
    );
}

export default CardQuadras;
