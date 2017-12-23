visitBlock: decaf.tree.Tree$Block@4b9af9a9
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
Exception in thread "main" java.lang.NullPointerException
	at decaf.tac.Tac.toString(Tac.java:259)
	at java.lang.String.valueOf(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at decaf.translate.Translater.printTo(Translater.java:70)
	at decaf.Driver.compile(Driver.java:107)
	at decaf.Driver.main(Driver.java:117)
