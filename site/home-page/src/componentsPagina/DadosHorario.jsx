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
    function pegaHorario(idHorario){
        sessionStorage.setItem("idHorario", idHorario)

    }
  return (
    <>
        <span class="tituloCard">
          <h1>horarios</h1>
        </span>
        {horario.map((horario) => (
            <button className = "botaoReserva" onClick={pegaHorario(horario.id)}>{horario.data}</button>
        ))}
      </>
  );
}
export default DadosHorario;