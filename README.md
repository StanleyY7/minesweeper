# Project: Minesweeper

![minesweeperCap](https://user-images.githubusercontent.com/119549394/221120751-fc4440fb-5ed6-484b-a650-4076c357cb28.PNG)

A simplified CLI minesweeper game made using Java. 

## Outline
The main aim of this project was to utilise Java to build a simplified minesweeper CLI game.

## MVP
The main requirements of this project were:

- To recreate a simplified version of the game Minesweeper to be played in the java console.

- To have the game able to randomly generate 10 mines in a 10x10 grid.

- To have the grid be represented by a 2 dimensional array (or array like structure).

- To enable the user will be able to enter a command that represents a coordinate to check a location for a mine. Whereby after every guess the application should "redraw" the 2d grid. Revealing either a number from 0-8 depending on how many mines surround that location (based on the coordinate).

- That if the user selects a mine, the game will respond "boom!" and the game will be lost.

- That if every non-mine square has been revealed, the game is won.

- That the grid re-renders to the console after every user command.

## Bonus

- I added J-Unit Testing
- I refactored my original procedural programming minesweeper code into OOP (refactored version is in "minesweeperOOP" folder) whereby I also implemented the Command Design Pattern.

## Summary
I achieved the above requirements by first implementing the methods one by one in order. As an example I created the grid first, I then made methods to render it,  place bombs and then added more logic/methods accordingly until all MVP requirements were met. I then added bonus features, such as colors for grid elements (i.e. a bomb is red) as well as a wins/losses tracker which is printed at the initial start of the game.

### Gameplay Screenshot

![javaCap](https://user-images.githubusercontent.com/119549394/221120874-9f5e5475-538d-474b-b202-c32eed160cfb.PNG)

### Tech Stack
- Java
