package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Dichvu;
import com.htdatlichkbbv.datlichkb.service.DichvuService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/dichvu")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DichvuController {

    @Autowired
    private DichvuService dichvuService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Dichvu>> getAllDichVu() {
        ResponseData<List<Dichvu>> response = new ResponseData<>();

        List<Dichvu> ls = this.dichvuService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Dichvu> getDichVu(@PathVariable(name = "id") String id) {
        ResponseData<Dichvu> response = new ResponseData<>();

        if (!dichvuService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id DichVu " + id + " is not existed");
            response.setData(null);

            return response;
        }
        Dichvu ls = this.dichvuService.findById(id).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Dichvu> addDichVu(@RequestBody Dichvu dichvu) {
        ResponseData<Dichvu> response = new ResponseData<>();

        if (dichvuService.findById(dichvu.getMadv()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id DichVu " + dichvu.getMadv() + " is existed");
            response.setData(null);

            return response;
        }

        Dichvu nd_temp = new Dichvu();
        nd_temp.setMadv(dichvu.getMadv());
        nd_temp.setTendv(dichvu.getTendv());
        nd_temp.setDongia(dichvu.getDongia());
        dichvuService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating DichVu success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Dichvu> updateDichVu(@RequestBody Dichvu dichvu) {
        ResponseData<Dichvu> response = new ResponseData<>();

        if (!dichvuService.findById(dichvu.getMadv()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id DichVu " + dichvu.getMadv() + " is not existed");
            response.setData(null);

            return response;
        }

        Dichvu nd_temp = new Dichvu();
        nd_temp.setMadv(dichvu.getMadv());
        nd_temp.setTendv(dichvu.getTendv());
        nd_temp.setDongia(dichvu.getDongia());
        dichvuService.update(nd_temp);

        response.setCode(200);
        response.setMessage("Update Khoa success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Dichvu> deleteDichVu(@PathVariable(name = "id") String id) {
        ResponseData<Dichvu> response = new ResponseData<>();

        if (!dichvuService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id DichVu " + id + " is not existed");
            response.setData(null);

            return response;
        }
        dichvuService.deleteById(id);

        response.setCode(200);
        response.setMessage("Delete DichVu success");
        response.setData(null);

        return response;
    }
}
