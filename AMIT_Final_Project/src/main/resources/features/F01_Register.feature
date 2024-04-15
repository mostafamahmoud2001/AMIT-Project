@smoke
Feature:
Scenario Outline:  guest user could register with valid data successfully
  Given user go to register page
  When  user select gender type <genderType>
  And   user enter first name <firstName> and last name <lastName>
  And   user enter date of birth
  And   user enter email  field <email>
  And   user fills Password fields <password> <confirmPassword>
  And   user clicks on register button
  Then  success message is displayed
  Examples:
    | genderType | firstName | lastName | email | password |confirmPassword|
    | Male | automation | tester | test@example.com | P@ssw0rd | P@ssw0rd  |

