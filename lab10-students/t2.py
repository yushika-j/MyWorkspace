class Point:
    def __init__(self, xcoord=0, ycoord=0):
        self.x = xcoord
        self.y = ycoord


a = Point(-1, 1)
b = Point(3, 3)
a=b
a.x = 1

print(a.x, a.y, b.x, b.y)

