import {combineReducers} from 'redux'
// import movies from './movies/reducer'
import toggle from './reducer'
import { reducer as formReducer } from 'redux-form'
const rootReducer = combineReducers({
    form:formReducer,
    toggle
    
});

export default rootReducer;