import React, {useEffect, useState} from "react";
import api from "../api";

function DadosQuadra(props) {
  return(
    <>
        <p>Limite de pessoas:</p>
        <p>Materiais esportivos:</p>
        <p>Telefone:</p>
        <p>Endereço:</p>
        <p>Cep:</p>
        <p>Descrição: {sessionStorage.getItem('descricao')}</p>    

    </>
  );
  
}

export default DadosQuadra;
