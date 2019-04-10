package jdbchibernate;


import jdbchibernate.entity.Author;
import org.hibernate.Session;;

import javax.persistence.RollbackException;

public class SimpleHibernateDemo {
  public static void main(String[] args) throws RollbackException {
    Author zenek = new Author();
    zenek.setFirstName("KAZIMIERZ");
    zenek.setLastName("WIELKI");
    zenek.setNick("KAZEK");
    Session session = DBConnection.getSession();
    session.beginTransaction();
    session.save(zenek);
    session.getTransaction().commit();
    DBConnection.close();
  }
}
