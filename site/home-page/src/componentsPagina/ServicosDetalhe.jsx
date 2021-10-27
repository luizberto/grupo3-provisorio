import React from "react";
import CompServicos from "../components/CompServicos";
import bolinha from '../home-template-css/img/fluent_sport-soccer-16-regular.png'
import imagen from '../home-template-css/img/camisaFundo.png'

function ServicosDetalhe({image, texto}){
    return(
        <>
<div class="container3">

    <div class="container-grid">

        <CompServicos image = {imagen}/>
        <CompServicos image = {imagen}/>
        <CompServicos image = {imagen}/>
        <CompServicos image = {imagen}/>
    </div>
</div>

        </>
    );
}
export default ServicosDetalhe;