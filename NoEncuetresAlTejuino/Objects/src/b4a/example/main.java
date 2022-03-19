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
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.Timer _timer = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnplay = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblscore = null;
public static byte _randomnum1 = (byte)0;
public static byte _randomnum2 = (byte)0;
public static byte _randomnum3 = (byte)0;
public static int _score = 0;
public static byte _lives = (byte)0;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="ViewEnabled(False)";
_viewenabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="timer.Initialize(\"Timer\", 1000)";
_timer.Initialize(processBA,"Timer",(long) (1000));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="End Sub";
return "";
}
public static String  _viewenabled(boolean _bool) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "viewenabled", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "viewenabled", new Object[] {_bool}));}
anywheresoftware.b4a.objects.ButtonWrapper _button = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Private Sub ViewEnabled(bool As Boolean)";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="For Each button As Button In Panel1";
_button = new anywheresoftware.b4a.objects.ButtonWrapper();
{
final anywheresoftware.b4a.BA.IterableList group1 = mostCurrent._panel1;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_button = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(group1.Get(index1)));
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="button.Enabled = bool";
_button.setEnabled(_bool);
 }
};
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="For Each imgView As ImageView In Panel2";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group4 = mostCurrent._panel2;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_imgview = (anywheresoftware.b4a.objects.ImageViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ImageViewWrapper(), (android.widget.ImageView)(group4.Get(index4)));
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="imgView.Visible = bool";
_imgview.setVisible(_bool);
 }
};
RDebugUtils.currentLine=1835017;
 //BA.debugLineNum = 1835017;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _btnplay_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnplay_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnplay_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub btnPlay_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="StartGame";
_startgame();
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="End Sub";
return "";
}
public static String  _startgame() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "startgame", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "startgame", null));}
int _i = 0;
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub StartGame";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="For i = 0 To 19";
{
final int step1 = 1;
final int limit1 = (int) (19);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Panel1.GetView(i).As(Button).Text = i";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._panel1.GetView(_i).getObject()))).setText(BA.ObjectToCharSequence(_i));
 }
};
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="GenerateNum";
_generatenum();
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="ToastMessageShow(randomNum1 & randomNum2 & random";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(BA.NumberToString(_randomnum1)+BA.NumberToString(_randomnum2)+BA.NumberToString(_randomnum3)),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="score = 0";
_score = (int) (0);
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="lives = 3";
_lives = (byte) (3);
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="btnPlay.Enabled = False";
mostCurrent._btnplay.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="lblScore.Text = \"Score: \" & score";
mostCurrent._lblscore.setText(BA.ObjectToCharSequence("Score: "+BA.NumberToString(_score)));
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="timer.Enabled = True";
_timer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="ViewEnabled(True)";
_viewenabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458771;
 //BA.debugLineNum = 458771;BA.debugLine="End Sub";
return "";
}
public static String  _gameover() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "gameover", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "gameover", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub GameOver";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="MsgboxAsync(\"GAME OVER\", \"\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("GAME OVER"),BA.ObjectToCharSequence(""),processBA);
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="btnPlay.Enabled = True";
mostCurrent._btnplay.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="lblScore.Text = \"\"";
mostCurrent._lblscore.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="ViewEnabled(False)";
_viewenabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="End Sub";
return "";
}
public static String  _generatenum() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "generatenum", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "generatenum", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub GenerateNum";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="randomNum1 = Rnd(1, 21)";
_randomnum1 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (21)));
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="randomNum2 = Rnd(1, 21)";
_randomnum2 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (21)));
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="randomNum3 = Rnd(1, 21)";
_randomnum3 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (21)));
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="If randomNum1 == randomNum2 Or randomNum1 == rand";
if (_randomnum1==_randomnum2 || _randomnum1==_randomnum3 || _randomnum2==_randomnum3) { 
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="randomNum1 = Rnd(1, 21)";
_randomnum1 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (21)));
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="randomNum2 = Rnd(1, 21)";
_randomnum2 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (21)));
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="randomNum3 = Rnd(1, 21)";
_randomnum3 = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (21)));
 };
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="End Sub";
return "";
}
public static String  _tejuinocheck_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tejuinocheck_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tejuinocheck_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _button = null;
byte _btnvalue = (byte)0;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub TejuinoCheck_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Dim button As Button";
_button = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Dim btnValue As Byte";
_btnvalue = (byte)0;
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="button = Sender";
_button = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="btnValue = button.Tag";
_btnvalue = (byte)(BA.ObjectToNumber(_button.getTag()));
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="If btnValue == randomNum1 Or btnValue == randomNu";
if (_btnvalue==_randomnum1 || _btnvalue==_randomnum2 || _btnvalue==_randomnum3) { 
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="lives = lives - 1";
_lives = (byte) (_lives-1);
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="ToastMessageShow(lives, False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_lives),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="If lives == 0 Then";
if (_lives==0) { 
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="GameOver";
_gameover();
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=655380;
 //BA.debugLineNum = 655380;BA.debugLine="score = score + 5";
_score = (int) (_score+5);
RDebugUtils.currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="lblScore.Text = \"Score: \" & score";
mostCurrent._lblscore.setText(BA.ObjectToCharSequence("Score: "+BA.NumberToString(_score)));
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="End Sub";
return "";
}
public static String  _timer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timer_tick", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Private Sub Timer_Tick";
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="End Sub";
return "";
}
}