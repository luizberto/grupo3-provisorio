import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";

function PerfilAdm(){
    return(
    <>
        <NavbarSecundario/>

        <div className = "titulo">
        <button className = "quadraBtn upload">Upload da lista de alugueis</button>    
        <h1>Suas quadras</h1>
        <button className = "quadraBtn download">Download da lista de alugueis</button>
        </div>
        



        <div class="containerQuadras">
            <div class="quadra">
                <h1>Quadra 1</h1>
                <ul>
                    <li>Rua: </li>
                    <li>Numero:</li>
                    <li>Limite de ocupação: </li>
                </ul>
                <a href="">Visualizar&gt; </a>
            </div>
            
        </div>   
        <div class="content-add-quadra">
            <div class="add">
                <button className = "adcQuadra"><p>+</p></button>
            </div>    
        </div>
             </>
    );
}
export default PerfilAdm;