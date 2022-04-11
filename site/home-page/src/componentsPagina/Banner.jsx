import React from "react";
import Navbar from "../components/Navbar";
import {Button} from "react-bootstrap";
import Servicos from "./Servicos";
import Footer from "../components/Footer";
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
        </div>
    </div>
</section>

    </>
    );
}

export default Banner;