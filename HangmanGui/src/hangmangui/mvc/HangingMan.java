package hangmangui.mvc;

import javax.swing.ImageIcon;

//this Class returns image icons for the Hangman graphic according to the number of Lives in the current gameModel

public class HangingMan {

    Model gameModel;
    String zersLives = "/hangman/Images/hangman_0Lives.png";
    String oneLive = "/hangman/Images/hangman_1Lives.png";
    String twoLives = "/hangman/Images/hangman_1Lives.png";
    String threeLives = "/hangman/Images/hangman_2Lives.png";
    String fourLives = "/hangman/Images/hangman_3Lives.png";
    String fiveLives = "/hangman/Images/hangman_4Lives.png";
    String sixLives = "/hangman/Images/hangman_5Lives.png";

    public HangingMan(Model gameModel) {
        this.gameModel = gameModel;
    }

    public ImageIcon updateHangmanGraphic() {

        switch (gameModel.getLivesLeft()) {
            case 0:
                gameModel.setLivesLeft(0);
                return new javax.swing.ImageIcon(getClass().getResource("/hangman/Images/hangman_0Lives.png"));
            case 1:
                gameModel.setLivesLeft(1);
                return new javax.swing.ImageIcon(getClass().getResource("/hangman/Images/hangman_1Lives.png"));

            case 2:
                gameModel.setLivesLeft(2);
                return new javax.swing.ImageIcon(getClass().getResource("/hangman/Images/hangman_2Lives.png"));
            case 3:
                gameModel.setLivesLeft(3);
                return new javax.swing.ImageIcon(getClass().getResource("/hangman/Images/hangman_3Lives.png"));
            case 4:
                gameModel.setLivesLeft(4);
                return new javax.swing.ImageIcon(getClass().getResource("/hangman/Images/hangman_4Lives.png"));
            case 5:
                gameModel.setLivesLeft(5);
                return new javax.swing.ImageIcon(getClass().getResource("/hangman/Images/hangman_5Lives.png"));
            case 6:
                gameModel.setLivesLeft(6);
                return new javax.swing.ImageIcon(getClass().getResource("/hangman/Images/hangman_6Lives.png"));
        }
        return null;

    }
}