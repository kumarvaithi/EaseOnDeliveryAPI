import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ListSubheader from '@material-ui/core/ListSubheader';
import DashboardIcon from '@material-ui/icons/Dashboard'
import BookIcon from '@material-ui/icons/Book';
import HistoryIcon from '@material-ui/icons/History';
import ForwardIcon from '@material-ui/icons/Forward';
import VerifyIcon from '@material-ui/icons/Check';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import PeopleIcon from '@material-ui/icons/People';
// import ProfileIcon from '@material-ui/icons/Profile'
import BarChartIcon from '@material-ui/icons/BarChart';
import LayersIcon from '@material-ui/icons/Layers';
import AssignmentIcon from '@material-ui/icons/Assignment';
import Notifications from '@material-ui/icons/Notifications';
import Inbox from '@material-ui/icons/Inbox';
import {BrowserRouter as Router, Route,Switch, Redirect, Link}from 'react-router-dom'

export const customerMenu = (
  <div>
    <ListItem button component={Link} to='/book'>
      <ListItemIcon>
        <BookIcon />
      </ListItemIcon>
      <ListItemText primary="Book Delivery" />
    </ListItem>
    <ListItem button component={Link} to='/history'>
      <ListItemIcon>
        <HistoryIcon />
      </ListItemIcon>
      <ListItemText primary="Booking History" />
    </ListItem>
    {/* <ListItem button component={Link} to='/viewAccount'>
      <ListItemIcon>
        <PeopleIcon />
      </ListItemIcon>
      <ListItemText primary="My Account" />
    </ListItem> */}
    {/* <ListItem button>
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="Reports" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <LayersIcon />
      </ListItemIcon>
      <ListItemText primary="Integrations" />
    </ListItem> */}
  </div>
);

export const partnerMenu = (
  <div>
    {/* <ListSubheader inset>Saved reports</ListSubheader> */}
    <ListItem button component={Link} to="/partner">
      <ListItemIcon>
        <Inbox />
      </ListItemIcon>
      <ListItemText primary="Inbox" />
    </ListItem>
    <ListItem button component={Link} to='/partner/checkin'>
      <ListItemIcon>
      <ForwardIcon />
      </ListItemIcon>
      <ListItemText primary="Checkin" />
    </ListItem>
    {/* <ListItem button component={Link} to="/partner/reports">
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="Reports" />
    </ListItem> */}
  </div>
);

export const adminMenu = (
  <div>
    {/* <ListSubheader inset>Saved reports</ListSubheader> */}
    <ListItem button component={Link} to="/admin/reports">
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="Reports" />
    </ListItem>
  </div>
);