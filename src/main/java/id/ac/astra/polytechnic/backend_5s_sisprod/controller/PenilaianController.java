package id.ac.astra.polytechnic.backend_5s_sisprod.controller;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.Penilaian;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.service.PenilaianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penilaian")
@CrossOrigin
public class PenilaianController {
    @Autowired
    private PenilaianService penilaianService;

    PenilaianController(PenilaianService penilaianService) {
        this.penilaianService = penilaianService;
    }
    @GetMapping("/getAllPenilaian")
    public DtoResponse getAllPenilaian() {
        return penilaianService.getAllPenilaian();
    }

    @GetMapping("/getPenilaian/{id}")
    public DtoResponse getPenilaian(@PathVariable Integer id) {
        return penilaianService.getByPenilaian(id);
    }
    @PostMapping("/savePenilaian")
    public DtoResponse savePenilaian(@RequestBody Penilaian penilaian){
        return penilaianService.savePenilaian(penilaian);
    }
}
