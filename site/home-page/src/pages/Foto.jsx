import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";

function Foto(){
    return(
        <>
        <NavbarSecundario/>
        <div class="container-foto">
            <h3>Edição de foto</h3>
        <div class="foto">
        </div>
        <h3>Aplique sua foto</h3>
        <input class="input-foto" type="image" name="" id="input-foto" value="enviar foto"/>
        <button class="troca-foto">Finalizar troca</button>
    </div>
        </>
    );
}
export default Foto;