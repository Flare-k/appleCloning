import React from "react";
import { Navbar } from "react-bootstrap";
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Login from '../routes/Login';
import Register from '../routes/Register';
import Product from '../routes/Product';

const Header = () => {
    return (
        <Router>
            <Navbar
                bg="black"
                variant="datk"
                className="mb-4">
                <Navbar.Brand href="/">
                    <img
                        src="/logo.png"
                        width="30"
                        height="30"
                        className="d-inline-block align-top"
                        alt="React Bootstrap logo"
                    />Home
                    </Navbar.Brand>

                <Navbar.Brand href="/login">Login</Navbar.Brand>
                {/* <Navbar.Brand href="/member/login">Login</Navbar.Brand>
                <Navbar.Brand href="/member/register">Join</Navbar.Brand>
                <Navbar.Brand href="/product/ipad-mini">ipad</Navbar.Brand> */}
            </Navbar>

            <Route path="/login" component={Login} />


            {/* <Route path="/member/login" component={Login} />
            <Route path="/member/register" component={Register} />
            <Route path="/product/ipad-mini" component={Product} /> */}
        </Router>
    );
};

export default Header;