package id.ac.astra.polytechnic.backend_5s_sisprod.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.service.FotoKerjaService;
import id.ac.astra.polytechnic.backend_5s_sisprod.vo.FotoTempatKerjaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/tempat")
@CrossOrigin
public class TempatKerjaController {

    @Autowired
    private FotoKerjaService fotoKerjaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${file.upload-foto-dir}")
    private String uploadDir;

    TempatKerjaController(FotoKerjaService fotoKerjaService) {
        this.fotoKerjaService = fotoKerjaService;
    }

    @GetMapping("/getReqFoto/{id}")
    public DtoResponse getTempatKerja(@PathVariable Integer id) {
        return fotoKerjaService.getTempatKerja(id);
    }

    @PostMapping(value = "/addFoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DtoResponse saveFoto(@RequestPart("file") MultipartFile file, @RequestPart("tempat")String tempatJson) throws IOException {
        FotoTempatKerjaVo fotoTempatKerjaVo = objectMapper.readValue(tempatJson, FotoTempatKerjaVo.class);
        return  fotoKerjaService.saveFotoTempatKerja(file, fotoTempatKerjaVo);
    }

    @GetMapping("/foto/{filename}")
    public ResponseEntity<Resource> getFoto(@PathVariable String filename) throws IOException {
        Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}
