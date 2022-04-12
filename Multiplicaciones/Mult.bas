B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
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
	
	Private num1, num2, res As Int
	
	Private pnlMain As Panel
	Private lblCombo As Label
	
	
	Private btnIniciar As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("Multi")
	
	For Each element As B4XView In pnlMain
		element.Visible = False
	Next
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub btnIniciar_Click
	Start
End Sub

Private Sub btnEvent_Click
	Dim btn As Button = Sender
	Dim btnValue As Int = btn.Text
	
	If btnValue == res Then
		ToastMessageShow("Correcto! 🎉", False)
		Main.combo = Main.combo + 1
	Else
		ToastMessageShow("Incorrecto! 😔", False)
		Main.combo = 0
	End If
	
	lblCombo.Text = "COMBO: " & Main.combo
	
	
	GenerateNum
	GenerateOptions
	
End Sub

Private Sub GenerateNum
	Select Main.btnVal
		Case 3:
			num1 = Rnd(1, 11)
			num2 = Rnd(1, 11)
			
		Case 4:
			num1 = Rnd(1, 101)
			num2 = Rnd(1, 11)
	End Select
	
	res = num1 * num2
	
	lblN1.Text = num1
	lblN2.Text = num2
	
	Log(res)
	
End Sub

Private Sub GenerateOptions
	Dim r1, r2, r3 As Int = 0
	Dim limit As Int = 0
	Dim resPos As Byte = Rnd(0, 4)
	
	pnlOpciones.GetView(resPos).As(Button).Text = res

	Select Main.btnVal
		Case 3:
			limit = 101
		Case 4:
			limit = 1001
	End Select
	
	Do Until (r1 <> r2 And r1 <> r3 And r1 <> res And r2 <> res And r2 <> r3 And r3 <> res)
		r1 = Rnd(1, limit)
		r2 = Rnd(1, limit)
		r3 = Rnd(1, limit)
	Loop
	
	Select resPos
		Case 0:
			pnlOpciones.GetView(1).As(Button).Text = r1
			pnlOpciones.GetView(2).As(Button).Text = r2
			pnlOpciones.GetView(3).As(Button).Text = r3
		Case 1:
			pnlOpciones.GetView(0).As(Button).Text = r1
			pnlOpciones.GetView(2).As(Button).Text = r2
			pnlOpciones.GetView(3).As(Button).Text = r3
		Case 2:
			pnlOpciones.GetView(0).As(Button).Text = r1
			pnlOpciones.GetView(1).As(Button).Text = r2
			pnlOpciones.GetView(3).As(Button).Text = r3
		Case 3:
			pnlOpciones.GetView(0).As(Button).Text = r1
			pnlOpciones.GetView(1).As(Button).Text = r2
			pnlOpciones.GetView(2).As(Button).Text = r3
						
	End Select
	
End Sub

Private Sub Start
	btnIniciar.Visible = False
	
	For Each element As B4XView In pnlMain
		element.Visible = True
	Next
	
	lblCombo.Text = "COMBO: 0"
	
	GenerateNum
	GenerateOptions
	
	
End Sub



