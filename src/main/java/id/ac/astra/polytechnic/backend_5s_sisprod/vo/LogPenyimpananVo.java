package id.ac.astra.polytechnic.backend_5s_sisprod.vo;

import java.time.LocalDateTime;

public class LogPenyimpananVo {
    private Integer idLog;
    private String namaBarang;
    private String namaZona;
    private LocalDateTime waktuLog;
    private String keterangan;

    public LogPenyimpananVo(Integer idLog, String namaBarang, String namaZona, LocalDateTime waktuLog, String keterangan) {
        this.idLog = idLog;
        this.namaBarang = namaBarang;
        this.namaZona = namaZona;
        this.waktuLog = waktuLog;
        this.keterangan = keterangan;
    }
    public LogPenyimpananVo() {}

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaZona() {
        return namaZona;
    }

    public void setNamaZona(String namaZona) {
        this.namaZona = namaZona;
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
