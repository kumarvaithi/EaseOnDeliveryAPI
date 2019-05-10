import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableFooter from '@material-ui/core/TableFooter';
import TableHead from '@material-ui/core/TableHead';
import TablePagination from '@material-ui/core/TablePagination';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import IconButton from '@material-ui/core/IconButton';
import FirstPageIcon from '@material-ui/icons/FirstPage';
import KeyboardArrowLeft from '@material-ui/icons/KeyboardArrowLeft';
import KeyboardArrowRight from '@material-ui/icons/KeyboardArrowRight';
import LastPageIcon from '@material-ui/icons/LastPage';

const CustomTableCell = withStyles(theme => ({
  head: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 14,
  },
}))(TableCell);

const actionsStyles = theme => ({
  root: {
    flexShrink: 0,
    color: theme.palette.text.secondary,
   // marginTop: theme.spacing.unit * 5,
    marginLeft: theme.spacing.unit * 5,
  },
});

class TablePaginationActions extends React.Component {
  handleFirstPageButtonClick = event => {
    this.props.onChangePage(event, 0);
  };

  handleBackButtonClick = event => {
    this.props.onChangePage(event, this.props.page - 1);
  };

  handleNextButtonClick = event => {
    this.props.onChangePage(event, this.props.page + 1);
  };

  handleLastPageButtonClick = event => {
    this.props.onChangePage(
      event,
      Math.max(0, Math.ceil(this.props.count / this.props.rowsPerPage) - 1),
    );
  };

  render() {
    const { classes, count, page, rowsPerPage, theme } = this.props;

    return (
      <div className={classes.root}>
        <IconButton
          onClick={this.handleFirstPageButtonClick}
          disabled={page === 0}
          aria-label="First Page"
        >
          {theme.direction === 'rtl' ? <LastPageIcon /> : <FirstPageIcon />}
        </IconButton>
        <IconButton
          onClick={this.handleBackButtonClick}
          disabled={page === 0}
          aria-label="Previous Page"
        >
          {theme.direction === 'rtl' ? <KeyboardArrowRight /> : <KeyboardArrowLeft />}
        </IconButton>
        <IconButton
          onClick={this.handleNextButtonClick}
          disabled={page >= Math.ceil(count / rowsPerPage) - 1}
          aria-label="Next Page"
        >
          {theme.direction === 'rtl' ? <KeyboardArrowLeft /> : <KeyboardArrowRight />}
        </IconButton>
        <IconButton
          onClick={this.handleLastPageButtonClick}
          disabled={page >= Math.ceil(count / rowsPerPage) - 1}
          aria-label="Last Page"
        >
          {theme.direction === 'rtl' ? <FirstPageIcon /> : <LastPageIcon />}
        </IconButton>
      </div>
    );
  }
}

TablePaginationActions.propTypes = {
  classes: PropTypes.object.isRequired,
  count: PropTypes.number.isRequired,
  onChangePage: PropTypes.func.isRequired,
  page: PropTypes.number.isRequired,
  rowsPerPage: PropTypes.number.isRequired,
  theme: PropTypes.object.isRequired,
};

const TablePaginationActionsWrapped = withStyles(actionsStyles, { withTheme: true })(
  TablePaginationActions,
);

let counter = 0;
function createData(month, custName, deliDate, areaName, status) {
  counter += 1;
  return { id: counter, month, custName, deliDate, areaName, status };
}

const styles = theme => ({
  root: {
    width: '100%',
    marginTop: theme.spacing.unit * 3,
  },
  table: {
    minWidth: 500,
  },
  tableWrapper: {
    overflowX: 'auto',
    marginTop: '60px'
  },
});

class CustomPaginationActionsTable extends React.Component {
  state = {
    rows: [
      createData('Jan', 'Kumar', '2-Jan-19', 'Ashok Nagar', 'On Time delivered'),
      createData('Jan', 'Syed', '6-Jan-19', 'T Nagar', 'Delayed'),
      createData('Jan', 'Krishna', '15-Jan-19', 'Pour', 'On Time delivred'),
      createData('Jan', 'Vijay', '25-Jan-19', 'Pour', 'On Time delivred'),
      createData('Feb', 'Raju', '4-Feb-19', 'T Nagar', 'On Time delivred'),
      createData('Feb', 'Sathish', '8-Feb-19', 'Pour', 'On Time delivred'),
      createData('Feb', 'Sankar', '14-Feb-19', 'Guindy', 'On Time delivred'),
      createData('Feb', 'Karthik', '26-Feb-19', 'Pour', 'Delayed'),
      createData('Mar', 'Venu', '5-Mar-19', 'Ashok Nagar', 'On Time delivred'),
      createData('Mar', 'Mani', '14-Mar-19', 'KK Nagar', 'On Time delivred'),
      createData('Mar', 'Rangan', '18-Mar-19', 'Pour', 'On Time delivred'),
      createData('Mar', 'Bharathi', '24-Mar-19', 'Guindy', 'On Time delivred'),
      createData('MAr', 'Sundar', '29-Mar-19', 'Pour', 'On Time delivred'),
    ].sort((a, b) => (a.custName < b.custName ? -1 : 1)),
    page: 0,
    rowsPerPage: 5,
  };

  handleChangePage = (event, page) => {
    this.setState({ page });
  };

  handleChangeRowsPerPage = event => {
    this.setState({ page: 0, rowsPerPage: event.target.value });
  };

  render() {
    const { classes } = this.props;
    const { rows, rowsPerPage, page } = this.state;
    const emptyRows = rowsPerPage - Math.min(rowsPerPage, rows.length - page * rowsPerPage);

    return (
      <Paper className={classes.root}>
        <div className={classes.tableWrapper}>
          <Table className={classes.table}>
            <TableHead>
                <TableRow >
                    <CustomTableCell>Month</CustomTableCell>
                    <CustomTableCell align="right">Customer Name</CustomTableCell>
                    <CustomTableCell align="right">Delivered Date</CustomTableCell>
                    <CustomTableCell align="right">Areas Details</CustomTableCell>
                    <CustomTableCell align="right">Status</CustomTableCell>
                </TableRow>
            </TableHead>

            <TableBody>
              {rows.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map(row => (
                <TableRow key={row.id}>
                  <TableCell component="th" scope="row">{row.month}</TableCell>
                  <TableCell align="right">{row.custName}</TableCell>
                  <TableCell align="right">{row.deliDate}</TableCell>
                  <TableCell align="right">{row.areaName}</TableCell>
                  <TableCell align="right">{row.status}</TableCell>
                </TableRow>
              ))}
              {emptyRows > 0 && (
                <TableRow style={{ height: 48 * emptyRows }}>
                  <TableCell colSpan={6} />
                </TableRow>
              )}
            </TableBody>
            <TableFooter>
              <TableRow>
                <TablePagination
                  rowsPerPageOptions={[5, 10, 25]}
                  colSpan={6}
                  count={rows.length}
                  rowsPerPage={rowsPerPage}
                  page={page}
                  SelectProps={{
                    native: true,
                  }}
                  onChangePage={this.handleChangePage}
                  onChangeRowsPerPage={this.handleChangeRowsPerPage}
                  ActionsComponent={TablePaginationActionsWrapped}
                />
              </TableRow>
            </TableFooter>
          </Table>
        </div>
      </Paper>
    );
  }
}

CustomPaginationActionsTable.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(CustomPaginationActionsTable);
