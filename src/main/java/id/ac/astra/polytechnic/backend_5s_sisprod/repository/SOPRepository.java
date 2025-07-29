package id.ac.astra.polytechnic.backend_5s_sisprod.repository;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.SOP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SOPRepository extends JpaRepository<SOP, Integer> {
    @Query(value = """
        SELECT s.id_sop, d.nama_departemen, s.judul_sop, s.dokumen, s.status
        FROM ms_sop s
        INNER JOIN ms_departemen d ON s.id_departemen = d.id_departemen
        WHERE d.nama_departemen LIKE %:namaDepartemen%
        OR s.judul_sop LIKE %:judulSop%
        """, nativeQuery = true)
    List<Object[]> searchSOPByNamaDepartemenOrJudul(
            @Param("namaDepartemen") String namaDepartemen,
            @Param("judulSop") String judulSop
    );
}
