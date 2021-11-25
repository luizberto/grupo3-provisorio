import React from "react";
import logo from "../home-template-css/img/image 22.png";
import { Link } from "react-router-dom";


function NavbarSecundario(props){
    return(
  <>
   <header class="header">
        <a class="logo" href="/"><img src={logo} height="40px" alt=""/></a>

        <nav>
           <Link to = "/"><a>Home</a></Link>
           <Link to = {props.voltar}><a>{props.anterior}</a></Link>
        </nav>
    </header>
 </>
    );
}

export default NavbarSecundario;