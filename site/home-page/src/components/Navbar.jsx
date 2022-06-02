import React, { useState } from "react";
import logo from "../home-template-css/App/img-novo/SPORTFY.png";
import { Link } from "react-router-dom";
import { DropdownButton, Dropdown, Stack, Button } from "react-bootstrap";



function Navbar({dnquadra, cadAdm}) {

    return (
        <>
            <header className="n-header">
                <div class="logo">
                    <img src={logo}/>
                </div>

                <ul className="n-nav">
                       
                 <a href={dnquadra} className = "n-link">
                      <li className="n-li">Login</li>   
                 </a>       
                 
                 <a href={cadAdm} className = "n-link">
                   <li className="n-li">Cadastro</li>
                 </a>
                      
                </ul>
            </header>
        </>
    );
}

export default Navbar;