import React, { Component } from 'react';
import {Nav, Navbar, NavItem, NavDropdown, MenuItem,Button,FormControl} from 'react-bootstrap';


class SearchBar extends Component {

    constructor(props){
        super(props);
        this.state = {
            value: '',
        }
    }

    handleInputChange = (e) => {
        this.setState({ value: e.target.value });
    }

    handleClick = () => {

        fetch('http://localhost:8080/api/course/' + this.state.value)
            .then(response => response.json())
            .then(data => this.setState({ data }));

    }



    render() {
        return (
            <form>
                <NavItem ><FormControl
                              className="search-bar"
                              type = "text"
                              placeholder="Search for..."
                              value = {this.state.value}
                              onChange={this.handleInputChange}
                              id="searchBar"
                              />
                    <Button onClick = {this.handleClick} type = "submit" id = "button">Search</Button></NavItem>
            </form>
        )
    }
}

export default SearchBar;