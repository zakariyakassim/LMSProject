import React from "react";
import axios from "axios";
import {Button, FormControl, FormGroup, Modal} from "react-bootstrap"
import Rest from "../Rest";
import './css/ViewDVDs.css';
import Popover from "react-bootstrap/es/Popover";
import Tooltip from "react-bootstrap/es/Tooltip";


export class ViewDVDs extends React.Component {


    constructor(props) {
        super(props);
       // this.getData.bind(this);
      /*  this.state = {
            data : ''
        }; */

      this.modal = {
            show: false
        };

        this.state = {
            error: null,
            isLoaded: false,
            items: []
        };
        this.api = {
          apiKey : 'f000b5430a909fe857a7de49bf27895e'
        };
        this.getMovie()


       // this.getData();
    }

    handleShow() {
        this.setState({ show: true });
    }
    handleClose() {
        this.setState({ show: false });
    }


    onChange = (e) => {
        this.setState({[e.target.name]: e.target.value});
    };

    getList = () => {

        this.movieList = this.state.items.map(function(item, index){
            return <li  key={ index }>
                <div className="container">

                    <img src={"https://image.tmdb.org/t/p/w500"+item.poster_path} class="image" alt="" className="image" />
                    <div class="middle">
                        <a href="">  <div key={item.id} class="text">BOOK</div></a>
                    </div>
                </div>
            </li>;
        });
    };

    getData = (e) => {
        Rest.getAccount().then(response => {
            console.log(response.ok);
            if (response.ok) {
                response.json().then(json => {

                    this.setState({
                        isLoaded: true,
                        items: json.content
                    });


                   // alert(json)
                });
            }
        });
    };



    getMovie = () => {

        Rest.get('https://api.themoviedb.org/3/movie/now_playing?api_key=' + this.api.apiKey + '&language=en-US&page=1')
            .then(response => {
                console.log(response.ok);
                if (response.ok) {
                    response.json().then(json => {

                        this.setState({
                            isLoaded: true,
                            items: json.results
                        });

                        console.log(json)
                        // alert(json)
                    });
                }
            });
};

    render() {
        this.getList();

        const popover = (
            <Popover id="modal-popover" title="popover">
                very popover. such engagement
            </Popover>
        );
        const tooltip = <Tooltip id="modal-tooltip">wow.</Tooltip>;
        return (
            <div>

                <ul id="viewDVDList">
                    {this.movieList}
                </ul>

                <Modal show={this.modal.show} onHide={this.handleClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>Add User</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>

                        <center>



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
