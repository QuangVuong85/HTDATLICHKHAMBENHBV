import {message} from "antd";

const url = 'http://localhost:8080/api/v.1.0'

export function UserLogin(loginData, dataResult) {
  fetch(`${url}/login`, {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json"
    },
    body: JSON.stringify(loginData)
  })
    .then(respone => respone.json())
    .then(data => {
      if (data.code == 200) {
        dataResult(data.data);
      } else {
        message.error(data.message, 5);
      }
    })
    .catch(error => {
      message.error(error, 5);
    });
}

export function UserRegister(registerData){
    fetch(`${url}`, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
       data : registerData
    })
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
           

        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }
  
  export function ListUser(listUser) {
    fetch(`${url}/benhnhan`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      }
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          listUser(data.data);
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
        message.error(error, 5);
      });
  }
  export function DetailUser(mabn,dataDetail) {
    fetch(`${url}/benhnhan/${mabn}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      }
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          dataDetail(data.data);
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
        message.error(error, 5);
      });
  }
  export function ListDoctor(listDoctor){
    fetch(`${url}/bacsi`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          listDoctor(data.data)
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }

  export function ListAdmin(listAdmin){
    fetch(`${url}/benhnhan`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          listAdmin(data.data)
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }

  export function ListDepartment(listDepartment){
    fetch(`${url}/khoa`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          listDepartment(data.data)
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }

  export function DetailDoctor(mabs,doctorInfo){
    fetch(`${url}/lichhen/?mabs=${mabs}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          doctorInfo(data.data)
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }

  export function ListService(listService){
    fetch(`${url}/dichvu`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          listService(data.data)
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }
  export function ListLichHen(lichhen){
    fetch(`${url}/lichhen`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          lichhen(data.data)
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }
  export function Add_LichHen(lichhen){
    fetch(`${url}/lichhen`, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify(lichhen)
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          console.log(data.data)
          message.success('Thêm mới thành công', 5);
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }
  export function update_LichHen(lichhen){
    fetch(`${url}/lichhen`, {
      method: "PUT",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify(lichhen)
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          message.success('Đặt lịch thành công', 5);
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }
  export function delete_LichHen(malichhen){
    fetch(`${url}/lichhen/${malichhen}`, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          message.success('Xóa lịch thành công', 5);
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }
  export function ListDoctorByDepartment(idKhoa,listDoctor){
    fetch(`${url}/bacsi/?id=${idKhoa}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      }
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          listDoctor(data.data)
        } else {
          message.error('Khoa hiện tại chưa có bác sĩ', 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }
  export function DetailLichHen(idLichHen,detail){
    fetch(`${url}/lichhen/${idLichHen}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      }
    })
      .then(respone => respone.json())
      .then(data => {
        if (data.code == 200) {
          detail(data.data)
        } else {
          message.error(data.message, 5);
        }
      })
      .catch(error => {
          message.error(error,5)
      });
  }
  