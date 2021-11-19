import React, { useState } from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import { Link } from "react-router-dom";
import { useHistory } from 'react-router-dom';
import api from '../api';
import InputMask from 'react-input-mask';

function CadastroAtleta(props) {

    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const [campo3, setCampo3] = useState("");
    const [campo4, setCampo4] = useState("");
    const [campo5, setCampo5] = useState("");
    const history = useHistory();

    function atleta(e) {
        alert(campo5)
        e.preventDefault();

        api.post("/atletas", {
            nomeAtleta: campo1,
            email: campo2,
            senha: campo3,
            dataNasc: campo4,
            cpf: campo5,
            endereco:{
                cep:'09710180',
                logradouro:"rua doutor flaquer"
            }

        }).then((resposta) => {
            if (resposta.status === 201) {
                alert("aperte enter para se redirecionar");
                sessionStorage.setItem("email", campo2);
                sessionStorage.setItem("senha", campo3);
                sessionStorage.setItem("user", "adm")

                history.push('/loginAtleta');
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
                    <h4 class="tituloForm">Cadastro atleta</h4>
                    <form onSubmit={atleta} class="formClass">
                        <label for=""> {props.campoUm}nome
                            <input type="text" onChange={e => setCampo1(e.target.value)} />
                        </label>
                        <label for="">{props.campoDois}email
                            <input type="email" onChange={e => setCampo2(e.target.value)} />
                        </label>
                        <label for=""> {props.campoTres}senha
                            <input type="password" onChange={e => setCampo3(e.target.value)} />
                        </label>
                        <label for=""> {props.campoQuatro}data de nascimento
                            <input type="date" onChange={e => setCampo4(e.target.value)} />
                        </label>
                        <label for=""> {props.campoCinco}CPF
                            <InputMask type="text" mask='999.999.999-99' onChange={e => setCampo5(e.target.value)} />
                        </label>
                            <button class="buttonCadastrar" type="submit">Cadastrar</button>
                    </form>
                </div>
            </div>
            <Footer />
        </>
    );
}
export default CadastroAtleta;