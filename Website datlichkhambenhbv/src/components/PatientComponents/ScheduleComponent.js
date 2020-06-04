import React, { Component } from "react";
import { Button, DatePicker } from "antd";
import moment from 'moment';
import {ListService,DetailDoctor} from '../../apis/Api'
import resourceImg from "../../resources/images/index";

function onChange(date, dateString) {
  console.log(date, dateString);
}
const dateFormat = 'DD/MM/YYYY';

class ScheduleComponents extends Component {
  constructor(props) {
    super(props);
    this.state = {
      service: [],
      bacsi: {
        bs : {},
        lichhenList :[]
      }
    };
  }

  componentWillMount() {
    const { bacsiID } = this.props;
    ListService(data => this.setState({ service: data }));
    DetailDoctor(bacsiID, bacsi => {
      this.setState({ bacsi: bacsi });
    });
  }

  render() {
    const { bacsi, service } = this.state;
    console.log(bacsi.bs.tenbs)
    return (
      <div style={styles.container}>
        <div style={styles.itemContain}>
          <h1
            style={{
              color: "#000000",
              fontSize: 18,
              fontFamily: "Times New Roman",
              width: "90%",
              fontWeight: "600"
            }}
          >
            {bacsi.bs.tenbs}
          </h1>
          <h1
            style={{
              color: "#3775C0",
              fontSize: 15,
              marginTop: -10,
              fontFamily: "Times New Roman",
              width: "90%",
              fontWeight: "initial"
            }}
          >
            {`KHOA ${bacsi.bs.makhoa_}`}
          </h1>
          <h1
            style={{
              fontSize: 18,
              marginTop: -10,
              fontFamily: "Times New Roman",
              width: "90%",
              fontWeight: "initial"
            }}
          >
            {bacsi.bs.chucvu}
          </h1>
          <img 
            style={{
              fontSize: 18,
              marginTop: -10,
              //fontFamily: "Times New Roman",
              width: "90%",
              //fontWeight: "initial"
            }}
            src={resourceImg.img_bs} />
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
              width: "90%",
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
                  {item.dongia.toLocaleString("vi", {
                    style: "currency",
                    currency: "VND"
                  })}
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

        <div style={styles.itemContain}>
          <div
            style={{
              width: "90%",
              flexDirection: "row",
              display: "flex",
              fontWeight: "600"
            }}
          >
            <h1
              style={{
                color: "#000000",
                fontSize: 18,
                marginLeft: 20,
                fontFamily: "Times New Roman",
                width: 150,
                fontWeight: "600"
              }}
            >
              Đặt lịch khám
            </h1>
            <DatePicker
              onChange={onChange}
              defaultValue={moment(new Date(), dateFormat)}
              format={dateFormat}
            />
          </div>

          <div
            style={{
              width: "80%",
              height: 1,
              marginRight: 60,
              backgroundColor: "#E2E2E2"
            }}
          ></div>
          <div
            style={{
              width: "100%",
              flexDirection: "row",
              display: "flex",
              flexWrap: "wrap"
            }}
          >
            {bacsi.lichhenList.map(item => (
              <Button
                style={{ marginLeft: 10, marginTop: 10 }}
                type="primary"
                size={"large"}
                disabled={item.trangthai === 0 ? false : true}
                key={item.malichhen}
                onClick={() =>
                  this.props.bookAppointment(item.malichhen, bacsi.bs.mabs)
                }
              >
                {item.thoigian}
              </Button>
            ))}
          </div>
          <h1
            style={{
              fontSize: 15,
              marginLeft: 10,
              marginTop: 10,
              fontFamily: "Times New Roman",
              width: "90%",
              fontWeight: "initial"
            }}
          >
            {"Chọn và đặt miễn phí"}
          </h1>
        </div>
      </div>
    );
  }
}
export default ScheduleComponents;
const styles = {
  container: {
    height: "auto",
    width: "90%",
    flexDirection: "row",
    display: "flex",
    justifyContent: "center"
  },
  itemContain: {
    marginTop: 20,
    marginLeft: 30,
    width: "30%",
    height: "auto",
    flexDirection: "column",
    display: "flex",
    alignItems: "center",
  //  backgroundColor:'black'
  }
};
