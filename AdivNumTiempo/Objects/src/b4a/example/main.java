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
public anywheresoftware.b4a.objects.EditTextWrapper _txtp1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtp2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblmensajes = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblp1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblp2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnp1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnp2 = null;
public static byte _randomn = (byte)0;
public static byte _turn = (byte)0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnplay = null;
public static byte _time = (byte)0;
public anywheresoftware.b4a.objects.LabelWrapper _lbltiempo = null;
public static boolean _win = false;
public anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
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
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="timer.Initialize(\"timer\", 1000)";
_timer.Initialize(processBA,"timer",(long) (1000));
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _btnp1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnp1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnp1_click", null));}
int _inputplayer = 0;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub btnP1_Click";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="If txtP1.Text == \"\" Then";
if ((mostCurrent._txtp1.getText()).equals("")) { 
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="MsgboxAsync(\"Digite un valor\", \"!!!\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Digite un valor"),BA.ObjectToCharSequence("!!!"),processBA);
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="Dim inputPlayer As Int";
_inputplayer = 0;
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="inputPlayer = txtP1.Text";
_inputplayer = (int)(Double.parseDouble(mostCurrent._txtp1.getText()));
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="CheckNum(inputPlayer, \"JUGADOR 1\")";
_checknum(_inputplayer,"JUGADOR 1");
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="txtP1.Text = \"\"";
mostCurrent._txtp1.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="End Sub";
return "";
}
public static String  _checknum(int _num,String _pturnname) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "checknum", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "checknum", new Object[] {_num,_pturnname}));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub CheckNum(num As Int, pTurnName As Stri";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Log(pTurnName & \" - \" & num)";
anywheresoftware.b4a.keywords.Common.LogImpl("4720898",_pturnname+" - "+BA.NumberToString(_num),0);
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="If num == randomN Then";
if (_num==_randomn) { 
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="win = True";
_win = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="GameOver";
_gameover();
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="If num < randomN Then";
if (_num<_randomn) { 
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="lblMensajes.Text = \"El numero es mayor\"";
mostCurrent._lblmensajes.setText(BA.ObjectToCharSequence("El numero es mayor"));
 }else 
{RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="Else If num > randomN Then";
if (_num>_randomn) { 
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="lblMensajes.Text = \"El numero es menor\"";
mostCurrent._lblmensajes.setText(BA.ObjectToCharSequence("El numero es menor"));
 }}
;
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="turnChange";
_turnchange();
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="End Sub";
return "";
}
public static String  _btnp2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnp2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnp2_click", null));}
int _inputplayer = 0;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub btnP2_Click";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="If txtP2.Text == \"\" Then";
if ((mostCurrent._txtp2.getText()).equals("")) { 
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="MsgboxAsync(\"Digite un valor\", \"!!!\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Digite un valor"),BA.ObjectToCharSequence("!!!"),processBA);
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="Dim inputPlayer As Int";
_inputplayer = 0;
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="inputPlayer = txtP2.Text";
_inputplayer = (int)(Double.parseDouble(mostCurrent._txtp2.getText()));
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="CheckNum(inputPlayer, \"JUGADOR 2\")";
_checknum(_inputplayer,"JUGADOR 2");
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="txtP2.Text = \"\"";
mostCurrent._txtp2.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="End Sub";
return "";
}
public static String  _btnplay_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnplay_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnplay_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub btnPlay_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="StartGame";
_startgame();
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _startgame() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "startgame", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "startgame", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub StartGame";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="win = False";
_win = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="time = 40";
_time = (byte) (40);
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="turn = 1";
_turn = (byte) (1);
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="lblTiempo.Text = \"Tiempo: \" & time";
mostCurrent._lbltiempo.setText(BA.ObjectToCharSequence("Tiempo: "+BA.NumberToString(_time)));
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="lblMensajes.Text = \"\"";
mostCurrent._lblmensajes.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="img.Background = Null";
mostCurrent._img.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="btnPlay.Enabled = False";
mostCurrent._btnplay.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="timer.Enabled = True";
_timer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="P1Visible(True)";
_p1visible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="txtP1.RequestFocus";
mostCurrent._txtp1.RequestFocus();
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="randomN = Rnd(1, 101)";
_randomn = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (101)));
RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="Log(randomN)";
anywheresoftware.b4a.keywords.Common.LogImpl("4393233",BA.NumberToString(_randomn),0);
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="End Sub";
return "";
}
public static String  _gameover() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "gameover", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "gameover", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub GameOver";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="P1Visible(False)";
_p1visible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="P2Visible(False)";
_p2visible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="timer.Enabled = False";
_timer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="btnPlay.Enabled = True";
mostCurrent._btnplay.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="lblTiempo.Text = \"Tiempo: \"";
mostCurrent._lbltiempo.setText(BA.ObjectToCharSequence("Tiempo: "));
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="lblMensajes.Text = \"\"";
mostCurrent._lblmensajes.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="If win Then";
if (_win) { 
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="Select turn";
switch (BA.switchObjectToInt(_turn,(byte) (1),(byte) (2))) {
case 0: {
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="img.SetBackgroundImage(LoadBitmap(File.DirAsse";
mostCurrent._img.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"JUG1.png").getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=458771;
 //BA.debugLineNum = 458771;BA.debugLine="img.SetBackgroundImage(LoadBitmap(File.DirAsse";
mostCurrent._img.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"JUG2.png").getObject()));
 break; }
}
;
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=458777;
 //BA.debugLineNum = 458777;BA.debugLine="img.SetBackgroundImage(LoadBitmap(File.DirAssets,";
mostCurrent._img.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"GAMEOVER.png").getObject()));
RDebugUtils.currentLine=458779;
 //BA.debugLineNum = 458779;BA.debugLine="End Sub";
return "";
}
public static String  _turnchange() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "turnchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "turnchange", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub turnChange()";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="If turn == 1 Then";
if (_turn==1) { 
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="turn = 2";
_turn = (byte) (2);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="P1Visible(False)";
_p1visible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="P2Visible(True)";
_p2visible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="txtP2.RequestFocus";
mostCurrent._txtp2.RequestFocus();
 }else {
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="turn = 1";
_turn = (byte) (1);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="P1Visible(True)";
_p1visible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="P2Visible(False)";
_p2visible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="txtP1.RequestFocus";
mostCurrent._txtp1.RequestFocus();
 };
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="End Sub";
return "";
}
public static String  _p1visible(boolean _bool) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p1visible", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "p1visible", new Object[] {_bool}));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub P1Visible(bool As Boolean)";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="lblP1.Enabled = bool";
mostCurrent._lblp1.setEnabled(_bool);
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="txtP1.Enabled = bool";
mostCurrent._txtp1.setEnabled(_bool);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="btnP1.Enabled = bool";
mostCurrent._btnp1.setEnabled(_bool);
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="End Sub";
return "";
}
public static String  _p2visible(boolean _bool) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p2visible", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "p2visible", new Object[] {_bool}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub P2Visible(bool As Boolean)";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="lblP2.Enabled = bool";
mostCurrent._lblp2.setEnabled(_bool);
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="txtP2.Enabled = bool";
mostCurrent._txtp2.setEnabled(_bool);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="btnP2.Enabled = bool";
mostCurrent._btnp2.setEnabled(_bool);
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="End Sub";
return "";
}
public static String  _timer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timer_tick", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Private Sub timer_tick";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="time = time - 1";
_time = (byte) (_time-1);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="lblTiempo.Text = \"Tiempo: \" & time";
mostCurrent._lbltiempo.setText(BA.ObjectToCharSequence("Tiempo: "+BA.NumberToString(_time)));
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="If time == 0 Then";
if (_time==0) { 
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="timer.Enabled = False";
_timer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="GameOver";
_gameover();
 };
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="End Sub";
return "";
}
}