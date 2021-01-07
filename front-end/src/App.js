import React from 'react';
import './App.css';
import LandingPage from './components/landing/Landing';
import SearchForm from './components/main/SearchForm'
import 'bootstrap/dist/css/bootstrap.min.css';
import { HashRouter as Router, Route, Switch, Redirect } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path="/welcome" render={props => <LandingPage {...props} />} />
          <Route path="/search" render={props => <SearchForm {...props} />} />
          <Redirect path="/" to={"/welcome"} />
        </Switch>     
      </Router>
    </div>
  );
}

export default App;
