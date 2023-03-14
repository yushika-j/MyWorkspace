# exercice 2

somme(1,1).
somme(N,T):- N>1, somme(N+1,T1), T1 is T+N.

# exercice 3
factoriel(0,1).
factoriel(N,Result) :- N > 0, N1 is N-1, factoriel(N1,Result1), Result is N * Result1.
combinaisons(a,b,c):- factoriel(a,b)