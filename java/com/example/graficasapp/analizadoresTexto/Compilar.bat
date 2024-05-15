echo "STARTING JFLEX COMPILING"
java -jar "C:\jflex-1.9.1\lib\jflex-full-1.9.1.jar" AnalizadorLexicoKoltlin.flex

echo "STARTING CUP COMPILING"
java -jar "C:\java-cup-11b.jar" -parser SintacticoKoltlin AnalizadorSintacticoKoltlin.cup

pause
move LexicoKoltlin.java "..\analizadores"
move SintacticoKoltlin.java "..\analizadores"
move sym.java "..\analizadores"