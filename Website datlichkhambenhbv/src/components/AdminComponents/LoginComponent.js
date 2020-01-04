import React, { Component } from "react";
import { Icon, Input, Button, Checkbox, message } from "antd";
import AdminInfoManager from "../../models/AdminInfoManager";

import adminInfo from "../../resources/dataDefault/admin";
const AdminInfoManagerInstance = AdminInfoManager.getAdminInfoManagerInstance();

class LoginComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      TenTK: "",
      MatKhau: "",
      remember: false
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Đăng nhập Admin";
  }
  loginAdmin = () => {
    const { TenTK, MatKhau } = this.state;
    let adminInfor;
    if (TenTK !== "" && MatKhau !== "") {
      adminInfo.forEach(element => {
        if (element.TenTK === TenTK && element.MatKhau === MatKhau) {
          adminInfor = element;
        }
      });
      if (adminInfor !== null && adminInfor !== undefined) {
        AdminInfoManagerInstance.updateAdminInfo(adminInfor);
        message.success("Đăng nhập thành công", 3);
      } else {
        message.error("Tên đăng nhập hoặc mật khẩu sai", 3);
      }
    } else {
      message.error("Chưa đủ thông tin", 3);
    }
  };
  render() {
    const { TenTK, MatKhau } = this.state;
    return (
      <div style={styles.container}>
        <div style={styles.form}>
          <div style={styles.item}>
            <Input
              prefix={<Icon type="user" style={{ color: "rgba(0,0,0,.25)" }} />}
              placeholder="Tên đăng nhập"
              value={TenTK}
              onChange={e => {
                this.setState({ TenTK: e.target.value });
              }}
            />
          </div>
          <div style={styles.item}>
            <Input
              prefix={<Icon type="lock" style={{ color: "rgba(0,0,0,.25)" }} />}
              type="password"
              placeholder="Mật khẩu"
              value={MatKhau}
              onChange={e => {
                this.setState({ MatKhau: e.target.value });
              }}
            />
          </div>
          <div style={styles.check}>
            <Checkbox>Remember me</Checkbox>
            {/* <a style={{ float: "right" }} href="">
              Forgot password?
            </a> */}
          </div>
          <div style={styles.login}>
            <Button
              type="primary"
              htmlType="submit"
              style={{ width: "100%" }}
              onClick={this.loginAdmin}
            >
              Đăng nhập
            </Button>
          </div>
        </div>
      </div>
    );
  }
}
export default LoginComponent;

const styles = {
  container: {
    height: "100%",
    width: "100%",
    display: "flex",
    position: "fixed",
    justifyContent: "center",
  },
  form: {
    minWidth: 300,
    marginTop: 100
  },
  item: {
    height: 30,
    width: "100%",
    marginTop: 20,
    marginBottom: 20
  },
  check: {
    height: 30,
    width: "100%",
    marginTop: 20,
    marginBottom: 20
  },
  login: {
    justifyContent: "center",
    alignItems: "center",
    width: "100%",
    marginTop: 20,
    marginBottom: 20
  }
};
