import React from 'react';
import { Link } from 'react-router-dom';

import './Home.css';
import Footer from "../main/Footer";

const Home = () => {
    return (
        <div id="home-body">
            <div id="Introduction">
                <div>
                    <h1>Welcome to QC Tutorials</h1>
                </div>
                <p>
                    QC Tutorials is designed in order to maximise your learning potential
                </p>
            </div>
            <section>
                <div id="row">
                    <div id="row-info">
                        <h2>Course Name 1</h2>
                        <p>
                            Information on the course that is being shown
                        </p>
                        <p>
                            <Link className="pageLink" to="/course">View Course</Link>
                        </p>
                    </div>
                    <div id="row-info">
                        <h2>Course Name 2</h2>
                        <p>
                            Information on the course that is being shown
                        </p>
                        <p>
                            <Link className="pageLink" to="/course">View Course</Link>
                        </p>
                    </div>
                    <div id="row-info">
                        <h2>Course Name 3</h2>
                        <p>
                            Information on the course that is being shown
                        </p>
                        <p>
                            <Link className="pageLink" to="/course">View Course</Link>
                        </p>
                    </div>
                    <div id="row-info">
                        <h2>Course Name 4</h2>
                        <p>
                            Information on the course that is being shown
                        </p>
                        <p>
                            <Link className="pageLink" to="/course">View Course</Link>
                        </p>
                    </div>
                </div>
            </section>
        </div>
    );
    <Footer />
};

export default Home;