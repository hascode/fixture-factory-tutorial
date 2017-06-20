package com.hascode.tutorial;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.hascode.tutorial.entity.Author;
import org.junit.Test;

public class ReUsingTemplatesExampleTest {

  @Test
  public void testWithBooks() throws Exception {
    Fixture.of(Author.class).addTemplate("valid", new Rule() {{
      add("firstName", firstName());
      add("lastName", lastName());
      add("email", "${firstName}.${lastName}@email.com");
    }});

    Fixture.of(Author.class).addTemplate("invalid").inherits("valid", new Rule() {{
      add("lastName", "");
    }});

    Author author = Fixture.from(Author.class).gimme("invalid");
    assertThat(author.getLastName()).isEmpty();

    System.out.println(author);
  }
}
