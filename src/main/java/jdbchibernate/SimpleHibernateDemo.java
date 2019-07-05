package jdbchibernate;


import jdbchibernate.entity.Author;
import jdbchibernate.entity.Person;
import org.hibernate.Session;;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class SimpleHibernateDemo {
  public static void main(String[] args) throws RollbackException {
    /*
    Author zenek = new Author();
    zenek.setFirstName("KAZIMIERZ");
    zenek.setLastName("WIELKI");
    zenek.setNick("KAZEK");
    Session session = DBConnection.getSession();
    session.beginTransaction();
    session.save(zenek);
    session.getTransaction().commit();
    DBConnection.close();
    */



    EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog");

    EntityManager em = emf.createEntityManager();
    Author a = em.find(Author.class, 1L);
    em.detach(a);
    em.getTransaction().begin();
    a.setNick("");
    em.getTransaction().commit();
    System.out.println("nick "+a.getNick());
    a = em.find(Author.class, 1L);
    System.out.println("nick "+a.getNick());
  }
}
