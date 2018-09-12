import React from 'react';

import {Nav, Navbar, NavItem, NavDropdown, MenuItem, Modal, FormGroup, FormControl} from 'react-bootstrap';
import Button from 'react-bootstrap/es/Button';

import './MainNav.css';

const MainNav =() => {
  return(
  <Navbar id="navigation">
  <Navbar.Brand>
  <a href="/">QTutorials</a>
  </Navbar.Brand>
   <Nav pullRight>
    <NavItem className="pageLink" eventKey={1} href="/">HOME</NavItem>
	<NavItem className="pageLink" eventKey={2} href="/">COURSES</NavItem>
	<NavDropdown className="pageLink" eventKey="3" title="ACCOUNT" id="nav-dropdown">
          <MenuItem eventKey="3.1">My Profile</MenuItem>
          <MenuItem eventKey="3.3">My Learners</MenuItem>
		  <MenuItem eventKey="3.2">Add Course</MenuItem>
        </NavDropdown>
	<NavItem className="pageLink" eventKey={4} href="/">PROFILE</NavItem>
	<NavItem eventKey={5} href="/">LOGIN</NavItem>
   </Nav>
  </Navbar>
  
  <div className="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden = "true">
   <div className="modal-dialog" role="document">
     <div className="modal-content">
       <div className="modal-header text-center">
         <h4 className="modal-title w-100 font-weight-bold">Login</h4>
          <button type="button" className="close" data-dismiss="modal" aria-label ="Close">
             <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div className="modal-body mx-3">
           <div className="md-form mb-5">
              <i className="fa fa-user prefix grey-text"></i>
			  <input type ="text" id="username" className="form-control validate">
			 </div>
			</div> 
			</div>
			</div> 
			</div>
			</div> 
			</div>
  
	  );
 }
 
export default MainNav;
