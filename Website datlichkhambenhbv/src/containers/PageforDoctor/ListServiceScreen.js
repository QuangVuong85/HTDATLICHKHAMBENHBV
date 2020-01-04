import React, { Component } from "react";
import { Table, Divider, Button, Form,Popconfirm,Input ,InputNumber} from "antd";
import { withRouter } from "react-router-dom";

import dichvu from "../../resources/dataDefault/dichvukham";
import AddServiceComponent from "../../components/DoctorComponents/AddServiceComponent";
import UpdateServiceComponent from "../../components/DoctorComponents/UpdateServiceComponent";
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

  save = (e) => {
    const { record} = this.props;
    this.form.validateFields((error, values) => {
     // e.preventDefault();
      if(!Number.isNaN(Number(values.DonGia))){
        console.log( values," là số")
      }else{
        console.log( values,"không là số")
      }
      if (error === null) {
        console.log("e.currentTarget.id",e.currentTarget.id)
        if(e.currentTarget.id == "TenDV"){
          record.TenDV = values.TenDV
        }else{
          record.DonGia = values.DonGia //`${values.DonGia.replace(/\B(?=(\d{3})+(?!\d))/g, '.')} đ`
        }
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
          // <Input
          //   ref={node => (this.input = node)}
          //   onPressEnter={this.save}
          //   onBlur={this.save}
          // />
          <InputNumber
            ref={node => (this.input = node)}
            defaultValue={1000}
            // formatter={value => `${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, '.')}
            // parser={value => value.replace(/\$\s?|(.*)/g, "")}
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
class ListServiceScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      dataSource: dichvu,
      count: dichvu.length
    };
    document.title = "Phòng khám Đa khoa ReactJS Team - Dịch vụ khám"
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
      TenDV: "Tên dịch vụ khám",
      DonGia: "0 đ"
    };
    this.setState({
      dataSource: [...dataSource, newData],
      count: count + 1
    });
  };
  render() {
    const { data, dataSource } = this.state;
    const components = {
      body: {
        row: EditableFormRow,
        cell: EditableCell
      }
    };
    
    const column = [
      {
        title: "Tên dịch vụ",
        dataIndex: "TenDV",
        key: "TenDV",
        editable: true
      },
      {
        title: "Đơn giá(đ)",
        dataIndex: "DonGia",
        key: "DonGia",
        editable: true
      },
      {
        title: "Hoạt động",
        key: "action",
        render: (text, record) => (
          <Popconfirm
            title="Bạn chắc chắn xóa?"
            okText="Có"
            cancelText="Hủy"
            onConfirm={() => this.handleDelete(record.MaDV)}
          >
            <a>Xóa</a>
          </Popconfirm>
        )
      }
    ];
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
          onClick={() => this.setState({ addService: true })}
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

export default withRouter(ListServiceScreen);
