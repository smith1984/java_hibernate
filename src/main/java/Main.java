
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.smith.entity.HibernateUtil;
import ru.smith.entity.Product;

import java.util.List;

public class Main {


    public static void main(final String[] args) throws Exception {

        List<Product> products = null;

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();


        try{
            session.beginTransaction();

            Query query = session.createQuery("SELECT p FROM Product p JOIN FETCH p.productCategory");
            products = query.list();
            session.getTransaction().commit();
            //for (Product p: products)
            //    Hibernate.initialize(p.getProductCategory());

        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();

        }
        finally {
            session.close();
            sessionFactory.close();
        }

        for (Product p: products)
            System.out.println(p.getNameProduct() + "*" + p.getDescription() + "*" + p.getProductCategory().getTitle());


    }
}
