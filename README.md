# Mobiquity inc - Packer challenge

by Waddah Ajaj ( waddah.ajaj@gmail.com )

## Introduction
This assignment is part of the recruitment process for Mobiquity inc. The goal is to write a software that finds the optimal list of items to include in a bag with a weight limit. The items have properties such as index number, weight and cost. For each list of items and bag maximum weight, we find the best list of items which offer the maximum cost below the allowed weight. If different sets of items share the same cost, we choose the ones with least weight.

## Algorithm
The problem is a typical representation of that of a 0/1 Knapsack problem. While the most effective solutions for that problem are normally implemented using dynamic programming, we can't use it here because the weight is a real number instead of an integer, which means we can't iterate through a list of weight intervals. Since the number of items in the list is fairly small (<=15 items), I opted instead for a brute force algorithm. What the algorithm does is to create all possible subsets of the initial list (power subsets), and check for the one with the maximum value below the maximum weight. Although some optimizations could be made to that algorithm (like checking before hand which items could not be possibly included, thus scaling down the initial list), but for this test purposes, the current implementation should be fine.


This algorithm has complexity = O(2^n), because we have to check all combinations of items and calculate each one's cost.
 
## Project structure
The project is structured in a simple way that allows as much flexibility and specialization for each component (i.e. separation of concerns) as possible. The general structure of the program is as follows:

**data**: This package contains the POJOs for Item and PackageItem
**engine**: The engine is the "brain" of the program, i.e. it contains the algorithm which will be applied on the data
**service**: The service package contains the services used in the software, which in this case contains the file service
**factory**: The factory classes follow the Factory design pattern, which means they are responsible for creating and instantiating other classes.
**utils**: This package contains static utils classes, which perform specific actions.

In addition to the core classes, we have the jUnit tests, which cover most the classes and methods within them using predefined sets of data.

#### Test cases

       1. 81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
       2.  8 : (1,15.3,€34)
       3. 75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
       4. 56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)

Expected Results:
   
    4
    -
    2,7
    8,9
