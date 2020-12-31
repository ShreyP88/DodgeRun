# DodgeRun
Java Game based on the premise of Object-Oriented Programming (OOP) made to strengthen my Java knowledge and to have fun. 

## Instructions
Use WASD to move and try your best to dodge enemies. The levels will increment every 500 points. During the game, you can use P to pause and SPACE to open the shop where you can upgrade player HP (1000 points), Speed (750 points), or Refill HP (500 points) in order to make your journey to surviving the longest amount of time easier! 

## Details
The game is based on the fundamentals of object oriented programming as it includes objects which help the game function in various diffrent ways. The game mostly relies on two methods, render and tick which generate graphics and allow for objects to access further stages of the game respectively. I also incorporated a LinkedList for the enemies which allows for easy removal of enemies or in my case, I cleared all enemies before the boss level in order to make the game fair. I utilized a HashMap but not for anything too complicated. The HashMap was used to access the music which plays in the menu and in the background of the game. 
<img src="https://github.com/ShreyP88/DodgeRun/blob/master/game%20pics/intro.PNG" width=600>
<img src="https://github.com/ShreyP88/DodgeRun/blob/master/game%20pics/character%20select.PNG" width=600>
#### This portion of the game will allow you to select your character. The Wizard will move faster with less HP while the Knight will be slower with more HP.
<img src="https://github.com/ShreyP88/DodgeRun/blob/master/game%20pics/Level%201%20-%202.PNG" width=600>
#### Following the selection of your character, enemies will begin to spawn periodically every round with an emergence of a super enemy every 4th level and a tracking enemy (cyan) at level 5 (green) in order to prevent 'camping.'
<img src="https://github.com/ShreyP88/DodgeRun/blob/master/game%20pics/Before%20Health%20Refill.PNG" width=600>
#### Here is an example of the different enemies as well as a display of using the shop effectively. 
<img src="https://github.com/ShreyP88/DodgeRun/blob/master/game%20pics/after%20pause.PNG" width=600>
#### As you can see, my health has no been refilled.
<img src="https://github.com/ShreyP88/DodgeRun/blob/master/game%20pics/Boss.PNG" width=600>
#### At level 10, a boss will appear and every level after will continue to spawn enemies with the same rules mentioned before. 



## Motivation/Future
I wanted to learn the ins and outs of Java and since I already had a good understanding of OOP, I wanted to take it to the next level and have mutliple objects and methods integrated within another and interacting with eachother. I also wanted to create something which my 10 year old brother would be fascinated to play and with his input, created a dodging based game. I'm still going to be working on this game to add more features such as a worlds system where there are different bosses, enemies, obstacles. 

