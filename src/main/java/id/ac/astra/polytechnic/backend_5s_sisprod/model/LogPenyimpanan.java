package id.ac.astra.polytechnic.backend_5s_sisprod.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tr_log_penyimpanan")
public class LogPenyimpanan {
    @Id
    @Column(name = "id_log")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLog;

    @Column(name = "id_barang")
    private Integer idBarang;

    @Column(name = "id_zona")
    private Integer idZona;

    @Column(name = "waktu_log")
    private LocalDateTime waktuLog;

    @Column(name = "keterangan")
    private String keterangan;

    public LogPenyimpanan() {}

    public LogPenyimpanan(Integer idLog, Integer idBarang, Integer idZona, LocalDateTime waktuLog, String keterangan) {
        this.idLog = idLog;
        this.idBarang = idBarang;
        this.idZona = idZona;
        this.waktuLog = waktuLog;
        this.keterangan = keterangan;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public Integer getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Integer idBarang) {
        this.idBarang = idBarang;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public LocalDateTime getWaktuLog() {
        return waktuLog;
    }

    public void setWaktuLog(LocalDateTime waktuLog) {
        this.waktuLog = waktuLog;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
