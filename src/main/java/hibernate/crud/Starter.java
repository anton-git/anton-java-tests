package hibernate.crud;

import hibernate.crud.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Starter {

    //    final static SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    final static SessionFactory SESSION_FACTORY = new Configuration()
            .configure()
            .addAnnotatedClass(Book.class)
            .buildSessionFactory();

    private static void shutDownSessionFactory() {
        System.out.println("Shutting down session factory.");
        if (SESSION_FACTORY.isOpen()) {
            SESSION_FACTORY.close();
            System.out.println("Session factory was closed.");
        } else {
            System.out.println("Session factory is not open, unable to close.");
        }
    }

    private SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void main(String[] args) {

        final Starter app = new Starter();
        app.create(new Book(1, "Java book"));
        app.create(new Book(2, "SQL book"));

        final List<Book> storedBooks = app.getAll();
        storedBooks.forEach(System.out::println);

        shutDownSessionFactory();
    }

    private void create(final Book book) {
        System.out.println("Creating a book.");
        final Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        System.out.println("Book saved to session.");
        session.getTransaction().commit();
        try {
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Do not change id
     */
    private void update(final Book book) {
        System.out.println("Updating a book.");
        Session session = getSessionFactory().openSession();
        session.update(book);
        System.out.println("Book updated to session.");
        try {
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Book> getAll() {
        return getSessionFactory().openSession().createQuery("from Book", Book.class).list();
    }

    private Book getById() {
        return null;
    }
}
