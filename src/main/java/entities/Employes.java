package entities;

import javax.persistence.*;

@Entity
@Table(name = "employes")
public class Employes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employes;

    private String nom;

    private  String prenom;

    private String email;

    private int age;

    private String fonction;

    private String tel;

    private  String adresse;

    @ManyToOne
    @JoinColumn(name = "secteur_secteur_id")
    private Secteur secteur;

    public Long getId_employes() {
        return id_employes;
    }

    public void setId_employes(Long id_employes) {
        this.id_employes = id_employes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }


}
