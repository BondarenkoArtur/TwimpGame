package ga.uabart.twimp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import ga.uabart.twimp.Helpers.IrcHelper;
import ga.uabart.twimp.Helpers.JsonHelper;
import ga.uabart.twimp.Objects.People;
import ga.uabart.twimp.Screens.GameScreen;

public class TwimpGame extends Game{

    public People people = new People(this);
    public JsonHelper jsonHelper = new JsonHelper(this);

    IrcHelper ircHelper = new IrcHelper(this);


	@Override
	public void create () {
        people.reloadPeople(jsonHelper);
        setScreen(new GameScreen(this));
    }


    public void render(){
        super.render();
        handleInput();
    };


    private void handleInput() {
        if (Gdx.input.justTouched()){
            people.addPers();
        }
    }

}
