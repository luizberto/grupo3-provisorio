import React from "react";

function QuadrasAdm(props){
    return(
        <>

                <div class="quadra">
                    <h1>Quadra {props.key}</h1>
                    <ul>
                        <li>Nome da quadra:{props.nome}</li>
                        <li>Descrição da quadra:{props.descricao}</li>
                        <li>Limite de ocupação:{props.ocupacao}</li>
                    </ul>
                    <a href="">vizualizar&gt; </a>
                </div>


        </>
    );
}
export default QuadrasAdm;