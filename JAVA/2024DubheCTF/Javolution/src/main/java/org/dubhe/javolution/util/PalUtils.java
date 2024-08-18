package org.dubhe.javolution.util;

import org.dubhe.javolution.model.Element;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;
import java.util.Random;

public class PalUtils
{
    public static int randomizeStat(int baseStat) {
        double variation = new Random().nextDouble() * 0.2 + 0.9;
        return (int) (baseStat * variation);
    }
    public static double elementAdvantage(Element attacker, Element defender) {
        double rate = 1.5;
        boolean isAdvantage = false;
        switch (attacker) {
            case FIRE:
                isAdvantage = (defender == Element.GRASS|| defender == Element.ICE);
                break;
            case GRASS:
                isAdvantage = defender == Element.GROUND;
                break;
            case GROUND:
                isAdvantage = defender == Element.ELECTRIC;
                break;
            case ELECTRIC:
                isAdvantage = defender == Element.WATER;
                break;
            case WATER:
                isAdvantage = defender == Element.FIRE;
                break;
            case ICE:
                isAdvantage = defender == Element.DRAGON;
                break;
            case DRAGON:
                isAdvantage = defender == Element.DARK;
                break;
            case DARK:
                isAdvantage = defender == Element.NEUTRAL;
                break;
            case HACKER:
                isAdvantage = true;
                break;
        }
        return isAdvantage ? rate : 1;
    }

    public static Object base64Deserialize(String base64)
    {
        try {
            byte[] decoded = Base64.getDecoder().decode(base64);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decoded);
            ObjectInputStream objInput = new ObjectInputStream(byteArrayInputStream);
            return objInput.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
