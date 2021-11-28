import React, {useState} from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import {Link, useHistory} from "react-router-dom";
import api from "../api";
import {Form, Button} from "react-bootstrap";


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
                alert("logado com sucesso");
                history.push('/buscaQuadra');
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
                    <Form onSubmit={login}>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control onChange={e => setCampo1(e.target.value)}  type="email" placeholder="Enter email" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control onChange={e => setCampo2(e.target.value)} type="password" placeholder="Password" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicCheckbox">
                            <Form.Check type="checkbox" label="Check me out" />
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>



                    <h5>É administrador de alguma quadra?</h5>
                    <Link to="/loginAdm"><a>clique aqui</a></Link>
                </div>



            </div>

            <Footer />
        </>
    );
}

export default LoginAtleta;