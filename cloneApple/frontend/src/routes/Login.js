import React, { useEffect } from 'react';
import axios from 'axios';
import './Home.css';

const Login = () => {



    useEffect(()=>{
        getApi();
        getApi2();

    });

    const getApi = () => {

        axios.get("http://localhost:8080/api/hello")
            .then(res => {
                console.log(res.data);

            })
            .catch(res => console.log(res))
    };
    const getApi2 = () => {

        axios.get("http://localhost:8080/api/hello1")
            .then(res => {
                console.log(res.data);

            })
            .catch(res => console.log(res))
    };


    return (
        <div class="starter-template">
            <h1>Apple Login 화면 입니다.</h1>
        </div>
    );


}

// class Home extends React.Component {
//     constructor(props) {
//         super(props)
//         this.state = {
//             message : ""
//         }
//     }

//     componentDidMount() {
//         console.log('test')
//         // this.getApi();
//     }

//     // getApi = () => {
//     //     axios.get("http://localhost:8080/")
//     //         .then(res => {
//     //             console.log(res);
//     //             console.log('test')
//     //             this.setState({
//     //                 message : res.data.message
//     //             })
//     //         })
//     //         .catch(res => console.log(res))
//     // }

//     render() {

//     }
// };

export default Login;