import React from "react";
import CompServicos from "../components/CompServicos";
import bolinha from '../home-template-css/img/fluent_sport-soccer-16-regular.png'
import imagen from '../home-template-css/img/camisaFundo.png'
import imagen2 from '../home-template-css/img/fut.jpg'
import imagen3 from '../home-template-css/img/image 21.png'
import imagen4 from '../home-template-css/img/gramadinho.png'
function ServicosDetalhe({image, texto}){
    return(
        <>
<div class="container3">

    <div class="container-grid">

        <CompServicos image = {imagen} texto = "A Sportfy oferece a melhor aplicação de esportes atualmente, trazendo acessibilidade e alcance para você e seus amigos"/>
        <CompServicos image = {imagen2} texto = "Nós utilizamos uma api de ultima geração para aproximar atleta e quadra num movimento de reciprocidade onde os administradores dessas quadras e os usuarios delas tenham o melhor filtro dentro do aplicativo"/>
        <CompServicos image = {imagen3} texto = "Coloque suas quadras na nossa aplicação e aumente seu alcance, fazendo assim que as pessoas de sua proximidade conheçam seu negocio e se fidelizem através de uma melhor acessibilidade"/>
        <CompServicos image = {imagen4} texto = "Tenha acesso a tudo que as quadras irão oferecer na sua descrição e observe se ela se adapta a sua demanda e de seus amigos"/>
    </div>
</div>

        </>
    );
}
export default ServicosDetalhe;