package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.context.LoginContext;
import com.htdatlichkbbv.datlichkb.service.NguoidungService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private NguoidungService nguoidungService;

    // use get ip address request
    @Autowired
    private HttpServletRequest request;

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Boolean> checkLogin(@RequestBody LoginContext loginContext) {
        ResponseData<Boolean> response = new ResponseData<>();
        boolean value = false;

        if (nguoidungService.findByNamePasswordTK(loginContext) == 1) {
            value = true;
            response.setCode(200);
            response.setMessage("Login success");
            response.setData(value);
            return response;
        }

        response.setCode(500);
        response.setMessage("Tài khoản hoặc mật khẩu không đúng.");
        response.setData(value);

        return response;
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<String> getIP() {
        System.out.println("RemoteHost:" + request.getRemoteHost());
        System.out.println("RemoteAddr:" + request.getRemoteAddr());
        System.out.println("RemotePort: " + request.getRemotePort());
        System.out.println("RemoteUser: " + request.getRemoteUser());

        ResponseData<String> response = new ResponseData<>();
        response.setCode(200);
        response.setMessage("Login success");
        response.setData(request.getRemoteAddr() + ":" +
                request.getRemotePort());
        return response;
    }
}
