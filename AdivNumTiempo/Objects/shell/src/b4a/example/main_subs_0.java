package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,46);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 48;BA.debugLine="timer.Initialize(\"timer\", 1000)";
Debug.ShouldStop(32768);
main._timer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("timer")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,63);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("btnP1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,153);
if (RapidSub.canDelegate("btnp1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnp1_click");}
RemoteObject _inputplayer = RemoteObject.createImmutable(0);
 BA.debugLineNum = 153;BA.debugLine="Private Sub btnP1_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 155;BA.debugLine="If txtP1.Text == \"\" Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",main.mostCurrent._txtp1.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 156;BA.debugLine="MsgboxAsync(\"Digite un valor\", \"!!!\")";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Digite un valor")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("!!!"))),main.processBA);
 BA.debugLineNum = 157;BA.debugLine="Return";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 160;BA.debugLine="Dim inputPlayer As Int";
Debug.ShouldStop(-2147483648);
_inputplayer = RemoteObject.createImmutable(0);Debug.locals.put("inputPlayer", _inputplayer);
 BA.debugLineNum = 164;BA.debugLine="inputPlayer = txtP1.Text";
Debug.ShouldStop(8);
_inputplayer = BA.numberCast(int.class, main.mostCurrent._txtp1.runMethod(true,"getText"));Debug.locals.put("inputPlayer", _inputplayer);
 BA.debugLineNum = 166;BA.debugLine="CheckNum(inputPlayer, \"JUGADOR 1\")";
Debug.ShouldStop(32);
_checknum(_inputplayer,RemoteObject.createImmutable("JUGADOR 1"));
 BA.debugLineNum = 167;BA.debugLine="txtP1.Text = \"\"";
Debug.ShouldStop(64);
main.mostCurrent._txtp1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 168;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("btnP2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,170);
if (RapidSub.canDelegate("btnp2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnp2_click");}
RemoteObject _inputplayer = RemoteObject.createImmutable(0);
 BA.debugLineNum = 170;BA.debugLine="Private Sub btnP2_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 172;BA.debugLine="If txtP2.Text == \"\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main.mostCurrent._txtp2.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 173;BA.debugLine="MsgboxAsync(\"Digite un valor\", \"!!!\")";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Digite un valor")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("!!!"))),main.processBA);
 BA.debugLineNum = 174;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 177;BA.debugLine="Dim inputPlayer As Int";
Debug.ShouldStop(65536);
_inputplayer = RemoteObject.createImmutable(0);Debug.locals.put("inputPlayer", _inputplayer);
 BA.debugLineNum = 179;BA.debugLine="inputPlayer = txtP2.Text";
Debug.ShouldStop(262144);
_inputplayer = BA.numberCast(int.class, main.mostCurrent._txtp2.runMethod(true,"getText"));Debug.locals.put("inputPlayer", _inputplayer);
 BA.debugLineNum = 181;BA.debugLine="CheckNum(inputPlayer, \"JUGADOR 2\")";
Debug.ShouldStop(1048576);
_checknum(_inputplayer,RemoteObject.createImmutable("JUGADOR 2"));
 BA.debugLineNum = 182;BA.debugLine="txtP2.Text = \"\"";
Debug.ShouldStop(2097152);
main.mostCurrent._txtp2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("btnPlay_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,98);
if (RapidSub.canDelegate("btnplay_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnplay_click");}
 BA.debugLineNum = 98;BA.debugLine="Private Sub btnPlay_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="win = False";
Debug.ShouldStop(4);
main._win = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 100;BA.debugLine="time = 40";
Debug.ShouldStop(8);
main._time = BA.numberCast(byte.class, 40);
 BA.debugLineNum = 101;BA.debugLine="lblTiempo.Text = \"Tiempo: \" & time";
Debug.ShouldStop(16);
main.mostCurrent._lbltiempo.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Tiempo: "),main._time)));
 BA.debugLineNum = 102;BA.debugLine="btnPlay.Enabled = False";
Debug.ShouldStop(32);
main.mostCurrent._btnplay.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 104;BA.debugLine="timer.Enabled = True";
Debug.ShouldStop(128);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 106;BA.debugLine="P1Visible(True)";
Debug.ShouldStop(512);
_p1visible(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 107;BA.debugLine="txtP1.RequestFocus";
Debug.ShouldStop(1024);
main.mostCurrent._txtp1.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 108;BA.debugLine="turn = 1";
Debug.ShouldStop(2048);
main._turn = BA.numberCast(byte.class, 1);
 BA.debugLineNum = 110;BA.debugLine="lblMensajes.Text = \"\"";
Debug.ShouldStop(8192);
main.mostCurrent._lblmensajes.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 112;BA.debugLine="randomN = Rnd(1, 101)";
Debug.ShouldStop(32768);
main._randomn = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 101))));
 BA.debugLineNum = 113;BA.debugLine="Log(randomN)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0983055",BA.NumberToString(main._randomn),0);
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("CheckNum (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,117);
if (RapidSub.canDelegate("checknum")) { return b4a.example.main.remoteMe.runUserSub(false, "main","checknum", _num, _pturnname);}
Debug.locals.put("num", _num);
Debug.locals.put("pTurnName", _pturnname);
 BA.debugLineNum = 117;BA.debugLine="Private Sub CheckNum(num As Int, pTurnName As Stri";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 119;BA.debugLine="Log(pTurnName & \" - \" & num)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","01048578",RemoteObject.concat(_pturnname,RemoteObject.createImmutable(" - "),_num),0);
 BA.debugLineNum = 120;BA.debugLine="If num == randomN Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_num,BA.numberCast(double.class, main._randomn))) { 
 BA.debugLineNum = 121;BA.debugLine="win = True";
Debug.ShouldStop(16777216);
main._win = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 122;BA.debugLine="GameOver(pTurnName)";
Debug.ShouldStop(33554432);
_gameover(_pturnname);
 BA.debugLineNum = 123;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 126;BA.debugLine="If num < randomN Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("<",_num,BA.numberCast(double.class, main._randomn))) { 
 BA.debugLineNum = 127;BA.debugLine="MsgboxAsync(\"El numero es mayor\", \"!!!\")";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El numero es mayor")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("!!!"))),main.processBA);
 BA.debugLineNum = 128;BA.debugLine="lblMensajes.Text = \"El numero es mayor\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lblmensajes.runMethod(true,"setText",BA.ObjectToCharSequence("El numero es mayor"));
 }else 
{ BA.debugLineNum = 130;BA.debugLine="Else If num > randomN Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(">",_num,BA.numberCast(double.class, main._randomn))) { 
 BA.debugLineNum = 131;BA.debugLine="MsgboxAsync(\"El numero es menor\", \"!!!\")";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El numero es menor")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("!!!"))),main.processBA);
 BA.debugLineNum = 132;BA.debugLine="lblMensajes.Text = \"El numero es menor\"";
Debug.ShouldStop(8);
main.mostCurrent._lblmensajes.runMethod(true,"setText",BA.ObjectToCharSequence("El numero es menor"));
 }}
;
 BA.debugLineNum = 135;BA.debugLine="turnChange";
Debug.ShouldStop(64);
_turnchange();
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gameover(RemoteObject _pwinner) throws Exception{
try {
		Debug.PushSubsStack("GameOver (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("gameover")) { return b4a.example.main.remoteMe.runUserSub(false, "main","gameover", _pwinner);}
Debug.locals.put("pWinner", _pwinner);
 BA.debugLineNum = 71;BA.debugLine="Private Sub GameOver(pWinner As String)";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="If win Then";
Debug.ShouldStop(256);
if (main._win.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 74;BA.debugLine="MsgboxAsync(\"HAS GANADO \" & pWinner, \"GAME OVER\"";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("HAS GANADO "),_pwinner))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("GAME OVER"))),main.processBA);
 BA.debugLineNum = 75;BA.debugLine="lblMensajes.Text = \"GANADOR \" & pWinner";
Debug.ShouldStop(1024);
main.mostCurrent._lblmensajes.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("GANADOR "),_pwinner)));
 BA.debugLineNum = 76;BA.debugLine="P1Visible(False)";
Debug.ShouldStop(2048);
_p1visible(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 77;BA.debugLine="P2Visible(False)";
Debug.ShouldStop(4096);
_p2visible(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 78;BA.debugLine="btnPlay.Enabled = True";
Debug.ShouldStop(8192);
main.mostCurrent._btnplay.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 79;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _p1visible(RemoteObject _bool) throws Exception{
try {
		Debug.PushSubsStack("P1Visible (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,86);
if (RapidSub.canDelegate("p1visible")) { return b4a.example.main.remoteMe.runUserSub(false, "main","p1visible", _bool);}
Debug.locals.put("bool", _bool);
 BA.debugLineNum = 86;BA.debugLine="Private Sub P1Visible(bool As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="lblP1.Enabled = bool";
Debug.ShouldStop(4194304);
main.mostCurrent._lblp1.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 88;BA.debugLine="txtP1.Enabled = bool";
Debug.ShouldStop(8388608);
main.mostCurrent._txtp1.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 89;BA.debugLine="btnP1.Enabled = bool";
Debug.ShouldStop(16777216);
main.mostCurrent._btnp1.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("P2Visible (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,92);
if (RapidSub.canDelegate("p2visible")) { return b4a.example.main.remoteMe.runUserSub(false, "main","p2visible", _bool);}
Debug.locals.put("bool", _bool);
 BA.debugLineNum = 92;BA.debugLine="Private Sub P2Visible(bool As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="lblP2.Enabled = bool";
Debug.ShouldStop(268435456);
main.mostCurrent._lblp2.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 94;BA.debugLine="txtP2.Enabled = bool";
Debug.ShouldStop(536870912);
main.mostCurrent._txtp2.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 95;BA.debugLine="btnP2.Enabled = bool";
Debug.ShouldStop(1073741824);
main.mostCurrent._btnp2.runMethod(true,"setEnabled",_bool);
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
public static RemoteObject  _timer_tick() throws Exception{
try {
		Debug.PushSubsStack("timer_tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,51);
if (RapidSub.canDelegate("timer_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","timer_tick");}
 BA.debugLineNum = 51;BA.debugLine="Private Sub timer_tick";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="time = time - 1";
Debug.ShouldStop(524288);
main._time = BA.numberCast(byte.class, RemoteObject.solve(new RemoteObject[] {main._time,RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 53;BA.debugLine="lblTiempo.Text = time";
Debug.ShouldStop(1048576);
main.mostCurrent._lbltiempo.runMethod(true,"setText",BA.ObjectToCharSequence(main._time));
 BA.debugLineNum = 55;BA.debugLine="If time == 0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",main._time,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 56;BA.debugLine="timer.Enabled = False";
Debug.ShouldStop(8388608);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 57;BA.debugLine="GameOver(\"\")";
Debug.ShouldStop(16777216);
_gameover(RemoteObject.createImmutable(""));
 };
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("turnChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,139);
if (RapidSub.canDelegate("turnchange")) { return b4a.example.main.remoteMe.runUserSub(false, "main","turnchange");}
 BA.debugLineNum = 139;BA.debugLine="Private Sub turnChange()";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="If turn == 1 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main._turn,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 141;BA.debugLine="turn = 2";
Debug.ShouldStop(4096);
main._turn = BA.numberCast(byte.class, 2);
 BA.debugLineNum = 142;BA.debugLine="P1Visible(False)";
Debug.ShouldStop(8192);
_p1visible(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 143;BA.debugLine="P2Visible(True)";
Debug.ShouldStop(16384);
_p2visible(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 144;BA.debugLine="txtP2.RequestFocus";
Debug.ShouldStop(32768);
main.mostCurrent._txtp2.runVoidMethod ("RequestFocus");
 }else {
 BA.debugLineNum = 146;BA.debugLine="turn = 1";
Debug.ShouldStop(131072);
main._turn = BA.numberCast(byte.class, 1);
 BA.debugLineNum = 147;BA.debugLine="P1Visible(True)";
Debug.ShouldStop(262144);
_p1visible(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 148;BA.debugLine="P2Visible(False)";
Debug.ShouldStop(524288);
_p2visible(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 149;BA.debugLine="txtP1.RequestFocus";
Debug.ShouldStop(1048576);
main.mostCurrent._txtp1.runVoidMethod ("RequestFocus");
 };
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}