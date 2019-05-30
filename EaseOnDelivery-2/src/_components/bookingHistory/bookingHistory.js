import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
 
import {
    Accordion,
    AccordionItem,
    AccordionItemHeading,
    AccordionItemPanel,
    AccordionItemButton
} from 'react-accessible-accordion';
 
// Demo styles, see 'Styles' section below for some notes on use.
import 'react-accessible-accordion/dist/fancy-example.css';
import { grey100 } from 'material-ui/styles/colors';

const styles = theme => ({
    card: {
      maxWidth: '80%',
      paddingLeft : '100',
    },
    media: {
      height: 0,
      paddingTop: '56.25%', // 16:9
    },
    actions: {
      display: 'flex',
    },
    expand: {
      transform: 'rotate(0deg)',
      marginLeft: 'auto',
      transition: theme.transitions.create('transform', {
        duration: theme.transitions.duration.shortest,
      }),
    },
    expandOpen: {
      transform: 'rotate(180deg)',
    },
    avatar: {
      backgroundColor: grey100,
    },
  });
// let bookingHistoryDetails = [];
// let bookingHistoryDetails = [
//     {
//         bookingID : "1"
//         ,path : "/history/1"
//         ,exact : true
//         ,bookingDate : "Apr 01 2019"
//         ,pickupLocation : "DLF"
//         ,dropLocation : "Guindy"
//         ,deliveryCharge : "1000.00"
//         ,typeOfVehicle : "Auto"
//         ,deliveryType : "ELECTRONIC ITEMS"
//         ,tentativeWeight : "100 Kg"
//         ,deliveredDate : "Apr 01 2019"
//         ,deliverPersonName : "Kumar"
//         ,deliverPersonContactNo : "987998989"
//         ,paymentMode : "Cash"
//         ,vehicleType : "Four Wheeler"
//         ,vehicleName : "Mahindra"
//         ,vehicleRegNo : "TN 01 1234"
//     },
//     {
//         bookingID : "2"
//         ,path : "/history/2"
//         ,exact : true
//         ,bookingDate : "Mar 01 2019"
//         ,pickupLocation : "Meenampakkam"
//         ,dropLocation : "Tambaram"
//         ,deliveryCharge : "1000.00"
//         ,deliveryType : "CLOTH ITEMS"
//         ,tentativeWeight : "100 Kg"
//         ,deliveredDate : "Mar 01 2019"
//         ,deliverPersonName : "Syed"
//         ,deliverPersonContactNo : "98768787"
//         ,paymentMode : "Cash"
//         ,vehicleType : "Two Wheeler"
//         ,vehicleName : "Pulsar"
//         ,vehicleRegNo : "TN 01 PUL1234"
//     },
//     {
       
//         bookingID : "3"
//         ,path : "/history/3"
//         ,exact : true
//         ,bookingDate : "Feb 01 2019"
//         ,pickupLocation : "Egmore"
//         ,dropLocation : "Tambaram"
//         ,deliveryCharge : "1000.00"
//         ,deliveryType : "HOUSE ITEMS"
//         ,tentativeWeight : "100 Kg"
//         ,deliveredDate : "Feb 01 2019"
//         ,deliverPersonName : "Sathya"
//         ,deliverPersonContactNo : "986767676"
//         ,paymentMode : "Cash"
//         ,vehicleType : "Four Wheeler"
//         ,vehicleName : "Mini Auto"
//         ,vehicleRegNo : "TN 01 MA1234"

//     },
//     {
//         bookingID : "4"
//         ,path : "/history/4"
//         ,exact : true
//         ,bookingDate : "Jan 01 2019"
//         ,pickupLocation : "Pallavaram"
//         ,dropLocation : "DLF"
//         ,deliveryCharge : "1000.00"
//         ,deliveryType : "ELECTRONIC ITEMS"
//         ,tentativeWeight : "100 Kg"
//         ,deliveredDate : "Mar 01 2019"
//         ,deliverPersonName : "Karthick"
//         ,deliverPersonContactNo : "987998989"
//         ,paymentMode : "Cash"
//         ,vehicleType : "Four Wheeler"
//         ,vehicleName : "Mahindra"
//         ,vehicleRegNo : "TN 01 MA1234"
//     }
// ];

class BookingHistory extends React.Component {

  state = {
    bookingHistoryDetails : []
  }

  async componentDidMount(){
    this.getBookingHistory();
  }

  getBookingHistory = () => {
    let url = "history/1";
    this.props.callGetServices(url).then(value =>{
      console.log("value is " + value.data.historyList.length)
      this.setState({
        bookingHistoryDetails : value.data.historyList
      })
    });
  }
    render(){
      console.log("bookingHistoryDetails is " + this.state.bookingHistoryDetails.length);

        const {classes} = this.props
        return (
            <div className={classes.card + " historyCard "}>
                {this.state.bookingHistoryDetails.map((value, index)=>(
                    <Accordion allowZeroExpanded = 'true' >
                    <AccordionItem>
                        <AccordionItemHeading>
                            <AccordionItemButton>
                            {value.bookingDate} 
                            </AccordionItemButton>
                        </AccordionItemHeading>
                        <AccordionItemPanel className={classes.avatar}>
                            <p>
                                <ul>
                                    <li>
                            Delivery Type : {value.deliveryType}
                                <br/>
                                Tentative Weight : {value.tentativeWeight}
                                <br/>
                                Delivered Date :   {value.deliveredDate}
                                <br/>
                                {/* Deliver Person Name : {anything.deliverPersonName}
                                <br/>
                                Deliver Person ContactNo : {anything.deliverPersonContactNo}
                                <br/>
                                Payment Mode : {anything.paymentMode}
                                <br/>
                                Vehicle Type : {anything.vehicleType}
                                <br/>
                                Vehicle Name : {anything.vehicleName}
                                <br/>
                                Vehicle Reg.No : {anything.vehicleRegNo}*/}
                                </li> 
                                </ul>
                            </p>
                        </AccordionItemPanel>
                    </AccordionItem>
                </Accordion>
                ))}
            </div>
            
        );

    }
}
 
BookingHistory.propTypes = {
    classes: PropTypes.object.isRequired,
  };
  
  export default withStyles(styles)(BookingHistory);