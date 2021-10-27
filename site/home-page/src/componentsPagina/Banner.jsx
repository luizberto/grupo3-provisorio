import React from "react";
import Navbar from "../components/Navbar";

function Banner(){
    return(
        <>

        <Navbar atleta = "/loginAtleta" dnquadra = "/loginAdm" cadAtleta = "/cadastroAtleta" cadAdm = "/cadastroAdm"/>
        <section class="banner">

<div class="container">
    <div class="titulo">
        <h1>
    Encontre quadras para praticar seus esportes favoritos.
</h1>
    </div>
</div>
</section>
    </>
    );
}

export default Banner;