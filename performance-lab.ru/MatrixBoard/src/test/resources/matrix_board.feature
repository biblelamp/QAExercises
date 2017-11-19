Feature: MatrixBoard test
  Scenario: negative login to MatrixBoard
    Given user navigates to 'http://at.pflb.ru/matrixboard2/'
    When he fill login field with 'user'
    And he fill password field with 'asd'
    And he click submit button
    Then he should see error message


  Scenario Outline: positive login to MatrixBoard
    Given user navigates to 'http://at.pflb.ru/matrixboard2/'
    When he fill login field with '<login>'
    And he fill password field with '<password>'
    And he click submit button
    Then he should see '<login>' in profile box
    And user logging out
    Examples:
      |login|password|
      |user |user    |
      |admin|admin   |