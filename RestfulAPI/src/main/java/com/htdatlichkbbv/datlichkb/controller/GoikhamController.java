package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Goikham;
import com.htdatlichkbbv.datlichkb.service.GoikhamService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/goikham")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GoikhamController {

    @Autowired
    private GoikhamService goikhamService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Goikham>> getAllGoikham() {
        ResponseData<List<Goikham>> response = new ResponseData<>();

        List<Goikham> ls = this.goikhamService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Goikham> getGoikham(@PathVariable(name = "id") String id) {
        ResponseData<Goikham> response = new ResponseData<>();

        if (!goikhamService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Goikham " + id + " is not existed");
            response.setData(null);

            return response;
        }
        Goikham ls = this.goikhamService.findById(id).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Goikham> addGoikham(@RequestBody Goikham goikham) {
        ResponseData<Goikham> response = new ResponseData<>();

        if (goikhamService.findById(goikham.getMagk()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Goikham " + goikham.getMagk() + " is existed");
            response.setData(null);

            return response;
        }

        Goikham nd_temp = new Goikham();
        nd_temp.setMagk(goikham.getMagk());
        nd_temp.setTengk(goikham.getTengk());
        nd_temp.setDongia(goikham.getDongia());
        goikhamService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating Goikham success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Goikham> updateGoikham(@RequestBody Goikham goikham) {
        ResponseData<Goikham> response = new ResponseData<>();

        if (!goikhamService.findById(goikham.getMagk()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Goikham " + goikham.getMagk() + " is not existed");
            response.setData(null);

            return response;
        }

        Goikham nd_temp = new Goikham();
        nd_temp.setTengk(goikham.getTengk());
        nd_temp.setMagk(goikham.getMagk());
        nd_temp.setDongia(goikham.getDongia());
        goikhamService.update(nd_temp);

        response.setCode(200);
        response.setMessage("Update Khoa success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Goikham> deleteGoikham(@PathVariable(name = "id") String id) {
        ResponseData<Goikham> response = new ResponseData<>();

        if (!goikhamService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Goikham " + id + " is not existed");
            response.setData(null);

            return response;
        }
        goikhamService.deleteById(id);

        response.setCode(200);
        response.setMessage("Delete Goikham success");
        response.setData(null);

        return response;
    }
}
