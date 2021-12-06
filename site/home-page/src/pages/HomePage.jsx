import React from "react";
import Banner from '../componentsPagina/Banner';
import Servicos from '../componentsPagina/Servicos';
import Entre from '../componentsPagina/Entre';
import ServicosDetalhe from "../componentsPagina/ServicosDetalhe";
import Footer from "../components/Footer";
function HomePage(){
    return(
        <>
        <Banner/>
        <Servicos/>     
        <Footer/>        
        </>
    );
}
export default HomePage;