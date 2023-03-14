Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> 
============== RESTART: C:\Users\yushi\Music\lab7-students\lab7.py =============
>>> #TESTING QUESTION 5.16
>>> print(indexes("mississipi","i"))
[1, 4, 7, 9]
>>> print(indexes("mississipi","s"))
[2, 3, 5, 6]
>>> print(indexes("mississipi","m"))
[0]
>>> print(indexes("mississipi","a"))
[]
>>> 
>>> #TESTING QUESTION 5.17
>>> print(doubles([3,0,1,2,3,6,2,4,5,6,5]))
2
6
4
None
>>> print(doubles([3,6,10,1,2,3,6,2,4,5,10]))
2
6
4
10
None
>>> 
>>> #TESTING QUESTION 5.18
>>> print(four_letter(['dog','stop','door','bus','dust']))
['stop', 'door', 'dust']
None
>>> print(four_letter(['rock','door','bus','dust','cars']))
['rock', 'door', 'dust', 'cars']
None
>>> 
>>> #TESTING QUESTION 5.19
>>> print(inBoth([3,2,5,4,7],[9,0,1]))
False
>>> print(inBoth([3,2,5,4,7],[9,0,1,3]))
True
>>> 
>>> #TESTING QUESTION 5.20
>>> print(intersect([3,2,5,4,7,9],[9,0,1,5]))
[5, 9]
>>> print(intersect([3,2,5,4,7],[9,0]))
[]
>>> print(intersect([3,2,5,4,7,9],[9,0,1,5,2,4]))
[2, 5, 4, 9]
>>> 
>>> #TESTING QUESTION 5.21
>>> print(pair([2,3,4],[5,7,9,12],9))
2 7
4 5
None
>>> print(pair([0,2,3,4],[5,7,9,12],7))
0 7
2 5
None
>>> 
>>> #TESTING QUESTION 5.22
>>> print(pairSum([7,8,5,3,4,6],11))
0 4
1 3
2 5
None
>>> print(pairSum([7,8,5,3,4,6,5],10))
0 3
2 2
2 2
None
>>> 
>>> #TESTING QUESTION 5.29
>>> print(LastFirst(['Gerber, Len','Fox, Kate','Dunn, Bob']))
[['Len', 'Kate', 'Bob'], ['Gerber', 'Fox', 'Dunn']]
>>> print(LastFirst(['Wilson, Alan','Fox, Emma','Smith, Joe']))
[['Alan', 'Emma', 'Joe'], ['Wilson', 'Fox', 'Smith']]
>>> 
>>> #TESTING QUESTION 5.30
>>> print(subsetSum([5,4,10,20,15,19],10))
False
>>> print(subsetSum([5,4,10,20,15,19],29))
True
>>> print(subsetSum([5,4,10,20,15,19],30))
True
>>> 
>>> #TESTING QUESTION 5.33
>>> print(mystery(11))
3
>>> print(mystery(4))
2
>>> print(mystery(290))
8
>>> print(mystery(1024))
10
>>> 
>>> #TESTING QUESTION 5.46
>>> print(inversions('DCBA'))
6
>>> print(inversions('DCABGK'))
5
>>> print(inversions('ABCE'))
0
>>> #TESTING QUESTION 5.48
>>> print(sublist([15,50,20],[20,15,30,50,1,100]))
True
>>> print(sublist([15,50,20],[20,15]))
False
>>> 