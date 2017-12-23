VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T0 = 4
    parm _T0
    _T1 =  call _Alloc
    _T2 = VTBL <_Main>
    *(_T1 + 0) = _T2
    return _T1
}

FUNCTION(main) {
memo ''
main:
    _T9 = 6
    _T3 = _T9
    _T10 = 2
    _T4 = _T10
    _T11 = 3
    _T5 = _T11
java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:258)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
    parm _T4
    call _PrintInt
    _T12 = "\n"
    parm _T12
    call _PrintString
    _T13 = 3
    _T6 = _T13
java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:258)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
    parm _T4
    call _PrintInt
    _T14 = "\n"
    parm _T14
    call _PrintString
java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:258)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
    parm _T4
    call _PrintInt
    _T15 = "\n"
    parm _T15
    call _PrintString
java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:258)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
    parm _T4
    call _PrintInt
    _T16 = "\n"
    parm _T16
    call _PrintString
    _T18 = 0
java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:258)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
    _T7 = _T17
    _T8 = _T18
    parm _T7
    call _PrintInt
    _T19 = "+"
    parm _T19
    call _PrintString
    parm _T8
    call _PrintInt
    _T20 = "j"
    parm _T20
    call _PrintString
    _T21 = "\n"
    parm _T21
    call _PrintString
    _T23 = 0
java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:258)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
    _T7 = _T22
    _T8 = _T23
    parm _T7
    call _PrintInt
    _T24 = "+"
    parm _T24
    call _PrintString
    parm _T8
    call _PrintInt
    _T25 = "j"
    parm _T25
    call _PrintString
    _T26 = "\n"
    parm _T26
    call _PrintString
}

