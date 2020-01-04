import React, { Component } from "react";
import "../../App.css";
import "../../antd.css";
import {
  Route,
  Switch,
  withRouter
} from "react-router-dom";

import LoginComponent from '../../components/DoctorComponents/LoginComponent';
import DashboardScreen from './DashboardScreen';
import ListServiceScreen from "./ListServiceScreen";
import ListScheduleScreen from "./ListScheduleScreen";
import ListAppointmentScreen from "./ListAppointmentScreen";

import BreadcrumbCustom from "../../components/BreadcrumbCustom";

import DoctorInfoManager from "../../models/DoctorInfoManager";
import icons from "../../resources/icons/index";
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Drawer,
  Badge
} from "antd";

const DoctorInfoManagerInstance = DoctorInfoManager.getDoctorInfoManagerInstance();
const { Header, Sider, Content } = Layout;

class HomeDoctorScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      collapsed: false,
      openLogin: false,
      openRegister: false,
      openAccountSetting: false,
      name: "Dashboard",
      doctorInfo: DoctorInfoManagerInstance.doctorInfo
    };
    DoctorInfoManagerInstance.addObserver(this);
  }

  componentWillUnmount() {
    DoctorInfoManagerInstance.removeObserver(this);
  }
  onDoctorInfoChanged = () => {
    this.setState({ doctorInfo: DoctorInfoManagerInstance.doctorInfo });
  };
  toggle = () => {
    this.setState({
      collapsed: !this.state.collapsed
    });
  };
  onClickMenuItem = e => {
    const { history } = this.props;
    switch (e.key) {
      case "0":
        history.push("/doctor");
        this.setState({ name: "Dashboard" });
        break;
      case "1":
        history.push("/doctor/list-schedule");
        this.setState({ name: "Lịch khám" });
        break;
      case "2":
        history.push("/doctor/service-list-manager");
        this.setState({ name: "Dịch vụ khám" });
        break;
      case "3":
        history.push("/doctor/appointment-list-manager");
        this.setState({ name: "Lịch hẹn khám"});
        break;
      default:
        break;
    }
  };
  render() {
    const { collapsed, doctorInfo, name } = this.state;
    let menuAuthen = (
      <Menu
        theme="dark"
        onClick={e => {
          if (e.key == "1") {
            DoctorInfoManagerInstance.updateDoctorInfo(false);
          }
        }}
      >
        <Menu.Item key="1">
          <Icon type="logout" />
          Đăng xuất
        </Menu.Item>
      </Menu>
    );
    let page = <LoginComponent />;
    if (doctorInfo !== false) {
      page = (
        <Layout>
          <Sider trigger={null} collapsible collapsed={this.state.collapsed}>
            <div
              style={{
                margin: 10,
                flexDirection: "row",
                display: "flex",
                padding: 5
              }}
            >
              <img src={icons.patient} style={{ width: 30, height: 30 }} />
              {collapsed ? (
                <div />
              ) : (
                <h3 style={{ color: "white", margin: "auto" }}>DOCTOR TEAM</h3>
              )}
            </div>
            <Menu theme="dark" mode="inline" onClick={this.onClickMenuItem}>
              <Menu.Item key="0">
                <Icon type="dashboard" />
                <span>Dashboard</span>
              </Menu.Item>
              <Menu.Item key="1">
                <Icon type="unordered-list" />
                <span>Lịch khám</span>
              </Menu.Item>
              <Menu.Item key="2">
                <Icon type="customer-service" />
                <span>Dịch vụ khám</span>
              </Menu.Item>
              <Menu.Item key="3">
                <Badge count={1}>
                  <Icon type="calendar" />
                </Badge>
                <span style={{ marginLeft: 15 }}>Lịch hẹn khám</span>
              </Menu.Item>
            </Menu>
          </Sider>
          <Layout>
            <Header
              style={{
                background: "#fff",
                padding: 20,
                display: "flex",
                flexDirection: "row"
              }}
            >
              <div
                style={{
                  display: "flex",
                  flexDirection: "row",
                  width: "50%"
                }}
              >
                <Icon
                  style={{ fontSize: 20, marginRight: 10 }}
                  type={this.state.collapsed ? "menu-unfold" : "menu-fold"}
                  onClick={this.toggle}
                />
                <BreadcrumbCustom name={name} />
              </div>
              <div
                style={{
                  display: "flex",
                  flexDirection: "row-reverse",
                  width: "50%"
                }}
              >
                <Dropdown
                  style={{ display: "flex", flexDirection: "row-reverse" }}
                  overlay={menuAuthen}
                  placement="bottomCenter"
                >
                  <a
                    style={{
                      display: "flex",
                      flexDirection: "row-reverse",
                      color: "rgba(0, 0, 0, 0.65)"
                    }}
                  >
                    <Avatar icon="user" />
                    <p style={{ marginTop: -17, marginRight: 10 }}>
                      {doctorInfo ? doctorInfo.tenbs : "Chưa đăng nhập"}
                    </p>
                  </a>
                </Dropdown>
              </div>
            </Header>
            <Content
              style={{
                margin: "24px 16px",
                padding: 24,
                background: "#fff",
                minHeight: "calc(100vh - 50px)"
              }}
            >
              <Switch>
                <Route exact path="/doctor" component={DashboardScreen} />
                <Route
                  path="/doctor/list-schedule"
                  component={ListScheduleScreen}
                />
                <Route
                  path="/doctor/service-list-manager"
                  component={ListServiceScreen}
                />
                <Route
                  path="/doctor/appointment-list-manager"
                  component={ListAppointmentScreen}
                />
                {/* <Route path="/doctor/add-shedule" component={AddScheduleScreen}/>
                <Route path="/doctor/add-service" component={AddServiceScreen}/> */}
              </Switch>
            </Content>
          </Layout>
        </Layout>
      );
    }
    return page;
  }
}

export default withRouter(HomeDoctorScreen);
