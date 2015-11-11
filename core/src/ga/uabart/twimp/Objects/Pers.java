package ga.uabart.twimp.Objects;

public class Pers {
    private String _id;
    private int __v;
    private String name;
    private int money;
    private int exp;

    public Pers() {
        this.name = "Player";
    }

    public Pers(String name) {
        this.name = name;
        money = 0;
        exp = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (money >= 1000){
            money -= 1000;
            this.name = name;
        }
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public int getExp() {
        return exp;
    }

    public void addExp(int exp) {
        this.exp += exp;
    }
}
