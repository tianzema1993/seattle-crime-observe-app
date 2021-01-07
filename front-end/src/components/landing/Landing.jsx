import React from 'react';
import './css/Landing.css';
import { Link } from "react-router-dom";
import Grid from '@material-ui/core/Grid';
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import ArrowForwardIcon from '@material-ui/icons/ArrowForward';
import IconButton from '@material-ui/core/IconButton';

class Landing extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            facts: ["Do you know 'First Hill Park' is the most dangerous park in past 10 years?", "In Seattle, New Years Day is the most dangerous holiday!", "In 2019, 'Fraud Offenses' increases 3 times compared to past three years average."],
            index: 0
        };
    }
    render() {
        return (
            <section className="landing">
                <div className="search-title">
                    <h1>Search Seattle Crime Records</h1>
                    <Grid container justify="center" alignItems="center" direction="row">
                        <Grid item xs={3}>
                            <IconButton onClick={() => {this.setState({index: this.state.index - 1 >= 0 ? this.state.index - 1 : this.state.facts.length - 1})}}>
                                <ArrowBackIcon style={{width: 60, height: 60, color: 'yellow'}} />
                            </IconButton>
                        </Grid>
                        <Grid item xs={6}>
                            <h2><i>{this.state.facts[this.state.index]}</i></h2>
                        </Grid>
                        <Grid item xs={3}>
                        <IconButton onClick={() => {this.setState({index: this.state.index + 1 < this.state.facts.length ? this.state.index + 1 : 0})}}>
                                <ArrowForwardIcon style={{width: 60, height: 60, color: 'yellow'}} />
                            </IconButton>
                        </Grid>
                    </Grid>
                    <Link to={"/search"} >
                        <button className="btn btn-primary" key="search-btn">Find more...</button>
                    </Link>
                </div>
            </section>

        );
    }
}
export default Landing;