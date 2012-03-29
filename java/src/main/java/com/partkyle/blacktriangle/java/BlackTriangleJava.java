package com.partkyle.blacktriangle.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.partkyle.blacktriangle.core.BlackTriangle;

public class BlackTriangleJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assets().setPathPrefix("com/partkyle/blacktriangle/resources");
    PlayN.run(new BlackTriangle());
  }
}
