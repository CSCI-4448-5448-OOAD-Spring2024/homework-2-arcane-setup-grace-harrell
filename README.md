# Homework3 ARCANE-SetUp

Team Members:

1. Grace Harrell
2. Lindy Zhang 

Java Version: 17

Comments / Descriptions: The game ARCANE is a self playing game with adventurers and creatures in a cave system with 4 or 9 rooms. The adventurers move rooms until they encounter a creature and then they engage in a fight. The fight is determined by dice rolls made by both the creature and adventurer and continues until one of them dies. If the adventurers encounter food in a room without a creature, they are able to eat and increase their health.

1. Cohesion: Our dice class. Screenshot below:
   
  <img width="619" alt="Dice" src="https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/112991905/f476a738-986b-4323-8211-a2bb73c41b28">

2. Encapsulation / Information Hiding: This is an example of Encapsulation from our fight() method in the turn class. We use the isAlive() method on creature and adventurer hides the excess code done on both of the entities to execute the conditional. Additionally, we hide the information on the randomization with the rollDice method.

   <img width="625" alt="Screenshot 2024-02-14 at 4 11 33 PM" src="https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/112991905/6472069b-b0ce-41fd-b568-5f12c5ca4ad9">

2. Dependency Injection: This constructor for our Cave class shows how Cave is dependent on the Creature, Adventurer, and Room classes. It is required that they are passed into the constructor when a new cave is created. This provides it with the information that the cave class needs without constructing new instances of the objects. 

   <img width="631" alt="Screenshot 2024-02-14 at 3 59 50 PM" src="https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/112991905/ed7156b3-f169-4541-8a79-b188e1c653ee">


3. Polymorphism: The setName() function in the Entity class is an example of polymorphism. This is because the subclasses of Entity, Creature and Adventurer, though they inherit the setName method, the subclasses have different behaviors when setName() is called.
   
   
4. Inheritance: The Food, Creature, and Adventurer classes are subclasses of Entity, and inherit its methods and variables.

**Code Coverage**  
<img width="539" alt="Screenshot 2024-02-14 at 4 32 31 PM" src="https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/112991905/9e46bbc6-e4e7-4055-be57-53d79ab73c0d">

   
****EXAMPLE OUTPUTS (made by testPlayThree in ArcaneTest)****
https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/blob/Homework_3/exampleOutput3x3.txt 

https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/blob/Homework_3/exampleOuput3x3_2.txt  

https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/blob/Homework_3/exampleOutput3x3_3.txt
