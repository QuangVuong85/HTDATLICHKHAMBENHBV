import React, { Component } from "react";
import { Button } from "antd";
import { withRouter } from "react-router-dom";
import HeaderBar from "../../components/PatientComponents/HeaderBar";
import ScheduleComponent from "../../components/PatientComponents/ScheduleComponent";
import {ListDoctorByDepartment,DetailDoctor} from '../../apis/Api';
class ScheduleDepartScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      listDoctor: [
        // {
        //   bs : {},
        //   lichhenList:[]
        // },
      ]
      
    };
    document.title = "LỊCH KHÁM BÁC SĨ CHUYÊN KHOA";
  }
  componentWillMount() {
    const { id } = this.props.match.params;
    ListDoctorByDepartment(id,data =>
      {
        this.setState({ listDoctor: data });
        // for(let i = 0 ;i < data.length; i++){
        //   DetailDoctor(data[i].mabs,dataDetail =>
        //     {
        //       listDoctor.push(dataDetail)
        //     })
        // }
      })
    // this.setState({ listDoctor: listDoctor });
  }
  render() {
    const { listDoctor } = this.state;
    return (
      <div
        style={{
          width: "100%",
          height: "100%",
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          backgroundSize: "cover",
          backgroundColor: "#E2E2E2"
        }}
      >
        <HeaderBar login={() => this.props.history.push("/login")} />
        {listDoctor.map(item => (
          <div
            style={{
              height: "auto",
              width: "90%",
              flexDirection: "row",
              display: "flex",
              alignItems: "flex-start",
              backgroundColor: "#FFFFFF",
              marginBottom: 20
            }}
            key={item.mabs}
          >
            <ScheduleComponent
              bacsiID={item.mabs}
              login={() => this.props.history.push("/login")}
              bookAppointment={(idLichhen,idBS) =>
                this.props.history.push(`/bookAppointment/${idBS}/${idLichhen}`)
              }
            />
          </div>
        ))}
      </div>
    );
  }
}
export default withRouter(ScheduleDepartScreen);
