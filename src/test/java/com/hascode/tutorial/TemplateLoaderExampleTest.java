package com.hascode.tutorial;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.hascode.tutorial.entity.Author;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemplateLoaderExampleTest {

  @BeforeClass
  public static void setupTest() {
    FixtureFactoryLoader.loadTemplates("com.hascode.testing.mytemplates");
  }

  @Test
  public void testAuthor() throws Exception {
    Author valid = Fixture.from(Author.class).gimme("valid");
    Author invalid = Fixture.from(Author.class).gimme("invalid");

    assertThat(valid.getLastName()).isNotEmpty();
    assertThat(invalid.getLastName()).isEmpty();

    System.out.printf("valid: %s\n", valid);
    System.out.printf("invalid: %s\n", invalid);
  }
}
