package id.ac.astra.polytechnic.backend_5s_sisprod.service;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.Penilaian;
import id.ac.astra.polytechnic.backend_5s_sisprod.repository.PenilaianRepository;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PenilaianService {

    @Autowired
    PenilaianRepository penilaianRepository;

    public DtoResponse getByPenilaian(Integer idPenilaian) {
        try {
            List<Penilaian> list = penilaianRepository.findByIdPenilaian(idPenilaian);
            if (list != null && !list.isEmpty()) {
                return new DtoResponse(200, list, "Data ditemukan");
            } else {
                return new DtoResponse(404, null, "Data penilaian tidak ditemukan");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    public DtoResponse getAllPenilaian() {
        try {
            List<Penilaian> list = penilaianRepository.findAll();
            if (!list.isEmpty()) {
                return new DtoResponse(200, list, "Data penilaian ditemukan");
            } else {
                return new DtoResponse(204, null, "Tidak ada data penilaian");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    public DtoResponse savePenilaian(Penilaian penilaian) {
        try {
            // Hitung total nilai jika null
            if (penilaian.getTotalNilai() == null) {
                int total = penilaian.getNilaiSeiri()
                        + penilaian.getNilaiSeiton()
                        + penilaian.getNilaiSeiso()
                        + penilaian.getNilaiSeiketsu()
                        + penilaian.getNilaiShitsuke();
                penilaian.setTotalNilai(total);
            }

            // Set waktu penilaian jika belum diisi
            if (penilaian.getWaktuPenilaian() == null) {
                penilaian.setWaktuPenilaian(LocalDateTime.now());
            }

            penilaianRepository.save(penilaian);
            return new DtoResponse(200, penilaian, "Penilaian berhasil disimpan");

        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi kesalahan: " + e.getMessage());
        }
    }

}
