import java.util.LinkedList;
import java.util.List;

public class Person {
    List<Weapon> weapons;
    List<Inventory> inventory;

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }
}

 class PersonBuilder {

     List<Weapon> weapons;
     List<Inventory> inventory;

     public PersonBuilder() {
         weapons = new LinkedList<>();
         inventory = new LinkedList<>();
     }

     public PersonBuilder addGun() {
         weapons.add(new MakarovGun());
         return this;
    }
     public PersonBuilder addKnife() {
         weapons.add(new Knife());
         return this;
     }
     public PersonBuilder addRifle() {
         weapons.add(new Rifle());
         return this;
     }

     public PersonBuilder addBomb() {
         inventory.add(new Bomb());
         return this;
     }
     public PersonBuilder addBodyArmor() {
         inventory.add(new BodyArmor());
         return this;
     }
     public PersonBuilder addGrenade() {
         inventory.add(new Grenade());
         return this;
     }
     public PersonBuilder addSapperSet() {
         inventory.add(new SapperSet());
         return this;
     }


     public Person build() {
         Person person = new Person();
         person.setInventory(inventory);
         person.setWeapons(weapons);
         return person;
     }
 }

 class PlayerFactory  {
    public static Person createTerrorist() {
        return new PersonBuilder().addGun().addKnife().addGrenade().addBomb().build();
    }
     public static Person createСommandos() {
         return new PersonBuilder().addRifle().addKnife().addGrenade().addBodyArmor().addSapperSet().build();
     }
     public static Person createРostage() {
         return new PersonBuilder().build();
     }
}

 abstract class Inventory {
}


 abstract class Weapon {
    public double getDamaged() { return 0; }
}

 abstract class Gun extends Weapon {

     public abstract double getCountBullets();
 }
class MakarovGun extends Gun {
    @Override
    public double getDamaged() { return 10; }

    @Override
    public double getCountBullets() {
        return 10;
    }
}
class Rifle extends Weapon {}
class Knife extends Weapon {}

class Bomb extends Inventory {}
class Grenade extends Inventory {}
class BodyArmor extends Inventory {}
class SapperSet extends Inventory {}

class GunMuffler extends Weapon{
    public GunMuffler(Gun basic) {
        this.basic = basic;
    }

    private final Gun basic;

    @Override
    public double getDamaged() { return getDamaged() *.9; }

}