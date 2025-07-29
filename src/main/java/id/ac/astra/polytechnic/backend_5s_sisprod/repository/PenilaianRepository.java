package id.ac.astra.polytechnic.backend_5s_sisprod.repository;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.BarangKerja;
import id.ac.astra.polytechnic.backend_5s_sisprod.model.Penilaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenilaianRepository extends JpaRepository<Penilaian, Integer> {

}
