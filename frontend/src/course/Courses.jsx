import React, { Component } from 'react';
import './Course.css';
import {Nav, Navbar, NavItem, NavDropdown, MenuItem,Button,FormControl} from 'react-bootstrap';

class Courses extends React.Component {

    constructor(props) {
        super(props);

        this.handleChange = this.handleChange.bind(this);
        this.props = props;

        this.state = {
            value: "",
            data: null
        }

    }

    handleChange(e) {
        this.setState({ value: e.target.value });

    }



    render() {
        let cards = [];
        let json = null;
        

        if(this.props.courses !== null) {
            for (var i = 0; i<this.props.courses.length; i++) {
                let modules = [];
                if(this.props.courses[i].name.toLocaleLowerCase().includes(this.state.value) || this.state.value === "") {

                    try {
                        json = JSON.parse(this.props.courses[i].modules);
                        json.forEach(function(x) {
                            modules.push(<li id = "bullet">{x.name}</li>);
                        })
                }
                catch(err) {
                }


                cards[i] = (

                    <div className="column" >

                        <div className="card" >
                            <h4>Name</h4>
                            <p>{this.props.courses[i].name}</p>
                            <h4>Description</h4>
                            <p>{this.props.courses[i].description}</p>
                            <h4>{(modules.length === 0) ? 
                                    false:"Modules"}</h4>

                            {modules}

                        </div>
                    </div>
                );
            }

        }
    }
    else {
        cards = [];
    }


return (

    <div id = "margin" className = "row">
        <Nav> <FormControl
                  id = "search"
                  type="text"
                  value={this.state.value}
                  placeholder="Search for courses..."
                  onChange={this.handleChange}
                  /></Nav>{cards}</div>
);
}


}


export default Courses;