import React from 'react';

import {Nav, Navbar, NavItem, NavDropdown, MenuItem,Button,FormControl} from 'react-bootstrap';

import Login from './Login'

import './MainNav.css';

const MainNav =() => {
  return(
  <Navbar id="navigation">
   <Navbar.Brand >
   <Nav pullLeft className="site-name" >
     <a href="/"> QC Tutorials</a>
  </Nav>
   </Navbar.Brand>
   <Nav pullRight>
	  <NavItem><Login/></NavItem>
    </Nav>
   <Nav pullRight>
    <NavItem eventKey={1} href="/">HOME</NavItem>
	<NavItem  eventKey={2} href="/courses">COURSES</NavItem>
	<NavDropdown  eventKey="3" title="ACCOUNT" id="nav-dropdown">
		  <MenuItem href="/AddCourse" id="add-course">Add Course</MenuItem>
    </NavDropdown>
    </Nav>
	<Nav className="Search">
	 
	</Nav>
  </Navbar>
	  );
 }
 
export default MainNav;
