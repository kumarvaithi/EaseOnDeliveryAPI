import React from 'react';
import { withStyles, withTheme } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import AcceptOrder from './OrderAccept'
import { createMuiTheme,MuiThemeProvider } from '@material-ui/core/styles';
import { red } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import {Link}from 'react-router-dom'
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import TextField from '@material-ui/core/TextField';
import classNames from 'classnames';
import Typography from '@material-ui/core/Typography';

const muiTheme = createMuiTheme({
  palette: {
      primary: {
          main: '#ecebeb',
      },
      secondary: {
          main: '#000',
      },
  },
});

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

class Notifications extends React.Component {
  state = {
    open: true,
    isAccept : false,
    latestColor : "primary",
    acceptColor : "primary",
    deliveredColor : "primary",
    latestVariant : 'contained',
    acceptVariant : 'contained',
    deliveredVariant : 'contained',
    inboxBookingDetails : [],
    latestCardVisible : false,
    cardVisible : false,
    cardButtonVisible : 0, // 0 - Latest 1 - Other
    viewBookingID : 0,
    viewDetailsEnabled : false,
    currentOrderStatus : 'Yet to Pick Order',
    customerPINDisabled : true,
    storePINConfirmed : false,
    customerPINConfirmed : false,
    storePIN : 0,
    customerPIN : 0
  };

  componentDidMount() {
    if(this.props.state.requestFromPopUp === true){
      this.viewBookings(this.props.state.viewBookingID);    
    }else{
      this.getBookings("I");
    }
    this.handleClickOpen('latest');
  }
  
  setStateOnChange = (stateObject) => (e) => {
    this.setState ({ [stateObject] : e.target.value})
  }

  verifyOrderTrackPin = (type) => {
    console.log("just to check")
    console.log("Type is " , type);
    var request = {};
    var url = "/verify/2/"
    if(type == 'S'){
      url = `${url}${this.state.viewBookingID}/${type}/${this.state.storePIN}`
    }else if(type == 'C'){
      url = `${url}${this.state.viewBookingID}/${type}/${this.state.customerPIN}`
    }

    this.props.callGetServices(url).then(response =>{
      console.log("response is " + response)
      let responseData = response.data;
      if(responseData.responseCode == "00"){
        if(type == 'S'){
          this.setState({
            storePINConfirmed : true,
            currentOrderStatus : "Order Picked up, Moving towards Destination",
            customerPINDisabled :false
          })
        }else if(type == 'C'){
          this.setState({
            customerPINConfirmed : true,
            currentOrderStatus : "Order Delivered Successfully.!" 
          })
        }
      }else{
        alert("Incorrect PIN, Please try again using correct pin.");
      }
    }).catch(error => {
      console.log(error)
    })
  }
  acceptOrder = (type) => {
    console.log("inside acceptorder " , type);
    var request = {};
    var url = "accept"
    if(type == 'ACCEPT'){
      request = {
        bookingID : this.state.viewBookingID,
        providerID : 2,
        bookingStatus : "A",
        providerVehicleDetailsID : 0
      }
    }else if(type == 'REJECT'){
      request = {
        bookingID : this.state.viewBookingID,
        providerID : 2,
        bookingStatus : "R",
        providerVehicleDetailsID : 0
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

  viewBookings = (bookingID) => {
    console.log("inside view bookings" + bookingID)
    let url = "view/" + bookingID;
    this.props.callGetServices(url).then(value =>{
      this.setState({
        inboxBookingDetails : value.data.bookingDetails
      })
      console.log("value is " + value.data.bookingDetails)
    }).catch(error =>{
      console.log(error);
    })
  }

  getBookings = (status) => {
    let url = "searchRide/2/" + status;
    this.props.callGetServices(url).then(value =>{
      this.setState({
        inboxBookingDetails : value.data.bookingDetails
      })
      console.log("value is " + value.data.bookingDetails)
    }).catch(error =>{
      console.log(error);
    })
  }

  viewDetails = (viewBookingID) =>{
    console.log("inside View Details" + viewBookingID)
    console.log("Booking Txn Status ", this.state.inboxBookingDetails.length);
    var bookingTxnStatus = "";
    for(var i=0;i<this.state.inboxBookingDetails.length;i++){
      if(this.state.inboxBookingDetails[i].bookingID == viewBookingID){
        if(this.state.inboxBookingDetails[i].bookingStatus == "P"){
          this.setState({
            storePINConfirmed : true,
            currentOrderStatus : "Order Picked up, Moving towards Destination",
            customerPINDisabled :false
          })
        }
      }
    }
    var latestCardVisible = false;
    if(this.state.cardButtonVisible === 0){
      latestCardVisible = true;
    }else{
      latestCardVisible = false;
    }

    this.setState({
      latestCardVisible : latestCardVisible,
      viewBookingID : viewBookingID,
      viewDetailsEnabled : true,
      cardVisible : true
    })
  }

  handleClickOpen = (value) => {
    console.log("value is ", value);
    var latestVariant = "";
    var acceptVariant = "";
    var deliveredVariant = "";
    var latestColor = "";
    var acceptColor = "";
    var deliveredColor = "";
    var cardButtonVisible = 0
    var status = "I";
    if(value == 'latest'){
      latestVariant = "outlined";
      acceptVariant = "contained";
      deliveredVariant = "contained";
      latestColor = "secondary";
      acceptColor = "primary";
      deliveredColor = "primary";
      cardButtonVisible = 0;
      status = "I";
    }else if(value == 'accept'){
      latestVariant = "contained";
      acceptVariant = "outlined";
      deliveredVariant = "contained";
      latestColor = "primary";
      acceptColor = "secondary";
      deliveredColor = "primary";
      cardButtonVisible = 1;
      status = "A";
    }else if(value == 'delivered'){
      latestVariant = "contained";
      acceptVariant = "contained";
      deliveredVariant = "outlined";
      latestColor = "primary";
      acceptColor = "primary";
      deliveredColor = "secondary";
      cardButtonVisible = 1;
      status = "D";
    }

    this.setState({
      isAccept : true,
      latestVariant : latestVariant,
      acceptVariant : acceptVariant,
      deliveredVariant : deliveredVariant,
      latestColor : latestColor,
      acceptColor : acceptColor,
      deliveredColor : deliveredColor,
      cardButtonVisible : cardButtonVisible,
      viewDetailsEnabled : false,
      latestCardVisible : false,
      cardVisible : false
    });
    this.getBookings(status);
  };

  handleClose = () => {
    this.setState({ open: false });
  };

  handleAccept = () =>{
    this.setState({isAccept : true});
    this.handleClose()
  };
  render() {
    const { classes} = this.props;
    return (
      <div>
        {this.props.state.requestFromPopUp ? (
          <div>
            {this.state.inboxBookingDetails.map((value,index) =>(
              <Card key={index} className={classes.card + " largeCard "}>
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
                  <ListItemText className={" listItemReceipt "} primary="Payment Mode" secondary="Cash" />
                </List>
                  <CardActions className={" confirmButtonAction "}>
                  <Button size="small" color="primary" className="button-lg" 
                    onClick={() => this.acceptOrder('ACCEPT')}>
                      ACCEPT BOOKING
                  </Button>
                  <Button size="small" color="primary" className="button-lg" 
                    onClick={() => this.acceptOrder('REJECT')}>
                      REJECT BOOKING
                  </Button>
                </CardActions>
              </Card>
            ))}
          </div>
        ) : (
          <div>
              <MuiThemeProvider theme={muiTheme}>
                <Button variant={this.state.latestVariant} color={this.state.latestColor}  onClick={() => this.handleClickOpen('latest')} className = { "notificationButton" }>
                  Latest
                </Button>
                <Button variant={this.state.acceptVariant} color={this.state.acceptColor} onClick={() => this.handleClickOpen('accept')} className = { "notificationButton" }>
                  Accepted
                </Button>
                <Button variant={this.state.deliveredVariant} color={this.state.deliveredColor} onClick={() => this.handleClickOpen('delivered')} className = { "notificationButton" }>
                  DELIVERED
                </Button>
              </MuiThemeProvider>
              <List>
                {this.state.inboxBookingDetails.length > 0 ? (
                  !this.state.viewDetailsEnabled &&(
                    this.state.inboxBookingDetails.map((value,index) =>(
                      index % 2 === 0 ?(
                        <ListItem key={index} className = { "notificationListOdd" }  onClick={() => this.viewDetails(value.bookingID)}>
                          <ListItemText 
                            primary={`BookingID : ${value.bookingID} : Pickup:  ${value.pickupLocation} - Drop : ${value.dropLocation}`}
                          />
                        </ListItem>
                      ) : (
                        <ListItem key={index} className = { "notificationListEven" } onClick={() => this.viewDetails(value.bookingID)}>
                          <ListItemText
                            primary={`BookingID : ${value.bookingID} : Pickup:  ${value.pickupLocation} - Drop : ${value.dropLocation}`}
                          />
                        </ListItem>
                      )
                    ))
                  )
                ):(
                  <div>Currently Bookings not available</div>
                )} 
                {this.state.inboxBookingDetails.map((value,index) =>(
                  this.state.cardVisible && this.state.viewBookingID === value.bookingID &&(
                    <Card key={index} className={classes.card + " largeCard "}>
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
                        <ListItemText className={" listItemReceipt "} primary="Payment Mode" secondary="Cash" />
                        <ListItemText className={" listItemReceipt "} primary="Current Order Status" secondary={this.state.currentOrderStatus} />
                        <ListItemText className={" listItemReceipt "} primary="" secondary="" />
                        <ListItemText className={" listItemReceipt "} primary="" secondary= " " />
                      </List>
                      
                      {this.state.latestCardVisible ? (
                        // <div class= {" confirmButtonAction "}>
                        //   <button class="button-lg" onClick = {this.acceptOrder('ACCEPT')}> ACCEPT BOOKING</button>
                        //   <button class="button-lg" onClick = {this.acceptOrder('ACCEPT')}> REJECT BOOKING</button>
                        // </div>
                        <CardActions className={" confirmButtonAction "}>
                          
                          
                          <Button size="small" color="primary" className="button-lg" 
                            onClick={() => this.acceptOrder('ACCEPT')}>
                              ACCEPT BOOKING
                          </Button>
                          <Button size="small" color="primary" className="button-lg" 
                            onClick={() => this.acceptOrder('REJECT')}>
                              REJECT BOOKING
                          </Button>
                        </CardActions>
                      ) : (
                        <div>
                          {!this.state.storePINConfirmed && (
                              <Card className={classes.card + " smallCard "}>
                                <Typography gutterBottom variant="h5" component="h2" className={"typography"}>
                                    Verify Store PIN
                                </Typography>
                                  <TextField
                                  className={classNames(classes.margin, classes.textField) + " fields "}
                                  label="Store PIN"
                                  placeholder = "Enter Store PIN"
                                  onChange = {this.setStateOnChange('storePIN')}
                                  />
                                  <CardActions className={" confirmButtonAction "}>
                                    <Button size="small" color="primary" className="button-lg" 
                                      onClick={() => this.verifyOrderTrackPin('S')}>
                                        SUBMIT
                                    </Button>
                                  </CardActions>
                              </Card>
                          )}
                          {!this.state.customerPINConfirmed && (
                              <Card className={classes.card + " smallCard "}>
                                <Typography gutterBottom variant="h5" component="h2" className={"typography"}>
                                  Verify Customer PIN
                                </Typography>
                                <TextField
                                className={classNames(classes.margin, classes.textField) + " fields "}
                                label="Customer PIN"
                                placeholder = "Enter Customer PIN"
                                disabled = {this.state.customerPINDisabled}
                                onChange = {this.setStateOnChange('customerPIN')}
                                />
                                  <CardActions className={" confirmButtonAction "}>
                                    <Button size="small" color="primary" className="button-lg" 
                                      onClick={() => this.verifyOrderTrackPin('C')}>
                                        SUBMIT
                                    </Button>
                                  </CardActions>
                              </Card>
                          )}
                        </div>
                      )}
                    </Card>
                  )
                ))}
              </List>
          </div>
        )}
          
          {/* {this.state.isAccept &&
              <AcceptOrder />
          } */}
      </div>
    );
  }
}

// export default Notifications;
export default withStyles(styles)(Notifications);