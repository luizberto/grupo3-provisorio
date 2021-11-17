import React from "react";
import Footer from "../components/Footer";
import NavbarSecundario from "../components/NavbarSecundario.jsx";
import FormLogin from "../componentsPagina/FormLogin";

function LoginAtleta(){
       
return( 

    <>

        <NavbarSecundario/>
        <div class="containerLogin">
        <div class="logar">
            <h3>LOGIN Atleta</h3>
            <form class="formsLogar" action="">
                <label for="">
                   <p>Email</p> 
                    <input type="text"/>
                    
                </label>

                <label for="">
                  <p>Senha</p>
                    <input type="text"/>
                </label>
            </form>

            <button class="btnLogin">Login</button>

            <h5>É administrador de alguma quadra?</h5>
                <Link to = "/loginAdm"><a>clique aqui</a></Link>   
        </div>


        <div class="trocar">

            <div class="inscrever">
                <p>seja um dos nossos atletas e participe de um dos maiores sites esportivos do Brasil</p>

              <Link to = "/cadastroAtleta">
                  <button class="btnInscrever">Inscreva-se</button>  
                  </Link>    
            </div>
           
        </div>
    </div>

    <Footer/>
      </>
      );
}

export default LoginAtleta;