import React from 'react'
//const React = require('react) // ES modules - ES6

import ReactDOM from 'react-dom'

import List from './List'
import Product from './Product'
import JsonCheck from './JsonCheck'


require('./index.css')
const userData = {
    name : "Thameem",
    product : "Apple",
    price : "100"
}
const array = ['Apple','Orange','Banana']

const jsonObject = [{name :  'A',done: true},{name :  'B',done: false},{name :  'C',done: true} ]

class App extends React.Component{
    render(){
        return(
            <div>
                <h1 className="firstName">Hello,{this.props.user.name} how are you, is {this.props.user.product} with you around {this.props.user.price} rupees</h1>
            <List product = {this.props.user.product}price = {this.props.user.price}/>
            {/* <Product product = {this.props.productList}/> */}
            <Product product = {array}/>
            <JsonCheck object={jsonObject}/>
            <br/>
            </div>
        )
    }
}

ReactDOM.render(
    // <App name = "Thameem"/>,
    <App user = {userData} productList = {array}/>,
    document.getElementById("main")
)