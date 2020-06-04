import React, { Component } from "react";
import { Form, Icon, Input, Button, Checkbox, Modal } from "antd";
import { withRouter } from "react-router-dom";
import resourceImg from "../../resources/images/index";
import HeaderBar from "../../components/PatientComponents/HeaderBar";
import DepartmentComponent from "../../components/PatientComponents/DepartmentComponent";
import DoctorInfoComponent from "../../components/PatientComponents/DoctorInfoComponent";
import ServiceInfoComponent from "../../components/PatientComponents/ServiceInfoComponent";
import UserInfoManager from "../../models/UserInfoManager";
const UserInfoManagerInstance = UserInfoManager.getUserInfoManagerInstance();

class HomeScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      visible: false,
      visible1: false,
      visible2:false,
      userInfo: UserInfoManagerInstance.userInfo
    };
    document.title = 'Phòng khám Đa khoa ReactJs Team'
    UserInfoManagerInstance.addObserver(this);
  }
  componentWillUnmount() {
    UserInfoManagerInstance.removeObserver(this);
  }
  onUserInfoChanged = () => {
    this.setState({ userInfo: UserInfoManagerInstance.userInfo });
  };
  showModal = () => {
    this.setState({
      visible: true
    });
  };
  handleCancel = e => {
    this.setState({
      visible: false
    });
  };
  showModalDoctor = () => {
    this.setState({
      visible1: true
    });
  };
  handleDoctorCancel = e => {
    this.setState({
      visible1: false
    });
  };
  showModalService =() => {
    this.setState({
      visible2: true
    });
  }
  handleServiceCancel = e => {
    this.setState({
      visible2: false
    });
  };
  render() {
    const { userInfo } = this.state;
    return (
      <div style={styles.container}>
        <div
          style={{
            width: "100%",
            height: "100%",
            backgroundColor: "rgba(64, 64, 64, 0.4)"
          }}
        >
          <HeaderBar
            login={() => this.props.history.push("/login")}         
          />
          <div
            style={{
              height: "100%",
              width: "40%",
              marginLeft: "15%",
              display: "flex",
              flexDirection: "column"
            }}
          >
            <h1
              style={{
                color: "#F0FF11",
                fontSize: 20,
                marginTop: 80,
                fontFamily: "Times New Roman",
                fontWeight: "initial"
              }}
            >
              Dịch vụ khám và chữa bệnh
            </h1>
            <h1
              style={{
                color: "#FFFFFF",
                fontSize: 50,
                marginTop: 0,
                fontFamily: "Times New Roman",
                fontWeight: "initial"
              }}
            >
              PHÒNG KHÁM ĐA KHOA REACTJS TEAM
            </h1>
            <div
              style={{
                width: "100%",
                marginTop: -15,
                height: 2,
                backgroundColor: "#F0FF11"
              }}
            ></div>
            <h1
              style={{
                marginTop: 30,
                color: "#FFFFFF",
                fontSize: 20,
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
            {!userInfo ? (
              <div
                style={{
                  width: "100%",
                  height: 60,
                  display: "flex",
                  flexDirection: "row",
                  alignItems: "center",
                  justifyContent: "center"
                }}>
                <Button
                  type="primary"
                  icon="login"
                  style={styles.styleButton}
                  onClick={() => this.props.history.push("/login")}>
                  Đăng nhập
                </Button>
                <Button
                  icon="user-add"
                  style={styles.styleButton}
                  onClick={() => this.props.history.push("/register")}>
                  Đăng ký
                </Button>
              </div>
            ) : (
              <div style={styles.containSelect}>
                <div
                  style={{
                    height: "auto",
                    width: 40,
                    display: "flex",
                    flexDirection: "column"
                  }}
                >
                  <h1 style={styles.textNumber}>01</h1>
                  <div style={styles.line}></div>
                </div>
                <div style={styles.containDescription}>
                  <h1 style={styles.textDescription}>CHUYÊN KHOA</h1>
                  <h1 style={styles.textDescriptionDetaill}>
                    Với các trang thiết bị hiện đại,tiến tiến nhất thế giới
                  </h1>
                  <Button
                    type="primary"
                    style={{ marginLeft: 20 }}
                    onClick={this.showModal}
                  >
                    Đặt lịch ngay
                  </Button>
                </div>

                <div style={styles.containNumber}>
                  <h1 style={styles.textNumber}>02</h1>
                  <div style={styles.line}></div>
                </div>
                <div style={styles.containDescription}>
                  <h1 style={styles.textDescription}>BÁC SĨ</h1>
                  <h1 style={styles.textDescriptionDetaill}>
                    Là các chuyên gia đầu ngành có trình độ chuyên môn cao
                  </h1>
                  <Button
                    type="primary"
                    style={{ marginLeft: 20 }}
                    onClick={this.showModalDoctor}
                  >
                    Đặt lịch ngay
                  </Button>
                </div>

                <div style={styles.containNumber}>
                  <h1 style={styles.textNumber}>03</h1>
                  <div style={styles.line}></div>
                </div>
                <div style={styles.containDescription}>
                  <h1 style={styles.textDescription}>DỊCH VỤ</h1>
                  <h1 style={styles.textDescriptionDetaill}>
                    Chăm sóc sức khỏe linh động giá ưu đãi tốt nhất
                  </h1>
                  <Button
                    type="primary"
                    style={{ marginLeft: 20 }}
                    onClick={this.showModalService}
                  >
                    Xem dịch vụ
                  </Button>
                </div>
              </div>
            )}
          </div>
        </div>

        <Modal
          title="CHUYÊN KHOA"
          visible={this.state.visible}
          onOk={this.handleCancel}
          onCancel={this.handleCancel}
        >
          <DepartmentComponent
            listDoctor={(id_Khoa) =>
              this.props.history.push(
                `/listDoctor/${id_Khoa}`
              )
            }
          />
        </Modal>
        <Modal
          title="BÁC SĨ"
          visible={this.state.visible1}
          onOk={this.handleDoctorCancel}
          onCancel={this.handleDoctorCancel}
        >
          <DoctorInfoComponent
            detailInfor={(id_BS) =>
              this.props.history.push(`/detailInfor/${id_BS}`)
            }
          />
        </Modal>
        <Modal
          title="DỊCH VỤ KHÁM"
          visible={this.state.visible2}
          onOk={this.handleServiceCancel}
          onCancel={this.handleServiceCancel}
        >
          <ServiceInfoComponent
            
          />
        </Modal>
      </div>
    );
  }
}
export default withRouter(HomeScreen);
const styles = {
  container: {
    width: "100%",
    height: "100%",
    position: "fixed",
    backgroundSize: "cover",
    backgroundPosition: "center center",
    backgroundImage: `url(${resourceImg.img})`
  },
  containSelect: {
    height: "auto",
    width: "auto",
    marginRight: -200,
    marginTop: 20,
    display: "flex",
    flexDirection: "row"
  },
  sizeImg: {
    width: "100%",
    height: "100%"
  },
  containNumber: {
    height: "auto",
    width: 40,
    marginLeft: 100,
    display: "flex",
    flexDirection: "column"
  },
  line: {
    width: "auto",
    marginTop: -30,
    height: 3,
    backgroundColor: "#F0FF11"
  },
  textNumber: {
    fontSize: 45,
    color: "#FFFFFF",
    fontFamily: "Times New Roman",
    fontWeight: "bold"
  },
  containDescription: {
    height: "auto",
    width: 160,
    display: "flex",
    flexDirection: "column"
  },
  textDescription: {
    color: "#FFFFFF",
    fontSize: 20,
    width: "100%",
    marginLeft: 20,
    marginTop: 15,
    fontFamily: "Times New Roman",
    fontWeight: "600"
  },
  textDescriptionDetaill: {
    color: "#FFFFFF",
    fontSize: 15,
    marginLeft: 20,
    fontFamily: "Times New Roman",
    width: "100%",
    height: 80,
    fontWeight: "100"
  },
  styleButton: {
    height: 40,
    width: 150,
    marginRight: 20,
    color: "#FFFFFF",
    backgroundColor: "#3775C0",
    borderRadius: 20,
    borderColor: "#3775C0"
  }
};
// position: "fixed",
// position:'inherit',
// position :'initial',
// position :"relative",
// position :"revert",
// position :'static',
// position :'sticky',
// position :'unset',
