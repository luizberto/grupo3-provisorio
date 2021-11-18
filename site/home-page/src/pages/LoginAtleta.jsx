import React, {useState} from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import {Link, useHistory} from "react-router-dom";
import api from "../api";




function LoginAtleta() {

    const [campo1, setCampo1] = useState("");
    const [campo2, setCampo2] = useState("");
    const history = useHistory();
    function login(e) {
        e.preventDefault();
        api.post("/atletas/login", {
            email: campo1,
            senha: campo2,
        }).then((resposta) => {
            if (resposta.status === 201) {
                alert("logado com sucesso");
                history.push('/buscaQuadra');
            }
        }).catch((erro) => {
            alert("logado erro");
            console.log(erro);
        })
    }
    return (

        <>

            <NavbarSecundario />
            <div class="containerLogin">
                <div class="logar">
                    <h3>LOGIN Atleta</h3>
                    <form class="formsLogar" onSubmit={login} action="">
                        <label for="">
                            <p>Email</p>
                            <input type="text" />

                        </label>

                        <label for="">
                            <p>Senha</p>
                            <input type="text" />
                        </label>
                        <button type="submit" className="btnLogin">Login</button>
                    </form>



                    <h5>É administrador de alguma quadra?</h5>
                    <Link to="/loginAdm"><a>clique aqui</a></Link>
                </div>


                <div class="trocar">

                    <div class="inscrever">
                        <p>seja um dos nossos atletas e participe de um dos maiores sites esportivos do Brasil</p>

                        <Link to="/cadastroAtleta">
                            <button class="btnInscrever">Inscreva-se</button>
                        </Link>
                    </div>

                </div>
            </div>

            <Footer />
        </>
    );
}

export default LoginAtleta;