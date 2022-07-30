Feature: Amazon Home Page

  @demo
  Scenario: Verify the brand filter
   Given The Home page is visible
   Then Verify the url is as expected
   When Select any category from the header
   When Select any brand from brand filter
   Then Verify the options are displayed according the the filter

  @test
  Scenario: Test scenario in test leaf
    When I go to test leaf button url
    Then I validate if I am on the right page
    When I click on goto home page
    Then i validate I am redirected to home page

  @githubtest
  Scenario: Verify login functionalt on GitHub login page
    Given I go to GitHub page url
    Then I verify the homepage visible
    Then I verify SignIn element is visible
    When I click on SignIn
    Then I Verify the actual and expected urls are same
    When I pass data into email field
    Then I pass data in password field
    Then I click on SignIn button
    
    
   @amazontest
  Scenario: Verify product add to cart functionality in amazon website
    Given Go to Amazon page url
    Then Verify the url is same as expected 
 		When Enter data in search box
 		And  Click on search button
 		#Then Verify the options are displayed according to the filter
 		And  Scroll down till Apple iPhone 13 Pro, 128GB, Graphite 
 		When Select the iphone 
 		Then Verify add to cart button is visible
 		And Click on add to cart button
 		When Click on No Thanks button
    And Close browser
    
    @Biskanetest
    Scenario: Verify Dashboard page on Biskane
     Given User go to Biskane page url
     When User enter data into email field
     And User enter data into password field
     When User click on SignIn
     Then Verify Dashboard page
     And Click on logs out button
    
    @BiskanetestLogin
    Scenario: Verify shop page on Biskane 
     Given User go to Biskane page url
     When User enter data into email field
     And User enter data into password field
     When User click on SignIn
     Then Verify Dashboard page 
     When User click on Home
     And click on Shop now
     Then Verify shop page
     When Counts number of elements in the categories
     And Click on logs out button
     
     @SwitchUser
     Scenario: Switch user functionality on Biskane page
     Given User go to Biskane page url
     When User enter data into email field
     And User enter data into password field
     When User click on SignIn
     Then Verify Dashboard page
     When Click on switch user
     And Select on Artist from switch user
     When Click on Yes button
     Then Verify Artist page
     And Click on logs out button
     
     @BiskaneTestMyCollection
     Scenario: Verify my collection on 
     Given User go to Biskane page url
     When User enter data into email field
     And User enter data into artist password field
     When User click on SignIn
     Then Verify Dashboard page
     When User go to collection
     And User click collection Edit button
     When User edit product title edit box
     And User go to Product Category drop down and select
     And Click on Artist pagelogs out button
          