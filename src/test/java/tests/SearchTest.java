package tests;

import screen.SearchScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends TestBase {
    SearchScreen searchScreen = new SearchScreen();
    private final String search = "java";


    @Test
    @DisplayName("Проверка сущесвтования результатов при поиске")
    void searchTest() {
        searchScreen.clickFirstSearchInput()
                .sendRequestSecondSearchInput(search)
                .checkNotNullContent();
    }


    @Test
    @DisplayName("Откртие статьи")
    void openArticleTest() {
        searchScreen.clickFirstSearchInput()
                .sendRequestSecondSearchInput(search)
                .clickFirstArtical()
                .errorIsDisplayed();
    }
}
