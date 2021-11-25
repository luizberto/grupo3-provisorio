import React, {useState} from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import api from '../api';
import InputMask from 'react-input-mask';
import { Link } from "react-router-dom";
import { useHistory } from 'react-router-dom';

function CadastroAdm(props){
    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const [campo3, setCampo3] = useState("");
    const [campo4, setCampo4] = useState("");
    const [campo5, setCampo5] = useState("");
    const history = useHistory();

    function adm(e) {
        e.preventDefault();
        alert(campo4);
        api.post("/adm", {
          nomeDono: campo1,
          email: campo2,
          senha: campo3,
          dataNasc: campo4,
          cpf: campo5
        }).then((resposta) => {
          if (resposta.status === 201) {
            alert("aperte enter para se redirecionar");
            
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
                    <h4 class="tituloForm">Cadastro Administração</h4>
                    <form onSubmit={adm} class="formClass">
                        <label for=""> {props.campoUm}nome 
                            <input type="text" onChange={e => setCampo1(e.target.value)}/>
                        </label>
                        <label for="">{props.campoDois}email
                            <input type="email" onChange={e => setCampo2(e.target.value)}/>
                        </label>
                        <label for=""> {props.campoTres}senha
                            <input type="password" onChange={e => setCampo3(e.target.value)}/>
                        </label>
                        <label for=""> {props.campoQuatro}data de nascimento
                            <input type="date" onInput={e => setCampo4(e.target.value)}/>
                        </label>
                        <label for=""> {props.campoCinco}cpf
                            <InputMask type="text" mask='999.999.999-99'  onChange={e => setCampo5(e.target.value)}/>
                        </label>
                            <button class="buttonCadastrar" type="submit">Cadastrar</button>
                    </form>

                    
                </div>

            </div>
            <Footer />
        </>
    );
}
export default CadastroAdm;