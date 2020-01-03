package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import com.htdatlichkbbv.datlichkb.service.BenhnhanService;
import com.htdatlichkbbv.datlichkb.service.NguoidungService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/benhnhan")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BenhnhanController {

    @Autowired
    private BenhnhanService benhnhanService;

    @Autowired
    private NguoidungService nguoidungService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Benhnhan>> getAllBenhNhan() {
        ResponseData<List<Benhnhan>> response = new ResponseData<>();

        List<Benhnhan> ls = this.benhnhanService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Benhnhan> getBenhNhan(@PathVariable(name = "id") String id) {
        ResponseData<Benhnhan> response = new ResponseData<>();

        if (!benhnhanService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Ma BenhNhan " + id + " is not existed");
            response.setData(null);

            return response;
        }

        Benhnhan ls = this.benhnhanService.findById(id).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Benhnhan> addBenhNhan(@RequestBody Benhnhan benhnhan) {
        ResponseData<Benhnhan> response = new ResponseData<>();

        if (benhnhanService.findById(benhnhan.getMabn()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id BenhNhan " + benhnhan.getMabn() + " is existed");
            response.setData(null);

            return response;
        }

        Benhnhan nd_temp = new Benhnhan();
        nd_temp.setMabn(benhnhan.getMabn());
        nd_temp.setHoten(benhnhan.getHoten());
        nd_temp.setGioitinh(benhnhan.getGioitinh());
        nd_temp.setSodt(benhnhan.getSodt());
        nd_temp.setEmail(benhnhan.getEmail());
        nd_temp.setDiachi(benhnhan.getDiachi());
        nd_temp.setMatk_(benhnhan.getMatk_());

        benhnhanService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating BenhNhan success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Benhnhan> updateBenhNhan(@RequestBody Benhnhan benhnhan) {
        ResponseData<Benhnhan> response = new ResponseData<>();

        if (!benhnhanService.findById(benhnhan.getMabn()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id BenhNhan " + benhnhan.getMabn() + " is not existed");
            response.setData(null);

            return response;
        }

        // check matk
        if (!nguoidungService.findById(benhnhan.getMatk_()).isPresent()) {
            response.setCode(500);
            response.setMessage("MaTK BenhNhan " + benhnhan.getMatk_() + " is not existed");
            response.setData(null);

            return response;
        }

        Benhnhan nd_temp = new Benhnhan();
        nd_temp.setMabn(benhnhan.getMabn());
        nd_temp.setHoten(benhnhan.getHoten());
        nd_temp.setGioitinh(benhnhan.getGioitinh());
        nd_temp.setSodt(benhnhan.getSodt());
        nd_temp.setEmail(benhnhan.getEmail());
        nd_temp.setDiachi(benhnhan.getDiachi());
        nd_temp.setMatk_(benhnhan.getMatk_());
        benhnhanService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Update BacSi success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Benhnhan> deleteBenhNhan(@PathVariable(name = "id") String id) {
        ResponseData<Benhnhan> response = new ResponseData<>();

        if (!benhnhanService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id BenhNhan " + id + " is not existed");
            response.setData(null);

            return response;
        }
        benhnhanService.deleteById(id);

        response.setCode(200);
        response.setMessage("Delete BenhNhan success");
        response.setData(null);

        return response;
    }
}
