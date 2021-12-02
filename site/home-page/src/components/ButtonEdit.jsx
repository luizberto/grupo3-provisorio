import React from "react";
import edite from '../home-template-css/App/img/edite.png'
import { Link } from "react-router-dom";

function ButtonEdit(props){
    return(
       <Link to = {props.path}><button className = "botaoAcao">{props.acao}</button></Link> 
    );
}
export default ButtonEdit;