class rectangle:
    def __init__(self,x,y,w,h):
        '''initialises a new rectangle whose top left corner is (x,y) coordinates with width w and height h'''
        
        self.x = x
        self.y = y 
        self.w = w 
        self.h = h 
        # if self.h < 0 or self.w < 0:
        #     myError = ValueError('Value should be a positive number')
        #     raise myError

    def get_height(self):
        return self.h

    def get_width(self):
        return self.w

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y

    def set_height(self,height):
        self.h = height
        if self.h < 0:
            myError = ValueError('Height should be a positive number')
            raise myError

    def set_width(self,width):
        self.w = width
        if self.w < 0:
            myError = ValueError('Width should be a positive number')
            raise myError

    def set_x(self,x):
        self.x = x

    def set_y(self,y):
        self.y = y

    def __str__(self):
        print("Rectangle[x="+ str(self.x)+",y="+ str(self.y)+",width="+ str(self.w) + ",height="+str(self.h)+"]")

    def contains(self,my_x,my_y):
        if self.x < my_x and self.y > my_y:
            return True
        return False
    def intersection(self,rect):
        w1 = rect.get_width()
        h1 = rect.get_height()
        x1 = rect.get_x()
        y1 = rect.get_y()
        #a is width, b is length
        a = abs(self.x - x1)
        b = abs(self.y - y1)
        area = a * b
        return area

    def union(self,rect):
        w1 = rect.get_width()
        h1 = rect.get_height()
        x1 = rect.get_x()
        y1 = rect.get_y()
        a = min(self.x,x1)
        b = max(self.x+self.w,x1 + w1)
        my_width = b - a
        c = min(self.y-self.h,y1-h1)
        my_length = a - c
        area = my_length*my_width
        return area

    def __eq__(self, rect):
        w1 = rect.get_width()
        h1 = rect.get_height()
        x1 = rect.get_x()
        y1 = rect.get_y()
        if (self.x == x1) and (self.y == y1) and (self.w == w1) and (self.h == h1):
            return True
        return False
            
# rectangle1 = rectangle(2,3,6,5)
# rectangle2 = rectangle(3,8,7,8)
# rectangle3 = rectangle(18,12,17,11)
# rectangle4 = rectangle(2,3,6,5)
# rectangle5 = rectangle
# rectangle.set_x(rectangle5,8)
# rectangle.set_y(rectangle5,6)
# rectangle.set_width(rectangle5,7)
# rectangle.set_height(rectangle5,5)
# rectangle.__str__(rectangle2)

# print(rectangle1.union(rectangle2))
# print(rectangle1.intersection(rectangle2))
# print(rectangle1.intersection(rectangle3))
# print(rectangle1.__eq__(rectangle4))
# (rectangle1.contains(3,4))
