import React from "react";
import logo from "../home-template-css/img/image 22.png";
import {Link} from "react-router-dom";

function Navbar({atleta, dnquadra, cadAtleta, cadAdm }){
    return(
        <>
        <header class="header">
        <a class="logo" href="/">
            <img src= {logo} height="40px" alt=""/>
            </a>

        <nav>
            <ul class="menu">
                <li>
                    <a href="">Login</a>
                    <ul className = "subMenu">
                       <Link to = {atleta}><li><a>Atleta</a></li></Link> 
                       <Link to = {dnquadra}><li><a> Dono de quadra</a></li></Link> 
                    </ul>
                </li>
                <li>
                    <a href="">Cadastro</a>
                    <ul className = "subMenu">
                        <Link to = {cadAtleta}><li> <a href="">Atleta</a></li> </Link>
                        <Link to = {cadAdm}><li> <a href=""> Dono de quadra</a></li></Link> 
                    </ul>
                </li>
            </ul>
        </nav>
    </header>
    </>
    );
}

export default Navbar;