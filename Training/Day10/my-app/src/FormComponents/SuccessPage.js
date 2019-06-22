import React, { Component } from 'react';
// import {AppBar,MuiThemeProvider ,Typography} from 'material-ui';
import {AppBar,MuiThemeProvider} from 'material-ui';

class SuccessPage extends Component {
    render() { 
        const {values : {firstName,lastName,email,mobile,city,occupation}} = this.props;
        return (
            <MuiThemeProvider>
                <React.Fragment>
                <AppBar title="Success Fully Registered" />
                {/* <Typography component="h2" variant="h1" gutterBottom> */}
                    Your Details Are Successfully Saved {firstName} {lastName} 
                {/* </Typography> */}
                
                </React.Fragment>
            </MuiThemeProvider>
        );
    }
}
 
export default SuccessPage;