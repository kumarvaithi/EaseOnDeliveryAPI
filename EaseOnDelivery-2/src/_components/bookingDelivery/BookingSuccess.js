import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import {MuiThemeProvider} from 'material-ui';
import List from '@material-ui/core/List';
import ListItemText from '@material-ui/core/ListItemText';
import ComponentProgressBar from '../../_commons/ComponentProgressBar'
import LinearProgress from '@material-ui/core/LinearProgress';
const styles = {
  root: {
    flexGrow: 1,
  },
};

class LinearDeterminate extends React.Component {
  state = {
    completed: 0,
    showSuccessPage: false,
    showError : false
  };
  componentDidMount() {
    this.timer = setInterval(this.progress, 2500);
  }

  componentWillUnmount() {
    clearInterval(this.timer);
  }

  progress = () => {
    const { completed } = this.state;
    console.log("Completed value is " + completed);
    if (completed === 100) {
      // if(this.state.showError === true){
        this.setState({ 
          completed: 0 ,
          showSuccessPage: true
        });
      // }else{
      //   this.setState({ 
      //     completed: 0 ,
      //     showSuccessPage: false
      //   });
      // }
        clearInterval(this.timer);

    } else {
      let url = "bookingDetails/" + this.props.values.bookingID;
      this.props.callGetServices(url).then(value =>{
        if(value.data.bookingStatus == "A"){
          this.setState({
            completed : 100,
            showError : false
          })
        }else{
          const diff = Math.random() * 10;
          if(this.state.completed >= 90){
            this.setState(
              { 
                completed: Math.min(completed + diff, 100),
                showError : true
              });
              clearInterval(this.timer);
          }else{
            this.setState(
              { 
                completed: Math.min(completed + diff, 100),
              });
          }
        }
      });
      
    }
  };
   render() {
    const { values,classes } = this.props;
    return (
      <div className = {classes.root}>
        {!this.state.showSuccessPage && !this.state.showError &&
          <div>
              <LinearProgress variant="determinate" value={this.state.completed} className="progress-bar"/>
              <Typography component="h4" variant="h6" gutterBottom>
                  Searching for delivery vehicles
              </Typography>
          </div>
        }
        
        {this.state.showSuccessPage &&
            <Card className={classes.card + " largeCard "}>
                <CardContent >
                  <Typography gutterBottom variant="h5" component="h2" className={"typography"}>
                    Your booking confirmed successfully!!!
                  </Typography>
                </CardContent>
                <List>
                  <br/>
                  <ListItemText className={" listItemReceipt "} primary="Booking ID" secondary={values.bookingID} />
                  <ListItemText className={" listItemReceipt "} primary="Pick Up" secondary={values.pickup} />
                  <ListItemText className={" listItemReceipt "} primary="Drop" secondary={values.drop} />
                  <ListItemText className={" listItemReceipt "} primary="When" secondary={values.when} />
                  <ListItemText className={" listItemReceipt "} primary="Product Type" secondary={values.itemType} />
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
            </Card>    
        }
        {this.state.showError && (
          <Typography component="h4" variant="h6" gutterBottom>
             Sorry !!!, We Treid our level best to find a provider but currently all our providers are serviving, Try booking after sometime.
          </Typography>
        )}  
      </div>
    );
  }
}

LinearDeterminate.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(LinearDeterminate);