import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

import java.util.Objects;

/**
 * Project 4 Assembly Silos
 * This is to build Assembly Silos that take in their own code. An input is
 * sent in and the silos process their code together 1 line at a time (until all silos are
 * done with that line) then continue on until an output is achieved.
 *
 * This file is the Transfer Region Class
 */

public class TransferRegion implements Runnable {
    protected String upTemp = " ",leftTemp = " ", rightTemp = " ", downTemp = " ";
    protected String up = " ", left = " ", right = " ", down = " ";
    private final Label upLabel = new Label();
    private final Label leftLabel = new Label();
    private final Label rightLabel = new Label();
    private final Label downLabel = new Label();

    /**
     * This is the Transfer Region Class
     */
    TransferRegion(){
        this.up = " ";
        this.left = " ";
        this.right = " ";
        this.down = " ";
    }

    /**
     * This will grab the up arrow of the transfer region, return it and clear it.
     * @return The data in the up arrow
     */
    String getUp(){
        if (this.upTemp.matches(" ")){
            return " ";
        }
        else {
            String temp = this.upTemp;
            this.upTemp = " ";
            return temp;
        }
    }

    /**
     * This will grab the left arrow of the transfer region, return it and clear it.
     * @return The data in the left arrow
     */
    String getLeft(){
        if (this.leftTemp.matches(" ")){
            return " ";
        }
        else {
            String temp = this.leftTemp;
            this.leftTemp = " ";
            return temp;
        }
    }

    /**
     * This will grab the right arrow of the transfer region, return it and clear it.
     * @return the data of the right arrow
     */
    String getRight(){
        if (this.rightTemp.matches(" ")){
            return " ";
        }
        else {
            String temp = this.rightTemp;
            this.rightTemp = " ";
            return temp;
        }
    }

    /**
     * This will grab the down arrow of the transfer region, return it and clear it.
     * @return The data in the down arrow
     */
    String getDown(){
        if (this.downTemp.matches(" ")){
            return " ";
        }
        else {
            String temp = this.downTemp;
            this.downTemp = " ";
            return temp;
        }
    }

    /**
     * This puts a value in the Up position
     * @param s The String being put UP
     */

    /**
     * This puts a value in the Up position
     * @param s The String being put UP
     */
    void addUp(String s){
        this.up = s;
    }

    /**
     * This puts a value in the LEFT position
     * @param s The String being put LEFT
     */
    void addLeft(String s){
        this.left = s;
    }

    /**
     * This puts a value in the RIGHT position
     * @param s The String being put RIGHT
     */
    void addRight(String s){
        this.right = s;
    }

    /**
     * This puts a value in the DOWN position
     * @param s The String being put DOWN
     */
    void addDown(String s){
        this.down = s;
    }

    /**
     * Method called that changes the temp value to be the actual value
     * after a step is run in order to prevent concurrency issues
     */
    void updateValue() {
        if (!Objects.equals(up, " ")) {
            upTemp = up;
        }
        if (!Objects.equals(down, " ")) {
            downTemp = down;
        }
        if (!Objects.equals(left, " ")) {
            leftTemp = left;
        }
        if (!Objects.equals(right, " ")) {
            rightTemp = right;
        }
    }

    /**
     * THis is to get the Node for the Transfer region for the GUI
     * @return The border Pane Node made
     */
    BorderPane getNode(){
        BorderPane outerPane = new BorderPane();

        upLabel.setAlignment(Pos.CENTER);
        outerPane.setTop(upLabel);
        outerPane.setAlignment(upLabel, Pos.CENTER);

        leftLabel.setAlignment(Pos.CENTER);
        outerPane.setLeft(leftLabel);
        outerPane.setAlignment(leftLabel, Pos.CENTER);

        rightLabel.setAlignment(Pos.CENTER);
        outerPane.setRight(rightLabel);
        outerPane.setAlignment(rightLabel, Pos.CENTER);

        downLabel.setAlignment(Pos.CENTER);
        outerPane.setBottom(downLabel);
        outerPane.setAlignment(downLabel, Pos.CENTER);

        refreshFX();
        return outerPane;
    }

    /**
     * This is to update the FX of the transfer region for the GUI
     */
    void refreshFX(){
        String upText = "⬆  " + up;
        upLabel.setText(upText);
        if(up.equals(" ")){upLabel.setStyle("-fx-text-fill: #dc9656;");}
        else{upLabel.setStyle("-fx-text-fill: #a1b56c;");}

        String leftText = left + "\n⬅";
        leftLabel.setText(leftText);
        if(left.equals(" ")){leftLabel.setStyle("-fx-text-fill: #dc9656;");}
        else{leftLabel.setStyle("-fx-text-fill: #a1b56c;");}


        String rightText = "➡\n" + right;
        rightLabel.setText(rightText);
        if(right.equals(" ")){rightLabel.setStyle("-fx-text-fill: #dc9656;");}
        else{rightLabel.setStyle("-fx-text-fill: #a1b56c;");}


        String downText = down + "  ⬇";
        downLabel.setText(downText);
        if(right.equals(" ")){downLabel.setStyle("-fx-text-fill: #dc9656;");}
        else{downLabel.setStyle("-fx-text-fill: #a1b56c;");}

    }

    /**
     * When the transfer region thread is run it does the work
     * of updating the value of the transfer region
     */
    @Override
    public void run() {
        updateValue();
    }
}