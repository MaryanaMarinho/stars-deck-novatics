import React from "react";

import {BrowserRouter, Route, Switch} from "react-router-dom";
import Ranking from "./pages/Ranking";
import EventForm from "./pages/EventForm";
import UserProfile from "./pages/UserProfile";


const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Ranking}/>
            <Route exact path="/event" component={EventForm}/>
            <Route exact path="/profile/:id" component={UserProfile}/>
        </Switch>
    </BrowserRouter>
);

export default Routes;
