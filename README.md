# BBC Programme Finder Application by Patrick Cunningham

This is a simple TDD Spring MVC web application which searches a [BBC feed] (http://www.bbc.co.uk/iplayer/ion/searchextended/search_availability/iplayer/service_type/radio/format/json/q/news) for viewable/listenable episodes of programmes on the iplayer.

The front-end uses [Twitter bootstrap] (http://twitter.github.com/bootstrap/) to provide a responsive layout so the app provides different layouts per device.

## How far did I get?

The app matches all four intended scenarios
- Entering a string into a text box to search on
- Search string returns matches for a Brand name
- Search string returns no matches for a Brand name
- Begin entering a string into a text box to search on and pause

## How did I do it

Given the data feed url I created a local copy of a typical results response and (working on the assumption that data is present for all properties) generated pojos using [jsonschema2pojo](http://code.google.com/p/jsonschema2pojo/).
Once in these object I used MVC and Service design patterns to manipulate data and return correct information to relevant pages.

## Demo Version

Can be found [here] (http://programme-finder.herokuapp.com/)


## Running the application locally

First build with:

    $mvn clean install

Then run it with:

    $java -jar target/dependency/webapp-runner.jar target/*.war

And open a web browser and go to 

    [http://localhost:8080/] (http://localhost:8080/)

