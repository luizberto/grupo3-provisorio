import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import { useState, useEffect } from "react";
import ListItem from '../components/ListItem'
import NewTaskInput from '../components/NewTaskInput'
import api from "../api";
import {useHistory} from "react-router-dom";
import Footer from "../components/Footer";

function Pagamento(){

    const [formaPagamento, setFormaPagamento] = useState("");

    function contextPagamento() {
        var formaPagChecked = document.getElementsByName("FormaPagamento");
        for (var i = 0; i < formaPagChecked.length; i++) {
          if (formaPagChecked[i].checked) {
            if (formaPagChecked[i].value === "pix") {
              setFormaPagamento("pix");
            } else if (formaPagChecked[i].value === "presencial") {
              setFormaPagamento("presencial");
            } 
          }
        } 
      }

   return(
       <>
       <NavbarSecundario/>
            <div class="container-pagamento">
<div class="dados-pagamento">

    <h1>Pagamento</h1>
    <div class="tela-pagamento">
        <label for="">Selecione quantas <br/> pessoas vão:
            <input type="text"/> 
        </label>

        <label for="">Valor:
            <input type="text"/>
        </label>
    <div class="parte-pagamento">
        <label for="">
           <h6>pix</h6> 
            <input type="radio" name="FormaPagamento" onClick = {contextPagamento} value="pix"/>
        </label>
        <label for="">
           <h6>Presencial</h6> 
            <input type="radio" name="FormaPagamento" onClick = {contextPagamento} value="presencial"/>
        </label>
    </div>
    </div>

    { formaPagamento === 'pix' ?
                    <div className="pagamento-removivel">
                      <h6>Chave Pix para o pagamento: <br/>A5YYYTWW28882JJJ27712</h6>
                      <p>Chave Aleatória : iPet</p>
                      <img src="" alt="" />
                      <p>Valor da compra: R$ 120,00</p>
                      <button className = "buttonStyle">Pagar</button>
                    </div>
  : formaPagamento === 'presencial' ?
                     <div className="pagamento-removivel">
                      <h3>Pagamento Dinheiro</h3>
                      <p>Valor da compra: R$ 120,00</p>
                      <label htmlFor="">Troco para: </label>
                      <input type="text" placeholder="Troco para R$"/>
                      <button className = "buttonStyle">Pagar</button>
                    </div>
                    :
                    <div className="pagamento-removivel">
                      <h6>Escolha uma forma de pagamento acima</h6>
                    </div>

    }
    

   
    
</div>
</div>
<Footer/>
       </>
   );
   }
    
export default Pagamento;




