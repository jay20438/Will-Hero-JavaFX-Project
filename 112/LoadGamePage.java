package com.example.willherojavafxproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class LoadGamePage implements Initializable, Serializable {
    private ArrayList<Game> playerSavedGames;
    private String selectedItem;
    private Homepage homepage;
    private FxmlLoader fxmlLoader;

    @FXML
    private transient Label myLabel;

    @FXML
    private transient ListView<String> myList;

    @FXML
    private transient Button myLoadButton;


    @FXML
    private transient ImageView homepageButton;

    public LoadGamePage(ArrayList<Game> playerSavedGames, Homepage homepage){
        fxmlLoader = new FxmlLoader();
        this.playerSavedGames = playerSavedGames;
        this.homepage = homepage;
    }




    @FXML
    void goToHomepage(MouseEvent event) {
        HelloApplication.setDifferentScene(fxmlLoader.getScene("homepage", homepage, "Homepage"));
    }

    @FXML
    void loadGame(MouseEvent event) {
        if(myLabel.getText().equals("Select the Game")){
            if(playerSavedGames == null){
                myLabel.setText("No Games yet Saved!");
            }else{
                myLabel.setText("please select the item first!");
            }
        }else{
            homepage.load(myLabel.getText());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (playerSavedGames!=null) {
                ListIterator<Game> listIterator = playerSavedGames.listIterator();
                while (listIterator.hasNext()) {
                    Game game = listIterator.next();
                    myList.getItems().add(game.getDateOfGamePlayed());
                }

                myList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                    selectedItem = myList.getSelectionModel().getSelectedItem();
                    myLabel.setText(selectedItem);
                }
            });
        }
    }


}