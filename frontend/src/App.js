import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import Footer from './main/Footer';
import Header from './main/Header';
import Home from './home/Home';
import Courses from './course/Courses';


export class App extends React.Component {
    render() {
        return (
                <Router>
				  <React.Fragment>
				    <Header />
				     <Route exact path="/home" component = {Home}/>
					 <Route exact path="/courses" component = {Courses}/>
				  <Footer />
				  
                  </React.Fragment>
                </Router>
        );
    }
}

