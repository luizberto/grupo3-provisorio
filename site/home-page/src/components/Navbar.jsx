import React, {useState} from "react";
import logo from "../home-template-css/img/image 22.png";
import {Link} from "react-router-dom";
import {DropdownButton, Dropdown} from "react-bootstrap";
import {useHistory} from "react-router-dom";

function Navbar({atleta, dnquadra, cadAtleta, cadAdm }){

    return(
        <>
        <header class="header">
        <a class="logo" href="/">
            <img src= {logo} height="40px" alt=""/>
            </a>

        <nav>

            <DropdownButton
                size="lg"
                title="Login"
                variant="secondary"
            >
                <Dropdown.Item href={atleta} eventKey="1">Atleta</Dropdown.Item>
                <Dropdown.Item href={dnquadra} eventKey="2">Administrador</Dropdown.Item>
            </DropdownButton>
            <DropdownButton
                size="lg"
                title="Cadastro"
                variant="secondary"
            >
                <Dropdown.Item href={cadAtleta} eventKey="1">Atleta</Dropdown.Item>
                <Dropdown.Item href={cadAdm} eventKey="2">Administrador</Dropdown.Item>
            </DropdownButton>
        </nav>
    </header>
    </>
    );
}

export default Navbar;