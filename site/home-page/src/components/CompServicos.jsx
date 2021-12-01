import React from "react";

function CompServicos({image, texto}) {
    return (
        
    
            <div class="box-image">
                <img src={image} alt="" width="100%" height = "500px"/>
            <p>{texto}</p>
        </div>
    
    );
}

export default CompServicos;