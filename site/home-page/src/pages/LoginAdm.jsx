import React, { useState } from "react";
import Footer from "../components/Footer";
import { Link } from "react-router-dom";

import profile from '../home-template-css/img/profile.png'
import git from '../home-template-css/img/git.png'
import linkedn from '../home-template-css/img/linkedin.png'
import insta from '../home-template-css/img/insta.png'
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import FormLogin from "../componentsPagina/FormLogin";
import api from "../api";
import { useHistory } from 'react-router-dom';

function LoginAdm() {

    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const history = useHistory();
    function login(e) {
        e.preventDefault();
        api.post("/adm/login", {
            email: campo1,
            senha: campo2,
        }).then((resposta) => {
            if (resposta.status === 201) {
                alert("logado com sucesso");
                history.push('/perfilAdm');
            }
        }).catch((erro) => {
            alert("logado erro");
            console.log(erro);
        })
    }
    return (

        <>
            <NavbarSecundario />
            <div class="containerLogin">
                <div class="logar">
                    <h3>LOGIN Administrador</h3>
                    <form class="formsLogar" onSubmit={login} action="">
                        <label for="">
                            <p>Email</p>
                            <input type="text" onChange={e => setCampo1(e.target.value)} />

                        </label>

                        <label for="">
                            <p>Senha</p>
                            <input type="password" onChange={e => setCampo2(e.target.value)} />
                        </label>
                        <button type="submit" class="btnLogin">Login</button>
                    </form>



                    <h5>É atleta?</h5>
                    <Link to="/loginAtleta"><a>clique aqui</a></Link>
                </div>


                <div class="trocar">

                    <div class="inscrever">
                        <p>Se não tem cadastro no site, increva-se ja e amplie seu negócio</p>

                        <Link to="/cadastroAdm">
                            <button class="btnInscrever">Inscreva-se</button>
                        </Link>
                    </div>

                </div>
            </div>

            <Footer />

        </>
    );
}
export default LoginAdm;