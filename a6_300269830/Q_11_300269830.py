def falafel(J,M):#
    '''(str,str)->bool
    returns true if M contains at least one or more common characters in J'''
    J = J.strip()
    M = M.strip()
    Jset = set(J)
    Mset = set(M)
    intersect = Jset.intersection(Mset)
    for i in list(intersect):
        if J.count(i) <= M.count(i):
            return True
    return False
