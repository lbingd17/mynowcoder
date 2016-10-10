import java.util.*;

public class BinDecimal {
    public String printBin(double num) {
        if (num < 0 || num > 1)
            return "Error";

        StringBuilder sb = new StringBuilder().append("0.");
        for (int i = 2; i < 32; i++) {
            num *= 2;
            if (num > 1) {
                num -= 1;
                sb.append('1');
            } else if (num < 1) {
                sb.append('0');
            } else {
                sb.append('1');
                return sb.toString();
            }
        }

        return "Error";
    }
}
