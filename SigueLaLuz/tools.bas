B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=11.5
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Public Sub GenerateRandomPlaces(level As Byte, limit As Byte) As Byte()
	Dim randomPlaces((level + 4) * 2) As Byte
	
	For i = 0 To randomPlaces.Length - 1
		If i Mod 2 == 0 Then
			randomPlaces(i) = Rnd(0, limit)
		End If
	Next
	
	Return randomPlaces
End Sub

Public Sub MessageLogger(message As String)
	Log(message)
	ToastMessageShow(message, False)
End Sub

Public Sub SetButtonTags(panel As Panel)
	For i = 0 To panel.NumberOfViews - 1
		panel.GetView(i).Tag = i
		panel.GetView(i).As(Button).Text = i + 1
	Next
End Sub

Public Sub ButtonState(panel As Panel, bool As Boolean)
	For Each view As B4XView In panel
		view.Enabled = bool
	Next
End Sub


Public Sub setColorViews(panel As Panel, colorBg As ColorDrawable)
	For Each view As Button In panel
		view.Background = colorBg
		view.TextColor = Colors.RGB(242, 242, 247)
'		view.TextColor = Colors.RGB(28, 28, 30)
	Next
End Sub