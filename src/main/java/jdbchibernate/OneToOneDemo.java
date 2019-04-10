package jdbchibernate;

import jdbchibernate.entity.Article;
import jdbchibernate.entity.Author;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneDemo {
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-demo");
    EntityManager em = factory.createEntityManager();
    Article art = new Article();
    Author a = new Author();
    a.setNick("Luka");
    a.setFirstName("Łukasz");
    a.setLastName("Skowronek");
    art.setTitle("Oskutecznym rad sposobie");
    art.setContent("Tralala lalal alal al al al");
    art.setAuthor(a);

    em.getTransaction().begin();
    em.persist(a);
    em.persist(art);
    em.getTransaction().commit();
    em.close();
    factory.close();
  }
}
