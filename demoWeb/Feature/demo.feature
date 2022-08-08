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
     #Then Verify Dashboard page
     When Change profile picture
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
     When Click on submit button
     Then Verify product title is changed
     And Delete a collection and click on delete button
     And Click on Artist pagelogs out button
     
     @BiskaneShopPage
     Scenario: Test scenario in BiskaneShopPage
     Given User go to Biskane page url
     When User enter data into email field
     And User enter data into artist password field
     When User click on SignIn
     Then Verify Dashboard page
     When User click on Home
     Then Verify shop page
     And click on Shop now
     When Click on Art button
     And Click on buy now button
     And Scroll down till Add to cart button is visible
     When Click on added to cart button
     Then Verify item added to cart
     When Click on DashBoard button	
     And Click on Artist pagelogs out button
     
     @BiskaneOrdersAndShippedItems 
     Scenario: Test scenario in BiskaneShopPage
     Given User go to Biskane page url
     When User enter data into email field
     And User enter data into artist password field
     When User click on SignIn
     Then Verify Dashboard page
     When User click on orders
     And User click on select search type
     When Click on select from drop down
     #And Click on Ok button
     When Click on Go button
     And Click on Artist pagelogs out button
     
     @BiskaneRefunds
     Scenario: Test scenario in BiskaneShopPage
     Given User go to Biskane page url
     When User enter data into email field
     And User enter data into artist password field
     When User click on SignIn
     Then Verify Dashboard page
     When Click on refunds button
     Then Verify refund status
     And Click on next page button
     When Click on refund pending action button
     And Add QTY No of item to refund 
     When Enter text to comment box
     And Click on Approve button
     #And Click on Artist pagelogs out button
     
     @BiskaneStorePage
     Scenario: Test scenario in BiskaneStorePage
     Given User go to Biskane page url
     When User enter data into email field
     And User enter password 
     When User click on SignIn
     Then Verify Dashboard page
     When User click on my shop button
     Then Verify my shop page
     And Click on my collection button
     When Click on add new collection button
     And Add all the product details
     #And Click on image submit button
     When Add product title
     And Select Art from product category
     When Add product Description
     And Add cost of the item
     When Click on update price button
     And Add Maximum no of items per parcel
     And Select approx weight box
     When Select option from weight type
     And Add Quantity in quantity box
     When Add PreOrder days
     And Click on Art type radio button
     And Add Length and Width and Height of the item
     When Click on new collection submit button
     And Click on shop page logs out button
      