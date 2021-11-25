import React, {useEffect, useState} from "react";
import api from "../api";

function DadosQuadra(props) {
  return(
    <>
        <p>Limite de pessoas:{sessionStorage.getItem('limitePessoas')}</p>
        <p>Materiais esportivos:</p>
        <p>Valor:</p>
        <p>Endereço:</p>
        <p>Cep:</p>
        <p>Descrição: {sessionStorage.getItem('descricao')}</p>    

    </>
  );
  
}

export default DadosQuadra;
