package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App
{
    public static void main( String[] args ) throws IOException

    {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student st = new Student();

//        st.setId(2);
        st.setName("Saad");
        st.setCity("Mumbai");

        //creating object of Address class
        Address ad=new Address();
        ad.setStreet("street2");
        ad.setCity("Bangalore");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1.904);

        //reading image
        FileInputStream fis = new FileInputStream("src/main/java/Sketch-10-9-38-8-10-2019.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(st);
        session.save(ad);
        tx.commit();
        System.out.println(factory);
        session.close();
        System.out.println("Done....");

    }

}

