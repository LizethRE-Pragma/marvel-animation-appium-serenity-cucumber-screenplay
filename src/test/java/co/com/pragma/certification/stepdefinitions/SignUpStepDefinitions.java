package co.com.pragma.certification.stepdefinitions;

import co.com.pragma.certification.models.User;
import co.com.pragma.certification.tasks.ClickOn;
import co.com.pragma.certification.tasks.GoTo;
import co.com.pragma.certification.tasks.SignUp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class SignUpStepDefinitions {
    @Dado("va a la pagina de Registro")
    public void vaALapaginaDeRegistro() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoTo.signUpPage());
    }

    @Cuando("diligencia la informacion de registro")
    public void diligenciaLaInformacion(DataTable dataTable) {
        List<List<String>> items = dataTable.asLists(String.class);

        for (int i = 1; i < items.size(); i++) {
            String name = items.get(i).get(0) == null ? "" : items.get(i).get(0).trim();
            String email = items.get(i).get(1) == null ? "" : items.get(i).get(1).trim();
            String password = items.get(i).get(2) == null ? "" : items.get(i).get(2).trim();
            String confirmPassword = items.get(i).get(3) == null ? "" : items.get(i).get(3).trim();
            String gender = items.get(i).get(4) == null ? "" : items.get(i).get(4).trim();
            String terms = items.get(i).get(5) == null ? "" : items.get(i).get(5).trim();

            OnStage.theActorInTheSpotlight().attemptsTo(SignUp.with(User.builder()
                    .name(name)
                    .email(email)
                    .password(password)
                    .confirmPassword(confirmPassword)
                    .gender(gender)
                    .terms(terms)
                    .build()
            ));
        }
    }

    @Cuando("da en Registrarse")
    public void daEnRegistrarse() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickOn.signUpButton());
    }

}
