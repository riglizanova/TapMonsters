package main;
/**
 * @author Joyce
 *
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice.Screen;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
public class SequenceScreen extends Screen implements KeyListener{

	public static int sequencex = 50;
	public static int playerx = 50;
	public static int y = 50;
	public static int w = 50;
	public static int h = 50;
	
	public int playery = y+100;

	private static Sequence s = new Sequence(10);
	private static ArrayList<String> playerMatch = new ArrayList<String>();
	private static ArrayList<Graphic> displayedSequence = new ArrayList<Graphic>();
	
	private static Graphic playerChoice; 
	private static TextLabel text;
	private static int idx = 0;
	private static int ctr = 0;
	
	public SequenceScreen(int width, int height) {
		super(width, height);
	}
	
	public void addToDisplayedSequence(int numOfTimes){
			for (int i = 0; i < numOfTimes; i++){
				if (s.getSequence().get(idx) == 0){
					displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowUp.png"));
					playerMatch.add("W");
				}
				if (s.getSequence().get(idx) == 1){
					displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowRight.png"));
					playerMatch.add("D");
				}
				if (s.getSequence().get(idx) == 2){
					displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowDown.png"));
					playerMatch.add("S");
				}
				if (s.getSequence().get(idx) == 3){
					displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowLeft.png"));
					playerMatch.add("A");
				}
				sequencex+=60;
				if (idx < s.getSequence().size() ) idx++;
		}
	}
	
	public void addToViewObjects(int l){
		for(int i = 0 ; i < l; i++){
			viewObjects.add(displayedSequence.get(0));
			displayedSequence.remove(0);
		}
	}
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		int length = 4;
		System.out.println(s.getSequence());
		addToDisplayedSequence(length);
		addToViewObjects(length);
	}

	public void keyPressed(KeyEvent e) {
		if (playerChoice != null) remove(playerChoice);
		if (e.getKeyCode() == KeyEvent.VK_W){
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowUp.png");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_D){
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowRight.png");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_S){
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowDown.png");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_A){
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowLeft.png");
			addObject(playerChoice);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (!playerMatch.isEmpty()){
			if (Character.toLowerCase(playerMatch.get(0).charAt(0)) == Character.toLowerCase(e.getKeyChar())){
				playerMatch.remove(0);
				viewObjects.remove(0);
				for (int i = 0; i < viewObjects.size() -1; i++){
						viewObjects.get(i).setX(viewObjects.get(i).getX() - 60);
					}
				sequencex = sequencex - 60;
				if(idx < s.getSequence().size()){
					addToDisplayedSequence(1);
					addToViewObjects(1);
				}
				ctr++;
				if (ctr == s.getSequence().size()){
					System.out.println("You've won!");
				}
			}else{
				System.out.println("Wrong");
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
	public KeyListener getKeyListener(){
		return this;
	}
}
