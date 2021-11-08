import React from "react";
import { Link } from "react-router-dom";

function CompLinks({texto, image, link}){
    return(
        <>
           
           <Link to = {link}>
                <div class="serv">
                    <img src={image} width="50px" alt=""/>
                    <p>
                        {texto}
                    </p>
                </div>

            </Link>
            
        </>
    );
}

export default CompLinks;