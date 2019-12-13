package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Nguoidatlich;
import com.htdatlichkbbv.datlichkb.service.BenhnhanService;
import com.htdatlichkbbv.datlichkb.service.NguoidatlichService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/nguoidatlich")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NguoidatlichController {

    @Autowired
    private NguoidatlichService nguoidatlichService;

    @Autowired
    private BenhnhanService benhnhanService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Nguoidatlich>> getAllNguoidatlich() {
        ResponseData<List<Nguoidatlich>> response = new ResponseData<>();

        List<Nguoidatlich> ls = this.nguoidatlichService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nguoidatlich> getNguoidatlich(@PathVariable(name = "id") String id) {
        ResponseData<Nguoidatlich> response = new ResponseData<>();

        if (!nguoidatlichService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Nguoidatlich " + id + " is not existed");
            response.setData(null);

            return response;
        }
        Nguoidatlich ls = this.nguoidatlichService.findById(id).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nguoidatlich> addNguoidatlich(@RequestBody Nguoidatlich nguoidatlich) {
        ResponseData<Nguoidatlich> response = new ResponseData<>();

        if (nguoidatlichService.findById(nguoidatlich.getManguoidat()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Nguoidatlich " + nguoidatlich.getManguoidat() + " is existed");
            response.setData(null);

            return response;
        }

        // check mabn
        if (!benhnhanService.findById(nguoidatlich.getMabn_()).isPresent()) {
            response.setCode(500);
            response.setMessage("MaBN Nguoidatlich " + nguoidatlich.getMabn_() + " is not existed");
            response.setData(null);

            return response;
        }

        Nguoidatlich nd_temp = new Nguoidatlich();
        nd_temp.setManguoidat(nguoidatlich.getManguoidat());
        nd_temp.setHoten(nguoidatlich.getHoten());
        nd_temp.setSodt(nguoidatlich.getSodt());
        nd_temp.setEmail(nguoidatlich.getEmail());
        nd_temp.setMabn_(nguoidatlich.getMabn_());

        nguoidatlichService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating Nguoidatlich success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nguoidatlich> updateNguoidatlich(@RequestBody Nguoidatlich nguoidatlich) {
        ResponseData<Nguoidatlich> response = new ResponseData<>();

        if (!nguoidatlichService.findById(nguoidatlich.getManguoidat()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Nguoidatlich " + nguoidatlich.getManguoidat() + " is not existed");
            response.setData(null);

            return response;
        }

        // check mabn
        if (!benhnhanService.findById(nguoidatlich.getMabn_()).isPresent()) {
            response.setCode(500);
            response.setMessage("MaBN Nguoidatlich " + nguoidatlich.getMabn_() + " is not existed");
            response.setData(null);

            return response;
        }

        Nguoidatlich nd_temp = new Nguoidatlich();
        nd_temp.setManguoidat(nguoidatlich.getManguoidat());
        nd_temp.setHoten(nguoidatlich.getHoten());
        nd_temp.setSodt(nguoidatlich.getSodt());
        nd_temp.setEmail(nguoidatlich.getEmail());
        nd_temp.setMabn_(nguoidatlich.getMabn_());

        nguoidatlichService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Update Nguoidatlich success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Nguoidatlich> deleteNguoidatlich(@PathVariable(name = "id") String id) {
        ResponseData<Nguoidatlich> response = new ResponseData<>();

        if (!nguoidatlichService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Nguoidatlich " + id + " is not existed");
            response.setData(null);

            return response;
        }
        nguoidatlichService.deleteById(id);

        response.setCode(200);
        response.setMessage("Delete Nguoidatlich success");
        response.setData(null);

        return response;
    }
}
