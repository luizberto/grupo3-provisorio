import React from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
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