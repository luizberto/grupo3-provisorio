import React from "react";
import Footer from "../components/Footer";
import { Link } from "react-router-dom";

import profile from '../home-template-css/img/profile.png'
import git from '../home-template-css/img/git.png'
import linkedn from '../home-template-css/img/linkedin.png'
import insta from '../home-template-css/img/insta.png'
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import FormLogin from "../componentsPagina/FormLogin";

function LoginAdm(){
    return(

        <>
        <NavbarSecundario/>
        <div class="containerLogin">
        <div class="logar">
            <h3>LOGIN Administrador</h3>
            <form class="formsLogar" action="">
                <label for="">
                   <p>Email</p> 
                    <input type="text"/>
                    
                </label>

                <label for="">
                  <p>Senha</p>
                    <input type="text"/>
                </label>
            </form>

            <button class="btnLogin">Login</button>

            <h5>É atleta?</h5>
                <Link to = "/loginAtleta"><a>clique aqui</a></Link>   
        </div>


        <div class="trocar">

            <div class="inscrever">
                <p>Se não tem cadastro no site, increva-se ja e amplie seu negócio</p>

              <Link to = "/cadastroAdm">
                  <button class="btnInscrever">Inscreva-se</button>  
                  </Link>    
            </div>
           
        </div>
    </div>

    <Footer/>

    </>
    );
}
export default LoginAdm;