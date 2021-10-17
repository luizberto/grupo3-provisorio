import React from "react";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import logo from "../home-template-css/img/logo.png"


function PreEntradas({texto}){
    return(
        <>

        <Navbar/>
             <main>
        <div class="background">
            <div class="preLogin">
                <div class="border">
                    <div class="logo">
                        <img src={logo} alt="LOGO"/>
                    </div>
                    <div class="conteudoPrincipal">
                        <h3>Qual tipo de {texto} você gostaria de fazer?</h3>
                        <span>
                            <a href="./loginAtleta.html">Atleta</a>
                            <a href="./loginAdm.html">Admnistrador</a>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <Footer/>
        </>
    );
}
export default PreEntradas;