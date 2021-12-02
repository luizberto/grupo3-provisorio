import React, {useEffect, useState} from "react";
import api from "../api";
import NavbarSecundario from "../components/NavbarSecundario";
import Footer from "../components/Footer";
import {Button, Card, Col, Container, Row, InputGroup, FormControl} from "react-bootstrap";
import CardQuadras from "../components/CardQuadras";
function BuscaQuadra() {
    const [quadra, setQuadra] = useState([]);
    const [notFound, setNotFound] = useState();

    useEffect(() => {
        async function pegaDados() {
            const resposta = await api.get("/quadras");
            if (resposta.status === 200) {
                setQuadra(resposta.data);
                setNotFound("");
            } else if (resposta.status === 204) {
                setNotFound(<div>Nao achou nenhuma quadra</div>);
            }

            console.log(resposta.data);
        }

        pegaDados();
    }, []);

    return (
        <>
            {/*<select name="select">*/}
            {/*    <option value="valor1">Ordenar</option>*/}
            {/*    <option value="valor2">Distancia</option>*/}
            {/*    <option value="valor3">Favoritos</option>*/}
            {/*</select>*/}
            <NavbarSecundario/>
            <Container className="containerQuadras">
                <InputGroup className="mb-3" style={{width:"20%" , marginLeft:"30px"}}>
                    <FormControl
                        placeholder="Nome da quadra"
                        aria-label="Nome da quadra"
                        aria-describedby="basic-addon2"
                    />
                    <Button variant="outline-secondary" id="button-addon2">
                        Pesquisar
                    </Button>
                </InputGroup>
                <Row xs={2} md="auto" >
                    {quadra.map((quadra) => (
                        <>

                            <Col md="auto">
                                <CardQuadras
                                    id={quadra.idQuadra}
                                    descricao={quadra.descQuadra}
                                    nome={quadra.nomeQuadra}
                                    limite={quadra.limitePessoas}
                                    usuario="atleta"
                                />
                            </Col>
                        </>
                    ))}
                </Row>
            </Container>
            <Footer/>
        </>
    );
}

export default BuscaQuadra;
