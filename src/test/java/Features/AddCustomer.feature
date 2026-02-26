Feature: Add new customer

  Scenario Outline: Add Customer using mandatory fields

    Given User login with username <username> and password <password>
    When User taps on Sign Button
    And User clicks on customer menu
    And User clicks on customer menu officer
    And User clicks on customer
    And User clicks on individual customer
    When User Enter <fullname> <shortname> <familyname> <title> <gender> <sector> <mnemonic> <industry> <nationality> info
    And User Taps on physical address to enter<street> info
    And User taps on commit
    Then User moves to next page

    Examples:
      |     fullname   | shortname |familyname|title|gender|sector|mnemonic|industry|nationality|street|username|password|
      |Aya Adel Mahmoud|Aya|Hosny       |Mrs|Female|3002|MAHAYA|1002|EG|zayed |AUTOMATION.1|Aa12345&|


