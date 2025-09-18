package co.com.pragma.certification.tasks;

import co.com.pragma.certification.interactions.Back;
import co.com.pragma.certification.models.Character;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.CharactersPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class SearchCharacter implements Task {
    Character character;

    public SearchCharacter(Character character) {
        this.character = character;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(GENERAL_SECRET_PLACE_BUTTON, isCurrentlyVisible()).forNoMoreThan(30).seconds());
        actor.attemptsTo(
                Click.on(SEARCH_BUTTON),
                Click.on(SEARCH_INPUT),
                Enter.theValue(character.getNickName()).into(SEARCH_INPUT),
                Back.now()
        );
    }

    public static SearchCharacter with(Character character) {
        return Tasks.instrumented(SearchCharacter.class, character);
    }
}