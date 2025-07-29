package id.ac.astra.polytechnic.backend_5s_sisprod.service;


import id.ac.astra.polytechnic.backend_5s_sisprod.model.BarangKerja;
import id.ac.astra.polytechnic.backend_5s_sisprod.repository.BarangKerjaRepository;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangKerjaService {
    @Autowired
    private BarangKerjaRepository barangKerjaRepository;

    public DtoResponse getByPengguna(Integer id) {
        try{
            List<BarangKerja> barangKerja = barangKerjaRepository.findByIdPengguna(id);
            if (barangKerja != null) {
                return new DtoResponse(200, barangKerja, "OK");
            }
            return new DtoResponse(404, null, "barang kerja tidak ditemukan");
        } catch (Exception e){
            return new DtoResponse(500, null, e.getMessage());
        }

    }

    public DtoResponse saveBarangPekerja(BarangKerja barangKerja) {
        try{
            barangKerja.setIdDepartemen(null);
            barangKerja.setJenisKepemilikan(1);
            barangKerjaRepository.save(barangKerja);
            return new DtoResponse(200, barangKerja, "OK");
        } catch (Exception e){
            return new DtoResponse(500, null, e.getMessage());
        }
    }

    public DtoResponse updateBarangPekerja(BarangKerja barangKerja) {
        try{
            BarangKerja selectedBarang = barangKerjaRepository.findById(barangKerja.getIdBarang()).orElseThrow();
            if(selectedBarang != null){
                if (barangKerja.getNamaBarang() != null){
                    selectedBarang.setNamaBarang(barangKerja.getNamaBarang());
                }
                if (barangKerja.getJumlah() != null){
                    selectedBarang.setJumlah(barangKerja.getJumlah());
                }
                if (barangKerja.getStatusPenggunaan() != null){
                    selectedBarang.setStatusPenggunaan(barangKerja.getStatusPenggunaan());
                }
                if (barangKerja.getAlasanTidakDipakai() != null){
                    selectedBarang.setAlasanTidakDipakai(barangKerja.getAlasanTidakDipakai());
                }
                if (barangKerja.getTindakLanjut() != null){
                    selectedBarang.setTindakLanjut(barangKerja.getTindakLanjut());
                }
                barangKerjaRepository.save(selectedBarang);
                return new DtoResponse(200, selectedBarang, "OK");
            }

            return new DtoResponse(404, null, "baran tidak ditemukan");
        } catch (Exception e){
            return new DtoResponse(500, null, e.getMessage());
        }
    }



}
