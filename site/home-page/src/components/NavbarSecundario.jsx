import React from "react";
import logo from "../home-template-css/img/image 22.png";
import { Link } from "react-router-dom";


function NavbarSecundario(){
    return(
  <>
   <header class="header">
        <a class="logo" href="/"><img src={logo} height="40px" alt=""/></a>

        <nav>
           <Link to = "/"><a>Home</a></Link>
        </nav>
    </header>
 </>
    );
}

export default NavbarSecundario;