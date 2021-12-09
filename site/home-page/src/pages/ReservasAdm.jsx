import React, {useEffect, useState} from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import api from "../api";
import {Card, Col, Container, Row, ListGroup} from "react-bootstrap";
import {format} from "date-fns";

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
                                    <Card.Header>{reserva.quadra.nomeQuadra}</Card.Header>
                                    <ListGroup variant="flush">
                                        <ListGroup.Item>{reserva.horaPartida}</ListGroup.Item>
                                        <ListGroup.Item>{reserva.qtdAtletas}</ListGroup.Item>
                                        <ListGroup.Item>{format(new Date(reserva.horaPartida), 'hh:mm dd/MM')}</ListGroup.Item>
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
