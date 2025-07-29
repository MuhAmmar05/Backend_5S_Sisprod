package id.ac.astra.polytechnic.backend_5s_sisprod.controller;


import id.ac.astra.polytechnic.backend_5s_sisprod.model.BarangKerja;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.service.BarangKerjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
@CrossOrigin
public class BarangKerjaController {

    @Autowired
    BarangKerjaService barangKerjaService;
    BarangKerjaController(BarangKerjaService barangKerjaService) {
        this.barangKerjaService = barangKerjaService;
    }

    @GetMapping("/getBarangByPengguna/{id}")
    public DtoResponse getBarangByPengguna(@PathVariable Integer id){
        return barangKerjaService.getByPengguna(id);
    }

    @PostMapping("/saveBarangPekerja")
    public DtoResponse saveBarangPekerja(@RequestBody BarangKerja barangKerja){
        return barangKerjaService.saveBarangPekerja(barangKerja);
    }

    @PutMapping("/updateBarangPekerja")
    public DtoResponse updaterBarangPekerja(@RequestBody BarangKerja barangKerja){
        return barangKerjaService.updateBarangPekerja(barangKerja);
    }


}
