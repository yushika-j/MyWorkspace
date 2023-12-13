// This function calculates the sum of two integers.
// Parameters:
// - num1: the first integer
// - num2: the second integer
// Returns:
// The sum of num1 and num2.
int calculateSum(int num1, int num2) {
    return num1 + num2;
}
// c++ practice
# include <iostream>
using namespace std;

int main() {
    int x = 10;
    int y = 20;
    int ref = x;
    int *ptr1 = &x;
    int **ptr2 = &ptr1;
    std:: cout << "x = " << x << endl;
    std:: cout << "ptr = " << ptr1 << endl;
    std:: cout << "ptr2 = " << ptr2 << endl;

    *ptr1 = 20;
    std:: cout << "x = " << x << endl;
    **ptr2 = 30;
    std:: cout << "x = " << x << endl;
    ref = y;
    std:: cout << "ref = " << ref << endl;
    return 0;
}