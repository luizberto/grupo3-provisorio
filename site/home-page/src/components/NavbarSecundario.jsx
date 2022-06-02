import React from "react";
import logo from "../home-template-css/App/img-novo/SPORTFY.png";
import { Link } from "react-router-dom";
import { Button } from 'react-bootstrap'


function NavbarSecundario(props) {
   return (
      <>
         <header class="n-header">
            <div class="logo" href="/">
               <img src={logo} alt="" />
            </div>

            <ul className="n-nav">
               <Link to="/">
                  <Button variant="success">Home</Button>{' '}
               </Link>
            </ul>
         </header>
      </>
   );
}

export default NavbarSecundario;