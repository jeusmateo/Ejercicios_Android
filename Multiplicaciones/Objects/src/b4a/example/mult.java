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

public class mult extends Activity implements B4AActivity{
	public static mult mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.mult");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (mult).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.mult");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.mult", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (mult) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (mult) Resume **");
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
		return mult.class;
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
            BA.LogInfo("** Activity (mult) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (mult) Pause event (activity is not paused). **");
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
            mult mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (mult) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _pnlopciones = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbln1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbln2 = null;
public static int _num1 = 0;
public static int _num2 = 0;
public static int _res = 0;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmain = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcombo = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btniniciar = null;
public b4a.example.main _main = null;
public b4a.example.sumaresta _sumaresta = null;
public b4a.example.starter _starter = null;
public b4a.example.tools _tools = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _element = null;
 //BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"Multi\")";
mostCurrent._activity.LoadLayout("Multi",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="For Each element As B4XView In pnlMain";
_element = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group2 = mostCurrent._pnlmain;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_element = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group2.Get(index2)));
 //BA.debugLineNum = 35;BA.debugLine="element.Visible = False";
_element.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }
};
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _btnevent_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
int _btnvalue = 0;
 //BA.debugLineNum = 52;BA.debugLine="Private Sub btnEvent_Click";
 //BA.debugLineNum = 53;BA.debugLine="Dim btn As Button = Sender";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 54;BA.debugLine="Dim btnValue As Int = btn.Text";
_btnvalue = (int)(Double.parseDouble(_btn.getText()));
 //BA.debugLineNum = 56;BA.debugLine="If btnValue == res Then";
if (_btnvalue==_res) { 
 //BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(\"Correcto! 🎉\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Correcto! 🎉"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 58;BA.debugLine="Main.combo = Main.combo + 1";
mostCurrent._main._combo /*int*/  = (int) (mostCurrent._main._combo /*int*/ +1);
 }else {
 //BA.debugLineNum = 60;BA.debugLine="ToastMessageShow(\"Incorrecto! 😔\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Incorrecto! 😔"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 61;BA.debugLine="Main.combo = 0";
mostCurrent._main._combo /*int*/  = (int) (0);
 };
 //BA.debugLineNum = 64;BA.debugLine="lblCombo.Text = \"COMBO: \" & Main.combo";
mostCurrent._lblcombo.setText(BA.ObjectToCharSequence("COMBO: "+BA.NumberToString(mostCurrent._main._combo /*int*/ )));
 //BA.debugLineNum = 67;BA.debugLine="GenerateNum";
_generatenum();
 //BA.debugLineNum = 68;BA.debugLine="GenerateOptions";
_generateoptions();
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _btniniciar_click() throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Private Sub btnIniciar_Click";
 //BA.debugLineNum = 49;BA.debugLine="Start";
_start();
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _generatenum() throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub GenerateNum";
 //BA.debugLineNum = 73;BA.debugLine="Select Main.btnVal";
switch (BA.switchObjectToInt(mostCurrent._main._btnval /*byte*/ ,(byte) (3),(byte) (4))) {
case 0: {
 //BA.debugLineNum = 75;BA.debugLine="num1 = Rnd(1, 11)";
_num1 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (11));
 //BA.debugLineNum = 76;BA.debugLine="num2 = Rnd(1, 11)";
_num2 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (11));
 break; }
case 1: {
 //BA.debugLineNum = 79;BA.debugLine="num1 = Rnd(1, 101)";
_num1 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (101));
 //BA.debugLineNum = 80;BA.debugLine="num2 = Rnd(1, 11)";
_num2 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (11));
 break; }
}
;
 //BA.debugLineNum = 83;BA.debugLine="res = num1 * num2";
_res = (int) (_num1*_num2);
 //BA.debugLineNum = 85;BA.debugLine="lblN1.Text = num1";
mostCurrent._lbln1.setText(BA.ObjectToCharSequence(_num1));
 //BA.debugLineNum = 86;BA.debugLine="lblN2.Text = num2";
mostCurrent._lbln2.setText(BA.ObjectToCharSequence(_num2));
 //BA.debugLineNum = 88;BA.debugLine="Log(res)";
anywheresoftware.b4a.keywords.Common.LogImpl("11769488",BA.NumberToString(_res),0);
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _generateoptions() throws Exception{
int _r1 = 0;
int _r2 = 0;
int _r3 = 0;
int _limit = 0;
byte _respos = (byte)0;
 //BA.debugLineNum = 92;BA.debugLine="Private Sub GenerateOptions";
 //BA.debugLineNum = 93;BA.debugLine="Dim r1, r2, r3 As Int = 0";
_r1 = 0;
_r2 = 0;
_r3 = (int) (0);
 //BA.debugLineNum = 94;BA.debugLine="Dim limit As Int = 0";
_limit = (int) (0);
 //BA.debugLineNum = 95;BA.debugLine="Dim resPos As Byte = Rnd(0, 4)";
_respos = (byte) (anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (4)));
 //BA.debugLineNum = 97;BA.debugLine="pnlOpciones.GetView(resPos).As(Button).Text = res";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (_respos)).getObject()))).setText(BA.ObjectToCharSequence(_res));
 //BA.debugLineNum = 99;BA.debugLine="Select Main.btnVal";
switch (BA.switchObjectToInt(mostCurrent._main._btnval /*byte*/ ,(byte) (3),(byte) (4))) {
case 0: {
 //BA.debugLineNum = 101;BA.debugLine="limit = 101";
_limit = (int) (101);
 break; }
case 1: {
 //BA.debugLineNum = 103;BA.debugLine="limit = 1001";
_limit = (int) (1001);
 break; }
}
;
 //BA.debugLineNum = 106;BA.debugLine="Do Until (r1 <> r2 And r1 <> r3 And r1 <> res And";
while (!((_r1!=_r2 && _r1!=_r3 && _r1!=_res && _r2!=_res && _r2!=_r3 && _r3!=_res))) {
 //BA.debugLineNum = 107;BA.debugLine="r1 = Rnd(1, limit)";
_r1 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),_limit);
 //BA.debugLineNum = 108;BA.debugLine="r2 = Rnd(1, limit)";
_r2 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),_limit);
 //BA.debugLineNum = 109;BA.debugLine="r3 = Rnd(1, limit)";
_r3 = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),_limit);
 }
;
 //BA.debugLineNum = 112;BA.debugLine="Select resPos";
switch (BA.switchObjectToInt(_respos,(byte) (0),(byte) (1),(byte) (2),(byte) (3))) {
case 0: {
 //BA.debugLineNum = 114;BA.debugLine="pnlOpciones.GetView(1).As(Button).Text = r1";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (1)).getObject()))).setText(BA.ObjectToCharSequence(_r1));
 //BA.debugLineNum = 115;BA.debugLine="pnlOpciones.GetView(2).As(Button).Text = r2";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (2)).getObject()))).setText(BA.ObjectToCharSequence(_r2));
 //BA.debugLineNum = 116;BA.debugLine="pnlOpciones.GetView(3).As(Button).Text = r3";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (3)).getObject()))).setText(BA.ObjectToCharSequence(_r3));
 break; }
case 1: {
 //BA.debugLineNum = 118;BA.debugLine="pnlOpciones.GetView(0).As(Button).Text = r1";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (0)).getObject()))).setText(BA.ObjectToCharSequence(_r1));
 //BA.debugLineNum = 119;BA.debugLine="pnlOpciones.GetView(2).As(Button).Text = r2";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (2)).getObject()))).setText(BA.ObjectToCharSequence(_r2));
 //BA.debugLineNum = 120;BA.debugLine="pnlOpciones.GetView(3).As(Button).Text = r3";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (3)).getObject()))).setText(BA.ObjectToCharSequence(_r3));
 break; }
case 2: {
 //BA.debugLineNum = 122;BA.debugLine="pnlOpciones.GetView(0).As(Button).Text = r1";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (0)).getObject()))).setText(BA.ObjectToCharSequence(_r1));
 //BA.debugLineNum = 123;BA.debugLine="pnlOpciones.GetView(1).As(Button).Text = r2";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (1)).getObject()))).setText(BA.ObjectToCharSequence(_r2));
 //BA.debugLineNum = 124;BA.debugLine="pnlOpciones.GetView(3).As(Button).Text = r3";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (3)).getObject()))).setText(BA.ObjectToCharSequence(_r3));
 break; }
case 3: {
 //BA.debugLineNum = 126;BA.debugLine="pnlOpciones.GetView(0).As(Button).Text = r1";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (0)).getObject()))).setText(BA.ObjectToCharSequence(_r1));
 //BA.debugLineNum = 127;BA.debugLine="pnlOpciones.GetView(1).As(Button).Text = r2";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (1)).getObject()))).setText(BA.ObjectToCharSequence(_r2));
 //BA.debugLineNum = 128;BA.debugLine="pnlOpciones.GetView(2).As(Button).Text = r3";
((anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(mostCurrent._pnlopciones.GetView((int) (2)).getObject()))).setText(BA.ObjectToCharSequence(_r3));
 break; }
}
;
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private pnlOpciones As Panel";
mostCurrent._pnlopciones = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private lblN1 As Label";
mostCurrent._lbln1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private lblN2 As Label";
mostCurrent._lbln2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private num1, num2, res As Int";
_num1 = 0;
_num2 = 0;
_res = 0;
 //BA.debugLineNum = 22;BA.debugLine="Private pnlMain As Panel";
mostCurrent._pnlmain = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lblCombo As Label";
mostCurrent._lblcombo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private btnIniciar As Button";
mostCurrent._btniniciar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _start() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _element = null;
 //BA.debugLineNum = 134;BA.debugLine="Private Sub Start";
 //BA.debugLineNum = 135;BA.debugLine="btnIniciar.Visible = False";
mostCurrent._btniniciar.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 137;BA.debugLine="For Each element As B4XView In pnlMain";
_element = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group2 = mostCurrent._pnlmain;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_element = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group2.Get(index2)));
 //BA.debugLineNum = 138;BA.debugLine="element.Visible = True";
_element.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }
};
 //BA.debugLineNum = 141;BA.debugLine="lblCombo.Text = \"COMBO: 0\"";
mostCurrent._lblcombo.setText(BA.ObjectToCharSequence("COMBO: 0"));
 //BA.debugLineNum = 143;BA.debugLine="GenerateNum";
_generatenum();
 //BA.debugLineNum = 144;BA.debugLine="GenerateOptions";
_generateoptions();
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
}
