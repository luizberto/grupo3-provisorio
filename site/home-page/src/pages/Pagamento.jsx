import React from "react";
import Navbar from "../components/Navbar";
import NavbarSecundario from "../components/NavbarSecundario";
import { useState } from "react";

function Pagamento(){

    const[chekced, setchecked] = useState(false)
    let pix = document.getElementById("pix")
    let credito = document.getElementById("credito")
    let presencial = document.getElementById("presencial")

    function apaga(){
        setchecked(!chekced)
    }

    const chekcedClass = chekced ? 'checked':'';

  

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

    <form action="" name="formulario">
        <div class="cartoes">

        <span className = "check" onClick = {apaga} >
        <label id="presencial">Presencial</label>  
        </span>

        <span className = "check" onClick = {apaga} >
          <label id="credito">Credito</label>  
        </span>

        <span className = "check2" onClick = {apaga}>
        <label id="pix"> Pix</label>
         </span>

        <div>
            
 </div>
        </div>
        <label for="">
          Valor: <input type="text" id="campo" name="campo"/>
        </label>
      
        <label for="">
          Pagar: <input type="text"/>
        </label>

       
    </form>
       <button onclick="chamarAviso()" class="avisin" >confirmar</button>
    </div>
   
</div>
        </>
    );
}
export default Pagamento;