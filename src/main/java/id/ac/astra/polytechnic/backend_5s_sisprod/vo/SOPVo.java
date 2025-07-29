package id.ac.astra.polytechnic.backend_5s_sisprod.vo;

public class SOPVo {
    private Integer idSop;
    private String namaDepartemen;
    private String judulSop;
    private String dokumen;
    private String status;

    public SOPVo() {}

    public SOPVo(Integer idSop, String namaDepartemen, String judulSop, String dokumen, String status) {
        this.idSop = idSop;
        this.namaDepartemen = namaDepartemen;
        this.judulSop = judulSop;
        this.dokumen = dokumen;
        this.status = status;
    }

    public Integer getIdSop() {
        return idSop;
    }

    public void setIdSop(Integer idSop) {
        this.idSop = idSop;
    }

    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    public void setNamaDepartemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
    }

    public String getJudulSop() {
        return judulSop;
    }

    public void setJudulSop(String judulSop) {
        this.judulSop = judulSop;
    }

    public String getDokumen() {
        return dokumen;
    }

    public void setDokumen(String dokumen) {
        this.dokumen = dokumen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
