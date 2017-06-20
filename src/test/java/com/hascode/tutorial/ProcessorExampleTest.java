package com.hascode.tutorial;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.hascode.testing.myprocessors.CustomPersistenceProcessor;
import com.hascode.tutorial.entity.Author;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProcessorExampleTest {

  @BeforeClass
  public static void setupTest() {
    FixtureFactoryLoader.loadTemplates("com.hascode.testing.mytemplates");
  }

  @Test
  public void testAuthor() throws Exception {
    List<Author> authors = Fixture.from(Author.class).uses(new CustomPersistenceProcessor())
        .gimme(10, "valid");
    assertThat(authors).hasSize(10);
  }
}
