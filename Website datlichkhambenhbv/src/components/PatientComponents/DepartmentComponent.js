import React, { Component } from "react";
import {ListDepartment} from '../../apis/Api'
class DepartmentComponents extends Component {
  constructor(props) {
    super(props);
    this.state = {
      khoa:[]
    };
  }
  componentWillMount(){
    ListDepartment(data => this.setState({khoa : data}))
  }
  render() {
    const {khoa} = this.state
    return (
      <div
        style={{
          width: "100%",
          height: "100%",
          display: "flex",
          flexDirection: "column"
        }}
      >
        {khoa.map(item => (
          <div
            style={{
              height: 40,
              width: "100%",
              flexDirection: "column",
              display: "flex",
              justifyContent: "center",
              alignItems: "center"
            }}
            key={item.makhoa}
          >
            <a
              style={{
                color: "#000000",
                fontSize: 18,
                marginLeft: 20,
                fontFamily: "Times New Roman",
                width: "90%",
                fontWeight: "initial"
              }}
              onClick={() => this.props.listDoctor(item.makhoa,item.tenkhoa)}
            >
              {item.tenkhoa}
            </a>
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
export default DepartmentComponents;
