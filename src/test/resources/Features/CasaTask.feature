Feature: CASA Feature

  @tag_example1
  Scenario Outline: verify the value of 'c' in payload and invalid signature is displayed when 'token' is passed
    Given user is in the '<url>'
    When user enter the 'token' 
    Then value of 'c' is 3 in payload
    And 'Invalid Signature' is displayed under Embedded text area

    Examples: 
      | url            |
      | https://jwt.io |

@tag_example2
  Scenario Outline: verify the Example 2 scenraios
    Given user is in the '<url>'
   When user enter the 'token'
    Then 'Invalid Signature' is displayed under Embedded text area
    When user enter the 'secret'
    Then The Secret Key signature is 'Valid secret'
    And 'Signature Verified' is displayed under Embedded text area
    And Token remains same
    And value of 'c' is 3 in payload
    When user modify the secret
    Then token changed in Embedded text area
    And payload remains same

    Examples: 
      | url            |
      | https://jwt.io |
