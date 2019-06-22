import React, { Component } from 'react';
import { applyMiddleware } from 'redux';
import {createStore} from 'redux';
import {Provider} from 'react-redux'
import rootReducer from './rootReducer'
import { composeWithDevTools } from 'redux-devtools-extension';
import Toggle from './Toggle';
import {
  BrowserRouter as Router,
  Link,
  NavLink,
  Route,
  Switch
} from 'react-router-dom'


import logger from 'redux-logger'
import thunk from 'redux-thunk'
import MovieDetail from './MovieDetail'
import MovieList from './MovieList'
const middleware = [logger,thunk]



// const store = createStore(rootReducer);
const store = createStore(rootReducer, {}, composeWithDevTools(applyMiddleware(...middleware)));

class App extends Component {
  render() {
    return (
      <Provider store={store}>
      <Router>

      
      <div className="App">
        {/* <Toggle /> */}
      </div>
      <Switch>
        <Route exact path="/" component={MovieList}/>
        <Route path="/:id" component={MovieDetail}/>
      </Switch>
      </Router>
      </Provider>
    );
  }
}

export default App;
//create store
// const hello = () => ({welcome : "Hello"})
// const store = createStore(hello);
// console.log(store.getState());

// const defaultState = {
//   menuName : "View Products",
//   page : "products.html",
//   menuID : "1235",
//   pageContent : "hi"
// }

//reducer function
// const greetings = (state=defaultState,action) => {
//   const {type,pageName} = action
//   // switch(action.type){
//     switch(type){
//     case 'PAGE_LOAD' :
//     return {...state, pageContent : `Welcome to  ${pageName}`}
//     case 'PAGE_CHANGE' : 
//     return {...state,pageContent : "Page has Changed"}
//     default :
//     return state 
//   }
// }

// const store = createStore(greetings)
// console.log(store.getState())
// const pageName = "index.html";
// store.dispatch({
//   type : "PAGE_LOAD",
//   pageName
// })

// console.log(store.getState())