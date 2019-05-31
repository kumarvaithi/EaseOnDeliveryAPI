import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Stepper from '@material-ui/core/Stepper';
import Step from '@material-ui/core/Step';
import StepLabel from '@material-ui/core/StepLabel';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

import RideDetails from './RideDetails';

import BookingConfirmation from './BookingConfirmation'
import BookingSuccess from './BookingSuccess'

import Slider from 'react-animated-slider';
import horizontalCss from 'react-animated-slider/build/horizontal.css';
import content from '../../_commons/ui-config'
import moment from 'moment';

const styles = theme => ({
  root: {
    width: '100%',
    height: '100%',
  },
  button: {
    marginRight: theme.spacing.unit,
  },
  instructions: {
    marginTop: theme.spacing.unit,
    marginBottom: theme.spacing.unit,
  },
});

function getSteps() {
  return ['Initiate Booking', 'Booking Confirmation', 'Order Accepted'];
}

class BookDelivery extends React.Component {
  state = {
    activeStep: 0,
    skipped: new Set(),
    loading : false,
    pickup : "",
    drop : "",
    when : "",
    productComponentVisible : false,
    itemType :"",
    vehicleType : "",
    productTypeOthersVisible : false,
    otherItems: "",
    tentativeWeight: "",
    deliveryDate: "",
    deliveryTime: "",
    storePersonName: "",
    storePersonContactNo: "",
    paymentMode:"",
    showSlider: true,
    isPaymentModeSelected: false
  };

  async componentDidMount(){
    const formattedDate = moment().format('YYYY-MM-DD');
    const formattedTime = moment().format('HH:mm');
    this.setState(()=>{
      return{
        deliveryDate : formattedDate,
        deliveryTime : formattedTime
      }
    })
  }

  // isStepOptional = step => step === 1;

  nextStep = () => {
    const { activeStep } = this.state;
    let { skipped } = this.state;
    
    if (this.isStepSkipped(activeStep)) {
      skipped = new Set(skipped.values());
      skipped.delete(activeStep);
    }
    this.setState({
      activeStep: activeStep + 1,
      skipped,
    });
  };

  handleBack = () => {
    this.setState(state => ({
      activeStep: state.activeStep - 1,
    }));
  };

  handleSkip = () => {
    const { activeStep } = this.state;
    if (!this.isStepOptional(activeStep)) {
      // You probably want to guard against something like this,
      // it should never occur unless someone's actively trying to break something.
      throw new Error("You can't skip a step that isn't optional.");
    }

    this.setState(state => {
      const skipped = new Set(state.skipped.values());
      skipped.add(activeStep);
      return {
        activeStep: state.activeStep + 1,
        skipped,
      };
    });
  };

  handleReset = () => {
    this.setState({
      activeStep: 0,
    });
  };

  isStepSkipped(step) {
    return this.state.skipped.has(step);
  }

  handleChange = (stateObject) => (e) => {
    this.setState ({ [stateObject] : e.target.value})
    if(e.target.value == "OTHERS"){
      this.setState(() =>{
        return{
          productTypeOthersVisible : true
        }
      })
    }else{
      this.setState(() =>{
        return{
          productTypeOthersVisible : false
        }
      })
    }
    if(stateObject === "paymentMode"){
      this.setState(() =>{
        return{
          isPaymentModeSelected : true
        }
      })
    }
  }

  sliderHandler = () =>{
    this.setState(() => {
      return{
        showSlider : false
      }
    })
  }

  getStepContent = () =>{
    const {activeStep} = this.state;
    switch(activeStep){
      case 0:
      return ( 
          <RideDetails
          nextStep = {this.nextStep}
          handleChange = {this.handleChange}
          values = {this.state}
          sliderHandler = {this.sliderHandler}/>
      );
      // case 1:
      // return ( 
      //   <ProductDetails
      //   nextStep = {this.nextStep}
      //   handleChange = {this.handleChange}
      //   values = {this.state}/>
      // );
      case 1:
      return ( 
        <BookingConfirmation
        callServices = {this.props.callServices}
        nextStep = {this.nextStep}
        handleChange = {this.handleChange}
        values = {this.state}/>
      );
      case 2:
      return ( 
          <BookingSuccess
          values = {this.state}
          handleChange = {this.handleChange}/>
      );
    }        
  }
  render() {
    const { classes } = this.props;
    const steps = getSteps();
    const { activeStep } = this.state;

    return (
      <div className={classes.root}>
        <Stepper activeStep={activeStep} className={"stepper-main-div"}>
          {steps.map((label, index) => {
            const props = {};
            const labelProps = {};
            // if (this.isStepOptional(index)) {
            //   labelProps.optional = <Typography variant="caption">Optional</Typography>;
            // }
            if (this.isStepSkipped(index)) {
              props.completed = false;
            }
            return (
              <Step key={label} {...props}>
                <StepLabel {...labelProps}>{label}</StepLabel>
              </Step>
            );
          })}
        </Stepper>
        {this.state.showSlider && (
          <div className={"sliderDiv"}>
          <Slider classNames={horizontalCss} autoplay={10000}>
              {content.map((item, index) => (
              <div
              key={index}
              style={{ background: `url('${item.image}') no-repeat center center`}}
              className = {"sliderBackgroundDiv"}
              >
              {/* <div className="center">
              <h1>{item.title}</h1>
              <p>{item.description}</p>
              <button>{item.button}</button>
              </div> */}
              </div>
              ))}
          </Slider>
        </div>
        )}
        
        <div>
          {activeStep === steps.length ? (
            <div>
              {/* <Typography className={classes.instructions}>
                All steps completed - you&apos;re finished
              </Typography>
              <Button onClick={this.handleReset} className={classes.button}>
                Reset
              </Button> */}
            </div>
          ) : (
            <div className={"booking-forms-block"}>
              {this.getStepContent()}
              {/* <div> */}
                {/* <Button
                  disabled={activeStep === 0}
                  onClick={this.handleBack}
                  className={classes.button}
                >
                  Back
                </Button> */}
                {/* {this.isStepOptional(activeStep) && (
                  <Button
                    variant="contained"
                    color="primary"
                    onClick={this.handleSkip}
                    className={classes.button}
                  >
                    Skip
                  </Button>
                )} */}
                {/* <Button
                  variant="contained"
                  color="primary"
                  onClick={this.nextStep}
                  className={classes.button}
                >
                  {activeStep === steps.length - 1 ? 'Finish' : 'Next'}
                </Button> */}
              {/* </div> */}
            </div>
          )}
        </div>
      </div>
    );
  }
}

BookDelivery.propTypes = {
  classes: PropTypes.object,
};

export default withStyles(styles)(BookDelivery);