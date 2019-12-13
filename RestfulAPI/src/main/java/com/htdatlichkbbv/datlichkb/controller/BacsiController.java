package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Nguoidung;
import com.htdatlichkbbv.datlichkb.service.BacsiService;
import com.htdatlichkbbv.datlichkb.service.KhoaService;
import com.htdatlichkbbv.datlichkb.service.NguoidungService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/bacsi")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BacsiController {

    @Autowired
    private BacsiService bacsiService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private NguoidungService nguoidungService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Bacsi>> getAllBacSi() {
        ResponseData<List<Bacsi>> response = new ResponseData<>();

        List<Bacsi> ls = this.bacsiService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Bacsi> getBacSi(@PathVariable(name = "id") String id) {
        ResponseData<Bacsi> response = new ResponseData<>();

        if (!bacsiService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id BacSi " + id + " is not existed");
            response.setData(null);

            return response;
        }
        Bacsi ls = this.bacsiService.findById(id).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Bacsi> addBacSi(@RequestBody Bacsi bacsi) {
        ResponseData<Bacsi> response = new ResponseData<>();

        if (bacsiService.findById(bacsi.getMabs()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id BacSi " + bacsi.getMabs() + " is existed");
            response.setData(null);

            return response;
        }

        Bacsi nd_temp = new Bacsi();
        nd_temp.setMabs(bacsi.getMabs());
        nd_temp.setTenbs(bacsi.getTenbs());
        nd_temp.setChucvu(bacsi.getChucvu());
        nd_temp.setHinhanh(bacsi.getHinhanh());
        nd_temp.setMakhoa_(bacsi.getMakhoa_());
        nd_temp.setMatk_(bacsi.getMatk_());

        bacsiService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating BacSi success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Bacsi> updateBacSi(@RequestBody Bacsi bacsi) {
        ResponseData<Bacsi> response = new ResponseData<>();

        if (!bacsiService.findById(bacsi.getMabs()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id BacSi " + bacsi.getMabs() + " is not existed");
            response.setData(null);

            return response;
        }

        System.out.println(bacsi.getMakhoa_());
        // check makhoa
        if (!khoaService.findById(bacsi.getMakhoa_()).isPresent()) {
            response.setCode(500);
            response.setMessage("MaKhoa BacSi " + bacsi.getMabs() + " is not existed");
            response.setData(null);

            return response;
        }

        System.out.println(bacsi.getMatk_());
        // check matk
        if (!nguoidungService.findById(bacsi.getMatk_()).isPresent()) {
            response.setCode(500);
            response.setMessage("MaTK BacSi " + bacsi.getMabs() + " is not existed");
            response.setData(null);

            return response;
        }

        Bacsi nd_temp = new Bacsi();
        nd_temp.setMabs(bacsi.getMabs());
        nd_temp.setTenbs(bacsi.getTenbs());
        nd_temp.setChucvu(bacsi.getChucvu());
        nd_temp.setHinhanh(bacsi.getHinhanh());
        nd_temp.setMakhoa_(bacsi.getMakhoa_());
        nd_temp.setMatk_(bacsi.getMatk_());
        bacsiService.update(nd_temp);

        response.setCode(200);
        response.setMessage("Update BacSi success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Bacsi> deleteBacSi(@PathVariable(name = "id") String id) {
        ResponseData<Bacsi> response = new ResponseData<>();

        if (!bacsiService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id BacSi " + id + " is not existed");
            response.setData(null);

            return response;
        }
        bacsiService.deleteById(id);

        response.setCode(200);
        response.setMessage("Delete BacSi success");
        response.setData(null);

        return response;
    }
}
