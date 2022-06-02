import React from "react";
import { Link } from "react-router-dom";

function CompLinks({texto, image}){
    return(
        <>
                <div class="m-detalhe">
                    <img src={image} alt=""/>
                    <p>
                        {texto}
                    </p>
                </div>
        </>
    );
}

export default CompLinks;