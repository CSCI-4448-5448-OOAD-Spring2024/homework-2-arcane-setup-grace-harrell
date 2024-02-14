# Homework2 ARCANE-SetUp

Team Members:

1. Grace Harrell
2. Lindy Zhang 

Java Version: 17

Comments / Descriptions: The game ARCANE is a self playing game with adventurers and creatures in a cave system with 4 or 9 rooms. The adventurers move rooms until they encounter a creature and then they engage in a fight. The fight is determined by dice rolls made by both the creature and adventurer and continues until one of them dies. If the adventurers encounter food in a room without a creature, they are able to eat and increase their health.

1. Cohesion: Our dice class. Screenshot below:
   
  <img width="619" alt="Dice" src="https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/112991905/f476a738-986b-4323-8211-a2bb73c41b28">

2. Encapsulation / Information Hiding:
   
3. Dependency Injection: This constructor for our Cave class shows how Cave is dependent on the Creature, Adventurer, and Room classes. It is required that they are passed into the constructor when a new cave is created. This provides it with the information that the cave class needs without constructing new instances of the objects. 

   <img width="631" alt="Screenshot 2024-02-14 at 3 59 50 PM" src="https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/112991905/ed7156b3-f169-4541-8a79-b188e1c653ee">


4. Polymorphism: The setName() function in the Entity class is an example of polymorphism. This is because the subclasses of Entity, Creature and Adventurer, though they inherit the setName method, the subclasses have different behaviors when setName() is called.
   
   
5. Inheritance: The Food, Creature, and Adventurer classes are subclasses of Entity, and inherit its methods and variables.
   


