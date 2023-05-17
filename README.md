User Service

    This is a user service that allows you to perform various operations related to managing user accounts. 
    In this specific implementation, the users are considered as students. 
    The service provides the following functionalities:

    a) Create a new student account in the system.
    b) Fetch student details by user ID.
    c) Edit/modify student details.
    d) Soft delete a student account.
    
Setup Requirements

    a) IntelliJ IDEA or any IDE that supports Spring Boot applications.
    b) MySQL: A relational database management system. You'll need to install and configure a MySQL server to store and retrieve student data.
    c) Postman: A popular API development and testing tool.
    
    
 Getting Started

    To get started with the user service, one can follow these steps:

    a) Clone the repository: Clone the project repository to your local machine.
    b) Open the project in IntelliJ IDEA: Launch IntelliJ IDEA (or your preferred IDE) and import the project by selecting the cloned repository's directory.
    c) Configure the database: Update the database connection details in the project's configuration file to point to your MySQL server.
    d) Build the project: Build the project in your IDE to resolve dependencies and compile the source code.
    e) Run the application: Run the user service application from your IDE.   
    
    
API Endpoints

    The user service exposes the following API endpoints:

    POST /students: Create a new student account. Send a JSON payload containing the student's details (e.g., name, age, grade) in the request body.
    GET /students/{studentId}: Fetch the details of a specific student by their user ID.
    GET /students/{studentCity} : Fetch the details of all the students who belongs to the given specific city.
    GET /students/{studentage} : Fetch the details of all the students who are greater than the given age
    PUT /students/{studentId}: Modify the details of a specific student. Send a JSON payload containing the updated student details in the request body.
    DELETE /students/{studentId}: Soft delete a specific student account.    
    
Testing with Postman

     You can use Postman to test the user service API endpoints:
    Launch Postman.
    Set the HTTP method and URL for the desired API endpoint.
    Add any required request parameters or headers.
    Send the request and observe the response.   
    
 Conclusion 
 
     With this user service, you can easily manage student accounts by creating, 
     fetching, modifying, and deleting them. Follow the setup instructions, 
     explore the API endpoints, and test the service using Postman to experience its functionalities.
    
    
    
    
