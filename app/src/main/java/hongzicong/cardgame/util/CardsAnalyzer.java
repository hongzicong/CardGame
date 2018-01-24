package hongzicong.cardgame.util;

import java.util.Vector;

import hongzicong.cardgame.view.Desk;
import hongzicong.cardgame.view.Player;

/**
 * Created by Dv00 on 2018/1/24.
 */

public class CardsAnalyzer {

    private int[] cards;

    //数字牌
    private int[] countCards = new int[12];
    private int count2;

    private Vector<int[]> card_danzhang = new Vector<int[]>(4);
    private Vector<int[]> card_yidui = new Vector<int[]>(4);
    private Vector<int[]> card_sange = new Vector<int[]>(4);
    private Vector<int[]> card_zashun = new Vector<int[]>(4);
    private Vector<int[]> card_tonghuashun = new Vector<int[]>(4);
    private Vector<int[]> card_tonghuawu = new Vector<int[]>(4);
    private Vector<int[]> card_sige = new Vector<int[]>(4);

    public int[] getCountPokes() {
        return countCards;
    }
    public int getCount2() {
        return count2;
    }

    public Vector<int[]> getCard_danzhang() {
        return card_danzhang;
    }

    public Vector<int[]> getCard_yidui() {
        return card_yidui;
    }

    public Vector<int[]> getCard_sange() {
        return card_sange;
    }

    public Vector<int[]> getCard_zashun() {
        return card_zashun;
    }

    public Vector<int[]> getCard_tonghuashun() {
        return card_tonghuashun;
    }

    public Vector<int[]> getCard_tonghuawu() {
        return card_tonghuawu;
    }

    public Vector<int[]> getCard_sige() { return card_sige; }

    private CardsAnalyzer() {
    }

    public static CardsAnalyzer getInstance() {
        return new CardsAnalyzer();
    }

    private void init() {
        for(int i = 0; i < countCards.length; i++) {
            countCards[i] = 0;
        }
        count2 = 0;
        card_danzhang.clear();
        card_yidui.clear();
        card_sange.clear();
        card_tonghuashun.clear();
        card_zashun.clear();
        card_tonghuawu.clear();
        card_sige.clear();
    }

    public boolean lastCardTypeEq(int pokeType) {
        if(remainCount() > 1) {
            return false;
        }
        switch (pokeType) {
            case CardsType.sange:
                return card_sange.size() == 1;
            case CardsType.yidui:
                return card_yidui.size() == 1;
            case CardsType.danzhang:
                return card_danzhang.size() == 1;
        }
        return false;
    }

    public int[] getPokes() {
        return cards;
    }

    public void setPokes(int[] pokes) {
        CardsManager.sort(pokes);
        this.cards = pokes;
        try {
            //todo
            //this.analyze();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int remainCount() {
        return card_danzhang.size() + card_yidui.size() + card_sange.size() +
                card_tonghuashun.size() + card_zashun.size() + card_tonghuawu.size();
    }


    public int[] getMinType(Player last, Player next) {
        CardsAnalyzer lastAna = CardsAnalyzer.getInstance();
        lastAna.setPokes(last.cards);

        CardsAnalyzer nextAna = CardsAnalyzer.getInstance();
        nextAna.setPokes(next.cards);

        int needSmart = -1;
        if (Desk.boss == next.playerId || (Desk.boss != next.playerId && Desk.boss != last.playerId)) {

        }
        //todo
        return  cards;
    }
}
