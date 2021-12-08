import React, { useState } from "react";
import logo from "../home-template-css/img/image 22.png";
import { Link } from "react-router-dom";
import { DropdownButton, Dropdown, Stack } from "react-bootstrap";



function Navbar({ atleta, dnquadra, cadAtleta, cadAdm }) {

    return (
        <>
            <header class="header">
                <a class="logo" href="/">
                    <img src={logo} height="40px" alt="" />
                </a>

                <nav>
                    <Stack direction="horizontal" gap={2}>
                        <DropdownButton
                            size="md"
                            title="Login"
                            variant="success"
                        >
                            <Dropdown.Item href={atleta} eventKey="1">Atleta</Dropdown.Item>
                            <Dropdown.Item href={dnquadra} eventKey="2">Administrador</Dropdown.Item>
                        </DropdownButton>
                        <DropdownButton
                            size="md"
                            title="Cadastro"
                            variant="success"
                        >
                            <Dropdown.Item href={cadAtleta} eventKey="1">Atleta</Dropdown.Item>
                            <Dropdown.Item href={cadAdm} eventKey="2">Administrador</Dropdown.Item>
                        </DropdownButton>
                    </Stack>
                </nav>
            </header>
        </>
    );
}

export default Navbar;