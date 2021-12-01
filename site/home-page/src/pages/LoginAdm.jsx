import React, { useState } from "react";
import Footer from "../components/Footer";
import { Link } from "react-router-dom";

import profile from '../home-template-css/img/profile.png'
import git from '../home-template-css/img/git.png'
import linkedn from '../home-template-css/img/linkedin.png'
import insta from '../home-template-css/img/insta.png'
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import FormLogin from "../componentsPagina/FormLogin";
import api from "../api";
import { useHistory } from 'react-router-dom';
import {Button, Form} from "react-bootstrap";

function LoginAdm() {

    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const history = useHistory();
    function login(e) {
        e.preventDefault();
        api.post("/adm/login", {
            email: campo1,
            senha: campo2,
        }).then((resposta) => {
            if (resposta.status === 201) {
                alert("logado com sucesso");
                history.push('/perfilAdm');
            }
        }).catch((erro) => {
            alert("logado erro");
            console.log(erro);
        })
    }
    return (

        <>
            <NavbarSecundario />
            <div class="containerLogin">
                <div class="logar">
                    <h3>Administrador</h3>
                    <Form onSubmit={login}>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email</Form.Label>
                            <Form.Control onChange={e => setCampo1(e.target.value)}  type="email" placeholder="Enter email" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Senha</Form.Label>
                            <Form.Control onChange={e => setCampo2(e.target.value)} type="password" placeholder="Password" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicCheckbox">
                            <Form.Check type="checkbox" label="Check me out" />
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Entrar
                        </Button>
                    </Form>



                    <h5>É atleta?</h5>
                    <Link to="/loginAtleta"><a>clique aqui</a></Link>
                </div>



            </div>

            <Footer />

        </>
    );
}
export default LoginAdm;