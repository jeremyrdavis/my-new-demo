package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateMenuCommand;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenu;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenuItem;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MenuService {

    public ThanksgivingMenu createMenu(CreateMenuCommand createMenuCommand) {

        return new ThanksgivingMenu(createMenuCommand.email(), createMenuCommand.stateCodes(), mockMains(), mockSides(), mockDesserts());
    }

    private List<ThanksgivingMenuItem> mockDesserts() {
        return List.of(
                new ThanksgivingMenuItem("Pumpkin Pie", "Traditional")
        );
    }

    private List<ThanksgivingMenuItem> mockSides() {
        return List.of(
                new ThanksgivingMenuItem("Mashed Potatoes", "Garlic"),
                new ThanksgivingMenuItem("Green Beans", "Almondine"),
                new ThanksgivingMenuItem("Macaroni and Cheese", "Baked")
        );
    }

    private List<ThanksgivingMenuItem> mockMains() {
        return List.of(
                new ThanksgivingMenuItem("Turkey", "Roasted"),
                new ThanksgivingMenuItem("Ham", "Honey Baked")
        );
    }
}
