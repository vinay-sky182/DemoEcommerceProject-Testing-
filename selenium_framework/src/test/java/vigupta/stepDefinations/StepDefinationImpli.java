package vigupta.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vigupta.pageobjects.CartPage;
import vigupta.pageobjects.CheckoutPage;
import vigupta.pageobjects.ConfirmationPage;
import vigupta.pageobjects.LandingPage;
import vigupta.pageobjects.ProductCatalouge;
import vigupta.testComponents.BaseTest;

public class StepDefinationImpli extends BaseTest
{
    public LandingPage Lpage;
    public ProductCatalouge PC;
    public ConfirmationPage cnfPage;
    String countryName = "FINLAND";

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException
    {
        Lpage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password (String uName, String uPass)
    {
       PC = Lpage.loginApplication(uName, uPass);
    }

    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException
    {
      	List<WebElement> products = PC.getProductList();
		PC.addProductToCart(productName);
    }

    @And("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String ProductName)
    {
        CartPage cp = PC.goToCartPage();
		Boolean match = cp.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checkOP = cp.goToCheckout();
		checkOP.selectCountry("fiNLanD");
        List<WebElement> country1 = checkOP.getCountryList();
		checkOP.selectCountryName(countryName);
		cnfPage = checkOP.submitOrder();		
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String message)
    {
        String confirmMsgString = cnfPage.getConfirmationMessage();
		Assert.assertTrue(confirmMsgString.equalsIgnoreCase(message));
        tearDown();
    }

    @Then("{string} error message is displayed")
    public void error_message_is_displayed(String errorMessage)
    {
        Assert.assertEquals(errorMessage, Lpage.getErrorMessage());
        tearDown();	
    }
    
}

// tidy gerkin :- it is a chrome plugin to genrate the 'Steps'
//  Regex "^\"([^\"]*)\" we can use this instead of {string}