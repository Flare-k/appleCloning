import React from 'react';
import axios from 'axios';
import './Home.css';

const Home = () => {



    return (
        <div class="starter-template">
            <h1>Apple Home 화면 입니다.</h1>
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

export default Home;