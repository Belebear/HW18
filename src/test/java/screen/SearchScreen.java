package screen;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.appium.java_client.MobileBy.AccessibilityId;

public class SearchScreen {

    private final SelenideElement firstSearchInput = $(AccessibilityId("Search Wikipedia"));
    private final SelenideElement secondSearchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection article = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private final SelenideElement articleError = $(id("org.wikipedia.alpha:id/page_error"));


    @Step("Клик на первую поисковую строку")
    public SearchScreen clickFirstSearchInput() {
        firstSearchInput.click();
        return this;
    }

    @Step("Ввод запроса в поисковую строку")
    public SearchScreen sendRequestSecondSearchInput(String request) {
        secondSearchInput.sendKeys(request);
        return this;
    }

    @Step("Проверка результатов")
    public SearchScreen checkNotNullContent() {
        article.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Переход по найденой статье")
    public SearchScreen clickFirstArtical() {
        article.first().click();
        return this;
    }

    @Step("Отображение ошибки при переходе в статью")
    public SearchScreen errorIsDisplayed() {
        articleError.shouldBe(visible);
        return this;
    }
}