import React, {Component} from "react";
import "../../App.css";
import "../../antd.css";
import {
    Route,
    Switch,
    withRouter
} from "react-router-dom";

import LoginComponent from '../../components/AdminComponents/LoginComponent';
import DashboardScreen from './DashboardScreen';
import ListUserScreen from "./ListUserScreen";
import ListAdminScreen from "./ListAdminScreen";
import ListDoctorScreen from "./ListDoctorScreen";
import ListPackageScreen from "./ListPackageScreen";
import ListStatisticScreen from "./ListStatisticScreen";
import BreadcrumbCustom from "../../components/BreadcrumbCustom";

import AdminInfoManager from "../../models/AdminInfoManager";
import icons from "../../resources/icons/index";
import {
    Layout,
    Menu,
    Icon,
    Avatar,
    Dropdown,
    Drawer
} from "antd";

const AdminInfoManagerInstance = AdminInfoManager.getAdminInfoManagerInstance();
const {Header, Sider, Content} = Layout;

class HomeAdminScreen extends Component {
    constructor(props) {
        super(props);
        this.state = {
            collapsed: false,
            openLogin: false,
            openRegister: false,
            openAccountSetting: false,
            name: "Dashboard",
            adminInfo: AdminInfoManagerInstance.adminInfo
        };
        AdminInfoManagerInstance.addObserver(this);
    }

    componentWillUnmount() {
        AdminInfoManagerInstance.removeObserver(this);
    }

    onAdminInfoChanged = () => {
        this.setState({adminInfo: AdminInfoManagerInstance.adminInfo});
    };
    toggle = () => {
        this.setState({
            collapsed: !this.state.collapsed
        });
    };
    onClickMenuItem = e => {
        const {history} = this.props;
        switch (e.key) {
            case "0": {
                history.push("/admin");
                this.setState({name: "Dashboard"})
            }
                break;
            case "1": {
                history.push("/admin/user-list-manager");
                this.setState({name: "Tài khoản người dùng"})
            }
                break;
            case "2": {
                history.push("/admin/doctor-list-manager");
                this.setState({name: "Danh sách bác sĩ"})
            }
                break;
            case "3": {
                history.push("/admin/patient-list-manager");
                this.setState({name: "Danh sách bệnh nhân"})
            }
                break;
            case "4": {
                history.push("/admin/examination-package-manager");
                this.setState({name: "Các gói khám"})
            }
                break;
            case "5": {
                history.push("/admin/statistic-manager");
                this.setState({name: "Thống kê"})
            }
                break;
            default:
                break;
        }
    };

    render() {
        const {collapsed, adminInfo, name} = this.state;
        let menuAuthen = (
            <Menu
                theme="dark"
                onClick={e => {
                    if (e.key === "1") {
                        AdminInfoManagerInstance.updateAdminInfo(false);
                    }
                }}
            >
                <Menu.Item key="1">
                    <Icon type="logout"/>
                    Đăng xuất
                </Menu.Item>
            </Menu>
        );
        let page = <LoginComponent/>;
        if (adminInfo !== false) {
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
                            <img src={icons.patient} style={{width: 30, height: 30}}/>
                            {collapsed ? (
                                <div/>
                            ) : (
                                <h3 style={{color: "white", margin: "auto"}}>
                                    <a
                                        href="http://localhost:3000/admin/"
                                        style={{
                                            color: "#FFFFFF",
                                        }}>
                                        ADMIN TEAM
                                    </a>
                                </h3>
                            )}
                        </div>
                        <Menu theme="dark" mode="inline" onClick={this.onClickMenuItem}>
                            <Menu.Item key="0">
                                <Icon type="dashboard"/>
                                <span>Dashboard</span>
                            </Menu.Item>
                            <Menu.Item key="1">
                                <Icon type="bar-chart"/>
                                <span>Quản lý người dùng</span>
                            </Menu.Item>
                            <Menu.Item key="2">
                                <Icon type="team"/>
                                <span>Danh sách Bác sĩ</span>
                            </Menu.Item>
                            <Menu.Item key="3">
                                <Icon type="user"/>
                                <span>Danh sách Bệnh nhân</span>
                            </Menu.Item>
                            <Menu.Item key="4">
                                <Icon type="folder-open"/>
                                <span>Quản lý Gói khám</span>
                            </Menu.Item>
                            <Menu.Item key="5">
                                <Icon type="profile"/>
                                <span>Thống kê</span>
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
                                    style={{fontSize: 20, marginRight: 10}}
                                    type={this.state.collapsed ? "menu-unfold" : "menu-fold"}
                                    onClick={this.toggle}
                                />
                                <BreadcrumbCustom name={name}/>
                            </div>
                            <div
                                style={{
                                    display: "flex",
                                    flexDirection: "row-reverse",
                                    width: "50%"
                                }}
                            >
                                <Dropdown
                                    style={{display: "flex", flexDirection: "row-reverse"}}
                                    overlay={menuAuthen}
                                    placement="bottomCenter"
                                >
                                    <div
                                        style={{
                                            display: "flex",
                                            flexDirection: "row-reverse",
                                            color: "rgba(0, 0, 0, 0.65)"
                                        }}
                                    >
                                        <Avatar icon="user"/>
                                        <p style={{marginTop: -17, marginRight: 10}}>
                                            {adminInfo ? adminInfo.TenND : "Chưa đăng nhập"}
                                        </p>
                                    </div>
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
                                <Route exact path="/admin" component={DashboardScreen}/>
                                <Route path="/admin/user-list-manager" component={ListAdminScreen}/>
                                <Route path="/admin/doctor-list-manager" component={ListDoctorScreen}/>
                                <Route path="/admin/patient-list-manager" component={ListUserScreen}/>
                                <Route path="/admin/examination-package-manager" component={ListPackageScreen}/>
                                <Route path="/admin/statistic-manager" component={ListStatisticScreen}/>
                            </Switch>
                        </Content>
                    </Layout>
                </Layout>
            );
        }
        return (
            page
        );
    }
}

export default withRouter(HomeAdminScreen);
