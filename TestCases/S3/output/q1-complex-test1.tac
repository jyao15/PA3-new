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
    _T14 = 1
    _T9 = _T14
    parm _T9
    call _PrintInt
    _T15 = "\n"
    parm _T15
    call _PrintString
    _T16 = 3
    _T18 = 0
    _T17 = _T16
    _T19 = 0
    _T20 = 12
    _T21 = (_T17 + _T19)
    _T22 = (_T18 + _T18)
    _T3 = _T21
    _T4 = _T22
    _T23 = "\n"
    parm _T23
    call _PrintString
    _T24 = 3
    _T26 = 0
    _T25 = _T24
    _T27 = 0
    _T28 = 45
    _T29 = (_T25 + _T27)
    _T30 = (_T26 + _T26)
    _T7 = _T29
    _T8 = _T30
    _T31 = _T3
    _T10 = _T31
    _T32 = _T4
    _T11 = _T32
    parm _T10
    call _PrintInt
    parm _T11
    call _PrintInt
    _T33 = "\n"
    parm _T33
    call _PrintString
    _T34 = (_T10 + _T11)
    _T36 = 0
    _T35 = _T34
    _T5 = _T35
    _T6 = _T36
    _T37 = "\n"
    parm _T37
    call _PrintString
    _T38 = "\n"
    parm _T38
    call _PrintString
    _T39 = "\n"
    parm _T39
    call _PrintString
    _T40 = (_T3 + _T5)
    _T41 = (_T4 + _T4)
    _T7 = _T40
    _T8 = _T41
    _T43 = 0
    _T42 = _T10
    _T44 = (_T3 + _T42)
    _T45 = (_T4 + _T4)
    _T7 = _T44
    _T8 = _T45
    _T46 = 0
    _T47 = 0
    _T48 = (_T3 + _T46)
    _T49 = (_T4 + _T4)
    _T7 = _T48
    _T8 = _T49
    _T50 = 0
    _T51 = 0
    _T53 = 0
    _T52 = _T10
    _T54 = (_T50 + _T52)
    _T55 = (_T51 + _T51)
    _T7 = _T54
    _T8 = _T55
    _T56 = 4
    _T57 = (_T56 + _T10)
    _T13 = _T57
    parm _T13
    call _PrintInt
    _T58 = "\n"
    parm _T58
    call _PrintString
    _T59 = "\n"
    parm _T59
    call _PrintString
    _T60 = (_T3 * _T5)
    _T61 = (_T4 * _T6)
    _T62 = (_T60 - _T61)
    _T63 = (_T3 * _T6)
    _T64 = (_T4 * _T5)
    _T65 = (_T63 + _T64)
    _T66 = (_T3 * _T5)
    _T7 = _T66
    _T8 = _T65
    _T68 = 0
    _T67 = _T10
    _T69 = (_T3 * _T67)
    _T70 = (_T4 * _T68)
    _T71 = (_T69 - _T70)
    _T72 = (_T3 * _T68)
    _T73 = (_T4 * _T67)
    _T74 = (_T72 + _T73)
    _T75 = (_T3 * _T67)
    _T7 = _T75
    _T8 = _T74
    _T76 = 0
    _T77 = 0
    _T78 = (_T3 * _T76)
    _T79 = (_T4 * _T77)
    _T80 = (_T78 - _T79)
    _T81 = (_T3 * _T77)
    _T82 = (_T4 * _T76)
    _T83 = (_T81 + _T82)
    _T84 = (_T3 * _T76)
    _T7 = _T84
    _T8 = _T83
    _T85 = 0
    _T86 = 0
    _T88 = 0
    _T87 = _T10
    _T89 = (_T85 * _T87)
    _T90 = (_T86 * _T88)
    _T91 = (_T89 - _T90)
    _T92 = (_T85 * _T88)
    _T93 = (_T86 * _T87)
    _T94 = (_T92 + _T93)
    _T95 = (_T85 * _T87)
    _T7 = _T95
    _T8 = _T94
    _T96 = 4
    _T97 = (_T96 * _T10)
    _T13 = _T97
    parm _T13
    call _PrintInt
    _T98 = "\n"
    parm _T98
    call _PrintString
    _T99 = "\n"
    parm _T99
    call _PrintString
}

