import React from "react";
import { Link } from "react-router-dom";
function FormLogin(props) {
    return (
        <div class="containerLogin">
            <div class="logar">
                <h3>LOGIN {props.titulo}</h3>
                <form class="formsLogar" action="">
                    <label for="">
                        <p>Email</p>
                        <input type="text" />

                    </label>

                    <label for="">
                        <p>Senha</p>
                        <input type="text" />
                    </label>
                </form>

                <button class="btnLogin"  >Login</button>

                <h5>{props.questao}</h5>
                <Link to={props.path}><a>clique aqui</a></Link>
            </div>


            <div class="trocar">

                <div class="inscrever">
                    <p>{props.texto}</p>

                    <Link to={props.pathCadastro}>
                        <button class="btnInscrever">Inscreva-se</button>
                    </Link>
                </div>

            </div>
        </div>
    );
}

export default FormLogin;