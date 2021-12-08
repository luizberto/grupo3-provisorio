import React from "react";
import BoxHorarioReserva from "../components/BoxHorarioReserva";
import NavbarSecundario from "../components/NavbarSecundario";
import Footer from "../components/Footer";


function Favoritos(){
    return(
        <>
        <NavbarSecundario voltar = "/visualizacaoAtleta"/>
        <div class="container6">
            <h1 class="titulo-horario">Horarios</h1>
            <div class="box-horario">
                <BoxHorarioReserva/>
            </div>
        </div>

        <Footer/>
    </>
    );
}
export default Favoritos;