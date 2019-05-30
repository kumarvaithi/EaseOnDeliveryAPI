import React from 'react';
import PropTypes from 'prop-types';
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
import { customerMenu, secondaryListItems } from './menuList';

import {BrowserRouter as Router, Route,Switch, Redirect, Link}from 'react-router-dom'

import BookDelivery from './_components/bookingDelivery/bookDelivery'
import ViewAccount from './_components/profile/viewAccount'
import BookingHistory from './_components/bookingHistory/bookingHistory'
import axios from 'axios';

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

class BookingServices extends React.Component {
  state = {
    open: false,
  };

  handleDrawerOpen = () => {
    this.setState({ open: true });
  };

  handleDrawerClose = () => {
    this.setState({ open: false });
  };

  callServices = async (request,url) => {
    console.log("request is ", request)
    url = "http://localhost:8081/bookings/" + url
    await axios({
      method: 'post',
      url : url,
      data : request,

    }).then(response =>{
      console.log(response);
    }).catch(error =>{
      console.log(error);
    });
  }

  callGetServices = async (url) => {
    console.log("url is ", url)
    url = "http://localhost:8081/bookings/" + url
    const response = await axios.get(url);
    console.log(response);
    return response;
    // await axios({
    //   method: 'get',
    //   url : url,
    // }).then(response =>{
    //   console.log(response);
    //   return response;
    // }).catch(error =>{
    //   console.log(error);
    // });
  }

  render() {
    const { classes } = this.props;

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
              Ease On Delivery
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
          <List>{customerMenu}</List>
        </Drawer>
        <main className="mainDIV">
            <Route exact path='/' render= {props=><BookDelivery callServices = {this.callServices} handleChange={this.props.handleChange} state={this.state}/>}/>
            <Route path='/book' render= {props=><BookDelivery callServices = {this.callServices} handleChange={this.props.handleChange} state={this.state}/>}/>
            {/* <Route path='/history' authed={this.state.authed} callGetServices = {this.callGetServices} callServices = {this.callServices} handleChange={this.props.handleChange} component={BookingHistory}/> */}
            <Route path='/history' render = {props=><BookingHistory callGetServices = {this.callGetServices} callServices = {this.callServices} handleChange={this.props.handleChange} state={this.state}/>}/>
            <Route path='/viewAccount' authed={this.state.authed} callServices = {this.callServices} component={ViewAccount}/>
        </main>
      </div>
    );
  }
}

BookingServices.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(BookingServices);