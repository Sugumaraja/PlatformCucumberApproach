Feature:Testing the loginpage releavant workflow.
  Background:
  Given while i am in the login page

    Scenario: To validate the login with valid credentials.
      And enter the valid email id "sugumarraja@blueehr.com"
      And enter the valid password "Qwert@1234"
      And click on the login button
      Then user should able to login the platform

