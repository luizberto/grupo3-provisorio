import React from "react";
import imagen from '../home-template-css/img/camisaFundo.png';
function CompServicos({image, texto}){
    return(
        <div class="box">
        <div class="box-image">
            <img src={image} alt="" width="100%" height="100%"/>
        </div>
       
        <p>{texto}</p>
    </div>
    );
}

export default CompServicos;