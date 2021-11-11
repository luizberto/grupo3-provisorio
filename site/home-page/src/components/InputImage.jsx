import React from "react";

function InputImage(){
    return(
        <>
        <label>
        <input type = "file" className = "inputImage" name = "arquivo" accept = "image/png, image/jpeg"/> 
        </label>
           
        </>
    );
}
export default InputImage;