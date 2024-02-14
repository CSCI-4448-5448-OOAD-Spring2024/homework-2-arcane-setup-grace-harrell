# Homework2 ARCANE-SetUp

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
   

# Trial 1 of the game:  
> Task :compileJava
> Task :processResources UP-TO-DATE
> Task :classes
> Task :compileTestJava
> Task :processTestResources NO-SOURCE
> Task :testClasses
Starting play...


ARCANE Maze: turn 0
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0), Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie
Southwest:
	Adventurers: 
		Olivia(health: 5.0)
	Creatures:  
	Food:  
		Cake
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
		Ava(health: 5.0)
	Creatures:  
	Food:  
		Tomato, Chicken
Actions: 
Adventurer Olivia(health: 6.0) just ate Cake
Adventurer Ava(health: 6.0) just ate Tomato


ARCANE Maze: turn 1
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0), Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie
Southwest:
	Adventurers: 
		Olivia(health: 6.0)
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
		Ava(health: 6.0)
	Creatures:  
	Food:  
		Chicken
Actions: 
Adventurer Olivia(health: 6.0) has moved from Southwest to South
Adventurer Ava(health: 7.0) just ate Chicken


ARCANE Maze: turn 2
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0), Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
		Olivia(health: 6.0)
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
		Ava(health: 7.0)
	Creatures:  
	Food:  
Actions: 
Adventurer Olivia(health: 6.0) has moved from South to Southeast
Adventurer Ava(health: 7.0) has moved from Southeast to South


ARCANE Maze: turn 3
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0), Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
		Ava(health: 7.0)
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
		Olivia(health: 6.0)
	Creatures:  
	Food:  
Actions: 
Adventurer Olivia(health: 6.0) has moved from Southeast to East
Adventurer Ava(health: 7.0) has moved from South to Southwest


ARCANE Maze: turn 4
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 6.0)
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0), Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie
Southwest:
	Adventurers: 
		Ava(health: 7.0)
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Olivia(health: 5.5) fought Ghoul(health: 2.5)
Adventurer Olivia(health: 0.5) lost to Ghoul(health: 2.5)
Adventurer Ava(health: 7.0) has moved from Southwest to West


ARCANE Maze: turn 5
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.5)
	Creatures:  
		Ghoul(health: 2.5)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0), Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
		Ava(health: 7.0)
	Creatures:  
	Food:  
		Cookie
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Olivia(health: 0.0) DEAD was killed.
Adventurer Ava(health: 8.0) just ate Cookie


ARCANE Maze: turn 6
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0), Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
		Ava(health: 8.0)
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 8.0) has moved from West to Center


ARCANE Maze: turn 7
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
		Ava(health: 8.0)
	Creatures:  
		Ogre(health: 3.0), Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 7.5) fought Ogre(health: 2.5)
Adventurer Ava(health: 7.5) beat Ogre(health: 0.0)


ARCANE Maze: turn 8
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
		Ava(health: 7.5)
	Creatures:  
		Goblin(health: 3.0), Ogre(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 7.0) fought Goblin(health: 2.5)
Adventurer Ava(health: 7.0) beat Goblin(health: 0.0)


ARCANE Maze: turn 9
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
		Ava(health: 7.0)
	Creatures:  
		Goblin(health: 0.0), Ogre(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 6.5) has defeated Goblin
Adventurer Ava(health: 6.5) has moved from Center to North


ARCANE Maze: turn 10
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Ava(health: 6.5)
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0), Ogre(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 6.0) fought Ghoul(health: 2.5)
Adventurer Ava(health: 5.0) lost to Ghoul(health: 2.5)


ARCANE Maze: turn 11
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Ava(health: 5.0)
	Creatures:  
		Ghoul(health: 2.5)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0), Ogre(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 4.5) fought Ghoul(health: 2.0)
Adventurer Ava(health: 4.5) drew against Ghoul(health: 2.0)


ARCANE Maze: turn 12
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Ava(health: 4.5)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0), Ogre(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 4.0) fought Ghoul(health: 1.5)
Adventurer Ava(health: 4.0) drew against Ghoul(health: 1.5)


ARCANE Maze: turn 13
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Ava(health: 4.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0), Ogre(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 3.5) fought Ghoul(health: 1.0)
Adventurer Ava(health: 0.5) lost to Ghoul(health: 1.0)


ARCANE Maze: turn 14
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Ava(health: 0.5)
	Creatures:  
		Ghoul(health: 1.0)
	Food:  
		Cookie, Chicken, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken, Chicken, Pancake
East:
	Adventurers: 
		Olivia(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0), Ogre(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 0.0) DEAD was killed.
Boo, the creatures won.
> Task :test
BUILD SUCCESSFUL in 494ms
4 actionable tasks: 3 executed, 1 up-to-date
4:08:44 PM: Execution finished ':test --tests "arcane.ArcaneTest.testPlayThree"'.


# Trial 2 of the game:   
> Task :compileJava UP-TO-DATE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE
> Task :compileTestJava UP-TO-DATE
> Task :processTestResources NO-SOURCE
> Task :testClasses UP-TO-DATE
Starting play...


ARCANE Maze: turn 0
Northwest:
	Adventurers: 
		Alex(health: 5.0)
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
		Liam(health: 5.0)
	Creatures:  
	Food:  
		Cookie, Cookie
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 6.0) just ate Cookie
Adventurer Alex(health: 5.0) has moved from Northwest to West


ARCANE Maze: turn 1
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
		Liam(health: 6.0)
	Creatures:  
	Food:  
		Cookie
West:
	Adventurers: 
		Alex(health: 5.0)
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 7.0) just ate Cookie
Adventurer Alex(health: 4.5) fought Ogre(health: 2.5)
Adventurer Alex(health: 4.5) beat Ogre(health: 0.0)


ARCANE Maze: turn 2
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
		Liam(health: 7.0)
	Creatures:  
	Food:  
West:
	Adventurers: 
		Alex(health: 4.5)
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 7.0) has moved from Center to South
Adventurer Alex(health: 4.0) has defeated Ogre
Adventurer Alex(health: 4.0) has moved from West to Northwest


ARCANE Maze: turn 3
Northwest:
	Adventurers: 
		Alex(health: 4.0)
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
		Cookie, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
		Liam(health: 7.0)
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 6.5) fought Goblin(health: 2.5)
Adventurer Liam(health: 5.5) lost to Goblin(health: 2.5)
Adventurer Alex(health: 4.0) has moved from Northwest to North


ARCANE Maze: turn 4
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Alex(health: 4.0)
	Creatures:  
	Food:  
		Cookie, Banana
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
		Liam(health: 5.5)
	Creatures:  
		Goblin(health: 2.5)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 5.0) fought Goblin(health: 2.0)
Adventurer Liam(health: 5.0) beat Goblin(health: 0.0)
Adventurer Alex(health: 5.0) just ate Cookie


ARCANE Maze: turn 5
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Alex(health: 5.0)
	Creatures:  
	Food:  
		Banana
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
		Liam(health: 5.0)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 4.5) has defeated Goblin
Adventurer Liam(health: 4.5) has moved from South to Center
Adventurer Alex(health: 6.0) just ate Banana


ARCANE Maze: turn 6
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Alex(health: 6.0)
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
		Liam(health: 4.5)
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 4.5) has moved from Center to West
Adventurer Alex(health: 6.0) has moved from North to Northwest


ARCANE Maze: turn 7
Northwest:
	Adventurers: 
		Alex(health: 6.0)
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
		Liam(health: 4.5)
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 4.0) has defeated Ogre
Adventurer Liam(health: 4.0) has moved from West to Center
Adventurer Alex(health: 6.0) has moved from Northwest to West


ARCANE Maze: turn 8
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
		Liam(health: 4.0)
	Creatures:  
	Food:  
West:
	Adventurers: 
		Alex(health: 6.0)
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 4.0) has moved from Center to West
Adventurer Liam(health: 4.0) has moved from West to Northwest
Adventurer Alex(health: 5.5) has defeated Ogre
Adventurer Alex(health: 5.5) has moved from West to Northwest


ARCANE Maze: turn 9
Northwest:
	Adventurers: 
		Alex(health: 5.5), Liam(health: 4.0)
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 4.0) has moved from Northwest to North
Adventurer Alex(health: 5.5) has moved from Northwest to North


ARCANE Maze: turn 10
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Alex(health: 5.5), Liam(health: 4.0)
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 4.0) has moved from North to Northeast
Adventurer Alex(health: 5.5) has moved from North to Center


ARCANE Maze: turn 11
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 4.0)
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
		Alex(health: 5.5)
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 3.5) fought Ghoul(health: 2.5)
Adventurer Liam(health: 2.5) lost to Ghoul(health: 2.5)
Adventurer Alex(health: 5.5) has moved from Center to North


ARCANE Maze: turn 12
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Alex(health: 5.5)
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 2.5)
	Creatures:  
		Ghoul(health: 2.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Liam(health: 2.0) fought Ghoul(health: 2.0)
Adventurer Liam(health: 0.0) lost to Ghoul(health: 2.0)
Adventurer Alex(health: 5.5) has moved from North to Northeast


ARCANE Maze: turn 13
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Alex(health: 5.5), Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 2.0)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 5.5) has moved from Northeast to East
Adventurer Liam(health: 0.0) DEAD was killed.
Adventurer Alex(health: 5.0) fought Goblin(health: 2.5)
Adventurer Alex(health: 4.0) lost to Goblin(health: 2.5)


ARCANE Maze: turn 14
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
		Alex(health: 4.0)
	Creatures:  
		Goblin(health: 2.5)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 3.5) fought Goblin(health: 2.0)
Adventurer Alex(health: 3.5) beat Goblin(health: 0.0)


ARCANE Maze: turn 15
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
		Alex(health: 3.5)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 3.0) has defeated Goblin
Adventurer Alex(health: 3.0) has moved from East to Center


ARCANE Maze: turn 16
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
		Alex(health: 3.0)
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 3.0) has moved from Center to North


ARCANE Maze: turn 17
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
		Alex(health: 3.0)
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 3.0) has moved from North to Northwest


ARCANE Maze: turn 18
Northwest:
	Adventurers: 
		Alex(health: 3.0)
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 3.0) has moved from Northwest to West


ARCANE Maze: turn 19
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
		Alex(health: 3.0)
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 2.5) has defeated Ogre
Adventurer Alex(health: 2.5) has moved from West to Southwest


ARCANE Maze: turn 20
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
		Alex(health: 2.5)
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 2.0) fought Ogre(health: 2.5)
Adventurer Alex(health: 2.0) beat Ogre(health: 0.0)


ARCANE Maze: turn 21
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
		Alex(health: 2.0)
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 1.5) has defeated Ogre
Adventurer Alex(health: 1.5) has moved from Southwest to South


ARCANE Maze: turn 22
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
		Alex(health: 1.5)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 1.0) has defeated Goblin
Adventurer Alex(health: 1.0) has moved from South to Center


ARCANE Maze: turn 23
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
		Alex(health: 1.0)
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 1.0) has moved from Center to South


ARCANE Maze: turn 24
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
		Alex(health: 1.0)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 0.5) has defeated Goblin
Adventurer Alex(health: 0.5) has moved from South to Southwest


ARCANE Maze: turn 25
Northwest:
	Adventurers: 
	Creatures:  
	Food:  
North:
	Adventurers: 
	Creatures:  
	Food:  
Northeast:
	Adventurers: 
		Liam(health: 0.0)
	Creatures:  
		Ghoul(health: 1.5)
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Center:
	Adventurers: 
	Creatures:  
	Food:  
West:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Pancake
Southwest:
	Adventurers: 
		Alex(health: 0.5)
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Salad, Cake, Cookie, Fries
South:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Actions: 
Adventurer Alex(health: 0.0) has defeated Ogre
Adventurer Alex(health: 0.0) has moved from Southwest to South
Adventurer Alex(health: 0.0) DEAD was killed.
Boo, the creatures won.
> Task :test
BUILD SUCCESSFUL in 443ms
4 actionable tasks: 1 executed, 3 up-to-date
4:14:06 PM: Execution finished ':test --tests "arcane.ArcaneTest.testPlayThree"'.


# Trial 3 of the game:   
> Task :compileJava UP-TO-DATE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE
> Task :compileTestJava UP-TO-DATE
> Task :processTestResources NO-SOURCE
> Task :testClasses UP-TO-DATE
Starting play...


ARCANE Maze: turn 0
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Isabella(health: 5.0)
	Creatures:  
		Goblin(health: 3.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
		Ava(health: 5.0)
	Creatures:  
	Food:  
		Chicken, Fries, Chicken
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 4.5) fought Goblin(health: 2.5)
Adventurer Isabella(health: 4.5) beat Goblin(health: 0.0)
Adventurer Ava(health: 6.0) just ate Chicken


ARCANE Maze: turn 1
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Isabella(health: 4.5)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
		Ava(health: 6.0)
	Creatures:  
	Food:  
		Fries, Chicken
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 4.0) has defeated Goblin
Adventurer Isabella(health: 4.0) has moved from East to Center
Adventurer Ava(health: 7.0) just ate Fries


ARCANE Maze: turn 2
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
		Isabella(health: 4.0)
	Creatures:  
		Goblin(health: 3.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
		Ava(health: 7.0)
	Creatures:  
	Food:  
		Chicken
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 3.5) fought Goblin(health: 2.5)
Adventurer Isabella(health: 2.5) lost to Goblin(health: 2.5)
Adventurer Ava(health: 8.0) just ate Chicken


ARCANE Maze: turn 3
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
		Isabella(health: 2.5)
	Creatures:  
		Goblin(health: 2.5)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
		Ava(health: 8.0)
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 2.0) fought Goblin(health: 2.0)
Adventurer Isabella(health: 2.0) beat Goblin(health: 0.0)
Adventurer Ava(health: 8.0) has moved from Southwest to South


ARCANE Maze: turn 4
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
		Isabella(health: 2.0)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
		Ava(health: 8.0)
	Creatures:  
		Ghoul(health: 3.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 1.5) has defeated Goblin
Adventurer Isabella(health: 1.5) has moved from Center to East
Adventurer Ava(health: 7.5) fought Ghoul(health: 2.5)
Adventurer Ava(health: 7.5) beat Ghoul(health: 0.0)


ARCANE Maze: turn 5
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Isabella(health: 1.5)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
		Ava(health: 7.5)
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 1.0) has defeated Goblin
Adventurer Isabella(health: 1.0) has moved from East to Northeast
Adventurer Ava(health: 7.0) has defeated Ghoul
Adventurer Ava(health: 7.0) has moved from South to Southwest


ARCANE Maze: turn 6
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
		Isabella(health: 1.0)
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
		Ava(health: 7.0)
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 1.0) has moved from Northeast to East
Adventurer Ava(health: 7.0) has moved from Southwest to South


ARCANE Maze: turn 7
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Isabella(health: 1.0)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
		Ava(health: 7.0)
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 0.5) has defeated Goblin
Adventurer Isabella(health: 0.5) has moved from East to Southeast
Adventurer Ava(health: 6.5) has defeated Ghoul
Adventurer Ava(health: 6.5) has moved from South to Southwest


ARCANE Maze: turn 8
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
		Ava(health: 6.5)
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
		Isabella(health: 0.5)
	Creatures:  
	Food:  
		Pancake, Pasta
Actions: 
Adventurer Isabella(health: 1.5) just ate Pancake
Adventurer Ava(health: 6.5) has moved from Southwest to South


ARCANE Maze: turn 9
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
		Ava(health: 6.5)
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
		Isabella(health: 1.5)
	Creatures:  
	Food:  
		Pasta
Actions: 
Adventurer Isabella(health: 2.5) just ate Pasta
Adventurer Ava(health: 6.0) has defeated Ghoul
Adventurer Ava(health: 6.0) has moved from South to Center


ARCANE Maze: turn 10
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
		Ava(health: 6.0)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
		Isabella(health: 2.5)
	Creatures:  
	Food:  
Actions: 
Adventurer Isabella(health: 2.5) has moved from Southeast to East
Adventurer Ava(health: 5.5) has defeated Goblin
Adventurer Ava(health: 5.5) has moved from Center to West


ARCANE Maze: turn 11
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Isabella(health: 2.5)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
		Ava(health: 5.5)
	Creatures:  
	Food:  
		Steak
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Isabella(health: 2.0) has defeated Goblin
Adventurer Isabella(health: 2.0) has moved from East to Northeast
Adventurer Ava(health: 6.5) just ate Steak


ARCANE Maze: turn 12
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
		Isabella(health: 2.0)
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
		Ava(health: 6.5)
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Isabella(health: 2.0) has moved from Northeast to North
Adventurer Ava(health: 6.5) has moved from West to Center


ARCANE Maze: turn 13
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 2.0)
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
		Ava(health: 6.5)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Isabella(health: 1.5) fought Ogre(health: 2.5)
Adventurer Isabella(health: 1.5) drew against Ogre(health: 2.5)
Adventurer Ava(health: 6.0) has defeated Goblin
Adventurer Ava(health: 6.0) has moved from Center to West


ARCANE Maze: turn 14
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 1.5)
	Creatures:  
		Ogre(health: 2.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
		Ava(health: 6.0)
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Isabella(health: 1.0) fought Ogre(health: 2.0)
Adventurer Isabella(health: 0.0) lost to Ogre(health: 2.0)
Adventurer Ava(health: 6.0) has moved from West to Center


ARCANE Maze: turn 15
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 2.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
		Ava(health: 6.0)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Isabella(health: 0.0) DEAD was killed.
Adventurer Ava(health: 5.5) has defeated Goblin
Adventurer Ava(health: 5.5) has moved from Center to East


ARCANE Maze: turn 16
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Ava(health: 5.5)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 5.0) has defeated Goblin
Adventurer Ava(health: 5.0) has moved from East to Southeast


ARCANE Maze: turn 17
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
		Ava(health: 5.0)
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 5.0) has moved from Southeast to East


ARCANE Maze: turn 18
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Ava(health: 5.0)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 4.5) has defeated Goblin
Adventurer Ava(health: 4.5) has moved from East to Southeast


ARCANE Maze: turn 19
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
		Ava(health: 4.5)
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 4.5) has moved from Southeast to East


ARCANE Maze: turn 20
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Ava(health: 4.5)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 4.0) has defeated Goblin
Adventurer Ava(health: 4.0) has moved from East to Southeast


ARCANE Maze: turn 21
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
		Ava(health: 4.0)
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 4.0) has moved from Southeast to East


ARCANE Maze: turn 22
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
		Ava(health: 4.0)
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 3.5) has defeated Goblin
Adventurer Ava(health: 3.5) has moved from East to Northeast


ARCANE Maze: turn 23
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
		Ava(health: 3.5)
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 3.5) has moved from Northeast to North


ARCANE Maze: turn 24
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Ava(health: 3.5), Isabella(health: 0.0)
	Creatures:  
		Ogre(health: 1.5)
	Food:  
		Salad
Northeast:
	Adventurers: 
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Isabella(health: 0.0) has moved from North to Northeast
Adventurer Ava(health: 3.0) fought Ogre(health: 1.0)
Adventurer Ava(health: 3.0) beat Ogre(health: 0.0)


ARCANE Maze: turn 25
Northwest:
	Adventurers: 
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
		Ava(health: 3.0)
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 2.5) has defeated Ogre
Adventurer Ava(health: 2.5) has moved from North to Northwest


ARCANE Maze: turn 26
Northwest:
	Adventurers: 
		Ava(health: 2.5)
	Creatures:  
		Ogre(health: 3.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 2.0) fought Ogre(health: 2.5)
Adventurer Ava(health: 2.0) beat Ogre(health: 0.0)


ARCANE Maze: turn 27
Northwest:
	Adventurers: 
		Ava(health: 2.0)
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Cookie, Ice Cream
North:
	Adventurers: 
	Creatures:  
		Ogre(health: 0.0)
	Food:  
		Salad
Northeast:
	Adventurers: 
		Isabella(health: 0.0)
	Creatures:  
	Food:  
East:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
		Chicken
Center:
	Adventurers: 
	Creatures:  
		Goblin(health: 0.0)
	Food:  
West:
	Adventurers: 
	Creatures:  
	Food:  
Southwest:
	Adventurers: 
	Creatures:  
	Food:  
South:
	Adventurers: 
	Creatures:  
		Ghoul(health: 0.0)
	Food:  
Southeast:
	Adventurers: 
	Creatures:  
	Food:  
Actions: 
Adventurer Ava(health: 1.5) has defeated Ogre
Adventurer Ava(health: 1.5) has moved from Northwest to North
Yay, the Adventurers won.
> Task :test
BUILD SUCCESSFUL in 429ms
4 actionable tasks: 1 executed, 3 up-to-date
4:15:22 PM: Execution finished ':test --tests "arcane.ArcaneTest.testPlayThree"'.




