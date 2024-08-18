package org.dubhe.javolution.service;

import org.dubhe.javolution.model.Element;
import org.dubhe.javolution.model.Pal;
import org.dubhe.javolution.util.PalUtils;
import java.util.HashMap;
import java.util.Map;
import static org.dubhe.javolution.util.PalUtils.*;

public class PalService
{
    private Pal player;
    private static final Map<String, Pal> palDeck = new HashMap<>();

    static {
        Pal flag = new Pal(999, "flag{fake}", 99, Element.HACKER, 99999, 999, 999);
        Pal jetragon = new Pal(111, "Jetragon", 50, Element.DRAGON, 10000, 950, 700);
        Pal grizzbolt = new Pal(103, "Grizzbolt", 30, Element.ELECTRIC, 5000, 630, 400);
        Pal mammorest = new Pal(90, "Mammorest", 20, Element.GRASS, 3500, 350, 400);
        Pal depresso = new Pal(17, "Depresso", 10, Element.DARK, 1500, 200, 100);
        Pal lamball = new Pal(1, "Lamball", 1, Element.NEUTRAL, 500, 100, 50);

        palDeck.put("flag", flag);
        palDeck.put("jetragon", jetragon);
        palDeck.put("grizzbolt", grizzbolt);
        palDeck.put("mammorest", mammorest);
        palDeck.put("depresso", depresso);
        palDeck.put("lamball", lamball);
    }

    public PalService()
    {
        this.player = new Pal(0, "ctfer", 1, Element.HACKER, 1000, 200, 200);
    }

    public Pal getPal(String name) {
        return palDeck.get(name.toLowerCase());
    }

    public void levelUp(int targetLevel) {
        if (targetLevel > this.player.getLevel()) {
            player.setLevel(targetLevel);
        }
    }
    public Pal getPlayer() {
        return player;
    }
    public void setPlayer(Pal player) {
        this.player = player;
    }
    public String showPal() {
        return player.toString();
    }
    public void genPal(String data) {
        Pal newPal =(Pal) PalUtils.base64Deserialize(data);
        if (newPal != null) {
            player = newPal;
        }
        else {
            player = new Pal(0, "ctfer", 50, Element.HACKER, 1000, 200, 200);
        }
    }
    public int battle(Pal player,Pal opponent)
    {
        int mydamage = Math.max((player.getAttack() - opponent.getDefense()), 0);
        int opponentdamage = Math.max((opponent.getAttack() - player.getDefense()), 0);
        double myPower = mydamage * player.getHp() * elementAdvantage(player.getElement(), opponent.getElement());
        double opponentPower = opponentdamage * opponent.getHp();
        return (int) (myPower - opponentPower);
    }

}
