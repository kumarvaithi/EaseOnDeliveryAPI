import React, {Component} from 'react';
import { connect } from 'react-redux';
import {toggleMessage} from './actions'
import {bindActionCreators} from 'redux'
const Toggle = ({messageVisibility,menuName,dispatch,toggleMessage}) => (
        <div>
            {messageVisibility &&
                <p>Welcome to {menuName}</p>
            }
            {/* <button onClick={() => dispatch({
                toggleMessage
            })}>Toggle</button> */}
            <button onClick={toggleMessage}>Toggle</button>
        </div>
    
)

const mapStateToProps = state => ({
    messageVisibility : state.greetings.messageVisibility,
    menuName : state.greetings.menuName
})

const mapDispatchToProps = dispatch => bindActionCreators({
    toggleMessage
},dispatch)

export default connect(mapStateToProps,mapDispatchToProps)(Toggle);