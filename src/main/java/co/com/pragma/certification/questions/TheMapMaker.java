package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.CharacterInformationPage.MAP_MARKER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TheMapMaker implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(MAP_MARKER, isCurrentlyVisible()).forNoMoreThan(15).seconds());
        return MAP_MARKER.resolveFor(actor).isDisplayed();
    }


    public static TheMapMaker isDisplayed() {
        return new TheMapMaker();
    }
}