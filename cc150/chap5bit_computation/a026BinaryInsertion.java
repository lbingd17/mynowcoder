import java.util.*;

public class BinInsert {
    public int binInsert(int n, int m, int j, int i) {
		int put = m << j;//signed left shift
		int res = n|put;
    	return res;
    }
}
//http://www.nowcoder.com/questionTerminal/30c1674ad5694b3f8f0bc2de6f005490
