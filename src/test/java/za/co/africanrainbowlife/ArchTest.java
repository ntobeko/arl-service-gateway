package za.co.africanrainbowlife;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("za.co.africanrainbowlife");

        noClasses()
            .that()
            .resideInAnyPackage("za.co.africanrainbowlife.service..")
            .or()
            .resideInAnyPackage("za.co.africanrainbowlife.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..za.co.africanrainbowlife.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
