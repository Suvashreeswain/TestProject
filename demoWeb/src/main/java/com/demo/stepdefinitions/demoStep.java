package com.demo.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.interactions.SendKeysAction;

import com.demo.pages.demoPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class demoStep extends StepDefinitionInit {

	@Given("^The Home page is visible$")
	public void the_Home_page_is_visible() throws Throwable {

		Assert.assertTrue(demopage.isHomePageVisible());

	}

	@Then("^Verify the url is as expected$")
	public void verify_the_url_is_as_expected() throws Throwable {
		Assert.assertTrue(demopage.isUrlCorrect());

	}


	@When("^Select any category from the header$")
	public void select_any_category_from_the_header() throws Throwable {
		demopage.selectCategory();

	}

	@When("^Select any brand from brand filter$")
	public void select_any_brand_from_brand_filter() throws Throwable {
		demopage.selectBrand();
	}

	@Then("^Verify the options are displayed according the the filter$")
	public void verify_the_options_are_displayed_according_the_the_filter() throws Throwable {

		Assert.assertTrue(demopage.areOptionsAccordingToFilterSet());

	}



	//------------Below steps are for test leaf scenario-------------------------//


	@When("^I go to test leaf button url$")
	public void i_go_to_test_leaf_button_url() throws Throwable {
		demopage.gotoButtonURL(); 

	}

	@When("^I click on goto home page$")
	public void i_click_on_goto_home_page() throws Throwable {
		demopage.clickHomePageButton(); 
	}

	@Then("^I validate if I am on the right page$")
	public void i_validate_if_i_am_on_the_right_page() throws Throwable {
		Assert.assertTrue(demopage.validateurl()); 
	}

	@Then("^i validate I am redirected to home page$")
	public void i_validate_i_am_redirected_to_home_page() throws Throwable {
		Assert.assertTrue(demopage.validateRedierction()); 
	}








	//------------Below steps are for GitHub login page scenario-------------------------//

	@Given("^I go to GitHub page url$")
	public void i_go_to_github_page_url() throws Throwable {
		demopage.gotoHomePageURL();
	}

	@When("^I click on SignIn$")
	public void i_click_on_signin() throws Throwable {
		demopage.clickOnSignIn();
	}

	@When("^I pass data into email field$")
	public void i_pass_data_into_email_field() throws Throwable {
		demopage.emailField();
	}

	@Then("^I verify the homepage visible$")
	public void i_verify_the_homepage_visible() throws Throwable {
		Assert.assertTrue(demopage.HomepageVisible());
	}

	@Then("^I verify SignIn element is visible$")
	public void i_verify_signin_element_is_visible() throws Throwable {
		Assert.assertTrue(demopage.signinVisible());
	}

	@Then("^I Verify the actual and expected urls are same$")
	public void i_verify_the_actual_and_expected_urls_are_same() throws Throwable {
		Assert.assertTrue(demopage.validateGitHubUrl());
	}

	@Then("^I pass data in password field$")
	public void i_pass_data_in_password_field() throws Throwable {
		demopage.passwordField();
	}

	@Then("^I click on SignIn button$")
	public void i_click_on_signin_button() throws Throwable {
		demopage.clickonSigninButton();
	}
	
	//------------Below steps are for Amazon product Add to cart scenario-------------------------//
	
	@Given("^Go to Amazon page url$")
    public void go_to_amazon_page_url() throws Throwable {
        demopage.goToAmazonHomePage();
    }

    @When("^Enter data in search box$")
    public void enter_data_in_search_box() throws Throwable {
        demopage.enterData();
    }

    @When("^Select the iphone$")
    public void select_the_iphone() throws Throwable {
        demopage.selectIphone();
    }

    @When("^Click on No Thanks button$")
    public void click_on_no_thanks_button() throws Throwable {
        demopage.noThanksButton();
    }

    @Then("^Verify the url is same as expected$")
    public void verify_the_url_is_same_as_expected() throws Throwable {
       Assert.assertTrue(demopage.validateAmazonUrl());
    }

    @Then("^Verify the options are displayed according to the filter$")
    public void verify_the_options_are_displayed_according_to_the_filter() throws Throwable {
        Assert.assertTrue(demopage.optionsDisplayed());
    }

    @Then("^Verify add to cart button is visible$")
    public void verify_add_to_cart_button_is_visible() throws Throwable {
    	Assert.assertTrue(demopage.addToCartDisplayed());
    }

    @Then("^Verify the product is in add to cart$")
    public void verify_the_product_is_in_add_to_cart() throws Throwable {
    	Assert.assertTrue(demopage.productInCart());
    }

    @And("^Click on search button$")
    public void click_on_search_button() throws Throwable {
        demopage.clickOnSearch();
    }

    @And("^Scroll down till Apple iPhone 13 Pro, 128GB, Graphite$")
    public void scroll_down_till_apple_iphone_13_pro_128gb_graphite() throws Throwable {
    	demopage.scrollDown();
    }

    @And("^Click on add to cart button$")
    public void click_on_add_to_cart_button() throws Throwable {
        demopage.clickOnAddToCart();
    }

    @And("^Close browser$")
    public void close_browser() throws Throwable {
        demopage.closeBrowser();
    }


//------------Below steps are for Verify login functionality on Biskane login page scenario-------------------------//

@Given("^User go to Biskane page url$")
public void user_go_to_biskane_page_url() throws Throwable {
    demopage.biskanePageURL();
}

@When("^User enter data into email field$")
public void user_enter_data_into_email_field() throws Throwable {
    demopage.loginEmail();
}

@When("^User click on SignIn$")
public void user_click_on_signin() throws Throwable {
    demopage.clickHomepageSignin();
}
@When("^Change profile picture$")
public void change_profile_picture() throws Throwable {
    demopage.ChangeProfilePic();
}
@Then("^Verify Dashboard page$")
public void verify_dashboard_page() throws Throwable {
	 Assert.assertTrue(demopage.validateDashboard());
}

@And("^User enter data into password field$")
public void user_enter_data_into_password_field() throws Throwable {
    demopage.loginPassword();
}

@And("^Click on logs out button$")
public void click_on_logs_out_button() throws Throwable {
    demopage.logoutButton();
}
@When("^User click on Home$")
public void user_click_on_home() throws Throwable {
    demopage.clickHome();
}

@When("^Counts number of elements in the categories$")
public void counts_number_of_elements_in_the_categories() throws Throwable {
    demopage.numberOfElements();
}

@Then("^Verify shop page$")
public void verify_shop_page() throws Throwable {
	Assert.assertTrue(demopage.verifyShopPage());
}

@And("^click on Shop now$")
public void click_on_shop_now() throws Throwable {
    demopage.clickShopNow();
}
@When("^Click on switch user$")
public void click_on_switch_user() throws Throwable {
    demopage.clickOnSwitchUser();
}

@When("^Click on Yes button$")
public void click_on_yes_button() throws Throwable {
    demopage.clickOnYesButton();
}

@Then("^Verify Artist page$")
public void verify_artist_page() throws Throwable {
	Assert.assertTrue(demopage.validateArtistPage());
}

@And("^Select on Artist from switch user$")
public void select_on_artist_from_switch_user() throws Throwable {
    demopage.selectArtist();
}

@When("^User go to collection$")
public void user_go_to_collection() throws Throwable {
    demopage.collection();
}

@And("^User enter data into artist password field$")
public void user_enter_data_into_artist_password_field() throws Throwable {
    demopage.artistPassword();
}
    
@When("^User edit product title edit box$")
public void user_edit_product_title_edit_box() throws Throwable {
    demopage.editProductTitleBox();
}

@And("^User click collection Edit button$")
public void user_click_collection_edit_button() throws Throwable {
	demopage.collectionButton();
	
}
@And("^User go to Product Category drop down and select$")
public void user_go_to_product_category_drop_down_and_select() throws Throwable {
    demopage.productCategory();
}
@And("^Click on Artist pagelogs out button$")
public void click_on_artist_pagelogs_out_button() throws Throwable {
    demopage.artistPageLogout();
}
@When("^Click on submit button$")
public void click_on_submit_button() throws Throwable {
    demopage.submit();
}

@Then("^Verify product title is changed$")
public void verify_product_title_is_changed() throws Throwable {
	Assert.assertTrue(demopage.productTitle());
}
@And("^Delete a collection and click on delete button$")
public void delete_a_collection_and_click_on_delete_button() throws Throwable {
    demopage.deleteCollection();

}
@When("^Click on Art button$")
public void click_on_art_button() throws Throwable {
	demopage.artButton();
}

@When("^Click on DashBoard button$")
public void click_on_dashboard_button() throws Throwable {
    demopage.dashBoard();
}
@When("^Click on added to cart button$")
public void click_on_added_to_cart_button() throws Throwable {
    demopage.addedToCartButton();
}
@Then("^Verify item added to cart$")
public void verify_item_added_to_cart() throws Throwable {
	Assert.assertTrue(demopage.addedToCart());
}

@And("^Click on buy now button$")
public void click_on_buy_now_button() throws Throwable {
    demopage.buyNowButton();
}
@And("^Scroll down till Add to cart button is visible$")
public void scroll_down_till_add_to_cart_button_is_visible() throws Throwable {
    demopage.addToCartButtonVisible();
}
@When("^User click on orders$")
public void user_click_on_orders() throws Throwable {
    demopage.clickOnOrder();
}

@When("^Click on select from drop down$")
public void click_on_select_from_drop_down() throws Throwable {
    demopage.clickOnSelect();
}

@When("^Click on Go button$")
public void click_on_go_button() throws Throwable {
    demopage.clickOnGo();
}

@And("^User click on select search type$")
public void user_click_on_select_search_type() throws Throwable {
    demopage.clickSelectType();
}

@And("^Click on Ok button$")
public void click_on_ok_button() throws Throwable {
    demopage.clickOnOkButton();
}
@When("^Click on refunds button$")
public void click_on_refunds_button() throws Throwable {
    demopage.ClickRefund();
}

@When("^Click on refund pending action button$")
public void click_on_refund_pending_action_button() throws Throwable {
 
    demopage.actionButton();
}

@When("^Enter text to comment box$")
public void enter_text_to_comment_box() throws Throwable {
    demopage.commentBox();
}

@Then("^Verify refund status$")
public void verify_refund_status() throws Throwable {
	Assert.assertTrue(demopage.refundStatus());
}

@And("^Click on next page button$")
public void click_on_next_page_button() throws Throwable {
    demopage.nextPageButton();
}

@And("^Add QTY No of item to refund$")
public void add_qty_no_of_item_to_refund() throws Throwable {
    demopage.clickQTYbutton();
}

@And("^Click on Approve button$")
public void click_on_approve_button() throws Throwable {
    demopage.clickApprove();
}
@When("^User click on my shop button$")
public void user_click_on_my_shop_button() throws Throwable {
    demopage.myShopButton();
}

@When("^Click on add new collection button$")
public void click_on_add_new_collection_button() throws Throwable {
    demopage.addCollectionButton();
}

@When("^Click on new collection submit button$")
public void click_on_new_collection_submit_button() throws Throwable {
    demopage.collectionSubmitButton();
}

@Then("^Verify my shop page$")
public void verify_my_shop_page() throws Throwable {
	Assert.assertTrue(demopage.shoppage());
}

@And("^User enter password$")
public void user_enter_password() throws Throwable {
    demopage.storePassword();
}

@And("^Click on my collection button$")
public void click_on_my_collection_button() throws Throwable {
	demopage.newCollectionButton();
}

@And("^Add all the product details$")
public void add_all_the_product_details() throws Throwable {
    demopage.productDetails();    
}
@When("^Add product title$")
public void add_product_title() throws Throwable {
    demopage.productTit();
}

@When("^Add product Description$")
public void add_product_description() throws Throwable {
    demopage.productDescription();
}

@When("^Click on update price button$")
public void click_on_update_price_button() throws Throwable {
    demopage.updatePriceButton();
}

@When("^Select option from weight type$")
public void select_option_from_weight_type() throws Throwable {
    demopage.weightType();
}

@When("^Add PreOrder days$")
public void add_preorder_days() throws Throwable {
   demopage.PreOrderdays();
}
@And("^Click on Art type radio button$")
public void click_on_art_type_radio_button() throws Throwable {
    demopage.artTypeRadioButton();
}
@And("^Select Art from product category$")
public void select_art_from_product_category() throws Throwable {
    demopage.artProductCategory();
}

@And("^Add cost of the item$")
public void add_cost_of_the_item() throws Throwable {
    demopage.addCostOfItem();
}

@And("^Add Maximum no of items per parcel$")
public void add_maximum_no_of_items_per_parcel() throws Throwable {
    demopage.maxItem();
}

@And("^Select approx weight box$")
public void select_approx_weight_box() throws Throwable {
    demopage.selectWeight();
}

@And("^Add Quantity in quantity box$")
public void add_quantity_in_quantity_box() throws Throwable {
    demopage.quantity();
}

@And("^Add Length and Width and Height of the item$")
public void add_length_and_width_and_height_of_the_item() throws Throwable {
    demopage.productSize();
}
@And("^Click on shop page logs out button$")
public void click_on_shop_page_logs_out_button() throws Throwable {
    demopage.shopPageLogout();
}
@And("^Click on image submit button$")
public void click_on_image_submit_button() throws Throwable {
    demopage.imageSubmit();
}
}













