package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.CharacterInformationPage.MARVEL_COMICS_CHARACTERS_TITLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TheMarvelPage implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(MARVEL_COMICS_CHARACTERS_TITLE, isCurrentlyVisible()).forNoMoreThan(30).seconds());
        return MARVEL_COMICS_CHARACTERS_TITLE.resolveFor(actor).isDisplayed();
    }


    public static TheMarvelPage isDisplayed() {
        return new TheMarvelPage();
    }
}