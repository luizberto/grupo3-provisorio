import React from "react";
import ButtonEdit from "../components/ButtonEdit";
import Footer from "../components/Footer";
import ImageQuadra from "../components/ImageQuadra";
import NavbarSecundario from "../components/NavbarSecundario";
import DadosHorario from "../componentsPagina/DadosHorario";
import DadosQuadra from "../componentsPagina/DadosQuadra";
import fundoperfil from '../home-template-css/App/img/camp-nou-5798015_640 1 (1).png'
import edite from '../home-template-css/App/img/edite.png'

function EdicaodeQuadra(){
    return(
        <>
        <NavbarSecundario/>
<section class="containerDescricao"> 
 <ImageQuadra/> 

<div class="containerBoxInfos">

    <div class="box-info-quadra">

        <span class="tituloCard">
            <h1>descrição</h1>
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