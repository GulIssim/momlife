package kz.vienna.momlife.model.entity;


import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, unique = true)
    private String iin;

    @Column(nullable = false)
    private String full_name;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Pregnancy> pregnancies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public List<Pregnancy> getPregnancies() {
        return pregnancies;
    }

    public void setPregnancies(List<Pregnancy> pregnancies) {
        this.pregnancies = pregnancies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                Objects.equals(iin, patient.iin) &&
                Objects.equals(full_name, patient.full_name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, iin, full_name);
    }
}
