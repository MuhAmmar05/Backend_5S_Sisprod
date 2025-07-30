package id.ac.astra.polytechnic.backend_5s_sisprod.service;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.FotoTempatKerja;
import id.ac.astra.polytechnic.backend_5s_sisprod.repository.FotoTempatKerjaRepository;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.vo.FotoTempatKerjaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.LocalDateTime;


import static id.ac.astra.polytechnic.backend_5s_sisprod.constant.API_URL.FOTO_TEMPAT_URL;

@Service
public class FotoKerjaService {

    @Autowired
    private FotoTempatKerjaRepository fotoTempatKerjaRepository;

    @Value("${file.upload-foto-dir}")
    private String uploadDir;

    public DtoResponse saveFotoTempatKerja(MultipartFile file, FotoTempatKerjaVo vo) {
        try {
            // Validasi ekstensi file
            String namaFile = file.getOriginalFilename();
            if (namaFile == null || namaFile.isBlank()) {
                return new DtoResponse(400, "Gagal", "Nama file tidak valid");
            }

            String lowerName = namaFile.toLowerCase();
            if (!(lowerName.endsWith(".jpg") || lowerName.endsWith(".jpeg") || lowerName.endsWith(".png"))) {
                return new DtoResponse(400, "Gagal", "Hanya file .jpg, .jpeg, atau .png yang diperbolehkan");
            }

            // Path tujuan
            Path path = Paths.get(uploadDir, namaFile);

            // Optional: Hapus jika sudah ada
            if (Files.exists(path)) {
                Files.delete(path);
            }

            Files.copy(file.getInputStream(), path);

            // Simpan ke database
            FotoTempatKerja foto = new FotoTempatKerja();
            foto.setIdPengguna(vo.getIdPengguna());
            foto.setJenisFoto(FotoTempatKerja.Jenis.valueOf(vo.getJenis()));
            foto.setLokasiKerja(vo.getLokasi());
            foto.setFoto(namaFile);
            foto.setWaktuFoto(LocalDateTime.now());

            fotoTempatKerjaRepository.save(foto);

            return new DtoResponse(200, "Sukses", "Foto tempat kerja berhasil disimpan");

        } catch (IOException e) {
            return new DtoResponse(500, "Gagal", "Gagal menyimpan file foto: " + e.getMessage());
        }
    }

    public DtoResponse getTempatKerja(Integer fotoParams) {
        FotoTempatKerja tempatKerja = fotoTempatKerjaRepository.findById(fotoParams).orElse(null);

        if (tempatKerja == null) {
            return new DtoResponse(404, null, "Izin tidak ditemukan");
        }

        String urlFoto = FOTO_TEMPAT_URL + tempatKerja.getFoto();
        tempatKerja.setFoto(urlFoto);

        return new DtoResponse(200, tempatKerja, "OK");
    }


}
