import React, {useState} from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import api from '../api';
import {useHistory} from "react-router-dom";


function CadastroQuadras(props){
    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const [campo3, setCampo3] = useState("");
    const [campo4, setCampo4] = useState("");
    const [campo5, setCampo5] = useState("");
    const history = useHistory();
    function quadra(e) {
        e.preventDefault();
    
        api.post("/quadras", {
            nomeQuadra: campo1,
            descQuadra: campo2,
            limitePessoas: campo3,
            classificacaoQuadra: campo4,
            complemento: campo5,
         
        }).then((resposta) => {
          if (resposta.status === 201) {
            alert("aperte enter para se redirecionar");
            history.push('/atletas');
          }
        }).catch((erro) => {
          console.log(erro);
        })
      }
      
    return (
        <>
            <NavbarSecundario />
            <div class="container4">
                <div class="dadosCadastro">
                    <h4 class="tituloForm">{props.titulo}</h4>
                    <form onSubmit={quadra} class="formClass">
                        <label for=""> {props.campoUm}nome
                            <input type="text" onChange={e => setCampo1(e.target.value)}/>
                        </label>
                        <label for="">{props.campoDois}descrição
                            <input type="text" onChange={e => setCampo2(e.target.value)}/>
                        </label>
                        <label for=""> {props.campoTres}limite pessoas
                            <input type="text" onChange={e => setCampo3(e.target.value)}/>
                        </label>
                        <label for=""> {props.campoQuatro}classificacao
                            <input type="text" onChange={e => setCampo4(e.target.value)}/>
                        </label>
                        <label for=""> {props.campoCinco}complemento
                            <input type="text" onChange={e => setCampo5(e.target.value)}/>
                        </label>
                        <button class="buttonCadastrar" type="submit">Cadastrar</button>
                    </form>

                    
                </div>

            </div>
            <Footer />
        </>
    );
}
export default CadastroQuadras;