import React, {Component} from 'react';
import PropTypes from 'prop-types';

//materia ui
import { withStyles } from '@material-ui/core/styles';
import {withRouter} from 'react-router-dom'
//browser router

//components
// import Dashboard from './_components/landing/Dashboard'
import BookinServices from './BookingServices'
import PartnerServices from './PartnerServices'
import AdminServices from './AdministratorServices'
//reducer
import rootReducer from './rootReducer'

//middleware
import logger from 'redux-logger'
import thunk from 'redux-thunk'

const middleware = [logger,thunk]

const styles = {
  root: {
    flexGrow: 1,
  },
  grow: {
    flexGrow: 1,
  },
  menuButton: {
    marginLeft: -12,
    marginRight: 20,
  },
};

class App extends Component {
  state = {
    auth: true,
    anchorEl: null,
    isPartner: false,
    isAdmin: false
  };

  handleSubmit = values => {
    window.alert(JSON.stringify(values, null, 4));
  };

  handleChange = (stateObject) => (e) => {
    this.setState ({ [stateObject] : e.target.value})
  }

  handleMenu = event => {
    this.setState({ anchorEl: event.currentTarget });
  };

  handleClose = () => {
    this.setState({ anchorEl: null });
  };

//|| this.props.location.pathname === '/partner'
  async componentDidMount(){
      var pathName = this.props.location.pathname;

       if(pathName.indexOf("/partner") >=0){
       this.setState(()=>{
         return{
          isPartner : !this.state.isPartner,
         }
       })
     }else if(pathName.indexOf("/admin") >=0){
       this.setState(()=>{
         return{
          isAdmin : !this.state.isAdmin
         }
       })
     }
   }


  render() {
    const { classes } = this.props;
    const { auth, anchorEl } = this.state;
    const open = Boolean(anchorEl);
    
    return ( 
      <div className={classes.root}>
          {!this.state.isPartner && !this.state.isAdmin && <BookinServices handleChange={this.handleChange} state={this.state}/>}
          {this.state.isPartner && !this.state.isAdmin && <PartnerServices handleChange={this.handleChange} state={this.state}/>}
          {!this.state.isPartner && this.state.isAdmin && <AdminServices state={this.state}/>}
      </div>
    );
  }
}

App.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withRouter(withStyles(styles)(App));