import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import Footer from './main/Footer';
import Header from './main/Header';
import Home from './home/Home';
import Courses from './course/Courses';
import AddCourse from './addCourse/AddCourse';
import Profile from './profile/Profile';

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
					<Route path="/Profile" component = {Profile}/>
				  <Footer />
				  
                  </React.Fragment>
                </Router>
        );
    }
}

