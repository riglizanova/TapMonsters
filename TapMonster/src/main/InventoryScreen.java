package main;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;
import guiPractice.ClickableScreen;
import guiPractice.components.TextArea;
import guiPractice.components.Visible;

public class InventoryScreen extends ClickableScreen implements Runnable{
	
	private TextArea title;
	private ArrayList<Artifact> artifacts;
	private Graphics2D g;

	public InventoryScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void run() {
		g.drawRect(100, 100, 100, 100);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		title = new TextArea(40,85,700,25, "Inventory");
		viewObjects.add(title);
	}

}
