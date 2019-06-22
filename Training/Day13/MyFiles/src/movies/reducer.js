import {GET_MOVIES,GET_MOVIE,RESET_MOVIE} from './actions'

const defaultState = {
    movies : [],
    isMoviesLoaded : false,
    movie: {},
    isMovieLoaded : false
  }


export default  function(state=defaultState,action) {
    const {type,data} = action
      switch(type){
      case GET_MOVIES :
      return {
        ...state, 
        movies : data,
        isMoviesLoaded : true
      }
      case GET_MOVIE :
      return {
        ...state, 
        movie : data,
        isMoviesLoaded : true
      }
      case RESET_MOVIE :
      return {
        ...state, 
        movie : {},
        isMovieLoaded : false
      }
      default :
      return state 
    }
}