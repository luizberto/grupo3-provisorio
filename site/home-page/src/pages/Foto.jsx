import React, {useState} from "react";
import Navbar from "../components/Navbar";
import api from "../api";
import {Button, Form} from "react-bootstrap";
import Footer from "../components/Footer";

function Foto() {
    const [foto, setFoto] = useState("");
    const FormData = require('form-data');
    const formData = new FormData();

    function fotoPatch(e) {
        formData.append("foto", foto);
        api.patch("/quadras/foto/" + sessionStorage.get("idQuadra"), formData)
            .then((resposta) => {
                if (resposta.status === 200) {
                    alert("foto modificada");

                }
            }).catch((erro) => {
            console.log(erro);
        })
    }

    return (
        <>
            <Navbar voltar="/edicaoQuadra" anterior="voltar"/>
            <div class="container">
            <div class="container-foto">
                <h3>Insira sua foto</h3>
            <div class="foto">
            </div>
                <Form onSubmit={fotoPatch}>
                    <Form.Control type="file" onChange={e => setFoto(e.target.value)}/>
                    <Button  type="submit">Finalizar</Button>
                </Form>
            </div>
            </div>
            <Footer/>
        </>
    );
}

export default Foto;