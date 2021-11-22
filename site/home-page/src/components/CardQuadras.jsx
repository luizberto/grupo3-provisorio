import React from "react";
import img from "../home-template-css/App/img/camp-nou-5798015_640 1 (1).png";
import { Link, useHistory } from "react-router-dom";

function CardQuadras(props) {

  const history = useHistory();

  function quadra(e){
    sessionStorage.setItem('idQuadra', props.id)
    sessionStorage.setItem('descricao', props.descricao)
    sessionStorage.setItem('nome', props.nome)
    sessionStorage.setItem('limitePessoas', props.limite)
    history.push('/visualizacaoAtleta');

  }
  return (
    <>
      <div class="contentCard">
        <div class="boxCard">
          <div class="cardImg">
            <img src={img} alt="" />
          </div>

          <div class="content-clube-descricao">
            <h1>{props.nome}</h1>
            <p>{props.descricao}</p>
              <button onClick={quadra} class="clubeButton">conhecer</button>
          </div>
        </div>
      </div>
    </>
  );
}
export default CardQuadras;
