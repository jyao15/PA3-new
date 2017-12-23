VTABLE(_A) {
    <empty>
    A
    _A.setA;
    _A.print;
    _A.fun;
}

VTABLE(_B) {
    _A
    B
    _A.setA;
    _B.print;
    _B.fun;
    _B.setB;
}

VTABLE(_C) {
    _A
    C
    _A.setA;
    _C.print;
    _C.fun;
    _C.setC;
}

VTABLE(_D) {
    _B
    D
    _A.setA;
    _D.print;
    _D.fun;
    _B.setB;
    _D.setD;
}

VTABLE(_E) {
    _C
    E
    _A.setA;
    _E.print;
    _E.fun;
    _C.setC;
    _E.setE;
}

VTABLE(_F) {
    _E
    F
    _A.setA;
    _F.print;
    _F.fun;
    _C.setC;
    _E.setE;
    _F.setF;
}

VTABLE(_G) {
    _C
    G
    _A.setA;
    _G.print;
    _G.fun;
    _C.setC;
    _G.setG;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_A_New) {
memo ''
_A_New:
    _T34 = 12
    parm _T34
    _T35 =  call _Alloc
    _T36 = 0
    *(_T35 + 4) = _T36
    *(_T35 + 8) = _T36
    _T37 = VTBL <_A>
    *(_T35 + 0) = _T37
    return _T35
}

FUNCTION(_B_New) {
memo ''
_B_New:
    _T38 = 20
    parm _T38
    _T39 =  call _Alloc
    _T40 = 0
    *(_T39 + 4) = _T40
    *(_T39 + 8) = _T40
    *(_T39 + 12) = _T40
    *(_T39 + 16) = _T40
    _T41 = VTBL <_B>
    *(_T39 + 0) = _T41
    return _T39
}

FUNCTION(_C_New) {
memo ''
_C_New:
    _T42 = 20
    parm _T42
    _T43 =  call _Alloc
    _T44 = 0
    *(_T43 + 4) = _T44
    *(_T43 + 8) = _T44
    *(_T43 + 12) = _T44
    *(_T43 + 16) = _T44
    _T45 = VTBL <_C>
    *(_T43 + 0) = _T45
    return _T43
}

FUNCTION(_D_New) {
memo ''
_D_New:
    _T46 = 28
    parm _T46
    _T47 =  call _Alloc
    _T48 = 0
    _T49 = 4
    _T50 = (_T47 + _T46)
_L34:
    _T51 = (_T50 - _T49)
    _T50 = _T51
    _T52 = (_T46 - _T49)
    _T46 = _T52
    if (_T46 == 0) branch _L35
    *(_T50 + 0) = _T48
    branch _L34
_L35:
    _T53 = VTBL <_D>
    *(_T50 + 0) = _T53
    return _T50
}

FUNCTION(_E_New) {
memo ''
_E_New:
    _T54 = 28
    parm _T54
    _T55 =  call _Alloc
    _T56 = 0
    _T57 = 4
    _T58 = (_T55 + _T54)
_L37:
    _T59 = (_T58 - _T57)
    _T58 = _T59
    _T60 = (_T54 - _T57)
    _T54 = _T60
    if (_T54 == 0) branch _L38
    *(_T58 + 0) = _T56
    branch _L37
_L38:
    _T61 = VTBL <_E>
    *(_T58 + 0) = _T61
    return _T58
}

FUNCTION(_F_New) {
memo ''
_F_New:
    _T62 = 36
    parm _T62
    _T63 =  call _Alloc
    _T64 = 0
    _T65 = 4
    _T66 = (_T63 + _T62)
_L40:
    _T67 = (_T66 - _T65)
    _T66 = _T67
    _T68 = (_T62 - _T65)
    _T62 = _T68
    if (_T62 == 0) branch _L41
    *(_T66 + 0) = _T64
    branch _L40
_L41:
    _T69 = VTBL <_F>
    *(_T66 + 0) = _T69
    return _T66
}

FUNCTION(_G_New) {
memo ''
_G_New:
    _T70 = 24
    parm _T70
    _T71 =  call _Alloc
    _T72 = 0
    _T73 = 4
    _T74 = (_T71 + _T70)
_L43:
    _T75 = (_T74 - _T73)
    _T74 = _T75
    _T76 = (_T70 - _T73)
    _T70 = _T76
    if (_T70 == 0) branch _L44
    *(_T74 + 0) = _T72
    branch _L43
_L44:
    _T77 = VTBL <_G>
    *(_T74 + 0) = _T77
    return _T74
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T78 = 4
    parm _T78
    _T79 =  call _Alloc
    _T80 = VTBL <_Main>
    *(_T79 + 0) = _T80
    return _T79
}

FUNCTION(_A.setA) {
memo '_T0:4 _T1:8 _T2:12'
_A.setA:
    _T81 = *(_T0 + 4)
    *(_T0 + 4) = _T1
    _T82 = *(_T0 + 8)
    *(_T0 + 8) = _T2
}

FUNCTION(_A.print) {
memo '_T3:4'
_A.print:
    _T83 = " a="
    parm _T83
    call _PrintString
    _T84 = *(_T3 + 4)
    parm _T84
    call _PrintInt
    _T85 = " a1="
    parm _T85
    call _PrintString
    _T86 = *(_T3 + 8)
    parm _T86
    call _PrintInt
    _T87 = " "
    parm _T87
    call _PrintString
}

FUNCTION(_A.fun) {
memo '_T4:4'
_A.fun:
    _T88 = "A"
    parm _T88
    call _PrintString
    parm _T4
    _T89 = *(_T4 + 0)
    _T90 = *(_T89 + 12)
    call _T90
    _T91 = "\n"
    parm _T91
    call _PrintString
}

FUNCTION(_B.setB) {
memo '_T5:4 _T6:8 _T7:12'
_B.setB:
    _T92 = *(_T5 + 12)
    *(_T5 + 12) = _T6
    _T93 = *(_T5 + 16)
    *(_T5 + 16) = _T7
}

FUNCTION(_B.print) {
memo '_T8:4'
_B.print:
    _T94 = " b="
    parm _T94
    call _PrintString
    _T95 = *(_T8 + 12)
    parm _T95
    call _PrintInt
    _T96 = " b1="
    parm _T96
    call _PrintString
    _T97 = *(_T8 + 16)
    parm _T97
    call _PrintInt
    _T98 = " "
    parm _T98
    call _PrintString
}

FUNCTION(_B.fun) {
memo '_T9:4'
_B.fun:
    _T99 = "B"
    parm _T99
    call _PrintString
Exception in thread "main" java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:308)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
