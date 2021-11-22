import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import { useState, useEffect } from "react";
import ListItem from '../components/ListItem'
import NewTaskInput from '../components/NewTaskInput'
import api from "../api";
import {useHistory} from "react-router-dom";

function Pagamento(){

    const [tasks, setTasks] = useState([]);
    const history = useHistory();

    function addNewTask(task) {
        const itensCopy = Array.from(tasks);
        itensCopy.push({id: tasks.length, value: task});
        setTasks(itensCopy);
    }

    function updateTask({target}, index) {
        const itensCopy = Array.from(tasks);
        itensCopy.splice(index, 1, { id: index, value: target.value });
        setTasks(itensCopy);
    }

    function deleteTask(index) {
        const itensCopy = Array.from(tasks);
        itensCopy.splice(index, 1);
        setTasks(itensCopy);
    }

    function pagar(e){
        e.preventDefault()
        api.post("/horarios/"+sessionStorage.getItem("idHorario"), {
            data_quadra: sessionStorage.getItem("dataQuadra"),
            reserva: "SIM",
            fkQuadra: sessionStorage.getItem("fkQuadra")


        }).then((resposta) => {
            if (resposta.status === 201) {
                alert("aperte enter para se redirecionar");
                history.push('/visualizacaoAtleta');
            }
        }).catch((erro) => {
            console.log(erro);
        })
    }

    return(
        <>
        <NavbarSecundario/>
 <div class="container-pagamento">
      
      <div class="box-content" >
          <div class="content-list" id="content-list"> 

            <h1>Lista de participantes</h1>
              <NewTaskInput onSubmit={addNewTask} />
              {tasks.map(({id, value}, index) => (
                  <ListItem
                      key={id}
                      value={value}
                      onChange={(event) => updateTask(event, index)}
                      onDelete={() => deleteTask(index)}
                  />
              ))}
          </div>
          <div className="Array-preview">
          </div>
      </div>

 <div class="content-pagamento" id="content-pagamento">
       
        <h3>Formas de pagamento</h3>


    <form onSubmit={pagar} name="formulario" class = "formPagamento">

        <label for="">
          Valor: <input type="text" id="valor" name="campo"/>
        </label>
        <label for="">
          Pagar: <input type="text"/>
        </label>
        <button className="avisin" type="submit">confirmar</button>
    </form>

    </div>
   
</div>
        </>
    );
}
export default Pagamento;