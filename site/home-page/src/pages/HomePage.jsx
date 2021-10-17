import React from "react";
import Banner from '../componentsPagina/Banner';
import Servicos from '../componentsPagina/Servicos';
import Entre from '../componentsPagina/Entre';
import ServicosDetalhe from "../componentsPagina/ServicosDetalhe";
import bolinha from '../home-template-css/img/fluent_sport-soccer-16-regular.png';
import camisa from '../home-template-css/img/Group.png'
import apito from '../home-template-css/img/mdi_whistle-outline.png'

function HomePage(){
    return(
        <>
        <Banner/>
        <Servicos/>
        <ServicosDetalhe image = {bolinha}/>
        <ServicosDetalhe image = {apito}/>
        <ServicosDetalhe image = {camisa}/>
        <Entre/>
        </>
    );
}
export default HomePage;