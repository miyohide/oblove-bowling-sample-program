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

}