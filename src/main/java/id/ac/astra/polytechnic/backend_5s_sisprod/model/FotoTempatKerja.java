package id.ac.astra.polytechnic.backend_5s_sisprod.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tr_foto_tempat_kerja")
public class FotoTempatKerja {
    @Id
    @Column(name = "id_foto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFoto;

    @Column(name = "id_pengguna")
    private Integer idPengguna;

    @Column(name = "jenis_foto")
    @Enumerated(EnumType.STRING)
    private Jenis jenisFoto;

    public enum Jenis {
        awal,
        akhir;
    }

    @Column(name = "lokasi_kerja")
    private String lokasiKerja;

    @Column(name = "foto")
    private String foto;

    @Column(name = "waktu_foto")
    private LocalDateTime waktuFoto;

    public FotoTempatKerja() {}

    public FotoTempatKerja(Integer idFoto, Integer idPengguna, Jenis jenisFoto, String lokasiKerja, String foto, LocalDateTime waktuFoto) {
        this.idFoto = idFoto;
        this.idPengguna = idPengguna;
        this.jenisFoto = jenisFoto;
        this.lokasiKerja = lokasiKerja;
        this.foto = foto;
        this.waktuFoto = waktuFoto;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public Integer getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(Integer idPengguna) {
        this.idPengguna = idPengguna;
    }

    public Jenis getJenisFoto() {
        return jenisFoto;
    }

    public void setJenisFoto(Jenis jenisFoto) {
        this.jenisFoto = jenisFoto;
    }

    public String getLokasiKerja() {
        return lokasiKerja;
    }

    public void setLokasiKerja(String lokasiKerja) {
        this.lokasiKerja = lokasiKerja;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public LocalDateTime getWaktuFoto() {
        return waktuFoto;
    }

    public void setWaktuFoto(LocalDateTime waktuFoto) {
        this.waktuFoto = waktuFoto;
    }
}
