package co.com.pragma.certification.tasks;

import co.com.pragma.certification.interactions.Back;
import co.com.pragma.certification.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.ResetPasswordPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class ResetPassword implements Task {
    User user;

    public ResetPassword(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(TITLE_TEXT, isCurrentlyVisible()).forNoMoreThan(5).seconds());
        actor.attemptsTo(
                Click.on(EMAIL_INPUT),
                Enter.theValue(user.getEmail()).into(EMAIL_INPUT),
                Back.now(),
                Click.on(SUBMIT_BUTTON)
        );
    }

    public static ResetPassword with(User user) {
        return Tasks.instrumented(ResetPassword.class, user);
    }
}