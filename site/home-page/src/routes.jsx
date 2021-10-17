import React from "react";
import {BrowserRouter, Switch, Route} from 'react-router-dom';
import CadastroAdm from "./pages/CadastroAdm";
import CadastroAtleta from "./pages/CadastroAtleta";
import CadastroQuadras from "./pages/CadastroQuadras";
import HomePage from "./pages/HomePage";
import LoginAdm from "./pages/LoginAdm";
import LoginAtleta from "./pages/LoginAtleta";
import PreCadastro from "./pages/PreCadastro";
import PreLogin from "./pages/PreLogin";


function Routes(){
    return(
        <BrowserRouter>
        <Switch>
            <Route path = "/" exact component = {HomePage} />
            <Route path = "/cadastroAtleta" exact component = {CadastroAtleta}/>
            <Route path = "/cadastroAdm" exact component = {CadastroAdm}/>
            <Route path = "/cadastroQuadras" exact component = {CadastroQuadras}/>
            <Route path = "/preLogin" exact component = {PreLogin}/>
            <Route path = "/preCadastro" exact component = {PreCadastro}/>
            <Route path = "/loginAdm" exact component = {LoginAdm}/>
            <Route path = "/loginAtleta" exact component = {LoginAtleta}/>
        </Switch>
    </BrowserRouter>
    );
}
export default Routes;