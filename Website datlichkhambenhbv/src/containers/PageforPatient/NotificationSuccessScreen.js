import React, { Component } from "react";
import {
  withRouter
} from "react-router-dom";
import HeaderBar from '../../components/PatientComponents/HeaderBar'
import {DetailLichHen} from '../../apis/Api'
class NotificationSuccessScreen extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      lichhen: {}
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Thông báo";
  }
  componentWillMount() {
    const { id } = this.props.match.params;
    DetailLichHen(id, data => this.setState({ lichhen: data }));
  }
  render() {
    const { lichhen } = this.state;
    return (
      <div style={styles.container}>
        <div
          style={{
            width: "100%",
            height: "100%"
          }}
        >
          <HeaderBar login={() => this.props.history.push("/login")} />
          <div
            style={{
              height: "100%",
              width: "50%",
              marginLeft: "15%",
              display: "flex",
              flexDirection: "column"
            }}
          >
            <h1
              style={{
                marginTop: 60,
                color: "#000000",
                fontSize: 20,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial"
              }}
            >
              Cảm ơn bạn đã sử dụng dịch vụ đặt lịch phòng khám của chúng tôi.
            </h1>
            <h1
              style={{
                color: "#000000",
                fontSize: 18,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial",
                marginLeft: 10
              }}
            >
              Bạn đã đăng ký thành công lịch hẹn khám theo nội dung dưới đây.
            </h1>
            <h1
              style={{
                color: "#000000",
                fontSize: 18,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial",
                marginLeft: 30
              }}
            >
              {`Mã số bệnh nhân : ${lichhen.mabn_}.`}
            </h1>
            <h1
              style={{
                color: "#000000",
                fontSize: 18,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial",
                marginLeft: 30
              }}
            >
              {`Địa chỉ phòng khám : Khoa CƠ-XƯƠNG-KHỚP - Phòng khám Đa Khoa ReactJS Team.`}
            </h1>
            <h1
              style={{
                color: "#000000",
                fontSize: 18,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial",
                marginLeft: 30
              }}
            >
              {`Địa điểm khám : Phòng 302, thời gian ${lichhen.thoigian}, ngày ${lichhen.ngaykham}.`}
            </h1>
            <h1
              style={{
                color: "#000000",
                fontSize: 18,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial",
                marginLeft: 30
              }}
            >
              {`Thời gian nhắc lịch trước giờ hẹn 30 phút.`}
            </h1>
            <h1
              style={{
                color: "#000000",
                fontSize: 18,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial",
                marginLeft: 10
              }}
            >
              {`Hãy liên hệ với chúng tôi nếu bạn cần bất kỳ sự trợ giúp nào - Hotline : 091234567`}
            </h1>
            <h1
              style={{
                color: "#000000",
                fontSize: 18,
                fontFamily: "Times New Roman",
                width: "100%",
                textAlign: "left",
                fontWeight: "initial",
                marginLeft: 10
              }}
            >
              {`Xin cảm ơn!`}
            </h1>
            <h1
              style={{
                color: "#000000",
                fontSize: 40,
                marginTop: 0,
                fontFamily: "Times New Roman",
                fontWeight: "initial"
              }}
            >
              -REACTJS TEAM-
            </h1>
          </div>
        </div>
      </div>
    );
  }
}
export default withRouter(NotificationSuccessScreen);
const styles = {
  container: {
    height: "100%",
    width: "100%",
    display: "flex",
    position: "fixed",
    justifyContent: "center",
    alignItems: "center",
  },
  containForm: {
    height: "100%",
    width: "100%",
    display: "flex",
    position: "fixed",
    flexDirection: "row",
    alignItems: "center",
  }

};
