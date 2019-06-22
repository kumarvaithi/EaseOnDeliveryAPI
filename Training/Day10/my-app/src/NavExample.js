import React, {Component} from 'react';
import {
    BrowserRouter as Router,
    Link,
    NavLink,
    Route,
    Switch
  } from 'react-router-dom'

  const Home = () => (<div><h2>Home</h2></div>)

  const About = () => (<div><h2>About</h2></div>)

  const Topic = ({match}) => (<div><h2>Topic</h2>
  <h3>{match.params.topicID}</h3>
  
  </div>)

  const Topics = ({match}) => {
      return (
          <div>
              <h2>
                  <ul>
                      <li>
                          <Link to={`${match.url}/home`}>
                            Home
                          </Link>
                      </li>
                      <li>
                        <Link to={`${match.url}/about`}>
                            About
                        </Link>
                      </li>
                      
                      
                  </ul>
                  <Route exact  path={`${match.url}/:topicID`} component={Topic}/>
                
              </h2>
          </div>
      )
  }

  class NavExample extends Component {
      render() { 
          return ( 
              <Router>
              
                  <div>
                      <ul>
                          <li><Link to="/">Home</Link></li>
                          <li><Link to="/about">About</Link></li>
                          <li><Link to="/topics">Topics</Link></li>
                      </ul>
                      <Switch>
                        <Route exact path="/" component={Home}/>
                        <Route path="/about" component={About}/>
                        <Route  path="/topics" component={Topics}/>
                      </Switch>
                  </div>
                </Router>
           );
      }
  }
   
  export default NavExample;