import React from "react";
import logo from "../home-template-css/img/image 22.png";

function Navbar(){
    return(
        <>
        <header class="header">
        <a class="logo" href="/">
            <img src= {logo} height="40px" alt=""/>
            </a>

        <nav>
            <ul class="menu">
                <li><a href="../homePage/preLogin.html">Login</a></li>
                <li><a href="">Cadastro</a></li>
            </ul>
        </nav>
    </header>
    </>
    );
}

export default Navbar;