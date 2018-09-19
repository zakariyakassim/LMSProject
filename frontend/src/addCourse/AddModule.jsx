import * as React from "react";
import FormGroup from "react-bootstrap/es/FormGroup";
import FormControl from "react-bootstrap/es/FormControl";
import ControlLabel from "react-bootstrap/es/ControlLabel";
import Button from "react-bootstrap/es/Button";

import './AddCourse.css';

class AddModule extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            value: [],
            textvalue : "",
            test:""
        }

        this.handleAddMod = this.handleAddMod.bind(this)
        this.handleChange = this.handleChange.bind(this)
        this.deleteMod = this.deleteMod.bind(this)

    }
    handleChange(e) {
        this.setState({
            textvalue:e.target.value
        })
    }
    handleAddMod() {
        this.state.value.push(this.state.textvalue)
        this.setState(
            this.state
        )
        this.state
        console.log(this.state.value)
    }

    deleteMod(v){
        for(var i = 0; i < this.state.value.length; i++){
            if(this.state.value[i] == v){
                delete this.state.value[i]
            }
        }
        this.setState({
            value:this.state.value
        })
        console.log(this.state.value)
    }

    render() {
        let { value } = this.state;
        return (
            <FormGroup>
                <ControlLabel> Your Modules </ControlLabel>
                <FormControl inline type="text" placeholder="Add module here" className="text" onChange={ this.handleChange } />
                <Button type="reset" className="addModule-btn" onClick={this.handleAddMod}>Add module</Button>
                    {value.map((v) => {
                    return <table id="add-module-table">
                        <tr>
                            <ul><li style={{padding:'15px'}}>{v}<Button className="module-del-button" bsStyle="danger" bsSize="xsmall" onClick={this.deleteMod.bind(this, v)}>Delete</Button></li></ul>
                        </tr>
                        </table>
                })}
            </FormGroup>
        )
    }
}

export default AddModule;