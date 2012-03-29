package com.partkyle.blacktriangle.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import com.partkyle.blacktriangle.core.BlackTriangle;

public class BlackTriangleHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assets().setPathPrefix("blacktriangle/");
    PlayN.run(new BlackTriangle());
  }
}
