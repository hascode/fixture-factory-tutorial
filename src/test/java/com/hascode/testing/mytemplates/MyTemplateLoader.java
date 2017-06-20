package com.hascode.testing.mytemplates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.hascode.tutorial.entity.Author;
import com.hascode.tutorial.entity.Book;
import java.text.SimpleDateFormat;

public class MyTemplateLoader implements TemplateLoader {

  @Override
  public void load() {
    Fixture.of(Author.class).addTemplate("valid", new Rule() {{
      add("firstName", firstName());
      add("lastName", lastName());
      add("email", "${firstName}.${lastName}@email.com");
    }});

    Fixture.of(Book.class).addTemplate("valid", new Rule() {{
      add("id", random(Long.class, range(1L, 200L)));
      add("authors", has(2).of(Author.class, "valid"));
      add("title", regex("[A-Z]{1}[A-Z a-z]{9,29}"));
      add("created", afterDate("2017-06-22", new SimpleDateFormat("yyyy-MM-dd")));
    }});

    Fixture.of(Author.class).addTemplate("invalid").inherits("valid", new Rule() {{
      add("lastName", "");
    }});
  }
}
