package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class tools {
private static tools mostCurrent = new tools();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static byte _btnval = (byte)0;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.suma1 _suma1 = null;
public b4a.example.mult _mult = null;
public b4a.example.suma2 _suma2 = null;
public b4a.example.tablas _tablas = null;
public static String  _test(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="tools";
if (Debug.shouldDelegate(null, "test", false))
	 {return ((String) Debug.delegate(null, "test", new Object[] {_ba}));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Public Sub test";
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="End Sub";
return "";
}
}