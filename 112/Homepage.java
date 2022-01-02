package com.example.willherojavafxproject;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class Homepage implements Initializable, Serializable {
    private FxmlLoader fxmlLoader;
    private transient FadeTransition fadeTransition1;
    private transient FadeTransition fadeTransition2;
    private transient FadeTransition fadeTransition3;
    private ArrayList<String> playerName;
    private HashMap<String, ArrayList<Game>> allPlayersSavedGames;
    private Player player;
    private File f;
    private SettingsPageView settingsPageView;
    private Game game;

    public  Homepage(Player player) throws IOException {
        settingsPageView = new SettingsPageView(this);
        f = new File("SavedGames.txt");
        f.createNewFile();
        allPlayersSavedGames = new HashMap<>();
        this.player = player;
        playerName = new ArrayList<>();
        fadeTransition1 = new FadeTransition();
        fadeTransition2 = new FadeTransition();
        fadeTransition3 = new FadeTransition();
        game = new Game(player, this);
        fxmlLoader = new FxmlLoader();
    }

    @FXML
    private  transient ImageView playButton;

    @FXML
    private  transient ImageView settingsButton;


    @FXML
    private  transient ImageView loadGame;

    @FXML
    private  transient Label myLabel;

    @FXML
    private  transient ListView<?> myList;

    @FXML
    private  transient Button myLoadButton;

    @FXML
    void playTheGame(MouseEvent event) {
        if(game.getPausedGame()){
            player = new Player(player.getMyName());
            game = new Game(player, this);
            settingsPageView = new SettingsPageView(this);
        }
        game.playGame();

    }


    @FXML
    void goToSettings(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("SettingsPageView", settingsPageView, "SettingsPageView"));
    }

    @FXML
    void showTheRank(MouseEvent event) {   /// here i am thinking to show the pop up menu rather then the
        HelloApplication.setDifferentScene(fxmlLoader.getScene("ranks"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fadeTransition1 = new FadeTransition();
        fadeTransition2 = new FadeTransition();
        fadeTransition3 = new FadeTransition();
        fadeTransition1.setDuration(Duration.millis(1000));
        fadeTransition1.setToValue(1);
        fadeTransition1.setNode(playButton);
        fadeTransition2.setDuration(Duration.millis(1000));
        fadeTransition2.setToValue(1);
        fadeTransition2.setNode(settingsButton);
        fadeTransition3.setDuration(Duration.millis(1000));
        fadeTransition3.setToValue(1);
        fadeTransition3.setNode(loadGame);
        fadeTransition1.play();
        fadeTransition2.play();
        fadeTransition3.play();
    }


    @FXML
    void loadGamePage(MouseEvent event) throws IOException {
        this.fetchData();
        LoadGamePage loadGamePage = new LoadGamePage(allPlayersSavedGames.get(player.getMyName()), this);
        HelloApplication.setDifferentScene(fxmlLoader.getScene("loadGame", loadGamePage, "LoadGamePage"));

    }



    public void save() throws IOException, ClassNotFoundException {
        this.fetchData();
        game.askPositionToStoreCoordinates();
        if(allPlayersSavedGames.get(player.getMyName())==null){
            ArrayList<Game> arrayList = new ArrayList<>();
            arrayList.add(game);
            allPlayersSavedGames.put(player.getMyName(), arrayList);
        }else{
            allPlayersSavedGames.get(player.getMyName()).add(game);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
            objectOutputStream.writeObject(allPlayersSavedGames);
        }catch (Exception e){}

    }

    public void fetchData() throws IOException {
        if(Files.size(Paths.get("SavedGames.txt"))!=0){
            FileInputStream fileInputStream = new FileInputStream(f);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                allPlayersSavedGames = (HashMap<String, ArrayList<Game>>) objectInputStream.readObject();
//                objectInputStream.
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
        }
    }

    public void load(String dateSelected){
        Game gameOld = null;
        ListIterator<Game> listIterator = allPlayersSavedGames.get(player.getMyName()).listIterator();
        while (listIterator.hasNext()){
            gameOld = listIterator.next();
            if(gameOld.getDateOfGamePlayed().equals(dateSelected)){
                break;
            }
        }
        game = gameOld;
        game.setLoadedGame(true);
        player = game.getPlayer();
        //game.askPositionToReviveEverything();
        game.playGame();
    }

    public Game getGame(){
        return game;
    }

    public interface Movement{
        public void move();
    }

}
