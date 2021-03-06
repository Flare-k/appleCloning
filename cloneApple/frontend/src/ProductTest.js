import React, {useState, useEffect} from 'react';

function ProductTest () {
  const [message, setMessage] = useState("");
  useEffect(() => {
    fetch('/product/productname')
        .then(response => response.text())
        .then(message => {
          setMessage(message);
        });
  },[])
  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          <h1 className="App-title">{message}</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
  )
}

export default ProductTest;