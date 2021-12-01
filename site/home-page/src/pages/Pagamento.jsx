import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import { useState, useEffect } from "react";
import ListItem from '../components/ListItem'
import NewTaskInput from '../components/NewTaskInput'
import api from "../api";
import { useHistory } from "react-router-dom";
import Footer from "../components/Footer";

function Pagamento() {

  function ouvir() {
    alert("pagamento realizado")
  }

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

  return (
    <>
      <NavbarSecundario />
      <div class="container-pagamento">
        <div class="dados-pagamento">

          <h1>Pagamento</h1>
          <div class="tela-pagamento">
            <label for="">Selecione quantas <br /> pessoas vão:
              <input type="text" />
            </label>

            <label for="">Valor:
            </label>
            <div class="parte-pagamento">
              <label for="">
                <h6>pix</h6>
                <input type="radio" name="FormaPagamento" onClick={contextPagamento} value="pix" />
              </label>
              <label for="">
                <h6>Presencial</h6>
                <input type="radio" name="FormaPagamento" onClick={contextPagamento} value="presencial" />
              </label>
            </div>
          </div>

          {formaPagamento === 'pix' ?
            <div className="pagamento-removivel">
              <h4>Tipo de Chave Pix: email</h4>
              <p>Chave de pagamento: teste@teste.com </p>
              <p>Valor da compra: R$ 120,00</p>
              <button onClick={ouvir} className="buttonStyle">Pagar</button>
            </div>
            : formaPagamento === 'presencial' ?
              <div className="pagamento-removivel">
                <h5>Pagamento Dinheiro</h5>
                <p>Valor da compra:</p>
                <button onClick={ouvir} className="buttonStyle">Finalizar</button>
              </div>
              :
              <div className="pagamento-removivel">
                <h6>Escolha uma forma de pagamento acima</h6>
              </div>

          }

        </div>
      </div>
      <Footer />
    </>
  );
}

export default Pagamento;




