This Springboot application will run on jdk11 tomcat 10
This was compile and run using Intellij IDE
Open the project on Intellijji and build and run
Access on port 8080
I used Insomnia to test API endpoints

This project composed of the following:
1) NoteApplication java class - where the main spring boot initialize
2) NoteController java class  - where api endpoints controller router are set
3) NotePOJO java class - where the objects for getter and setters are declared
4) NoteService interface - an interface each functions
5) NoteServiceImpl - where the functionalities of each API endpoint located

I only used ArrayList Map to store the notes data instead of creating a database or a text file.
