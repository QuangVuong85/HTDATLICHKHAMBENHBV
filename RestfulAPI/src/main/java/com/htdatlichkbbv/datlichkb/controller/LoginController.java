package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import com.htdatlichkbbv.datlichkb.entities.Nguoidung;
import com.htdatlichkbbv.datlichkb.entities.context.LoginContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBNContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBSContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResContext;
import com.htdatlichkbbv.datlichkb.service.NguoidungService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.util.*;

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
    public ResponseData<LoginResContext> checkLogin(@RequestBody LoginContext loginContext) {
        System.out.println(loginContext);
        ResponseData<LoginResContext> response = new ResponseData<>();

        List<String> list = null;

        list = nguoidungService.getByNamePasswordTK(loginContext);

        if (list.size() != 0) {
            LoginResContext loginResContext = new LoginResContext();
            loginResContext.setMatk(list.get(0));
            loginResContext.setMa_nhomnd(this.nguoidungService.findById(list.get(0)).get().getManhomnd_());

            response.setCode(200);
            response.setMessage("Login success");
            response.setData(loginResContext);
            return response;
        }

        response.setCode(500);
        response.setMessage("Tài khoản hoặc mật khẩu không đúng.");
        response.setData(null);
        return response;
    }

    @PostMapping(value = "/infobacsi", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<LoginResBSContext>> getInfoBSLogin(@RequestBody LoginResContext str) {
        ResponseData<List<LoginResBSContext>> response = new ResponseData<>();

        Optional<Nguoidung> nd = nguoidungService.findById(str.getMatk());
        if (!nd.isPresent()) {
            response.setCode(500);
            response.setMessage("Không tồn tại mã tài khoản bác sĩ");
            response.setData(null);
            return response;
        }

        if (str.getMa_nhomnd().equals("N3")) {
            response.setCode(200);
            response.setMessage("Login success");
            response.setData(this.nguoidungService.getInfoBacSi(str.getMatk()));
            return response;
        }

        response.setCode(500);
        response.setMessage("Không tồn tại mã nhóm người dùng");
        response.setData(null);
        return response;
    }

    @PostMapping(value = "/infobenhnhan", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<LoginResBNContext>> getInfoBNLogin(@RequestBody LoginResContext str) {
        ResponseData<List<LoginResBNContext>> response = new ResponseData<>();

        Optional<Nguoidung> nd = nguoidungService.findById(str.getMatk());
        if (!nd.isPresent()) {
            response.setCode(500);
            response.setMessage("Không tồn tại mã tài khoản bệnh nhân");
            response.setData(null);
            return response;
        }

        if (str.getMa_nhomnd().equals("N4")) {
            response.setCode(200);
            response.setMessage("Login success");
            response.setData(this.nguoidungService.getInfoBenhNhan(str.getMatk()));

            return response;
        }

        response.setCode(500);
        response.setMessage("Không tồn tại mã nhóm người dùng");
        response.setData(null);
        return response;
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<String> getIP() {
        // Client
        System.out.println("RemoteHost:" + request.getRemoteHost());
        System.out.println("RemoteAddr:" + request.getRemoteAddr());
        System.out.println("RemotePort: " + request.getRemotePort());
        System.out.println("RemoteUser: " + request.getRemoteUser());


        // Server
        System.out.println("ServerName: " + request.getServerName());
        System.out.println("LocalAddr: " + request.getLocalAddr());

        ResponseData<String> response = new ResponseData<>();

        String str = request.getRemoteAddr() + ":" + request.getRemotePort();
        response.setCode(200);
        response.setMessage("Login success");
        response.setData(str);

        return response;
    }
}
