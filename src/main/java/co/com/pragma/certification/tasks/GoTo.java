package co.com.pragma.certification.tasks;

import co.com.pragma.certification.interactions.SwipeVertically;
import co.com.pragma.certification.models.Character;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.CharacterInformationPage.MARVEL_COMICS_CHARACTERS_BUTTON;
import static co.com.pragma.certification.userinterfaces.CharactersPage.*;
import static co.com.pragma.certification.userinterfaces.LogInPage.*;
import static co.com.pragma.certification.userinterfaces.Menu.CHARACTERS_OPTION_MENU;
import static co.com.pragma.certification.userinterfaces.Menu.PROFILE_OPTION_MENU;
import static co.com.pragma.certification.userinterfaces.ResetPasswordPage.BACK_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class GoTo {
    public static Performable forgotPasswordPage() {
        return Task.where("Click on Forgot Password button", actor -> {
            actor.attemptsTo(WaitUntil.the(LOG_IN_BUTTON, isCurrentlyVisible()).forNoMoreThan(5).seconds());
            actor.attemptsTo(Click.on(FORGOT_PASSWORD_BUTTON));
        });
    }

    public static Performable backFromResetPasswordPage() {
        return Task.where("Click on Back button of Reset Password page", actor -> {
            actor.attemptsTo(Click.on(BACK_BUTTON));
        });
    }

    public static Performable signUpPage() {
        return Task.where("Click on Sign Up button", actor -> {
            actor.attemptsTo(WaitUntil.the(LOG_IN_BUTTON, isCurrentlyVisible()).forNoMoreThan(5).seconds());
            actor.attemptsTo(Click.on(SIGN_UP_BUTTON));
        });
    }

    public static Performable charactersPage() {
        return Task.where("Click on Characters option menu", actor -> {
            actor.attemptsTo(WaitUntil.the(CHARACTERS_OPTION_MENU, isCurrentlyVisible()).forNoMoreThan(5).seconds());
            actor.attemptsTo(Click.on(CHARACTERS_OPTION_MENU));
        });
    }

    public static Performable profilePage() {
        return Task.where("Click on Profile option menu", actor -> {
            actor.attemptsTo(WaitUntil.the(PROFILE_OPTION_MENU, isCurrentlyVisible()).forNoMoreThan(10).seconds());
            actor.attemptsTo(Click.on(PROFILE_OPTION_MENU));
        });
    }

    public static Performable basicInformationPage(Character character) {
        return Task.where("Click on character card", actor -> {
            actor.attemptsTo(WaitUntil.the(CHARACTER_CARD(character.getName(), character.getNickName()), isCurrentlyVisible()).forNoMoreThan(5).seconds());
            actor.attemptsTo(Click.on(CHARACTER_CARD(character.getName(), character.getNickName())));
        });
    }

    public static Performable marvelComicsCharactersPage() {
        return Task.where("Click on View Marvel Comics Characters", actor -> {
            while (!MARVEL_COMICS_CHARACTERS_BUTTON.resolveFor(actor).isCurrentlyVisible()) {
                actor.attemptsTo(SwipeVertically.toUp());
            }
            actor.attemptsTo(Click.on(MARVEL_COMICS_CHARACTERS_BUTTON));
        });
    }

    public static Performable location() {
        return Task.where("Click on Secret Place", actor -> {
            if (SECRET_PLACE_BUTTON.resolveFor(actor).isVisible()) {
                actor.attemptsTo(Click.on(SECRET_PLACE_BUTTON));
            } else if (VIEW_DETAILS_BUTTON.resolveFor(actor).isVisible()) {
                actor.attemptsTo(Click.on(VIEW_DETAILS_BUTTON));
            } else {
                throw new AssertionError("Neither Secret Place nor View Details button was visible.");
            }
        });
    }
}
