package lection_first.lambda.patterns.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Oleg on 20.11.2016.
 */
//strategy
@FunctionalInterface
interface Weapon {
    void damage (Hero hero);
}

class Sword implements Weapon{

    @Override
    public void damage(Hero hero) {
        hero.setHealth(hero.getHealth() - 10);
    }
}

class Laser implements Weapon{

    @Override
    public void damage(Hero hero) {
        hero.setHealth(hero.getHealth() - 15);
    }
}

class Hero {

    private final String name;
    private Integer health = 100;
    private Weapon weapon = new Sword();

    public Hero(String name) {
        this.name = name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void damage (Hero hero){
        weapon.damage(hero);
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void printHealth(){
        if (health > 0) {
            System.out.println(name + " health: " + health);
        } else {
            System.out.println(name + " is dead");
        }
    }
}

public class StrategyPattern{

    public static void main(String[] args) throws IOException {
        Hero obi = new Hero("Obi Wan");
        obi.setWeapon(hero -> hero.setHealth(hero.getHealth() - 100));

        Hero dart = new Hero("Dart Sitius");
        dart.damage(obi);
        obi.printHealth();

        while (dart.getHealth() > 0){
            obi.damage(dart);
            dart.printHealth();
        }
    }
}
