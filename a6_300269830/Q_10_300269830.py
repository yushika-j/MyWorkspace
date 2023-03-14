from math import sqrt


class my_lovely_circle:
    def __init__(self,x,y,radius):
        self.x = x
        self.y = y
        self.radius = radius
    
    # def __repr__(self):
    #     print("my_lovely_circle"+(self.x,self.y,self.radius))
    #     print("Area is " + str(self.getArea())  + "Perimeter is "+ str(self.getperimeter()))
    def getx(self):
        return self.x
    def gety(self):
        return self.y
    def getradius(self):
        return self.radius
    def setx(self,value):
        self.x = value
    def sety(self,value):
        self.y = value
    def setradius(self,value):
        self.radius = value
    def getArea(self):
        return (22/7)*(self.radius**2)
    def getperimeter(self):
        """Returns the perimeter of the circle."""
        return 2*(22/7)*self.radius
    def containsPoint(self,my_x,my_y):
        '''(tuple)-> (boolean)
        returns true if the point (x,y) is inside the circle'''
        if (self.x < my_x) and (self.y > my_y):
            return True
        return False
    import math
    def contains(self,other):
        '''(tuple)-> (boolean)
        returns true if the other circle is inside the circle'''
        # if (self.x < other.x) and (self.y > other.y):
        #     return True
        # return False
        distance = sqrt((other.x-self.x)**2) + ((other.y-self.y) ** 2)
        ans = self.radius > (distance + other.radius)
        return ans
    def overlaps(self,other):
        if (other.getx() - self.x)**2 +(other.gety()-self.y)**2 <= self.r**2:
            return True
        return False
# c1 = my_lovely_circle(2,2,5.5)
# print(c1)
# (c1.getArea)
