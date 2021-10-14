import React from "react";
import logo from "../home-template-css/img/image 22.png"

function Footer(){
    return(
        <>
        <footer class="footer">
        <a class="logo" href="/"><img src={logo} height="40px" alt=""/></a>
        <ul class="menu">
            <a href=""><li>Ajuda</li></a> 
            <a href=""><li>Contato</li></a> 
            <a href="">  <li>FAQ</li></a>
            <a href=""><li>Politica de Privacidade</li></a> 
        </ul>
    </footer>
    </>
    );
}
export default Footer;