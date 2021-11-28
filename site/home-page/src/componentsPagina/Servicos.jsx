import React from "react";
import figUm from "../home-template-css/img/camisetia.png";
import figDois from "../home-template-css/img/Vector.png";
import figTres from "../home-template-css/img/apitin.png";
import CompLinks from "../components/CompLinks";


function Servicos(){
    return(
        <>  

            <section className="servicos">
                <h1>Explorar</h1>
                <div className = "container2">
                        <CompLinks image = {figUm} 
                        texto = "Se reuna com os amigos e jogue nas quadras próximas. Clique aqui para inscrever-se "
                        link = "/cadastroAleta"/>

                        <CompLinks image = {figDois} 
                        texto = "Caso tenha uma quadra, expanda o nome dela e impulsione seu negócio. Clique aqui para inscrever-se"
                        link = "/cadastroAdm"/>

                        <CompLinks image = {figTres} 
                        texto = "Conheça mais vantagens, explore tudo que a sport.fy tem a te oferecer"/>
                </div>
            </section>

       

        </>
    );
}

export default Servicos;