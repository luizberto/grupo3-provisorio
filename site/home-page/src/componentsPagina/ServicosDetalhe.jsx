import React from "react";
import CompServicos from "../components/CompServicos";
import bolinha from '../home-template-css/img/fluent_sport-soccer-16-regular.png'
import imagen from '../home-template-css/img/camisaFundo.png'
import imagen2 from '../home-template-css/img/fut.jpg'
import imagen3 from '../home-template-css/img/image 21.png'
import imagen4 from '../home-template-css/img/gramadinho.png'
import {Carousel } from "react-bootstrap";

function ServicosDetalhe({image, texto}){
    return(
        <>
<div class="container3">
    <div class="container" >
        <Carousel >
            <Carousel.Item>
                <CompServicos image = {imagen} texto = "A Sportfy oferece a melhor aplicação de esportes atualmente"/>
                </Carousel.Item>
                <Carousel.Item>
                    <CompServicos image = {imagen2} texto = "Nós utilizamos uma api de ultima geração para aproximar atleta e quadra"/>
                </Carousel.Item>
                <Carousel.Item>
                    <CompServicos image = {imagen3} texto = "Coloque suas quadras na nossa aplicação e aumente seu alcance"/>
                </Carousel.Item>
                <Carousel.Item>
                    <CompServicos image = {imagen4} texto = "Tenha acesso a tudo que as quadras irão oferecer na sua descrição"/>
                </Carousel.Item>
        </Carousel>
    </div>
</div>

        </>
    );
}
export default ServicosDetalhe;