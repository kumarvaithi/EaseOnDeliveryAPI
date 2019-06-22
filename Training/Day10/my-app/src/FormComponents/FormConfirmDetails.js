import React, { Component } from 'react';
import {AppBar,MuiThemeProvider ,List,ListItem,RaisedButton} from 'material-ui';

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
        const {values : {firstName,lastName,email,mobile,city,occupation}} = this.props;
        return ( 
            <MuiThemeProvider>
                <React.Fragment>
                    <AppBar title="Confirm Details" />
                    <List>
                        <ListItem primaryText="First Name" secondaryText={firstName} />
                        <ListItem primaryText="Last Name" secondaryText={lastName} />
                        <ListItem primaryText="Email" secondaryText={email} />
                        <ListItem primaryText="Mobile" secondaryText={mobile} />
                        <ListItem primaryText="City" secondaryText={city} />
                        <ListItem primaryText="Occupation" secondaryText={occupation} />
                    </List>
                    <RaisedButton 
                    label = "Confirm"
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
