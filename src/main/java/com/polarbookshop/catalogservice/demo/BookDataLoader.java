package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.persistence.BookRepository;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "polar.loadTestData", havingValue = "true")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        List.of(
            Book.of("1234567891", "Northern Lights", "Lyra Silverstar", 9.90),
            Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90)
        ).forEach(book -> {
            if (!bookRepository.existsByIsbn(book.isbn())) {
                bookRepository.save(book);
            }
        });
    }
}
