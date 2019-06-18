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
  
});

const providerStatusDD = [
  {
    value: 'S',
    label: 'Store PIN',
  },
  {
    value: 'C',
    label: 'Customer PIN',
  }
];


class ProviderCheckIn extends React.Component {
  state = {
    displayProduct : false,
    providerStatus : "",
    providerCurrentLocation : ""
  }
  handleChange = (stateObject) => (e) => {
    this.setState ({ [stateObject] : e.target.value})
  }
  services = e => {
    e.preventDefault();
    console.log("inside services");
    let url = "checkin";
    let request = {
      providerID: "2",
      currentLocation : this.state.providerCurrentLocation,
      providerStatus : this.state.providerStatus
    }
    this.props.callPostServices(request,url);
  }
  render() {
    const { classes} = this.props;

    return (
      <div className={"boodDeliveryMainDiv"}>
        <div className = {classes.root}>
          <Card className={classes.card + " card "}>
          <CardContent >
              <Typography gutterBottom variant="h5" component="h2" className={"typography"}>
                  Verify Stages of Delivery
              </Typography>
              {/* <Typography component="p" className="typography1">
                  Assign delivery to us sit back and relax.
              </Typography> */}
          </CardContent>
              <TextField
                select
                className={classNames(classes.margin, classes.textField) + " fields "}
                value={this.state.providerStatus}
                label="Choose Pin"
                // InputProps={{
                //     startAdornment: <InputAdornment position="start">PRODUCT TYPE</InputAdornment>,
                // }}
                onChange = {this.handleChange('providerStatus')}
                >
                
                {providerStatusDD.map(option => (
                    <MenuItem key={option.value} value={option.value}>
                    {option.label}
                    </MenuItem>
                ))}
              </TextField>
              <br/>
              <TextField
              className={classNames(classes.margin, classes.textField) + " fields "}
              label="Booking ID"
              placeholder = "Enter the Booking ID"
              onChange = {this.handleChange('verifyBookingID')}
              />
              <CardActions>
                <Button size="small" color="primary" className="button-lg" 
                  onClick = {this.services}>
                    SUBMIT
                </Button>
              </CardActions>
        </Card>
        </div>  
      </div>  
    );
  }
}

ProviderCheckIn.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(ProviderCheckIn)