package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.Timer _timer = null;
public static anywheresoftware.b4a.objects.MediaPlayerWrapper _sound = null;
public static anywheresoftware.b4a.objects.MediaPlayerWrapper _coin = null;
public static anywheresoftware.b4a.objects.MediaPlayerWrapper _bgmusic = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnplay = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblscore = null;
public static byte _r1 = (byte)0;
public static byte _r2 = (byte)0;
public static byte _r3 = (byte)0;
public static byte _r4 = (byte)0;
public static byte _r5 = (byte)0;
public static byte _m1 = (byte)0;
public static byte _m2 = (byte)0;
public static int _score = 0;
public static byte _lives = (byte)0;
public static byte _time = (byte)0;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltime = null;
public b4a.example.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
 //BA.debugLineNum = 41;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 42;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 43;BA.debugLine="sound.Initialize";
_sound.Initialize();
 //BA.debugLineNum = 44;BA.debugLine="coin.Initialize";
_coin.Initialize();
 //BA.debugLineNum = 45;BA.debugLine="bgMusic.Initialize";
_bgmusic.Initialize();
 //BA.debugLineNum = 47;BA.debugLine="Activity.Title = \"\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 49;BA.debugLine="sound.Load(File.DirAssets, \"Hit_Hurt8.wav\")";
_sound.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Hit_Hurt8.wav");
 //BA.debugLineNum = 50;BA.debugLine="coin.Load(File.DirAssets, \"Pickup_Coin65.wav\")";
_coin.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Pickup_Coin65.wav");
 //BA.debugLineNum = 51;BA.debugLine="bgMusic.Load(File.DirAssets, \"Arcade fast flow1.o";
_bgmusic.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Arcade fast flow1.ogg");
 //BA.debugLineNum = 53;BA.debugLine="bgMusic.Looping = True";
_bgmusic.setLooping(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 54;BA.debugLine="bgMusic.Play";
_bgmusic.Play();
 //BA.debugLineNum = 57;BA.debugLine="For Each btn As Button In Panel1";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
{
final anywheresoftware.b4a.BA.IterableList group11 = mostCurrent._panel1;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(group11.Get(index11)));
 //BA.debugLineNum = 58;BA.debugLine="btn.Enabled = False";
_btn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 59;BA.debugLine="btn.SetBackgroundImage(LoadBitmap(File.DirAssets";
_btn.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Placeholder.png").getObject()));
 }
};
 //BA.debugLineNum = 62;BA.debugLine="timer.Initialize(\"Timer\", 1000)";
_timer.Initialize(processBA,"Timer",(long) (1000));
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 72;BA.debugLine="bgMusic.Pause";
_bgmusic.Pause();
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 67;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 68;BA.debugLine="bgMusic.Play";
_bgmusic.Play();
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public static String  _btnplay_click() throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Private Sub btnPlay_Click";
 //BA.debugLineNum = 168;BA.debugLine="StartGame";
_startgame();
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public static String  _gameover() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
 //BA.debugLineNum = 155;BA.debugLine="Private Sub GameOver";
 //BA.debugLineNum = 156;BA.debugLine="timer.Enabled = False";
_timer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 157;BA.debugLine="btnPlay.Enabled = True";
mostCurrent._btnplay.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 159;BA.debugLine="For Each btn As Button In Panel1";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = mostCurrent._panel1;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(group3.Get(index3)));
 //BA.debugLineNum = 160;BA.debugLine="btn.Enabled = False";
_btn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 161;BA.debugLine="btn.Visible = True";
_btn.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 162;BA.debugLine="btn.SetBackgroundImage(LoadBitmap(File.DirAssets";
_btn.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Placeholder.png").getObject()));
 }
};
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public static String  _generatenum() throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Private Sub GenerateNum";
 //BA.debugLineNum = 110;BA.debugLine="r1 = 0";
_r1 = (byte) (0);
 //BA.debugLineNum = 111;BA.debugLine="r2 = 0";
_r2 = (byte) (0);
 //BA.debugLineNum = 112;BA.debugLine="r3 = 0";
_r3 = (byte) (0);
 //BA.debugLineNum = 113;BA.debugLine="r4 = 0";
_r4 = (byte) (0);
 //BA.debugLineNum = 114;BA.debugLine="r5 = 0";
_r5 = (byte) (0);
 //BA.debugLineNum = 115;BA.debugLine="m1 = 0";
_m1 = (byte) (0);
 //BA.debugLineNum = 116;BA.debugLine="m2 = 0";
_m2 = (byte) (0);
 //BA.debugLineNum = 118;BA.debugLine="Do Until (r1 <> r2 And r2 <> r3 And r3 <> r4 And";
while (!((_r1!=_r2 && _r2!=_r3 && _r3!=_r4 && _r4!=_r5 && _r5!=_m1 && _m1!=_m2))) {
 //BA.debugLineNum = 119;BA.debugLine="r1 = Rnd(0, 20)";
_r1 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (20)));
 //BA.debugLineNum = 120;BA.debugLine="r2 = Rnd(0, 20)";
_r2 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (20)));
 //BA.debugLineNum = 121;BA.debugLine="r3 = Rnd(0, 20)";
_r3 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (20)));
 //BA.debugLineNum = 122;BA.debugLine="r4 = Rnd(0, 20)";
_r4 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (20)));
 //BA.debugLineNum = 123;BA.debugLine="r5 = Rnd(0, 20)";
_r5 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (20)));
 //BA.debugLineNum = 124;BA.debugLine="m1 = Rnd(0, 20)";
_m1 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (20)));
 //BA.debugLineNum = 125;BA.debugLine="m2 = Rnd(0, 20)";
_m2 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (20)));
 }
;
 //BA.debugLineNum = 128;BA.debugLine="Log(r1 & \" \" & r2 & \" \" & r3 & \" \" & r4 & \" \" & r";
anywheresoftware.b4a.keywords.Common.LogImpl("4458775",BA.NumberToString(_r1)+" "+BA.NumberToString(_r2)+" "+BA.NumberToString(_r3)+" "+BA.NumberToString(_r4)+" "+BA.NumberToString(_r5)+" "+BA.NumberToString(_m1)+" "+BA.NumberToString(_m2),0);
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private btnPlay As Button";
mostCurrent._btnplay = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private lblScore As Label";
mostCurrent._lblscore = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private r1, r2, r3, r4, r5, m1, m2 As Byte";
_r1 = (byte)0;
_r2 = (byte)0;
_r3 = (byte)0;
_r4 = (byte)0;
_r5 = (byte)0;
_m1 = (byte)0;
_m2 = (byte)0;
 //BA.debugLineNum = 31;BA.debugLine="Private score As Int";
_score = 0;
 //BA.debugLineNum = 33;BA.debugLine="Private lives, time As Byte";
_lives = (byte)0;
_time = (byte)0;
 //BA.debugLineNum = 35;BA.debugLine="Private Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private lblTime As Label";
mostCurrent._lbltime = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 19;BA.debugLine="Private timer As Timer";
_timer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 20;BA.debugLine="Private sound, coin, bgMusic As MediaPlayer";
_sound = new anywheresoftware.b4a.objects.MediaPlayerWrapper();
_coin = new anywheresoftware.b4a.objects.MediaPlayerWrapper();
_bgmusic = new anywheresoftware.b4a.objects.MediaPlayerWrapper();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _startgame() throws Exception{
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
 //BA.debugLineNum = 132;BA.debugLine="Private Sub StartGame";
 //BA.debugLineNum = 134;BA.debugLine="score = 0";
_score = (int) (0);
 //BA.debugLineNum = 135;BA.debugLine="time = 40";
_time = (byte) (40);
 //BA.debugLineNum = 136;BA.debugLine="lives = 3";
_lives = (byte) (3);
 //BA.debugLineNum = 138;BA.debugLine="btnPlay.Enabled = False";
mostCurrent._btnplay.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 139;BA.debugLine="lblScore.Text = \"Score: \" & score";
mostCurrent._lblscore.setText(BA.ObjectToCharSequence("Score: "+BA.NumberToString(_score)));
 //BA.debugLineNum = 140;BA.debugLine="lblTime.Text = \"Tiempo: \" & time";
mostCurrent._lbltime.setText(BA.ObjectToCharSequence("Tiempo: "+BA.NumberToString(_time)));
 //BA.debugLineNum = 143;BA.debugLine="For Each imgView As ImageView In Panel2";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group7 = mostCurrent._panel2;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_imgview = (anywheresoftware.b4a.objects.ImageViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ImageViewWrapper(), (android.widget.ImageView)(group7.Get(index7)));
 //BA.debugLineNum = 144;BA.debugLine="imgView.SetBackgroundImage(LoadBitmap(File.DirAs";
_imgview.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Cora2.png").getObject()));
 }
};
 //BA.debugLineNum = 147;BA.debugLine="For Each btn As Button In Panel1";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
{
final anywheresoftware.b4a.BA.IterableList group10 = mostCurrent._panel1;
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(group10.Get(index10)));
 //BA.debugLineNum = 148;BA.debugLine="btn.Enabled = True";
_btn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }
};
 //BA.debugLineNum = 151;BA.debugLine="timer.Enabled = True";
_timer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public static String  _tejuinocheck_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _button = null;
byte _btnvalue = (byte)0;
 //BA.debugLineNum = 173;BA.debugLine="Private Sub TejuinoCheck_Click";
 //BA.debugLineNum = 174;BA.debugLine="Dim button As Button";
_button = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 175;BA.debugLine="Dim btnValue As Byte";
_btnvalue = (byte)0;
 //BA.debugLineNum = 178;BA.debugLine="button = Sender";
_button = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 179;BA.debugLine="btnValue = button.Tag";
_btnvalue = (byte)(BA.ObjectToNumber(_button.getTag()));
 //BA.debugLineNum = 181;BA.debugLine="button.Enabled = False";
_button.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 182;BA.debugLine="button.SetBackgroundImage(LoadBitmap(File.DirAsse";
_button.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Placeholder.png").getObject()));
 //BA.debugLineNum = 184;BA.debugLine="If btnValue == m1 Or btnValue == m2 Then";
if (_btnvalue==_m1 || _btnvalue==_m2) { 
 //BA.debugLineNum = 185;BA.debugLine="lives = lives - 1";
_lives = (byte) (_lives-1);
 //BA.debugLineNum = 186;BA.debugLine="sound.Play";
_sound.Play();
 //BA.debugLineNum = 187;BA.debugLine="Panel2.GetView(lives).SetBackgroundImage(LoadBit";
mostCurrent._panel2.GetView((int) (_lives)).SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"CoraVacio.png").getObject()));
 //BA.debugLineNum = 189;BA.debugLine="If lives == 0 Then";
if (_lives==0) { 
 //BA.debugLineNum = 190;BA.debugLine="MsgboxAsync(\"Se ha quedado sin vida\", \"GAME OVE";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Se ha quedado sin vida"),BA.ObjectToCharSequence("GAME OVER"),processBA);
 //BA.debugLineNum = 191;BA.debugLine="GameOver";
_gameover();
 };
 }else if(_btnvalue==_r1 || _btnvalue==_r2 || _btnvalue==_r3 || _btnvalue==_r4 || _btnvalue==_r5) { 
 //BA.debugLineNum = 195;BA.debugLine="coin.Play";
_coin.Play();
 //BA.debugLineNum = 196;BA.debugLine="score = score + 5";
_score = (int) (_score+5);
 //BA.debugLineNum = 197;BA.debugLine="lblScore.Text = \"Score: \" & score";
mostCurrent._lblscore.setText(BA.ObjectToCharSequence("Score: "+BA.NumberToString(_score)));
 };
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public static String  _timer_tick() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
 //BA.debugLineNum = 75;BA.debugLine="Private Sub Timer_Tick";
 //BA.debugLineNum = 76;BA.debugLine="time = time - 1";
_time = (byte) (_time-1);
 //BA.debugLineNum = 77;BA.debugLine="lblTime.Text = \"Tiempo: \" & time";
mostCurrent._lbltime.setText(BA.ObjectToCharSequence("Tiempo: "+BA.NumberToString(_time)));
 //BA.debugLineNum = 79;BA.debugLine="If time <= 0 Then";
if (_time<=0) { 
 //BA.debugLineNum = 80;BA.debugLine="MsgboxAsync(\"Su puntaje fue de \" & score, \"SE HA";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su puntaje fue de "+BA.NumberToString(_score)),BA.ObjectToCharSequence("SE HA ACABADO EL TIEMPO"),processBA);
 //BA.debugLineNum = 81;BA.debugLine="GameOver";
_gameover();
 //BA.debugLineNum = 82;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 86;BA.debugLine="For Each btn As Button In Panel1";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
{
final anywheresoftware.b4a.BA.IterableList group8 = mostCurrent._panel1;
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(group8.Get(index8)));
 //BA.debugLineNum = 87;BA.debugLine="btn.SetBackgroundImage(LoadBitmap(File.DirAssets";
_btn.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Placeholder.png").getObject()));
 //BA.debugLineNum = 88;BA.debugLine="btn.Enabled = True";
_btn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }
};
 //BA.debugLineNum = 91;BA.debugLine="GenerateNum";
_generatenum();
 //BA.debugLineNum = 93;BA.debugLine="Panel1.GetView(r1).SetBackgroundImage(LoadBitmap(";
mostCurrent._panel1.GetView((int) (_r1)).SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"TejuinoBueno.png").getObject()));
 //BA.debugLineNum = 94;BA.debugLine="Panel1.GetView(r2).SetBackgroundImage(LoadBitmap(";
mostCurrent._panel1.GetView((int) (_r2)).SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"TejuinoBueno.png").getObject()));
 //BA.debugLineNum = 95;BA.debugLine="Panel1.GetView(r3).SetBackgroundImage(LoadBitmap(";
mostCurrent._panel1.GetView((int) (_r3)).SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"TejuinoBueno.png").getObject()));
 //BA.debugLineNum = 96;BA.debugLine="Panel1.GetView(r4).SetBackgroundImage(LoadBitmap(";
mostCurrent._panel1.GetView((int) (_r4)).SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"TejuinoBueno.png").getObject()));
 //BA.debugLineNum = 97;BA.debugLine="Panel1.GetView(r5).SetBackgroundImage(LoadBitmap(";
mostCurrent._panel1.GetView((int) (_r5)).SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"TejuinoBueno.png").getObject()));
 //BA.debugLineNum = 99;BA.debugLine="Panel1.GetView(m1).SetBackgroundImage(LoadBitmap(";
mostCurrent._panel1.GetView((int) (_m1)).SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"TejuinoMalo.png").getObject()));
 //BA.debugLineNum = 100;BA.debugLine="Panel1.GetView(m2).SetBackgroundImage(LoadBitmap(";
mostCurrent._panel1.GetView((int) (_m2)).SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"TejuinoMalo.png").getObject()));
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
}
