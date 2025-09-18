package co.com.pragma.certification.stepdefinitions;

import co.com.pragma.certification.models.Character;
import co.com.pragma.certification.questions.*;
import co.com.pragma.certification.tasks.GoTo;
import co.com.pragma.certification.tasks.Map;
import co.com.pragma.certification.tasks.SearchCharacter;
import co.com.pragma.certification.tasks.SearchCharacterByScrolling;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CharatersStepDefinitions {
    @Cuando("busca el personaje por {string}")
    public void buscaElPersonaje(String nickname) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchCharacter.with(Character.builder()
                .nickName(nickname)
                .build()
        ));
    }

    @Entonces("deberia ver el resultado de la busqueda {string} {int}")
    public void deberiaVerLaAlertaConElMensaje(String characterName, int number) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheSearchResults.isDisplayed(characterName, number)));
    }

    @Cuando("busca el personaje por {string} y {string} desplazandose")
    public void buscaElPersonajeDesplazandose(String name, String nickname) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchCharacterByScrolling.with(Character.builder()
                .name(name)
                .nickName(nickname)
                .build()
        ));
    }

    @Entonces("deberia ver la tarjeta del personaje {string} y {string}")
    public void deberiaVerLaTarjetaDelPersonaje(String name, String nickname) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheCharacterCard.isDisplayed(Character.builder()
                .name(name)
                .nickName(nickname)
                .build()
        )));
    }

    @Cuando("va a la informacion del personaje {string} y {string}")
    public void vaALaInformacionDelPersonaje(String name, String nickname) {
        OnStage.theActorInTheSpotlight().attemptsTo(GoTo.basicInformationPage(Character.builder()
                .name(name)
                .nickName(nickname)
                .build()
        ));
    }

    @Entonces("deberia ver el detalle del personaje {string}")
    public void deberiaVerElDetalleDelPersonaje(String nickname) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheCharacterView.isDisplayed(Character.builder()
                .nickName(nickname)
                .build()
        )));
    }

    @Dado("que se encuentra en la pagina de Informacion del personaje {string} y {string}")
    public void queSeEncuentraEnLaPaginaDeInformacionDelPersonaje(String name, String nickname) {
        buscaElPersonaje(nickname);
        vaALaInformacionDelPersonaje(name, nickname);
        deberiaVerElDetalleDelPersonaje(nickname);
    }

    @Cuando("va a la pagina de Marvel Comics Characters")
    public void vaALaPaginaDeMarvelComicsCharacters() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoTo.marvelComicsCharactersPage());
    }

    @Entonces("deberia ver la pagina externa de Marvel")
    public void deberiaVerLaPaginaExternaDeMarvel() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheMarvelPage.isDisplayed()));
    }

    @Cuando("va a la ubicacion del personaje")
    public void vaALaUbicacionDelPersonaje() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoTo.location());

    }

    @Entonces("deberia ver la marca en el mapa")
    public void deberiaVerLaMarcaEnElMapa() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheMapMaker.isDisplayed()));
    }

    @Dado("que se encuentra en el mapa del personaje {string}")
    public void queSeEncuentraEnElMapa(String nickname) {
        buscaElPersonaje(nickname);
        vaALaUbicacionDelPersonaje();
        deberiaVerLaMarcaEnElMapa();
    }

    @Cuando("se aleja de la ubicacion")
    public void seAlejaDeLaUbicacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(Map.zoomOut());
    }
}
