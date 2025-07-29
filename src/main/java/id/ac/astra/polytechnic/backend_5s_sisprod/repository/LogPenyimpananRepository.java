package id.ac.astra.polytechnic.backend_5s_sisprod.repository;

import id.ac.astra.polytechnic.backend_5s_sisprod.model.LogPenyimpanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogPenyimpananRepository extends JpaRepository<LogPenyimpanan, Integer> {

    @Query(value = """
        SELECT lp.id_log, bk.nama_barang, zs.nama_zona, lp.waktu_log, lp.keterangan
        FROM tr_log_penyimpanan lp 
        INNER JOIN ms_barang_kerja bk ON lp.id_barang = bk.id_barang
        INNER JOIN ms_zona_simpan zs ON lp.id_zona = zs.id_zona
        WHERE bk.nama_barang LIKE %:namaBarang% OR zs.nama_zona LIKE %:namaZona%
        """, nativeQuery = true)
    List<Object[]> searchLogByNamaBarangOrZona(
            @Param("namaBarang") String namaBarang,
            @Param("namaZona") String namaZona
    );

}
