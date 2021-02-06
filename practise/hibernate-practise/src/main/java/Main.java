import entity.Address;
import entity.Sex;
import entity.User;
import entity.UserShort;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        User user1 = new User().setFirstName("sierra").setLastName("user1").setSex(Sex.M).setAge(26).setPassport("xx3441");
//        User user2 = new User().setFirstName("tango").setLastName("user2").setSex(Sex.F).setAge(13).setPassport("3512xr");
//        User user3 = new User().setFirstName("sobik").setLastName("user3").setSex(Sex.U).setAge(59).setPassport("gse1436d");
//
//        session.save(user1);
//        session.save(user2);
//        session.save(user3);

//        session.getTransaction().commit();

//        Address ad = new Address();
//        ad.setCity("wdw");
//        ad.setCountry("country");
//        ad.setFlat("13");
//        ad.setStreet("street");

        User user = new User()
                .setLastName("Stepurko")
                .setFirstName("Alex")
                .setAge(37)
                .setSex(Sex.M)
                .setPassport("XX234512")
                .setPhone("380675644218");
                //.setAddress(ad);

//        session.save(user);
//        session.getTransaction().commit();

        Query q = session.createQuery("From User");

//        List<User> list = q.list();
//        System.out.println(list.size());
//        for (User u : list) {
//            System.out.println(u);
//        }

        session.createQuery("select lastName from User").list().forEach(System.out::println);

//        q = session.createQuery("From UserShort");
//
//        List<UserShort> listtwo = q.list();
//        System.out.println(listtwo.size());
//        for (UserShort u : listtwo) {
//            System.out.println(u);
//        }
    }
}
