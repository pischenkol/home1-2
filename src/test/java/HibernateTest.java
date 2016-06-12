import Hibernate.HibernateUtil;
import models.Manager;
import models.Office;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by appleface on 12.06.16.
 */
public class HibernateTest {
    @Test
    public void testConnection() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Office office = session.get(Office.class, 11);
            Assert.assertNotNull(office);
            Assert.assertNotNull(office.getRegion());
            Manager manager = office.getManager();
            Assert.assertNotNull(manager);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
