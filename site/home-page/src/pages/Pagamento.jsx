import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import { useState } from "react";
import Footer from "../components/Footer";
import { Spinner } from "react-bootstrap";
import {useHistory} from "react-router-dom";
import api from "../api";

function Pagamento() {
  const history = useHistory();
  const [formaPagamento, setFormaPagamento] = useState("");
  const [qtdJogadores, setQtdJogadores] = useState("");

  function ouvir() {
    api.post("/reservas", {
      dataQuadra: sessionStorage.getItem("dataHorario"),
      quadra: sessionStorage.getItem("idQuadra"),
      qtdAtletas: qtdJogadores,
      horario: sessionStorage.getItem("idHorario"),
      atleta: sessionStorage.getItem("idAtleta"),
      horaPartida: sessionStorage.getItem("dataHorario")

    }).then((resposta) => {
      if (resposta.status === 201) {
        alert("aperte enter para se redirecionar");
        history.push('/cadastroEndereco');
      }
    }).catch((erro) => {
      console.log(erro);
    })
    alert("Reserva concluida")
    history.push("/reservas")
  }


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
              <input type="number" min="6" max="99"  class="input-jogadores" onChange={e => setQtdJogadores(e.target.value)}/>
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




