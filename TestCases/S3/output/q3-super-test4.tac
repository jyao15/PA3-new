start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T1
end vardef in methoddef: int Temp: _T1 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T2
end vardef in methoddef: int Temp: _T2 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T7
end vardef in methoddef: int Temp: _T7 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T8
end vardef in methoddef: int Temp: _T8 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T13
end vardef in methoddef: int Temp: _T13 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T14
end vardef in methoddef: int Temp: _T14 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T19
end vardef in methoddef: int Temp: _T19 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T20
end vardef in methoddef: int Temp: _T20 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T25
end vardef in methoddef: int Temp: _T25 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T26
end vardef in methoddef: int Temp: _T26 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T30
end vardef in methoddef: int Temp: _T30 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T31
end vardef in methoddef: int Temp: _T31 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T36
end vardef in methoddef: int Temp: _T36 Temp2: null
genMemo: _T0:4 _T1:8 _T2:12 
visitBlock: decaf.tree.Tree$Block@4b9af9a9
genMemo: _T3:4 
visitBlock: decaf.tree.Tree$Block@2cdf8d8a
genMemo: _T4:4 
visitBlock: decaf.tree.Tree$Block@30946e09
genMemo: _T5:4 
visitBlock: decaf.tree.Tree$Block@5cb0d902
genMemo: _T6:4 _T7:8 _T8:12 
visitBlock: decaf.tree.Tree$Block@46fbb2c1
genMemo: _T9:4 
visitBlock: decaf.tree.Tree$Block@1698c449
genMemo: _T10:4 
visitBlock: decaf.tree.Tree$Block@5ef04b5
genMemo: _T11:4 
visitBlock: decaf.tree.Tree$Block@5f4da5c3
genMemo: _T12:4 _T13:8 _T14:12 
visitBlock: decaf.tree.Tree$Block@443b7951
genMemo: _T15:4 
visitBlock: decaf.tree.Tree$Block@14514713
genMemo: _T16:4 
visitBlock: decaf.tree.Tree$Block@69663380
genMemo: _T17:4 
visitBlock: decaf.tree.Tree$Block@5b37e0d2
genMemo: _T18:4 _T19:8 _T20:12 
visitBlock: decaf.tree.Tree$Block@4459eb14
genMemo: _T21:4 
visitBlock: decaf.tree.Tree$Block@5a2e4553
genMemo: _T22:4 
visitBlock: decaf.tree.Tree$Block@28c97a5
genMemo: _T23:4 
visitBlock: decaf.tree.Tree$Block@6659c656
genMemo: _T24:4 _T25:8 _T26:12 
visitBlock: decaf.tree.Tree$Block@6d5380c2
genMemo: _T27:4 
visitBlock: decaf.tree.Tree$Block@45ff54e6
genMemo: _T28:4 
visitBlock: decaf.tree.Tree$Block@2328c243
genMemo: _T29:4 _T30:8 _T31:12 
visitBlock: decaf.tree.Tree$Block@bebdb06
genMemo: _T32:4 
visitBlock: decaf.tree.Tree$Block@7a4f0f29
genMemo: _T33:4 
visitBlock: decaf.tree.Tree$Block@45283ce2
genMemo: _T34:4 
visitBlock: decaf.tree.Tree$Block@2077d4de
genMemo: _T35:4 _T36:8 
visitBlock: decaf.tree.Tree$Block@7591083d
genMemo: _T37:4 
visitBlock: decaf.tree.Tree$Block@77a567e1
genMemo: _T38:4 
visitBlock: decaf.tree.Tree$Block@736e9adb
genMemo: _T39:4 
visitBlock: decaf.tree.Tree$Block@6d21714c
visitBlock: decaf.tree.Tree$Block@108c4c35
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
    _C.allprint;
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
    _T40 = 12
    parm _T40
    _T41 =  call _Alloc
    _T42 = 0
    *(_T41 + 4) = _T42
    *(_T41 + 8) = _T42
    _T43 = VTBL <_A>
    *(_T41 + 0) = _T43
    return _T41
}

FUNCTION(_B_New) {
memo ''
_B_New:
    _T44 = 20
    parm _T44
    _T45 =  call _Alloc
    _T46 = 0
    *(_T45 + 4) = _T46
    *(_T45 + 8) = _T46
    *(_T45 + 12) = _T46
    *(_T45 + 16) = _T46
    _T47 = VTBL <_B>
    *(_T45 + 0) = _T47
    return _T45
}

FUNCTION(_C_New) {
memo ''
_C_New:
    _T48 = 20
    parm _T48
    _T49 =  call _Alloc
    _T50 = 0
    *(_T49 + 4) = _T50
    *(_T49 + 8) = _T50
    *(_T49 + 12) = _T50
    *(_T49 + 16) = _T50
    _T51 = VTBL <_C>
    *(_T49 + 0) = _T51
    return _T49
}

FUNCTION(_D_New) {
memo ''
_D_New:
    _T52 = 28
    parm _T52
    _T53 =  call _Alloc
    _T54 = 0
    _T55 = 4
    _T56 = (_T53 + _T52)
_L40:
    _T57 = (_T56 - _T55)
    _T56 = _T57
    _T58 = (_T52 - _T55)
    _T52 = _T58
    if (_T52 == 0) branch _L41
    *(_T56 + 0) = _T54
    branch _L40
_L41:
    _T59 = VTBL <_D>
    *(_T56 + 0) = _T59
    return _T56
}

FUNCTION(_E_New) {
memo ''
_E_New:
    _T60 = 28
    parm _T60
    _T61 =  call _Alloc
    _T62 = 0
    _T63 = 4
    _T64 = (_T61 + _T60)
_L43:
    _T65 = (_T64 - _T63)
    _T64 = _T65
    _T66 = (_T60 - _T63)
    _T60 = _T66
    if (_T60 == 0) branch _L44
    *(_T64 + 0) = _T62
    branch _L43
_L44:
    _T67 = VTBL <_E>
    *(_T64 + 0) = _T67
    return _T64
}

FUNCTION(_F_New) {
memo ''
_F_New:
    _T68 = 36
    parm _T68
    _T69 =  call _Alloc
    _T70 = 0
    _T71 = 4
    _T72 = (_T69 + _T68)
_L46:
    _T73 = (_T72 - _T71)
    _T72 = _T73
    _T74 = (_T68 - _T71)
    _T68 = _T74
    if (_T68 == 0) branch _L47
    *(_T72 + 0) = _T70
    branch _L46
_L47:
    _T75 = VTBL <_F>
    *(_T72 + 0) = _T75
    return _T72
}

FUNCTION(_G_New) {
memo ''
_G_New:
    _T76 = 24
    parm _T76
    _T77 =  call _Alloc
    _T78 = 0
    _T79 = 4
    _T80 = (_T77 + _T76)
_L49:
    _T81 = (_T80 - _T79)
    _T80 = _T81
    _T82 = (_T76 - _T79)
    _T76 = _T82
    if (_T76 == 0) branch _L50
    *(_T80 + 0) = _T78
    branch _L49
_L50:
    _T83 = VTBL <_G>
    *(_T80 + 0) = _T83
    return _T80
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T84 = 4
    parm _T84
    _T85 =  call _Alloc
    _T86 = VTBL <_Main>
    *(_T85 + 0) = _T86
    return _T85
}

FUNCTION(_A.setA) {
memo '_T0:4 _T1:8 _T2:12'
_A.setA:
    _T87 = *(_T0 + 4)
    *(_T0 + 4) = _T1
    _T88 = *(_T0 + 8)
    *(_T0 + 8) = _T2
}

FUNCTION(_A.print) {
memo '_T3:4'
_A.print:
    _T89 = " a="
    parm _T89
    call _PrintString
    _T90 = *(_T3 + 4)
    parm _T90
    call _PrintInt
    _T91 = " a1="
    parm _T91
    call _PrintString
    _T92 = *(_T3 + 8)
    parm _T92
    call _PrintInt
    _T93 = " "
    parm _T93
    call _PrintString
}

FUNCTION(_A.allprint) {
memo '_T4:4'
_A.allprint:
    parm _T4
    _T94 = *(_T4 + 0)
    _T95 = *(_T94 + 12)
    call _T95
}

FUNCTION(_A.fun) {
memo '_T5:4'
_A.fun:
    _T96 = "A"
    parm _T96
    call _PrintString
    parm _T5
    _T97 = *(_T5 + 0)
    _T98 = *(_T97 + 12)
    call _T98
    _T99 = "\n"
    parm _T99
    call _PrintString
}

FUNCTION(_B.setB) {
memo '_T6:4 _T7:8 _T8:12'
_B.setB:
    _T100 = *(_T6 + 12)
    *(_T6 + 12) = _T7
    _T101 = *(_T6 + 16)
    *(_T6 + 16) = _T8
}

FUNCTION(_B.print) {
memo '_T9:4'
_B.print:
    _T102 = " b="
    parm _T102
    call _PrintString
    _T103 = *(_T9 + 12)
    parm _T103
    call _PrintInt
    _T104 = " b1="
    parm _T104
    call _PrintString
    _T105 = *(_T9 + 16)
    parm _T105
    call _PrintInt
    _T106 = " "
    parm _T106
    call _PrintString
}

FUNCTION(_B.allprint) {
memo '_T10:4'
_B.allprint:
Exception in thread "main" java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:309)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
