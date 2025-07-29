package id.ac.astra.polytechnic.backend_5s_sisprod.vo;


public class PenggunaVo {
    private Integer id_pengguna;
    private String nama_lengkap;
    private String alamat;
    private Integer idDepartemen;
    private String nama_departemen;
    private String role;
    private String status;

    public PenggunaVo() {}

    public PenggunaVo(Integer id_pengguna, String nama_lengkap, String alamat, Integer idDepartemen,String nama_departemen, String role, String status) {
        this.id_pengguna = id_pengguna;
        this.nama_lengkap = nama_lengkap;
        this.alamat = alamat;
        this.idDepartemen = idDepartemen;
        this.nama_departemen = nama_departemen;
        this.role = role;
        this.status = status;
    }

    public Integer getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(Integer id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getIdDepartemen() {
        return idDepartemen;
    }

    public void setIdDepartemen(Integer idDepartemen) {
        this.idDepartemen = idDepartemen;
    }

    public String getNama_departemen() {
        return nama_departemen;
    }

    public void setNama_departemen(String nama_departemen) {
        this.nama_departemen = nama_departemen;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
