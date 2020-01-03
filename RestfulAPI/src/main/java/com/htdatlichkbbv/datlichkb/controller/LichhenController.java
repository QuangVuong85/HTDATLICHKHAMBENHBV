package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Dichvu;
import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import com.htdatlichkbbv.datlichkb.entities.context.LichHenCuaBacSiContext;
import com.htdatlichkbbv.datlichkb.entities.context.LichhenContext;
import com.htdatlichkbbv.datlichkb.entities.context.LichhenTheoBacsiContext;
import com.htdatlichkbbv.datlichkb.service.BacsiService;
import com.htdatlichkbbv.datlichkb.service.BenhnhanService;
import com.htdatlichkbbv.datlichkb.service.DichvuService;
import com.htdatlichkbbv.datlichkb.service.LichhenService;
import com.htdatlichkbbv.datlichkb.utils.Constant;
import com.htdatlichkbbv.datlichkb.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.URL_V1 + "/lichhen")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LichhenController {

    @Autowired
    private LichhenService lichhenService;

    @Autowired
    private BenhnhanService benhnhanService;

    @Autowired
    private  DichvuService dichvuService;

    @Autowired
    private BacsiService bacsiService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<List<Lichhen>> getAllLichhen() {
        ResponseData<List<Lichhen>> response = new ResponseData<>();

        List<Lichhen> ls = this.lichhenService.findAll();
        response.setCode(200);
        response.setMessage("Get all data success");
        response.setData(ls);
        return response;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Lichhen> getLichhen(@PathVariable(name = "id") String id) {
        ResponseData<Lichhen> response = new ResponseData<>();

        if (!lichhenService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Lichhen " + id + " is not existed");
            response.setData(null);

            return response;
        }
        Lichhen ls = this.lichhenService.findById(id).get();
        response.setCode(200);
        response.setMessage("Get data success");
        response.setData(ls);

        return response;
    }
    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<LichHenCuaBacSiContext> getLichhenCuaBacSi(
            @RequestParam(name = "mabacsi") String mabacsi) {
        ResponseData<LichHenCuaBacSiContext> response = new ResponseData<>();
        System.out.println(mabacsi);
        if (!bacsiService.findById(mabacsi).isPresent()) {
            response.setCode(500);
            response.setMessage("bác sĩ có mã " + mabacsi + "chưa có lịch hẹn");
            response.setData(null);

            return response;
        } else {
            LichHenCuaBacSiContext lichHenCuaBacSiContext = new LichHenCuaBacSiContext();
            Bacsi bacsi = this.bacsiService.findById(mabacsi).get();
            List<Lichhen> lichhencuabacsi = this.lichhenService.DanhSachLichHenCuaBacSi(mabacsi);
            List<Dichvu> dichvucuabacsi = this.dichvuService.DanhSachDichVuCuaBacSi(mabacsi);
            lichHenCuaBacSiContext.setBacsi(bacsi);
            lichHenCuaBacSiContext.setListDichVu(dichvucuabacsi);
            lichHenCuaBacSiContext.setListLichHen(lichhencuabacsi);
            response.setCode(200);
            response.setMessage("Get data success");
            response.setData(lichHenCuaBacSiContext);

            return response;
        }
    }


    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Lichhen> addLichhen(@RequestBody Lichhen lichhen) {
        ResponseData<Lichhen> response = new ResponseData<>();

        if (lichhenService.findById(lichhen.getMalichhen()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Lichhen " + lichhen.getMalichhen() + " is existed");
            response.setData(null);

            return response;
        }

        Lichhen nd_temp = new Lichhen();
        nd_temp.setMalichhen(lichhen.getMalichhen());
        nd_temp.setNgaykham(lichhen.getNgaykham());
        nd_temp.setThoigian(lichhen.getThoigian());
        nd_temp.setTrangthai(lichhen.getTrangthai());
        nd_temp.setMabs_(lichhen.getMabs_());

        lichhenService.save(nd_temp);

        response.setCode(200);
        response.setMessage("Creating Lichhen success");
        response.setData(nd_temp);

        return response;
    }

    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Lichhen> updateLichhen(@RequestBody LichhenContext lichhenContext) {
        ResponseData<Lichhen> response = new ResponseData<>();

        if (!lichhenService.findById(lichhenContext.getMalichhen()).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Lichhen " + lichhenContext.getMalichhen()+ " is not existed");
            response.setData(null);

            return response;
        }

        // check mabn
        if (!benhnhanService.findById(lichhenContext.getMabn()).isPresent()) {
            response.setCode(500);
            response.setMessage("MaBN Benhnhan " + lichhenContext.getMabn() + " is not existed");
            response.setData(null);

            return response;
        }

        System.out.println(lichhenContext);
        lichhenService.updateLichHenOld(
                lichhenContext.getMalichhen(),
                lichhenContext.getMabn(),
                lichhenContext.getTrangthai(),
                lichhenContext.getGhichu());
        response.setCode(200);
        response.setMessage("Update Lichhen success");
        response.setData(null);

        return response;
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseData<Lichhen> deleteLichhen(@PathVariable(name = "id") String id) {
        ResponseData<Lichhen> response = new ResponseData<>();

        if (!lichhenService.findById(id).isPresent()) {
            response.setCode(500);
            response.setMessage("Id Lichhen " + id + " is not existed");
            response.setData(null);

            return response;
        }
        lichhenService.deleteById(id);

        response.setCode(200);
        response.setMessage("Delete Lichhen success");
        response.setData(null);

        return response;
    }
}
