package manager;

import entities.Employes;


import entities.Secteur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class SecteurManager {
    public static void main(String[] args) {
        SessionFactory sessionFactory;


        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Secteur informatique = new Secteur();
        informatique.setNom("informatique");
        informatique.setLocationVille("Lille");


        Employes employes = new Employes();
        employes.setNom("elvis");
        employes.setPrenom("mess");
        employes.setEmail("mess@gmail.fr");
        employes.setTel("032020202000");
        employes.setFonction("PDG");
        employes.setAdresse("12 rue de lille, 59000 Lille");
        employes.setAge(40);
        employes.setSecteur(informatique);

        Employes employes2 = new Employes();
        employes2.setNom("paul");
        employes2.setPrenom("marcarné");
        employes2.setEmail("paul@gmail.fr");
        employes2.setTel("0202022200");
        employes2.setFonction("kiki");
        employes2.setAdresse("1122 rue des souris");
        employes2.setAge(40);
        employes2.setSecteur(informatique);

        Set<Employes> employesList = new HashSet<Employes>();
        employesList.add(employes);
        employesList.add(employes2);
        informatique.setEmployes(employesList);

        session.save(informatique);



        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
