package id.ac.astra.polytechnic.backend_5s_sisprod.service;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.Departemen;
import id.ac.astra.polytechnic.backend_5s_sisprod.model.Pengguna;
import id.ac.astra.polytechnic.backend_5s_sisprod.repository.DepartemenRepository;
import id.ac.astra.polytechnic.backend_5s_sisprod.repository.PenggunaRepository;
import id.ac.astra.polytechnic.backend_5s_sisprod.response.DtoResponse;
import id.ac.astra.polytechnic.backend_5s_sisprod.vo.PenggunaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PenggunaService {

    @Autowired
    private PenggunaRepository penggunaRepository;

    @Autowired
    private DepartemenRepository departemenRepository;


    public DtoResponse login(Pengguna pengguna) {
        Pengguna currentUser = penggunaRepository.findByUsernameAndPassword(pengguna.getUsername(), pengguna.getPassword());

        if (currentUser != null) {
            if (pengguna.getPassword().equals(currentUser.getPassword())) {
                Departemen departemen = departemenRepository.findById(currentUser.getIdDepartemen()).orElse(null);


                PenggunaVo penggunaVo = new PenggunaVo(
                        currentUser.getId_pengguna(),
                        currentUser.getNama_lengkap(),
                        currentUser.getAlamat(),
                        currentUser.getIdDepartemen(),
                        departemen.getNamaDepartemen(),
                        currentUser.getRole().name(),    // konversi Enum → String
                        currentUser.getStatus().name()   // konversi Enum → String
                );


                return new DtoResponse(200, penggunaVo, "Berhasil Login");
            }
        }

        return new DtoResponse(404, null, "Username atau Password salah");
    }
}