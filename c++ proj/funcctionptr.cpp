#include <iostream>
using namespace std;

typedef int (*FunctionPtr)(int, int); // Define FunctionPtr type

int Add(int a, int b) {
    return a + b;
}

int Subtract(int a, int b) {
    return a - b;
}

int Multiply(int a, int b) {
    return a * b;
}

int main() {
    FunctionPtr functionArray[3];
    functionArray[0] = &Add;
    functionArray[1] = &Subtract;
    functionArray[2] = &Multiply;
    
    // Define functions
    int a = 10;
    int b = 20;
    int result = Multiply(a, b); // Calls the Add function
    
    cout << "Result: " << result << endl;
    
    return 0;
}