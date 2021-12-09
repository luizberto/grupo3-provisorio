import React, {useEffect, useState} from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import {Link} from "react-router-dom";
import api from "../api";
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import CardQuadras from "../components/CardQuadras";

function PerfilAdm() {
    const [quadra, setQuadra] = useState([]);
    const [show, setShow] = useState(false);
    let form = new FormData();


    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    useEffect(() => {
        async function pegaDados() {
            const resposta = await api.get("/quadras");
            if (resposta.status === 200) {
                setQuadra(resposta.data);
            }

            console.log(resposta.data);
        }

        pegaDados();
    }, []);

    function enviaArquivo(e) {
        const file = document.getElementById("files");
        console.log("Cadastrando", file);

        form.append("inputFile", file.files[0]);

        api
            .post("/txt/import", form, {

                headers: {
                    "Content-Type": "multpart/form-data",
                }

            }).then((response) => {
            if (response.status === 201) {
                alert("Quadras cadstradas")
            }
        })
            .catch((err) => {
                console.error("ops! ocorreu um erro" + err);
            });
    }
    function downloadLista(e) {
        api.get("/txt/quadra")
            .then((response) => {
            if (response.status === 201) {
                alert("Lista baixada")
            }
        }).catch((err) => {
            console.error("ops! ocorreu um erro" + err);
        });
    }
    return (
        <>
            <NavbarSecundario voltar="/"/>

            <Container className="titulo">
                <Form onSubmit={enviaArquivo}>
                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Upload de lista</Form.Label>
                        <Form.Control type="File" id="files"/>
                    </Form.Group>
                    <Button variant="success" type={"submit"}>
                        Enviar
                    </Button>
                </Form>
                
                <Button variant = "success" className="quadraBtn download">
                    Download lista
                </Button>
            </Container>
            <Container className="containerQuadras">
                <Row xs={1} md='auto' className="g-4">
                    {quadra.map((quadra) => (
                        <>
                            <Col md="auto">
                                <CardQuadras
                                    id={quadra.idQuadra}
                                    descricao={quadra.descQuadra}
                                    nome={quadra.nomeQuadra}
                                    limite={quadra.limitePessoas}
                                    usuario="Editar"
                                />
                            </Col>
                        </>

                    ))}
                </Row>
            </Container>
            <Container class="content-add-quadra">
                <Container class="add">
                    <Link to="/cadastroQuadras">
                        <Button variant = "success">
                            <p>+</p>
                        </Button>
                    </Link>
                </Container>
            </Container>
        </>
    );
}

export default PerfilAdm;
