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
    value: 'HOUSESHIFTING',
    label: 'HOUSE SHIFTING',
  },
  {
    value: 'OFFICESHIFTING',
    label: 'OFFICE SHIFTING',
  },
  {
    value: 'FRUITSVEG',
    label: 'FRUITS/VEGETABLES BAGGAGE',
  },
  {
    value: 'ELECTRONICITEMS',
    label: 'ELECTRONIC ITEMS',
  },
  {
    value: 'IRONITEMS',
    label: 'IRON ITEMS',
  },
  {
    value: 'CLOTHES',
    label: 'CLOTHES',
  },
  {
    value: 'OTHERS',
    label: 'OTHERS',
  },
];

const transportModeDD = [
  {
    value: 'HOUSESHIFTING',
    label: 'HOUSE SHIFTING',
  },
  {
    value: 'OFFICESHIFTING',
    label: 'OFFICE SHIFTING',
  },
  {
    value: 'FRUITSVEG',
    label: 'FRUITS/VEGETABLES BAGGAGE',
  },
  {
    value: 'ELECTRONICITEMS',
    label: 'ELECTRONIC ITEMS',
  },
  {
    value: 'IRONITEMS',
    label: 'IRON ITEMS',
  },
  {
    value: 'CLOTHES',
    label: 'CLOTHES',
  },
  {
    value: 'OTHERS',
    label: 'OTHERS',
  },
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
    const formattedDate = moment().format('YYYY-MM-DD');
    const formattedTime = moment().format('hh:mm');

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
              // InputProps={{
              //     startAdornment: <InputAdornment position="start">PICKUP</InputAdornment>,
              // }}
              onChange = {handleChange('pickup')}
              />
              <br/>
              <TextField
              label="Drop Location"
              placeholder = "Enter The Drop Location"
              className={classNames(classes.margin, classes.textField) + " fields "}
              // InputProps={{
              //     startAdornment: <InputAdornment position="start">DROP</InputAdornment>,
              // }}
              onChange = {handleChange('drop')}
              />
              <br/>
              <TextField
              select
              className={classNames(classes.margin, classes.textField) + " fields "}
              value={values.when}
              label="Select When"
              // InputProps={{
              //     startAdornment: <InputAdornment position="start">WHEN</InputAdornment>,
              // }}
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
          label="Choose Product Type"
          // InputProps={{
          //     startAdornment: <InputAdornment position="start">PRODUCT TYPE</InputAdornment>,
          // }}
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
            label = "Other Products"
            placeholder = "Enter The Other Products"
            // InputProps={{
            //     startAdornment: <InputAdornment position="start">OTHERS</InputAdornment>,
            // }}
            onChange = {handleChange('otherProducts')}
            />
        }
        {values.productTypeOthersVisible &&
          <br/>
        }
        <TextField
        className={classNames(classes.margin, classes.textField) + " fields "}
        label ="Tentative Weight in Kg's"
        placeholder = "Enter the Weight"
        // InputProps={{
        //     startAdornment: <InputAdornment position="start">TENTATIVE WEIGHT</InputAdornment>,
        //     endAdornment : <InputAdornment position="end">IN KG'S</InputAdornment>,
        // }}
        onChange = {handleChange('tentativeWeight')}
        />
        {/* <TextField
          select
          className={classNames(classes.margin, classes.textField) + " fields "}
          value={values.productType}
          InputProps={{
              startAdornment: <InputAdornment position="start">MODE OF TRANSPORT</InputAdornment>,
          }}
          onChange = {handleChange('productType')}
          >
          
          {transportModeDD.map(option => (
              <MenuItem key={option.value} value={option.value}>
              {option.label}
              </MenuItem>
          ))}
        </TextField> */}
        <TextField
          id="datetime-local"
          label="DELIVERY DATE"
          type="date"
          defaultValue={values.deliveryDate}
          className={classes.manDateTime}
          InputLabelProps={{
            shrink: true,
          }}
          onChange = {handleChange('deliveryDate')}
        />
        <TextField
          id="datetime-local"
          label="DELIVERY TIME "
          type="time"
          defaultValue={values.deliveryTime}
          className={classes.manDateTime}
          InputLabelProps={{
            shrink: true,
          }}
          onChange = {handleChange('deliveryTime')}
        />
        <TextField
          className={classNames(classes.margin, classes.textField) + " fields "}
          label = "Delivery Person"
          placeholder = "Enter The Delivery Person"
          // InputProps={{
          //     startAdornment: <InputAdornment position="start">DELIVERY PERSON</InputAdornment>,
          // }}
          onChange = {handleChange('deliveryPerson')}
        />
        <TextField
          className={classNames(classes.margin, classes.textField) + " fields "}
          label = "Delivery Person Contact No"
          placeholder = "Enter the Delivery Person No"
          // InputProps={{
          //     startAdornment: <InputAdornment position="start">DELIVERY PERSON NO</InputAdornment>,
          // }}
          onChange = {handleChange('deliveryPersonNO')}
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