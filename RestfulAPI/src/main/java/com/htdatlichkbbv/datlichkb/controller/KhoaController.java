package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Khoa;
import com.htdatlichkbbv.datlichkb.service.impl.KhoaServiceImpl;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/khoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KhoaController {

    @Autowired
    private KhoaServiceImpl khoaService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Khoa>> getAllKhoa() {
        ResponseData<List<Khoa>> response = new ResponseData<>();

        List<Khoa> ls = this.khoaService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Khoa> getKhoa(@PathVariable(name = "id") String id) {
        ResponseData<Khoa> response = new ResponseData<>();

        if (!khoaService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Khoa " + id + " is not existed");
            response.setData(null);

            return response;
        }
        Khoa ls = this.khoaService.findById(id).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Khoa> addNguoiDung(@RequestBody Khoa khoa) {
        ResponseData<Khoa> response = new ResponseData<>();

        if (khoaService.findById(khoa.getMakhoa()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Khoa " + khoa.getMakhoa() + " is existed");
            response.setData(null);

            return response;
        }

        Khoa nd_temp = new Khoa();
        nd_temp.setMakhoa(khoa.getMakhoa());
        nd_temp.setTenkhoa(khoa.getTenkhoa());
        nd_temp.setSodt(khoa.getSodt());
        khoaService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating Khoa success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Khoa> updateNguoiDung(@RequestBody Khoa khoa) {
        ResponseData<Khoa> response = new ResponseData<>();

        if (!khoaService.findById(khoa.getMakhoa()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Khoa " + khoa.getMakhoa() + " is not existed");
            response.setData(null);

            return response;
        }

        Khoa nd_temp = new Khoa();
        nd_temp.setMakhoa(khoa.getMakhoa());
        nd_temp.setTenkhoa(khoa.getTenkhoa());
        nd_temp.setSodt(khoa.getSodt());
        khoaService.update(nd_temp);

        response.setCode(200);
        response.setMessage("Update Khoa success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Khoa> deleteNguoiDung(@PathVariable(name = "id") String id) {
        ResponseData<Khoa> response = new ResponseData<>();

        if (!khoaService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Khoa " + id + " is not existed");
            response.setData(null);

            return response;
        }
        khoaService.deleteById(id);

        response.setCode(200);
        response.setMessage("Delete Khoa success");
        response.setData(null);

        return response;
    }
}
