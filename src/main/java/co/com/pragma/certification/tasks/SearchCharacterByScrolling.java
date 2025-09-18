package co.com.pragma.certification.tasks;

import co.com.pragma.certification.interactions.SwipeVertically;
import co.com.pragma.certification.models.Character;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.CharactersPage.CHARACTER_CARD;
import static co.com.pragma.certification.userinterfaces.CharactersPage.GENERAL_SECRET_PLACE_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class SearchCharacterByScrolling implements Task {
    Character character;

    public SearchCharacterByScrolling(Character character) {
        this.character = character;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(GENERAL_SECRET_PLACE_BUTTON, isCurrentlyVisible()).forNoMoreThan(30).seconds());
        while (!CHARACTER_CARD(character.getName(), character.getNickName()).resolveFor(actor).isCurrentlyVisible()) {
            actor.attemptsTo(SwipeVertically.toUp());
        }
    }

    public static SearchCharacterByScrolling with(Character character) {
        return Tasks.instrumented(SearchCharacterByScrolling.class, character);
    }
}