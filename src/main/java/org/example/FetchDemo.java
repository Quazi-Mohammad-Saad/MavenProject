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
        Student student=(Student) session.load(Student.class,1);   //Student.class --->Identity Type
//        System.out.println(student);
        //like in which class's object you want to find followed by Identifier
//        System.out.println(student.getCity()+" : "+student.getName());

        //Creating other objects of Student class
//        Student student1=(Student) session.get(Student.class,1);
//        System.out.println(student);


        //Same thing we are performing for the Address class
//        Address ad = (Address) session.get(Address.class,1);
//        System.out.println(ad.getCity()+" : "+ad.isOpen());

        session.close();
        factory.close();

    }
}