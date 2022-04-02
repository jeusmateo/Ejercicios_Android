package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class suma1_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","activity_create", _firsttime);}
RemoteObject _element = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"suma1\")";
Debug.ShouldStop(1);
suma1.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("suma1")),suma1.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="For Each element As B4XView In pnlMain";
Debug.ShouldStop(4);
_element = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
{
final RemoteObject group2 = suma1.mostCurrent._pnlmain;
final int groupLen2 = group2.runMethod(true,"getSize").<Integer>get()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_element = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), group2.runMethod(false,"Get",index2));Debug.locals.put("element", _element);
Debug.locals.put("element", _element);
 BA.debugLineNum = 36;BA.debugLine="element.Enabled = False";
Debug.ShouldStop(8);
_element.runMethod(true,"setEnabled",suma1.mostCurrent.__c.getField(true,"False"));
 }
}Debug.locals.put("element", _element);
;
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Pause (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,45);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Resume (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,41);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","activity_resume");}
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btniniciar_click() throws Exception{
try {
		Debug.PushSubsStack("btnIniciar_Click (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,54);
if (RapidSub.canDelegate("btniniciar_click")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","btniniciar_click");}
 BA.debugLineNum = 54;BA.debugLine="Private Sub btnIniciar_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Start";
Debug.ShouldStop(4194304);
_start();
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsend_click() throws Exception{
try {
		Debug.PushSubsStack("btnSend_Click (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,58);
if (RapidSub.canDelegate("btnsend_click")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","btnsend_click");}
 BA.debugLineNum = 58;BA.debugLine="Private Sub btnSend_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="CheckResult";
Debug.ShouldStop(67108864);
_checkresult();
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnvolver_click() throws Exception{
try {
		Debug.PushSubsStack("btnVolver_Click (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,49);
if (RapidSub.canDelegate("btnvolver_click")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","btnvolver_click");}
 BA.debugLineNum = 49;BA.debugLine="Private Sub btnVolver_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(131072);
suma1.mostCurrent.__c.runVoidMethod ("StartActivity",suma1.processBA,(Object)((suma1.mostCurrent._main.getObject())));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _checkresult() throws Exception{
try {
		Debug.PushSubsStack("CheckResult (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,115);
if (RapidSub.canDelegate("checkresult")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","checkresult");}
RemoteObject _num = RemoteObject.createImmutable(0);
 BA.debugLineNum = 115;BA.debugLine="Private Sub CheckResult";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="If txtNum.Text == \"\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",suma1.mostCurrent._txtnum.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 117;BA.debugLine="MsgboxAsync(\"Favor de digitar un número\", \"⚠ Err";
Debug.ShouldStop(1048576);
suma1.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Favor de digitar un número")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("⚠ Error"))),suma1.processBA);
 BA.debugLineNum = 118;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 121;BA.debugLine="Dim num As Int = txtNum.Text";
Debug.ShouldStop(16777216);
_num = BA.numberCast(int.class, suma1.mostCurrent._txtnum.runMethod(true,"getText"));Debug.locals.put("num", _num);Debug.locals.put("num", _num);
 BA.debugLineNum = 123;BA.debugLine="If num == res Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_num,BA.numberCast(double.class, suma1._res))) { 
 BA.debugLineNum = 124;BA.debugLine="ToastMessageShow(\"Correcto! 🎉\", False)";
Debug.ShouldStop(134217728);
suma1.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correcto! 🎉")),(Object)(suma1.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 126;BA.debugLine="ToastMessageShow(\"Incorrecto! 😔\", False)";
Debug.ShouldStop(536870912);
suma1.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Incorrecto! 😔")),(Object)(suma1.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 129;BA.debugLine="Start";
Debug.ShouldStop(1);
_start();
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private pnlScreen As Panel";
suma1.mostCurrent._pnlscreen = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pnlMain As Panel";
suma1.mostCurrent._pnlmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private num1, num2, operation As Byte";
suma1._num1 = RemoteObject.createImmutable((byte)0);
suma1._num2 = RemoteObject.createImmutable((byte)0);
suma1._operation = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 21;BA.debugLine="Private res As Int";
suma1._res = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 23;BA.debugLine="Private lblN1, lblN2 As Label";
suma1.mostCurrent._lbln1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
suma1.mostCurrent._lbln2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private btnIniciar As Button";
suma1.mostCurrent._btniniciar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtNum As EditText";
suma1.mostCurrent._txtnum = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private lblOperation As Label";
suma1.mostCurrent._lbloperation = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _start() throws Exception{
try {
		Debug.PushSubsStack("Start (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,66);
if (RapidSub.canDelegate("start")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","start");}
RemoteObject _element = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _aux = RemoteObject.createImmutable((byte)0);
 BA.debugLineNum = 66;BA.debugLine="Private Sub Start";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="btnIniciar.Enabled = False";
Debug.ShouldStop(4);
suma1.mostCurrent._btniniciar.runMethod(true,"setEnabled",suma1.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 70;BA.debugLine="For Each element As B4XView In pnlMain";
Debug.ShouldStop(32);
_element = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
{
final RemoteObject group2 = suma1.mostCurrent._pnlmain;
final int groupLen2 = group2.runMethod(true,"getSize").<Integer>get()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_element = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), group2.runMethod(false,"Get",index2));Debug.locals.put("element", _element);
Debug.locals.put("element", _element);
 BA.debugLineNum = 71;BA.debugLine="element.Enabled = True";
Debug.ShouldStop(64);
_element.runMethod(true,"setEnabled",suma1.mostCurrent.__c.getField(true,"True"));
 }
}Debug.locals.put("element", _element);
;
 BA.debugLineNum = 74;BA.debugLine="txtNum.Text = \"\"";
Debug.ShouldStop(512);
suma1.mostCurrent._txtnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 75;BA.debugLine="txtNum.RequestFocus";
Debug.ShouldStop(1024);
suma1.mostCurrent._txtnum.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 77;BA.debugLine="Select Main.btnVal";
Debug.ShouldStop(4096);
switch (BA.switchObjectToInt(suma1.mostCurrent._main._btnval /*RemoteObject*/ ,BA.numberCast(byte.class, 1),BA.numberCast(byte.class, 2))) {
case 0: {
 BA.debugLineNum = 79;BA.debugLine="num1 = Rnd(1, 11)";
Debug.ShouldStop(16384);
suma1._num1 = BA.numberCast(byte.class, suma1.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 11))));
 BA.debugLineNum = 80;BA.debugLine="num2 = Rnd(1, 11)";
Debug.ShouldStop(32768);
suma1._num2 = BA.numberCast(byte.class, suma1.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 11))));
 break; }
case 1: {
 BA.debugLineNum = 82;BA.debugLine="num1 = Rnd(1, 101)";
Debug.ShouldStop(131072);
suma1._num1 = BA.numberCast(byte.class, suma1.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 101))));
 BA.debugLineNum = 83;BA.debugLine="num2 = Rnd(1, 101)";
Debug.ShouldStop(262144);
suma1._num2 = BA.numberCast(byte.class, suma1.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 101))));
 break; }
}
;
 BA.debugLineNum = 86;BA.debugLine="operation = Rnd(0, 2)";
Debug.ShouldStop(2097152);
suma1._operation = BA.numberCast(byte.class, suma1.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 88;BA.debugLine="Select operation";
Debug.ShouldStop(8388608);
switch (BA.switchObjectToInt(suma1._operation,BA.numberCast(byte.class, 0),BA.numberCast(byte.class, 1))) {
case 0: {
 BA.debugLineNum = 90;BA.debugLine="lblOperation.Text = \"➕\"";
Debug.ShouldStop(33554432);
suma1.mostCurrent._lbloperation.runMethod(true,"setText",BA.ObjectToCharSequence("➕"));
 BA.debugLineNum = 91;BA.debugLine="res = num1 + num2";
Debug.ShouldStop(67108864);
suma1._res = RemoteObject.solve(new RemoteObject[] {suma1._num1,suma1._num2}, "+",1, 1);
 break; }
case 1: {
 BA.debugLineNum = 94;BA.debugLine="Dim aux As Byte = 0";
Debug.ShouldStop(536870912);
_aux = BA.numberCast(byte.class, 0);Debug.locals.put("aux", _aux);Debug.locals.put("aux", _aux);
 BA.debugLineNum = 95;BA.debugLine="lblOperation.Text = \"➖\"";
Debug.ShouldStop(1073741824);
suma1.mostCurrent._lbloperation.runMethod(true,"setText",BA.ObjectToCharSequence("➖"));
 BA.debugLineNum = 97;BA.debugLine="If num2 > num1 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean(">",suma1._num2,BA.numberCast(double.class, suma1._num1))) { 
 BA.debugLineNum = 98;BA.debugLine="aux = num1";
Debug.ShouldStop(2);
_aux = suma1._num1;Debug.locals.put("aux", _aux);
 BA.debugLineNum = 100;BA.debugLine="num1 = num2";
Debug.ShouldStop(8);
suma1._num1 = suma1._num2;
 BA.debugLineNum = 101;BA.debugLine="num2 = aux";
Debug.ShouldStop(16);
suma1._num2 = _aux;
 };
 BA.debugLineNum = 104;BA.debugLine="res = num1 - num2";
Debug.ShouldStop(128);
suma1._res = RemoteObject.solve(new RemoteObject[] {suma1._num1,suma1._num2}, "-",1, 1);
 break; }
}
;
 BA.debugLineNum = 108;BA.debugLine="Log(res)";
Debug.ShouldStop(2048);
suma1.mostCurrent.__c.runVoidMethod ("LogImpl","51245226",BA.NumberToString(suma1._res),0);
 BA.debugLineNum = 110;BA.debugLine="lblN1.Text = num1";
Debug.ShouldStop(8192);
suma1.mostCurrent._lbln1.runMethod(true,"setText",BA.ObjectToCharSequence(suma1._num1));
 BA.debugLineNum = 111;BA.debugLine="lblN2.Text = num2";
Debug.ShouldStop(16384);
suma1.mostCurrent._lbln2.runMethod(true,"setText",BA.ObjectToCharSequence(suma1._num2));
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
public static RemoteObject  _txtnum_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtNum_TextChanged (suma1) ","suma1",2,suma1.mostCurrent.activityBA,suma1.mostCurrent,62);
if (RapidSub.canDelegate("txtnum_textchanged")) { return b4a.example.suma1.remoteMe.runUserSub(false, "suma1","txtnum_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 62;BA.debugLine="Private Sub txtNum_TextChanged (Old As String, New";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="txtNum.SelectionStart = 0";
Debug.ShouldStop(1073741824);
suma1.mostCurrent._txtnum.runMethod(true,"setSelectionStart",BA.numberCast(int.class, 0));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}