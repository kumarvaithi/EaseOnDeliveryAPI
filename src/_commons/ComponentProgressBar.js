import React from "react";
import "react-step-progress-bar/styles.css";
import { ProgressBar } from "react-step-progress-bar";
import LinearProgress from '@material-ui/core/LinearProgress';

class ComponentProgressBar extends React.Component {
      componentDidMount() {
        this.timer = setInterval(this.progress, 500);
      }
    
      componentWillUnmount() {
        clearInterval(this.timer);
      }
    
      progress = () => {
        const { completed } = this.state;
        if (completed === 100) {
          this.setState({ 
              completed: 0 ,
              showSuccessPage: true
            });
        } else {
          const diff = Math.random() * 10;
          this.setState({ completed: Math.min(completed + diff, 100) });
        }
      };
  render() {
    return (
        <LinearProgress variant="determinate" value={this.state.completed} className="progress-bar"/>
    );
  }
}

export default ComponentProgressBar;