class Point:
    def __init__(self, xcoord=0, ycoord=0):
        self.x = xcoord
        self.y = ycoord


def riddle(x, p):
    x=x+7
    return x + p.x + p.y

x = 5
blank = Point(1, 2)
t =riddle(x, blank)
print(x, t, blank.x, blank.y)



