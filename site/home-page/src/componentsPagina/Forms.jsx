import React from "react";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";


function Forms(props){
    return(
        <>
        <Navbar/>
            <main>
        <div class="backgroundCadastro">
            <span class="">
                <h2>{props.titulo}</h2>
            </span>
            <div class="boxContainer">
                <div class="borderTopCadastro">
                </div>
                <form class="dadosCadastro">
                    <div class="infoPessoal">
                        <h2>{props.subTitulo}</h2>
                        <span class="">
                            <p>{props.campoUm}</p>
                            <input type="text" class="campo"/>
                        </span>
                        <span>
                            <p>{props.campoDois}</p>
                            <input type="email" class="campo"/>
                        </span>
                        <span>
                            <p>{props.campoTres}</p>
                            <input type="password" class="campo"/>
                        </span>
                        <span>
                            <p>{props.campoQuatro}</p>
                            <input class="campo"/>
                        </span>
                        <span>
                            <p>{props.campoCinco}</p>
                            <input class="campo"/>
                        </span>
                        <button>Cadastrar</button>
                    </div>


                </form>
                <div class="borderBottomCadastro">
                </div>
            </div>
        </div>
    </main>
    <Footer/>
        </>
    );
}
export default Forms;