import React from "react";
import {BrowserRouter, Switch, Route} from 'react-router-dom';
import CadastroAdm from "./pages/CadastroAdm";
import CadastroAtleta from "./pages/CadastroAtleta";
import CadastroQuadras from "./pages/CadastroQuadras";
import HomePage from "./pages/HomePage";


function Routes(){
    return(
        <BrowserRouter>
        <Switch>
            <Route path = "/" exact component = {HomePage} />
            <Route path = "/cadastroAtleta" exact component = {CadastroAtleta}/>
            <Route path = "/cadastroAdm" exact component = {CadastroAdm}/>
            <Route path = "/cadastroQuadras" exact component = {CadastroQuadras}/>
        </Switch>
    </BrowserRouter>
    );
}
export default Routes;