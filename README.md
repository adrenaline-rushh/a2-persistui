[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/tI1Hnuga)
# A2-PersistUI

This android app, "Dice games", is a gambling game, where you roll a dice and you earn or lose coins according to the following rules:
1. If you roll a 6, you get 5 coins
2. If you roll 2 sixes in a row, you will get 10 coins for the second six.
3. If you roll any other number in a row, you lose 5 coins.

## Collaborators
Yash Yelmame (2020A7PS1224G), Email: f20201224@goa.bits-pilani.ac.in

Aaditya Raghavan (2020A3PS1251G), Email: f20201251@goa.bits-pilani.ac.in

## About the Assignment

### How were the tasks completed?

1. First, we implemented the interface for Die in the class Die6, and implemented the `roll` and `value` methods.
2. Next, we moved on to the `WalletViewModel` and calculated the following statistics:
    * `currentBalance` - shows the number of coins earned till now.
    * `numSingleSixes` - shows the number of total sixes rolled.
    * `numTotalRolls` - shows the number of times the die has been rolled.
    * `numDoubleSixes` - shows the number of times two sixes in a row have been rolled.
    * `numDoubleOthers` - shows the number of times a number other than 6 has been rolled twice in a row.
    * `previousRollValue` - shows the previous value on the die.
3. We now wrote the unit test cases for `WalletViewModel` and fixed all issues which were causing the testcases to fail.
4. We then created the portrait and landscape UIs and fixed all accessibility scanner issues that were found.
5. We then integrated the UI with `WalletViewModel` using `WalletActivity`, Such that on button click the dice is rolled and UI 
is updated.
6. Now, we also added a few things to `WalletActivity`
    * Toast message is displayed everytime a 6 is rolled.
    * when `OnCreate()` is called, we check if there is any instance of ViewModel already present
    * We also added some "suspense", that is there is a delay when the dice is rolled and it does not roll instantaneously.

### Running TalkBack

### Running Accessibility Scanner

We created the UI with Accessibility in mind, so when we ran the accessibility scanner after creating the portrait and landscape,
we only found 1 issue, which was related to the foreground and background contrast ratio not being high enough for the red colour
So, we simply changed the colour to a more darker red and that issue went away.

### How testing was done?

### Pair Programming

### Assignment Difficulty