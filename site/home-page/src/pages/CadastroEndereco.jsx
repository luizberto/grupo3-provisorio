import React, {useState} from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import api from '../api';

function CadastroEndereco(props){

        const [campo1, setCampo1] = useState("");
        const [campo2, setCampo2] = useState("");
        const [campo3, setCampo3] = useState("");
        const [campo4, setCampo4] = useState("");
        const [campo5, setCampo5] = useState("");
    
        function atleta(e) {
            e.preventDefault();
        
            
          }
    
    return(
        <>
        <NavbarSecundario/>
        <div class="container4">
        <div class="dadosCadastro">
        <h4 class="tituloForm">Endereço</h4>
            <form onSubmit={props.usuario} class="formClass">
                <label for=""> CEP
                    <input type="text" onChange={e => setCampo1(e.target.value)}/>
                </label>
                <label for=""> Logradouro
                    <input type="text" onChange={e => setCampo2(e.target.value)}/>
                </label>
                <label for=""> Bairro
                    <input type="text" onChange={e => setCampo3(e.target.value)}/>
                </label>
                <label for=""> Cidade
                    <input type="text" onChange={e => setCampo4(e.target.value)}/>
                </label>
                <label for=""> Estado
                    <input type="text" onChange={e => setCampo5(e.target.value)}/>
                </label>
                <button class="buttonCadastrar" type="submit">Cadastrar</button>
            </form>        
        </div>
    </div>  

        <Footer/>

                </>
    );
}

export default CadastroEndereco;