Feature: CASA Feature

  @tag_example1
  Scenario Outline: verify the Example 1 scenraios
    Given user is in the '<url>'
    When user paste the token in embedded text area
    Then value of 'c' is 3 in payload
    And 'Invalid Signature' is displayed under Embedded text area

    Examples: 
      | url            |
      | https://jwt.io |

@tag_example2
  Scenario Outline: verify the Example 2 scenraios
    Given user is in the '<url>'
    When user paste the token in embedded text area
    Then 'Invalid Signature' is displayed under Embedded text area

    Examples: 
      | url            |
      | https://jwt.io |
