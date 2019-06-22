import React, {Component} from 'react';
import {
    BrowserRouter as Router,
    Link,
    NavLink,
    Route,
    Switch
  } from 'react-router-dom'


const routes = [
    {
        path : "/",
        exact : true,
        sidebar : () => <div>home sidebar!</div>,
        main : () => <div>home main</div>
    },
    {
        path : "/bubblegum",
        exact : false,
        sidebar : () => <div>home sidebar bubblegum!</div>,
        main : () => <div>home main bubblegum</div>
    },
    {
        path : "/test",
        exact : true,
        sidebar : () => <div>home sidebar test!</div>,
        main : () => <div>home main test</div>
    },
];

class SideBar extends Component {
    render() { 
        return (
            <Router>
                <div style = {{display : "flex"}}>
                    <div style = {{padding : "10px", width : "40%", background : "#000000", color:"#ffffff"}}>
                        <ul>
                            <li><Link to = "/">Home</Link></li>
                            <li><Link to = "/bubblegum">Bubble Gum</Link></li>
                            <li><Link to = "/test">Test</Link></li>
                        </ul>{routes.map((route,index) =>(
                                <Route 
                                    key = {index}
                                    path = {route.path}
                                    component = {route.sidebar}
                                    exact = {route.exact}
                                />            
                            ))
                        }
                   </div>
                   <div style = {{flex : 1, padding:"10px"}}>
                        {routes.map((route,index) =>(
                                <Route 
                                    key = {index}
                                    path = {route.path}
                                    component = {route.main}
                                    exact = {route.exact}
                                />            
                        ))
                        }
                   </div>       
            </div>
            </Router>                 
            
        );
    }
}
export default SideBar;