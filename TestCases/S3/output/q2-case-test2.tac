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
    _T9 = 6
    _T3 = _T9
    _T10 = 2
    _T4 = _T10
    _T11 = 3
    _T5 = _T11
    _T12 = 3
    _T13 = (_T3 * _T12)
    _T15 = 0
    _T16 = (_T4 + _T5)
    _T17 = (_T13 - _T15)
    if (_T17 != 0) branch _L11
    _T14 = _T16
    branch _L10
_L11:
    _T18 = 3
    _T19 = 3
    _T20 = (_T4 + _T19)
    _T21 = (_T13 - _T18)
    if (_T21 != 0) branch _L12
    _T14 = _T20
    branch _L10
_L12:
    _T22 = 9
    _T23 = 2
    _T24 = (_T5 * _T23)
    _T25 = 6
    _T26 = (_T24 + _T25)
    _T27 = (_T13 - _T22)
    if (_T27 != 0) branch _L13
    _T14 = _T26
    branch _L10
_L13:
    _T28 = 100
    _T14 = _T28
_L10:
    _T4 = _T14
    parm _T4
    call _PrintInt
    _T29 = "\n"
    parm _T29
    call _PrintString
    _T30 = 3
    _T6 = _T30
    _T32 = 0
    _T33 = (_T4 + _T5)
    _T34 = (_T6 - _T32)
    if (_T34 != 0) branch _L15
    _T31 = _T33
    branch _L14
_L15:
    _T35 = 3
    _T36 = 3
    _T37 = (_T4 + _T36)
    _T38 = (_T6 - _T35)
    if (_T38 != 0) branch _L16
    _T31 = _T37
    branch _L14
_L16:
    _T39 = 6
    _T40 = 2
    _T41 = (_T5 * _T40)
    _T42 = 6
    _T43 = (_T41 + _T42)
    _T44 = (_T6 - _T39)
    if (_T44 != 0) branch _L17
    _T31 = _T43
    branch _L14
_L17:
    _T45 = 100
    _T31 = _T45
_L14:
    _T4 = _T31
    parm _T4
    call _PrintInt
    _T46 = "\n"
    parm _T46
    call _PrintString
    _T48 = 0
    _T49 = (_T4 + _T5)
    _T50 = (_T3 - _T48)
    if (_T50 != 0) branch _L19
    _T47 = _T49
    branch _L18
_L19:
    _T51 = 3
    _T52 = 3
    _T53 = (_T4 + _T52)
    _T54 = (_T3 - _T51)
    if (_T54 != 0) branch _L20
    _T47 = _T53
    branch _L18
_L20:
    _T55 = 6
    _T56 = 2
    _T57 = (_T5 * _T56)
    _T58 = 6
    _T59 = (_T57 + _T58)
    _T60 = (_T3 - _T55)
    if (_T60 != 0) branch _L21
    _T47 = _T59
    branch _L18
_L21:
    _T61 = 100
    _T47 = _T61
_L18:
    _T4 = _T47
    parm _T4
    call _PrintInt
    _T62 = "\n"
    parm _T62
    call _PrintString
    _T63 = 6
    _T64 = (_T3 - _T63)
    _T66 = 0
    _T67 = (_T4 + _T5)
    _T68 = (_T64 - _T66)
    if (_T68 != 0) branch _L23
    _T65 = _T67
    branch _L22
_L23:
    _T69 = 3
    _T70 = 3
    _T71 = (_T4 + _T70)
    _T72 = (_T64 - _T69)
    if (_T72 != 0) branch _L24
    _T65 = _T71
    branch _L22
_L24:
    _T73 = 9
    _T74 = 2
    _T75 = (_T5 * _T74)
    _T76 = 6
    _T77 = (_T75 + _T76)
    _T78 = (_T64 - _T73)
    if (_T78 != 0) branch _L25
    _T65 = _T77
    branch _L22
_L25:
    _T79 = 100
    _T65 = _T79
_L22:
    _T4 = _T65
    parm _T4
    call _PrintInt
    _T80 = "\n"
    parm _T80
    call _PrintString
    _T82 = 0
    _T83 = (_T4 + _T5)
    _T84 = (_T3 - _T82)
    if (_T84 != 0) branch _L27
    _T81 = _T83
    branch _L26
_L27:
    _T85 = 3
    _T86 = 3
    _T87 = (_T4 + _T86)
    _T88 = (_T3 - _T85)
    if (_T88 != 0) branch _L28
    _T81 = _T87
    branch _L26
_L28:
    _T89 = 6
    _T90 = 2
    _T91 = (_T5 * _T90)
    _T92 = 6
    _T93 = (_T91 + _T92)
    _T94 = (_T3 - _T89)
    if (_T94 != 0) branch _L29
    _T81 = _T93
    branch _L26
_L29:
    _T95 = 100
    _T81 = _T95
_L26:
    _T97 = 0
    _T96 = _T81
    _T7 = _T96
    _T8 = _T97
    parm _T7
    call _PrintInt
    _T98 = "+"
    parm _T98
    call _PrintString
    parm _T8
    call _PrintInt
    _T99 = "j"
    parm _T99
    call _PrintString
    _T100 = "\n"
    parm _T100
    call _PrintString
    _T102 = 8
    _T103 = (_T4 + _T5)
    _T104 = (_T3 - _T102)
    if (_T104 != 0) branch _L31
    _T101 = _T103
    branch _L30
_L31:
    _T105 = 3
    _T106 = (_T4 + _T3)
    _T107 = (_T3 - _T105)
    if (_T107 != 0) branch _L32
    _T101 = _T106
    branch _L30
_L32:
    _T108 = 0
    _T109 = 8
    _T110 = (_T3 - _T108)
    if (_T110 != 0) branch _L33
    _T101 = _T109
    branch _L30
_L33:
    _T111 = 100
    _T101 = _T111
_L30:
    _T113 = 0
    _T112 = _T101
    _T7 = _T112
    _T8 = _T113
    parm _T7
    call _PrintInt
    _T114 = "+"
    parm _T114
    call _PrintString
    parm _T8
    call _PrintInt
    _T115 = "j"
    parm _T115
    call _PrintString
    _T116 = "\n"
    parm _T116
    call _PrintString
}

