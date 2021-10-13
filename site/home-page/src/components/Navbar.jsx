import React from "react";


function Navbar(){
    return(
        <>
        <header class="header">
        <a class="logo" href="/">
            <img src= "../img/image 22.png" height="40px" alt=""/>
            </a>

        <nav>
            <ul class="menu">
                <li><a href="../homePage/preLogin.html">Login</a></li>
                <li><a href="">Contato</a></li>
            </ul>
        </nav>
    </header>
    </>
    );
}

export default Navbar;