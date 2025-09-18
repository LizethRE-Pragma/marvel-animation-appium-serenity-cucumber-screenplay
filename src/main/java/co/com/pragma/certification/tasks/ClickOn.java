package co.com.pragma.certification.tasks;

import co.com.pragma.certification.interactions.SwipeVertically;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.pragma.certification.userinterfaces.LogInPage.LOG_IN_BUTTON;
import static co.com.pragma.certification.userinterfaces.SingUpPage.SIGN_UP_BUTTON;

public class ClickOn {
    public static Performable logInButton() {
        return Task.where("Click on Log In button", actor -> {
            actor.attemptsTo(Click.on(LOG_IN_BUTTON));
        });
    }

    public static Performable signUpButton() {
        return Task.where("Click on Sign Up button", actor -> {
            actor.attemptsTo(SwipeVertically.toUp());
            actor.attemptsTo(Click.on(SIGN_UP_BUTTON));
        });
    }
}
