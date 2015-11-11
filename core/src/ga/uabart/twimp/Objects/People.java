package ga.uabart.twimp.Objects;

import com.badlogic.gdx.math.MathUtils;
import ga.uabart.twimp.Helpers.JsonHelper;
import ga.uabart.twimp.TwimpGame;

import java.util.ArrayList;

public class People {
    private TwimpGame game;
    private ArrayList<Pers> people;

    public People(TwimpGame game) {
        this.game = game;
    }

    public People(ArrayList<Pers> people) {
        this.people = people;
    }

    public People() {
        people = new ArrayList<Pers>();
    }

    public ArrayList<Pers> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Pers> people) {
        this.people = people;
    }

    public void reloadPeople(JsonHelper jsonHelper) {
        ArrayList<Pers> peopleTemp = jsonHelper.receivePers();
        this.people = peopleTemp;
    }

    public void addPers() {
        Pers pers = new Pers("Bot " + MathUtils.random(100, 999));
        pers.addMoney(MathUtils.random(1,50)*100);
        pers.addExp(MathUtils.random(1,20));
        game.jsonHelper.sendPers(pers);
        this.reloadPeople(game.jsonHelper);
    }

    public void addPers(String name) {
        Pers pers = new Pers(name);
        game.jsonHelper.sendPers(pers);
        this.reloadPeople(game.jsonHelper);
    }


}
