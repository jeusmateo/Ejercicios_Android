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
public static String  _btnp1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnp1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnp1_click", null));}
int _inputplayer = 0;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub btnP1_Click";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="If txtP1.Text == \"\" Then";
if ((mostCurrent._txtp1.getText()).equals("")) { 
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="MsgboxAsync(\"Digite un valor\", \"!!!\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Digite un valor"),BA.ObjectToCharSequence("!!!"),processBA);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="Dim inputPlayer As Int";
_inputplayer = 0;
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="inputPlayer = txtP1.Text";
_inputplayer = (int)(Double.parseDouble(mostCurrent._txtp1.getText()));
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="CheckNum(inputPlayer, \"JUGADOR 1\")";
_checknum(_inputplayer,"JUGADOR 1");
RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="txtP1.Text = \"\"";
mostCurrent._txtp1.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="End Sub";
return "";
}
public static String  _checknum(int _num,String _pturnname) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "checknum", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "checknum", new Object[] {_num,_pturnname}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub CheckNum(num As Int, pTurnName As Stri";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Log(pTurnName & \" - \" & num)";
anywheresoftware.b4a.keywords.Common.LogImpl("01048578",_pturnname+" - "+BA.NumberToString(_num),0);
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="If num == randomN Then";
if (_num==_randomn) { 
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="win = True";
_win = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="GameOver(pTurnName)";
_gameover(_pturnname);
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="If num < randomN Then";
if (_num<_randomn) { 
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="MsgboxAsync(\"El numero es mayor\", \"!!!\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El numero es mayor"),BA.ObjectToCharSequence("!!!"),processBA);
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="lblMensajes.Text = \"El numero es mayor\"";
mostCurrent._lblmensajes.setText(BA.ObjectToCharSequence("El numero es mayor"));
 }else 
{RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="Else If num > randomN Then";
if (_num>_randomn) { 
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="MsgboxAsync(\"El numero es menor\", \"!!!\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El numero es menor"),BA.ObjectToCharSequence("!!!"),processBA);
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="lblMensajes.Text = \"El numero es menor\"";
mostCurrent._lblmensajes.setText(BA.ObjectToCharSequence("El numero es menor"));
 }}
;
RDebugUtils.currentLine=1048594;
 //BA.debugLineNum = 1048594;BA.debugLine="turnChange";
_turnchange();
RDebugUtils.currentLine=1048596;
 //BA.debugLineNum = 1048596;BA.debugLine="End Sub";
return "";
}
public static String  _btnp2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnp2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnp2_click", null));}
int _inputplayer = 0;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub btnP2_Click";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="If txtP2.Text == \"\" Then";
if ((mostCurrent._txtp2.getText()).equals("")) { 
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="MsgboxAsync(\"Digite un valor\", \"!!!\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Digite un valor"),BA.ObjectToCharSequence("!!!"),processBA);
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="Dim inputPlayer As Int";
_inputplayer = 0;
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="inputPlayer = txtP2.Text";
_inputplayer = (int)(Double.parseDouble(mostCurrent._txtp2.getText()));
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="CheckNum(inputPlayer, \"JUGADOR 2\")";
_checknum(_inputplayer,"JUGADOR 2");
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="txtP2.Text = \"\"";
mostCurrent._txtp2.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="End Sub";
return "";
}
public static String  _btnplay_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnplay_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnplay_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub btnPlay_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="win = False";
_win = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="time = 40";
_time = (byte) (40);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="lblTiempo.Text = \"Tiempo: \" & time";
mostCurrent._lbltiempo.setText(BA.ObjectToCharSequence("Tiempo: "+BA.NumberToString(_time)));
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="btnPlay.Enabled = False";
mostCurrent._btnplay.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="timer.Enabled = True";
_timer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="P1Visible(True)";
_p1visible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="txtP1.RequestFocus";
mostCurrent._txtp1.RequestFocus();
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="turn = 1";
_turn = (byte) (1);
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="lblMensajes.Text = \"\"";
mostCurrent._lblmensajes.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="randomN = Rnd(1, 101)";
_randomn = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (101)));
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="Log(randomN)";
anywheresoftware.b4a.keywords.Common.LogImpl("0983055",BA.NumberToString(_randomn),0);
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="End Sub";
return "";
}
public static String  _p1visible(boolean _bool) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p1visible", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "p1visible", new Object[] {_bool}));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub P1Visible(bool As Boolean)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="lblP1.Enabled = bool";
mostCurrent._lblp1.setEnabled(_bool);
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="txtP1.Enabled = bool";
mostCurrent._txtp1.setEnabled(_bool);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="btnP1.Enabled = bool";
mostCurrent._btnp1.setEnabled(_bool);
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="End Sub";
return "";
}
public static String  _gameover(String _pwinner) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "gameover", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "gameover", new Object[] {_pwinner}));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub GameOver(pWinner As String)";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="If win Then";
if (_win) { 
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="MsgboxAsync(\"HAS GANADO \" & pWinner, \"GAME OVER\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("HAS GANADO "+_pwinner),BA.ObjectToCharSequence("GAME OVER"),processBA);
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="lblMensajes.Text = \"GANADOR \" & pWinner";
mostCurrent._lblmensajes.setText(BA.ObjectToCharSequence("GANADOR "+_pwinner));
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="P1Visible(False)";
_p1visible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="P2Visible(False)";
_p2visible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="btnPlay.Enabled = True";
mostCurrent._btnplay.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="End Sub";
return "";
}
public static String  _turnchange() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "turnchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "turnchange", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub turnChange()";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="If turn == 1 Then";
if (_turn==1) { 
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="turn = 2";
_turn = (byte) (2);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="P1Visible(False)";
_p1visible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="P2Visible(True)";
_p2visible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="txtP2.RequestFocus";
mostCurrent._txtp2.RequestFocus();
 }else {
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="turn = 1";
_turn = (byte) (1);
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="P1Visible(True)";
_p1visible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="P2Visible(False)";
_p2visible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="txtP1.RequestFocus";
mostCurrent._txtp1.RequestFocus();
 };
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="End Sub";
return "";
}
public static String  _p2visible(boolean _bool) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p2visible", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "p2visible", new Object[] {_bool}));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub P2Visible(bool As Boolean)";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="lblP2.Enabled = bool";
mostCurrent._lblp2.setEnabled(_bool);
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="txtP2.Enabled = bool";
mostCurrent._txtp2.setEnabled(_bool);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="btnP2.Enabled = bool";
mostCurrent._btnp2.setEnabled(_bool);
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="End Sub";
return "";
}
public static String  _timer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timer_tick", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub timer_tick";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="time = time - 1";
_time = (byte) (_time-1);
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="lblTiempo.Text = time";
mostCurrent._lbltiempo.setText(BA.ObjectToCharSequence(_time));
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="If time == 0 Then";
if (_time==0) { 
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="timer.Enabled = False";
_timer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="GameOver(\"\")";
_gameover("");
 };
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="End Sub";
return "";
}
}