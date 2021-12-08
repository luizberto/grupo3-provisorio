import React, {useState} from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import {useForm} from "react-hook-form";
import api from "../api";

function CadastroEndereco(props) {

    const {register, handleSubmit, watch, formState: {errors}} = useForm();
    const onSubmit = data => console.log(data);

    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const [campo3, setCampo3] = useState("");
    const [campo4, setCampo4] = useState("");
    const [campo5, setCampo5] = useState("");

    function endereco(e) {
        api.post("/enderecos/" + sessionStorage.getItem("idQuadra"),
          {
                cep: campo1,
                logradouro: campo2,
                bairro: campo3,
                cidade: campo4,
                estado: campo5
          })
            .then((resposta) => {
                if (resposta.status === 201) {
                    alert("endereco cadastrado");
                    //history.push('/cadastroEndereco');

                }
            }).catch((erro) => {
            console.log(erro);
        })


    }

    return (
        <>
            <NavbarSecundario voltar="/cadastroQuadras"/>
            <div class="container4">
                <div class="dadosCadastro">
                    <h4 class="tituloForm">Endereço</h4>
                    <form onSubmit={endereco} class="formClass">
                        <label for=""> CEP
                            <input type="text" onChange={e => setCampo1(e.target.value)}/>
                        </label>
                        <label for=""> Rua
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