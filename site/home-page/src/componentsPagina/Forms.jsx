import React from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";


function Forms(props){
    return(
    <>
    <NavbarSecundario/>
        <div class="container4">
            <div class="dadosCadastro">
                <h4 class="tituloForm">{props.titulo}</h4>
                <form action="" class="formClass">
                    <label for=""> {props.campoUm}
                        <input type="text"/>
                    </label>
                    <label for="">{props.campoDois}
                        <input type="text"/>
                    </label>
                    <label for=""> {props.campoTres}
                        <input type="text"/>
                    </label>
                    <label for=""> {props.campoQuatro}
                        <input type="text"/>
                    </label>
                    <label for=""> {props.campoCinco}
                        <input type="text"/>
                    </label>
                </form>

                <button class="buttonCadastrar">Cadastrar</button>
            </div>

        </div>
    <Footer/>
    </>
    );
}
export default Forms;