package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Area
@Entity
@Table(name = "secteur")
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_secteur;

    private String nom;

    private String locationVille;


    @OneToMany(mappedBy = "secteur", cascade = CascadeType.ALL)
    private Set<Employes> employes;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "secteur_has_filliale",
            joinColumns = @JoinColumn(name = "secteur_secteur_id"),
            inverseJoinColumns = @JoinColumn(name = "filliale_filliale_id")
    )
    private Set<Filliale> filliales = new HashSet<>();

    public void addFilliale (Filliale filliale) {
        this.filliales.add(filliale);
    }

    public Long getId_secteur() {
        return id_secteur;
    }

    public void setId_secteur(Long id_secteur) {
        this.id_secteur = id_secteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Employes> getEmployes() {
        return employes;
    }

    public void setEmployes(Set<Employes> employes) {
        this.employes = employes;
    }

    public String getLocationVille() {
        return locationVille;
    }

    public void setLocationVille(String locationVille) {
        this.locationVille = locationVille;
    }

    public Set<Filliale> getFilliales() {
        return filliales;
    }

    public void setFilliales(Set<Filliale> filliales) {
        this.filliales = filliales;
    }
}
