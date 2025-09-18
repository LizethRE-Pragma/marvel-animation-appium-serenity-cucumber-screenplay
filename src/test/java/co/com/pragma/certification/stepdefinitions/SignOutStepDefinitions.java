package co.com.pragma.certification.stepdefinitions;

import co.com.pragma.certification.questions.TheLogInPage;
import co.com.pragma.certification.tasks.GoTo;
import co.com.pragma.certification.tasks.SignOut;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SignOutStepDefinitions {
    @Cuando("cierra sesion")
    public void cierraSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoTo.profilePage());
        OnStage.theActorInTheSpotlight().attemptsTo(SignOut.now());
    }

    @Entonces("deberia ver la pagina de Inicio de Sesion")
    public void deberiaVerLaPaginaDeInicioDeSesion() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheLogInPage.isDisplayed()));
    }
}
