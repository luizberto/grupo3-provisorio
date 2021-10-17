import React from "react";
import Forms from "../componentsPagina/Forms";

function CadastroAtleta(){
    return(
        <>
            <Forms titulo = "Cadastramento de atleta" 
            subTitulo = "dados do atleta"
            campoUm = "Nome"
            campoDois = "Email"
            campoTres = "Senha"
            campoQuatro = "Data de nascimento"
            campoCinco = "CPF"
            />
           
        </>
    );
}
export default CadastroAtleta;