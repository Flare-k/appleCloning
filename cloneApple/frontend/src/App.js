import React, { Component, useState, useEffect } from 'react';
// import { } from 'react'
// import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
// import Home from './routes/Home';
import Header from './nav/Header';
// import Login from './routes/Login';
// import Product from './routes/Product';

// import Register from './routes/Register';


import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';




const App = () => {

    return (

        <Header/>


    //     <Router>
    //         <Header />
    //         <Switch>
    //             <Route path='/' exact={true} component={Home} />
    //             <Route path='/member/login' exact={true} component={Login} />
    //             <Route path='/member/join' exact={true} component={Register} />
    //             <Route path='/product/ipad-mini' exact={true} component={Product} />
    //         </Switch>
    //     </Router>
    )

}

export default App;