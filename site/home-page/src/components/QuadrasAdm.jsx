import React from "react";

function QuadrasAdm(props){
    return(
        <>
            <div class="containerQuadras">
                <div class="quadra">
                    <h1>Quadra 1</h1>
                    <ul>
                        <li>Nome da quadra:{props.nome}</li>
                        <li>Descrição da quadra:{props.descricao}</li>
                        <li>Limite de ocupação:{props.ocupacao}</li>
                    </ul>
                    <a href="">Visualizar&gt; </a>
                </div>
            </div>    

        </>
    );
}
export default QuadrasAdm;