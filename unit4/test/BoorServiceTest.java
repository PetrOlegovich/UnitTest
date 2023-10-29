import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {

        Book expectedBook = new Book("1", "Book1", "Author1");


        when(bookRepository.findById("1")).thenReturn(expectedBook);


        Book actualBook = bookService.findBookById("1");

        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void testFindAllBooks() {

        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book1", "Author1"));
        expectedBooks.add(new Book("2", "Book2", "Author2"));

        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.findAllBooks();

        assertEquals(expectedBooks, actualBooks);
    }
}