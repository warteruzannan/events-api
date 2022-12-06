package br.com.advanse.eventsapi.arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "br.com.advanse.eventsapi")
public class CoreRulesTest {

    @ArchTest
    void core_depends(JavaClasses javaClasses){
        var rule = layeredArchitecture()
                .consideringOnlyDependenciesInLayers()
                .layer("Core").definedBy("br.com.advanse.eventsapi.core..")
                .layer("Application").definedBy("br.com.advanse.eventsapi.application..")
                .layer("Data").definedBy("br.com.advanse.eventsapi.data..")
                .whereLayer("Core")
                .mayNotAccessAnyLayer();

        rule.check(javaClasses);
    }
}