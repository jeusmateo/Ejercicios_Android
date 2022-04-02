
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class tools implements IRemote{
	public static tools mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public tools() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, tools.class);
    static {
		mostCurrent = new tools();
        remoteMe = RemoteObject.declareNull("b4a.example.tools");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("tools"), "b4a.example.tools");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.example.tools"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _btnval = RemoteObject.createImmutable((byte)0);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.suma1 _suma1 = null;
public static b4a.example.mult _mult = null;
public static b4a.example.suma2 _suma2 = null;
public static b4a.example.tablas _tablas = null;
  public Object[] GetGlobals() {
		return new Object[] {"btnVal",tools._btnval,"Main",Debug.moduleToString(b4a.example.main.class),"Mult",Debug.moduleToString(b4a.example.mult.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"Suma1",Debug.moduleToString(b4a.example.suma1.class),"Suma2",Debug.moduleToString(b4a.example.suma2.class),"Tablas",Debug.moduleToString(b4a.example.tablas.class)};
}
}