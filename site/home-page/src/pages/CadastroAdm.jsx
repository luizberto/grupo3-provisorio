import React from "react";
import Forms from "../componentsPagina/Forms";

function CadastroAdm(){
    return(
        <Forms titulo = "Cadastramento de Administrador"
        subTitulo = "Dados do administrador"
        campoUm = "Nome"
        campoDois = "Email"
        campoTres = "Senha"
        campoQuatro = "Data de nascimento"
        campoCinco = "CPF"
        
        />
    );
}
export default CadastroAdm;