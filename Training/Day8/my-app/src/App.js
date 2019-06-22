import React, { Component } from 'react';
import './App.css';
import ListContact from './ListContact';

class App extends Component {
  state = {
    contacts:[
      {
        id : "1",
        name : "thameem",
        address : "test add1",
        url : "https://upload.wikimedia.org/wikipedia/commons/4/4b/What_Is_URL.jpg"
      },
      {
        id : "2",
        name : "irfan",
        address : "test add2",
        url : "https://upload.wikimedia.org/wikipedia/commons/4/4b/What_Is_URL.jpg"
      },
      {
        id : "3",
        name : "kabeer",
        address : "test add3",
        url : "https://upload.wikimedia.org/wikipedia/commons/4/4b/What_Is_URL.jpg"
      }
    ],
    count : 0
  }
  removeContact = (contact)=>{
    this.setState({
      contacts : this.state.contacts.filter((c)=>c.id !== contact.id)
    })
  }

  inCrement = ()=>{
    this.setState({
      
      count : this.state.count + 1
    })
  }
  decrement = ()=>{
    this.setState({
      count : this.state.count - 1
    })
  }
  render() {
    return (
      <div className="App">
        {this.state.count}
        <br/>
        <button onClick={this.inCrement}>Increment</button>
        <br/>
        <button onClick={this.decrement}>Decrement</button>
        <ListContact contacts = {this.state.contacts}
        onDeleteContact = {this.removeContact}/>   
      </div>
    );
  }
}

export default App;
