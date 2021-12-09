import React, {useEffect, useState} from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import api from "../api";
import {Card, Col, Container, Row, ListGroup} from "react-bootstrap";

function ReservasAdm() {
    const [reserva, setReserva] = useState([]);

    useEffect(() => {
        async function pegaDados() {
            const resposta = await api.get("/reservas");
            if (resposta.status === 200) {
                setReserva(resposta.data);
            }

            console.log(resposta.data);
        }

        pegaDados();
    }, []);

    return (
        <>
            <NavbarSecundario voltar = "/perfilAdm"/>
            <Container className="titulo">
                <h1>Suas reservas</h1>
            </Container>
            <Container className="containerQuadras">
                <Row xs={1} md={4} className="g-4">
                    {reserva.map((reserva) => (
                        <>
                            <Col>
                                <Card style={{ width: '18rem' }}>
                                    <Card.Header>Featured</Card.Header>
                                    <ListGroup variant="flush">
                                        <ListGroup.Item>Cras justo odio</ListGroup.Item>
                                        <ListGroup.Item>Dapibus ac facilisis in</ListGroup.Item>
                                        <ListGroup.Item>Vestibulum at eros</ListGroup.Item>
                                    </ListGroup>
                                </Card>
                            </Col>
                        </>
                    ))}
                </Row>
            </Container>
        </>
    );
}

export default ReservasAdm;
