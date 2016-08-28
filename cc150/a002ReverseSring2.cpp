class Reverse {
public:
    string reverseString(string iniString) {
        int i,j;
        for(i= 0,j= iniString.length()-1; i<j; i++,j--)  
          iniString[i]^= iniString[j]^= iniString[i]^= iniString[j];//交换
        return iniString;
    }
};
