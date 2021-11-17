import React from "react";
import ButtonEdit from "../components/ButtonEdit";
import ImageQuadra from "../components/ImageQuadra";
import NavbarSecundario from "../components/NavbarSecundario";
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
    
    <DadosQuadra/>
    
   
</div>
<ButtonEdit acao = "Editar"/>
</section>
        </>
    );
}
export default EdicaodeQuadra;