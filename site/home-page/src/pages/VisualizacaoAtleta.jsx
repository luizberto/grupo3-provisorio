import React from "react";
import DadosQuadra from "../componentsPagina/DadosQuadra";
import ButtonEdit from "../components/ButtonEdit";
import ImageQuadra from "../components/ImageQuadra";

function VislualizacaoAtleta(){
    return(
        <section class="containerDescricao"> 
        <ImageQuadra/> 
       
       <div class="containerBoxInfos">
           
           <DadosQuadra/>
           
          
       </div>
       <ButtonEdit acao = "Alugar"/>
       </section>
    );
}export default VislualizacaoAtleta;