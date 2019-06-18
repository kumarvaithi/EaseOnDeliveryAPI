import React, { Component} from 'react';
import { BrowserRouter as Router, Route, Link } from  "react-router-dom";
import { white } from 'material-ui/styles/colors';
import { black } from 'material-ui/styles/colors';
import { blue100 } from 'material-ui/styles/colors';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { green100 } from 'material-ui/styles/colors';
import { green500 } from 'material-ui/styles/colors';
import {AppBar,MuiThemeProvider ,List,ListItem,RaisedButton} from 'material-ui';

import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import red from '@material-ui/core/colors/red';
import FavoriteIcon from '@material-ui/icons/Favorite';
import ShareIcon from '@material-ui/icons/Share';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';

const styles = theme => ({
    card: {
      maxWidth: 400,
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
      backgroundColor: red[500],
    },
  });
class BookingHistoryDetails extends Component{
    render(){
        const {bookingDetails, classes } = this.props;
        return(
            <MuiThemeProvider>
            <React.Fragment>
            <div className = {classes.root}>
                
                    <Card className={classes.card + " card "}>
                    <Collapse in={this.state.expanded} timeout="auto" unmountOnExit>
                        <CardContent >
                            <Typography gutterBottom variant="h5" component="h2" className={"typography"}>
                                More Details...
                            </Typography>
                            <List>
                                <ListItem primaryText="Pickup Location" secondaryText={bookingDetails.pickupLocation} />
                                <ListItem primaryText="Drop Location" secondaryText={bookingDetails.dropLocation} />
                                <ListItem primaryText="Delivery Type" secondaryText={bookingDetails.deliveryType} />
                                <ListItem primaryText="Tentative Weight" secondaryText={bookingDetails.tentativeWeight} />
                                <ListItem primaryText="Delivered Date" secondaryText={bookingDetails.deliveredDate} />
                                <ListItem primaryText="Deliver Person Name" secondaryText={bookingDetails.deliverPersonName} />
                                <ListItem primaryText="Deliver Person ContactNo" secondaryText={bookingDetails.deliverPersonContactNo} />
                                <ListItem primaryText="Payment Mode" secondaryText={bookingDetails.paymentMode} />
                                <ListItem primaryText="Vehicle Type" secondaryText= {bookingDetails.vehicleType} />
                                <ListItem primaryText="Vehicle Name" secondaryText= {bookingDetails.vehicleName} />
                                <ListItem primaryText="Vehicle Reg.No" secondaryText= {bookingDetails.vehicleRegNo} />
                            </List>
                        </CardContent>
                        </Collapse>
                    </Card>    
            </div>
        </React.Fragment>
    </MuiThemeProvider>
        )
    }
}
BookingHistoryDetails.propTypes = {
    classes: PropTypes.object.isRequired,
  };

export default withStyles(styles)(BookingHistoryDetails);