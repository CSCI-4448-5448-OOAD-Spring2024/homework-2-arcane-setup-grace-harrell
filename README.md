# Homework 5 ARCANE

Team Members:

1. Grace Harrell
2. Lindy Zhang 

Java Version: 17

Comments / Descriptions: The game ARCANE is a self playing game with adventurers and creatures in a cave system any number of rooms. The adventurers (adventurer, knight, coward, glutton) move rooms until they encounter a creature (creature or demon) and then they engage in a fight/flee/eat. The fight is determined by dice rolls made by both the creature and adventurer and continues until one of them dies. If the adventurers (knight, adventurer, coward) encounter food in a room without a creature, they are able to eat and increase their health. We implemented an observer pattern to keep track of events such as an adventurers' or creatures' death, the end of a turn, the end of the game, etc. The adaptor pattern allows us to use the game display given to us.

**Extra Credit Implementation**
- We implemented a Cucumber-JVM scenario and the screenshot of the passing test is below.
  
<img width="518" alt="Screenshot 2024-03-15 at 9 44 06 AM" src="https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/112991905/91cf95fc-2ec4-40c6-a710-d056b27cb47c">  

**Interaction Diagram**
![interactionDiagram](https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/89498239/6db10349-e6c3-40b2-afd0-634ffe045ff4)



**Code Coverage Screenshot**  

<img width="498" alt="Screenshot 2024-03-15 at 2 43 49 PM" src="https://github.com/CSCI-4448-5448-OOAD-Spring2024/homework-2-arcane-setup-grace-harrell/assets/112991905/8e09dafe-056b-41bf-86cc-36ef7cba7638">  

**Arcane Play Example**  

https://drive.google.com/file/d/1QAnKX-433vTAYmWQbdhlxiHBO9JnGYEF/view?usp=sharing

