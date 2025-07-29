package id.ac.astra.polytechnic.backend_5s_sisprod.repository;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.BarangKerja;
import id.ac.astra.polytechnic.backend_5s_sisprod.model.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangKerjaRepository extends JpaRepository<BarangKerja, Integer> {
    List<BarangKerja> findByIdPengguna(Integer id);
}
