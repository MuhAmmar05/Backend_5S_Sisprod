package id.ac.astra.polytechnic.backend_5s_sisprod.controller;


import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.service.LogPenyimpananService;
import id.ac.astra.polytechnic.backend_5s_sisprod.vo.LogPenyimpananVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penyimpanan")
@CrossOrigin
public class LogPenyimpananController {
    @Autowired
    LogPenyimpananService logPenyimpananService;

    LogPenyimpananController(LogPenyimpananService logPenyimpananService) {
        this.logPenyimpananService = logPenyimpananService;
    }

    @GetMapping("/getPenyimpananBySearch/{search}")
    public DtoResponse getBarangByPengguna(@PathVariable String search) {
        return logPenyimpananService.getBySearch(search);
    }
}
