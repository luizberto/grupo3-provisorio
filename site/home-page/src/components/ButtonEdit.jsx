import React from "react";
import edite from '../home-template-css/App/img/edite.png'

function ButtonEdit(props){
    return(
        <button className = "botaoAcao">{props.acao}</button>
    );
}
export default ButtonEdit;