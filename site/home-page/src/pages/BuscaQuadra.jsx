import React, { useEffect, useState } from "react";
import CardQuadras from "../components/CardQuadras";
import api from "../api";
import NavbarSecundario from "../components/NavbarSecundario";
import Footer from "../components/Footer";

function BuscaQuadra() {
  const [quadra, setQuadra] = useState([]);

  useEffect(() => {
    async function pegaDados() {
      const resposta = await api.get("/quadras");
      if (resposta.status === 200) {
        setQuadra(resposta.data);
      }

      console.log(resposta.data);
    }
    pegaDados();
  }, []);
  return (
    <>
      <NavbarSecundario />
      <section>
        <div class="containeCard">
          <div class="box-menu">
            <select name="select">
              <option value="valor1">Ordenar</option>
              <option value="valor2">Distancia</option>
              <option value="valor3">Favoritos</option>
            </select>

            <input type="text" />
          </div>

          {quadra.map((quadra) => (
            <CardQuadras
              id={quadra.id}
              nome={quadra.nomeQuadra}
              descricao={quadra.descQuadra}
              limite={quadra.limitePessoas}
            />
          ))}
        </div>
      </section>
      <Footer />
    </>
  );
}
export default BuscaQuadra;
