VTABLE(_A) {
    <empty>
    A
    _A.setA;
    _A.print;
    _A.allprint;
    _A.fun;
}

VTABLE(_B) {
    _A
    B
    _A.setA;
    _B.print;
    _B.allprint;
    _B.fun;
    _B.setB;
}

VTABLE(_C) {
    _A
    C
    _A.setA;
    _C.print;
    _C.allprint;
    _C.fun;
    _C.setC;
}

VTABLE(_D) {
    _B
    D
    _A.setA;
    _D.print;
    _D.allprint;
    _D.fun;
    _B.setB;
    _D.setD;
}

VTABLE(_E) {
    _C
    E
    _A.setA;
    _E.print;
    _E.allprint;
    _E.fun;
    _C.setC;
    _E.setE;
}

VTABLE(_F) {
    _E
    F
    _A.setA;
    _F.print;
    _F.allprint;
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
    _G.allprint;
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
    _T41 = 12
    parm _T41
    _T42 =  call _Alloc
    _T43 = 0
    *(_T42 + 4) = _T43
    *(_T42 + 8) = _T43
    _T44 = VTBL <_A>
    *(_T42 + 0) = _T44
    return _T42
}

FUNCTION(_B_New) {
memo ''
_B_New:
    _T45 = 20
    parm _T45
    _T46 =  call _Alloc
    _T47 = 0
    *(_T46 + 4) = _T47
    *(_T46 + 8) = _T47
    *(_T46 + 12) = _T47
    *(_T46 + 16) = _T47
    _T48 = VTBL <_B>
    *(_T46 + 0) = _T48
    return _T46
}

FUNCTION(_C_New) {
memo ''
_C_New:
    _T49 = 20
    parm _T49
    _T50 =  call _Alloc
    _T51 = 0
    *(_T50 + 4) = _T51
    *(_T50 + 8) = _T51
    *(_T50 + 12) = _T51
    *(_T50 + 16) = _T51
    _T52 = VTBL <_C>
    *(_T50 + 0) = _T52
    return _T50
}

FUNCTION(_D_New) {
memo ''
_D_New:
    _T53 = 28
    parm _T53
    _T54 =  call _Alloc
    _T55 = 0
    _T56 = 4
    _T57 = (_T54 + _T53)
_L41:
    _T58 = (_T57 - _T56)
    _T57 = _T58
    _T59 = (_T53 - _T56)
    _T53 = _T59
    if (_T53 == 0) branch _L42
    *(_T57 + 0) = _T55
    branch _L41
_L42:
    _T60 = VTBL <_D>
    *(_T57 + 0) = _T60
    return _T57
}

FUNCTION(_E_New) {
memo ''
_E_New:
    _T61 = 28
    parm _T61
    _T62 =  call _Alloc
    _T63 = 0
    _T64 = 4
    _T65 = (_T62 + _T61)
_L44:
    _T66 = (_T65 - _T64)
    _T65 = _T66
    _T67 = (_T61 - _T64)
    _T61 = _T67
    if (_T61 == 0) branch _L45
    *(_T65 + 0) = _T63
    branch _L44
_L45:
    _T68 = VTBL <_E>
    *(_T65 + 0) = _T68
    return _T65
}

FUNCTION(_F_New) {
memo ''
_F_New:
    _T69 = 36
    parm _T69
    _T70 =  call _Alloc
    _T71 = 0
    _T72 = 4
    _T73 = (_T70 + _T69)
_L47:
    _T74 = (_T73 - _T72)
    _T73 = _T74
    _T75 = (_T69 - _T72)
    _T69 = _T75
    if (_T69 == 0) branch _L48
    *(_T73 + 0) = _T71
    branch _L47
_L48:
    _T76 = VTBL <_F>
    *(_T73 + 0) = _T76
    return _T73
}

FUNCTION(_G_New) {
memo ''
_G_New:
    _T77 = 24
    parm _T77
    _T78 =  call _Alloc
    _T79 = 0
    _T80 = 4
    _T81 = (_T78 + _T77)
_L50:
    _T82 = (_T81 - _T80)
    _T81 = _T82
    _T83 = (_T77 - _T80)
    _T77 = _T83
    if (_T77 == 0) branch _L51
    *(_T81 + 0) = _T79
    branch _L50
_L51:
    _T84 = VTBL <_G>
    *(_T81 + 0) = _T84
    return _T81
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T85 = 4
    parm _T85
    _T86 =  call _Alloc
    _T87 = VTBL <_Main>
    *(_T86 + 0) = _T87
    return _T86
}

FUNCTION(_A.setA) {
memo '_T0:4 _T1:8 _T2:12'
_A.setA:
    _T88 = *(_T0 + 4)
    *(_T0 + 4) = _T1
    _T89 = *(_T0 + 8)
    *(_T0 + 8) = _T2
}

FUNCTION(_A.print) {
memo '_T3:4'
_A.print:
    _T90 = " a="
    parm _T90
    call _PrintString
    _T91 = *(_T3 + 4)
    parm _T91
    call _PrintInt
    _T92 = " a1="
    parm _T92
    call _PrintString
    _T93 = *(_T3 + 8)
    parm _T93
    call _PrintInt
    _T94 = " "
    parm _T94
    call _PrintString
}

FUNCTION(_A.allprint) {
memo '_T4:4'
_A.allprint:
    parm _T4
    _T95 = *(_T4 + 0)
    _T96 = *(_T95 + 12)
    call _T96
}

FUNCTION(_A.fun) {
memo '_T5:4'
_A.fun:
    _T97 = "A"
    parm _T97
    call _PrintString
    parm _T5
    _T98 = *(_T5 + 0)
    _T99 = *(_T98 + 12)
    call _T99
    _T100 = "\n"
    parm _T100
    call _PrintString
}

FUNCTION(_B.setB) {
memo '_T6:4 _T7:8 _T8:12'
_B.setB:
    _T101 = *(_T6 + 12)
    *(_T6 + 12) = _T7
    _T102 = *(_T6 + 16)
    *(_T6 + 16) = _T8
}

FUNCTION(_B.print) {
memo '_T9:4'
_B.print:
    _T103 = " b="
    parm _T103
    call _PrintString
    _T104 = *(_T9 + 12)
    parm _T104
    call _PrintInt
    _T105 = " b1="
    parm _T105
    call _PrintString
    _T106 = *(_T9 + 16)
    parm _T106
    call _PrintInt
    _T107 = " "
    parm _T107
    call _PrintString
}

FUNCTION(_B.allprint) {
memo '_T10:4'
_B.allprint:
Exception in thread "main" java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:308)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
