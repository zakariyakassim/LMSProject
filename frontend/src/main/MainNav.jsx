import React from 'react';

import {Nav, Navbar, NavItem, NavDropdown, MenuItem, Modal, FormGroup, FormControl} from 'react-bootstrap';
import Button from 'react-bootstrap/es/Button';
import {Link} from 'react-router-dom';

import './MainNav.css';

const MainNav =() => {
  return(
  <Navbar id="navigation">
  <Navbar.Brand>
  <Link to="/">QTutorials</Link>
  </Navbar.Brand>
   <Nav pullRight>
    <NavItem eventKey={1} href="/">HOME</NavItem>
	<NavItem  eventKey={2} href="/Courses">COURSES</NavItem>
	<NavDropdown  eventKey="3" title="ACCOUNT" id="nav-dropdown">
          <MenuItem eventKey="3.1">My Profile</MenuItem>
          <MenuItem eventKey="3.3">My Learners</MenuItem>
		  <MenuItem eventKey="3.2">Add Course</MenuItem>
        </NavDropdown>
	<NavItem eventKey={4} href="/">PROFILE</NavItem>
	<NavItem eventKey={5} href="/">LOGIN</NavItem>
   </Nav>
  </Navbar>
	  );
 }
 
export default MainNav;
