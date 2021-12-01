import React, {useState} from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import api from "../api";
import {Button, Form} from "react-bootstrap";

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
            <NavbarSecundario voltar="/edicaoQuadra" anterior="voltar"/>
            <div class="container-foto">
                <h3>Edição de foto</h3>
                <div class="foto">
            </div>
                <h3>Aplique sua foto</h3>
                <Form onSubmit={fotoPatch}>
                    <Form.Control type="file" onChange={e => setFoto(e.target.value)}/>
                    <Button  type="submit">Finalizar troca</Button>
                </Form>

            </div>
        </>
    );
}

export default Foto;