package com.efluid.tcbc.process;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScanneClasspathTest {

  private ScanneClasspath tested;

  @Before
  public void init() {
    tested = Mockito.mock(ScanneClasspath.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  public void should_return_empty_list_on_get_fichiers_class() throws IOException {
    String pathThatExist = "";
    String pathThatDoesNotExist = "Path/that/does/not/exist";

    List<Path> shoudlNotBeEmpty = tested.getFichiersClass(pathThatExist);
    assertThat(shoudlNotBeEmpty.isEmpty()).isFalse();

    List<Path> shoudlBeEmpty = tested.getFichiersClass(pathThatDoesNotExist);
    assertThat(shoudlBeEmpty.isEmpty()).isTrue();
  }
}