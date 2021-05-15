import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Product () {
    const [productName, setProductName] = useState('');

    // 변수 초기화
    function callback(str) {
        setProductName(str);
    }

    // callback 함수가 아닌 바로 setProductName 사용 시 에러 발생 (이유 찾아보기)
    useEffect(
        () => {
            axios.get('http://localhost:8080/product/ipad-mini').then((res) => {
                callback(res.data)
            })
        }, []
    );

    return (
        <div class="starter-template">
            <h1>{productName}</h1>
        </div>
    );
};

export default Product;