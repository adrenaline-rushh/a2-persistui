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

We took around 5-6 hours to complete the assignment fully and then an additional 1-2 hours in trying different things 
with the assignment.

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

We tried running talkback and noticed that the texts for "Sixes rolled", "Total rolls" and all are extremely small in area
So, we increased the padding of the texts in order to have a better experience and a little bit bigger touch targets. So as to
make it easier to figure out approximate locations of all the small text fields.

We read the Android documentation and it read as follows:
```
When using an ImageView , ImageButton , CheckBox , or other View that conveys information graphically, 
use an android:contentDescription attribute to provide a content label for that View
```

This content label is used by Talkback to read aloud to the person who has turned on Talkback. However, since our die
value keeps on changing, we need to change the `contentDescription` every time we update the UI. Doing this, the program should work
perfectly even with talkback on.

### Running Accessibility Scanner

We created the UI with Accessibility in mind, so when we ran the accessibility scanner after creating the portrait and landscape,
we only found 1 issue, which was related to the foreground and background contrast ratio not being high enough for the red colour
So, we simply changed the colour to a more darker red and that issue went away.

### How testing was done?

We were trying for writing the unit tests before writing the code, and following a test-driven approach, but we could not get an idea
of how to write tests using mockito, so we started to write code for the `WalletViewModel`, and then once we got an idea on how
we had to write unit tests, then we started testing.

We found Mockito a little bit difficult to understand, but once we understood how mockito works and what mocking exactly is, after understanding
that, we did not have too many issues with implementing it in unit tests. However, we still could not do it for integration tests because we could not 
understand how to Inject the mock into a class object present in `Wallet Activity`.

### Pair Programming

Pair programming rating - 4/5
We did Pair Programming to quite a good extent this time, due to time constraints we also divided the work, Yash was constantly reviewing
and also simultaneously helping with writing code and testing as well, Aaditya was writing most of the code logic and also wrote the unit tests 
and tried writing integration tests which we could not complete however.

### Assignment Difficulty

Assignment difficulty: 6/10
We did not find the implementation of ViewModel or Toast to be too difficult, however, we did face quite
a lot of issues with Mockito which were difficult to resolve and understand. Other than that, the assignment
went quite smoothly.