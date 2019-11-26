/*
compact: good
*/

#include <cstdlib>
#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
    unsigned int sum = 0;
    for(int i = 1; i < 1000; i++){
        if(!(i % 3) || !(i % 5)) {
            //std::cout << "found : " << i << " sum : " << sum << "\n";
            sum += i;}
    }        
    std::cout << sum << "\n";
    system("PAUSE");
    return EXIT_SUCCESS;    
    //return 0;
}

