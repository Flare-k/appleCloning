import React, {Component} from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './routes/Home';
import Header from './nav/Header';
import Login from './routes/Login';
import Register from './routes/Register';


import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';


class App extends Component {
    render() {
        return (
            <Router>
                <Header/>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/member/login' exact={true} component={Login}/>
                    <Route path='/member/join' exact={true} component={Register}/>
                </Switch>
            </Router>
        )
    }
}

export default App;