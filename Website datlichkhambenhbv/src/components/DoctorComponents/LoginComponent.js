import React, { Component } from "react";
import { Icon, Input, Button, Checkbox, message } from "antd";
import DoctorInfoManager from "../../models/DoctorInfoManager";
import {UserLogin,ListDoctor} from '../../apis/Api'
const DoctorInfoManagerInstance = DoctorInfoManager.getDoctorInfoManagerInstance();

class LoginComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      TenTK: "",
      MatKhau: "",
      remember: false
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Đăng nhập Bác sĩ";
  }
  loginDoctor = () => {
    const { TenTK, MatKhau } = this.state;
    if (TenTK !== "" && MatKhau !== "") {
      let doctorInfor = {
        tentk: TenTK,
        matkhau: MatKhau
      };
      UserLogin(doctorInfor, dataResult => {
        if (dataResult.ma_nhomnd != "N3") {
          message.error("Tài khoản không có quyền truy cập", 3);
        } else {
          ListDoctor(data => {
            for (let i = 0; i < data.length; i++) {
              if ((data[i].matk_ === dataResult.matk)) {
                data[i].tentk = doctorInfor.tentk;
                data[i].matkhau = doctorInfor.matkhau;

                DoctorInfoManagerInstance.updateDoctorInfo(data[i]);
                message.success("Đăng nhập thành công", 3);
                break;
              }
            }
          });
        }
      });
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
              onClick={this.loginDoctor}
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
