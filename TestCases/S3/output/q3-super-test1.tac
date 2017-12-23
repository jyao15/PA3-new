start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T1
end vardef in methoddef: int Temp: _T1 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T3
end vardef in methoddef: int Temp: _T3 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T5
end vardef in methoddef: int Temp: _T5 Temp2: null
genMemo: _T0:4 _T1:8 
visitBlock: decaf.tree.Tree$Block@4b9af9a9
genMemo: _T2:4 _T3:8 
visitBlock: decaf.tree.Tree$Block@2cdf8d8a
genMemo: _T4:4 _T5:8 
visitBlock: decaf.tree.Tree$Block@30946e09
visitBlock: decaf.tree.Tree$Block@5cb0d902
VTABLE(_Computer) {
    <empty>
    Computer
    _Computer.Crash;
}

VTABLE(_Mac) {
    _Computer
    Mac
    _Mac.Crash;
    _Mac.add;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Computer_New) {
memo ''
_Computer_New:
    _T6 = 8
    parm _T6
    _T7 =  call _Alloc
    _T8 = 0
    *(_T7 + 4) = _T8
    _T9 = VTBL <_Computer>
    *(_T7 + 0) = _T9
    return _T7
}

FUNCTION(_Mac_New) {
memo ''
_Mac_New:
    _T10 = 12
    parm _T10
    _T11 =  call _Alloc
    _T12 = 0
    *(_T11 + 4) = _T12
    *(_T11 + 8) = _T12
    _T13 = VTBL <_Mac>
    *(_T11 + 0) = _T13
    return _T11
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T14 = 4
    parm _T14
    _T15 =  call _Alloc
    _T16 = VTBL <_Main>
    *(_T15 + 0) = _T16
    return _T15
}

FUNCTION(_Computer.Crash) {
memo '_T0:4 _T1:8'
_Computer.Crash:
    _T18 = 0
    _T17 = _T18
    branch _L15
_L16:
    _T19 = 1
    _T20 = (_T17 + _T19)
    _T17 = _T20
_L15:
    _T21 = (_T17 < _T1)
    if (_T21 == 0) branch _L17
    _T22 = "sad\n"
    parm _T22
    call _PrintString
    branch _L16
_L17:
}

FUNCTION(_Mac.add) {
memo '_T2:4 _T3:8'
_Mac.add:
Exception in thread "main" java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:309)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
