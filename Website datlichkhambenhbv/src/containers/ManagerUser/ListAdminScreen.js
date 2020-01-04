import React, { Component } from 'react';
import { Table,Button,Popconfirm,Form,Input} from 'antd';
import {
  withRouter
} from 'react-router-dom'

import UserInfoManager from '../../models/AdminInfoManager';
import admin from '../../resources/dataDefault/adminInfor';
const AdminInfoManagerInstance = UserInfoManager.getAdminInfoManagerInstance();

const EditableContext = React.createContext();
const EditableRow = ({ form, index, ...props }) => (
  <EditableContext.Provider value={form}>
    <tr {...props} />
  </EditableContext.Provider>
);

const EditableFormRow = Form.create()(EditableRow);

class EditableCell extends React.Component {
  state = {
    editing: false
  };

  toggleEdit = () => {
    const editing = !this.state.editing;
    this.setState({ editing }, () => {
      if (editing) {
        this.input.focus();
      }
    });
  };

  save = () => {
    const { record} = this.props;
    this.form.validateFields((error, values) => {
      if (error === null) {
        console.log("record",record)
      }
       this.toggleEdit();
    });
  };

  renderCell = form => {
    this.form = form;
    const { children, dataIndex, record, title } = this.props;
    const { editing } = this.state;
    return editing ? (
      <Form.Item style={{ margin: 0 }}>
        {form.getFieldDecorator(dataIndex, {
          rules: [
            {
              required: true,
              message: `Vui lòng nhập ${title}!`
            }
          ],
          initialValue: record[dataIndex]
        })(
          <Input
            ref={node => (this.input = node)}
            onPressEnter={this.save}
            onBlur={this.save}
          />
        )}
      </Form.Item>
    ) : (
      <div
        className="editable-cell-value-wrap"
        style={{ paddingRight: 24 }}
        onClick={this.toggleEdit}
      >
        {children}
      </div>
    );
  };

  render() {
    const {
      editable,
      dataIndex,
      title,
      record,
      index,
      children,
      ...restProps
    } = this.props;
    return (
      <td {...restProps}>
        {editable ? (
          <EditableContext.Consumer>{this.renderCell}</EditableContext.Consumer>
        ) : (
          children
        )}
      </td>
    );
  }
}
class ListAdminScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      dataSource: admin,
      count: admin.length,
      adminInfo: AdminInfoManagerInstance.adminInfo
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Danh sách người dùng"
    AdminInfoManagerInstance.addObserver(this);
  }

  componentWillUnmount() {
    AdminInfoManagerInstance.removeObserver(this);
  }
  onAdminInfoChanged = () => {
    this.setState({ adminInfo: AdminInfoManagerInstance.adminInfo });
  };
  handleDelete = key => {
    const dataSource = [...this.state.dataSource];
    console.log("key",key)
    this.setState({ dataSource: dataSource.filter(item => item.key !== key) });
  };

  handleAdd = () => {
    const { count, dataSource } = this.state;

    const newData = {
      MaND: `MaND${count+1}`,
      TenDN: "ten_dn",
      MatKhau: "password",
      MaNhomND : 2
    };
    this.setState({
      dataSource: [...dataSource, newData],
      count: count + 1
    });
  };
  render() {
    const {adminInfo,dataSource} = this.state
    const column = [
      {
        title: "Tên đăng nhập",
        dataIndex: "TenDN",
        key: "TenDN",
        editable: true
      },
      {
        title: "Mật khẩu",
        dataIndex: "MatKhau",
        key: "MatKhau",
        editable: true
      },
      {
        title: "Quyền truy cập",
        dataIndex: "MaNhomND",
        key: "MaNhomND",
        render: MaNhomND =>
          MaNhomND == 1 ? <span>Administrators</span> : <span>Editor</span>
      },
      {
        title: adminInfo.MaNhomND == 1 ? "Hoạt động" : null,
        dataIndex:adminInfo.MaNhomND == 1 ? "MaNhomND" : null,
        key: "MaNhomND",
        render: adminInfo.MaNhomND == 1 ? (MaNhomND,record) =>
          MaNhomND == 2 ? (
            <Popconfirm
              title="Bạn chắc chắn xóa?"
              okText="Có"
              cancelText="Hủy"
              onConfirm={() => this.handleDelete(record.MaND)}
            >
              <a>Xóa</a>
            </Popconfirm>
          ) : (
            null
          ) : null
      }
    ];
    const components = {
      body: {
        row: EditableFormRow,
        cell: EditableCell
      }
    };
    const columns = column.map(col => {
      if (!col.editable) {
        return col;
      }
      return {
        ...col,
        onCell: record => ({
          record,
          editable: col.editable,
          dataIndex: col.dataIndex,
          title: col.title,
        //  handleSave: this.handleSave
        })
      };
    });
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
          onClick={this.handleAdd}
        >
          Thêm mới
        </Button>
        <Table
          style={{ width: "100%" }}
          components={components}
          rowClassName={() => "editable-row"}
          bordered
          columns={columns}
          // expandedRowRender={record => (
          //   <p style={{ margin: 0 }}></p>
          // )}
          dataSource={dataSource}
        />
      </div>
    );
  }
}

export default withRouter(ListAdminScreen);
