package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Nhomngdung;
import com.htdatlichkbbv.datlichkb.service.NhomngdungService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1+"/nhomngdung")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NhomngdungController {

    @Autowired
    private NhomngdungService nhomngdungService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Nhomngdung>> getAllNhomNguoiDung() {
        ResponseData<List<Nhomngdung>> response = new ResponseData<>();

        List<Nhomngdung> ls = this.nhomngdungService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nhomngdung> getNhomNguoiDung(@PathVariable(name = "id") String id) {
        ResponseData<Nhomngdung> response = new ResponseData<>();

        if (!nhomngdungService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id NhomNguoiDung " + id + " is not existed");
            response.setData(null);

            return response;
        }
        Nhomngdung ls = this.nhomngdungService.findById(id).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nhomngdung> addNguoiDung(@RequestBody Nhomngdung nd) {
        ResponseData<Nhomngdung> response = new ResponseData<>();

        if (nhomngdungService.findById(nd.getManhomnd()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id NhomNguoiDung " + nd.getManhomnd() + " is existed");
            response.setData(null);

            return response;
        }

        Nhomngdung nd_temp = new Nhomngdung();
        nd_temp.setManhomnd(nd.getManhomnd());
        nd_temp.setTennhomnd(nd.getTennhomnd());
        nhomngdungService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating NhomNguoiDung success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nhomngdung> updateNguoiDung(@RequestBody Nhomngdung nd) {
        ResponseData<Nhomngdung> response = new ResponseData<>();

        if (!nhomngdungService.findById(nd.getManhomnd()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id NhomNguoiDung " + nd.getManhomnd() + " is not existed");
            response.setData(null);

            return response;
        }

        Nhomngdung nd_temp = new Nhomngdung();
        nd_temp.setManhomnd(nd.getManhomnd());
        nd_temp.setTennhomnd(nd.getTennhomnd());
        nhomngdungService.update(nd_temp);

        response.setCode(200);
        response.setMessage("Update NhomNguoiDung success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nhomngdung> deleteNguoiDung(@PathVariable(name = "id") String id) {
        ResponseData<Nhomngdung> response = new ResponseData<>();

        if (!nhomngdungService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id NhomNguoiDung " + id + " is not existed");
            response.setData(null);

            return response;
        }
        nhomngdungService.deleteById(id);

        response.setCode(200);
        response.setMessage("Delete NhomNguoiDung success");
        response.setData(null);

        return response;
    }
}
