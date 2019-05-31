import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import MuiDialogTitle from '@material-ui/core/DialogTitle';
import MuiDialogContent from '@material-ui/core/DialogContent';
import MuiDialogActions from '@material-ui/core/DialogActions';
import IconButton from '@material-ui/core/IconButton';
import CloseIcon from '@material-ui/icons/Close';
import Typography from '@material-ui/core/Typography';
import AcceptOrder from './orderAccept'

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

class Notifications extends React.Component {
  state = {
    open: true,
    isAccept : false,
  };

  // componentDidMount() {
  //   this.timer = setInterval(this.services, 5000);
  // }

  services = () => {
    console.log("inside services");
    let url = "searchRide/"+1;
    this.props.callGetServices(url);
  }

  handleClickOpen = () => {
    this.setState({
      open: true,
    });
  };

  handleClose = () => {
    this.setState({ open: false });
  };

  handleAccept = () =>{
    this.setState({isAccept : true});
    this.handleClose()
  };
  render() {
    return (
      <div>
        {/* <Button variant="outlined" color="secondary" onClick={this.handleClickOpen}>
          Open dialog
        </Button> */}
        {/* <Dialog
          onClose={this.handleClose}
          aria-labelledby="customized-dialog-title"
          open={this.state.open}
        >
          <DialogTitle id="customized-dialog-title" onClose={this.handleClose}>
            House Shifting !
          </DialogTitle>
          <DialogContent>
            <Typography gutterBottom>
              Pick Up : Guindy 
              <br/>
              Drop : Tambaram
            </Typography>
            <Typography gutterBottom>
              Expected Delivery Time is 08:00 AM
            </Typography>
            </DialogContent>
          <DialogActions>
            <Button onClick={this.handleAccept} color="primary">
              Accept
            </Button>
            <Button onClick={this.handleClose} color="primary">
              Cancel
            </Button>
          </DialogActions>
        </Dialog> */}
        {this.state.isAccept &&
            <AcceptOrder />
        }
      </div>
    );
  }
}

export default Notifications;