package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    //This method will accept int (in seconds) and execute Thread.sleep for given duration

    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }
    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(String exceptedInUrl, String expectedInTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles ) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL : " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(exceptedInUrl)){
                break;
            }
        }
        //5. Assert: Title contains "expectedInTitle"
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    //This method accepts a String "expectedTitle" and Asserts if it is true

    public static void verifyTitle(String exceptedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),exceptedTitle);
    }

    /**
     * This method will accept a String as expected value and verify actual URL contains the value
     * @param exceptedInURL
     */
    public static void verifyURLContains(String exceptedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(exceptedInURL));
    }

    /**
     * This method will aceept a dropdown as a WebElement and return all of the options' text in a List of String
     * @param dropdownElement
     * @return List<String>
     */
    public static List<String> dropdownsOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement eachElement : actualOptionsAsWebElement) {
            actualOptionsAsString.add(eachElement.getText());
        }
        return actualOptionsAsString;
    }


    /**
     * This method will accpet a group radio buttons as a List of WebElement
     * It will loop through the list, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){
        for (WebElement eachCard : radioButtons) {
            if (eachCard.getAttribute("value").equalsIgnoreCase(attributeValue)){
                eachCard.click();
            }
        }
    }

}
