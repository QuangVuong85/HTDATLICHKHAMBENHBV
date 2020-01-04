import React, { Component } from "react";
import { Layout } from "antd";
import { withRouter } from "react-router-dom";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend
} from "recharts";

const data = [
  {
    name: "CƠ-XƯƠNG-KHỚP",
    NGAY1: 4000,
    NGAY2: 2400,
    NGAY3: 2400,
  },
  {
    name: "THẦN KINH",
    NGAY1: 3000,
    NGAY2: 1398,
    NGAY3: 2210,
  },
  {
    name: "TIÊU HÓA",
    NGAY1: 2000,
    NGAY2: 9800,
    NGAY3: 2290,
  },
  {
    name: "TIM MẠCH",
    NGAY1: 2780,
    NGAY2: 3908,
    NGAY3: 2000,
  },
  {
    name: "TAI MŨI HỌNG",
    NGAY1: 1890,
    NGAY2: 4800,
    NGAY3: 2181,
  },
  {
    name: "CỘT SỐNG",
    NGAY1: 2390,
    NGAY2: 3800,
    NGAY3: 2500,
  },
  {
    name: "Y HỌC CỔ TRUYỀN",
    NGAY1: 3490,
    NGAY2: 4300,
    NGAY3: 2100,
  },
  {
    name: "CHÂM CỨU",
    NGAY1: 4000,
    NGAY2: 2400,
    NGAY3: 2400,
  },
  {
    name: "SẢN PHỤ KHOA",
    NGAY1: 3000,
    NGAY2: 1398,
    NGAY3: 2210,
  },
  {
    name: "DA LIỄU",
    NGAY1: 2000,
    NGAY2: 9800,
    NGAY3: 2290,
  },
  {
    name: "UNG BƯỚU",
    NGAY1: 2780,
    NGAY2: 3908,
    NGAY3: 2000,
  },
  {
    name: "NHA KHOA",
    NGAY1: 1890,
    NGAY2: 4800,
    NGAY3: 2181,
  }
];

class DashboardScreen extends Component {
  render() {
    return (
      <div
        style={{
          height: "100%",
          width: "100%",
          display: "flex",
          flexDirection:"column",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <BarChart
          width={800}
          height={400}
          data={data}
          margin={{
            top: 100,
            bottom: 15
          }}
        >
          <CartesianGrid strokeDasharray="2"/>
          <XAxis dataKey="name" />
          <YAxis />
          <Tooltip itemSorter={data} />
          <Legend />
          {/* <Bar dataKey="NGÀY 4" stackId="a" fill="#8884d8" /> */}
          <Bar dataKey="NGAY3" stackId="a" fill="#82ca9d" />
          <Bar dataKey="NGAY2" stackId="a" fill="orange" />
          <Bar dataKey="NGAY1" stackId="a" fill="blue" />
        </BarChart>
        {/* <BarChart
          width={300}
          height={200}
          data={data}
          margin={{
            top: 20,
            right: 30,
            left: 20,
            bottom: 5
          }}
        >
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="name" />
          <YAxis />
          <Tooltip itemSorter={data} />
          <Legend />
          <Bar dataKey="API4" stackId="a" fill="#8884d8" />
          <Bar dataKey="NGAY3" stackId="a" fill="#82ca9d" />
          <Bar dataKey="NGAY2" stackId="a" fill="orange" />
          <Bar dataKey="NGAY1" stackId="a" fill="blue" />
        </BarChart>
        <BarChart
          width={300}
          height={200}
          data={data}
          margin={{
            top: 20,
            right: 30,
            left: 20,
            bottom: 5
          }}
        >
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="name" />
          <YAxis />
          <Tooltip itemSorter={data} />
          <Legend />
          <Bar dataKey="API4" stackId="a" fill="#8884d8" />
          <Bar dataKey="NGAY3" stackId="a" fill="#82ca9d" />
          <Bar dataKey="NGAY2" stackId="a" fill="orange" />
          <Bar dataKey="NGAY1" stackId="a" fill="blue" />
        </BarChart> */}
      </div>
    );
  }
}

export default withRouter(DashboardScreen);
