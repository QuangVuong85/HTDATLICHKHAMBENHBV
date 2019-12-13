package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Nguoidung;
import com.htdatlichkbbv.datlichkb.service.NguoidungService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/nguoidung")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NguoidungController {

    @Autowired
    private NguoidungService nguoidungService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Nguoidung>> getAllNguoiDung() {
        ResponseData<List<Nguoidung>> response = new ResponseData<>();

        List<Nguoidung> ls = this.nguoidungService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nguoidung> getNguoiDung(@PathVariable(name = "id") String matk) {
        ResponseData<Nguoidung> response = new ResponseData<>();

        if (!nguoidungService.findById(matk).isPresent()) {
            response.setCode(500);
            response.setMessage("Id NguoiDung " + matk + " is not existed");
            response.setData(null);

            return response;
        }
        Nguoidung ls = this.nguoidungService.findById(matk).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nguoidung> addNguoiDung(@RequestBody Nguoidung nd) {
        ResponseData<Nguoidung> response = new ResponseData<>();

        if (nguoidungService.findById(nd.getMatk()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id NguoiDung " + nd.getMatk() + " is existed");
            response.setData(null);

            return response;
        }

        Nguoidung nd_temp = new Nguoidung();
        nd_temp.setMatk(nd.getMatk());
        nd_temp.setTentk(nd.getTentk());
        nd_temp.setMatkhau(nd.getMatkhau());
        nd_temp.setManhomnd_(nd.getManhomnd_());
        nguoidungService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating NguoiDung success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nguoidung> updateNguoiDung(@RequestBody Nguoidung nd) {
        ResponseData<Nguoidung> response = new ResponseData<>();

        if (!nguoidungService.findById(nd.getMatk()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id NguoiDung " + nd.getMatk() + " is not existed");
            response.setData(null);

            return response;
        }

        Nguoidung nd_temp = new Nguoidung();
        nd_temp.setMatk(nd.getMatk());
        nd_temp.setTentk(nd.getTentk());
        nd_temp.setMatkhau(nd.getMatkhau());
        nd_temp.setManhomnd_(nd.getManhomnd_());
        nguoidungService.update(nd_temp);

        response.setCode(200);
        response.setMessage("Update NguoiDung success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nguoidung> deleteNguoiDung(@PathVariable(name = "id") String matk) {
        ResponseData<Nguoidung> response = new ResponseData<>();

        if (!nguoidungService.findById(matk).isPresent()) {
            response.setCode(500);
            response.setMessage("Id NguoiDung " + matk + " is not existed");
            response.setData(null);

            return response;
        }
        nguoidungService.deleteById(matk);

        response.setCode(200);
        response.setMessage("Delete NguoiDung success");
        response.setData(null);

        return response;
    }
}
