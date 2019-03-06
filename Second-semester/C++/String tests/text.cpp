#include <iostream>
using namespace std;

int main()
{
    //getline(cin, variable); gets a full line of string
    
    string text = "yeah ok this is a text";
    
    cout << "This is a string: " << text << endl;

    text[0] = 'S'; //Replaces the character at index 0 with S
    cout << "Modified string: " << text << endl;

    cout <<"text word index: " << text.find("text") << endl;

    string sub = text.substr(8, 9);
    cout << "Substring starting from 8 and taking 9 characters: " << sub << endl;

    return 0;
}