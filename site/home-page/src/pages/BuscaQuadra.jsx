import React from "react";
import CardQuadras from "../components/CardQuadras";

function BuscaQuadra(){
    return(
        <>
<section>
    <div class="containeCard"> 
      <div class="box-menu">
        <select name="select">
          <option value="valor1">Ordenar</option>
          <option value="valor2" >Distancia</option>
          <option value="valor3">Favoritos</option>
        </select>

        <input type="text"/>
      </div>

      <CardQuadras/>

      

     
    </div>
</section>
        </>
    );
}
export default BuscaQuadra;