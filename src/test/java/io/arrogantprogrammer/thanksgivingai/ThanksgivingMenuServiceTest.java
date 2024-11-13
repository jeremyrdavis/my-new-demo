package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateMenuCommand;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenu;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ThanksgivingMenuServiceTest {

    @Inject
    MenuService menuService;

    @Test
    public void testCreateMenu() {

        ThanksgivingMenu thanksgivingMenu = menuService.createMenu(new CreateMenuCommand("shrek@duloc.org", Collections.emptyList()));
        assertNotNull(thanksgivingMenu);
        assertTrue(thanksgivingMenu.email().equals("shrek@duloc.org"));
        assertTrue(thanksgivingMenu.stateCodes().isEmpty());
        assertTrue(thanksgivingMenu.mains().size() >= 1);
        assertTrue(thanksgivingMenu.sides().size() >= 2);
        assertTrue(thanksgivingMenu.desserts().size() >= 1);

    }
}
