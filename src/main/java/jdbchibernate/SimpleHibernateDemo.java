package jdbchibernate;


import org.hibernate.Session;

import javax.persistence.RollbackException;

public class SimpleHibernateDemo {
  public static void main(String[] args) throws RollbackException {
    MyMessage msg = new MyMessage();
    msg.setText("Second message");
    Session session = DBConnection.getSession();
    session.beginTransaction();
    session.save(msg);
    session.getTransaction().commit();
    DBConnection.close();
  }
}
