package tests;

import Pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends TestBase {
    SearchPage searchPage = new SearchPage();
    private final String search = "java";


    @Test
    @DisplayName("Проверка сущесвтования результатов при поиске")
    void searchTest() {
        searchPage.clickFirstSearchInput()
                .sendRequestSecondSearchInput(search)
                .checkNotNullContent();
    }


    @Test
    @DisplayName("Откртие статьи")
    void openArticleTest() {
        searchPage.clickFirstSearchInput()
                .sendRequestSecondSearchInput(search)
                .clickFirstArtical()
                .errorIsDisplayed();
    }
}
