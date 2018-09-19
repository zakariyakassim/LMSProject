import React from "react";
import {BrowserRouter as Router, Route} from "react-router-dom";
import logo from './logo.svg';
import './App.css';
import {AddAccount} from './Components/AddAccount'
import {Nav, Navbar, NavItem, NavDropdown, MenuItem, Modal, FormGroup, FormControl} from 'react-bootstrap';

import axios from 'axios';
import NavLink from "react-router-dom/es/NavLink";
import OverlayTrigger from "react-bootstrap/es/OverlayTrigger";
import Popover from "react-bootstrap/es/Popover";
import Tooltip from "react-bootstrap/es/Tooltip";
import Button from "react-bootstrap/es/Button";
import {ViewDVDs} from "./Components/ViewDVDs";

export class App extends React.Component {

    constructor(props, context) {
        super(props, context);

        this.handleShow = this.handleShow.bind(this);
        this.handleClose = this.handleClose.bind(this);

        this.state = {
            show: false,
            user: []
        };
    }
    onChange = (e) => {
       this.setState({user:{[e.target.name]: e.target.value}});
     //   this.setState(this.state.user({[e.target.name]: e.target.value}))
    };
    home() {


    }

    handleClose() {
        this.setState({ show: false });
    }

    handleShow() {
        this.setState({ show: true });
    }

    render() {
        const popover = (
            <Popover id="modal-popover" title="popover">
                very popover. such engagement
            </Popover>
        );
        const tooltip = <Tooltip id="modal-tooltip">wow.</Tooltip>;
        return (
            <div>
                <Router>
                    <div class="App-header">
                        <div className="App">
                            <img src={logo} className="App-logo" alt="logo"/>
                            <h1 className="App-title">Zaks React App</h1>
                        </div>
                        <Navbar className="">

                            <Navbar.Collapse>
                                <Nav>
                                    <NavItem eventKey={1}>
                                        <NavLink to="/">Home</NavLink>
                                    </NavItem>
                                    <NavDropdown eventKey={2} title="Options" id="basic-nav-dropdown">
                                        <MenuItem eventKey={2.1}><NavLink to="/add">Add DVD</NavLink></MenuItem>
                                        <MenuItem eventKey={2.2}><NavLink to="/delete">Delete DVD</NavLink></MenuItem>
                                        <MenuItem divider/>
                                        <MenuItem eventKey={2.3}><NavLink to="/view"> View DVD </NavLink>s</MenuItem>
                                    </NavDropdown>
                                </Nav>
                                <Nav pullRight>
                                    <NavItem eventKey={1} onSelect={this.handleShow} href="#">
                                        New User
                                    </NavItem>
                                    <NavItem eventKey={2} href="#">
                                        Set User
                                    </NavItem>
                                </Nav>
                            </Navbar.Collapse>
                        </Navbar>

                        <Route exact path="/add" component={AddAccount}/>
                        <Route exact path="/" component={AddAccount}/>
                        <Route exact path="/view" component={ViewDVDs}/>
                    </div>
                </Router>

                <Modal show={this.state.show} onHide={this.handleClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>Add User</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>

                        <center>
                            <form className="form">

                                <FormGroup bsSize="large">
                                    <FormControl value={this.state.firstName} onChange={this.onChange} name="firstName"
                                                 type="text" placeholder="Large text"/>
                                </FormGroup>
                                <FormGroup bsSize="large">
                                    <FormControl value={this.state.lastName} onChange={this.onChange} name="lastName"
                                                 type="text" placeholder="Large text"/>
                                </FormGroup>

                            </form>
                            <h1>{JSON.stringify(this.state.user)}</h1>

                        </center>


                    </Modal.Body>
                    <Modal.Footer>
                        <Button onClick={this.handleClose}>Close</Button>
                    </Modal.Footer>
                </Modal>
            </div>
        )
    }

}

