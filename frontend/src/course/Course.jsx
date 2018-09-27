
import React, { Component } from 'react';
import './Course.css';
import {Nav, Navbar, NavItem, NavDropdown, MenuItem,Button,FormControl} from 'react-bootstrap';
import courses from './Courses';

const Course = (props) =>{
	this.props = props;
	
	let json = null;
	let modules = [];
	
     this.state = {
            value: "",
            data: null
        }

        return (

            <div className="Course">
			
			<h3>{this.props.modules}</h3>
			
			</div>
			

       
        );
	}




export default Course;