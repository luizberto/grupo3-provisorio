import React, {useState} from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import api from '../api';

function CadastroAdm(props){
    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const [campo3, setCampo3] = useState("");
    const [campo4, setCampo4] = useState("");
    const [campo5, setCampo5] = useState("");

    function adm(e) {
        e.preventDefault();
    
        api.post("/adm", {
          cpf: campo5,
          nomeAdm: campo1,
          email: campo2,
          senha: campo3,
          dataNasc: campo4,
         
        }).then((resposta) => {
          if (resposta.status === 201) {
            alert("aperte enter para se redirecionar");
            // history.push('/atletas');
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
                    <form onSubmit={props.usuario} class="formClass">
                    <label for=""> CPF
                            <input type="text" onChange={e => setCampo1(e.target.value)}/>
                        </label>
                        <label for=""> email
                            <input type="text" onChange={e => setCampo2(e.target.value)}/>
                        </label>
                        <label for=""> senha
                            <input type="text" onChange={e => setCampo3(e.target.value)}/>
                        </label>
                        <label for=""> data de Nascimento
                            <input type="text" onChange={e => setCampo4(e.target.value)}/>
                        </label>
                        <label for=""> endereço
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
export default CadastroAdm;