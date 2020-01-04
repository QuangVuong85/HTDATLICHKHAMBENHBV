import React, { Component } from "react";
import {
  Form,
  Select,
  Input,
  Icon,
  Button,
  message,
  TimePicker,
  DatePicker
} from "antd";
import { withRouter } from "react-router-dom";
import moment from "moment";
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
const bacsi = {
  MaBS: "BS07",
  TenBS: "Giáo sư, Tiến sĩ Trần Ngọc Ân",
  ChucVu: "Giáo sư, Tiến sĩ Khoa học Trị liệu Thần kinh Cột sống",
  TenKhoa: "THẦN KINH",
  MaKhoa: "K02",
  ThoiGian: [
    "07:30",
    "08:00",
    "08:30",
    "09:00",
    "09:30",
    "10:00",
    "10:30",
    "11:00",
    "14:00",
    "14:30",
    "15:00",
    "15:30",
    "16:00",
    "16:30",
    "17:00",
    "17:30"
  ],
  TrangThai: false,
  DichVu: [
    {
      TenDV: "Xét nghiệm máu 24 chỉ số",
      DonGia: "600.000 đ",
      MaDV: "DV01"
    },
    {
      TenDV: "Chụp cộng hưởng từ (MRI) 1.5Tesla sọ não",
      DonGia: "600.000 đ",
      MaDV: "DV02"
    },
    {
      TenDV: "Cắt lớp vi tính (CT Scanner) sọ não",
      DonGia: "600.000 đ",
      MaDV: "DV03"
    },
    {
      TenDV: "X-Quang sọ não",
      DonGia: "600.000 đ",
      MaDV: "DV04"
    }
  ]
};
class UpdateScheduleComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
    document.title = "Phòng khám Đa khoa ReactJS Team - Đăng ký";
  }
  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFields((err, fieldsValue) => {
      if (err === null) {
        const values = {
          ...fieldsValue,
          "date-picker": fieldsValue["date-picker"].format("YYYY-MM-DD"),
          "time-picker": fieldsValue["time-picker"].format("HH:mm")
        };
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
          <Form.Item label="Ngày khám">
            {getFieldDecorator("date-picker", {
              //  initialValue: moment("01/01/2020", dateFormat),
              rules: [
                {
                  type: "object",
                  required: true,
                  message: "Vui lòng chọn ngày!"
                }
              ]
            })(
              <DatePicker
                value={moment("01/01/2020", dateFormat)}
                format={dateFormat}
                placeholder="Chọn ngày"
                style={{ width: 150 }}
              />
            )}
          </Form.Item>

          <Form.Item label="Thời gian khám">
            {getFieldDecorator("time-picker", {
              // initialValue : moment("12:08", format),
              rules: [
                { type: "object", required: true, message: "Vui lòng chọn thời gian!" }
              ]
            })(
              <TimePicker
                placeholder="Chọn thời gian"
                format={format}
                style={{ width: 150 }}
              />
            )}
          </Form.Item>

          <Form.Item label="Dịch vụ khám"
            wrapperCol={{
              xs: { span: 24, offset: 0 },
              sm: { span: 16, offset: 8 }
            }}
          >
            {bacsi.DichVu.map(item => (
                <div
                  style={{
                    width: "100%",
                    flexDirection: "column",
                    display: "flex"
                  }}
                  key={item.MaDV}
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
                        width: "80%",
                        flexDirection: "column",
                        display: "flex"
                      }}
                    >
                      <h1
                        style={{
                          fontSize: 17,
                          marginLeft: 10,
                          fontFamily: "Times New Roman",
                          width: "100%",
                          fontWeight: "initial"
                        }}
                      >
                        {item.TenDV}
                      </h1>
                    </div>

                    <h1
                      style={{
                        fontSize: 17,
                        marginLeft: 10,
                        fontFamily: "Times New Roman",
                        width: "25%",
                        fontWeight: "initial"
                      }}
                    >
                      {item.DonGia}
                    </h1>
                  </div>
                  <div
                    style={{
                      width: "100%",
                      height: 1,
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
              Cập nhật
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
              Cập nhật
            </Button>
          </div>
        </Form>
      </div>
    );
  }
}
export default withRouter(Form.create()(UpdateScheduleComponent));
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
