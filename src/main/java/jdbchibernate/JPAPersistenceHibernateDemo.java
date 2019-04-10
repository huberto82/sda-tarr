package jdbchibernate;

import jdbchibernate.entity.Author;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAPersistenceHibernateDemo {
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-demo");
    EntityManager em = factory.createEntityManager();
    Author a = new Author();
    a.setFirstName("Bolesław");
    a.setLastName("Prus");
    a.setNick("Aolek");
    em.getTransaction().begin();
    em.persist(a);
    em.getTransaction().commit();
    em.close();
    factory.close();
  }
}
