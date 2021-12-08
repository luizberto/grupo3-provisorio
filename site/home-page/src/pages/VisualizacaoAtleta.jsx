import React from "react";
import DadosQuadra from "../componentsPagina/DadosQuadra";
import ButtonEdit from "../components/ButtonEdit";
import ImageQuadra from "../components/ImageQuadra";
import DadosHorario from "../componentsPagina/DadosHorario";
import NavbarSecundario from "../components/NavbarSecundario";
function VislualizacaoAtleta() {
    return (
        <>

            <NavbarSecundario voltar="/buscaQuadra" />
            <section class="containerDescricao">
                <ImageQuadra />

                <div class="containerBoxInfos">
                    <div class="box-info-quadra">

                        <span class="tituloCard">
                            <h1>Informações</h1>
                        </span>
                        <DadosQuadra />
                        
                    </div>

                    <div class="box-info-quadra">
                        <DadosHorario />
                        <ButtonEdit acao="alugar" path="/pagamento" />
                    </div>

                </div>
            </section>
        </>
    );
} export default VislualizacaoAtleta;