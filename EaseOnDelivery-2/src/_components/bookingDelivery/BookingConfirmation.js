import React from 'react';
import classNames from 'classnames';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import InputAdornment from '@material-ui/core/InputAdornment';
import TextField from '@material-ui/core/TextField';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import MenuItem from '@material-ui/core/MenuItem';
import Typography from '@material-ui/core/Typography';
import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'
import moment from 'moment';
import List from '@material-ui/core/List';
import ListItemText from '@material-ui/core/ListItemText';

const styles = theme => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  margin: {
    margin: theme.spacing.unit,
  },
  withoutLabel: {
    marginTop: theme.spacing.unit * 3,
  },
  textField: {
    flexBasis: 200,
  },
  card: {
    maxWidth: 445,
  },
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  manDateTime: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: 200,
  },
  
});

const paymentModeDD = [
  {
    value: 'CASH',
    label: 'CASH ON DELIVERY',
  },
  // {
  //   value: 'CREDIT CARD',
  //   label: 'CREDIT CARD',
  // },
  // {
  //   value: 'DEBIT CARD',
  //   label: 'DEBIT CARD',
  // },
];

class BookingConfirmation extends React.Component {
  continue = e => {
    e.preventDefault();
    this.services();
    this.props.nextStep();
  }

  services = () => {
    console.log("inside services");
    let url = "confirm";
    let request = {
      pickupLocation: this.props.values.pickup,
      dropLocation : this.props.values.drop,
      deliverWhen : this.props.values.when,
      itemType : this.props.values.itemType,
      itemTentativeWeight : this.props.values.tentativeWeight,
      deliveryDate : this.props.values.deliveryDate + ' ' + this.props.values.deliveryTime,
      storePersonName : this.props.values.storePersonName,
      storePersonContactNo : `+91${this.props.values.storePersonContactNo}`,
      vehicleType : this.props.values.vehicleType,
      billAmount : 1000.00,
      vat : 2.00,
      commsion : 10.00,
      totalBillAmount : 1012.00,
      paymentMode : "Cash",
      customerID : 1,
      providerID : 0,
    }
    this.props.callServices(request,url).then(response => {
      this.props.setBookingID(response.data.bookingID);
    }).catch(error => {
      console.log(error);
    })
  }

  render() {
    const { classes,handleChange,values} = this.props;
    return (
      <div className = {classes.root + " boodDeliveryMainDiv "}>      
        {!values.isPaymentModeSelected && (
          <Card className={classes.card + " largeCard "}>    
            <Typography component="h4" variant="h6" gutterBottom>
              Approximate Delivery Charge : 1012 INR. 
            </Typography>
          
            <TextField
              select
              className={classNames(classes.margin, classes.textField) + " confirmFields "}
              value={values.paymentMode}
              label = "Payment Mode"
              // InputProps={{
              //     startAdornment: <InputAdornment position="start">PAYMENT MODE</InputAdornment>,
              // }}
              onChange = {handleChange('paymentMode')}
              >
              {paymentModeDD.map(option => (
                  <MenuItem key={option.value} value={option.value}>
                  {option.label}
                  </MenuItem>
              ))}
            </TextField>
          </Card>
        )}
        {values.isPaymentModeSelected &&(
          <Card className={classes.card + " largeCard "}>    
            <List>
              <br/>
              <ListItemText className={" listItemReceipt "} primary="Pick Up" secondary={values.pickup} />
              <ListItemText className={" listItemReceipt "} primary="Drop" secondary={values.drop} />
              <ListItemText className={" listItemReceipt "} primary="When" secondary={values.when} />
              <ListItemText className={" listItemReceipt "} primary="Item Type" secondary={values.itemType} />
              {this.props.productTypeOthersVisible &&
                  <ListItemText className={" listItemReceipt "} primary="Other Product" secondary={values.otherItems} />
              }
              <ListItemText className={" listItemReceipt "} primary="Tentative Weight" secondary={values.tentativeWeight} />
              <ListItemText className={" listItemReceipt "} primary="Delivery Date" secondary={values.deliveryDate + " " + values.deliveryTime} />
              <ListItemText className={" listItemReceipt "} primary="Vehicle Type" secondary={values.vehicleType} />
              <ListItemText className={" listItemReceipt "} primary="Store Person Name" secondary={values.storePersonName} />
              <ListItemText className={" listItemReceipt "} primary="Store Person No" secondary={values.storePersonContactNo} />
              <ListItemText className={" listItemReceipt "} primary="Payment Mode" secondary={values.paymentMode} />
            </List>
            
              <CardActions className={" confirmButtonAction "}>
                  <Button size="small" color="primary" className="button-sm" 
                    onClick = {this.continue}>
                      CONFIRM BOOKING
                  </Button>
              </CardActions>
            
          </Card>
        )}          
    </div>
    );
  }
}

BookingConfirmation.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(BookingConfirmation)