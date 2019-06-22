import React, {Component} from 'react'

class Product extends Component{
    render(){
        return(
            <div>
                <h2 className="secondName">Please find the below Product List</h2>
                <ul>
                    {/* for rendering purpose this syntax is used
                    {this.props.product.map((list,index)=>(
                        <li key={index}>{list}</li>
                    ))} */} 
                    {this.props.product.map((list,index)=>{
                        return(
                            <li key={index}>{list}</li>
                        )
                    })}
                </ul>
            </div>
        )
    }
}

export default Product;