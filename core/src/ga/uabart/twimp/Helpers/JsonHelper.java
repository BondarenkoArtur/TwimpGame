package ga.uabart.twimp.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.*;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import ga.uabart.twimp.Objects.Pers;
import ga.uabart.twimp.TwimpGame;

import java.util.ArrayList;

public class JsonHelper {

    TwimpGame game;

    String res;

    ArrayList<Pers> people;

    public JsonHelper(TwimpGame game) {
        this.game = game;
    }

    String JSON_URL = "http://twimp-uabart.c9users.io/resources";

    public void sendToFile(Object o){
        Json json = new Json();
        json.toJson(o, Gdx.files.local("test.json"));
    }

    public void sendPers(Pers pers){
        Json json = new Json();
        json.setUsePrototypes(false);
        json.setOutputType(JsonWriter.OutputType.json);
        HttpRequest httpPost = new HttpRequest(HttpMethods.POST);
        httpPost.setUrl(JSON_URL);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setContent(json.toJson(pers));
        Gdx.net.sendHttpRequest (httpPost, new HttpResponseListener() {

            @Override
            public void handleHttpResponse(HttpResponse httpResponse) {
                Gdx.app.log(this.getClass().toString(), httpResponse.getResultAsString());
            }

            @Override
            public void failed(Throwable t) {
                Gdx.app.log(this.getClass().toString(), "failed: " + t.toString());
            }

            @Override
            public void cancelled() {
                Gdx.app.log(this.getClass().toString(), "cancelled");
            }
        });
    }

    public ArrayList<Pers> receivePers(){
        people = new ArrayList<Pers>();

        HttpRequest httpGet = new HttpRequest(HttpMethods.GET);
        httpGet.setUrl(JSON_URL);

        Gdx.net.sendHttpRequest (httpGet, new HttpResponseListener() {

            @Override
            public void handleHttpResponse(HttpResponse httpResponse) {
                res = httpResponse.getResultAsString();
                Json json = new Json();
                Gdx.app.log(this.getClass().toString(), res);
                people = json.fromJson(ArrayList.class, Pers.class, res);
                game.people.setPeople(people);
            }

            @Override
            public void failed(Throwable t) {
                Gdx.app.log(this.getClass().toString(), "failed: " + t.toString());
            }

            @Override
            public void cancelled() {
                Gdx.app.log(this.getClass().toString(), "cancelled");
            }
        });

        return people;
    }


}
