
# module-01 - Programer's way
using Pattern Design for a coffee shop

## Acknowledgements

> La vie en panic ;-;

It's good to say thanks to my buddy [@huyvha](huyvha@vng.com.vn), [@namlh4](namlh4@vng.com.vn), [@phucngh](phucnnh@vng.com.vn) and [@hoangnv6](hoangnv6@vng.com.vn) for helping me to finish this module.

Also, from the bottom of my heart, I want to say thank [@minhhn3](minhhn3@vng.com.vn) and [@hanvt](hanvt@vng.com.vn) for introducing me to `unit test` and `mockito` (and many other tools that I can not remember all).

Finally, I want to thank the evaluators [@taiptht](taiptht@vng.com.vn) and [@nghialt](nghialt@vng.com.vn) for giving me a chance to submit the assignment late.

## Problem statement

### Requirements

#### Context

Write a program for a coffee shop.

#### Requirements

- A beverage can be added with many topping
- Order statuses can be sent to chat apps (telegram, zalo, ...)
- Bill can be printed or sent to chat apps (telegram, zalo, ...)

### Analysis

- For the first requirement, I used **Decorator Pattern** to manage the toppings and original beverages.
- However, Decorator Pattern can not control how many and which toppings can be added to a beverage, so I used **Abstract Factory** to control the amount and type of toppings that can be added.
- For the second requirement, I used **State Pattern** to help users know the status of the beverage-making process.
- For the last requirement, I used **Strategy Pattern** to choose the way status messages can be sent to the client.

### Solution

| ![](https://i.imgur.com/to6pqn1.png) |
|:---:|
| UML for the Coffee Shop |