import React, { Component } from 'react';
import {AppBar,MuiThemeProvider ,TextField,RaisedButton} from 'material-ui';

class FormPersonalDetails extends Component {
    continue = e => {
        e.preventDefault();
        this.props.nextStep();
    }
    back = e =>{
        e.preventDefault();
        this.props.previousStep()
    }
    render() { 
        const {values,handleChange} = this.props;
        return ( 
            <MuiThemeProvider>
                <React.Fragment>
                    <AppBar title="Personal Details" />
                    <TextField 
                    hintText = "Enter The Mobile"
                    floatingLabelText="Mobile"
                    onChange = {handleChange('mobile')}
                    defaultValue = {values.mobile}/>
                    <br/>

                    <TextField 
                    hintText = "Enter The City"
                    floatingLabelText="City"
                    onChange = {handleChange('city')}
                    defaultValue = {values.city}/>
                    <br/>

                    <TextField 
                    hintText = "Enter The Occupation"
                    floatingLabelText="Occupation"
                    onChange = {handleChange('occupation')}
                    defaultValue = {values.occupation}/>
                    <br/>

                    <RaisedButton 
                    label = "Continue"
                    primary = {true}
                    style = {styles.button}
                    onClick = {this.continue}/>

                    <RaisedButton 
                    label = "Back"
                    primary = {true}
                    style = {styles.button}
                    onClick = {this.back}/>
                </React.Fragment>
            </MuiThemeProvider>                
         );
    }
}
const styles = {
    button : {
        margin : 15
    }
};
export default FormPersonalDetails;
