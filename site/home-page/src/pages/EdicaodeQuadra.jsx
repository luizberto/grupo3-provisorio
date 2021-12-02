import React from "react";
import ButtonEdit from "../components/ButtonEdit";
import Footer from "../components/Footer";
import ImageQuadra from "../components/ImageQuadra";
import NavbarSecundario from "../components/NavbarSecundario";
import DadosHorario from "../componentsPagina/DadosHorario";
import DadosQuadra from "../componentsPagina/DadosQuadra";
import { Link } from "react-router-dom";

function EdicaodeQuadra(){
    return(
        <>
        <NavbarSecundario voltar = "/perfilAdm"/>
<section class="containerDescricao"> 
 <ImageQuadra/> 

    <Link to = "/foto" className = "link-troca">
       <button class = "botaoTrocar">trocar imagem</button>
    </Link>

<div class="containerBoxInfos">

    <div class="box-info-quadra">

        <span class="tituloCard">
            <h1>Descrição</h1>
        </span>
        <DadosQuadra/>
        <ButtonEdit acao = "Editar"/>
    </div>

    <div class="box-info-quadra">
        <DadosHorario/>
    </div>
    
</div>

</section>
<Footer/>

        </>
    );
}
export default EdicaodeQuadra;