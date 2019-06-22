import React, { Component } from 'react';
import FormUserDetails from './FormUserDetails'
import FormPersonalDetails from './FormPersonalDetails'
import FormConfirmDetails from './FormConfirmDetails'
import SuccessPage from './SuccessPage'

class UserForm extends Component {
    state = { 
        step : 1,
        firstName : "",
        lastName : "",
        email : "",
        mobile : "",
        city : "",
        occupation : ""
     }

     nextStep = () =>{
         const {step} =this.state;
         this.setState({
            step : step +1
         });
     };
     previousStep = () =>{
        const {step} =this.state;
        this.setState({
           step : step -1
        });
    };
    handleChange = (stateObject) => (e) => {
          this.setState ({ [stateObject] : e.target.value})
    }
  
    render() { 
        const {step} = this.state;
        const {firstName,lastName,email,mobile,city,occupation} = this.state;
        const values = {firstName,lastName,email,mobile,city,occupation}
        switch(step){
            case 1:
            return ( 
                <FormUserDetails 
                nextStep = {this.nextStep}
                handleChange = {this.handleChange}
                values = {values}/>
            );
            case 2:
            return ( 
                <FormPersonalDetails 
                nextStep = {this.nextStep}
                previousStep = {this.previousStep}
                handleChange = {this.handleChange}
                values = {values}/>
            );
            case 3:
            return ( 
                <FormConfirmDetails 
                nextStep = {this.nextStep}
                previousStep = {this.previousStep}
                handleChange = {this.handleChange}
                values = {values}/>
            );
            case 4:
            return ( 
                <SuccessPage 
                values = {values}/>
            );
        }        
    }
}

export default UserForm;