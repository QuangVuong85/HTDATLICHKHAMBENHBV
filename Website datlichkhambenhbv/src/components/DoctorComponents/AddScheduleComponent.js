import React, { Component } from "react";
import {
  Form,
  Button,
  TimePicker,
  DatePicker
} from "antd";

import { withRouter } from "react-router-dom";
import {ListService,Add_LichHen,ListLichHen} from '../../apis/Api'
import DoctorInfoManager from "../../models/DoctorInfoManager";

const DoctorInfoManagerInstance = DoctorInfoManager.getDoctorInfoManagerInstance();
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
const format = "HH:mm";
const dateFormat = "DD/MM/YYYY";

class AddScheduleComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      service:[],
      listLichHen:[],
      doctorInfo: DoctorInfoManagerInstance.doctorInfo
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Đăng ký";
  }

  componentWillMount(){
    ListService(dataService => this.setState({service : dataService}))
    ListLichHen(data => this.setState({listLichHen : data}))
  }

  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFields((err, fieldsValue) => {
      if (err === null) {
        var values = {
          ...fieldsValue,
          "ngaykham": fieldsValue["ngaykham"].format("DD/MM/YYYY"),
          "thoigian": fieldsValue["thoigian"].format("HH:mm")   //fieldsValue["ngaykham"] time now
        };
        
        const{listLichHen, doctorInfo} = this.state;

        values.malichhen = `LH${listLichHen.length}`
        values.mabs_ = doctorInfo.mabs;
        values.trangthai = 0;
        console.log("Received values of form: ", values);
        Add_LichHen(values);
      }
    });
  };

  render() {
    const { getFieldDecorator } = this.props.form;
    const {service} = this.state
    return (
      <div style={styles.container}>
        <Form
          style={styles.form}
          {...formItemLayout}
          onSubmit={this.handleSubmit}
        >
          <Form.Item label="Ngày khám">
            {getFieldDecorator("ngaykham", {
              rules: [
                {
                  type: "object",
                  required: true,
                  message: "Vui lòng chọn ngày!"
                }
              ]
            })(
              <DatePicker
                format={dateFormat}
                placeholder="Chọn ngày"
                style={{ width: 150 }}
              />
            )}
          </Form.Item>

          <Form.Item label="Thời gian khám">
            {getFieldDecorator("thoigian", {
              rules: [
                {
                  type: "object",
                  required: true,
                  message: "Vui lòng chọn thời gian!"
                }
              ]
            })(
              <TimePicker
                placeholder="Chọn thời gian"
                format={format}
                style={{ width: 150 }}
              />
            )}
          </Form.Item>

          <Form.Item
            label="Dịch vụ khám"
            wrapperCol={{
              xs: { span: 24, offset: 0 },
              sm: { span: 16, offset: 8 }
            }}
          >
            {service.map(item => (
              <div
                style={{
                  width: "100%",
                  flexDirection: "column",
                 // marginTop : -30,
                  display: "flex"
                 
                }}
                key={item.madv}
              >
                <div
                  style={{
                    width: "100%",
                    flexDirection: "row",
                    display: "flex"
                  }}
                >
                  <div
                    style={{
                      width: "70%",
                      flexDirection: "column",
                      display: "flex"
                    }}
                  >
                    <p
                      style={{
                        fontSize: 16,
                        //marginLeft: 10,
                        fontFamily: "Times New Roman",
                        width: "100%",
                        fontWeight: "initial"
                      }}
                    >
                      {item.tendv}
                    </p>
                  </div>

                  <p
                    style={{
                      fontSize: 16,
                      marginLeft: 10,
                      fontFamily: "Times New Roman",
                      width: "25%",
                      fontWeight: "initial"
                    }}
                  >
                    {item.dongia.toLocaleString('vi', {style : 'currency', currency : 'VND'})}
                  </p>
                </div>
                <div
                  style={{
                    width: "100%",
                    height: 1,
                    marginTop:-20,
                    backgroundColor: "#E2E2E2"
                  }}
                ></div>
              </div>
            ))}
          </Form.Item>
          {/* <Form.Item
            wrapperCol={{
              xs: { span: 24, offset: 0 },
              sm: { span: 16, offset: 8 }
            }}
          >
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
export default withRouter(Form.create()(AddScheduleComponent));
const styles = {
  container: {
    height: "100%",
    width: "100%",
    justifyContent: "center",
    alignItems: "center"
  },
  form: {
    marginTop:30,
    maxWidth: 500,
  }
};
