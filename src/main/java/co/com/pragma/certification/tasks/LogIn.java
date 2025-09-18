package co.com.pragma.certification.tasks;

import co.com.pragma.certification.interactions.Back;
import co.com.pragma.certification.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.LogInPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class LogIn implements Task {
    User user;

    public LogIn(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LOG_IN_BUTTON, isCurrentlyVisible()).forNoMoreThan(5).seconds());
        actor.attemptsTo(
                Click.on(EMAIL_INPUT),
                Enter.theValue(user.getEmail()).into(EMAIL_INPUT),
                Back.now(),
                Click.on(PASSWORD_INPUT),
                Enter.theValue(user.getPassword()).into(PASSWORD_INPUT),
                Back.now(),
                Click.on(LOG_IN_BUTTON)
        );
    }

    public static LogIn with(User user) {
        return Tasks.instrumented(LogIn.class, user);
    }
}