package id.ac.astra.polytechnic.backend_5s_sisprod.vo;

public class FotoTempatKerjaVo {
    private Integer idFoto;
    private Integer idPengguna;
    private String foto;
    private String jenis;
    private String lokasi;

    public FotoTempatKerjaVo(Integer idFoto, Integer idPengguna, String foto, String jenis, String lokasi) {
        this.idFoto = idFoto;
        this.idPengguna = idPengguna;
        this.foto = foto;
        this.jenis = jenis;
        this.lokasi = lokasi;
    }

    public FotoTempatKerjaVo() {}

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Integer getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(Integer idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
