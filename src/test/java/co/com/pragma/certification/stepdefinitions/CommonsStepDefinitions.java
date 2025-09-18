package co.com.pragma.certification.stepdefinitions;

import co.com.pragma.certification.models.User;
import co.com.pragma.certification.questions.TheAlert;
import co.com.pragma.certification.tasks.LogIn;
import co.com.pragma.certification.utils.DriverManager;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CommonsStepDefinitions {
    @Managed(driver = "appium")
    public static WebDriver driver;

    @Dado("que {actor} esta en la pagina de Inicio de Sesion de Marvel Animation")
    public void queActorEstaEnLaPaginaDeInicioDeSesionDeMarvelAnimation(Actor actor) {
        DriverManager.setDriver(driver);
        actor.can(BrowseTheWeb.with(driver).asActor(actor));
        actor.entersTheScene();
    }

    @Entonces("deberia ver la alerta con el mensaje {string}")
    public void deberiaVerLaAlertaConElMensaje(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheAlert.isDisplayed(message)));
    }

    @Dado("que {actor} ha iniciado sesion")
    public void queActorHaIniciadoSesion(Actor actor) {
        String email = System.getenv("EMAIL");
        String password = System.getenv("PASSWORD");

        queActorEstaEnLaPaginaDeInicioDeSesionDeMarvelAnimation(actor);
        OnStage.theActorInTheSpotlight().attemptsTo(LogIn.with(User.
                builder().
                email(email).
                password(password).
                build()
        ));
    }
}