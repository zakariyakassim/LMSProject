import React from 'react';

import {Nav, Navbar, NavItem, NavDropdown, MenuItem, Modal, FormGroup, FormControl} from 'react-bootstrap';
import Button from 'react-bootstrap/es/Button';

const MainNav =() => {
  return(
   <Nav>
    <NavItem eventKey={1} className="pullRight" href="/">HOME</NavItem>
	<NavItem eventKey={2} className="pullRight" href="/">COURSES</NavItem>
	<NavDropdown eventKey="3" title="ACCOUNT" id="nav-dropdown">
          <MenuItem eventKey="3.1">My Profile</MenuItem>
          <MenuItem eventKey="3.2">ADD COURSE</MenuItem>
          <MenuItem eventKey="3.3">My Learners</MenuItem>
          <MenuItem divider />
          <MenuItem eventKey="4.4">Separated link</MenuItem>
        </NavDropdown>
	<NavItem eventKey={4} className="pullRight" href="/">PROFILE</NavItem>
	<NavItem eventKey={5} className="pullRight" href="/">LOGIN</NavItem>
	 
   </Nav>
	  );
 }
 
export default MainNav;
