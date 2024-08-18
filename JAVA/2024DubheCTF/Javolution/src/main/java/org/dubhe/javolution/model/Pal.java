package org.dubhe.javolution.model;

import java.io.Serializable;
import static org.dubhe.javolution.util.PalUtils.*;

public class Pal implements Serializable
{
    private int id;
    private String name;
    private int level;
    private Element element;
    private int hp;
    private int attack;
    private int defense;
    public Pal(int id, String name, int level, Element element, int hp, int attack, int defense)
    {
        this.id = id;
        this.name = name;
        this.level = level;
        this.element = element;
        this.hp = randomizeStat(hp);
        this.attack = randomizeStat(attack);
        this.defense = randomizeStat(defense);
    }

    @Override
    public String toString()
    {
        return "Pal{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", level=" + level +
                ", element=" + element +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        if (level > this.level) {
            this.level = level;
        }
    }

    public Element getElement()
    {
        return element;
    }

    public void setElement(Element element)
    {
        this.element = element;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        if (hp <= this.level*200) {
            this.hp = hp;
        }
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int attack)
    {
        if (attack <= this.level*20) {
            this.attack = attack;
        }
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense)
    {
        if (defense <= this.level*20)
        {
            this.defense = defense;
        }
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
