import React from "react";

function CompServicos({image, texto}) {
    return (
        <div class="box">
            <div class="box-image">
                <img src={image} alt="" width="100%" height="100%"/>
            </div>

            <p>{texto}</p>
        </div>
    );
}

export default CompServicos;