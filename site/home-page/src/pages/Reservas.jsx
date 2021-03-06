import React from "react";
import BoxHorarioReserva from "../components/BoxHorarioReserva";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario";

function Reservas() {
    return (
        <>
            <NavbarSecundario voltar = "/visualizacaoAtleta"/>
            <div class="container6">
                <h1 class="titulo-horario">Horários</h1>
                <div class="box-horario">
                    <BoxHorarioReserva/>
                </div>
            </div>

            <Footer/>
        </>
    );
}

export default Reservas;