import React from "react";
import {BrowserRouter, Switch, Route} from 'react-router-dom';
import CadastroAdm from "./pages/CadastroAdm";
import CadastroAtleta from "./pages/CadastroAtleta";
import CadastroQuadras from "./pages/CadastroQuadras";
import HomePage from "./pages/HomePage";
import LoginAdm from "./pages/LoginAdm";
import LoginAtleta from "./pages/LoginAtleta";
import CadastroEndereco from "./pages/CadastroEndereco";
import PerfilAdm from "./pages/PerfilAdm";
import EdicaodeQuadra from "./pages/EdicaodeQuadra";



function Routes(){
    return(
        <BrowserRouter>
        <Switch>
            <Route path = "/" exact component = {HomePage} />
            <Route path = "/cadastroAtleta" exact component = {CadastroAtleta}/>
            <Route path = "/cadastroAdm" exact component = {CadastroAdm}/>
            <Route path = "/cadastroQuadras" exact component = {CadastroQuadras}/>
            <Route path = "/loginAdm" exact component = {LoginAdm}/>
            <Route path = "/loginAtleta" exact component = {LoginAtleta}/>
            <Route path = "/cadastroEndereco" exact component = {CadastroEndereco}/>
            <Route path = "/perfilAdm" exact component = {PerfilAdm}/>
            <Route path = "/edicaoQuadra" exact component = {EdicaodeQuadra}/>
        </Switch>
    </BrowserRouter>
    );
}
export default Routes;