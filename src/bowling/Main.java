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
        for (int i = 0; i < pins.length ; i++) {
            if (i < 16) {
                // 第8フレームまでの処理
                if (i % 2 == 0 && pins[i] == 10) {
                    rval += pins[i + 2];
                    if (pins[i + 2] == 10) {
                        rval += pins[i + 4];
                    } else {
                        rval += pins[i + 3];
                    }
                } else if(i % 2 == 0 && pins[i] + pins[i + 1] == 10) {
                    rval += pins[i + 2];
                }
            } else if (i < 18) {
                // 第9フレームの処理
                if (i % 2 == 0 && pins[i] == 10) {
                    rval += pins[i + 2] + pins[i + 3];
                } else if(i % 2 == 0 && pins[i] + pins[i + 1] == 10) {
                    rval += pins[i + 2];
                }
            } else {
                // 第10フレームの処理は3投の合計のみとなる。
            }
            rval += pins[i];
        }
        return rval;

    }

}
