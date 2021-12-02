import React from "react";
import img from "../home-template-css/App/img/camp-nou-5798015_640 1 (1).png";
import { Link, useHistory } from "react-router-dom";
import {Button, Card, Offcanvas} from "react-bootstrap";
import {useState} from "react";

function CardQuadras(props) {

  const history = useHistory();
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);


  function quadra(e) {
    if (props.usuario == "atleta") {

      sessionStorage.setItem('idQuadra', props.id)
      sessionStorage.setItem('descricao', props.descricao)
      sessionStorage.setItem('nome', props.nome)
      sessionStorage.setItem('limitePessoas', props.limite)
      history.push('/visualizacaoAtleta');
    }else{
      setShow(true);
    }
  }
  return (
    <>
      <Offcanvas show={show} onHide={handleClose}>
        <Offcanvas.Header closeButton>
          <Offcanvas.Title>{props.nome}</Offcanvas.Title>
        </Offcanvas.Header>
        <Offcanvas.Body>
          {props.limite}
        </Offcanvas.Body>

      </Offcanvas>
      <Card border="success" style={{ width: '18rem', color:"black" }}>
        <Card.Img variant="top" src={"http://localhost:8080/quadras/foto/"+props.id} />
        <Card.Body>
          <Card.Title>{props.nome}</Card.Title>
          <Card.Text style={{ color:"black" }}>
            Limite de pessoas: {props.limite}<br></br>
            Descrição:{props.complemento}
          </Card.Text>
          <Button variant="primary" onClick={quadra}>Alugar</Button>
        </Card.Body>

      </Card>
    </>
  );
}
export default CardQuadras;
