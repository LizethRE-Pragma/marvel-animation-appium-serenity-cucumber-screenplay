package co.com.pragma.certification.tasks;

import co.com.pragma.certification.interactions.ZoomOnElement;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static co.com.pragma.certification.userinterfaces.CharacterInformationPage.MAP_VIEW;

public class Map {
    public static Performable zoomIn() {
        return Task.where("Zoom In", actor -> {
            actor.attemptsTo(ZoomOnElement.in(MAP_VIEW));
            actor.attemptsTo(ZoomOnElement.in(MAP_VIEW));
            actor.attemptsTo(ZoomOnElement.in(MAP_VIEW));
        });
    }

    public static Performable zoomOut() {
        return Task.where("Zoom Out", actor -> {
            actor.attemptsTo(ZoomOnElement.out(MAP_VIEW));
            actor.attemptsTo(ZoomOnElement.out(MAP_VIEW));
            actor.attemptsTo(ZoomOnElement.out(MAP_VIEW));
        });
    }
}
