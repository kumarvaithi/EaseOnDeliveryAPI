import React, { Component } from 'react';
import './App.css';
import P0 from './Component/P0'
import UserForm from './FormComponents/UserForm'
import NavExample from './NavExample'
import SideBar from './SideBar'
import {
  BrowserRouter as Router,
  Link,
  NavLink,
  Route
} from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <div className="App">
        {/* <UserForm/> */}
        {/* <P0/> */}
        {/* <RouterMenu/> */}
      
        <Router>
          <Link  to ='/' >Home</Link>
          <br/>
          <Link to ='/signup' >SignUp</Link>
          <br />
          <Link to ='/nav' >NAV Menu</Link>
          <br />
          <Link to ='/sidebar' >Side Bar</Link>
          <Route exact path = "/" component = {P0}/>
          <Route path = "/signup" component = {UserForm}/>
          <Route path = "/nav" component = {NavExample}/>
          <Route path ="/sidebar" component = {SideBar}/>
        </Router>
      </div>
    );
  }
}

export default App;
