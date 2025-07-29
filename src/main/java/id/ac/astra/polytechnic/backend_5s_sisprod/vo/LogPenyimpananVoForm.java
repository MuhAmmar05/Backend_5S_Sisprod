package id.ac.astra.polytechnic.backend_5s_sisprod.vo;

public class LogPenyimpananVoForm {
    private String namaBarang;
    private String namaZona;

    public LogPenyimpananVoForm(String namaBarang, String namaZona) {
        this.namaBarang = namaBarang;
        this.namaZona = namaZona;
    }
    public LogPenyimpananVoForm() {}

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
}
