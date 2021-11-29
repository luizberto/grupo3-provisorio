import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import QuadrasAdm from "../components/QuadrasAdm";
import { Link } from "react-router-dom";
import api from "../api";
import { useEffect, useState } from "react";
import {Card, Button, Form, Offcanvas, Container, Row, Col} from "react-bootstrap";

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
      <NavbarSecundario />

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
          Download lista
        </button>
      </Container>
      <Container className="containerQuadras">
        {quadra.map((quadra) => (
            <>
            <Offcanvas show={show} onHide={handleClose}>
                <Offcanvas.Header closeButton>
                    <Offcanvas.Title>Offcanvas</Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body>
                    {quadra.limitePessoas}
                </Offcanvas.Body>

            </Offcanvas>
            <Card style={{ width: '18rem', color:"black" }}>
                <Card.Img variant="top" src={"http://localhost:8080/quadras/foto/"+quadra.idQuadra} />
                <Card.Body>
                    <Card.Title>{quadra.nomeQuadra}</Card.Title>
                    <Card.Text style={{ color:"black" }}>
                        Limite de pessoas: {quadra.limitePessoas}<br></br>
                        Descrição:{quadra.complemento}
                    </Card.Text>
                    <Button variant="primary" onClick={handleShow}>Detalhe</Button>
                </Card.Body>

            </Card>

            </>
        ))}

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
