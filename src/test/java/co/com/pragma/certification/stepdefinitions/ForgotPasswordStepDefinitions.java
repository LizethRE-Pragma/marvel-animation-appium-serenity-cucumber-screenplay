package co.com.pragma.certification.stepdefinitions;

import co.com.pragma.certification.models.User;
import co.com.pragma.certification.tasks.GoTo;
import co.com.pragma.certification.tasks.ResetPassword;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;

public class ForgotPasswordStepDefinitions {
    @Dado("va a la pagina de Restablecer contrasenia")
    public void vaALaPaginaDeRestablecerContrasenia() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoTo.forgotPasswordPage());
    }

    @Cuando("ingresa su correo {string}")
    public void ingresaSuCorreo(String email) {
        OnStage.theActorInTheSpotlight().attemptsTo(ResetPassword.with(User.builder()
                .email(email)
                .build()
        ));
    }
}
