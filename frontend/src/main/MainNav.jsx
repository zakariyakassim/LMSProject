import React from 'react';

import {Nav, Navbar, NavItem, NavDropdown, MenuItem,} from 'react-bootstrap';

import Login from './Login'

import './MainNav.css';

const MainNav =() => {
  return(
  <Navbar id="navigation">
  <Navbar.Brand>
  <a href="/home">QC Tutorials</a>
  </Navbar.Brand>
   <Nav pullRight>
    <NavItem eventKey={1} href="/home">HOME</NavItem>
	<NavItem  eventKey={2} href="/courses">COURSES</NavItem>
	<NavDropdown  eventKey="3" title="ACCOUNT" id="nav-dropdown">
          <MenuItem eventKey="3.1" href="/trainerProfile">My Profile</MenuItem>
          <MenuItem eventKey="3.3" href="/leaners">My Learners</MenuItem>
		  <MenuItem eventKey="3.2" href="/addCourse">Add Course</MenuItem>
        </NavDropdown>
	<NavItem eventKey={4} href="/learnerProfile">PROFILE</NavItem>
	<NavItem eventKey={5} > <Login/> </NavItem>
   </Nav>
  </Navbar>
	  );
 }
 
export default MainNav;
