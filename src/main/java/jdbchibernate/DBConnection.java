package jdbchibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBConnection {

  private static SessionFactory factory;

  static {
    Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
            .build();

    factory = cfg.buildSessionFactory(serviceRegistry);
  }

  public static Session getSession() {
    return factory.openSession();
  }

  public void doWork() {}

  public static void close() {
    factory.close();
  }

}