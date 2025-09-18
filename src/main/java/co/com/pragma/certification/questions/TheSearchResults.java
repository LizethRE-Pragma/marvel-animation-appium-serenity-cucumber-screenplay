package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.CharactersPage.SEARCH_RESULTS_TEXT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TheSearchResults implements Question<Boolean> {
    String characterName;
    int number;

    public TheSearchResults(String characterName, int number) {
        this.characterName = characterName;
        this.number = number;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(SEARCH_RESULTS_TEXT(characterName, number), isCurrentlyVisible()).forNoMoreThan(5).seconds());
        return SEARCH_RESULTS_TEXT(characterName, number).resolveFor(actor).isDisplayed();
    }


    public static TheSearchResults isDisplayed(String characterName, int number) {
        return new TheSearchResults(characterName, number);
    }
}