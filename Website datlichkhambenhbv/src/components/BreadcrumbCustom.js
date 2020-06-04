import { Breadcrumb } from 'antd';
import React, { Component } from 'react';

class BreadcrumbCustom extends Component {

  constructor(props) {
    super(props);
    this.state = {
      data: []
    }
  }

  render() {
    const { data } = this.state
    return (
      <Breadcrumb>
        {
          <Breadcrumb.Item><a>{this.props.name}</a></Breadcrumb.Item>
        }
      </Breadcrumb>
    )
  }
}

export default BreadcrumbCustom;