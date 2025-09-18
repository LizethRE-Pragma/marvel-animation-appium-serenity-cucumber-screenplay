package co.com.pragma.certification.stepdefinitions;

import co.com.pragma.certification.models.User;
import co.com.pragma.certification.questions.TheWelcomeText;
import co.com.pragma.certification.tasks.ClickOn;
import co.com.pragma.certification.tasks.LogIn;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LogInStepDefinitions {
    @Cuando("ingresa sus credenciales {string} {string}")
    public void ingresaSusCredenciales(String email, String password) {
        String resolvedEmail = resolveVariable(email, "EMAIL");
        String resolvedPassword = resolveVariable(password, "PASSWORD");

        OnStage.theActorInTheSpotlight().attemptsTo(LogIn.with(User.
                builder().
                email(resolvedEmail).
                password(resolvedPassword).
                build()
        ));
    }

    @Entonces("deberia ver el mensaje de bienvenida")
    public void deberiaVerLaPaginaDeInicio() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheWelcomeText.isDisplayed(OnStage.theActorInTheSpotlight().getName())));
    }

    @Cuando("da en Iniciar Sesion")
    public void daEnIniciarSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickOn.logInButton());
    }

    public String resolveVariable(String value, String key) {
        if (value.startsWith("$")) {
            return System.getenv(key);
            //return System.getProperty(key);
        }
        return value;
    }
}
