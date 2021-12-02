import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import QuadrasAdm from "../components/QuadrasAdm";
import { Link } from "react-router-dom";
import api from "../api";
import { useEffect, useState } from "react";
import {Card, Button, Form, Offcanvas, Container, Row, Col} from "react-bootstrap";
import CardQuadras from "../components/CardQuadras";

function PerfilAdm() {
  const [quadra, setQuadra] = useState([]);
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

  useEffect(() => {
    async function pegaDados() {
      const resposta = await api.get("/quadras");
      if(resposta.status === 200){
        setQuadra(resposta.data);
      }

      console.log(resposta.data);
    }
    pegaDados();
  }, []);
    function enviaArquivo(e){
        e.preventDefault();

    }
  return (
    <>
      <NavbarSecundario voltar = "/" />

      <Container className="titulo">
          <Form onSubmit={enviaArquivo}>
              <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Upload de lista</Form.Label>
                  <Form.Control type="File" placeholder="" />
              </Form.Group>
              <Button variant="primary" type="submit">
                  Submit
              </Button>
          </Form>
        <h1>Suas quadras</h1>
        <button className="quadraBtn download">
          Dwld lista
        </button>
      </Container>
      <Container className="containerQuadras">
          <Row xs={1} md={3} className="g-4">
        {quadra.map((quadra) => (
            <>
                <Col md="auto">
                    <CardQuadras
                        id={quadra.idQuadra}
                        descricao={quadra.descQuadra}
                        nome={quadra.nomeQuadra}
                        limite={quadra.limitePessoas}
                        usuario="administrador"
                    />
                </Col>
            </>
        ))}
          </Row>
      </Container>
      <Container class="content-add-quadra">
        <Container class="add">
          <Link to="/cadastroQuadras">
            <Button>
              <p>+</p>
            </Button>
          </Link>
        </Container>
      </Container>
    </>
  );
}
export default PerfilAdm;
