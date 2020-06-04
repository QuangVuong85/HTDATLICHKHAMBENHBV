import React, { Component } from 'react';
import { Table,Popconfirm} from 'antd';
import {
  withRouter
} from 'react-router-dom'

import {ListLichHen,DetailUser,delete_LichHen} from '../../apis/Api'
class ListAppointmentScreen extends Component {

  constructor(props) {
    super(props);
    this.state = {
      data: [],
    }
    document.title = "Phòng khám Đa khoa ReactJS Team - Lịch hẹn"
  }

  componentDidMount() {
    let tmpLichHen = []
    ListLichHen(lichhen => {
        for(let i = 0 ; i < lichhen.length ; i++){
          console.log(lichhen[i].mabn_);
          if(lichhen[i].mabn_ !== null){
            let id = lichhen[i].mabn_
            DetailUser( id,data => {
              lichhen[i].hoten = data.hoten
              lichhen[i].gioitinh = data.gioitinh === 1 ? 'Nam' :'Nữ'
              lichhen[i].sodt = data.sodt
              lichhen[i].diachi = data.diachi
            })
            tmpLichHen.push(lichhen[i])
          }
        }
    })
    this.setState({data: tmpLichHen})
  }
  render() {
    const columns = [
      {
        title: 'Tên bệnh nhân',
        dataIndex: 'hoten',
        key: 'hoten',
      },
      {
        title: 'Giới tính',
        dataIndex: 'gioitinh',
        key: 'gioitinh',
      },
      {
        title: 'Số điện thoại',
        dataIndex: 'sodt',
        key: 'sodt',
      },
      {
        title: 'Địa chỉ',
        dataIndex: 'diachi',
        key: 'diachi',
      },
      {
        title: 'Ngày khám',
        dataIndex: 'ngaykham',
        key: 'ngaykham',
      },
      {
        title: 'Thời gian',
        dataIndex: 'thoigian',
        key: 'thoigian',
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
          }}
        >
          <a>Xóa</a>
        </Popconfirm>
        )
      }
    ];
    const { data } = this.state;
    console.log(data)
    return (
      <div style={{
        height: '100%',
        width: '100%',
        justifyContent: 'center',
        alignItems: 'center'
      }}>
        {/* <Button
          type="primary"
          icon="add"
          style={{ marginLeft: 20, marginBottom: 10, marginTop: -20 }}
        >
          Thêm mới
        </Button> */}
        <Table style={{ width: '100%' }} columns={columns} dataSource={data} />
      </div>
    );
  }
}

export default withRouter(ListAppointmentScreen);
