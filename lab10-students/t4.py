class Point:
    def __init__(self, xcoord=0, ycoord=0):
        self.x = xcoord
        self.y = ycoord
    def __repr__(self):
        return 'Point('+str(self.x)+','+str(self.y)+')'

def riddle(a,b):
    a=b
    a.x=1000
    a.y=1000
    
p1=Point(1,2)
p2=Point(10,20)
print(p1,p2)
riddle(p1,p2)
print(p1, p2)
