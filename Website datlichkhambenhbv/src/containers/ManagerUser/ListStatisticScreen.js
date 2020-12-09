import {withRouter} from "react-router-dom";
import React, {Component, PureComponent} from "react";
import {
    BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend,
} from 'recharts';
import axios from 'axios';
import moment from "moment";
import {DatePicker, Table, Tabs} from "antd";

const {TabPane} = Tabs;

function callback(key) {
    console.log(key);
}


class ListStatisticScreen extends Component {

    state = {
        statistic: []
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/api/v.1.0/lichhen/thong-ke`)
            .then(res => {
                this.setState({statistic: res.data.data})
                console.log(res.data.data);
            })
            .catch(error => console.log(error));
    }

    onChange(date, dateString) {
        console.log(date, dateString);
    }


    render() {
        const columns = [
            {
                title: 'Mã bác sĩ',
                dataIndex: 'mabs',
                key: 'mabs',
            },
            {
                title: 'Tên bác sĩ',
                dataIndex: 'tenbs',
                key: 'tenbs',
            },
            {
                title: 'Ngày khám',
                dataIndex: 'ngaykham',
                key: 'ngaykham',
            },
            {
                title: 'Trạng thái',
                dataIndex: 'trangthai',
                key: 'trangthai',
            },
            {
                title: 'Số lượng bệnh nhân',
                dataIndex: 'soluong',
                key: 'soluong',
            },
        ];

        return (
            <div
                style={{
                    height: "100%",
                    width: "100%",
                    display: "flex",
                    flexDirection: "column",
                    justifyContent: "center",
                    alignItems: "center",
                }}
            >
                <Tabs defaultActiveKey="1" onChange={callback}>
                    <TabPane tab="Thống kê theo bảng" key="1">
                        <p>Ngày: <DatePicker onChange={this.onChange} defaultValue={moment("14-12-2020", 'DD/MM/YYYY')}/></p>

                        <Table dataSource={this.state.statistic} columns={columns}/>;

                        <div>
                            <p>Trạng thái: 0 - Số lượng lịch hẹn trống</p>
                            <p>Trạng thái: 1 - Số lượng lịch hẹn đã đặt</p>
                        </div>
                    </TabPane>

                    <TabPane tab="Thống kê theo đồ thị" key="2">
                        <p>Ngày: <DatePicker onChange={this.onChange} defaultValue={moment("14-12-2020", 'DD/MM/YYYY')}/></p>

                        <BarChart
                            width={800}
                            height={400}
                            data={this.state.statistic}
                            margin={{
                                top: 5, right: 30, left: 20, bottom: 5,
                            }}
                        >
                            <CartesianGrid strokeDasharray="3 3"/>
                            <XAxis dataKey="mabs"/>
                            <YAxis/>
                            <Tooltip/>
                            <Legend/>
                            <Bar dataKey="trangthai" fill="#8884d8"/>
                            <Bar dataKey="soluong" fill="#82ca9d"/>
                        </BarChart>

                        <div>
                            <p>Trạng thái: 0 - Số lượng lịch hẹn trống</p>
                            <p>Trạng thái: 1 - Số lượng lịch hẹn đã đặt</p>
                        </div>
                    </TabPane>
                </Tabs>
            </div>
        )
    }
}


export default withRouter(ListStatisticScreen);
