import React, { Component } from "react";
import{ListService} from '../../apis/Api'
class ServiceInfoComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      service: []
    };
  }
  componentWillMount() {
    ListService(data =>
      this.setState({ service: data })
    );
  }
  render() {
    const { service } = this.state;
    return (
      <div
        style={{
          width: "100%",
          height: "100%",
          display: "flex",
          flexDirection: "column"
        }}
      >
        {service.map(item => (
          <div
            style={{
              height: 70,
              width: "100%",
              flexDirection: "column",
              display: "flex",
              justifyContent: "center",
              alignItems: "center"
            }}
            key={item.madv}
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
               
              >
                {item.tendv}
              </a>
              <a
                style={{
                  color: "#3775C0",
                  fontSize: 18,
                  fontFamily: "Times New Roman",
                  width: "100%",
                  fontWeight: "initial"
                }}
                
              >
                {`Giá : ${item.dongia.toLocaleString('vi', {style : 'currency', currency : 'VND'})}`}
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
export default ServiceInfoComponent;
