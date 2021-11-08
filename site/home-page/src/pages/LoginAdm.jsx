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
           <FormLogin titulo = "ADM" 
           questao = "É atleta?" 
           texto = "Inscreva-se aqui para ampliar seu negócio" 
           path = "/loginAtleta"
           pathCadastro = "/cadastroAdm"/> 
          
    <Footer/>
    </>
    );
}
export default LoginAdm;