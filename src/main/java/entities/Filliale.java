package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "filliale")
public class Filliale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filliale_id;

    private  String nom;

    @ManyToOne
    @JoinColumn(name = "entreprise_entreprise_id")
    private Entreprise entreprise;

    @ManyToMany(mappedBy = "filliales")
    private Set<Secteur> secteurs = new HashSet<>();

    public  void addSecteur (Secteur secteur){
    this.secteurs.add(secteur);
    }

    public Long getFilliale_id() {
        return filliale_id;
    }

    public void setFilliale_id(Long filliale_id) {
        this.filliale_id = filliale_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Set<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(Set<Secteur> secteurs) {
        this.secteurs = secteurs;
    }


}
