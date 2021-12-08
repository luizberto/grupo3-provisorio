import React from "react";
import { Link } from "react-router-dom";

function ButtonLoginDQ(props){
    return(
        <>
             <div class="linkDono">
                        <h4>Dono de Quadra?</h4>
                    <Link to = {props.dnquadra}> <a>Logar aqui!</a></Link>
             </div>
        </>
    );
}

export default ButtonLoginDQ;