import React, { useState } from "react";
import logo from "../home-template-css/img/image 22.png";
import { Link } from "react-router-dom";
import { DropdownButton, Dropdown, Stack, Button } from "react-bootstrap";



function Navbar({ atleta, dnquadra, cadAtleta, cadAdm }) {

    return (
        <>
            <header class="header">
                <a class="logo" href="/">
                    <img src={logo} height="40px" alt="" />
                </a>

                <nav>
                    <Stack direction="horizontal" gap={2}>
                        <Button
                            title="Login"
                            variant="dark"
                        >
                            Login
                        </Button>
                        <Button
                            title="cadastrar"
                            variant="dark"
                        >
                            Cadastrar
                        </Button>
                    </Stack>
                </nav>
            </header>
        </>
    );
}

export default Navbar;