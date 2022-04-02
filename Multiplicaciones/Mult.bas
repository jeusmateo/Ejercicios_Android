B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private pnlOpciones As Panel
	Private lblN1 As Label
	Private lblN2 As Label
	
	Private num1, num2 As Byte
	Private res As Int
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("Multi")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub btnIniciar_Click
	Start
End Sub

Private Sub Start
	
	Select Main.btnVal
		Case 3:
			num1 = Rnd(1, 11)
			num2 = Rnd(1, 11)
			
		Case 4:
			num1 = Rnd(1, 101)
			num2 = Rnd(1, 101)	
	End Select
	
	
	
End Sub