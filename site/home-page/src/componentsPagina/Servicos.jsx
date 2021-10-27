import React from "react";
import figUm from "../home-template-css/img/fluent_sport-soccer-16-regular.png";
import figDois from "../home-template-css/img/mdi_whistle-outline.png";
import figTres from "../home-template-css/img/Group.png"
import CompLinks from "../components/CompLinks";


function Servicos(){
    return(
        <>
      
            <section className="servicos">
                <h1>Explorar</h1>
                <div className = "container2">
                        <CompLinks image = {figUm} 
                        texto = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."/>

                        <CompLinks image = {figDois} 
                        texto = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."/>

                        <CompLinks image = {figTres} 
                        texto = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."/>
                </div>
            </section>

       

        </>
    );
}

export default Servicos;