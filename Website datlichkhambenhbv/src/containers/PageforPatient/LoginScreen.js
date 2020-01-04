import React, { Component } from "react";
import { Form, Icon, Input, Button, Checkbox,message } from "antd";
import {withRouter} from "react-router-dom";
import resourceImg from "../../resources/images/index";
import UserInfoManager from "../../models/UserInfoManager";
import {UserLogin,ListUser} from '../../apis/Api';
const UserInfoManagerInstance = UserInfoManager.getUserInfoManagerInstance();
class LoginScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {};
    document.title = "Phòng khám Đa khoa ReactJS Team - Đăng nhập";
  }
  LoginUser = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log("Received values of form: ", values);
        UserLogin(values, dataResult => {
          if (dataResult.ma_nhomnd !== "N4") {
            message.error("Tài khoản không có quyền truy cập", 3);
          } else {
            ListUser(data => {
              for (let i = 0; i < data.length; i++) {
                if ((data[i].matk_ === dataResult.matk)) {
                  data[i].tentk = values.tentk;
                  data[i].matkhau = values.matkhau;

                  UserInfoManagerInstance.updateUserInfo(data[i]);
                  message.success("Đăng nhập thành công", 3);
                  break;
                }
              }
            });
          }
        });
      }
    });
  };
  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <div
        style={{
          height: "100%",
          width: "100%",
          display: "flex",
          position: "fixed",
          justifyContent: "center",
          alignItems: "center",
          backgroundSize: "cover",
          backgroundPosition: "center center",
          backgroundImage: `url(${resourceImg.img})`
        }}
      >
        <div
          style={{
            height: "100%",
            width: "100%",
            display: "flex",
            position: "fixed",
            flexDirection: "row",
            alignItems: "center",
            backgroundColor: "rgba(64, 64, 64, 0.4)"
          }}
        >
          <div
            style={{
              height: "100%",
              width: "40%",
              maxWidth: 500,
              marginLeft: "20%",
              justifyContent: "center",
              display: "flex",
              flexDirection: "column"
            }}
          >
            <h1
              style={{
                color: "#F0FF11",
                fontSize: 20,
                fontFamily: "Times New Roman",
                fontWeight: "initial"
              }}
            >
              Dịch vụ khám và chữa bệnh
            </h1>
            <h1
              style={{
                color: "#FFFFFF",
                fontSize: 40,
                marginTop: 0,
                fontFamily: "Times New Roman",
                fontWeight: "initial"
              }}
            >
              PHÒNG KHÁM ĐA KHOA REACTJS TEAM
            </h1>
            <h1
              style={{
                marginTop: 30,
                color: "#FFFFFF",
                fontSize: 18,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial"
              }}
            >
              Phòng khám được đánh giá cao về cả chất lượng khám chữa bệnh và
              dịch vụ khách hàng với cơ sở vật chất hiện đại vượt trội, hệ thống
              trang thiết bị y tế tiên tiến, và đội ngũ bác sĩ giỏi chuyên môn,
              giàu y đức.
            </h1>
          </div>
          <Form
            onSubmit={this.LoginUser}
            style={{ maxWidth: 300, marginLeft: 40 }}
          >
            <h1
              style={{
                color: "#FFFFFF",
                fontSize: 30,
                marginTop: 0,
                fontFamily: "Times New Roman",
                fontWeight: "initial"
              }}
            >
              ĐĂNG NHẬP TÀI KHOẢN
            </h1>
            <Form.Item>
              {getFieldDecorator("tentk", {
                rules: [
                  { required: true, message: "Vui lòng nhập tên của bạn!" }
                ]
              })(
                <Input
                  prefix={
                    <Icon type="user" style={{ color: "rgba(0,0,0,.3)" }} />
                  }
                  placeholder="Tên đăng nhập"
                />
              )}
            </Form.Item>
            <Form.Item>
              {getFieldDecorator("matkhau", {
                rules: [
                  {
                    required: true,
                    message: "Vui lòng nhập nhập khẩu của bạn!"
                  }
                ]
              })(
                <Input.Password
                  prefix={
                    <Icon type="lock" style={{ color: "rgba(0,0,0,.3)" }} />
                  }
                  placeholder="Mật khẩu"
                  type="password"
                />
              )}
            </Form.Item>
            <Form.Item>
              {/* {getFieldDecorator("", {
                valuePropName: "checked",
                initialValue: false
              })(<Checkbox style={{ color: "#F0FF11" }}>Remember me</Checkbox>)}
              <a style={{ float: "right" }} href="">
                Quên mật khẩu
              </a> */}
              <Checkbox style={{ color: "#F0FF11" }}>Remember me</Checkbox>
              <a style={{ float: "right" }} href="">
                Quên mật khẩu
              </a>
              <Button
                type="primary"
                htmlType="submit"
                style={{ width: "100%" }}
              >
                Đăng nhập
              </Button>
              <a
                onClick={() => {
                  this.props.history.push("/register");
                }}
              >
                Bạn chưa có tài khoản?
              </a>
            </Form.Item>
          </Form>
        </div>
      </div>
    );
  }
}

export default withRouter(Form.create()(LoginScreen));
