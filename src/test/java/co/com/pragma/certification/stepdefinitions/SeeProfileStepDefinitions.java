package co.com.pragma.certification.stepdefinitions;

import co.com.pragma.certification.tasks.GoTo;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;

public class SeeProfileStepDefinitions {
    @Dado("va a la seccion de Perfil")
    public void vaALaSeccionDePerfil() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoTo.profilePage());
    }
}
