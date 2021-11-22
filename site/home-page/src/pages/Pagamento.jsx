import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import { useState, useEffect } from "react";

function Pagamento(){

    
    return(
        <>
        <NavbarSecundario/>
 <div class="container-pagamento">
      
      <div class="box-content" >
          <div class="content-list" id="content-list"> 

            <h1>Lista de participantes</h1>
            <ul>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
              <li>
                <input type="text"/>
              </li>
             
            </ul>
          </div>
      </div>

 <div class="content-pagamento" id="content-pagamento">
       
        <h3>Formas de pagamento</h3>


    <form action="" name="formulario" class = "formPagamento">

        <label for="">
          Valor: <input type="text" id="valor" name="campo"/>
        </label>
        <label for="">
          Pagar: <input type="text"/>
        </label>
       
    </form>
       <button class="avisin" >confirmar</button>
    </div>
   
</div>
        </>
    );
}
export default Pagamento;