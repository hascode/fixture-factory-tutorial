package com.hascode.testing.myprocessors;

import br.com.six2six.fixturefactory.processor.Processor;

public class CustomPersistenceProcessor implements Processor {

  @Override
  public void execute(Object o) {
    System.out.printf("persisting test-data: %s\n", o);
  }
}
