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
    showSuccessPage: false
  };
  componentDidMount() {
    this.timer = setInterval(this.progress, 500);
  }

  componentWillUnmount() {
    clearInterval(this.timer);
  }

  progress = () => {
    const { completed } = this.state;
    if (completed === 100) {
      this.setState({ 
          completed: 0 ,
          showSuccessPage: true
        });
    } else {
      const diff = Math.random() * 10;
      this.setState({ completed: Math.min(completed + diff, 100) });
    }
  };
   render() {
    const { values,classes } = this.props;
    return (
      <div className = {classes.root}>
        {!this.state.showSuccessPage &&
          <div>
              <LinearProgress variant="determinate" value={this.state.completed} className="progress-bar"/>
              <Typography component="h4" variant="h6" gutterBottom>
                  Searching for delivery vehicles
              </Typography>
          </div>
        }
        
        {this.state.showSuccessPage &&
            <Card className={classes.card + " largeCard "}>
            
                <List>
                  <br/>
                  <ListItemText className={" listItemReceipt "} primary="Pick Up" secondary={values.pickup} />
                  <ListItemText className={" listItemReceipt "} primary="Drop" secondary={values.drop} />
                  <ListItemText className={" listItemReceipt "} primary="When" secondary={values.when} />
                  <ListItemText className={" listItemReceipt "} primary="Product Type" secondary={values.itemType} />
                  {this.props.productTypeOthersVisible &&
                      <ListItemText className={" listItemReceipt "} primary="Other Product" secondary={values.otherProducts} />
                  }
                  <ListItemText className={" listItemReceipt "} primary="Tentative Weight" secondary={values.tentativeWeight} />
                  <ListItemText className={" listItemReceipt "} primary="Delivery Date" secondary={values.deliveryDate + " " + values.deliveryTime} />
                  <ListItemText className={" listItemReceipt "} primary="Delivey Person" secondary={values.deliveryPerson} />
                  <ListItemText className={" listItemReceipt "} primary="Delivery Person No" secondary={values.deliveryPersonNO} />
                  <ListItemText className={" listItemReceipt "} primary="Payment Mode" secondary={values.paymentMode} />
                </List>
            </Card>    
        }  
      </div>
    );
  }
}

LinearDeterminate.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(LinearDeterminate);