Feature: Verify Brikroy icon work properly

  #T1
  @Release
  Scenario: Verify Bikroy logo work properly
    Given User Click on Bikroy logo
#    Then User return to home page

# T2
  @Release
  Scenario: Product Display
    Given Check Mobiles button is available in Category item section
    When Click on Mobiles button
    Then Check Mobile page is Displayed
    And Check Select Location button is available
    When Click Select Location button
    Then Check a Popup window displayed
    And Check Dhaka is available in Cities category
    When Click on Dhaka city
    Then Check Popular areas in Dhaka city are available
    When Click Mirpur area
    Then Check that all mobiles in Mirpur area are displayed
    When Click on a mobile top in the list


    #T3
