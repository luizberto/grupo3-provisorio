import React from "react";
import figUm from "../home-template-css/App/img-novo/ficha.png";
import figDois from "../home-template-css/App/img-novo/money.png";
import figTres from "../home-template-css/App/img-novo/bola.png";
import CompLinks from "../components/CompLinks";


function Servicos(){
    return(
        <>  

            <section className="missao">
                <h1 className="m-titulo">Entenda nossa missão</h1>
                <div className = "detalhes">
                        <CompLinks image = {figUm} 
                        texto = " A Compreensão é uma das ferramentas que utilizamos para proceder nos ensinos com as crianças, entendendo o seu contexto de vida, transtornos ou dificudades nós conseguimos nos moldar da melho forma para a experencia dela na nossa instituição"
                        />

                        <CompLinks image = {figDois} 
                        texto = "Aqui nós aplicamos o Ensino Humanizado para que desde cedo os nossos alunos entendam seu papel quanto pessoas na sociedade, ensinando sempre o respeito a diferenças, e trazendo sempre o ar de inclusão para o ambiente em que eles vivem tendo assim o maior acolhimento possivel e a melhor aprendzagem consequentemente"
                        />

                        <CompLinks image = {figTres} 
                        texto = "O Interesse é um dos mais imortantes valores que trazemos. Queremos acompanhar todos os passos de nossas cranças, tanto social quanto pessoal, para que ela nunca se sinta desamparada e cada uma possa se sentir unica no nosso universo de alunos prodigios."/>
                </div>
            </section>
        </>
    );
}

export default Servicos;