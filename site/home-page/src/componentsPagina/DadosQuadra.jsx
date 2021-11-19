import React, {useEffect, useState} from "react";
import fundoperfil from "../home-template-css/App/img/camp-nou-5798015_640 1 (1).png";
import api from "../api";

function DadosQuadra(props) {

    const [horario, setHorario] = useState([]);

    useEffect(() => {
      async function pegaDados() {
        const resposta = await api.get("/horarios/"+sessionStorage.getItem('idQuadra'));
        if (resposta.status === 201) {
          setHorario(resposta.data);
        }

        console.log(resposta.data);
        alert(resposta.data);
      }
      pegaDados();
    }, []);
  
  return (
    <>
      
      <div class="box-info-quadra">
        <span class="tituloCard">
          <h1>descrição</h1>
        </span>

        <p>Limite de pessoas:</p>
        <p>Materiais esportivos:</p>
        <p>Telefone:</p>
        <p>Endereço:</p>
        <p>Cep:</p>
        <p>Descrição: {sessionStorage.getItem('descricao')}</p>
      </div>

      <div class="box-info-quadra">
        <span class="tituloCard">
          <h1>horarios</h1>
          {horario.map((quadra) => (
            <div>{quadra.fkQuadra}</div>
          ))}
        </span>
      </div>
    </>
  );
}

export default DadosQuadra;
