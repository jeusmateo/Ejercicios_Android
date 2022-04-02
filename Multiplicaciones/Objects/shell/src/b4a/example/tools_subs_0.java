package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tools_subs_0 {


public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public btnVal As Byte";
tools._btnval = RemoteObject.createImmutable((byte)0);
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _test(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("test (tools) ","tools",6,_ba,tools.mostCurrent,9);
if (RapidSub.canDelegate("test")) { return b4a.example.tools.remoteMe.runUserSub(false, "tools","test", _ba);}
;
 BA.debugLineNum = 9;BA.debugLine="Public Sub test";
Debug.ShouldStop(256);
 BA.debugLineNum = 11;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}