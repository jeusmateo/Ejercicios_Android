package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(1);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("btnPlay_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,73);
if (RapidSub.canDelegate("btnplay_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnplay_click");}
RemoteObject _suma = RemoteObject.createImmutable((byte)0);
RemoteObject _rand1 = RemoteObject.createImmutable((byte)0);
RemoteObject _rand2 = RemoteObject.createImmutable((byte)0);
 BA.debugLineNum = 73;BA.debugLine="Private Sub btnPlay_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="Dim suma As Byte";
Debug.ShouldStop(512);
_suma = RemoteObject.createImmutable((byte)0);Debug.locals.put("suma", _suma);
 BA.debugLineNum = 76;BA.debugLine="Private rand1, rand2 As Byte";
Debug.ShouldStop(2048);
_rand1 = RemoteObject.createImmutable((byte)0);Debug.locals.put("rand1", _rand1);
_rand2 = RemoteObject.createImmutable((byte)0);Debug.locals.put("rand2", _rand2);
 BA.debugLineNum = 78;BA.debugLine="rand1 = Rnd(1, 7)";
Debug.ShouldStop(8192);
_rand1 = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 7))));Debug.locals.put("rand1", _rand1);
 BA.debugLineNum = 79;BA.debugLine="rand2 = Rnd(1, 7)";
Debug.ShouldStop(16384);
_rand2 = BA.numberCast(byte.class, main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 7))));Debug.locals.put("rand2", _rand2);
 BA.debugLineNum = 81;BA.debugLine="suma = rand1 + rand2";
Debug.ShouldStop(65536);
_suma = BA.numberCast(byte.class, RemoteObject.solve(new RemoteObject[] {_rand1,_rand2}, "+",1, 1));Debug.locals.put("suma", _suma);
 BA.debugLineNum = 84;BA.debugLine="imgMensaje.Visible = True";
Debug.ShouldStop(524288);
main.mostCurrent._imgmensaje.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 86;BA.debugLine="If suma == 7 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_suma,BA.numberCast(double.class, 7))) { 
 BA.debugLineNum = 87;BA.debugLine="imgMensaje.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(4194304);
main.mostCurrent._imgmensaje.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Ganado.png"))).getObject())));
 }else {
 BA.debugLineNum = 89;BA.debugLine="imgMensaje.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(16777216);
main.mostCurrent._imgmensaje.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Perdido.png"))).getObject())));
 };
 BA.debugLineNum = 92;BA.debugLine="setImgDado(rand1, imgDado1)";
Debug.ShouldStop(134217728);
_setimgdado(_rand1,main.mostCurrent._imgdado1);
 BA.debugLineNum = 93;BA.debugLine="setImgDado(rand2, imgDado2)";
Debug.ShouldStop(268435456);
_setimgdado(_rand2,main.mostCurrent._imgdado2);
 BA.debugLineNum = 95;BA.debugLine="intentos = intentos + 1";
Debug.ShouldStop(1073741824);
main._intentos = RemoteObject.solve(new RemoteObject[] {main._intentos,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 96;BA.debugLine="lblIntentois.Text = \"Intentos: \" & intentos";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lblintentois.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Intentos: "),main._intentos)));
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");}
 BA.debugLineNum = 44;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
Debug.ShouldStop(4096);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Hello world!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("B4X"))));
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private imgDado1 As ImageView";
main.mostCurrent._imgdado1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private imgDado2 As ImageView";
main.mostCurrent._imgdado2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private imgMensaje As ImageView";
main.mostCurrent._imgmensaje = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private intentos As Int";
main._intentos = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Private lblIntentois As Label";
main.mostCurrent._lblintentois = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setimgdado(RemoteObject _numdado,RemoteObject _imgview) throws Exception{
try {
		Debug.PushSubsStack("setImgDado (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,48);
if (RapidSub.canDelegate("setimgdado")) { return b4a.example.main.remoteMe.runUserSub(false, "main","setimgdado", _numdado, _imgview);}
Debug.locals.put("numDado", _numdado);
Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 48;BA.debugLine="Private Sub setImgDado(numDado As Byte, imgView As";
Debug.ShouldStop(32768);
 BA.debugLineNum = 50;BA.debugLine="Select numDado";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(_numdado,BA.numberCast(byte.class, 1),BA.numberCast(byte.class, 2),BA.numberCast(byte.class, 3),BA.numberCast(byte.class, 4),BA.numberCast(byte.class, 5),BA.numberCast(byte.class, 6))) {
case 0: {
 BA.debugLineNum = 52;BA.debugLine="imgView.SetBackgroundImage(LoadBitmap(File.DirA";
Debug.ShouldStop(524288);
_imgview.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dado1.png"))).getObject())));
 break; }
case 1: {
 BA.debugLineNum = 55;BA.debugLine="imgView.SetBackgroundImage(LoadBitmap(File.DirA";
Debug.ShouldStop(4194304);
_imgview.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dado2.png"))).getObject())));
 break; }
case 2: {
 BA.debugLineNum = 58;BA.debugLine="imgView.SetBackgroundImage(LoadBitmap(File.DirA";
Debug.ShouldStop(33554432);
_imgview.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dado3.png"))).getObject())));
 break; }
case 3: {
 BA.debugLineNum = 61;BA.debugLine="imgView.SetBackgroundImage(LoadBitmap(File.DirA";
Debug.ShouldStop(268435456);
_imgview.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dado4.png"))).getObject())));
 break; }
case 4: {
 BA.debugLineNum = 64;BA.debugLine="imgView.SetBackgroundImage(LoadBitmap(File.DirA";
Debug.ShouldStop(-2147483648);
_imgview.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dado5.png"))).getObject())));
 break; }
case 5: {
 BA.debugLineNum = 67;BA.debugLine="imgView.SetBackgroundImage(LoadBitmap(File.DirA";
Debug.ShouldStop(4);
_imgview.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dado6.png"))).getObject())));
 break; }
}
;
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}