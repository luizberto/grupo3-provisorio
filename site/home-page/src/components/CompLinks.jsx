import React from "react";


function CompLinks({texto, image}){
    return(
        <>
           
                <div class="serv">
                    <img src={image} width="50px" alt=""/>
                    <p>
                        {texto} 
                    </p>
                </div>
            
        </>
    );
}

export default CompLinks;