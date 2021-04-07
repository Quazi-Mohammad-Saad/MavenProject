package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        //get(), load()

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        //No need of transaction because it's needed when you want to save something
        Session session=factory.openSession();

        //get-student :1,7 or 8
        Address student=(Address) session.get(Address.class,1);
        System.out.println(student);

        session.close();
        factory.close();

    }
}