package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(256);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 43;BA.debugLine="ViewEnabled(False)";
Debug.ShouldStop(1024);
_viewenabled(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 44;BA.debugLine="timer.Initialize(\"Timer\", 1000)";
Debug.ShouldStop(2048);
main._timer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("Timer")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,51);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 51;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,47);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16384);
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
public static RemoteObject  _btnplay_click() throws Exception{
try {
		Debug.PushSubsStack("btnPlay_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,116);
if (RapidSub.canDelegate("btnplay_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnplay_click");}
 BA.debugLineNum = 116;BA.debugLine="Private Sub btnPlay_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="StartGame";
Debug.ShouldStop(1048576);
_startgame();
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("GameOver (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,104);
if (RapidSub.canDelegate("gameover")) { return b4a.example.main.remoteMe.runUserSub(false, "main","gameover");}
 BA.debugLineNum = 104;BA.debugLine="Private Sub GameOver";
Debug.ShouldStop(128);
 BA.debugLineNum = 106;BA.debugLine="MsgboxAsync(\"GAME OVER\", \"\")";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("GAME OVER")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))),main.processBA);
 BA.debugLineNum = 108;BA.debugLine="btnPlay.Enabled = True";
Debug.ShouldStop(2048);
main.mostCurrent._btnplay.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 109;BA.debugLine="lblScore.Text = \"\"";
Debug.ShouldStop(4096);
main.mostCurrent._lblscore.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 111;BA.debugLine="ViewEnabled(False)";
Debug.ShouldStop(16384);
_viewenabled(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _generatenum() throws Exception{
try {
		Debug.PushSubsStack("GenerateNum (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,70);
if (RapidSub.canDelegate("generatenum")) { return b4a.example.main.remoteMe.runUserSub(false, "main","generatenum");}
 BA.debugLineNum = 70;BA.debugLine="Private Sub GenerateNum";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="randomNum1 = Rnd(1, 21)";
Debug.ShouldStop(64);
main._randomnum1 = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 21))));
 BA.debugLineNum = 72;BA.debugLine="randomNum2 = Rnd(1, 21)";
Debug.ShouldStop(128);
main._randomnum2 = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 21))));
 BA.debugLineNum = 73;BA.debugLine="randomNum3 = Rnd(1, 21)";
Debug.ShouldStop(256);
main._randomnum3 = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 21))));
 BA.debugLineNum = 75;BA.debugLine="If randomNum1 == randomNum2 Or randomNum1 == rand";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",main._randomnum1,BA.numberCast(double.class, main._randomnum2)) || RemoteObject.solveBoolean("=",main._randomnum1,BA.numberCast(double.class, main._randomnum3)) || RemoteObject.solveBoolean("=",main._randomnum2,BA.numberCast(double.class, main._randomnum3))) { 
 BA.debugLineNum = 76;BA.debugLine="randomNum1 = Rnd(1, 21)";
Debug.ShouldStop(2048);
main._randomnum1 = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 21))));
 BA.debugLineNum = 77;BA.debugLine="randomNum2 = Rnd(1, 21)";
Debug.ShouldStop(4096);
main._randomnum2 = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 21))));
 BA.debugLineNum = 78;BA.debugLine="randomNum3 = Rnd(1, 21)";
Debug.ShouldStop(8192);
main._randomnum3 = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 21))));
 };
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
 //BA.debugLineNum = 24;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private btnPlay As Button";
main.mostCurrent._btnplay = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private lblScore As Label";
main.mostCurrent._lblscore = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private randomNum1 As Byte";
main._randomnum1 = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 29;BA.debugLine="Private randomNum2 As Byte";
main._randomnum2 = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 30;BA.debugLine="Private randomNum3 As Byte";
main._randomnum3 = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 31;BA.debugLine="Private score As Int";
main._score = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 33;BA.debugLine="Private lives As Byte";
main._lives = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 35;BA.debugLine="Private Panel2 As Panel";
main.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

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
		Debug.PushSubsStack("StartGame (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,83);
if (RapidSub.canDelegate("startgame")) { return b4a.example.main.remoteMe.runUserSub(false, "main","startgame");}
int _i = 0;
 BA.debugLineNum = 83;BA.debugLine="Private Sub StartGame";
Debug.ShouldStop(262144);
 BA.debugLineNum = 85;BA.debugLine="For i = 0 To 19";
Debug.ShouldStop(1048576);
{
final int step1 = 1;
final int limit1 = 19;
_i = 0 ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 86;BA.debugLine="Panel1.GetView(i).As(Button).Text = i";
Debug.ShouldStop(2097152);
(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent._panel1.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))).getObject())).runMethod(true,"setText",BA.ObjectToCharSequence(_i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 89;BA.debugLine="GenerateNum";
Debug.ShouldStop(16777216);
_generatenum();
 BA.debugLineNum = 91;BA.debugLine="ToastMessageShow(randomNum1 & randomNum2 & random";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(main._randomnum1,main._randomnum2,main._randomnum3))),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 93;BA.debugLine="score = 0";
Debug.ShouldStop(268435456);
main._score = BA.numberCast(int.class, 0);
 BA.debugLineNum = 94;BA.debugLine="lives = 3";
Debug.ShouldStop(536870912);
main._lives = BA.numberCast(byte.class, 3);
 BA.debugLineNum = 96;BA.debugLine="btnPlay.Enabled = False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._btnplay.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 97;BA.debugLine="lblScore.Text = \"Score: \" & score";
Debug.ShouldStop(1);
main.mostCurrent._lblscore.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Score: "),main._score)));
 BA.debugLineNum = 99;BA.debugLine="timer.Enabled = True";
Debug.ShouldStop(4);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 101;BA.debugLine="ViewEnabled(True)";
Debug.ShouldStop(16);
_viewenabled(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tejuinocheck_click() throws Exception{
try {
		Debug.PushSubsStack("TejuinoCheck_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,122);
if (RapidSub.canDelegate("tejuinocheck_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","tejuinocheck_click");}
RemoteObject _button = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _btnvalue = RemoteObject.createImmutable((byte)0);
 BA.debugLineNum = 122;BA.debugLine="Private Sub TejuinoCheck_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="Dim button As Button";
Debug.ShouldStop(67108864);
_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("button", _button);
 BA.debugLineNum = 124;BA.debugLine="Dim btnValue As Byte";
Debug.ShouldStop(134217728);
_btnvalue = RemoteObject.createImmutable((byte)0);Debug.locals.put("btnValue", _btnvalue);
 BA.debugLineNum = 127;BA.debugLine="button = Sender";
Debug.ShouldStop(1073741824);
_button = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("button", _button);
 BA.debugLineNum = 128;BA.debugLine="btnValue = button.Tag";
Debug.ShouldStop(-2147483648);
_btnvalue = BA.numberCast(byte.class, _button.runMethod(false,"getTag"));Debug.locals.put("btnValue", _btnvalue);
 BA.debugLineNum = 130;BA.debugLine="If btnValue == randomNum1 Or btnValue == randomNu";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_btnvalue,BA.numberCast(double.class, main._randomnum1)) || RemoteObject.solveBoolean("=",_btnvalue,BA.numberCast(double.class, main._randomnum2)) || RemoteObject.solveBoolean("=",_btnvalue,BA.numberCast(double.class, main._randomnum3))) { 
 BA.debugLineNum = 132;BA.debugLine="lives = lives - 1";
Debug.ShouldStop(8);
main._lives = BA.numberCast(byte.class, RemoteObject.solve(new RemoteObject[] {main._lives,RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 133;BA.debugLine="ToastMessageShow(lives, False)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(main._lives)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 136;BA.debugLine="If lives == 0 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main._lives,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 137;BA.debugLine="GameOver";
Debug.ShouldStop(256);
_gameover();
 BA.debugLineNum = 138;BA.debugLine="Return";
Debug.ShouldStop(512);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 142;BA.debugLine="score = score + 5";
Debug.ShouldStop(8192);
main._score = RemoteObject.solve(new RemoteObject[] {main._score,RemoteObject.createImmutable(5)}, "+",1, 1);
 BA.debugLineNum = 143;BA.debugLine="lblScore.Text = \"Score: \" & score";
Debug.ShouldStop(16384);
main.mostCurrent._lblscore.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Score: "),main._score)));
 BA.debugLineNum = 145;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Timer_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,55);
if (RapidSub.canDelegate("timer_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","timer_tick");}
 BA.debugLineNum = 55;BA.debugLine="Private Sub Timer_Tick";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _viewenabled(RemoteObject _bool) throws Exception{
try {
		Debug.PushSubsStack("ViewEnabled (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,59);
if (RapidSub.canDelegate("viewenabled")) { return b4a.example.main.remoteMe.runUserSub(false, "main","viewenabled", _bool);}
RemoteObject _button = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
Debug.locals.put("bool", _bool);
 BA.debugLineNum = 59;BA.debugLine="Private Sub ViewEnabled(bool As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="For Each button As Button In Panel1";
Debug.ShouldStop(134217728);
_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
{
final RemoteObject group1 = main.mostCurrent._panel1;
final int groupLen1 = group1.runMethod(true,"getSize").<Integer>get()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_button = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), group1.runMethod(false,"Get",index1));Debug.locals.put("button", _button);
Debug.locals.put("button", _button);
 BA.debugLineNum = 61;BA.debugLine="button.Enabled = bool";
Debug.ShouldStop(268435456);
_button.runMethod(true,"setEnabled",_bool);
 }
}Debug.locals.put("button", _button);
;
 BA.debugLineNum = 64;BA.debugLine="For Each imgView As ImageView In Panel2";
Debug.ShouldStop(-2147483648);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
{
final RemoteObject group4 = main.mostCurrent._panel2;
final int groupLen4 = group4.runMethod(true,"getSize").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_imgview = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ImageViewWrapper"), group4.runMethod(false,"Get",index4));Debug.locals.put("imgView", _imgview);
Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 65;BA.debugLine="imgView.Visible = bool";
Debug.ShouldStop(1);
_imgview.runMethod(true,"setVisible",_bool);
 }
}Debug.locals.put("imgView", _imgview);
;
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}