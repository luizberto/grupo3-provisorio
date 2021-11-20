import React, {useEffect, useState} from "react";
import api from "../api";

function DadosHorario(){
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
        <span class="tituloCard">
          <h1>horarios</h1>
          {horario.map((quadra) => (
            <div>{quadra.fkQuadra}</div>
          ))}
        </span>
      </>
  );
}
export default DadosHorario;