import React from "react";
import Banner from '../componentsPagina/Banner';
import Servicos from '../componentsPagina/Servicos';
import Footer from "../components/Footer";

function HomePage() {
    return (
        <>
            <Banner/>
            <Servicos/>
            <Footer/>
        </>
    );
}

export default HomePage;