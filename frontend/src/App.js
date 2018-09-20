import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import Footer from './main/Footer';
import Header from './main/Header';
import Home from './home/Home';
import Courses from './course/Courses';
import AddCourse from './addCourse/AddCourse';
import Profile from './profile/Profile';
import Signup from './addUser/Signup';

import './App.css';

export class App extends React.Component {
      constructor() {
        super();
        this.state = {
            "data": null,
        };
    }


    componentDidMount() {
        fetch('http://localhost:8080/api/coursemodule')
            .then(response => response.json())
            .then(data => this.setState({ data }));
    }
    
    render() {
        return (
                <Router>
				  <React.Fragment>
				    <Header />
				     <Route exact path="/" component = {Home}/>
					 <Route path="/courses"  render={(props) => <Courses courses = {this.state.data} isAuthed={true} />}/>
                     <Route path="/AddCourse" component = {AddCourse}/>
					<Route path="/AddUser" component = {Signup}/>
				  <Footer />
				  
                  </React.Fragment>
                </Router>
        );
    }
}

