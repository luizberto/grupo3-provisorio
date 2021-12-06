import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import { useState } from "react";
import Footer from "../components/Footer";
import { Spinner } from "react-bootstrap";

function Pagamento() {

  function ouvir() {
    alert("Reserva concluida")
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
      <NavbarSecundario voltar="/visualizacaoAtleta" />
      <div class="container-pagamento">
        <div class="dados-pagamento">

          <h1>Pagamento</h1>
          <div class="tela-pagamento">
            <label for="">Participantes
              <br />
              <input type="number" min="6" max="99"  class="input-jogadores"/>
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
              <h4></h4>
              <p>Chave de Pix: teste@teste.com </p>
              <p>R$: R$ 120,00</p>
              <button onClick={ouvir} className="buttonStyle">Finalizar</button>
            </div>
            : formaPagamento === 'presencial' ?
              <div className="pagamento-removivel">
                <h5>Dinheiro</h5>
                <p>R$:</p>
                <button onClick={ouvir} className="buttonStyle">Finalizar</button>
              </div>
              :
              <div className="pagamento-removivel">

              </div>

          }

        </div>
      </div>
      <Footer />
    </>
  );
}

export default Pagamento;




