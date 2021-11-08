import React from "react";
import profile from '../home-template-css/img/profile.png'
import git from '../home-template-css/img/git.png'
import insta from '../home-template-css/img/insta.png'
import linkedn from '../home-template-css/img/linkedin.png'
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import ButtonLoginDQ from "../components/ButtonLoginDQ";
import FormLogin from "../componentsPagina/FormLogin";

function LoginAtleta(){
    return(
        <>
        <NavbarSecundario/>
        <FormLogin titulo = "ATLETA" 
        questao = "É dono de quadra?" 
        texto = "Inscreva-se aqui para participar da maior rede de atletas do Brasil" 
        path = "/loginAdm"
        pathCadastro = "/cadastroAtleta"/> 
    <Footer/>
        </>
    );
}

export default LoginAtleta;