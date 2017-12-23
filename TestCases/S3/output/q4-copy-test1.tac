VTABLE(_Main) {
    <empty>
    Main
}

VTABLE(_animal) {
    <empty>
    animal
    _animal.setage;
    _animal.getage;
}

VTABLE(_people) {
    <empty>
    people
    _people.setaniage;
    _people.getage;
    _people.setage;
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T7 = 4
    parm _T7
    _T8 =  call _Alloc
    _T9 = VTBL <_Main>
    *(_T8 + 0) = _T9
    return _T8
}

FUNCTION(_animal_New) {
memo ''
_animal_New:
    _T10 = 8
    parm _T10
    _T11 =  call _Alloc
    _T12 = 0
    *(_T11 + 4) = _T12
    _T13 = VTBL <_animal>
    *(_T11 + 0) = _T13
    return _T11
}

FUNCTION(_people_New) {
memo ''
_people_New:
    _T14 = 24
    parm _T14
    _T15 =  call _Alloc
    _T16 = 0
    _T17 = 4
    _T18 = (_T15 + _T14)
_L17:
    _T19 = (_T18 - _T17)
    _T18 = _T19
    _T20 = (_T14 - _T17)
    _T14 = _T20
    if (_T14 == 0) branch _L18
    *(_T18 + 0) = _T16
    branch _L17
_L18:
    _T21 = VTBL <_people>
    *(_T18 + 0) = _T21
    return _T18
}

FUNCTION(main) {
memo ''
main:
    _T25 =  call _people_New
    _T23 = _T25
    parm _T23
    _T26 = *(_T23 + 0)
    _T27 = *(_T26 + 16)
    call _T27
java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:258)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
    _T28 = 99
    parm _T24
    parm _T28
    _T29 = *(_T24 + 0)
    _T30 = *(_T29 + 8)
    call _T30
    _T31 = "a: \n"
    parm _T31
    call _PrintString
    parm _T23
    _T32 = *(_T23 + 0)
    _T33 = *(_T32 + 12)
    call _T33
    _T34 = "b: \n"
    parm _T34
    call _PrintString
    parm _T24
    _T35 = *(_T24 + 0)
    _T36 = *(_T35 + 12)
    call _T36
}

FUNCTION(_animal.setage) {
memo '_T0:4 _T1:8'
_animal.setage:
    _T37 = *(_T0 + 4)
    *(_T0 + 4) = _T1
}

FUNCTION(_animal.getage) {
memo '_T2:4'
_animal.getage:
    _T38 = *(_T2 + 4)
    parm _T38
    call _PrintInt
    _T39 = "\n"
    parm _T39
    call _PrintString
}

FUNCTION(_people.setaniage) {
memo '_T3:4 _T4:8'
_people.setaniage:
    _T40 = *(_T3 + 16)
    parm _T40
    parm _T4
    _T41 = *(_T40 + 0)
    _T42 = *(_T41 + 8)
    call _T42
}

FUNCTION(_people.getage) {
memo '_T5:4'
_people.getage:
    _T43 = *(_T5 + 4)
    parm _T43
    call _PrintInt
    _T44 = "\n"
    parm _T44
    call _PrintString
    _T45 = *(_T5 + 8)
    _T46 = *(_T5 + 12)
    parm _T45
    call _PrintInt
    _T47 = "+"
    parm _T47
    call _PrintString
    parm _T46
    call _PrintInt
    _T48 = "j"
    parm _T48
    call _PrintString
    _T49 = "\n"
    parm _T49
    call _PrintString
    _T50 = *(_T5 + 16)
    parm _T50
    _T51 = *(_T50 + 0)
    _T52 = *(_T51 + 12)
    call _T52
    _T53 = *(_T5 + 20)
    parm _T53
    call _PrintString
    _T54 = "\n"
    parm _T54
    call _PrintString
}

FUNCTION(_people.setage) {
memo '_T6:4'
_people.setage:
    _T55 = *(_T6 + 16)
    _T56 =  call _animal_New
    *(_T6 + 16) = _T56
    _T57 = 100
    parm _T6
    parm _T57
    _T58 = *(_T6 + 0)
    _T59 = *(_T58 + 8)
    call _T59
    _T60 = *(_T6 + 4)
    _T61 = 10
    *(_T6 + 4) = _T61
    _T62 = *(_T6 + 20)
    _T63 = "11"
    *(_T6 + 20) = _T63
    _T64 = *(_T6 + 8)
    _T65 = *(_T6 + 12)
    _T66 = 89
    _T68 = 0
    _T67 = _T66
    _T69 = 0
    _T70 = 8
    _T71 = (_T67 + _T69)
    _T72 = (_T68 + _T70)
    *(_T6 + 8) = _T71
    *(_T6 + 12) = _T72
}

