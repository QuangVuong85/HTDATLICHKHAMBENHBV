import React, { Component } from "react";
import {
  Form,
  Input,
  Button,
  message,
} from "antd";
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
class AddServiceComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        openAccountSetting : false,
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Đăng ký";
  }
  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (err === null) {
        console.log("Received values of form: ", values);
      }
    });
  };

  render() {
    const { getFieldDecorator } = this.props.form;

    return (
      <div style={styles.container}>
        <Form
          style={styles.form}
          {...formItemLayout}
          onSubmit={this.handleSubmit}
        >
          <Form.Item label="Tên dịch vụ">
            {getFieldDecorator("name", {
              rules: [
                {
                  required: true,
                  message: "Vui lòng nhập tên dịch vụ!"
                }
              ]
            })(<Input placeholder="Dịch vụ khám" />)}
          </Form.Item>
          <Form.Item label="Giá khám">
            {getFieldDecorator("rate", {
              rules: [
                {
                  required: true,
                  message: "Vui lòng nhập giá dịch vụ!"
                }
              ]
            })(<Input placeholder="Giá" />)}
          </Form.Item>
          <Form.Item
            wrapperCol={{
              xs: { span: 24, offset: 0 },
              sm: { span: 16, offset: 8 }
            }}
          >
            <Button type="primary" htmlType="submit">
              Thêm mới
            </Button>
          </Form.Item>
        </Form>
        
      </div>
    );
  }
}
export default withRouter(Form.create()(AddServiceComponent));
const styles = {
  container: {
    height: "100%",
    width: "100%",
    justifyContent: "center",
    alignItems: "center"
  },
  form: {
    marginTop : 30,
    maxWidth: 400,
  }
};
