import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import Footer from './main/Footer';
import Header from './main/Header';

import axios from 'axios';
import NavLink from "react-router-dom/es/NavLink";
import OverlayTrigger from "react-bootstrap/es/OverlayTrigger";
import Popover from "react-bootstrap/es/Popover";
import Tooltip from "react-bootstrap/es/Tooltip";
import Button from "react-bootstrap/es/Button";


export class App extends React.Component {
    render() {
        const tooltip = <Tooltip id="modal-tooltip">wow.</Tooltip>;
        return (
                <Router>
				  <React.Fragment>
				  <Header />
				  <Footer />
				  
                  </React.Fragment>
                </Router>
        );
    }
}

