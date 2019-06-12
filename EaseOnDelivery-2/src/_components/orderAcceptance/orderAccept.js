import React, {Component} from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import TextField from '@material-ui/core/TextField';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import List from '@material-ui/core/List';
import ListItemText from '@material-ui/core/ListItemText';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';

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
    acceptOrder = (type) => {
      console.log("Type is " , type);
      var request = {};
      var url = ""
      if(type == 'ACCEPT'){
        request = {
          bookingID : this.props.state.bookingDetails[0].bookingID,
          providerID : 2,
          bookingTxnStatus : "A",
        }
      }else if(type == 'REJECT'){
        request = {
          bookingID : this.props.state.bookingDetails[0].bookingID,
          providerID : 2,
          bookingTxnStatus : "R",
        }
      }
      this.props.callPostServices(request,url).then(response =>{
        console.log(response)
        if(type == 'ACCEPT'){
          // this.setState({
          //   storePINConfirmed : true,
          //   currentOrderStatus : "Order Picked up, Moving towards Destination"
          // })
        }else if(type == 'REJECT'){
          // this.setState({
          //   customerPINConfirmed : true,
          //   currentOrderStatus : "Order Delivered Successfully.!" 
          // })
        }
      }).catch(error => {
        console.log(error)
      })
    }

    render() { 
        const { classes,state } = this.props;
        return(
          <div>
            {state.bookingDetails.map((value,index) =>(
              <Card key={value.bookingID} className={classes.card + " largeCard "}>
                <List>
                  <br/>
                  <ListItemText className={" listItemReceipt "} primary="Pick Up" secondary={value.pickupLocation} />
                  <ListItemText className={" listItemReceipt "} primary="Drop" secondary={value.dropLocation} />
                  <ListItemText className={" listItemReceipt "} primary="Delivery Date" secondary={value.deliveryDate} />
                  <ListItemText className={" listItemReceipt "} primary="Item Type" secondary={value.itemType} />
                  <ListItemText className={" listItemReceipt "} primary="Tentative Weight" secondary={value.itemTentativeWeight} />
                  <ListItemText className={" listItemReceipt "} primary="Vehicle Type" secondary={value.vehicleType} />
                  <ListItemText className={" listItemReceipt "} primary="Store Person Name" secondary={value.storePersonName} />
                  <ListItemText className={" listItemReceipt "} primary="Store Person No" secondary={value.storePersonContactNo} />
                  <ListItemText className={" listItemReceipt "} primary="Payment Mode" secondary={value.paymentMode} />
                </List>
                  <CardActions className={" confirmButtonAction "}>
                  <Button size="small" color="primary" className="button-lg" 
                    onClick = {this.acceptOrder('ACCEPT')}>
                      ACCEPT BOOKING
                  </Button>
                  <Button size="small" color="primary" className="button-lg" 
                    onClick = {this.acceptOrder('REJECT')}>
                      REJECT BOOKING
                  </Button>
                </CardActions>
              </Card>
            ))}
            
          </div>  
            
        );
    }
}
 
OrderAccept.propTypes = {
    classes: PropTypes.object.isRequired,
  };
  
export default withStyles(styles)(OrderAccept);
