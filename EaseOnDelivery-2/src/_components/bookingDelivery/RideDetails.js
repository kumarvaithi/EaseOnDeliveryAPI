import React from 'react';
import classNames from 'classnames';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import MenuItem from '@material-ui/core/MenuItem';
import Typography from '@material-ui/core/Typography';

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
  manDateTime: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: 150,
  }
});

const whenDD = [
  {
    value: 'NOW',
    label: 'NOW',
  },
  {
    value: 'LATER',
    label: 'DELIVER LATER',
  },
];

const itemTypeDD = [
  {
    value: 'GROCERIES',
    label: 'GROCERIES',
  },
  {
    value: 'FRUITSVEG',
    label: 'FRUITS/VEGETABLES BAGGAGE',
  }
];

const transportModeDD = [
  {
    value: 'TWOWHEELER',
    label: 'Two Wheeler',
  },
  {
    value: 'MINITRUCK',
    label: 'MINI TRUCK',
  }
];

class RideDetails extends React.Component {
  state = {
    displayProduct : false
  }
  continue = e => {
    e.preventDefault();
    this.props.sliderHandler();
    this.props.nextStep();
  }

  displayProductDetails = () => {
    this.setState({
      displayProduct : true
    })
  }
  render() {
    const { classes,handleChange,values} = this.props;
    const {displayProduct} = this.state
    
    return (
      <div className={"boodDeliveryMainDiv"}>

        <div className = {classes.root}>
        {!displayProduct ? (
          <Card className={classes.card + " card "}>
          <CardContent >
              <Typography gutterBottom variant="h5" component="h2" className={"typography"}>
                  Make Delivery Easy
              </Typography>
              <Typography component="p" className="typography1">
                  Assign delivery to us sit back and relax.
              </Typography>
          </CardContent>
              <TextField
              className={classNames(classes.margin, classes.textField) + " fields "}
              label="Pick up Location"
              placeholder = "Enter The Pick up Location"
              onChange = {handleChange('pickup')}
              />
              <br/>
              <TextField
              label="Drop Location"
              placeholder = "Enter The Drop Location"
              className={classNames(classes.margin, classes.textField) + " fields "}
              onChange = {handleChange('drop')}
              />
              <br/>
              <TextField
              select
              className={classNames(classes.margin, classes.textField) + " fields "}
              value={values.when}
              label="Select When"
              onChange = {handleChange('when')}
              >
              {whenDD.map(option => (
                  <MenuItem key={option.value} value={option.value}>
                  {option.label}
                  </MenuItem>
              ))}
              </TextField>
          <CardActions>
              <Button size="small" color="primary" className="button-lg" 
                onClick = {this.displayProductDetails}>
                  FIND NOW
              </Button>
          </CardActions>
        </Card>
        ) : (
          <Card className={classes.card + " card "}>
        <TextField
          select
          className={classNames(classes.margin, classes.textField) + " fields "}
          value={values.itemType}
          label="Choose Item Type"
          onChange = {handleChange('itemType')}
          >
          
          {itemTypeDD.map(option => (
              <MenuItem key={option.value} value={option.value}>
              {option.label}
              </MenuItem>
          ))}
        </TextField>
        <br />
        {values.productTypeOthersVisible &&
            <TextField
            className={classNames(classes.margin, classes.textField) + " fields "}
            label = "Other Item"
            placeholder = "Enter The Other Item"
            onChange = {handleChange('otherItems')}
            />
        }
        {values.productTypeOthersVisible &&
          <br/>
        }
        <TextField
        className={classNames(classes.margin, classes.textField) + " fields "}
        label ="Tentative Weight in Kg's"
        placeholder = "Enter the Weight"
        onChange = {handleChange('tentativeWeight')}
        />
        <br/>
        <TextField
          select
          className={classNames(classes.margin, classes.textField) + " fields "}
          value={values.vehicleType}
          label="Choose Vehicle Type"
          onChange = {handleChange('vehicleType')}
          >
          
          {transportModeDD.map(option => (
              <MenuItem key={option.value} value={option.value}>
              {option.label}
              </MenuItem>
          ))}
        </TextField>
        <br/>
        <br/>
        <TextField
          id="datetime-local"
          label="DELIVERY DATE"
          type="date"
          defaultValue={values.deliveryDate}
          className={classes.manDateTime}
          onChange = {handleChange('deliveryDate')}
        />
        
        <TextField
          id="datetime-local"
          label="DELIVERY TIME "
          type="time"
          defaultValue={values.deliveryTime}
          className={classes.manDateTime}
          onChange = {handleChange('deliveryTime')}
        />
        <TextField
          className={classNames(classes.margin, classes.textField) + " fields "}
          label = "Store Person Name"
          placeholder = "Enter The Store Person Name"
          onChange = {handleChange('storePersonName')}
        />
        <TextField
          className={classNames(classes.margin, classes.textField) + " fields "}
          label = "Store Person Contact No"
          placeholder = "Enter the Store Person No"
          onChange = {handleChange('storePersonContactNo')}
        />
        <CardActions>
            <Button size="small" color="primary" className="button-lg" 
              onClick = {this.continue}>
                CONTINUE
            </Button>
        </CardActions>
      </Card>
        )}
        
        </div>
      </div>  
    );
  }
}

RideDetails.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(RideDetails)