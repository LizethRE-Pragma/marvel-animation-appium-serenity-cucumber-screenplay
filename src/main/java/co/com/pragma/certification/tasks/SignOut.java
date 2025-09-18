package co.com.pragma.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.ProfilePage.ACCEPT_BUTTON;
import static co.com.pragma.certification.userinterfaces.ProfilePage.SIGN_OUT_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class SignOut implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(SIGN_OUT_BUTTON, isCurrentlyVisible()).forNoMoreThan(5).seconds());
        actor.attemptsTo(
                Click.on(SIGN_OUT_BUTTON),
                Click.on(ACCEPT_BUTTON)
        );
    }

    public static SignOut now() {
        return Tasks.instrumented(SignOut.class);
    }
}