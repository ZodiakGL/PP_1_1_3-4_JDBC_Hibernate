package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;



public class UserDaoHibernateImpl implements UserDao {
    Util util = new Util();
    Session session = Util.getSessionFactory().openSession();
    public UserDaoHibernateImpl() {

    }
    @Override
    public void createUsersTable() {
        try {
            session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "lastName VARCHAR(50) NOT NULL," +
                    "age SMALLINT NOT NULL)";
            SQLQuery query = session.createSQLQuery(sql);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS users";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
                session.beginTransaction();
                User user = new User(name, lastName, age);
                session.save(user);
                session.getTransaction().commit();
            } catch (Exception e) {
            }
        }

    @Override
    public void removeUserById(long id) {
        try{
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            session.beginTransaction();
            users = session.createQuery("from User")
                    .getResultList();
            session.getTransaction().commit();
    } catch (Exception e) {
        }
        return users;
    }
    @Override
    public void cleanUsersTable() {
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}
