package manager;

import entities.Employes;


import entities.Entreprise;
import entities.Filliale;import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class EntrepriseManager {
    public static void main(String[] args) {
        SessionFactory sessionFactory;


        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Entreprise danone = new Entreprise();
        danone.setNom("danone");


        Filliale grossiste = new Filliale();
        grossiste.setNom("grossiste");

        grossiste.setEntreprise(danone);

        Set<Filliale> fillialesGlobal = new HashSet<>();

        fillialesGlobal.add(grossiste);
        danone.setFilliale(fillialesGlobal);

        session.save(danone);
        session.save(grossiste);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
