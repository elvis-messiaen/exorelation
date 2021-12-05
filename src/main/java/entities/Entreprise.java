package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "entreprise")
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entreprise_id;

    private String nom;


    @OneToMany(mappedBy = "entreprise",cascade = CascadeType.ALL)
    private Set<Filliale> filliale;

    public Long getEntreprise_id() {
        return entreprise_id;
    }

    public void setEntreprise_id(Long entreprise_id) {
        this.entreprise_id = entreprise_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Filliale> getFilliale() {
        return filliale;
    }

    public void setFilliale(Set<Filliale> filliale) {
        this.filliale = filliale;
    }
}
