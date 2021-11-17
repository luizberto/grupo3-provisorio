import React from "react";
import DadosQuadra from "../componentsPagina/DadosQuadra";
import ButtonEdit from "../components/ButtonEdit";
import ImageQuadra from "../components/ImageQuadra";
import {Link} from 'react-router-dom';
function VislualizacaoAtleta(){
    return(
        <section class="containerDescricao"> 
        <ImageQuadra/> 
       
       <div class="containerBoxInfos">
           
           <DadosQuadra/>
           
          
       </div>
       <Link to = "/"><ButtonEdit acao = "Alugar"/></Link> 
       </section>
    );
}export default VislualizacaoAtleta;