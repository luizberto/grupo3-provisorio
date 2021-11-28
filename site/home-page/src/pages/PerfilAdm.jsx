import React from "react";
import NavbarSecundario from "../components/NavbarSecundario";
import QuadrasAdm from "../components/QuadrasAdm";
import { Link } from "react-router-dom";
import api from "../api";
import { useEffect, useState } from "react";
import  { Card, Button } from "react-bootstrap";

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
          Upload lista
        </button>
        <h1>Suas quadras</h1>
        <button className="quadraBtn download">
          Download lista
        </button>
      </div>
      <div className="containerQuadras">
        {quadra.map((quadra) => (
          //<QuadrasAdm
           // key={quadra.id_quadra}
            //nome={quadra.nomeQuadra}
            //descricao={quadra.descQuadra}
            //ocupacao={quadra.limitePessoas}
          ///>

            <Card style={{ width: '18rem', color:"black" }}>
                <Card.Img variant="top" src={"http://localhost:8080/quadras/foto/"+quadra.idQuadra} />
                <Card.Body>
                    <Card.Title>{quadra.nomeQuadra}</Card.Title>
                    <Card.Text style={{ color:"black" }}>
                        Limite de pessoas: {quadra.limitePessoas}<br></br>
                        Descrição:{quadra.complemento}
                    </Card.Text>
                    <Button variant="primary">Detalhe</Button>
                </Card.Body>
            </Card>
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
