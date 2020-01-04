import React, { Component } from 'react';
import { Table, Divider,Button,Drawer,Popconfirm} from 'antd';
import {
  withRouter
} from 'react-router-dom'

import AddDoctorComponent from '../../components/AdminComponents/AddDoctorComponent'
import UpdateDoctorComponent from '../../components/AdminComponents/UpdateDoctorComponent'
import UserInfoManager from '../../models/UserInfoManager';
import bacsiInfo from '../../resources/dataDefault/bacsiInfor';
//import {GetUserInfo} from '../../apis/ApiDoctor';
const UserInfoManagerInstance = UserInfoManager.getUserInfoManagerInstance();

class ListUserScreen extends Component {

  constructor(props) {
    super(props);
    this.state = {
      data: [],
      addDoctor : false,
      updateDoctor:false,
    }
    document.title = "Phòng khám Đa khoa ReactJS Team - Danh sách bác sĩ"
  }

  // componentWillMount() {
  //   GetUserInfo((data) => {
  //     console.log(data)
  //     this.setState({ data: data })
  //   });
    
    // let userInfo = UserInfoManagerInstance.getUserInfo();
    // if (userInfo) {
    //   GetListUser(userInfo.accessToken, (data) => {
    //     this.setState({ data: data })
    //   });
    // }
 // }


  render() {
    const columns = [
      {
        title: 'Họ Tên',
        dataIndex: 'TenND',
        key: 'tenbs',
      },
      {
        title: 'Học vị',
        dataIndex: 'HocVi',
        key: 'hocvi',
      },
      {
        title: 'Chức vụ',
        dataIndex: 'ChucVu',
        key: 'chucvu',
      },
      {
        title: 'Khoa',
        dataIndex: 'TenKhoa',
        key: 'makhoa_'

      },
      {
        title: 'Mã người dùng',
        dataIndex: '',
        key: ''

      },
      // {
      //   title: 'Tên đăng nhập',
      //   dataIndex: 'TenDN',
      //   key: 'TenDN'

      // },
      // {
      //   title: 'Mật khẩu',
      //   dataIndex: 'MatKhau',
      //   key: 'MatKhau'

      // },
      {
        title: 'Hoạt động',
        key: 'action',
        render: (record) => (
          <span>
            <a onClick={() => this.setState({ updateDoctor: true })}>Chỉnh sửa</a>
            <Divider type="vertical" />
            <Popconfirm
              title="Bạn chắc chắn xóa?"
              okText="Có"
              cancelText="Hủy"
             // onConfirm={() => this.handleDelete(record.MaDV)}
            >
              <a>Xóa</a>
            </Popconfirm>
          </span>
        ),
      },
    ];
    const { data,addDoctor,updateDoctor } = this.state;

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
          onClick={() => this.setState({ addDoctor: true })}>
          Thêm mới
        </Button>
        <Table
          style={{ width: "100%" }}
          columns={columns}
          dataSource={bacsiInfo}
        />
        <Drawer
          title="THÊM MỚI BÁC SĨ"
          width={450}
          closable={false}
          onClose={() => {
            this.setState({ addDoctor: false });
          }}
          visible={addDoctor}
        >
          <AddDoctorComponent
            closeAddDoctor={() => {
              this.setState({ addDoctor: false });
            }}
          />
        </Drawer>
        <Drawer
          title="CẬP NHẬT THÔNG TIN"
          width={450}
          closable={false}
          onClose={() => {
            this.setState({ updateDoctor: false });
          }}
          visible={updateDoctor}>
          <UpdateDoctorComponent
            closeUpdateDoctor={() => {
              this.setState({ updateDoctor: false });
            }}
          />
        </Drawer>
      </div>
    );
  }
}

export default withRouter(ListUserScreen);
