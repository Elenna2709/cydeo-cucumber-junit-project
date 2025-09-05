@dataTable
Feature: Cucumber Data Tables implementation practices


  Scenario: List of fruits and vegetables I like
    Then user should see below list
      | orange     |
      | apple      |
      | kiwi       |
      | strawberry |
      | tomato     |
      | pear       |
      | eggplant   |

    #to be beatiful the pipes above
  #Mac: command + option +L

  #CREATE  a new scenario where we list the type of pets we love
  #print out all the string in the list

  Scenario: List of pets I love
    Then user should see the list
      | cat     |
      | dog     |
      | bunny   |
      | hamster |
      | parrot  |

  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      | name    | Jane         |
      | surname | Doe          |
      | age     | 29           |
      | address | somewhere    |
      | state   | GA           |
      | zipcode | 30065        |
      | phone   | 111-111-4444 |

  Scenario: User should be able to see all 12 months in months
  dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |