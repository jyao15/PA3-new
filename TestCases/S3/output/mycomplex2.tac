start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T1
end vardef in methoddef: int Temp: _T1 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T2
end vardef in methoddef: int Temp: _T2 Temp2: null
genMemo: _T0:4 _T1:8 _T2:12 
visitBlock: decaf.tree.Tree$Block@4b9af9a9
visitBlock: decaf.tree.Tree$Block@2cdf8d8a
VTABLE(_Mac) {
    <empty>
    Mac
    _Mac.Crash;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Mac_New) {
memo ''
_Mac_New:
    _T3 = 12
    parm _T3
    _T4 =  call _Alloc
    _T5 = 0
    *(_T4 + 4) = _T5
    *(_T4 + 8) = _T5
    _T6 = VTBL <_Mac>
    *(_T4 + 0) = _T6
    return _T4
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

FUNCTION(_Mac.Crash) {
memo '_T0:4 _T1:8 _T2:12'
_Mac.Crash:
    _T10 = *(_T0 + 4)
    *(_T0 + 4) = _T1
    _T11 = *(_T0 + 8)
    *(_T0 + 8) = _T2
}

FUNCTION(main) {
memo ''
main:
    _T13 =  call _Mac_New
    _T12 = _T13
    _T14 = 3
    _T15 = 4
    parm _T12
    parm _T14
    parm _T15
    _T16 = *(_T12 + 0)
    _T17 = *(_T16 + 8)
    call _T17
}

