import React from "react";
import logo from "../home-template-css/img/image 22.png"

function Footer(){
    return(
        <>
        <footer class="footer">
        <a class="logo" href="/"><img src={logo} height="40px" alt=""/></a>
        <ul class="menu">
            <li>Ajuda</li> 
            <li>Contato</li> 
            <li>FAQ</li>
            <li>Politica de Privacidade</li> 
        </ul>
    </footer>
    </>
    );
}
export default Footer;