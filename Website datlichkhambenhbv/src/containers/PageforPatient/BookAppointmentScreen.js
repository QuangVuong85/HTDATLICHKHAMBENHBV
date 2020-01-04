import React, { Component } from "react";
import { Form, Icon, Input, Button, Checkbox, message, Radio } from "antd";
import {
  withRouter
} from "react-router-dom";
import HeaderBar from "../../components/PatientComponents/HeaderBar";
import UserInfoManager from "../../models/UserInfoManager";
import icon from "../../resources/icons/index";
import {ListService,DetailDoctor,update_LichHen} from '../../apis/Api'

const UserInfoManagerInstance = UserInfoManager.getUserInfoManagerInstance();
const plainOptions = ["Đặt cho mình", "Đặt cho người thân"];
const plainOptions1 = ["Nam", "Nữ"];
class BookAppointmentScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bacsi:{
        bs:{},
        lichhenList:[]
      },
      service:[],
      time:{},
      value: "Đặt cho mình",
      value1: "Nam",
      value2:'',
      userInfo: UserInfoManagerInstance.userInfo
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Đặt lịch khám";
  }
  componentWillMount() {
    const { id,idLichhen } = this.props.match.params;
    console.log(id)
    ListService(data => this.setState({ service: data }));
    DetailDoctor(id, bacsi => {
      for(let i = 0 ; i < bacsi.lichhenList.length;i++){
        if(bacsi.lichhenList[i].malichhen === idLichhen){
          this.setState({ time: bacsi.lichhenList[i] });
          break;
        }
      }
      this.setState({ bacsi: bacsi });
    });
  }
  onChange = e => {
    console.log("radio checked", e.target.value);
    this.setState({
      value: e.target.value
    });
  };
  onChange1 = e => {
    console.log("radio checked", e.target.value);
    this.setState({
      value1: e.target.value
    });
  };
 
  DatLich(){
    const { idLichhen } = this.props.match.params;
    const { userInfo} = this.state;
    let tmp = {
      malichhen: idLichhen,
      mabn : userInfo.mabn,
      trangthai: 1,
      ghichu: 'Đã đặt thành công'
    }
    update_LichHen(tmp)
    this.props.history.push(`/notificationSuccess/${idLichhen}`)
  }
  render() {
    const { userInfo, value,value1,bacsi,service,time,value2 } = this.state;
    console.log("bacsi", bacsi);
    return (
      <div style={styles.container}>
        <HeaderBar login={() => this.props.history.push("/login")} />
        <div
          style={{
            width: "35%",
            height: "100%",
            marginTop: 20
          }}
        >
          <div
            style={{
              width: "100%",
              height: 20,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              justifyContent: "center",
              marginTop: 15
            }}
          >
            <Radio.Group
              options={plainOptions}
              onChange={this.onChange}
              value={value}
            />
          </div>

          {value === "Đặt cho mình" ? (
            <div
              style={{
                width: "100%",
                height: "auto",
                display: "flex",
                flexDirection: "column",
                backgroundColor: "#FFFFFF",
                marginTop: 20
              }}
            >
              <p
                style={{
                  fontSize: 16,
                  fontWeight: "bold",
                  marginLeft: 10,
                  marginTop: 10
                }}
              >
                THÔNG TIN BỆNH NHÂN
              </p>
              <div style={styles.containInfo}>
                <img
                  src={icon.user}
                  style={{ width: 20, height: 20, marginTop: -10 }}
                />
                <h1 style={styles.textInfo}>{`Họ tên : ${userInfo.hoten}`}</h1>
              </div>
              <div style={styles.containInfo}>
                <img
                  src={icon.gender}
                  style={{ width: 20, height: 20, marginTop: -10 }}
                />
                <h1
                  style={styles.textInfo}
                >{`Giới tính : ${userInfo.gioitinh == 1 ? 'Nam' : 'Nữ'}`}</h1>
              </div>
              <div style={styles.containInfo}>
                <img
                  src={icon.email}
                  style={{ width: 20, height: 20, marginTop: -10 }}
                />
                <h1 style={styles.textInfo}>{`Email : ${userInfo.email}`}</h1>
              </div>
              <div style={styles.containInfo}>
                <img
                  src={icon.phone}
                  style={{ width: 20, height: 20, marginTop: -10 }}
                />
                <h1
                  style={styles.textInfo}
                >{`Số điện thoại : ${userInfo.sodt}`}</h1>
              </div>
              <div style={styles.containInfo}>
                <img
                  src={icon.location}
                  style={{ width: 20, height: 20, marginTop: -10 }}
                />
                <h1
                  style={styles.textInfo}
                >{`Địa chỉ : ${userInfo.diachi}`}</h1>
              </div>
            </div>
          ) : (
            <div
              style={{
                width: "100%",
                height: "auto",
                display: "flex",
                flexDirection: "column",
                backgroundColor: "#FFFFFF",
                marginTop: 20
              }}
            >
              <p
                style={{
                  fontSize: 16,
                  fontWeight: "bold",
                  marginLeft: 10,
                  marginTop: 10
                }}
              >
                THÔNG TIN NGƯỜI ĐẶT
              </p>
              <div style={styles.containInfo}>
                <img
                  src={icon.user}
                  style={{ width: 20, height: 20, marginTop: -10 }}
                />
                <h1 style={styles.textInfo}>{`Họ tên : ${userInfo.hoten}`}</h1>
              </div>
              <div style={styles.containInfo}>
                <img
                  src={icon.email}
                  style={{ width: 20, height: 20, marginTop: -10 }}
                />
                <h1 style={styles.textInfo}>{`Email : ${userInfo.email}`}</h1>
              </div>
              <div style={styles.containInfo}>
                <img
                  src={icon.phone}
                  style={{ width: 20, height: 20, marginTop: -10 }}
                />
                <h1
                  style={styles.textInfo}
                >{`Số điện thoại : ${userInfo.sodt}`}</h1>
              </div>
              <p
                style={{
                  fontSize: 16,
                  fontWeight: "bold",
                  marginLeft: 10,
                  marginTop: 10
                }}
              >
                THÔNG TIN NGƯỜI BỆNH
              </p>
              <div style={styles.item}>
                <Input
                  style={{ height: 40,width:'80%',marginLeft:'10%'}}
                  defaultValue={value2}
                  onChange={(text) => this.setState({value2 : text})}
                  prefix={
                    <Icon type="user" style={{ color: "rgba(0,0,0,.25)" }} />
                  }
                  placeholder="Họ tên người bệnh"
                />
              </div>
              
              <div style={styles.item}>
              <h1
                  style={{color: "#000000",
                  fontSize: 17,
                  marginLeft: 10,
                  marginTop: 10,
                  fontFamily: "Times New Roman",
                  width: 100,
                  marginLeft:'10%',
                  fontWeight: "initial"}}
                >{`Giới tính`}</h1>
                <Radio.Group
                  options={plainOptions1}
                  onChange={this.onChange1}
                  value={value1}
                />
              </div>
            </div>
          )}
          <div
            style={{
              width: "100%",
              height: "auto",
              display: "flex",
              flexDirection: "column",
              backgroundColor: "#FFFFFF",
              marginTop: 20
            }}
          >
            <p
              style={{
                fontSize: 16,
                fontWeight: "bold",
                marginLeft: 10,
                marginTop: 10
              }}
            >
              THÔNG TIN KHÁM
            </p>
            <div style={styles.containInfo}>
              <img
                src={icon.user}
                style={{ width: 20, height: 20, marginTop: -10 }}
              />
              <h1 style={styles.textInfo}>{`Họ tên bác sĩ: ${bacsi.bs.tenbs}`}</h1>
            </div>
            <div style={styles.containInfo}>
              <img
                src={icon.department}
                style={{ width: 20, height: 20, marginTop: -10 }}
              />
              <h1 style={styles.textInfo}>{`Khoa : ${bacsi.bs.makhoa_}`}</h1>
            </div>
            <div style={styles.containInfo}>
              <img
                src={icon.degree}
                style={{ width: 20, height: 20, marginTop: -10 }}
              />
              <h1 style={styles.textInfo}>{`Chức vụ : ${bacsi.bs.chucvu}`}</h1>
            </div>
            <div style={styles.containInfo}>
              <img
                src={icon.clock}
                style={{ width: 20, height: 20, marginTop: -10 }}
              />
              <h1 style={styles.textInfo}>{`Thời gian khám : ${time.thoigian}`}</h1>
            </div>
            <div style={styles.containInfo}>
              <img
                src={icon.location}
                style={{ width: 20, height: 20, marginTop: -10 }}
              />
              <h1 style={styles.textInfo}>{`Địa điểm : Phòng khám 302 - Khoa ${bacsi.bs.makhoa_}`}</h1>
            </div>

            <div style={styles.itemContain}>
              <h1
                style={{
                  fontSize: 18,
                  marginLeft: 10,
                  fontFamily: "Times New Roman",
                  width: "90%",
                  fontWeight: "600"
                }}
              >
                {"Các dịch vụ khám và giá liên quan"}
              </h1>
              <div
                style={{
                  width: "100%",
                  height: 1,
                  backgroundColor: "#E2E2E2"
                }}
              ></div>
              {service.map(item => (
                <div
                  style={{
                    width: "100%",
                    flexDirection: "column",
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
                        {item.tendv}
                      </h1>
                      <h1
                        style={{
                          fontSize: 15,
                          marginLeft: 10,
                          marginTop: -10,
                          fontFamily: "Times New Roman",
                          width: "90%",
                          fontWeight: "500"
                        }}
                      >
                        {"(Theo chỉ định của bác sĩ)"}
                      </h1>
                    </div>

                    <h1
                      style={{
                        fontSize: 17,
                        marginLeft: 10,
                        fontFamily: "Times New Roman",
                        width: "20%",
                        fontWeight: "initial"
                      }}
                    >
                      {item.dongia.toLocaleString('vi', {style : 'currency', currency : 'VND'})}
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
            </div>
          </div>
          <Button
            type="primary"
            block
            style={{ marginTop: 20, marginBottom: 30 }}
            onClick={() => this.DatLich()}
          >
            XÁC NHẬN ĐẶT LỊCH
          </Button>
        </div>
      </div>
    );
  }
}

export default withRouter(BookAppointmentScreen);
const styles = {
  container: {
    width: "100%",
    height: "100%",
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  //  backgroundSize: "cover",
    backgroundColor: "#E2E2E2"
  },
  form: {
    maxWidth: 300,
    marginTop: 100
  },
  item: {
    height: 40,
    width: "100%",
    display:'flex',
    flexDirection:'row',
    //justifyContent:'center',
    alignItems:'center',
  },
  containInfo: {
    width: "100%",
    height: 50,
    marginTop: -10,
    marginLeft: 20,
    display: "flex",
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center"
  },
  textInfo: {
    color: "#000000",
    fontSize: 17,
    marginLeft: 10,
    fontFamily: "Times New Roman",
    width: "90%",
    fontWeight: "initial"
  }
};
