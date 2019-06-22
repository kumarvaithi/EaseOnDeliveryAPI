import React, {Component} from 'react'

class JsonCheck extends Component{
    render(){
        var todo = this.props.object.filter(data => data.done === true)
        var done = this.props.object.filter(data => data.done === false)
        return(
            <div>
                <h2 className="secondName">Please find the below Product List</h2>
                <ul>
                    {/* {this.props.object.map((data,index)=>(<li key={index}>{data.name}</li>))} */}
                    <h1>Done</h1>
                    {todo.map((data,index)=>(
                            <li key={index}>{data.name}</li>
                    ))}

                    <h1>TO DO</h1>
                    {done.map((data,index)=>(
                        <li key={index}>{data.name}</li>
                    ))}
                </ul>
            </div>
        )
    }
}

export default JsonCheck;