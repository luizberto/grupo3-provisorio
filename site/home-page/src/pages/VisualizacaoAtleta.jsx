import React from "react";
import DadosQuadra from "../componentsPagina/DadosQuadra";
import ButtonEdit from "../components/ButtonEdit";
import ImageQuadra from "../components/ImageQuadra";
import DadosHorario from "../componentsPagina/DadosHorario";
import Navbar from "../components/Navbar";
import NavbarSecundario from "../components/NavbarSecundario";
function VislualizacaoAtleta() {
    return (
        <>
        <NavbarSecundario />
        <section class="containerDescricao">
            <ImageQuadra />

            <div class="containerBoxInfos">
            <div class="box-info-quadra">

<span class="tituloCard">
    <h1>Descrição</h1>
</span>
<DadosQuadra/>
<ButtonEdit acao = "alugar" path = "/pagamento" />
</div>

<div class="box-info-quadra">
<DadosHorario/>
</div>

            </div>
        </section>
        </>
    );
} export default VislualizacaoAtleta;