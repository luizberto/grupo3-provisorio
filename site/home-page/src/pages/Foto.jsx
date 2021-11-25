import React, { useState } from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import api from "../api";
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
            <NavbarSecundario voltar="/edicaoQuadra" anterior="voltar" />
            <div class="container-foto">
                <h3>Edição de foto</h3>
                <div class="foto">
                </div>
                <h3>Aplique sua foto</h3>
                <input class="input-foto" type="file" onChange={e => setFoto(e.target.value)} name="" id="input-foto" />
                <button onClick={fotoPatch} class="troca-foto">Finalizar troca</button>
            </div>
        </>
    );
}
export default Foto;