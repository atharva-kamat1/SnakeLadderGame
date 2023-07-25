welcome to readme.md created by atharva kamat

this file contians the logic that i used for creating single-player snake ladder game in java...
the game is played on console

1) i have created a class called Dice which has a int 'top' variable. It has roll() which generates a random number between 1 to 6 
   using java.lang.Random and top is initialized to it and returns the top...

2) a new class snakeladder is defined which has int position that marks position of player on board

3) a snake or ladder can be thought as a key-value pair which takes player from a particular position
   and drops him to new position.

4) therefore, i have used 2 hashmaps (for 1 for snake and other for ladder) which stores the two positions as pair.

5) everytime we roll the dice, we land on new position and everytime it will check whether hashmap snake contians key as position
   or hashmap ladder contains key as position
   if it is present, then its a hit and we initialize position to the corresponding value...

6) we win the game once we reach position = 100

kindly find the source code file...