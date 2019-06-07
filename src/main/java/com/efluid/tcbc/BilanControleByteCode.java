package com.efluid.tcbc;

import org.slf4j.*;

public class BilanControleByteCode {

  private static final Logger LOG = LoggerFactory.getLogger(BilanControleByteCode.class);

  private final TestControleByteCode testControleByteCode;

  public BilanControleByteCode(TestControleByteCode testControleByteCode) {
    this.testControleByteCode = testControleByteCode;
  }

  /**
   * Affiche le bilan du contrôle du byteCode
   */
  public int execute() {
    int nbErreurTotal = 0;
    int nbErreurParJar = 0;
    int nbJarEnErreur = 0;
    int nbClassesEnErreur = 0;
    StringBuilder erreursParJar = new StringBuilder();

    for (Jar jar : testControleByteCode.getJarsTraites()) {
      nbErreurParJar = 0;
      if (!jar.getClassesEnErreur().isEmpty()) {
        LOG.info("|=== " + jar.getNom() + " ===|");
        LOG.info("\t|=== Classes en erreur ===|");
      }
      for (Classe classeEnErreur : jar.getClassesEnErreur()) {
        nbErreurTotal += classeEnErreur.getNbErreurs();
        nbErreurParJar += classeEnErreur.getNbErreurs();
        nbClassesEnErreur++;

        LOG.info("\t\t" + classeEnErreur.getNom() + " : " + classeEnErreur.getNbErreurs() + " erreur(s)");
      }
      erreursParJar.append("\t" + jar.getNom() + " : " + nbErreurParJar).append(System.lineSeparator());
      if (nbErreurParJar > 0) {
        nbJarEnErreur++;
      }
    }

    TestControleByteCode.doLogList(testControleByteCode.getClassesReferenceesNonTrouveesOuChargees(), "Classes referencees non trouvees :");
    LOG.info("Classes non trouvees ou non chargees (erreur de chargement) : " + testControleByteCode.getClassesReferenceesNonTrouveesOuChargees().size());
    LOG.info("Erreur par jar : " + System.lineSeparator() + erreursParJar.toString());
    LOG.info("Jar en erreur : " + nbJarEnErreur);
    LOG.info("Classe en erreur : " + nbClassesEnErreur);
    LOG.info("Nombre d'erreur totale : " + nbErreurTotal);

    return nbErreurTotal;
  }
}
