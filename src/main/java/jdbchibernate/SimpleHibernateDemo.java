package jdbchibernate;


import org.hibernate.Session;

import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

public class SimpleHibernateDemo {
  public static void main(String[] args) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
    MyMessage msg = new MyMessage();
    msg.setText("First message");

    Session session = DBConnection.getSession();
    session.beginTransaction();
    session.save(msg);
    session.getTransaction().commit();
    DBConnection.close();
  }
}
