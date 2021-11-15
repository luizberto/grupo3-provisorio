import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import fundoperfil from '../home-template-css/App/img/camp-nou-5798015_640 1 (1).png'
import edite from '../home-template-css/App/img/edite.png'

function EdicaodeQuadra(){
    return(
        <>
        <NavbarSecundario/>
<section class="containerDescricao">
    
    <div class="box-quadra">
        <img src={fundoperfil} alt=""/>
    </div>

    <div class="containerBoxInfos">
        <div class="box-info-quadra">
          <span class="tituloCard">
            <h1>descrição</h1>
           <a href=""> <img src={edite} alt=""/> </a>
          </span> 
          <p>Limite de pessoas:</p>
          <p>Materiais esportivos:</p>
          <p>Telefone:</p>
          <p>Endereço:</p>
          <p>Cep:</p>
          <p>Descrição:</p> 
        </div>

        <div class="box-info-quadra">
          <span class="tituloCard">
            <h1>horarios</h1>
           <a href=""><img src={edite} alt=""/> </a> 
          </span>
        </div>
    </div>


</section>
        </>
    );
}
export default EdicaodeQuadra;