start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T1
end vardef in methoddef: int Temp: _T1 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T2
end vardef in methoddef: int Temp: _T2 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T6
end vardef in methoddef: int Temp: _T6 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T7
end vardef in methoddef: int Temp: _T7 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T11
end vardef in methoddef: int Temp: _T11 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T12
end vardef in methoddef: int Temp: _T12 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T16
end vardef in methoddef: int Temp: _T16 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T17
end vardef in methoddef: int Temp: _T17 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T21
end vardef in methoddef: int Temp: _T21 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T22
end vardef in methoddef: int Temp: _T22 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T26
end vardef in methoddef: int Temp: _T26 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T27
end vardef in methoddef: int Temp: _T27 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T31
end vardef in methoddef: int Temp: _T31 Temp2: null
genMemo: _T0:4 _T1:8 _T2:12 
visitBlock: decaf.tree.Tree$Block@4b9af9a9
genMemo: _T3:4 
visitBlock: decaf.tree.Tree$Block@2cdf8d8a
genMemo: _T4:4 
visitBlock: decaf.tree.Tree$Block@30946e09
genMemo: _T5:4 _T6:8 _T7:12 
visitBlock: decaf.tree.Tree$Block@5cb0d902
genMemo: _T8:4 
visitBlock: decaf.tree.Tree$Block@46fbb2c1
genMemo: _T9:4 
visitBlock: decaf.tree.Tree$Block@1698c449
genMemo: _T10:4 _T11:8 _T12:12 
visitBlock: decaf.tree.Tree$Block@5ef04b5
genMemo: _T13:4 
visitBlock: decaf.tree.Tree$Block@5f4da5c3
genMemo: _T14:4 
visitBlock: decaf.tree.Tree$Block@443b7951
genMemo: _T15:4 _T16:8 _T17:12 
visitBlock: decaf.tree.Tree$Block@14514713
genMemo: _T18:4 
visitBlock: decaf.tree.Tree$Block@69663380
genMemo: _T19:4 
visitBlock: decaf.tree.Tree$Block@5b37e0d2
genMemo: _T20:4 _T21:8 _T22:12 
visitBlock: decaf.tree.Tree$Block@4459eb14
genMemo: _T23:4 
visitBlock: decaf.tree.Tree$Block@5a2e4553
genMemo: _T24:4 
visitBlock: decaf.tree.Tree$Block@28c97a5
genMemo: _T25:4 _T26:8 _T27:12 
visitBlock: decaf.tree.Tree$Block@6659c656
genMemo: _T28:4 
visitBlock: decaf.tree.Tree$Block@6d5380c2
genMemo: _T29:4 
visitBlock: decaf.tree.Tree$Block@45ff54e6
genMemo: _T30:4 _T31:8 
visitBlock: decaf.tree.Tree$Block@2328c243
genMemo: _T32:4 
visitBlock: decaf.tree.Tree$Block@bebdb06
genMemo: _T33:4 
visitBlock: decaf.tree.Tree$Block@7a4f0f29
visitBlock: decaf.tree.Tree$Block@45283ce2
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
	at decaf.tac.Tac.toString(Tac.java:309)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
