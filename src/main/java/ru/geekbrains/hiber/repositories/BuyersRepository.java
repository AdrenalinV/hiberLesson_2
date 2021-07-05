package ru.geekbrains.hiber.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.hiber.entities.Buyer;

@Component
public class BuyersRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public BuyersRepository(SessionFactory sessionFactory) {
        if (sessionFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = sessionFactory.unwrap(SessionFactory.class);
    }

    public  void createBuyer(Buyer b) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(b);
            session.getTransaction().commit();
        }
    }

    public  Buyer readBuyer(long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }

    public  void updateBuyer(Buyer b, long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.evict(buyer);
            buyer.setName(b.getName());
            session.update(buyer);
            session.getTransaction().commit();
        }
    }

    public void deleteBuyer(long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.delete(buyer);
            session.getTransaction().commit();
        }
    }
}
