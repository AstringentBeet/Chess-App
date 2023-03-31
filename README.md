# Chess

## Table of contents

- [Overview](#overview)
  - [The challenge](#the-challenge)
  - [Screenshot](#screenshot)
  - [Links](#links)
- [My process](#my-process)
  - [Progress log](#progress-log)
  - [Built with](#built-with)
  - [What I learned](#what-i-learned)
  - [Useful resources](#useful-resources)

**Note: Delete this note and update the table of contents based on what sections you keep.**

## Overview
This will be a simple chess application. The goal is to create a fully-structured application, which will help me understand how to properly structure and build a Java application using a good portion of what its extensive library has to offer.

### The challenge

Users should be:

-Play chess. That is all.

### Screenshot

![](./screenshot.jpg)


### Links

- Solution URL: [Add solution URL here](https://your-solution-url.com)
- Live Site URL: [Add live site URL here](https://your-live-site-url.com)

## My process
Utilize the android api to create a blank screen. This will allow me to create a grid display.

### Progress Log

#### 03/22/23
Created the both the packages and classes for the tiles on the board and the chess pieces. The tile class is actually a nested class, whose inner classes can determine whether the tile is occupied. There's more to it than that, but I'll add details when it's not 3:34am.

#### 03/28/23
Adding more details to the tile class, and it's nested classes. By making the classes immutable, it'll make the overall program more efficient and secure. I also added three more classes (technically two classes, one Enum) to flesh out some of the methods within the `piece` class. 

#### 03/31/23; 12:51pm
In addition to cleaning up the code in the Tile class, I added a bit more details to make it as immutable a possible.
Note from TextEdit:
Immutability simply refers to the property of an object that cannot be modified after it has been created. Other classes can still have access to it; they simply can’t modify the value(s) assigned to the object.
This project is helping me get a much better understanding of how Java and OOP works in general. Two things to take note of:
•	When using the static key word  – more specifically, when making an immutable class, method, or variable immutable, the data at hand is initialized only once (given that the class containing these elements is loaded) instead. This saves the application a lot of memory and increases the overall performance of the chess engine.
In order to make a class immutable, there are four rules to follow:
1.	There must not be methods that allows the modification of an object’s state (known as mutators aka setter methods).
2.	Ensure that the class can’t be extended. This is done by using the final keyword in java
3.	Make al fields private.
4.	Ensure exclusive access to any mutable components. This is done through defensive copies (also known as copy constructors).
~~~
  Class Copy {
    int a;
    int b;
    public Copy(Copy c1) {
      a = c1.a;
      b = c1.b;
    }
  }
~~~
Anywhats, I began following along this tutorial with the partial knowledge that building this application was going to be challenging. As it turns out, it's pretty complex for where I'm at right now; I'm finding my (numerous) browser windows have over 15 tabs open each exploring various features of the Java programming language. I'm still learning to appreciate the language, and this project is definitely helping with that. Next step is adding the Knight piece. 

### Built with

- Java
- Maven

### What I learned
-The importance of class immutability.
Not enough.

### Useful resources
