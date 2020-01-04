import React, { Component } from "react";
import {
  Form,
  Icon,
  Input,
  Button,
  Checkbox,
  Modal,
  Dropdown,
  Menu,
  Avatar
} from "antd";
import UserInfoManager from "../../models/UserInfoManager";
const UserInfoManagerInstance = UserInfoManager.getUserInfoManagerInstance();
class HeaderBar extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userInfo: UserInfoManagerInstance.userInfo
    };
     UserInfoManagerInstance.addObserver(this)
  }
  componentWillUnmount(){
    UserInfoManagerInstance.removeObserver(this)
  }
  onUserInfoChanged = ()=> {
    this.setState({userInfo: UserInfoManagerInstance.userInfo})
  }
  render() {
    const {userInfo} = this.state;
    let menuAuthen = (
      <Menu theme="dark" onClick={(e) => {
        if (e.key == '1') {
          UserInfoManagerInstance.updateUserInfo(false);        
      }}}>
        <Menu.Item key="1" >
          <Icon type="logout" />
          Đăng xuất
        </Menu.Item>
      </Menu>
    );
    if (!userInfo) {
      menuAuthen = (
        <Menu theme="dark" onClick={(e)=>{
            if(e.key == '1' ){
              this.props.login()
            }
        }}>
          <Menu.Item  key="1" >
            <Icon type="login"/>
              Đăng nhập
          </Menu.Item>
        </Menu>
      );
    }
    return (
      <div
        style={{
          height: 70,
          width: "100%",
          flexDirection: "row",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          backgroundColor: "#3775C0"
        }}
      >
        <div
          style={{
            height: 70,
            width: "70%",
            flexDirection: "column",
            display: "flex",
            justifyContent: "center",
            alignItems: "center"
          }}
        >
          <h1
            style={{
              color: "#FFFFFF",
              fontSize: 18,
              marginLeft: 50,
              fontFamily: "Times New Roman",
              width: "90%",
              fontWeight: "initial"
            }}
          >
            PHÒNG KHÁM ĐA KHOA REACTJS TEAM
          </h1>
          <h1
            style={{
              color: "#FFFFFF",
              fontSize: 15,
              marginTop: -10,
              marginLeft: 50,
              fontFamily: "Times New Roman",
              width: "90%",
              fontWeight: "initial"
            }}
          >
            Số 236 - Hoàng Quốc Việt - Cổ Nhuế 1 - Hà Nội
          </h1>
        </div>
        <div
          style={{
            display: "flex",
            flexDirection: "row-reverse",
            justifyContent: "center",
            width: "30%"
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
              <p style={{ marginRight: 10, color: "#FFFFFF", marginTop: 5 }}>
                {userInfo ? userInfo.hoten : "Chưa đăng nhập"}
              </p>
            </a>
          </Dropdown>
        </div>
      </div>
    );
  }
}
export default HeaderBar;
