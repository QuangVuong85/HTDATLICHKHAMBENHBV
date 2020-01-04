import React, { Component } from 'react';
import { Table} from 'antd';
import {

  withRouter
} from 'react-router-dom'

import UserInfoManager from '../../models/UserInfoManager';
import benhnhan from '../../resources/dataDefault/benhnhanInfor';
const UserInfoManagerInstance = UserInfoManager.getUserInfoManagerInstance();

class ListUserScreen extends Component {

  constructor(props) {
    super(props);
    this.state = {
      data: [],
    }
    document.title = "Phòng khám Đa khoa ReactJS Team - Danh sách bệnh nhân"
  }
  render() {
    const columns = [
      {
        title: 'Họ Tên',
        dataIndex: 'HoTen',
        key: 'HoTen',
      },
      {
        title: 'Giới tính',
        dataIndex: 'GioiTinh',
        key: 'GioiTinh',
      },
      {
        title: 'Số điện thoại',
        dataIndex: 'SoDT',
        key: 'SoDT'

      },
      {
        title: 'Email',
        dataIndex: 'Email',
        key: 'Email'

      },
      {
        title: 'Địa chỉ',
        dataIndex: 'DiaChi',
        key: 'DiaChi'

      },
      {
        title: 'Mã người dùng',
        dataIndex: '',
        key: ''

      },
      // {
      //   title: 'Mật khẩu',
      //   dataIndex: 'MatKhau',
      //   key: 'MatKhau'

      // },
      // {
      //   title: 'Hoạt động',
      //   key: 'action',
      //   render: (record) => (
      //     <span>
      //       <a>Chỉnh sửa</a>
      //       <Divider type="vertical" />
      //       <a>Xóa</a>
      //     </span>
      //   ),
      // },
    ];
    const { data } = this.state;

    return (
      <div style={{
        height: '100%',
        width: '100%',
        justifyContent: 'center',
        alignItems: 'center'
      }}>
        <Table style={{ width: '100%' }} columns={columns} dataSource={benhnhan} />
      </div>
    );
  }
}

export default withRouter(ListUserScreen);
