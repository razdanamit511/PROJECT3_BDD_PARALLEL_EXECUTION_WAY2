#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: SignIn
  I want to Sign-In into the AUT

  Background: User is on Sign-In page
   Given User is on Sign-In page

  @Smoke
  Scenario: Validate that Sign-In page title is "Customer Login"
    When User gets the page title
    Then title of the page is "Customer Login"
    
  @Smoke
  Scenario: Validate that Sign-In page form contains below elements:-
    i. Email Label
    ii. Email Textbox
    iii. Password Label
    iv. Password Textbox
    v. Forgot Password link
    vi. Create An Account button
    vii. Sign-In button
    Then Email label is displayed on sign-in page
    And Email textbox is displayed on sign-in page
    And Password label is displayed on sign-in page
    And Password textbox is displayed on sign-in page
    And Forgot Password Link is displayed
    And Create An Account button is displayed
    And Sign-In button is displayed

  Scenario Outline: Validate that user logs in successfully using valid credentials
    When User enters "<username>" in email textbox
    And User enters "<password>" in password textbox
    And User clicks Sign-In button
    Then User gets the page title
    And title of the page is "Home Page"
    Examples: 
      | username | password |
      | razdanamit51@gmail.com | Chericof1# |
      | asas2222222@gmail.com11 | Chericof1# |

  @tag2
  Scenario Outline: Validate that user is not able to login using invalid credentials
    When User enters "<username>" in email textbox
    And User enters "<password>" in password textbox
    And User clicks Sign-In button
    And User gets the page title
    Then title of the page is "Customer Login"
    Examples: 
      | username | password |
      | razdanamit1151@gmail.com | Chericof1# |
      | ushajain@gmail.com | Chericof1#11 |
