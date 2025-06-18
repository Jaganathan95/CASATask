Feature: CASA Feature

  Scenario Outline: 
    :

    Given user is in the '<url>'
    When user paste the token in embedded text area
    Then value of '<c>' is 3 in payload
    And 'Invalid Signature' is displayed under Embedded text area

    Examples: 
      | url            | c |
      | https://jwt.io | 3 |
