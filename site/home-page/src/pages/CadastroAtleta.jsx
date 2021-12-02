import React, { useState } from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import { Link } from "react-router-dom";
import { useHistory } from 'react-router-dom';
import api from '../api';
import InputMask from 'react-input-mask';
import {Button, Form} from "react-bootstrap";
import {useForm} from "react-hook-form";
function CadastroAtleta(props) {

    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const [campo3, setCampo3] = useState("");
    const [campo4, setCampo4] = useState("");
    const [campo5, setCampo5] = useState("");
    const history = useHistory();


    const {register} = useForm();

    function atleta(e) {
        e.preventDefault();

        api.post("/atletas", {
            nomeAtleta: campo1,
            email: campo2,
            senha: campo3,
            dataNasc: campo4,
            cpf: campo5

        }).then((resposta) => {
            if (resposta.status === 201) {
                alert("aperte enter para se redirecionar");
                sessionStorage.setItem("email", campo2);
                sessionStorage.setItem("senha", campo3);
                sessionStorage.setItem("user", "adm")

                history.push('/loginAtleta');
            }
        }).catch((erro) => {
            console.log(erro);
        })
    }

    return (
        <>
            <NavbarSecundario voltar = "/loginAtleta" />
            <div class="container4">
                <div class="dadosCadastro">
                    <Form onSubmit={atleta}>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Nome</Form.Label>
                            <Form.Control onChange={e => setCampo1(e.target.value)}  type="String" placeholder="Nome" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Email</Form.Label>
                            <Form.Control onChange={e => setCampo2(e.target.value)} type="email" placeholder="Email" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Senha</Form.Label>
                            <Form.Control onChange={e => setCampo3(e.target.value)} type="password" placeholder="Senha" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Data Nascimento</Form.Label>
                            <Form.Control onChange={e => setCampo4(e.target.value)} type="date" placeholder="" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>CPF</Form.Label>
                            <Form.Control onChange={e => setCampo5(e.target.value)} type="String" placeholder="" />
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </div>
            </div>
            <Footer />
        </>
    );
}
export default CadastroAtleta;