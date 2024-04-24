def get_length(dna):
    """ (str) -> int

    Return the length of the DNA sequence dna.

    >>> get_length('ATCGAT')
    6
    >>> get_length('ATCG')
    4
    """
    if dna == '':
            return 0
    else:
        return len(dna)
    

def is_longer(dna1, dna2):
    """ (str, str) -> bool

    Return True if and only if DNA sequence dna1 is longer than DNA sequence
    dna2.

    >>> is_longer('ATCG', 'AT')
    True
    >>> is_longer('ATCG', 'ATCGGA')
    False
    """
    if len(dna1) > len(dna2):
        return True
    else:
         return False


def count_nucleotides(dna, nucleotide):
    """ (str, str) -> int

    Return the number of occurrences of nucleotide in the DNA sequence dna.

    >>> count_nucleotides('ATCGGC', 'G')
    2
    >>> count_nucleotides('ATCTA', 'G')
    0
    """
    count = 0
    for i in range(len(dna)):
        
        if dna[i] == nucleotide:
            count = count + 1
    return count


def contains_sequence(dna1, dna2):
    """ (str, str) -> bool

    Return True if and only if DNA sequence dna2 occurs in the DNA sequence
    dna1.

    >>> contains_sequence('ATCGGC', 'GG')
    True
    >>> contains_sequence('ATCGGC', 'GT')
    False

    """
    if dna2 in dna1:
        return True
    else:
        return False
    
def is_valid_sequence(dna):
    """ (str) -> bool

    Return True if and only if the DNA sequence is valid (that is, it contains no characters other than 'A', 'T', 'C' and 'G').

    >>> is_valid_sequence('ATCGGC')
    True
    >>> is_valid_sequence('ATCGGZ')
    False
    """
    valid = True
    for char in dna:
        if char not in 'ATCG':
            valid = False
    return valid

def insert_sequence(dna1, dna2, index):
    """ (str, str, int) -> str"""
    myDNA = ""
    if (len(dna1) == 0):
        myDNA = dna2
    else:
        myDNA = dna1[0:index] + dna2 + dna1[index:]

    return myDNA
def get_complement(dna):
    for i in range(len(dna)):
            if dna[i] == 'T':
                dna = dna[:i] + 'A' + dna[i+1:]
            elif dna[i] == 'A':
                dna = dna[:i] + 'T' + dna[i+1:]
            elif dna[i] == 'G':
                dna = dna[:i] + 'C' + dna[i+1:]
            elif dna[i] == 'C':
                dna = dna[:i] + 'G' + dna[i+1:]
    return dna

def get_complementary_sequence(dna):
    '''(str) -> (str)'''
    #T changes to A and G changes to C
    for i in range(len(dna)):
        if dna[i] == 'T':
            dna = dna[:i] + 'A' + dna[i+1:]
        elif dna[i] == 'A':
            dna = dna[:i] + 'T' + dna[i+1:]
        elif dna[i] == 'G':
            dna = dna[:i] + 'C' + dna[i+1:]
        elif dna[i] == 'C':
            dna = dna[:i] + 'G' + dna[i+1:]
    return dna
