import React, { useState } from "react";
import Footer from "../components/Footer";
import { Link, useHistory } from "react-router-dom";
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.min.css'; 
import api from "../api";
import { Form, Button } from "react-bootstrap";
import NavbarSecundario from "../components/NavbarSecundario";


function LoginAtleta() {

    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const history = useHistory();

    function login(e) {
        e.preventDefault();
        api.post("/atletas/login", {
            email: campo1,
            senha: campo2,
        }).then((resposta) => {
            if (resposta.status === 201) {
                //alert("logado com sucesso");
                toast.success('logado com sucesso')
                sessionStorage.setItem("idAtleta", resposta.data.id);
                history.push('/buscaQuadra');
            }
        }).catch((erro) => {
            //alert("logado erro");
            toast.error('email ou senha invalidos ou campos vazios')
            console.log(erro);
        })
    }

    return (

        <>

            <NavbarSecundario />
            <div class="containerLogin">
            <ToastContainer
                position="top-left"
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
            />
                <div class="logar">
                    <h3>Atleta</h3>
                    <Form onSubmit={login}>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email</Form.Label>
                            <Form.Control onChange={e => setCampo1(e.target.value)} type="email" placeholder="Enter email" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Senha</Form.Label>
                            <Form.Control onChange={e => setCampo2(e.target.value)} type="password"
                                          placeholder="Password"/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicCheckbox">
                            <Form.Check type="checkbox" label="Salvar"/>
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Entrar
                        </Button>
                    </Form>


                    <div className="container9">
                        <b>
                            ?? atleta?
                            <br />
                            <Link to="/loginAtleta"><a>clique aqui</a></Link>
                        </b>
                        <b>
                            N??o tem cadastro?
                            <br />
                            <Link to="/cadastroAtleta"><a>clique aqui</a></Link>
                        </b>
                    </div>
                </div>


            </div>

            <Footer/>
        </>
    );
}

export default LoginAtleta;