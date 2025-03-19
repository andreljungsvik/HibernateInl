package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String author;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Library getLibrary() {
        return library;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
