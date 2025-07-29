package id.ac.astra.polytechnic.backend_5s_sisprod.controller;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.Pengguna;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pengguna")
@CrossOrigin
public class PenggunaController {
    @Autowired
    PenggunaService penggunaService;

    PenggunaController(PenggunaService penggunaService) {
        this.penggunaService = penggunaService;
    }

    @PostMapping("/login")
    public DtoResponse getUser(@RequestBody Pengguna pengguna) {
        return penggunaService.login(pengguna);
    }

}
