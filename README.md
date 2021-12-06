
#Asian Health Clinic
#Summary
#I would like to create a web application for my Final Project . The name of my web application is Asian Health Clinic . Even though name mentions a health clinic we are going to focus only on creating an appointment for patients. Here users are employees that work in Asian Clinic . We also have admin who have more privileges than users . The Home Page would allow user/ admin to login if they are already a registered member or register by creating an account. let’s dive into the functions performed by User and admin
#A User will be able to add patients and they would add appointment schedule   for each patient . Inserted patient data is displayed  in another page where user can view , edit or delete the patient data. An admin can do the functions of users and in addition inserts the availability schedule , he/she can add , edit, or remove physicians’ data  from clinic  and add their available hours. . I thought of creating a Patient appointment system to simulate the functions performed by everyone in a clinic out of my imagination. I used to think about how all the systems correlate each other when I call for a doctor appointment from health clinic

#Design Specifications
#I preferred a professional theme. Because it’s a clinic website  It focus more on content . I want users to easily navigate to web app and create the appointment without much time consumption.  I inserted one picture in the homepage  that would relate with the web app. My web application has navigation menu , breadcrumb menu , form, and a table.  Navigation menu shows the actions of different functions . Form is used to add patients’ , available hours, and physicians’ data. I used a tabular and card format for displaying data done by both admin and user.

#Future Work
#There is no search bar for my current application . A search bar would allow users/ admin to easily find the patient or physicians’  data  rather than scrolling through a long list. For either I need to add a search API or add another controller for my web application. The new controller will use the patient or physician repository . Both repositories should have methods to search by different fields inherited from Crud repository . The methods are overridden in the controller that have the methods to display data.

#Database Credentials:

#Heroku URL: