package jdbc_hibernate;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import javax.transaction.*;
import javax.transaction.RollbackException;
import java.util.Locale;

@Entity
class Message {
  @Id
  @GeneratedValue
  private Long id;

  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}

interface UserRepository extends CrudRepository<Message, Integer> {

}

public class SimpleHibernateDemo {
  public static void main(String[] args) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
    TransactionManager TM = ;
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("HelloWorldPU");
    UserTransaction tx = TM.getUserTransaction();
    tx.begin();
    EntityManager em = emf.createEntityManager();
    Message message = new Message();
    message.setText("Hello World!");
    em.persist(message);
    tx.commit();
// INSERT into MESSAGE (ID, TEXT) values (1, 'Hello World!')
    em.close();
  }
}
