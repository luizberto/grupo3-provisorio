import React from "react";
import Footer from "../components/Footer";
import { Link } from "react-router-dom";

import profile from '../home-template-css/img/profile.png'
import git from '../home-template-css/img/git.png'
import linkedn from '../home-template-css/img/linkedin.png'
import insta from '../home-template-css/img/insta.png'
import NavbarSecundario from "../components/NavbarSecundario.jsx";

function LoginAdm(){
    return(
        <>
        <NavbarSecundario/>
        <main>
        <div class="container">

            <div class="divCadastro">
                <div class="ofuscarBG">
                    <div class="infoCadastro">
                        <span>
                            <h4>NÃO TEM LOGIN?</h4>
                            <b>
                                Entre já para a sua melhor experiência no esporte.
                            </b>
                            <a href="./preCadastro.html">Cadastre-se</a>
                        </span>
                    </div>
                </div>
            </div>
            <div class="dadosLogin">
                <div class="borderTop">
                </div>
                <img src={profile} alt="" width="20%"/>
                <h3>Admnistrador</h3>
                <form class="inputsLogin">
                    <span>
                        <b>
                            Email
                            <input type="email"/>
                        </b>
                        <b>
                            Senha
                            <input type="password"/>
                            <i>Esqueceu a senha?</i>
                        </b>
                    </span>
                    <button>Login</button>
                </form>
                <div class="borderBottom">
                    <div class="redes">
                        <img src={git} alt=""/>
                        <img src={linkedn} alt=""/>
                        <img src={insta} alt=""/>
                    </div>
                    <div class="linkAtleta">
                        <h4>É atleta?</h4>
                       <Link to = "/loginAtleta"><a>Logar aqui!</a></Link> 
                    </div>
                </div>
            </div>
        </div>
    </main>
    <Footer/>
    </>
    );
}
export default LoginAdm;