import React, { Component } from "react";
import{ListDoctor} from '../../apis/Api'
class DoctorComponents extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bacsi: []
    };
  }
  componentWillMount() {
    ListDoctor(data =>
      this.setState({ bacsi: data })
    );
  }
  render() {
    const { bacsi } = this.state;
    return (
      <div
        style={{
          width: "100%",
          height: "100%",
          display: "flex",
          flexDirection: "column"
        }}
      >
        {bacsi.map(item => (
          <div
            style={{
              height: 70,
              width: "100%",
              flexDirection: "column",
              display: "flex",
              justifyContent: "center",
              alignItems: "center"
            }}
            key={item.mabs}
          >
            <div
              style={{
                height: 50,
                width: 400,
                flexDirection: "column",
                display: "flex",
                justifyContent: "center",
                alignItems: "center"
              }}
            >
              <a
                style={{
                  color: "#000000",
                  fontSize: 18,
                  fontFamily: "Times New Roman",
                  width: "100%",
                  fontWeight: "initial"
                }}
                onClick={() => this.props.detailInfor(item.mabs)}
              >
                {item.tenbs}
              </a>
              <a
                style={{
                  color: "#3775C0",
                  fontSize: 18,
                  fontFamily: "Times New Roman",
                  width: "100%",
                  fontWeight: "initial"
                }}
                onClick={() => this.props.detailInfor(item.mabs)}
              >
                {`Khoa : ${item.makhoa_}`}
              </a>
            </div>

            <div
              style={{
                width: "100%",
                marginTop: 5,
                height: 1,
                backgroundColor: "#EEE8E8"
              }}
            ></div>
          </div>
        ))}
      </div>
    );
  }
}
export default DoctorComponents;
