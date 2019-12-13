package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Phongkham;
import com.htdatlichkbbv.datlichkb.entities.PhongkhamId;
import com.htdatlichkbbv.datlichkb.service.PhongkhamService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/phongkham")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PhongkhamController {

    @Autowired
    private PhongkhamService phongkhamService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Phongkham>> getAllPhongKham() {
        ResponseData<List<Phongkham>> response = new ResponseData<>();

        List<Phongkham> ls = this.phongkhamService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseData<Phongkham> getPhongKham(
            @RequestParam(value = "mabs", required = false) String mabs,
            @RequestParam(value = "makhoa", required = false) String makhoa
    ) {
        ResponseData<Phongkham> response = new ResponseData<>();
        PhongkhamId phongkhamId = new PhongkhamId();
        phongkhamId.setMabs(mabs);
        phongkhamId.setMakhoa(makhoa);

        if (!phongkhamService.findById(phongkhamId).isPresent()) {
            response.setCode(500);
            response.setMessage("(MaBS, MaKhoa) PhongKham (" + mabs + ", " + makhoa + ") is not existed");
            response.setData(null);

            return response;
        }
        Phongkham ls = this.phongkhamService.findById(phongkhamId).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Phongkham> addPhongKham(
            @RequestBody Phongkham phongkham
    ) {
        ResponseData<Phongkham> response = new ResponseData<>();
        PhongkhamId phongkhamId = phongkham.phongkhamId__;

        if (phongkhamService.findById(phongkhamId).isPresent()) {
            response.setCode(500);
            response.setMessage("(MaBS, MaKhoa) PhongKham (" + phongkhamId.getMabs()
                    + ", " + phongkhamId.getMakhoa() + ") is existed");
            response.setData(null);

            return response;
        }

        Phongkham nd_temp = new Phongkham();
        nd_temp.setPhongkhamId__(phongkhamId);
        nd_temp.setSophong(phongkham.getSophong());
        phongkhamService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating PhongKham success");
        response.setData(nd_temp);

        return response;
    }

   @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Phongkham> updateBacSi(
            @RequestBody Phongkham phongkham
   ) {
       ResponseData<Phongkham> response = new ResponseData<>();
       PhongkhamId phongkhamId = phongkham.phongkhamId__;

       if (!phongkhamService.findById(phongkhamId).isPresent()) {
           response.setCode(500);
           response.setMessage("(MaBS, MaKhoa) PhongKham (" + phongkhamId.getMabs()
                   + ", " + phongkhamId.getMakhoa() + ") is not existed");
           response.setData(null);

           return response;
       }

       Phongkham nd_temp = new Phongkham();
       nd_temp.setPhongkhamId__(phongkhamId);
       nd_temp.setSophong(phongkham.getSophong());
       phongkhamService.save(nd_temp);

       response.setCode(200);
       response.setMessage("Update PhongKham success");
       response.setData(nd_temp);

       return response;
    }

    @DeleteMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Phongkham> deletePhongKham(
            @RequestParam(value = "mabs", required = false) String mabs,
            @RequestParam(value = "makhoa", required = false) String makhoa
    ) {
        ResponseData<Phongkham> response = new ResponseData<>();
        PhongkhamId phongkhamId = new PhongkhamId();
        phongkhamId.setMabs(mabs);
        phongkhamId.setMakhoa(makhoa);

        if (!phongkhamService.findById(phongkhamId).isPresent()) {
            response.setCode(500);
            response.setMessage("(MaBS, MaKhoa) PhongKham (" + mabs + ", " + makhoa + ") is not existed");
            response.setData(null);

            return response;
        }
        this.phongkhamService.deleteById(phongkhamId);
        response.setCode(200);
        response.setMessage("Delete PhongKham success");
        response.setData(null);

        return response;
    }
}
