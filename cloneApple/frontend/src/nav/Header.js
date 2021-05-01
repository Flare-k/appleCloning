import React from "react";
import { Navbar } from "react-bootstrap";
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Login from '../routes/Login';
import Register from '../routes/Register';

const Header = () => {
    return (
        <Router>
            <Navbar 
                bg = "dark"
                variant="datk"
                className="mb-4">
                <Navbar.Brand href="/">Home</Navbar.Brand>
                <Navbar.Brand href="/member/login">Login</Navbar.Brand>
                <Navbar.Brand href="/member/register">Join</Navbar.Brand>
            </Navbar>

            <Route path="/member/login" component={Login} />
            <Route path="/member/register" component={Register} />
        </Router>
    );
};

export  default Header;