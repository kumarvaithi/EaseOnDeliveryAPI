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
    value: 'A',
    label: 'Available',
  },
  {
    value: 'S',
    label: 'Currently Servicing',
  },
  {
    value: 'NA',
    label: 'Not Available',
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

    this.props.callPostServices(request,url).then(response =>{
      console.log("inside provider checkin response ", response)
    }).catch(error =>{
      console.log(error)
    })

  }
  render() {
    const { classes} = this.props;

    return (
      <div className={"boodDeliveryMainDiv"}>
        <div className = {classes.root}>
          <Card className={classes.card + " card "}>
          <CardContent >
              <Typography gutterBottom variant="h5" component="h2" className={"typography"}>
                  Provider Check in
              </Typography>
              {/* <Typography component="p" className="typography1">
                  Assign delivery to us sit back and relax.
              </Typography> */}
          </CardContent>
              <TextField
              className={classNames(classes.margin, classes.textField) + " fields "}
              label="Current Location"
              placeholder = "Enter The Current Location"
              // InputProps={{
              //     startAdornment: <InputAdornment position="start">PICKUP</InputAdornment>,
              // }}
              onChange = {this.handleChange('providerCurrentLocation')}
              />
              <br/>
              <TextField
                select
                className={classNames(classes.margin, classes.textField) + " fields "}
                value={this.state.providerStatus}
                label="Choose Available Status"
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