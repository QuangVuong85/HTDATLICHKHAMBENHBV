package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Chitietdichvu;
import com.htdatlichkbbv.datlichkb.entities.ChitietdichvuId;
import com.htdatlichkbbv.datlichkb.service.ChitietdichvuService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/chitietdichvu")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChitietdichvuController {

    @Autowired
    private ChitietdichvuService chitietdichvuService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Chitietdichvu>> getAllChitietdichvu() {
        ResponseData<List<Chitietdichvu>> response = new ResponseData<>();

        List<Chitietdichvu> ls = this.chitietdichvuService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseData<Chitietdichvu> getChitietdichvu(
            @RequestParam(value = "magk", required = false) String magk,
            @RequestParam(value = "malichhen", required = false) String malichhen
    ) {
        ResponseData<Chitietdichvu> response = new ResponseData<>();
        ChitietdichvuId chitietdichvuId = new ChitietdichvuId();
        chitietdichvuId.setMagk(magk);
        chitietdichvuId.setMalichhen(malichhen);

        if (!chitietdichvuService.findById(chitietdichvuId).isPresent()) {
            response.setCode(500);
            response.setMessage("(MaGK, MaLichHen) Chitietdichvu (" + magk + ", " + malichhen + ") is not existed");
            response.setData(null);

            return response;
        }
        Chitietdichvu ls = this.chitietdichvuService.findById(chitietdichvuId).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Chitietdichvu> addChitietdichvu(
            @RequestBody Chitietdichvu chitietdichvu
    ) {
        ResponseData<Chitietdichvu> response = new ResponseData<>();
        ChitietdichvuId chitietdichvuId = chitietdichvu.chitietdichvuId__;

        if (chitietdichvuService.findById(chitietdichvuId).isPresent()) {
            response.setCode(500);
            response.setMessage("(MaGK, MaLichHen) Chitietdichvu " + chitietdichvuId.getMagk()
                    + ", " + chitietdichvuId.getMalichhen() + ") is existed");
            response.setData(null);

            return response;
        }

        Chitietdichvu nd_temp = new Chitietdichvu();
        nd_temp.setChitietdichvuId__(chitietdichvuId);
        nd_temp.setThoigiandat(chitietdichvu.getThoigiandat());
        nd_temp.setGhichu(chitietdichvu.getGhichu());
        chitietdichvuService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating Chitietdichvu success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Chitietdichvu> updateBacSi(
            @RequestBody Chitietdichvu chitietdichvu
    ) {
        ResponseData<Chitietdichvu> response = new ResponseData<>();
        ChitietdichvuId chitietdichvuId = chitietdichvu.chitietdichvuId__;

        if (!chitietdichvuService.findById(chitietdichvuId).isPresent()) {
            response.setCode(500);
            response.setMessage("(magk, MaLichHen) Chitietdichvu" + chitietdichvuId.getMagk()
                    + ", " + chitietdichvuId.getMalichhen() + ") is not existed");
            response.setData(null);

            return response;
        }

        Chitietdichvu nd_temp = new Chitietdichvu();
        nd_temp.setChitietdichvuId__(chitietdichvuId);
        nd_temp.setThoigiandat(chitietdichvu.getThoigiandat());
        nd_temp.setGhichu(chitietdichvu.getGhichu());
        chitietdichvuService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Update Chitietdichvu success");
        response.setData(nd_temp);

        return response;
    }

    @DeleteMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Chitietdichvu> deleteChitietdichvu(
            @RequestParam(value = "magk", required = false) String magk,
            @RequestParam(value = "malichhen", required = false) String malichhen
    ) {
        ResponseData<Chitietdichvu> response = new ResponseData<>();
        ChitietdichvuId chitietdichvuId = new ChitietdichvuId();
        chitietdichvuId.setMalichhen(malichhen);
        chitietdichvuId.setMagk(magk);

        if (!chitietdichvuService.findById(chitietdichvuId).isPresent()) {
            response.setCode(500);
            response.setMessage("(magk, MaLichHen) Chitietdichvu (" + magk + ", " + malichhen + ") is not existed");
            response.setData(null);

            return response;
        }
        this.chitietdichvuService.deleteById(chitietdichvuId);
        response.setCode(200);
        response.setMessage("Delete Chitietdichvu success");
        response.setData(null);

        return response;
    }
}
