package com.hascode.tutorial;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.hascode.tutorial.entity.Author;
import com.hascode.tutorial.entity.Book;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.Test;

public class FixtureExampleTest {

  @Test
  public void testWithBooks() throws Exception {
    Fixture.of(Author.class).addTemplate("valid", new Rule() {{
      add("firstName", firstName());
      add("lastName", firstName());
      add("email", "${firstName}.${lastName}@email.com");
    }});

    Fixture.of(Book.class).addTemplate("valid", new Rule() {{
      add("id", random(Long.class, range(1L, 200L)));
      add("authors", has(2).of(Author.class, "valid"));
      add("title", regex("[A-Z]{1}[A-Z a-z]{9,29}"));
      add("created", afterDate("2017-06-22", new SimpleDateFormat("yyyy-MM-dd")));
    }});

    Book oneBook = Fixture.from(Book.class).gimme("valid");

    assertThat(oneBook.getId()).isBetween(1L, 1000L)
        .as("id must be between 1 and 1000, value is: %s", oneBook.getId());
    assertThat(oneBook.getTitle()).isNotBlank();
    assertThat(oneBook.getAuthors()).hasSize(2);
    // and so on ..

    System.out.println(oneBook);

    List<Book> twentyBooks = Fixture.from(Book.class).gimme(20, "valid");
    assertThat(twentyBooks).hasSize(20);

    // jff
    twentyBooks.forEach(System.out::println);
  }
}
