package edu.miu.bookservice.bookcatalogservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.miu.bookservice.bookcatalogservice.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query(value = "select b from Book b join b.copy bc where bc.scanCode= :code")
    Book findByScanCode(@Param("code") String scanCode);

    @Query(value = "select b from Book b join b.author a where a.name= :name")
    Book findByAuthorName(@Param("name") String author);

    @Query(value = "select b from Book b where b.title= :title")
    Book findByTitle(@Param("title") String title);
}
