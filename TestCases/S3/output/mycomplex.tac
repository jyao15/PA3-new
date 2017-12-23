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
    _T1 = 12
    parm _T1
    _T2 =  call _Alloc
    _T3 = 0
    *(_T2 + 4) = _T3
    *(_T2 + 8) = _T3
    _T4 = VTBL <_Mac>
    *(_T2 + 0) = _T4
    return _T2
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T5 = 4
    parm _T5
    _T6 =  call _Alloc
    _T7 = VTBL <_Main>
    *(_T6 + 0) = _T7
    return _T6
}

FUNCTION(_Mac.Crash) {
memo '_T0:4'
_Mac.Crash:
    _T8 = *(_T0 + 4)
    _T9 = *(_T0 + 8)
    _T10 = 3
    _T12 = 0
    _T11 = _T10
    _T13 = 0
    _T14 = 4
    _T15 = (_T11 + _T13)
    _T16 = (_T12 + _T14)
    *(_T0 + 4) = _T15
    *(_T0 + 8) = _T16
}

FUNCTION(main) {
memo ''
main:
    _T18 =  call _Mac_New
    _T17 = _T18
    parm _T17
    _T19 = *(_T17 + 0)
    _T20 = *(_T19 + 8)
    call _T20
}

