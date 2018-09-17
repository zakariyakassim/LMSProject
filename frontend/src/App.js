import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import Footer from './main/Footer';
import Header from './main/Header';
import Home from './home/Home';
import Courses from './course/Courses';
import AddCourse from './addCourse/AddCourse';
import './App.css';

export class App extends React.Component {
    render() {
        return (
                <Router>
				  <React.Fragment>
				    <Header />
				     <Route exact path="/" component = {Home}/>
					 <Route path="/courses" component = {Courses}/>
                     <Route path="/AddCourse" component = {AddCourse}/>
				  <Footer />
				  
                  </React.Fragment>
                </Router>
        );
    }
}

