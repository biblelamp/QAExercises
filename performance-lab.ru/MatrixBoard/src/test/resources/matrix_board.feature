Feature: MatrixBoard test
  Scenario: negative login to MatrixBoard
    Given user navigates to 'http://at.pflb.ru/matrixboard2/'
    When he fill login field with 'user'
    And he fill password field with 'asd'
    And he click submit button
    Then he should see error message


  Scenario: positive login to MatrixBoard
    Given user navigates to 'http://at.pflb.ru/matrixboard2/'
    When he fill login field with 'user'
    And he fill password field with 'user'
    And he click submit button
    Then he should see 'user' in profile box