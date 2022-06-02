import React from "react";
import Navbar from "../components/Navbar";


function Banner(){
    return(
        <>

        <Navbar 
         dnquadra = "/loginAdm" 
         cadAdm = "/cadastroAdm"
         />

<section class="n-banner">
        <h1 class="slogan">
            SPORT.FY PARA ADMINISTRADOR
        </h1>

        <h5 class="subtitulo">
            Organize e monitore suas quadras e se junte ao maior app de aproimação de clientes ao seu negócio
        </h5>

</section>

    </>
    );
}

export default Banner;