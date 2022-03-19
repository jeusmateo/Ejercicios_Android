package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,47);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="timer.Initialize(\"timer\", 1000)";
Debug.ShouldStop(65536);
main._timer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("timer")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,68);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,64);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnp1_click() throws Exception{
try {
		Debug.PushSubsStack("btnP1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,174);
if (RapidSub.canDelegate("btnp1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnp1_click");}
RemoteObject _inputplayer = RemoteObject.createImmutable(0);
 BA.debugLineNum = 174;BA.debugLine="Private Sub btnP1_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 176;BA.debugLine="If txtP1.Text == \"\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main.mostCurrent._txtp1.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 177;BA.debugLine="MsgboxAsync(\"Digite un valor\", \"!!!\")";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Digite un valor")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("!!!"))),main.processBA);
 BA.debugLineNum = 178;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 181;BA.debugLine="Dim inputPlayer As Int";
Debug.ShouldStop(1048576);
_inputplayer = RemoteObject.createImmutable(0);Debug.locals.put("inputPlayer", _inputplayer);
 BA.debugLineNum = 183;BA.debugLine="inputPlayer = txtP1.Text";
Debug.ShouldStop(4194304);
_inputplayer = BA.numberCast(int.class, main.mostCurrent._txtp1.runMethod(true,"getText"));Debug.locals.put("inputPlayer", _inputplayer);
 BA.debugLineNum = 185;BA.debugLine="CheckNum(inputPlayer, \"JUGADOR 1\")";
Debug.ShouldStop(16777216);
_checknum(_inputplayer,RemoteObject.createImmutable("JUGADOR 1"));
 BA.debugLineNum = 186;BA.debugLine="txtP1.Text = \"\"";
Debug.ShouldStop(33554432);
main.mostCurrent._txtp1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 187;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnp2_click() throws Exception{
try {
		Debug.PushSubsStack("btnP2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,189);
if (RapidSub.canDelegate("btnp2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnp2_click");}
RemoteObject _inputplayer = RemoteObject.createImmutable(0);
 BA.debugLineNum = 189;BA.debugLine="Private Sub btnP2_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 191;BA.debugLine="If txtP2.Text == \"\" Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main.mostCurrent._txtp2.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 192;BA.debugLine="MsgboxAsync(\"Digite un valor\", \"!!!\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Digite un valor")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("!!!"))),main.processBA);
 BA.debugLineNum = 193;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 196;BA.debugLine="Dim inputPlayer As Int";
Debug.ShouldStop(8);
_inputplayer = RemoteObject.createImmutable(0);Debug.locals.put("inputPlayer", _inputplayer);
 BA.debugLineNum = 198;BA.debugLine="inputPlayer = txtP2.Text";
Debug.ShouldStop(32);
_inputplayer = BA.numberCast(int.class, main.mostCurrent._txtp2.runMethod(true,"getText"));Debug.locals.put("inputPlayer", _inputplayer);
 BA.debugLineNum = 200;BA.debugLine="CheckNum(inputPlayer, \"JUGADOR 2\")";
Debug.ShouldStop(128);
_checknum(_inputplayer,RemoteObject.createImmutable("JUGADOR 2"));
 BA.debugLineNum = 201;BA.debugLine="txtP2.Text = \"\"";
Debug.ShouldStop(256);
main.mostCurrent._txtp2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnplay_click() throws Exception{
try {
		Debug.PushSubsStack("btnPlay_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,134);
if (RapidSub.canDelegate("btnplay_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnplay_click");}
 BA.debugLineNum = 134;BA.debugLine="Private Sub btnPlay_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="StartGame";
Debug.ShouldStop(64);
_startgame();
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _checknum(RemoteObject _num,RemoteObject _pturnname) throws Exception{
try {
		Debug.PushSubsStack("CheckNum (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,138);
if (RapidSub.canDelegate("checknum")) { return b4a.example.main.remoteMe.runUserSub(false, "main","checknum", _num, _pturnname);}
Debug.locals.put("num", _num);
Debug.locals.put("pTurnName", _pturnname);
 BA.debugLineNum = 138;BA.debugLine="Private Sub CheckNum(num As Int, pTurnName As Stri";
Debug.ShouldStop(512);
 BA.debugLineNum = 140;BA.debugLine="Log(pTurnName & \" - \" & num)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4720898",RemoteObject.concat(_pturnname,RemoteObject.createImmutable(" - "),_num),0);
 BA.debugLineNum = 141;BA.debugLine="If num == randomN Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_num,BA.numberCast(double.class, main._randomn))) { 
 BA.debugLineNum = 142;BA.debugLine="win = True";
Debug.ShouldStop(8192);
main._win = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 143;BA.debugLine="GameOver";
Debug.ShouldStop(16384);
_gameover();
 BA.debugLineNum = 144;BA.debugLine="Return";
Debug.ShouldStop(32768);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 147;BA.debugLine="If num < randomN Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("<",_num,BA.numberCast(double.class, main._randomn))) { 
 BA.debugLineNum = 149;BA.debugLine="lblMensajes.Text = \"El numero es mayor\"";
Debug.ShouldStop(1048576);
main.mostCurrent._lblmensajes.runMethod(true,"setText",BA.ObjectToCharSequence("El numero es mayor"));
 }else 
{ BA.debugLineNum = 151;BA.debugLine="Else If num > randomN Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(">",_num,BA.numberCast(double.class, main._randomn))) { 
 BA.debugLineNum = 153;BA.debugLine="lblMensajes.Text = \"El numero es menor\"";
Debug.ShouldStop(16777216);
main.mostCurrent._lblmensajes.runMethod(true,"setText",BA.ObjectToCharSequence("El numero es menor"));
 }}
;
 BA.debugLineNum = 156;BA.debugLine="turnChange";
Debug.ShouldStop(134217728);
_turnchange();
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gameover() throws Exception{
try {
		Debug.PushSubsStack("GameOver (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,93);
if (RapidSub.canDelegate("gameover")) { return b4a.example.main.remoteMe.runUserSub(false, "main","gameover");}
 BA.debugLineNum = 93;BA.debugLine="Private Sub GameOver";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 95;BA.debugLine="P1Visible(False)";
Debug.ShouldStop(1073741824);
_p1visible(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 96;BA.debugLine="P2Visible(False)";
Debug.ShouldStop(-2147483648);
_p2visible(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 97;BA.debugLine="timer.Enabled = False";
Debug.ShouldStop(1);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 98;BA.debugLine="btnPlay.Enabled = True";
Debug.ShouldStop(2);
main.mostCurrent._btnplay.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 100;BA.debugLine="lblTiempo.Text = \"Tiempo: \"";
Debug.ShouldStop(8);
main.mostCurrent._lbltiempo.runMethod(true,"setText",BA.ObjectToCharSequence("Tiempo: "));
 BA.debugLineNum = 101;BA.debugLine="lblMensajes.Text = \"\"";
Debug.ShouldStop(16);
main.mostCurrent._lblmensajes.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 104;BA.debugLine="If win Then";
Debug.ShouldStop(128);
if (main._win.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 108;BA.debugLine="Select turn";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(main._turn,BA.numberCast(byte.class, 1),BA.numberCast(byte.class, 2))) {
case 0: {
 BA.debugLineNum = 110;BA.debugLine="img.SetBackgroundImage(LoadBitmap(File.DirAsse";
Debug.ShouldStop(8192);
main.mostCurrent._img.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("JUG1.png"))).getObject())));
 break; }
case 1: {
 BA.debugLineNum = 112;BA.debugLine="img.SetBackgroundImage(LoadBitmap(File.DirAsse";
Debug.ShouldStop(32768);
main.mostCurrent._img.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("JUG2.png"))).getObject())));
 break; }
}
;
 BA.debugLineNum = 114;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 118;BA.debugLine="img.SetBackgroundImage(LoadBitmap(File.DirAssets,";
Debug.ShouldStop(2097152);
main.mostCurrent._img.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("GAMEOVER.png"))).getObject())));
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private txtP1 As EditText";
main.mostCurrent._txtp1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtP2 As EditText";
main.mostCurrent._txtp2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private lblMensajes As Label";
main.mostCurrent._lblmensajes = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private lblP1 As Label";
main.mostCurrent._lblp1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private lblP2 As Label";
main.mostCurrent._lblp2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private btnP1 As Button";
main.mostCurrent._btnp1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btnP2 As Button";
main.mostCurrent._btnp2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private randomN As Byte";
main._randomn = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 34;BA.debugLine="Private turn As Byte";
main._turn = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 36;BA.debugLine="Private btnPlay As Button";
main.mostCurrent._btnplay = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private time As Byte";
main._time = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 40;BA.debugLine="Private lblTiempo As Label";
main.mostCurrent._lbltiempo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private win As Boolean";
main._win = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 44;BA.debugLine="Private img As ImageView";
main.mostCurrent._img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _p1visible(RemoteObject _bool) throws Exception{
try {
		Debug.PushSubsStack("P1Visible (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,122);
if (RapidSub.canDelegate("p1visible")) { return b4a.example.main.remoteMe.runUserSub(false, "main","p1visible", _bool);}
Debug.locals.put("bool", _bool);
 BA.debugLineNum = 122;BA.debugLine="Private Sub P1Visible(bool As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="lblP1.Enabled = bool";
Debug.ShouldStop(67108864);
main.mostCurrent._lblp1.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 124;BA.debugLine="txtP1.Enabled = bool";
Debug.ShouldStop(134217728);
main.mostCurrent._txtp1.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 125;BA.debugLine="btnP1.Enabled = bool";
Debug.ShouldStop(268435456);
main.mostCurrent._btnp1.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _p2visible(RemoteObject _bool) throws Exception{
try {
		Debug.PushSubsStack("P2Visible (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,128);
if (RapidSub.canDelegate("p2visible")) { return b4a.example.main.remoteMe.runUserSub(false, "main","p2visible", _bool);}
Debug.locals.put("bool", _bool);
 BA.debugLineNum = 128;BA.debugLine="Private Sub P2Visible(bool As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 129;BA.debugLine="lblP2.Enabled = bool";
Debug.ShouldStop(1);
main.mostCurrent._lblp2.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 130;BA.debugLine="txtP2.Enabled = bool";
Debug.ShouldStop(2);
main.mostCurrent._txtp2.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 131;BA.debugLine="btnP2.Enabled = bool";
Debug.ShouldStop(4);
main.mostCurrent._btnp2.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Private timer As Timer";
main._timer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _startgame() throws Exception{
try {
		Debug.PushSubsStack("StartGame (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,72);
if (RapidSub.canDelegate("startgame")) { return b4a.example.main.remoteMe.runUserSub(false, "main","startgame");}
 BA.debugLineNum = 72;BA.debugLine="Private Sub StartGame";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="win = False";
Debug.ShouldStop(256);
main._win = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 74;BA.debugLine="time = 40";
Debug.ShouldStop(512);
main._time = BA.numberCast(byte.class, 40);
 BA.debugLineNum = 75;BA.debugLine="turn = 1";
Debug.ShouldStop(1024);
main._turn = BA.numberCast(byte.class, 1);
 BA.debugLineNum = 77;BA.debugLine="lblTiempo.Text = \"Tiempo: \" & time";
Debug.ShouldStop(4096);
main.mostCurrent._lbltiempo.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Tiempo: "),main._time)));
 BA.debugLineNum = 78;BA.debugLine="lblMensajes.Text = \"\"";
Debug.ShouldStop(8192);
main.mostCurrent._lblmensajes.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 79;BA.debugLine="img.Background = Null";
Debug.ShouldStop(16384);
main.mostCurrent._img.runMethod(false,"setBackground",(main.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 81;BA.debugLine="btnPlay.Enabled = False";
Debug.ShouldStop(65536);
main.mostCurrent._btnplay.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 82;BA.debugLine="timer.Enabled = True";
Debug.ShouldStop(131072);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 84;BA.debugLine="P1Visible(True)";
Debug.ShouldStop(524288);
_p1visible(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 85;BA.debugLine="txtP1.RequestFocus";
Debug.ShouldStop(1048576);
main.mostCurrent._txtp1.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 88;BA.debugLine="randomN = Rnd(1, 101)";
Debug.ShouldStop(8388608);
main._randomn = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 101))));
 BA.debugLineNum = 89;BA.debugLine="Log(randomN)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4393233",BA.NumberToString(main._randomn),0);
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timer_tick() throws Exception{
try {
		Debug.PushSubsStack("timer_tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,52);
if (RapidSub.canDelegate("timer_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","timer_tick");}
 BA.debugLineNum = 52;BA.debugLine="Private Sub timer_tick";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="time = time - 1";
Debug.ShouldStop(1048576);
main._time = BA.numberCast(byte.class, RemoteObject.solve(new RemoteObject[] {main._time,RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 54;BA.debugLine="lblTiempo.Text = \"Tiempo: \" & time";
Debug.ShouldStop(2097152);
main.mostCurrent._lbltiempo.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Tiempo: "),main._time)));
 BA.debugLineNum = 56;BA.debugLine="If time == 0 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",main._time,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 57;BA.debugLine="timer.Enabled = False";
Debug.ShouldStop(16777216);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 58;BA.debugLine="GameOver";
Debug.ShouldStop(33554432);
_gameover();
 };
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _turnchange() throws Exception{
try {
		Debug.PushSubsStack("turnChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,160);
if (RapidSub.canDelegate("turnchange")) { return b4a.example.main.remoteMe.runUserSub(false, "main","turnchange");}
 BA.debugLineNum = 160;BA.debugLine="Private Sub turnChange()";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="If turn == 1 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",main._turn,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 162;BA.debugLine="turn = 2";
Debug.ShouldStop(2);
main._turn = BA.numberCast(byte.class, 2);
 BA.debugLineNum = 163;BA.debugLine="P1Visible(False)";
Debug.ShouldStop(4);
_p1visible(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 164;BA.debugLine="P2Visible(True)";
Debug.ShouldStop(8);
_p2visible(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 165;BA.debugLine="txtP2.RequestFocus";
Debug.ShouldStop(16);
main.mostCurrent._txtp2.runVoidMethod ("RequestFocus");
 }else {
 BA.debugLineNum = 167;BA.debugLine="turn = 1";
Debug.ShouldStop(64);
main._turn = BA.numberCast(byte.class, 1);
 BA.debugLineNum = 168;BA.debugLine="P1Visible(True)";
Debug.ShouldStop(128);
_p1visible(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 169;BA.debugLine="P2Visible(False)";
Debug.ShouldStop(256);
_p2visible(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 170;BA.debugLine="txtP1.RequestFocus";
Debug.ShouldStop(512);
main.mostCurrent._txtp1.runVoidMethod ("RequestFocus");
 };
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}