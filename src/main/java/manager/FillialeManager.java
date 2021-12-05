package manager;

import entities.Employes;
import entities.Entreprise;
import entities.Filliale;
import entities.Secteur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class FillialeManager {
    public static void main(String[] args) {
        SessionFactory sessionFactory;


        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // filliale
        Filliale filliale = new Filliale();
        filliale.setNom("filliale");

        //employe
        Employes employes = new Employes();
        employes.setNom("elvis");
        employes.setPrenom("mess");
        employes.setEmail("mess@gmail.fr");
        employes.setTel("032020202000");
        employes.setFonction("PDG");
        employes.setAdresse("12 rue de lille, 59000 Lille");
        employes.setAge(40);

        // entreprise
        Entreprise entreprise = new Entreprise();
        entreprise.setNom("entreprise");



        // entreprise => dans filliale
        filliale.setEntreprise(entreprise);

        Set<Filliale> fillialesGlobal = new HashSet<>();

        fillialesGlobal.add(filliale);
        entreprise.setFilliale(fillialesGlobal);

        session.save(entreprise);
        session.save(filliale);

        //secteur
        Secteur secteur = new Secteur();
        secteur.setNom("secteur");
        secteur.setLocationVille("Lille");
        secteur.setFilliales(fillialesGlobal);
        employes.setSecteur(secteur);


        Set<Employes> employesList = new HashSet<Employes>();
        employesList.add(employes);
        secteur.setEmployes(employesList);


        employes.setSecteur(secteur);
        filliale.addSecteur(secteur);
        secteur.addFilliale(filliale);

        session.save(secteur);
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
