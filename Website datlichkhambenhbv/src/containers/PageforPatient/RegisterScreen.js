import React, { Component } from "react";
import {
  Form,
  Select,
  Input,
  Icon,
  Checkbox,
  Button,
  message,
  Cascader,
  Radio 
} from "antd";
import {
  withRouter
} from "react-router-dom";
//import {Register} from "../apis/Api";
import resourceImg from "../../resources/images/index";
const residences = [
  {
    value: "1",
    label: "Xuân Thủy",
    children: [
      {
        value: "1",
        label: "Cầu Giấy",
        children: [
          {
            value: "1",
            label: "Hà Nội"
          }
        ]
      }
    ]
  },
  {
    value: "2",
    label: "Trần Cung",
    children: [
      {
        value: "1",
        label: "Cổ Nhuế",
        children: [
          {
            value: "1",
            label: "Hà Nội"
          }
        ]
      }
    ]
  }
];
const plainOptions = ["Nam", "Nữ"];
class RegisterScreen extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
      repassword: "",
      phone: "",
      read: false,
      email: "",
      countryid: "84",
      name: "",
      value : "Nam"
    };
    document.title = 'Phòng khám Đa khoa ReactJS Team - Đăng ký'
  }
  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFieldsAndScroll((err, values) => {
      
      if (!err) {
        console.log("Received values of form: ", values);
        message.warning("Đăng ký tài khoản thành công", 5);
        this.props.history.goBack()
      }
    });
  };
  handleConfirmBlur = e => {
    const { value } = e.target;
    this.setState({ confirmDirty: this.state.confirmDirty || !!value });
  };

  compareToFirstPassword = (rule, value, callback) => {
    const { form } = this.props;
    if (value && value !== form.getFieldValue("password")) {
      callback("Mật khẩu không khớp.Vui lòng nhập lại!");
    } else {
      callback();
    }
  };

  validateToNextPassword = (rule, value, callback) => {
    const { form } = this.props;
    if (value && this.state.confirmDirty) {
      form.validateFields(["confirm"], { force: true });
    }
    callback();
  };
  handleSelectChange = value => {
    console.log(value);
    this.props.form.setFieldsValue({
      note: `Hi, ${value === 'male' ? 'man' : 'lady'}!`,
    });
  };
  onChange = e => {
    console.log("radio checked", e.target.value);
    this.setState({
      value: e.target.value
    });
  };
  render() {
    const { Option } = Select;
    console.log("history register",this.props.history)

    const selectPhonenumber = (
      <Select
        defaultValue="84"
        style={{ width: 70 }}
        size={"small"}
        onSelect={e => {
          this.setState({ countryid: e });
        }}
      >
        <Option value="84">+84</Option>
        <Option value="85">+85</Option>
        <Option value="86">+86</Option>
        <Option value="87">+87</Option>
        <Option value="88">+88</Option>
        <Option value="89">+89</Option>
        <Option value="90">+90</Option>
      </Select>
    );
    const {
      value,
    } = this.state;
    const { getFieldDecorator } = this.props.form;
    return (
      <div style={styles.container}>
        <div style={styles.containForm}>
          <div
            style={{
              height: "100%",
              width: "50%",
              maxWidth: 500,
              marginLeft:"20%",
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
          <Form style={styles.form} onSubmit={this.handleSubmit}>
            <h1
              style={{
                color: "#FFFFFF",
                fontSize: 25,
                marginTop: 0,
                fontFamily: "Times New Roman",
                fontWeight: "initial"
              }}
            >
              ĐĂNG KÝ TÀI KHOẢN
            </h1>
            <Form.Item label="Yêu cầu bắt buộc" style={{ marginTop: -5 }}>
              {getFieldDecorator("username", {
                rules: [
                  { required: true, message: "Vui lòng nhập tên đăng nhập!" }
                ]
              })(
                <Input
                  prefix={
                    <Icon type="user" style={{ color: "rgba(0,0,0,.3)" }} />
                  }
                  placeholder="Tên đăng nhập"
                  // value={TenTK}
                  // onChange={e => {
                  //   this.setState({ TenTK: e.target.value });
                  // }}
                />
              )}
            </Form.Item>
            <Form.Item style={{ marginTop: -5 }}>
              {getFieldDecorator("nickname", {
                rules: [
                  { required: true, message: "Vui lòng nhập họ tên của bạn!" }
                ]
              })(
                <Input
                  prefix={
                    <Icon type="user" style={{ color: "rgba(0,0,0,.3)" }} />
                  }
                  placeholder="Họ Tên"
                  // value={TenTK}
                  // onChange={e => {
                  //   this.setState({ TenTK: e.target.value });
                  // }}
                />
              )}
            </Form.Item>
            
            <Form.Item style={{ marginTop: -5 }}>
              {getFieldDecorator("email", {
                rules: [
                  {
                    type: "email",
                    message: "Email không hợp lệ!"
                  },
                  {
                    required: true,
                    message: "Vui lòng nhập Email!"
                  }
                ]
              })(
                <Input
                  prefix={
                    <Icon type="mail" style={{ color: "rgba(0,0,0,.3)" }} />
                  }
                  placeholder="Email"
                />
              )}
            </Form.Item>
            <Form.Item style={{ marginTop: -5 }}>
              {getFieldDecorator("password", {
                rules: [
                  {
                    required: true,
                    message: "Vui lòng nhập mật khẩu!"
                  },
                  {
                    validator: this.validateToNextPassword
                  }
                ]
              })(
                <Input.Password
                  prefix={
                    <Icon type="lock" style={{ color: "rgba(0,0,0,.3)" }} />
                  }
                  placeholder="Mật khẩu"
                />
              )}
            </Form.Item>
            <Form.Item style={{ marginTop: -5 }}>
              {getFieldDecorator("confirm", {
                rules: [
                  {
                    required: true,
                    message: "Vui lòng nhập mật khẩu!"
                  },
                  {
                    validator: this.compareToFirstPassword
                  }
                ]
              })(
                <Input.Password
                  prefix={
                    <Icon type="lock" style={{ color: "rgba(0,0,0,.3)" }} />
                  }
                  placeholder="Nhập lại mật khẩu"
                  onBlur={this.handleConfirmBlur}
                />
              )}
            </Form.Item>
            <Form.Item style={{ marginTop: -5 }}>
              {getFieldDecorator("residence", {
               // initialValue: ["1", "1", "1"],
                rules: [
                  {
                    type: "array",
                    required: true,
                    message: "Vui lòng chọn địa chị!"
                  }
                ]
              })(<Cascader placeholder="Chọn địa chỉ" options={residences} />)}
            </Form.Item>
            <Form.Item style={{ marginTop: -5 }}>
              {getFieldDecorator("phone", {
                rules: [
                  {
                    required: true,
                    message: "Vui lòng nhập số điện thoại!"
                  }
                ]
              })(
                <Input
                  placeholder="Số điện thoại"
                  addonBefore={selectPhonenumber}
                  style={{ width: "100%" }}
                />
              )}
            </Form.Item>
            <div style={styles.item}>
                    <Radio.Group
              options={plainOptions}
              onChange={this.onChange}
              value={value}
            />
                    </div>
            {/* <Form.Item>
              {getFieldDecorator("gender", {
                rules: [
                  {
                    required: true,
                    message: "Vui lòng chọn giới tính của bạn!"
                  }
                ]
              })(
                <Select
                  placeholder="Giới tính"
                  onChange={this.handleSelectChange}
                >
                  <Option value="male">Nam</Option>
                  <Option value="female">Nữ</Option>
                </Select>
              )}
            </Form.Item> */}
            <Form.Item style={{ marginTop: -10 }}>
              {getFieldDecorator("agreement", {
                valuePropName: "checked"
              })(
                <Checkbox style={{color:"#FFFFFF"}}>
                  Tôi đồng ý với điều khoản sử dụng <a href="">chi tiết</a>
                </Checkbox>
              )}
            </Form.Item>

            <div style={styles.regis}>
              <Button
                type="primary"
                htmlType="submit"
                style={styles.buttonregis}
              //  onClick={this._register}
              >
                Đăng ký
              </Button>
            </div>
          </Form>
        </div>
      </div>
    );
  }
}
//export default withRouter(RegisterScreen);
export default withRouter(Form.create()(RegisterScreen));
const styles = {
  container: {
    height: "100%",
    width: "100%",
    display: "flex",
    position: "fixed",
    justifyContent: "center",
    alignItems: "center",
    backgroundSize: "cover",
    backgroundPosition: "center center",
    backgroundImage: `url(${resourceImg.img})`
  },
  containForm: {
    height: "100%",
    width: "100%",
    display: "flex",
    position: "fixed",
    flexDirection: "row",
   // marginLeft:"20%",
   // justifyContent: "center",
    alignItems: "center",
    backgroundColor: "rgba(64, 64, 64, 0.4)"
  },
  form: {
    maxWidth: 300,
    marginLeft: 40
  },
  item: {
    height: 40,
    width: "100%",
    marginTop: 20,
    marginBottom: 20
  },
  check: {
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
    height: 40,
    width: "100%",
    marginTop: 20,
    marginBottom: 20
  },
  regis: {
    justifyContent: "center",
    alignItems: "center",
    width: "100%",
    marginTop: -10
  },
  buttonregis: {
    height: 40,
    width: "100%",
    marginBottom: 10
  }
};
