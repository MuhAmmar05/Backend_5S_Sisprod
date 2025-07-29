package id.ac.astra.polytechnic.backend_5s_sisprod.controller;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.Pengguna;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.service.PenggunaService;
import id.ac.astra.polytechnic.backend_5s_sisprod.service.SOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/sop")
@CrossOrigin
public class SOPController {
    @Autowired
    SOPService sopService;

private String uploadDir = "uploads/dokumen";

    SOPController(SOPService sopService) {
        this.sopService = sopService;
    }

    @GetMapping("/getSop/{search}")
    public DtoResponse getSop(@PathVariable String search) {
        return sopService.getAllSOP(search);
    }

    @GetMapping("/dokumen/{filename}")
    public ResponseEntity<Resource> getFoto(@PathVariable String filename) throws IOException {
        Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
