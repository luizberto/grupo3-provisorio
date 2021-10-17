import React from "react";
import Forms from "../componentsPagina/Forms";

function CadastroQuadras(){
    return(
        <Forms titulo = "Cadastramento de Quadra" 
        subTitulo = "dados da quadra"
        campoUm = "Cep"
        campoDois = "Logradouro"
        campoTres = "Bairro"
        campoQuatro = "Cidade"
        campoCinco = "Estado"
        
        />
    );
}
export default CadastroQuadras;