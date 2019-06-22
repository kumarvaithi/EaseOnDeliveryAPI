import {PAGE_LOAD,PAGE_CHANGE,GET_MOVIES} from './actions'

const defaultState = {
    menuName : "View Products",
    page : "products.html",
    menuID : "1235",
    pageContent : "hi",
    messageVisibility : false,
    movies: []
  }


const greetings = (state=defaultState,action) => {
    const {type,pageName,data} = action
    // switch(action.type){
      switch(type){
      case PAGE_LOAD :
      return {...state, messageVisibility : !state.messageVisibility}
      case PAGE_CHANGE : 
      return {...state,pageContent : "Page has Changed"}
      
      default :
      return state 
    }
  }

  export default greetings;