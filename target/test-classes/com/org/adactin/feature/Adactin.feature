Feature: Adactin application
Scenario: User login adactin application
Given User launched the adactin application
When user enter the below value as data for login
|username|password|
|Priyu007|priyank|
#When User enter "<username>" the username
#And User enter "<password>" the password
Then User validate the username and password

Scenario: User login adactin application
Given User launched the adactin application
When user enter the below value as data for login
|username|password|
|bgpriyu07|priyanka7895|
Then User validate the username and password

Scenario: User login adactin application
Given User launched the adactin application
When user enter the below value as data for login
|username|password|
|priyu7895|priyanka7895|
Then User validate the username and password

Scenario: User enter into search hotel page
When User select the location
When User select the hotel
When User select the Roomtype
When User select the NumberofRooms
When User select the Checkindate
When User select the Checkoutdate
When User select the Adultsperroom
When User select the Childperroom
And User click the search button to search hotel details
Then User validate the search Hotel page.

#Examples:
#|username|password|
#|Priyu007|priyank|
#|bgpriyu07|priyanka7895|
#|priyu7895|priyanka7895|

