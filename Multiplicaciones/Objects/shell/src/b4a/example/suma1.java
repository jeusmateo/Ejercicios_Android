
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

public class suma1 implements IRemote{
	public static suma1 mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public suma1() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("suma1"), "b4a.example.suma1");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, suma1.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _pnlscreen = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlmain = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _num1 = RemoteObject.createImmutable((byte)0);
public static RemoteObject _num2 = RemoteObject.createImmutable((byte)0);
public static RemoteObject _operation = RemoteObject.createImmutable((byte)0);
public static RemoteObject _res = RemoteObject.createImmutable(0);
public static RemoteObject _lbln1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbln2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _btniniciar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _txtnum = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lbloperation = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.mult _mult = null;
public static b4a.example.suma2 _suma2 = null;
public static b4a.example.tablas _tablas = null;
public static b4a.example.tools _tools = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",suma1.mostCurrent._activity,"btnIniciar",suma1.mostCurrent._btniniciar,"lblN1",suma1.mostCurrent._lbln1,"lblN2",suma1.mostCurrent._lbln2,"lblOperation",suma1.mostCurrent._lbloperation,"Main",Debug.moduleToString(b4a.example.main.class),"Mult",Debug.moduleToString(b4a.example.mult.class),"num1",suma1._num1,"num2",suma1._num2,"operation",suma1._operation,"pnlMain",suma1.mostCurrent._pnlmain,"pnlScreen",suma1.mostCurrent._pnlscreen,"res",suma1._res,"Starter",Debug.moduleToString(b4a.example.starter.class),"Suma2",Debug.moduleToString(b4a.example.suma2.class),"Tablas",Debug.moduleToString(b4a.example.tablas.class),"Tools",Debug.moduleToString(b4a.example.tools.class),"txtNum",suma1.mostCurrent._txtnum};
}
}