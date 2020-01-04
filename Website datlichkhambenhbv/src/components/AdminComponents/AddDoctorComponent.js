import React, { Component } from "react";
import { Form, Select, Input, Icon, Button, message } from "antd";
import { withRouter } from "react-router-dom";
const formItemLayout = {
  labelCol: {
    xs: { span: 24 },
    sm: { span: 8 }
  },
  wrapperCol: {
    xs: { span: 24 },
    sm: { span: 16 }
  }
};
const tailFormItemLayout = {
  wrapperCol: {
    xs: {
      span: 24,
      offset: 0
    },
    sm: {
      span: 16,
      offset: 8
    }
  }
};
const { Option } = Select;

const hocvi = ["Tiến sĩ","Thạc sĩ","Giáo sư"]
class AddDoctorComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
     
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Đăng ký";
  }
  addDoctor = e => {
    e.preventDefault();
    this.props.form.validateFieldsAndScroll((error, values) => {
      if(error == null){
        console.log(values)
      }else{
        console.log(error)
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
  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <div style={styles.container}>
        <Form
          style={styles.form}
          {...formItemLayout}
          onSubmit={this.addDoctor}
        >
          <Form.Item label="Tên đăng nhập">
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
              />
            )}
          </Form.Item>

          <Form.Item label="Nhập mật khẩu">
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

          <Form.Item label="Nhập lại mật khẩu">
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
          <Form.Item label="Họ Tên">
            {getFieldDecorator("name", {
              rules: [{ required: true, message: "Vui lòng nhập họ tên!" }]
            })(
              <Input
                prefix={
                  <Icon type="user" style={{ color: "rgba(0,0,0,.3)" }} />
                }
                placeholder="Họ Tên"
              />
            )}
          </Form.Item>
          <Form.Item label="Học vị">
            {getFieldDecorator("hocvi", {
              rules: [
                {
                  required: true,
                  message: "Vui lòng chọn học vị!"
                }
              ]
            })(
              <Select
                size="large"
                placeholder="Học vị"
               // onChange={this.handleSelectChange}
              >
                {hocvi.map(item => (
                  <Option key={item}>{item}</Option>
                ))}
              </Select>
            )}
          </Form.Item>
          <Form.Item label="Chức vụ">
            {getFieldDecorator("option", {
              rules: [
                {
                  required: true,
                  message: "Vui lòng chọn chức vụ!"
                }
              ]
            })(
              <Select
                size="large"
                placeholder="Chức vụ"
               // onChange={this.handleSelectChange}
              >
                <Option value="male">Nam</Option>
                <Option value="female">Nữ</Option>
              </Select>
            )}
          </Form.Item>
          <Form.Item label="Khoa">
            {getFieldDecorator("depart", {
              rules: [
                {
                  required: true,
                  message: "Vui lòng chọn khoa!"
                }
              ]
            })(
              <Select
                size="large"
                placeholder="Khoa"
               // onChange={this.handleSelectChange}
              >
                <Option value="male">Nam</Option>
                <Option value="female">Nữ</Option>
              </Select>
            )}
          </Form.Item>
          {/* <Form.Item {...tailFormItemLayout}>
            <Button type="primary" htmlType="submit">
              Thêm mới
            </Button>
          </Form.Item> */}
          <div
            style={{
              position: 'absolute',
              right: 0,
              bottom: 0,
              width: '100%',
              borderTop: '1px solid #e9e9e9',
              padding: '10px 16px',
              background: '#fff',
              textAlign: 'right',
            }}
          >
            <Button style={{ marginRight: 8 }}>
              Hủy
            </Button>
            <Button type="primary" htmlType="submit">
              Thêm mới
            </Button>
          </div>
        </Form>
      </div>
    );
  }
}
export default withRouter(Form.create()(AddDoctorComponent));
const styles = {
  container: {
    height: "100%",
    width: "100%",
    justifyContent: "center",
    alignItems: "center"
  },
  form: {
    maxWidth: 400,
  },
};
