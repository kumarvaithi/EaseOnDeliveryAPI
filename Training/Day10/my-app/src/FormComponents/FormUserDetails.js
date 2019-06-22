import React, { Component } from 'react';
import {AppBar,MuiThemeProvider ,TextField,RaisedButton} from 'material-ui';

class FormUserDetails extends Component {

    continue = e => {
        e.preventDefault();
        this.props.nextStep();
    }

    render() { 
        const {values,handleChange} = this.props;
        return ( 
                <MuiThemeProvider>
                    <React.Fragment>
                        <AppBar title="Basic Details" />
                        <TextField 
                        hintText = "Enter The First Name"
                        floatingLabelText="First Name"
                        onChange = {handleChange('firstName')}
                        defaultValue = {values.firstName}/>
                        <br/>
                        <TextField 
                        hintText = "Enter The Last Name"
                        floatingLabelText="Last Name"
                        onChange = {handleChange('lastName')}
                        defaultValue = {values.lastName}/>
                        <br/>
                        <TextField 
                        hintText = "Enter The Email"
                        floatingLabelText="Email"
                        onChange = {handleChange('email')}
                        defaultValue = {values.email}/>
                        <br/>

                        <RaisedButton 
                        label = "Continue"
                        primary = {true}
                        style = {styles.button}
                        onClick = {this.continue}/>
                    </React.Fragment>
                    {/* <input type="text" values = {values.firstName} onChange ={handleChange('firstName')}/> */}
                </MuiThemeProvider>                
        );

    }
}
const styles = {
    button : {
        margin : 15
    }
};
export default FormUserDetails;