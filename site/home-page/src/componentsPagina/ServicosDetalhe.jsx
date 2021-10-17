import React from "react";
import bolinha from '../home-template-css/img/fluent_sport-soccer-16-regular.png'

function ServicosDetalhe({image, texto, back}){
    return(
        <>
              <section class="descServicos">
            <div class="container2">
                <div class="boxImage">
                    <img src={image} width="170px" alt=""/>
                </div>
                <div class="boxTexto">
                    <p>
                        It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                    </p>
                </div>
            </div> 
        </section>
        </>
    );
}
export default ServicosDetalhe;