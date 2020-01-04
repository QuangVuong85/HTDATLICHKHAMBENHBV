import React, { Component } from "react";
import "./App.css";
import "./antd.css";
import {
  BrowserRouter,
  Route,
  Link,
  Router,
  Switch,
  Redirect,
  withRouter
} from "react-router-dom";
import UserInfoManager from "./models/UserInfoManager";

import HomeScreen from "./containers/PageforPatient/HomeScreen";
import LoginScreen from "./containers/PageforPatient/LoginScreen";
import RegisterScreen from "./containers/PageforPatient/RegisterScreen";
import DetailInfoScreen from "./containers/PageforPatient/DetailInfoScreen";
import ScheduleDepartScreen from "./containers/PageforPatient/ScheduleDepartScreen";
import BookAppointmentScreen from "./containers/PageforPatient/BookAppointmentScreen";
import NotificationSuccessScreen from "./containers/PageforPatient/NotificationSuccessScreen";

import HomeAdminScreen from './containers/ManagerUser/HomeAdminScreen';
import HomeDoctorScreen from './containers/PageforDoctor/HomeDoctorScreen';

import {
  Layout
} from "antd";

const UserInfoManagerInstance = UserInfoManager.getUserInfoManagerInstance();

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userInfo: UserInfoManagerInstance.userInfo
    };
    UserInfoManagerInstance.addObserver(this);
  }

  componentWillUnmount() {
    UserInfoManagerInstance.removeObserver(this);
  }
  onUserInfoChanged = () => {
    this.setState({ userInfo: UserInfoManagerInstance.userInfo });
  };
  render() {
    const {userInfo } = this.state;
    const PrivateRoute = ({ component: Component, ...rest }) => (
      <Route
        {...rest}
        render={props =>
          !userInfo ?<Component {...props} /> : <Redirect to="/" />
        }
      />
    );
    const RouteUser = ({ component: Component, ...rest }) => (
      <Route
        {...rest}
        render={props =>
          !userInfo ? <Redirect to="/" /> : <Component {...props} />
        }
      />
    );
    // const RouteAdmin = ({ component: Component, ...rest }) => (
    //   <Route
    //     {...rest}
    //     render={props =>
    //       !userInfo ? <Redirect to="/" /> : userInfo.MaNhomND == 1 || userInfo.MaNhomND == 2 ? <Component {...props}/> : null
    //     }
    //   />
    // );
    return (
      <Layout>    
        <Switch>
            <Route exact path="/" component={HomeScreen} />
            <Route path ="/admin" component={HomeAdminScreen} />
            <Route path ="/doctor" component={HomeDoctorScreen}/>
            <PrivateRoute path="/login" component={LoginScreen} />
            <PrivateRoute path="/register" component={RegisterScreen} />
            <RouteUser path="/bookAppointment/:id/:idLichhen" component={BookAppointmentScreen} />
            <RouteUser path="/detailInfor/:id" component={DetailInfoScreen} />
            <RouteUser path="/listDoctor/:id" component={ScheduleDepartScreen} />
            <RouteUser path="/notificationSuccess/:id" component={NotificationSuccessScreen}/>
          </Switch>
      </Layout>
    );
  }
}

export default withRouter(App);
