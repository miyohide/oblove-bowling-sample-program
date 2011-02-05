package bowling;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
    }

    static public int score(int[] pins) {
        int rval = 0;
        boolean beforeStrike = false;
        boolean beforeSpare = false;
        for (int i = 0 ; i < pins.length ; i++) {
            // 最終フレームの最後の投球はボーナスを考慮しない
            if (i == pins.length - 1) {
                rval += pins[i];
                break;
            }
            if (i >= 2 && i % 2 == 0) {
                if (pins[i - 2] == 10) {
                    beforeStrike = true;
                } else if (pins[i - 2] + pins[i - 1] == 10) {
                    beforeSpare = true;
                }
            }
            if (beforeStrike) {
                rval += pins[i];
            }
            if (beforeSpare && i % 2 == 0) {
                rval += pins[i];
            }
            rval += pins[i];
            if (i % 2 == 1) {
                beforeStrike = beforeSpare = false;
            }
        }
        return rval;
    }

}
