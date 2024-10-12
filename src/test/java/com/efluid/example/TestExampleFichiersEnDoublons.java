package com.efluid.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;

import com.efluid.tcbc.TestControleFichiersEnDoublon;

public class TestExampleFichiersEnDoublons extends TestControleFichiersEnDoublon {

  @Override
  protected void isValid(int erreurs) {
    assertThat(erreurs).isEqualTo(2);
    assertThat(fichiersEnDoublon.get(Disabled.class.getName() + ".class")).isNotNull();
    assertThat(fichiersEnDoublon.get("META-INF.maven.commons-cli.commons-cli.pom.properties")).isNotNull();
  }
}
