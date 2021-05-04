package clientname.mods.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import clientname.gui.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class ModCPS extends ModDraggable {

	private List<Long> clicks = new ArrayList<Long>();
	private boolean wasPressed;
	private long lastPressed;
	
	private List<Long> clicks2 = new ArrayList<Long>();
	private boolean wasPressed2;
	private long lastPressed2;

	@Override
	public int getWidth() {
		return 59;
	}

	@Override
	public int getHeight() {
		return 15;
	}

	@Override
	public void render(ScreenPosition pos) {
		final boolean lpressed = Mouse.isButtonDown(0);
		final boolean rpressed = Mouse.isButtonDown(1);
		
		// LMB
		if(lpressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis() + 10;
			this.wasPressed = lpressed;
			if(lpressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		
		// RMB
		if(rpressed != this.wasPressed2) {
			this.lastPressed2 = System.currentTimeMillis() + 10;
			this.wasPressed2 = rpressed;
			if(rpressed) {
				this.clicks2.add(this.lastPressed2);
			}
		}
		
		GuiScreen.drawRect(pos.getAbsoluteX()/1 + 1, pos.getAbsoluteY()/1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, new Color(0, 0, 0, 150).getRGB());
		font.drawString(getCPS() + " §7|§f " + getCPS2(),  pos.getAbsoluteX() + 18, pos.getAbsoluteY() + 4, -1);
		
	}
	
	// LMB
	private int getCPS() {
		final long time = System.currentTimeMillis();
		this.clicks.removeIf(aLong -> aLong + 1000 < time);
		return this.clicks.size();
	}
	
	// RMB
	private int getCPS2() {
		final long time2 = System.currentTimeMillis();
		this.clicks2.removeIf(aLong2 -> aLong2 + 1000 < time2);
		return this.clicks2.size();
	}

	@Override
	public void renderDummy(ScreenPosition pos) {
		
		final boolean lpressed = Mouse.isButtonDown(0);
		final boolean rpressed = Mouse.isButtonDown(1);
		
		if(lpressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis() + 10;
			this.wasPressed = lpressed;
			if(lpressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		
		if(rpressed != this.wasPressed2) {
			this.lastPressed2 = System.currentTimeMillis() + 10;
			this.wasPressed2 = rpressed;
			if(rpressed) {
				this.clicks2.add(this.lastPressed2);
			}
		}
		
		GuiScreen.drawRect(pos.getAbsoluteX()/1 + 1, pos.getAbsoluteY()/1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, new Color(0, 0, 0, 150).getRGB());
		font.drawString(getCPS() + " §7|§f " + getCPS2(),  pos.getAbsoluteX() + 18, pos.getAbsoluteY() + 4, -1);
		
	}
}
