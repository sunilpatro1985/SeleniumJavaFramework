## Selenium Java framework with maven testNG


Refer [step by step tutorial](https://www.youtube.com/playlist?list=PLPO0LFyCaSo1lEiEFxT97x-CSn-J1omzZ )
 for detailed explanation.
 

### Highlights on this framework 
* How to create maven build project 
* Write tests using testNG
* Implement page object model
* Singleton pattern for driver instantiation and getter / setter
* Running the tests using maven surefire plugin
* Run tests in command prompt
* Run tests in Docker containers


Refer below links for basic understanding of selenium, Maven & testNG
* [Selenium java topics](https://youtube.com/playlist?list=PLPO0LFyCaSo22dffCqWdwyxOxdA1KgtJ7)  
* [TestNG features](https://youtube.com/playlist?list=PLPO0LFyCaSo3gshbTOWezIzAqiJSHc2H-)  

-----------------
Open command prompt, navigate to project directory & run below command

### Run tests in local
`mvn test` //default runs in chrome browser  
`mvn test -Dbrowser=firefox` 

### Run tests in remote / docker

**Note -** 
Make sure you have docker desktop installed
Docker is currently running
Navigate to docker directory `cd docker`  
Run below command to run the docker conntainers
`docker-compose -f docker-compose-hubNode.yml up -d`

Now in another terminal, run any of below command to run the tests inside the container  
`mvn test -Dplatform=remote` //default runs in chrome browser  
`mvn test -Dbrowser=firefox -Dplatform=remote`

See the tests running insider container  
Navigate to browser and load this url `localhost:4444`

After running the tests, stop the containers  
`docker-compose -f docker-compose-hubNode.yml down`