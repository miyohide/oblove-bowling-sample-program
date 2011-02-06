package bowling;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
/*
    @Test
    // Problem 1. スペアやストライクによるボーナスは考慮しない
    public void testScore() {
        int[] pins = {1,4,2,8,5,0,10,0,0,4,5,5,2,0,6,1,10,0,10,5,5};
        int expResult = 83;
        int result = Main.score(pins);
        assertEquals(expResult, result);
    }
*/
    @Test
    // Problem 2. スペアやストライクを考慮する
    public void testScore() {
        int[] pins = {1,4,2,8,5,0,10,0,0,4,5,5,2,0,6,1,10,0,10,5,5};
        int expResult = 109;
        int result = Main.score(pins);
        assertEquals(expResult, result);
    }

    @Test
    // ストライクの時。次のフレームでは1回目に1ピン、2回目で0ピンの場合
    public void testScore_strike_first() {
        int[] pins = {10,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int act = Main.score(pins);
        assertEquals(12, Main.score(pins));
    }

    @Test
    // ストライクの時。次のフレームでは1回目に0ピン、2回目で1ピンの場合
    public void testScore_strike_second() {
        int[] pins = {10,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int act = Main.score(pins);
        assertEquals(12, Main.score(pins));
    }

    @Test
    // ストライクの時。次のフレームでは1回目に1ピン、2回目で0ピンの場合、
    // さらに次のフレームでピンを倒したとき
    public void testScore_strike_3rdFrame1() {
        int[] pins = {10,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int act = Main.score(pins);
        assertEquals(13, Main.score(pins));
    }

    @Test
    // ストライクの時。次のフレームでは1回目に1ピン、2回目で0ピンの場合、
    // さらに次のフレームでピンを倒したとき
    public void testScore_strike_3rdFrame2() {
        int[] pins = {10,0,1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int act = Main.score(pins);
        assertEquals(14, Main.score(pins));
    }

    @Test
    // スペアの時。次のフレームでは1回目に1ピン、2回目で0ピンの場合
    public void testScore_spare_first() {
        int[] pins = {2,8,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int act = Main.score(pins);
        assertEquals(12, Main.score(pins));
    }

    @Test
    // スペアの時。次のフレームでは1回目に1ピン、2回目で0ピンの場合
    // 次の次のフレームでピンを倒したとき
    public void testScore_spare_3rdFrame1() {
        int[] pins = {2,8,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int act = Main.score(pins);
        assertEquals(13, Main.score(pins));
    }

    @Test
    // スペアの時。次のフレームでは1回目に1ピン、2回目で0ピンの場合
    // 次の次のフレームでピンを倒したとき
    public void testScore_spare_3rdFrame2() {
        int[] pins = {2,8,1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int act = Main.score(pins);
        assertEquals(14, Main.score(pins));
    }

    @Test
    // 10フレームにて、10ピン、0ピン、0ピンの場合
    public void testScore_10thFrame1() {
        int[] pins = {1,4,2,8,5,0,10,0,0,4,5,5,2,0,6,1,10,0,10,0,0};
        int expResult = 94;
        int result = Main.score(pins);
        assertEquals(expResult, result);
    }

    @Test
    // 10フレームにて、10ピン、5ピン、0ピンの場合
    public void testScore_10thFrame2() {
        int[] pins = {1,4,2,8,5,0,10,0,0,4,5,5,2,0,6,1,10,0,10,5,0};
        int expResult = 104;
        int result = Main.score(pins);
        assertEquals(expResult, result);
    }

    @Test
    // 問題3。途中でも計算できるようにする。第1フレーム、1投目
    public void testScore_1stFrame1() {
        Main m = new Main();
        m.bowl(1);
        assertEquals(1,m.score());
    }

    @Test
    // 問題3。途中でも計算できるようにする。第1フレーム、2投目
    public void testScore_1stFrame2() {
        Main m = new Main();
        m.bowl(1);
        m.bowl(2);
        assertEquals(3,m.score());
    }

    @Test
    // 問題3。途中でも計算できるようにする。第2フレーム、1投目、前フレームスペア
    public void testScore_2ndFrame1_spare() {
        Main m = new Main();
        m.bowl(1);
        m.bowl(9);
        m.bowl(2);
        assertEquals(14,m.score());
    }

    @Test
    // 問題3。途中でも計算できるようにする。第2フレーム、2投目、前フレームスペア
    public void testScore_2ndFrame2_spare() {
        Main m = new Main();
        m.bowl(1);
        m.bowl(9);
        m.bowl(2);
        m.bowl(3);
        assertEquals(17,m.score());
    }

    @Test
    // 問題3。途中でも計算できるようにする。第2フレーム、1投目、前フレームスペア（0 -> 10)
    public void testScore_2ndFrame1_spare0to10() {
        Main m = new Main();
        m.bowl(0);
        m.bowl(10);
        m.bowl(2);
        assertEquals(14,m.score());
    }

    @Test
    // 問題3。途中でも計算できるようにする。第2フレーム、2投目、前フレームスペア（0 -> 10)
    public void testScore_2ndFrame2_spare0to10() {
        Main m = new Main();
        m.bowl(0);
        m.bowl(10);
        m.bowl(2);
        m.bowl(3);
        assertEquals(17,m.score());
    }

    @Test
    // 問題3。途中でも計算できるようにする。第2フレーム、1投目、前フレームストライク
    public void testScore_2ndFrame1_strike() {
        Main m = new Main();
        m.bowl(10);
        m.bowl(2);
        assertEquals(14,m.score());
    }

    @Test
    // 問題3。途中でも計算できるようにする。第2フレーム、2投目、前フレームストライク
    public void testScore_2ndFrame2_strike() {
        Main m = new Main();
        m.bowl(10);
        m.bowl(2);
        m.bowl(3);
        assertEquals(20,m.score());
    }

    @Test
    // 問題3。 全ゲーム
    public void testScore_FullFrame() {
        Main m = new Main();
        int[] pins = {1,4,2,8,5,0,10,0,4,5,5,2,0,6,1,10,10,5,5};
        for (int pin : pins) {
            m.bowl(pin);
        }
        int a = m.score();
        assertEquals(109, m.score());
    }


}