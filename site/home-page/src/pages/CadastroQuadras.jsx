import React, {useState} from "react";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar.jsx";
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.min.css';
import api from '../api';
import {useHistory} from "react-router-dom";
import NavbarSecundario from "../components/NavbarSecundario";


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
            //alert("aperte enter para se redirecionar");
            toast.success('Cadastrado com sucesso!');
<<<<<<< Updated upstream
            history.push('/perfilAdm');
        }
=======
            history.push('/perfilAdm')
          }
>>>>>>> Stashed changes
        }).catch((erro) => {
            toast.error('campos invalidos ou vazios');
            //console.log(erro);
        })
      }
      
    return (
        <>
            <NavbarSecundario home = "/perfilAdm"/>
            <ToastContainer
                position="top-left"
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
            />
            <div class="container4">
                <div class="dadosCadastro">
                    <h4 class="tituloForm">Cadastro Quadra</h4>
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
                        <label for=""> {props.campoQuatro}Valor aluguel
                            <input type="text" onChange={e => setCampo4(e.target.value)}/>
                        </label>
                        <label for=""> {props.campoCinco}materiais esportivos
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