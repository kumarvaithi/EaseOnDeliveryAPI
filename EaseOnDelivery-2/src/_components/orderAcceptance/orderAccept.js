import React, {Component} from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import TextField from '@material-ui/core/TextField';
import { withStyles } from '@material-ui/core/styles';
import { InputLabel } from '@material-ui/core';
import AccountCircle from '@material-ui/icons/AccountCircle';
import InputAdornment from '@material-ui/core/InputAdornment';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import ButtonBase from '@material-ui/core/ButtonBase';
import Button from '@material-ui/core/Button';
import Icon from '@material-ui/core/Icon';
import SaveIcon from '@material-ui/icons/Save';
import AppBar from '@material-ui/core/AppBar';

const styles = theme => ({
    container: {
    //   display: 'flex',
    //   flexWrap: 'wrap',
    },

    root: {
        flexGrow: 1,
        // display: 'flex',
        // flexWrap: 'wrap',
    },

    control: {
        padding: theme.spacing.unit * 2,
    },

    margin: {
        margin: theme.spacing.unit,
    },

    textField: {
      marginLeft: theme.spacing.unit,
      marginRight: theme.spacing.unit,
      width: 200,
    },

    dense: {
      marginTop: 19,
    },

    menu: {
      width: 200,
    },
    /* Layout Style */
    root: {
        flexGrow: 1,
    },

    paper: {
    //padding: theme.spacing.unit * 2,
    margin: 'auto',
    maxWidth: 500,
    },

    image: {
    width: 128,
    height: 128,
    },

    img: {
    margin: 'auto',
    display: 'block',
    maxWidth: '100%',
    maxHeight: '100%',
    },

    /* Button Style */
    button: {
        margin: theme.spacing.unit,
      },

    leftIcon: {
        marginRight: theme.spacing.unit,
    },

    rightIcon: {
        marginLeft: theme.spacing.unit,
    },

    iconSmall: {
        fontSize: 20,
    },
   
  });


const newOrderInfo = [
    {"id":"123", 
    "pickUpLocation": "Gundiy",
    "dropLocation" : "Tambaram",
    "dateOfDeivery" : "2-April-2019",
    "timeOfDeivery" : "8.00 AM",
    "profitToOrgAmt" : "20",
    "profitToDeliMan" : "40"
    }
]


class OrderAccept extends Component {
    state = {  }
    render() { 
        const { classes } = this.props;

        return(  
            <Grid container className={classes.root} spacing={16}>
            <div class="notificationPaper">
                <Paper className={classes.paper}>
                <Typography component="h4" variant="h6" gutterBottom>
                    Service Request for House Shifting
                </Typography>        
                    <ul style={{"list-style": "none"}}>
                    <li>
                    <TextField
                        disabled
                        className={classes.margin}
                        id="label-pick-location"
                        label="Pick Location"
                        defaultValue= {newOrderInfo[0].pickUpLocation}
                        //className={classes.textField}
                        margin="normal">
                    </TextField>
                    </li>
                    <li>
                    <TextField
                        disabled
                        className={classes.margin}
                        id="label-drop-location"
                        label="Drop Location"
                        // InputProps={{
                        // startAdornment: (
                        //     <InputAdornment position="start">
                        //     <AccountCircle />
                        //     </InputAdornment>
                        // ),
                        // }}
                        defaultValue= {newOrderInfo[0].dropLocation}
                        margin="normal">
                    </TextField>
                    </li>
                    <li>
                    <TextField
                        disabled
                        className={classes.margin}
                        id="label-delivery-date"
                        label="Date of Delivery"
                        defaultValue= {newOrderInfo[0].dateOfDeivery} 
                        margin="normal">
                    </TextField>
                    </li>
                    <li>
                    <TextField
                        disabled
                        className={classes.margin}
                        id="label-delivery-time"
                        label="Time of Delivery"
                        defaultValue= {newOrderInfo[0].timeOfDeivery}
                        margin="normal">
                    </TextField>
                    </li>
                    <li>
                    <TextField
                        disabled
                        className={classes.margin}
                        id="label-drop-location"
                        label="Profit Amount "
                        defaultValue= {newOrderInfo[0].profitToDeliMan}
                        margin="normal">
                    </TextField>
                    </li>
                    </ul>
                    
                    <div class="notificationButton">
                    <Button variant="contained" color="primary" className={classes.button}>
                        <Icon className={classNames(classes.leftIcon, classes.iconSmall)}/>Accept
                    </Button>
                    <Button variant="contained" color="primary" className={classes.button}>
                        <Icon className={classNames(classes.rightIcon, classes.iconSmall)}/>Reject
                    </Button>
                    </div>

                </Paper>
            </div>
            </Grid>
    
        );
    }
}
 
OrderAccept.propTypes = {
    classes: PropTypes.object.isRequired,
  };
  
export default withStyles(styles)(OrderAccept);
