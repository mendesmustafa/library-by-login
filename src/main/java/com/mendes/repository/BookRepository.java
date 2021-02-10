package com.mendes.repository;

import com.mendes.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mendesmustafa on 09.02.2021.
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
