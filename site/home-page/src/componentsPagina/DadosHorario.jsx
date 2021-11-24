import React, {useEffect, useState} from "react";
import api from "../api";
import { format } from 'date-fns';
import {useHistory} from "react-router-dom";



function DadosHorario(){
    const [horario, setHorario] = useState([]);
    const [campo1, setCampo1] = useState("");
    const history = useHistory();

    useEffect(() => {
      async function pegaDados() {
        const resposta = await api.get("/horarios/"+sessionStorage.getItem('idQuadra'));
        if (resposta.status === 201) {
          setHorario(resposta.data);
        }

        console.log(resposta.data);
        //alert(resposta.data);
      }
      pegaDados();
    }, []);
    function hora(id, fk, data){
        sessionStorage.setItem("idHorario", id)
        sessionStorage.setItem("fkQuadra", fk)
        sessionStorage.setItem("dataQuadra", data)
        alert(id)
        alert(fk)
        alert(data)
        history.push("/pagamento")
    }

  return (
    <>
        <span class="tituloCard">
          <h1>horarios</h1>
        </span>
        {horario.map((horario)=>(
            <div className = "botaoReserva" onClick={e => hora(horario.id, horario.fkQuadra, format(new Date(horario.data), 'yyyy-MM-dd hh:mm:ss'))}>{
                format(new Date(horario.data), 'hh:mm dd/MM')
            }</div>
        ))}
      </>
  );
}
export default DadosHorario;