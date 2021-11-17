import React from "react";
import img from '../home-template-css/App/img/camp-nou-5798015_640 1 (1).png'
import {Link} from 'react-router-dom';

function CardQuadras(){
    return(
        <>
             <div class="contentCard">
        <div class="boxCard">
          <div class="cardImg">
            <img src={img} alt=""/>
          </div>

          <div class="content-clube-descricao">
            <h1>get Nome da quadra</h1>
            <p>Get descrição de quadra</p>
           <Link to = "/visualizacaoAtleta"><button class="clubeButton">conhecer</button> </Link> 
          </div>
        </div>
      </div>
        </>
    );
}
export default CardQuadras;