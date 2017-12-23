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
    _T24 =  call _people_New
    _T22 = _T24
    parm _T22
    _T25 = *(_T22 + 0)
    _T26 = *(_T25 + 16)
    call _T26
java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:259)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:71)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
    _T27 = 99
    parm _T23
    parm _T27
    _T28 = *(_T23 + 0)
    _T29 = *(_T28 + 8)
    call _T29
    _T30 = "a: \n"
    parm _T30
    call _PrintString
    parm _T22
    _T31 = *(_T22 + 0)
    _T32 = *(_T31 + 12)
    call _T32
    _T33 = "b: \n"
    parm _T33
    call _PrintString
    parm _T23
    _T34 = *(_T23 + 0)
    _T35 = *(_T34 + 12)
    call _T35
}

FUNCTION(_animal.setage) {
memo '_T0:4 _T1:8'
_animal.setage:
    _T36 = *(_T0 + 4)
    *(_T0 + 4) = _T1
}

FUNCTION(_animal.getage) {
memo '_T2:4'
_animal.getage:
    _T37 = *(_T2 + 4)
    parm _T37
    call _PrintInt
    _T38 = "\n"
    parm _T38
    call _PrintString
}

FUNCTION(_people.setaniage) {
memo '_T3:4 _T4:8'
_people.setaniage:
    _T39 = *(_T3 + 16)
    parm _T39
    parm _T4
    _T40 = *(_T39 + 0)
    _T41 = *(_T40 + 8)
    call _T41
}

FUNCTION(_people.getage) {
memo '_T5:4'
_people.getage:
    _T42 = *(_T5 + 4)
    parm _T42
    call _PrintInt
    _T43 = "\n"
    parm _T43
    call _PrintString
    _T44 = *(_T5 + 8)
    _T45 = *(_T5 + 12)
    parm _T44
    call _PrintInt
    _T46 = "+"
    parm _T46
    call _PrintString
    parm _T45
    call _PrintInt
    _T47 = "j"
    parm _T47
    call _PrintString
    _T48 = "\n"
    parm _T48
    call _PrintString
    _T49 = *(_T5 + 16)
    parm _T49
    _T50 = *(_T49 + 0)
    _T51 = *(_T50 + 12)
    call _T51
    _T52 = *(_T5 + 20)
    parm _T52
    call _PrintString
    _T53 = "\n"
    parm _T53
    call _PrintString
}

FUNCTION(_people.setage) {
memo '_T6:4'
_people.setage:
    _T54 = *(_T6 + 16)
    _T55 =  call _animal_New
    *(_T6 + 16) = _T55
    _T56 = 100
    parm _T6
    parm _T56
    _T57 = *(_T6 + 0)
    _T58 = *(_T57 + 8)
    call _T58
    _T59 = *(_T6 + 4)
    _T60 = 10
    *(_T6 + 4) = _T60
    _T61 = *(_T6 + 20)
    _T62 = "11"
    *(_T6 + 20) = _T62
    _T63 = *(_T6 + 8)
    _T64 = *(_T6 + 12)
    _T65 = 89
    _T67 = 0
    _T66 = _T65
    _T68 = 0
    _T69 = 8
    _T70 = (_T66 + _T68)
    _T71 = (_T67 + _T69)
    *(_T6 + 8) = _T70
    *(_T6 + 12) = _T71
}

