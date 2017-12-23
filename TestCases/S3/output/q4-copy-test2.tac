start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T1
end vardef in methoddef: int Temp: _T1 Temp2: null
start vardef in methoddef: int Temp: null Temp2: null
vardef in methoddef: Temp: _T4
end vardef in methoddef: int Temp: _T4 Temp2: null
visitBlock: decaf.tree.Tree$Block@4b9af9a9
genMemo: _T0:4 _T1:8 
visitBlock: decaf.tree.Tree$Block@2cdf8d8a
genMemo: _T2:4 
visitBlock: decaf.tree.Tree$Block@30946e09
genMemo: _T3:4 _T4:8 
visitBlock: decaf.tree.Tree$Block@5cb0d902
genMemo: _T5:4 
visitBlock: decaf.tree.Tree$Block@46fbb2c1
genMemo: _T6:4 
visitBlock: decaf.tree.Tree$Block@1698c449
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
Exception in thread "main" java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:259)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
