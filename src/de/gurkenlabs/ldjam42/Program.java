package de.gurkenlabs.ldjam42;

import java.awt.Font;
import java.awt.event.KeyEvent;

import de.gurkenlabs.ldjam42.gui.IngameScreen;
import de.gurkenlabs.ldjam42.gui.MenuScreen;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.Resources;
import de.gurkenlabs.litiengine.gui.GuiProperties;
import de.gurkenlabs.litiengine.input.Input;

public class Program {
  public static final Font GUI_FONT = Resources.getFont("marquee moon.ttf").deriveFont(48f);

  /**
   * The main entry point for the GOIN club.
   * 
   * @param args
   */
  public static void main(String[] args) {
    Game.getInfo().setVersion("v0.0.1");
    Game.getInfo().setName("GO IN");
    Game.getInfo().setSubTitle("Behave or GET LOST!");

    Game.init(args);

    initGoin();
    Game.start();
  }

  private static void initGoin() {
    // init default UI settings
    GuiProperties.setDefaultFont(GUI_FONT);

    Game.getScreenManager().addScreen(new MenuScreen());
    Game.getScreenManager().addScreen(new IngameScreen());

    Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> {
      System.exit(0);
    });
  }
}
