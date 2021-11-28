import React from "react";
import Navbar from "../components/Navbar";
import {Button} from "react-bootstrap";
function Banner(){
    return(
        <>

        <Navbar atleta = "/loginAtleta" dnquadra = "/loginAdm" cadAtleta = "/cadastroAtleta" cadAdm = "/cadastroAdm"/>
        <section class="banner">

    <div class="container">
        <div class="tituloBanner">
            <h1>
            Encontre quadras para praticar seus esportes favoritos.
            </h1>
            <Button variant="dark">Conhecer</Button>{' '}
        </div>
    </div>
</section>
    </>
    );
}

export default Banner;