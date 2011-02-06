package bowling;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
    }

    private int bowlIndex = 0;
    private int[] scoreLog = new int[21];
    private boolean beforeStrike = false;
    private boolean beforeSpare = false;

    public Main() {
        // スコアの初期化
        for (int i = 0; i < scoreLog.length ; i++){
            scoreLog[i] = 0;
        }
    }

    // 与えられたピンの数に対して現在のスコアを計算する
    public void bowl(int pins) {
        scoreLog[bowlIndex] = pins;
        bowlIndex++;
        if (bowlIndex > 2*9) {
            // 10ピン倒しても何もしない
        } else if (pins == 10 && bowlIndex % 2 == 1) {
            scoreLog[bowlIndex] = 0;
            bowlIndex++;
        }
    }

    public int score() {
        return score(scoreLog);
    }

    // 与えられた配列に対してスコアを計算する
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
