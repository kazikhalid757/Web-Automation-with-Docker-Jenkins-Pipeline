Feature: Verify Brikroy icon work properly

  #T1
  @Release
  Scenario: Verify Bikroy logo work properly
    Given User Click on Bikroy logo

# T2
  @Release
  Scenario:Verify that All Ads Option show Properly
  Given Check that All Ads Option show Properly
  When  Click that All Ads Option


  # T3
  @Release
  Scenario: Verify that Chat button show Properly
    Given Check that chat button show Properly
    When  Click that chat button



    # T4
  @Release
  Scenario:Verify that Login button show Properly
    Given Check that login button show Properly
    When  Click that login button




    # T5
  @Release
  Scenario:Verify that POST YOUR AD button show Properly
    Given Check that Post your ad button show Properly
    When  Click that Post your ad button



    # T6
  @Release
  Scenario: Verify that Search bar show Properly
    Given Check that search bar show Properly
    When  Click that search bar



    # T7
  @Release
  Scenario: Verify that Search option work Properly
    Given Check that search bar show Properly
    When  Click that search bar
    And   Enter a search keyword
    And   Click search icon



    # T8
  @Release
  Scenario:Verify that Language button show Properly
    Given Check that language button show Properly
    When  Click that language button





    # T9
  @Release
  Scenario:Verify that Location button show Properly
    Given Check that location button show Properly
    When  Click that location button




   # T10
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













