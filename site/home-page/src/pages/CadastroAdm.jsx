import React, {useState} from "react";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar.jsx";
import api from '../api';
import InputMask from 'react-input-mask';
import { Link } from "react-router-dom";
import { useHistory } from 'react-router-dom';
import {Button, Form} from "react-bootstrap";
import NavbarSecundario from "../components/NavbarSecundario";

function CadastroAdm(props){ 
    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const [campo3, setCampo3] = useState("");
    const [campo4, setCampo4] = useState("");
    const [campo5, setCampo5] = useState("");


    const history = useHistory();

    function adm(e) {
        e.preventDefault();
        alert(campo4);
        api.post("/adm", {
          nomeDono: campo1,
          email: campo2,
          senha: campo3,
          dataNasc: campo4,
          cpf: campo5
        }).then((resposta) => {
          if (resposta.status === 201) {
            alert("aperte enter para se redirecionar");
            
          }
        }).catch((erro) => {
          console.log(erro);
        })
      }
      
    return (
        <>
            <NavbarSecundario voltar = "/loginAdm"/>
            <div class="container4">
                <div class="dadosCadastro">
                    <h4 class="tituloForm">Administrador</h4>
                    <Form onSubmit={adm}>
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
                            Entrar
                        </Button>
                    </Form>
                </div>

            </div>
            <Footer />
        </>
    );
}
export default CadastroAdm;