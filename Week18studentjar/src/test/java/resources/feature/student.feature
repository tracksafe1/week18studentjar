Feature: Testing different request on the student application

  @SMOKE
  Scenario: Check if the student application can be accessed by users
    When User sends a GET request to list endpoint
    Then User must get back a valid status code 200

  @POSITIVE
  Scenario Outline: Create a new student & verify if the student is added
    When I create a new student by providing the information firstName "<firstName>" lastName "<lastName>" email "<email>" programme "<programme>" courses "<courses>"
    And  I verify that the student with "<email>" is created
     And I update the student with information firstName "<firstName>" lastName "<lastName>" email "<email>" programme "<programme>" courses "<courses>"
     And The student with firstName "<firstName>" is updated successfully
    And I delete the student that created with firstName "<firstName>"
  Then The student deleted successfully from the application

    Examples:
      | firstName | lastName | email                 | programme        | courses |
      | shikha     | kapur  | shik11@gmail.com | Computer Science | JAVA    |
      | shikha1     | kapur1  | shi2@gmail.com | Api Testing      | Python  |


   # Scenario:update the created student and