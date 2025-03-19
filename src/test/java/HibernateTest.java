import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Book;
import se.yrgo.domain.Library;

public class HibernateTest {


    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Library lib = new Library("Biblioteket");

        Book b1 = new Book("Cool bok", "Magnus");
        Book b2 = new Book("Pippi", "Astrid Lindgren");

        lib.addBook(b1);
        lib.addBook(b2);

        session.save(lib);
        session.save(b1);
        session.save(b2);

        tx.commit();
        session.close();


        session = sf.openSession();
        tx = session.beginTransaction();

        Library library = session.get(Library.class, 1);
        System.out.println("Antal böcker i library: " + library.getBooks().size());
        for (Book book : library.getBooks()) {
            System.out.println("Bok: " + book.getTitle() + " Författare: " + book.getAuthor());
        }


        tx.commit();
        session.close();
    }

    private static SessionFactory sessionFactory = null;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
