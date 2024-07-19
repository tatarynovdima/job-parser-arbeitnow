Endpoints 

HTTP METHOD	Endpoint	Description
GET	/vacancies	Retrieve a sorted and paginated list of all vacancies.
GET	/vacancies/{id}	Retrieve detailed information about a vacancy by its ID.
GET	/vacancies/most-visited	Retrieve a list of the most visited vacancies' IDs. (The API has been changed so this method does not work correctly - but I did it according to the instructions)
GET	/vacancies/group-by-location	Retrieve a count of all vacancies grouped by location.


How to Start the Application Locally

Clone this repository and open it.
Run the application in your IDE.
Open your browser and navigate to http://localhost:8080/swagger-ui.html to access Swagger UI documentation.
You can test the application endpoints using Swagger UI or any other REST client tool.
