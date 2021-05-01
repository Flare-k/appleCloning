import React from 'react';
import axios from 'axios';
import './Home.css';

class Home extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            message : ""
        }
    }

    componentDidMount() {
        this.getApi();
    }

    getApi = () => {
        axios.get("http://localhost:8080/")
            .then(res => {
                console.log(res);
                this.setState({
                    message : res.data.message
                })
            })
            .catch(res => console.log(res))
    }

    render() {
        return (
            <div class="starter-template">
                <h1>Apple Home 화면 입니다.</h1>
            </div>
        );
    }
};

export default Home;