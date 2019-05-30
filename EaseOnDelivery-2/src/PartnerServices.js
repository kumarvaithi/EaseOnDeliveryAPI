import React from 'react';
import PropTypes, { func } from 'prop-types';
import classNames from 'classnames';
import { withStyles } from '@material-ui/core/styles';
import CssBaseline from '@material-ui/core/CssBaseline';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import Badge from '@material-ui/core/Badge';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import NotificationsIcon from '@material-ui/icons/Notifications';
import {partnerMenu} from './menuList';

import {BrowserRouter as Router, Route,Switch, Redirect, Link}from 'react-router-dom'

import BookDelivery from './_components/bookingDelivery/bookDelivery'
import ViewAccount from './_components/profile/viewAccount'
import BookingHistory from './_components/bookingHistory/bookingHistory'
import Reports from './_components/reports/partnerReport'
import AcceptOrder from './_components/orderAcceptance/orderAccept'
import Notifications from './_components/orderAcceptance/Notifications'
import ProviderCheckIn from './_components/checkin/ProviderCheckIn'
import axios from 'axios';

import Dialog from '@material-ui/core/Dialog';
import MuiDialogTitle from '@material-ui/core/DialogTitle';
import MuiDialogContent from '@material-ui/core/DialogContent';
import MuiDialogActions from '@material-ui/core/DialogActions';
import Button from '@material-ui/core/Button';
import CloseIcon from '@material-ui/icons/Close';

import moment from 'moment';

const drawerWidth = 240;

const styles = theme => ({
  root: {
    display: 'flex',
  },
  toolbar: {
    paddingRight: 24, // keep right padding when drawer closed
  },
  toolbarIcon: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end',
    padding: '0 8px',
    ...theme.mixins.toolbar,
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginLeft: 12,
    marginRight: 36,
  },
  menuButtonHidden: {
    display: 'none',
  },
  title: {
    flexGrow: 1,
  },
  drawerPaper: {
    position: 'relative',
    whiteSpace: 'nowrap',
    width: drawerWidth,
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
    backgroundColor: "#f5f5f5"
  },
  drawerPaperClose: {
    overflowX: 'hidden',
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    width: theme.spacing.unit * 7,
    [theme.breakpoints.up('sm')]: {
      width: theme.spacing.unit * 9,
    },
    
  },
  appBarSpacer: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    padding: theme.spacing.unit * 3,
    height: '100vh',
    overflow: 'auto',
  },
  chartContainer: {
    marginLeft: -22,
  },
  tableContainer: {
    height: 320,
  },
  h5: {
    marginBottom: theme.spacing.unit * 2,
  },
});

const DialogTitle = withStyles(theme => ({
  root: {
    borderBottom: `1px solid ${theme.palette.divider}`,
    margin: 0,
    padding: theme.spacing.unit * 2,
  },
  closeButton: {
    position: 'absolute',
    right: theme.spacing.unit,
    top: theme.spacing.unit,
    color: theme.palette.grey[500],
  },
}))(props => {
  const { children, classes, onClose } = props;
  return (
    <MuiDialogTitle disableTypography className={classes.root}>
      <Typography variant="h6">{children}</Typography>
      {onClose ? (
        <IconButton aria-label="Close" className={classes.closeButton} onClick={onClose}>
          <CloseIcon />
        </IconButton>
      ) : null}
    </MuiDialogTitle>
  );
});

const DialogContent = withStyles(theme => ({
  root: {
    margin: 0,
    padding: theme.spacing.unit * 2,
  },
}))(MuiDialogContent);

const DialogActions = withStyles(theme => ({
  root: {
    borderTop: `1px solid ${theme.palette.divider}`,
    margin: 0,
    padding: theme.spacing.unit,
  },
}))(MuiDialogActions);


class BookingServices extends React.Component {
  state = {
    open: true,
    openDialog : true,
    responseData : {},
    bookingDetails : [],
    enableNotification : false
  };

  async componentDidMount() {
    this.getBookingDetails();
    this.timer = setInterval(this.getBookingDetails, 5000);
  }

  handleDrawerOpen = () => {
    this.setState({ open: true });
  };

  handleDrawerClose = () => {
    this.setState({ open: false });
  };

  callPostServices = async (request,url) => {
    url = "http://localhost:8083/provider/" + url
    await axios({
      method: 'post',
      url : url,
      data : request,

    }).then(response => {
      console.log(response);
    }).catch(error =>{
      console.log(error);
    });
  }

  callGetServices = async (url) => {
    url = "http://localhost:8083/provider/" + url
    await axios({
      method: 'get',
      url : url,
   }).then(response => {
    // console.log(response.data);
    let data = response.data;
    this.setState({responseData : data})
    }).catch(error => {
      console.log(error);
    });
  }

  getBookingDetails = () => {
    let url = "searchRide/1/N";
    this.callGetServices(url);
    console.log(this.state.responseData);
    if(this.state.responseData.bookingDetails !== undefined){
      if(this.state.responseData.bookingDetails.length > 0){
        this.setState({
          bookingDetails : this.state.responseData.bookingDetails,
          enableNotification : !this.state.enableNotification
        });
        console.log(this.state.bookingDetails.length);
      }
    }
  }

  handleClose = () => {
    this.setState({ openDialog: false });
  };

  handleAccept = () =>{
    this.handleClose()
  };

  render() {
    const { classes } = this.props;
    const { bookingDetails } = this.state;
    return (
      <div className={classes.root}>
        <CssBaseline />
        <AppBar
          position="absolute"
          className={classNames(classes.appBar, this.state.open && classes.appBarShift) + " toolbar "}
        >
          <Toolbar disableGutters={!this.state.open} className={classes.toolbar}>
            <IconButton
              color="inherit"
              aria-label="Open drawer"
              onClick={this.handleDrawerOpen}
              className={classNames(
                classes.menuButton,
                this.state.open && classes.menuButtonHidden,
              )}
            >
              <MenuIcon />
            </IconButton>
            <Typography
              component="h1"
              variant="h6"
              color="inherit"
              noWrap
              className={classes.title}
            >
              Ease On Delivery Partner App
            </Typography>
            {/* <IconButton color="inherit">
              <Badge badgeContent={4} color="secondary">
                <NotificationsIcon />
              </Badge>
            </IconButton> */}
          </Toolbar>
        </AppBar>
        <Drawer
          variant="permanent"
          classes={{
            paper: classNames(classes.drawerPaper, !this.state.open && classes.drawerPaperClose),
          }}
          className =" own-drawer "
          open={this.state.open}
        >
          <div className={classes.toolbarIcon}>
            <IconButton onClick={this.handleDrawerClose}>
              <ChevronLeftIcon />
            </IconButton>
          </div>
          <Divider />
          <List>{partnerMenu}</List>
        </Drawer>
        <main className="mainDIV">
            <Route exact path='/partner' render= {props=><Notifications callGetServices={this.callGetServices} handleChange={this.props.handleChange} state={this.state}/>}/>
            {/* <Route exact path='/partner/acceptOrder' render= {props=><AcceptOrder handleChange={this.props.handleChange} state={this.state}/>}/> */}
            <Route exact path='/partner/checkin' render= {props=><ProviderCheckIn callPostServices={this.callPostServices} handleChange={this.props.handleChange} state={this.state}/>}/> 

            {/* <Route exact path='/admin/reports' render= {props=><Reports handleChange={this.props.handleChange} state={this.state}/>}/> */}
        </main>
        {this.state.enableNotification && 
          <div>
            {bookingDetails.map((value,index) =>(
              <Dialog
                onClose={this.handleClose}
                aria-labelledby="customized-dialog-title"
                open={this.state.openDialog}
                key = {value.bookingID}
              >    
                <DialogTitle id="customized-dialog-title" onClose={this.handleClose}>
                  {value.itemType} !
                </DialogTitle>
                <DialogContent>
                  <Typography gutterBottom>
                    Pick Up : {value.pickupLocation}
                  </Typography>
                  <Typography gutterBottom>
                    Drop : {value.dropLocation}
                  </Typography>
                  <Typography gutterBottom>
                    Expected Delivery At : {moment(value.deliveryDate).format('DD MMM hh:mm A')}
                  </Typography>
                  </DialogContent>
                <DialogActions className = { "dialogLinks" }>
                  <Link to="/partner/checkin">
                    <Button onClick={this.handleAccept} color="primary">
                      View
                    </Button>
                  </Link>
                  <Button onClick={this.handleClose} color="primary">
                    Close
                  </Button>
                </DialogActions>
              </Dialog>
            ))}
          </div>
        }
        
      </div>
    );
  }
}

BookingServices.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(BookingServices);