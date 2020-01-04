import React, { Component } from "react";
import { withRouter } from "react-router-dom";
import HeaderBar from "../../components/PatientComponents/HeaderBar";
import ScheduleComponent from "../../components/PatientComponents/ScheduleComponent";
import {DetailDoctor} from '../../apis/Api'
class DetailInfoScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
    };
    document.title = "THÔNG TIN BÁC SĨ";
  }
  render() {
    const { id } = this.props.match.params;
    return (
      <div
        style={{
          width: "100%",
          height: "100%",
          display: "flex",
          position: "absolute",
          flexDirection: "column",
          alignItems: "center"
        }}>
        <HeaderBar login={() => this.props.history.push("/login")} />
        <ScheduleComponent
          bacsiID={id}
          login={() => this.props.history.push("/login")}
          bookAppointment={(idLichhen,idBS) =>
            this.props.history.push(`/bookAppointment/${idBS}/${idLichhen}`)
          }
        />
      </div>
    );
  }
}
export default withRouter(DetailInfoScreen);
