import React, {Component} from 'react'

class List extends Component{
    render(){
        return(
            <h2 className="secondName">Hi, I am fine, Yes {this.props.product} with {this.props.price}</h2>
        )
    }
}

export default List;