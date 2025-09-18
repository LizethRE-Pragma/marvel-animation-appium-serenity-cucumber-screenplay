package co.com.pragma.certification.questions;

import co.com.pragma.certification.models.Character;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.pragma.certification.userinterfaces.CharactersPage.CHARACTER_CARD;

public class TheCharacterCard implements Question<Boolean> {
    Character character;

    public TheCharacterCard(Character character) {
        this.character = character;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CHARACTER_CARD(character.getName(), character.getNickName()).resolveFor(actor).isDisplayed();
    }


    public static TheCharacterCard isDisplayed(Character character) {
        return new TheCharacterCard(character);
    }
}