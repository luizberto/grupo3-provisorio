import React, {useEffect, useState} from "react";
import api from "../api";
import { format } from 'date-fns';
import {useHistory} from "react-router-dom";
import Horario from "../components/Horario";


function DadosHorario(){
    const [horario, setHorario] = useState([]);
    const [campo1, setCampo1] = useState("");
    const history = useHistory();

    useEffect(() => {
      async function pegaDados() {
        const resposta = await api.get("/horarios/"+sessionStorage.getItem('idQuadra'));
        if (resposta.status === 200) {
          setHorario(resposta.data);
        }

        console.log(resposta.data);
        //alert(resposta.data);
      }
      pegaDados();
    }, []);

  return (
    <>
        <span class="tituloCard">
          <h1>Horarios</h1>
        </span>
        {horario.map((horario)=>(
            //<div>{
            //    format(new Date(horario.dataQuadra), 'hh:mm dd/MM')
            //}</div>
            <Horario
                id = {horario.id}
                dataHora = {horario.dataQuadra}
            />


        ))}
      </>
  );
}
export default DadosHorario;