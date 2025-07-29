package id.ac.astra.polytechnic.backend_5s_sisprod.model;

import jakarta.persistence.*;



@Entity
@Table(name = "ms_departemen")
public class Departemen {
    @Id
    @Column(name = "id_departemen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartemen;

    @Column(name = "nama_departemen")
    private String namaDepartemen;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        aktif,
        nonaktif;
    }
    public Departemen(Integer idDepartemen, String namaDepartemen, String deskripsi, Status status) {
        this.idDepartemen = idDepartemen;
        this.namaDepartemen = namaDepartemen;
        this.deskripsi = deskripsi;
        this.status = status;
    }
    public Departemen() {}

    public Integer getIdDepartemen() {
        return idDepartemen;
    }

    public void setIdDepartemen(Integer idDepartemen) {
        this.idDepartemen = idDepartemen;
    }

    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    public void setNamaDepartemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}