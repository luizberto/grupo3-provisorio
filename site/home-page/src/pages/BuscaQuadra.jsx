import React, {useEffect, useState} from "react";
import api from "../api";
import NavbarSecundario from "../components/NavbarSecundario";
import Footer from "../components/Footer";
import {Button, Card, Col, Container, Row, InputGroup, FormControl} from "react-bootstrap";
import CardQuadras from "../components/CardQuadras";
function BuscaQuadra() {
    const [quadra, setQuadra] = useState([]);
    const [notFound, setNotFound] = useState();
    const [cidade, setCidade] = useState("");
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

    function getFavoritos(e){
        api.get("/favoritos/"+sessionStorage.getItem("idAtleta"))
            .then((response) => {
                if (response.status === 200) {
                    setQuadra(response.data)
                    console.log(response.data)

                }
            }).catch((err) => {
            console.error("ops! ocorreu um erro" + err);
        });
    }
    function getByCidade(e){
        api.get("/quadras/cidade/"+cidade)
            .then((response) => {
                if (response.status === 201) {
                    setQuadra(response.data)
                    console.log(response.data)
                }
            }).catch((err) => {
            console.error("ops! ocorreu um erro" + err);
        });
    }

    return (
        <>
            {/*<select name="select">*/}
            {/*    <option value="valor1">Ordenar</option>*/}
            {/*    <option value="valor2">Distancia</option>*/}
            {/*    <option value="valor3">Favoritos</option>*/}
            {/*</select>*/}
            <NavbarSecundario/>
            <Container className="containerQuadras">
                <InputGroup className="mb-3" style={{width:"35%" , marginLeft:"30px"}}>
                    <FormControl
                        placeholder="Cidade"
                        aria-label="Bairro"
                        aria-describedby="basic-addon2"
                        onChange={e => setCidade(e.target.value)}
                    />
                    <Button onClick={getByCidade} variant="outline-secondary" id="button-addon2">
                        Pesquisar
                    </Button>
                    <Button className="quadraBtn download" onClick={getFavoritos}>
                        Meus favoritos
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
                                    primario="Alugar"
                                    secundario="Favorito"
                                />
                            </Col>
                        </>
                    ))}
                </Row>
            </Container>
        </>
    );
}

export default BuscaQuadra;
