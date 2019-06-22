import React, {Component} from 'react'
import PropTypes from 'prop-types'

class ListContact extends Component{
    state = {
        query : "",
        showContactInfo: false,
        divID : ""
    }
    updateQuery = (query)=>{
        this.setState({
            query : query.trim()
        })
    }
    clearQuery = ()=>{
        this.updateQuery(' ')
    }
    showMoreDetails =(url,id)=>{
        this.setState({showContactInfo : !this.state.showContactInfo,
            divID : id})
    }
    render(){
        const {contacts,onDeleteContact} = this.props
        const {query,showContactInfo} = this.state;
        const ShowContact = query === ''
                        ? contacts
                        : contacts.filter((c)=>(c.name.toLowerCase().includes(query.toLowerCase())))

        return(
            <div>
                {JSON.stringify(query)}
                <br/>
                <input value={query} placeholder="Search" onChange={(event) => this.updateQuery(event.target.value)}/>
                {ShowContact.length !== contacts.length &&(
                    <div>
                        Showing {ShowContact.length} of {contacts.length}
                        <button onClick={this.clearQuery}>Clear</button>
                    </div>
                )}
                <ol>
                {ShowContact.map((list,index)=>
                    <li key={index} className="list-contacts" style={{border : "2px solid #000"}}>
                    {showContactInfo && list.id === this.state.divID ? (<div>
                        <img src={list.url} className="profileImg" width="100" height="100"></img>
                        <br/>
                        <button onClick={()=>onDeleteContact(list)}>Remove</button>
                    </div>) : ''}
                    
                        <br></br>{list.name}<br></br>
                        <button onClick={()=>this.showMoreDetails(list.url,list.id)}>Show More Details</button>
                    </li>
                )}
                </ol>   
            </div>
        )
    }
}
//functional Statement
// const ListContact = (props) =>{
//     return(
//         <div>
//             <ol>
//             {props.contacts.map((list,index)=>
//                 <li key={index} className="list-contacts" style={{border : "2px solid #000"}}>
//                     <img src={list.url} width="100" height="100"></img>{list.name}
//                     <button onClick={()=>props.onDeleteContact(list)}>Remove</button>
//                 </li>
//             )}
//             </ol>   
//         </div>
//     )
// }

ListContact.propTypes = {
    contacts : PropTypes.array.isRequired,
    onDeleteContact : PropTypes.func.isRequired
}

export default ListContact;