import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import QuadrasAdm from "../components/QuadrasAdm";
import { Link } from "react-router-dom";
import api from "../api";
import { useEffect, useState } from "react";

function PerfilAdm() {
  const [quadra, setQuadra] = useState([]);

  useEffect(() => {
    async function pegaDados() {
      const resposta = await api.get("/quadras");
      if(resposta.status === 200){
        setQuadra(resposta.data);
      }
      
      console.log(resposta.data);
    }
    pegaDados();
  }, []);

  return (
    <>
      <NavbarSecundario />

      <div className="titulo">
        <button className="quadraBtn upload">
          Upload da lista de alugueis
        </button>
        <h1>Suas quadras</h1>
        <button className="quadraBtn download">
          Download da lista de alugueis
        </button>
      </div>
      <div className="containerQuadras">
        {quadra.map((quadra) => (
          <QuadrasAdm
            key={quadra.id_quadra}
            nome={quadra.nomeQuadra}
            descricao={quadra.descQuadra}
            ocupacao={quadra.limitePessoas}
          />
        ))}
      </div>
      <div class="content-add-quadra">
        <div class="add">
          <Link to="/cadastroQuadras">
            <button className="adcQuadra">
              <p>+</p>
            </button>
          </Link>
        </div>
      </div>
    </>
  );
}
export default PerfilAdm;
