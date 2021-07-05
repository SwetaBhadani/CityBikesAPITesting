Feature: Test API for City Bikes

  Scenario: Test API for City Bikes

    Given The User has CityBike URL
    When User requests to check the networks of city bike, gets a success with status code 200
    When User verifys the country of the city Frankfurt, he gets Germany(DE) and their corresponding latitude and longitude
    When User makes a request with incorrect URI gets a response code of 404
