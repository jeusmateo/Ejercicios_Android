B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.2
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

'	Private pnlOptions As Panel
	Private pnlScreen As Panel
	Private pnlMain As Panel
	
	Private num1, num2, operation As Byte
	Private res As Int
	
	Private lblN1, lblN2 As Label
	Private btnIniciar As Button
	Private txtNum As EditText
	Private lblOperation As Label
	Private pnlSumaResta As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	
	Activity.LoadLayout("SumaResta")
	
	For Each element As B4XView In pnlMain
		element.Enabled = False
	Next
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub btnVolver_Click
	StartActivity(Main)
End Sub


Private Sub btnIniciar_Click
	Start
End Sub

Private Sub btnSend_Click
	CheckResult
End Sub

Private Sub txtNum_TextChanged (Old As String, New As String)
	txtNum.SelectionStart = 0
End Sub



Private Sub Start
	btnIniciar.Enabled = False
	
	For Each element As B4XView In pnlMain
		element.Enabled = True
	Next
	
	txtNum.Text = ""
	txtNum.RequestFocus
	
	Select Main.btnVal
		Case 1:
			num1 = Rnd(1, 11)
			num2 = Rnd(1, 11)
			
		Case 2:
			num1 = Rnd(1, 101)
			num2 = Rnd(1, 101)
	End Select
	
	operation = Rnd(0, 2)
	
	
	Select operation
		Case 0:
			lblOperation.Text = "➕"
			res = num1 + num2
			
		Case 1:
			Dim aux As Byte = 0
			lblOperation.Text = "➖"
			
			If num2 > num1 Then
				aux = num1
				
				num1 = num2
				num2 = aux
			
			End If
			res = num1 - num2
			
	End Select

	Log(res)
	
	lblN1.Text = num1
	lblN2.Text = num2

End Sub

Private Sub CheckResult
	If txtNum.Text == "" Then
		MsgboxAsync("Digita un número", "⚠Syntax Eror")
		Return
	End If
	
	Dim num As Int = txtNum.Text

	If num == res Then
		ToastMessageShow("Correcto! 🎉", False)
	Else
		ToastMessageShow("Incorrecto! 😔", False)
	End If
	
	Start
End Sub
