import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import axios from "axios";
import {App} from "./App";


ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();

