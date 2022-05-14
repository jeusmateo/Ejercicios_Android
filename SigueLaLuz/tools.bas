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
	Dim randomPlaces((level + 2) * 2) As Byte
	
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