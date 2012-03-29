package com.partkyle.blacktriangle.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.partkyle.blacktriangle.core.BlackTriangle;

public class BlackTriangleActivity extends GameActivity {

  @Override
  public void main(){
    platform().assets().setPathPrefix("com/partkyle/blacktriangle/resources");
    PlayN.run(new BlackTriangle());
  }
}
