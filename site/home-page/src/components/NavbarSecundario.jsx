import React from "react";
import logo from "../home-template-css/img/image 22.png";
import { Link } from "react-router-dom";
import {Button} from 'react-bootstrap'


function NavbarSecundario(props){
    return(
  <>
   <header class="header">
        <a class="logo" href="/"><img src={logo} height="40px" alt=""/></a>
 
        <nav>
        <Link to = "/"><Button variant="success">Home</Button>{' '}</Link>
           <Link to = {props.voltar}>
              <Button variant = "success">
              voltar
              </Button>
              </Link>
        </nav>
    </header>
 </>
    );
}

export default NavbarSecundario;