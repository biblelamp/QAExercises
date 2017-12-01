Feature: Testing market.yandex pages
  Scenario: Go to the specified section of the product catalog
    Given user opens the site 'http://yandex.ru/'
    And he goes to 'Маркет'
    And he goes to 'Компьютеры'
    And he goes to 'Ноутбуки'
    And he sets up limit of prices '30000'
    And he chooses the brand 'HP'
    And he chooses the brand 'Lenovo'
    And he clicks 'Apply'
    Then he should see '12' 'items' per page
    And he saves first items name
    And he put saved name in the search line
    And he clicks 'Search'
    Then he takes 'Name' and compares with saved
  