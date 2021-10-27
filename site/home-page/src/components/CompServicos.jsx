import React from "react";
import imagen from '../home-template-css/img/camisaFundo.png';
function CompServicos({image}){
    return(
        <div class="box">
        <div class="box-image">
            <img src={image} alt="" width="100%" height="100%"/>
        </div>
       
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nam laborum earum, odio tempore consequatur amet, minima saepe, veniam quam quis quidem hic temporibus sequi? Ut amet rem atque saepe tenetur.</p>
    </div>
    );
}

export default CompServicos;