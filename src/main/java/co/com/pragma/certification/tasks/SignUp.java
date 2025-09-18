package co.com.pragma.certification.tasks;

import co.com.pragma.certification.interactions.Back;
import co.com.pragma.certification.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.SingUpPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class SignUp implements Task {
    User user;

    public SignUp(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(NAME_INPUT, isCurrentlyVisible()).forNoMoreThan(5).seconds());
        actor.attemptsTo(
                Click.on(NAME_INPUT),
                Enter.theValue(user.getName()).into(NAME_INPUT),
                Back.now(),
                Click.on(EMAIL_INPUT),
                Enter.theValue(user.getEmail()).into(EMAIL_INPUT),
                Back.now(),
                Click.on(PASSWORD_INPUT),
                Enter.theValue(user.getPassword()).into(PASSWORD_INPUT),
                Back.now(),
                Click.on(CONFIRM_YOUR_PASSWORD_INPUT),
                Enter.theValue(user.getConfirmPassword()).into(PASSWORD_INPUT),
                Back.now()
        );
        if (user.getGender().equalsIgnoreCase("F") || user.getGender().equalsIgnoreCase("M")) {
            actor.attemptsTo(
                    Click.on(GENDER_DROPDOWN),
                    Click.on(GENDER_OPTION(user.getGender()))
            );
        }
        boolean isChecked = "true".equalsIgnoreCase(TERMS_CHECK.resolveFor(actor).getAttribute("checked"));
        if (user.getTerms().equalsIgnoreCase("S") && !isChecked) {
            actor.attemptsTo(Click.on(TERMS_CHECK));
        } else if (user.getTerms().equalsIgnoreCase("N") && isChecked) {
            actor.attemptsTo(Click.on(TERMS_CHECK));
        }
        actor.attemptsTo(Click.on(SIGN_UP_BUTTON));
    }

    public static SignUp with(User user) {
        return Tasks.instrumented(SignUp.class, user);
    }
}