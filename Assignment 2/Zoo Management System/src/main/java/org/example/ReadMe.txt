PLEASE READ THE SECTION ON ASSUMPTIONS BEFORE RUNNING THE CODE

How to run the file in terminal:

1. Run the following commands in the terminal one after the other

mvn clean
mvn compile
mvn package

2. The previous command should create a target folder
Inside the target folder, you will find a .jar file
In my computer, the file is named : Assingment2-AP-1.0-SNAPSHOT.jar
Copy the name of the file

3.In the terminal, run the command:
cd target

4.In the terminal, run the command:
java -cp .\name_of_the_.jarfile name_of_the_main_class

In my computer, the command was:

java -cp .\Assingment2-AP-1.0-SNAPSHOT.jar org.example.Main

5. Hopefully, you are greeted with the zoo management system


Objected Oriented Programming Principles used in the Code:

1. Abstract Classes
The Animal class is an abstract class which is extended by the Mammal, Reptile and Amphibian Class

2. Polymorphism
The objects of type Reptile, Amphibian or Mammal are stored in a Hashmap which stores Animal type objects

3. Interfaces
To make sure that I had implemented the large number of functions in the Admin and Visitor classes, I made 2 interfaces
called AdminFunctions and VisitorFunctions and made the Admin and Visitor class implement them respectively

4. Inheritance
Since the Deal and Discount classes were fundamentally very similar, both of them were children of the Coupon class which
stored the general structure for both the classes

5. Comparator
I used the Comparator interface to sort a given ArrayList in descending order


Some Assumptions taken while writing the code (Please read before running the code):

1. Extensive error handling was done, so it is unlikely that the code will break down due to an invalid input.
Nevertheless, as a precaution, try to enter the required input as far as possible

2. It was mentioned that there should be at least 2 animals of each type. I assumed that this meant that
at any given meant, the number of animals of each type can't drop down below 2. Thus, you can't remove an
animal if there are only 2 of its kind.

3. The username and password required to enter the admin class are constants
Username : admin
Password : admin123

4. The balance of a given user is declared during registration and there is no way to add any more money

5. The price of the premium membership is Rs 200 and basic membership is Rs 20

6. When you add an attraction, it is closed by default and the ticket prices are set to 0.
So if you want an attraction to be accessible to the public ,
as soon as you initialise it, go to schedule events and open it. Also set the ticket prices as you wish after you
have opened the events you wanted as they are initialised to 0 by default.

7. Discounts are stacked on top of each other. Thus, a 30 percent discount coupon stacked on top of a 20 percent
special deal would result in a discount of 44 rs on a ticket costing 100 rs

8. Total visitors is taken to be the sum of the number of visitors of each attraction

9. If you want to create a coupon which is applicable only on minors ie people <18 years of age, please use the keyword "minor"
as the first word of the category of the discount coupon. Similarly, for creating a coupon only applicable
on senior citizens ie people > 60 years of age, please use the keyword "senior" as the first word of the
category of the discount coupon.


