import React, { Component } from "react";
import { Table, Button, Form, Popconfirm, Input } from "antd";
import { withRouter } from "react-router-dom";

import UserInfoManager from "../../models/UserInfoManager";
import dichvu from "../../resources/dataDefault/dichvukham";
const UserInfoManagerInstance = UserInfoManager.getUserInfoManagerInstance();

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
class ListPackageScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      dataSource: dichvu,
      count: dichvu.length
    };
    this.columns = [
      {
        title: "Gói khám",
        dataIndex: "TenDV",
        editable: true
      },
      {
        title: "Đơn giá",
        dataIndex: "DonGia",
        editable: true
      },
      {
        title: "Hoạt động",
        dataIndex: "operation",
        render: (text, record) =>
          this.state.dataSource.length >= 1 ? (
            <Popconfirm
              title="Bạn chắc chắn xóa?"
              okText="Có"
              cancelText="Hủy"
              onConfirm={() => this.handleDelete(record.MaDV)}
            >
              <a>Xóa</a>
            </Popconfirm>
          ) : null
      }
    ];
    document.title = "Phòng khám Đa khoa ReactJS Team - Gói khám";
  }
  handleDelete = key => {
    const dataSource = [...this.state.dataSource];
    console.log("key",key)
    this.setState({ dataSource: dataSource.filter(item => item.key !== key) });
  };

  handleAdd = () => {
    const { count, dataSource } = this.state;

    const newData = {
      MaDV: `DV${count+1}`,
      TenDV: "Tên gói khám",
      DonGia: "0 đ"
    };
    this.setState({
      dataSource: [...dataSource, newData],
      count: count + 1
    });
  };

  // handleSave = row => {
  //   const newData = [...this.state.dataSource];
  //   const index = newData.findIndex(item => row.key === item.key);
  //   const item = newData[index];
  //   newData.splice(index, 1, {
  //     ...item,
  //     ...row
  //   });
  //   this.setState({ dataSource: newData });
  // };

  render() {
    const { data, dataSource } = this.state;
    const components = {
      body: {
        row: EditableFormRow,
        cell: EditableCell
      }
    };
    const columns = this.columns.map(col => {
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
          dataSource={dataSource}
        />
      </div>
    );
  }
}

export default withRouter(ListPackageScreen);
