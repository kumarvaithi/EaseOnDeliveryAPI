import React, { Component } from 'react';

import { GoogleComponent } from 'react-google-location' 
const API_KEY = "AIzaSyDBr4MmIc2GjDdAaVBGOZrWSLoSHbsGlXk"  // how to get key - step are below

class GooglePlaceDemo extends Component {
    constructor(props) {
      super(props)
      this.state = {
        place: null,
      };
    }
  
    render() {
        console.log("result ", this.state.place);
      return (
        <div >
           <GoogleComponent
           
            apiKey={API_KEY}
            language={'en'}
            country={'country:in|country:us'}
            coordinates={true}
            onChange={(e) => { this.setState({ place: e }) }} />
        </div>
  
      )
    } 
  }
  
  
  export default GooglePlaceDemo;