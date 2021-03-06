import {PAGE_LOAD,PAGE_CHANGE} from './actions'
const defaultState = {
    menuName : "View Products",
    page : "products.html",
    menuID : "1235",
    pageContent : "hi",
    messageVisibility : false
  }


const greetings = (state=defaultState,action) => {
    const {type} = action
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