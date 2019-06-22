import {combineReducers} from 'redux'
import greetings from './reducer'

const rootReducer = combineReducers({
    greetings
});

export default rootReducer;