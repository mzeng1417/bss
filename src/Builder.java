import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Class for building and setting up the GUI
 *
 * Mike Zeng
 * Pre-release 1
 */

public class Builder extends JPanel
{
    private JFrame GUI;
    private JProgressBar loadingBar;
    private JButton start;
    private JButton rules;
    private JButton load;
    private JButton exit;
    private JButton[][] battleshipControls;
    private JButton[][] battleshipAttackSquares;
    private JButton levelButton;
    private JLabel background;
    private JLabel timer;
    private JLabel ships;
    private JButton start2;
    private int level = 0;
    private ImageIcon[] startButtonPictures = {new ImageIcon(getClass().getResource("startGame.png")),new ImageIcon(getClass().getResource("startGameMouseHovering.png")),new ImageIcon(getClass().getResource("startGameClicked.png"))};
    private ImageIcon[] loadButtonPictures = {new ImageIcon(getClass().getResource("loadGame.png"))};
    private ImageIcon[] rulesButtonPictures = {new ImageIcon(getClass().getResource("rules.png"))};
    private ImageIcon[] levelButtonPictures = {new ImageIcon(getClass().getResource("boardSizeButton3x3.png")),new ImageIcon(getClass().getResource("boardSizeButton5x5.png")),new ImageIcon(getClass().getResource("boardSizeButton7x7.png")),new ImageIcon(getClass().getResource("boardSizeButton9x9.png"))};
    private ImageIcon[] backgrounds = {new ImageIcon(getClass().getResource("MainBackground.png")),new ImageIcon(getClass().getResource("startingGameScreen.png")),new ImageIcon(getClass().getResource("PlayingBackground.png"))};
    private ImageIcon logo = new ImageIcon(getClass().getResource("MZSZLogo.png"));
    private int backgroundID = 0;
    private JButton singleMulti;
    private JButton start3;

    //temporary debug code
    public static void main(String[] args) {
        new Builder().setUp();
    }

    public void setUp() {
        int loaded = 0;

        GUI = new JFrame("Battleship");
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setSize(1000,630);
        GUI.setVisible(true);
        GUI.setResizable(false);
        GUI.setLocationRelativeTo(null);
        GUI.setIconImage(logo.getImage());

        Builder battleship = new Builder();
        battleship.setLayout(null);
        battleship.setBounds(0,0,1000,600);

        GUI.add(battleship);

        //Jprogress bar or smth

        start = new JButton(startButtonPictures[0]);
        start.setVisible(false);
        start.setBounds(300,340,400,50);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToPlayScreen();
            }
        });
        battleship.add(start);

        load = new JButton(backgrounds[1]);//reductant code to solve a very strange bug
        load = new JButton(loadButtonPictures[0]);//icon load
        load.setVisible(false);
        load.setBounds(300,410,400,50);
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //load game
                //create a new BattleShip class with all the data
            }
        });
        battleship.add(load);

        rules = new JButton(backgrounds[1]);
        rules.setIcon(rulesButtonPictures[0]);
        rules.setVisible(false);
        rules.setBounds(300,480,400,50);
        rules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showRules();
            }
        });
        battleship.add(rules);

        exit = new JButton();
        exit.setVisible(false);
        exit.setBounds(800,0,200,50);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                defaultScreen();
            }
        });
        battleship.add(exit);

        levelButton = new JButton(levelButtonPictures[0]);
        battleship.add(levelButton);
        levelButton.setVisible(false);
        levelButton.setBounds(300,175,400,50);
        levelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(level<3) {
                    level++;
                }else{
                    level = 0;
                }
                levelButton.setIcon(levelButtonPictures[level]);
            }
        });

        start3 = new JButton();
        battleship.add(start3);
        start3.setBounds(300,300,400,50);
        start3.setVisible(false);
        start3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(level);
            }
        });

        background = new JLabel(backgrounds[0]); //*
        background.setBounds(0,0,1000,600);
        battleship.add(background);

        start.setVisible(true);
        load.setVisible(true);
        rules.setVisible(true);

    }

    public void defaultScreen() {
        background.setIcon(backgrounds[0]);
        level=0;

        start.setVisible(true);
        rules.setVisible(true);
        load.setVisible(true);
        start3.setVisible(false);
        levelButton.setVisible(false);
        levelButton.setIcon(levelButtonPictures[0]);
        exit.setVisible(false);

    }

    public void startGame(int gridSize) {
        background.setIcon(backgrounds[2]);
        levelButton.setVisible(false);
        start3.setVisible(false);

        if(gridSize == 0) {
            //start 3x3
        }else if(gridSize == 1) {
            //start 5x5
        }else if(gridSize == 2) {
            //start 7x7
        }else{
            //start 9x9
        }
        //change background
    }

    public void goToPlayScreen() {

        start.setVisible(false);
        rules.setVisible(false);
        load.setVisible(false);

        start3.setVisible(true);

        levelButton.setVisible(true);
        exit.setVisible(true);

        background.setIcon(backgrounds[1]);
    }

    public void showRules() {
        exit.setVisible(true);

        start.setVisible(false);
        rules.setVisible(false);
        load.setVisible(false);
        //show the rules
    }

    public void turnArrayButtons(boolean on,int dim) {
        for(int i=0;i<dim;i++) {
            for(int j=0;j<dim;i++) {
                battleshipControls[i][j].setVisible(on);
            }
        }
        for(int i=0;i<dim;i++) {
            for(int j=0;j<dim;i++) {
                battleshipAttackSquares[i][j].setVisible(on);
            }
        }
    }




}


