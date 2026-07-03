package ru.vtb.java.pro.javaprohibernate.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.vtb.java.pro.javaprohibernate.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final SessionFactory sessionFactory;

    public User save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            return user;
        }
    }

    public Optional<User> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return Optional.ofNullable(user);
        }
    }

    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User", User.class);
            session.getTransaction().commit();
            return query.list();
        }
    }

    public void delete(Long id) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.find(User.class, id);

            if (user != null) {
                session.remove(user);
            }
            session.getTransaction().commit();
        }
    }
}
