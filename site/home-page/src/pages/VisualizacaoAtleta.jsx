import React from "react";
import DadosQuadra from "../componentsPagina/DadosQuadra";
import ButtonEdit from "../components/ButtonEdit";
import ImageQuadra from "../components/ImageQuadra";
import DadosHorario from "../componentsPagina/DadosHorario";
function VislualizacaoAtleta() {
    return (
        <section class="containerDescricao">
            <ImageQuadra />

            <div class="containerBoxInfos">
            <div class="box-info-quadra">

<span class="tituloCard">
    <h1>descrição</h1>
</span>
<DadosQuadra/>
</div>

<div class="box-info-quadra">
<DadosHorario/>
</div>

            


            </div>
        </section>
    );
} export default VislualizacaoAtleta;