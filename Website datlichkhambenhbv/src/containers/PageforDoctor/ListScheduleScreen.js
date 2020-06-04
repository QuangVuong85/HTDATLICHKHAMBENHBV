import React, { Component } from "react";
import { Table, Popconfirm, Button, Drawer } from "antd";

import { withRouter } from "react-router-dom";
import AddScheduleComponent from "../../components/DoctorComponents/AddScheduleComponent";
import UpdateScheduleComponent from "../../components/DoctorComponents/UpdateScheduleComponent";
import {ListLichHen,delete_LichHen} from '../../apis/Api'
class ListScheduleScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      addSchedule: false,
      updateSchedule: false
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Lịch khám"
  }

  componentWillMount() {
    ListLichHen(data => this.setState({data : data.sort(function(a,b){
      // Turn your strings into dates, and then subtract them
      // to get a value that is either negative, positive, or zero.
      return new Date(a.ngaykham) - new Date(b.ngaykham);
    })}))
  }
  render() {
    const columns = [
      {
        title: "Ngày khám",
        dataIndex: "ngaykham",
        key: "ngaykham"
      },
      {
        title: "Thời gian",
        dataIndex: "thoigian",
        key: "thoigian"
      },
      {
        title: "Trạng thái",
        key: "trangthai",
        render: (record) =>
        record.trangthai === 1 ? <span>Đã đặt</span> : <span>Chưa đặt</span>
      },
      {
        title: "Hoạt động",
        key: "action",
        render: record => (
          <Popconfirm
          title="Bạn chắc chắn xóa?"
          okText="Có"
          cancelText="Hủy"
          onConfirm={() => {
            delete_LichHen(record.malichhen)
            ListLichHen(data => this.setState({data : data}))
          }}
        >
          <a href="#">Xóa</a>
        </Popconfirm>
        )
      }
    ];
    const { data, addSchedule, updateSchedule } = this.state;

    return (
      <div
        style={{
          height: "100%",
          width: "100%",
          justifyContent: "center",
          alignItems: "center"
        }}
      >
        <Button
          type="primary"
          icon="add"
          style={{ marginLeft: 20, marginBottom: 10, marginTop: -20 }}
          onClick={() => this.setState({ addSchedule: true })}
        >
          Thêm mới
        </Button>
        <Table style={{ width: "100%" }} columns={columns} dataSource={data} />
        <Drawer
          title="THÊM MỚI LICH KHÁM"
          width={500}
          closable={false}
          onClose={() => {
            this.setState({ addSchedule: false });
          }}
          visible={addSchedule}
        >
          <AddScheduleComponent
            closeAddSchedule={() => {
              this.setState({ addSchedule: false });
            }}
          />
        </Drawer>
        <Drawer
          title="CẬP NHẬT LỊCH KHÁM"
          width={500}
          closable={false}
          onClose={() => {
            this.setState({ updateSchedule: false });
          }}
          visible={updateSchedule}
        >
          <UpdateScheduleComponent
            closeUpdateSchedule={() => {
              this.setState({ updateSchedule: false });
            }}
          />
        </Drawer>
      </div>
    );
  }
}

export default withRouter(ListScheduleScreen);
