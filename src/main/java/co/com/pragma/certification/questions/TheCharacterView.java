package co.com.pragma.certification.questions;

import co.com.pragma.certification.models.Character;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.CharactersPage.CHARACTER_VIEW;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TheCharacterView implements Question<Boolean> {
    Character character;

    public TheCharacterView(Character character) {
        this.character = character;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(CHARACTER_VIEW(character.getNickName()), isCurrentlyVisible()).forNoMoreThan(10).seconds());
        return CHARACTER_VIEW(character.getNickName()).resolveFor(actor).isDisplayed();
    }


    public static TheCharacterView isDisplayed(Character character) {
        return new TheCharacterView(character);
    }
}