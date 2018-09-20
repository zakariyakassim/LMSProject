import React from "react";
import axios from "axios";
import {Button, FormControl, FormGroup} from "react-bootstrap"
import Rest from "../Rest";

export class AddAccount extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            firstName: '',
            lastName: ''
        };
        this.data = []
    }

    onChange = (e) => {
        this.setState({[e.target.name]: e.target.value});
    };

    handleSubmit = (e) => {
        /*   Rest.postAccount(this.state).then(function (response) {
               console.log(response.data)

           }).catch(function (error) {
               console.log(error)
           }); */

      /*  Rest.getAccount().then(function (response) {
            console.log(response.data)

        }).catch(function (error) {
            console.log(error)
        }) */

      Rest.getAccount()



     /*   axios.get('/api/accounts').then(function (response) {
            console.log(response.data);
            this.data = response.data

        }).catch(function (error) {
            console.log(error);
            //alert(error)
        })*/
    };

    render() {
        return (
            <div>
                <center>
                    <form class="form">

                        <FormGroup bsSize="large">
                            <FormControl value={this.state.firstName} onChange={this.onChange} name="firstName"
                                         type="text" placeholder="Large text"/>
                        </FormGroup>
                        <FormGroup bsSize="large">
                            <FormControl value={this.state.lastName} onChange={this.onChange} name="lastName"
                                         type="text" placeholder="Large text"/>
                        </FormGroup>
                        <Button bsSize="large"type="submit">Submit</Button>
                    </form>
                    <h1>{JSON.stringify(this.state)}</h1>
                    <Button bsSize="large" onClick={this.handleSubmit} type="submit">Submit</Button>
                </center>
            </div>
        )
    }
}
