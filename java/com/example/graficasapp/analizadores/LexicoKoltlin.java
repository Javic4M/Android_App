// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: AnalizadorLexicoKoltlin.flex

package com.example.graficasapp.analizadores;

import java_cup.runtime.*;


@SuppressWarnings("fallthrough")
public class LexicoKoltlin implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\1\0\2\1\22\0\1\1\1\2\1\3"+
    "\1\4\4\0\1\5\1\6\1\0\1\7\1\10\3\0"+
    "\12\11\1\12\1\13\1\14\1\15\1\16\2\0\1\17"+
    "\1\20\1\21\1\22\1\20\1\23\2\20\1\24\2\20"+
    "\1\25\3\20\1\26\2\20\1\27\4\20\1\30\2\20"+
    "\1\31\1\0\1\32\3\0\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\44\1\53\1\54\1\55"+
    "\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65"+
    "\1\66\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\1\1\15"+
    "\1\16\4\1\1\17\1\20\1\21\1\0\1\22\21\0"+
    "\1\23\1\24\1\25\1\26\2\0\1\27\3\0\1\30"+
    "\21\0\1\31\1\0\1\32\2\0\1\33\1\0\1\34"+
    "\26\0\1\35\1\0\1\36\25\0\1\37\5\0\1\40"+
    "\11\0\1\41\1\0\1\42\6\0\1\43\1\44\7\0"+
    "\1\45\3\0\1\46\1\47\10\0\1\50\1\51\3\0"+
    "\1\52\16\0\1\53\3\0\1\54\1\55\5\0\1\56"+
    "\3\0\1\57\4\0\1\60\1\0\1\61\1\62\1\0"+
    "\1\63\6\0\1\64\1\65";

  private static int [] zzUnpackAction() {
    int [] result = new int[228];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\67\0\67\0\156\0\245\0\67\0\67\0\67"+
    "\0\67\0\334\0\67\0\67\0\u0113\0\u014a\0\u0181\0\u01b8"+
    "\0\67\0\67\0\u01ef\0\u0226\0\u025d\0\u0294\0\67\0\67"+
    "\0\67\0\u02cb\0\67\0\u0302\0\u0339\0\u0370\0\u03a7\0\u03de"+
    "\0\u0415\0\u044c\0\u0483\0\u04ba\0\u04f1\0\u0528\0\u055f\0\u0596"+
    "\0\u05cd\0\u0604\0\u063b\0\u0672\0\67\0\67\0\67\0\u06a9"+
    "\0\u06e0\0\u0717\0\67\0\u074e\0\u0785\0\u07bc\0\67\0\u07f3"+
    "\0\u082a\0\u0861\0\u0898\0\u08cf\0\u0906\0\u093d\0\u0974\0\u09ab"+
    "\0\u09e2\0\u0a19\0\u0a50\0\u0a87\0\u0abe\0\u0af5\0\u0b2c\0\u0b63"+
    "\0\67\0\u0b9a\0\67\0\u0bd1\0\u0c08\0\67\0\u0c3f\0\67"+
    "\0\u0c76\0\u0cad\0\u0ce4\0\u0d1b\0\u0d52\0\u0d89\0\u0dc0\0\u0df7"+
    "\0\u0e2e\0\u0e65\0\u0e9c\0\u0ed3\0\u0f0a\0\u0f41\0\u0f78\0\u0faf"+
    "\0\u0fe6\0\u101d\0\u1054\0\u108b\0\u10c2\0\u10f9\0\67\0\u1130"+
    "\0\67\0\u1167\0\u119e\0\u11d5\0\u120c\0\u1243\0\u127a\0\u12b1"+
    "\0\u12e8\0\u131f\0\u1356\0\u138d\0\u13c4\0\u13fb\0\u1432\0\u1469"+
    "\0\u14a0\0\u14d7\0\u150e\0\u1545\0\u157c\0\u15b3\0\67\0\u15ea"+
    "\0\u1621\0\u1658\0\u168f\0\u16c6\0\67\0\u16fd\0\u1734\0\u176b"+
    "\0\u17a2\0\u17d9\0\u1810\0\u1847\0\u187e\0\u18b5\0\67\0\u18ec"+
    "\0\67\0\u1923\0\u195a\0\u1991\0\u19c8\0\u19ff\0\u1a36\0\67"+
    "\0\67\0\u1a6d\0\u1aa4\0\u1adb\0\u1b12\0\u1b49\0\u1b80\0\u1bb7"+
    "\0\67\0\u1bee\0\u1c25\0\u1c5c\0\67\0\67\0\u1c93\0\u1cca"+
    "\0\u1d01\0\u1d38\0\u1d6f\0\u1da6\0\u1ddd\0\u1e14\0\67\0\67"+
    "\0\u1e4b\0\u1e82\0\u1eb9\0\67\0\u1ef0\0\u1f27\0\u1f5e\0\u1f95"+
    "\0\u1fcc\0\u2003\0\u203a\0\u2071\0\u20a8\0\u20df\0\u2116\0\u214d"+
    "\0\u2184\0\u21bb\0\67\0\u21f2\0\u2229\0\u2260\0\67\0\67"+
    "\0\u2297\0\u22ce\0\u2305\0\u233c\0\u2373\0\67\0\u23aa\0\u23e1"+
    "\0\u2418\0\67\0\u244f\0\u2486\0\u24bd\0\u24f4\0\67\0\u252b"+
    "\0\67\0\67\0\u2562\0\67\0\u2599\0\u25d0\0\u2607\0\u263e"+
    "\0\u2675\0\u26ac\0\67\0\67";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[228];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\2\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\5\2"+
    "\1\20\4\2\1\21\1\22\4\2\1\23\1\24\2\2"+
    "\1\25\14\2\1\26\3\2\1\27\1\3\1\30\104\0"+
    "\1\31\51\0\3\32\1\33\1\34\4\32\1\35\5\32"+
    "\12\36\3\32\1\37\1\40\1\41\1\32\1\42\1\32"+
    "\1\43\2\32\1\44\1\45\1\32\1\46\1\32\1\47"+
    "\1\32\1\50\1\51\1\32\1\52\1\32\1\53\1\54"+
    "\4\32\11\0\1\12\72\0\1\55\66\0\1\56\66\0"+
    "\1\57\73\0\1\60\13\0\1\60\76\0\1\61\71\0"+
    "\1\62\37\0\1\60\13\0\1\60\1\0\1\63\70\0"+
    "\1\64\24\0\3\32\1\33\66\32\1\33\5\32\1\65"+
    "\21\32\31\65\1\32\1\65\4\32\1\33\5\32\1\35"+
    "\14\32\1\66\23\32\1\66\17\32\1\67\66\32\1\33"+
    "\27\32\1\70\36\32\1\33\27\32\1\71\6\32\1\72"+
    "\6\32\1\73\20\32\1\33\27\32\1\74\3\32\1\75"+
    "\32\32\1\33\45\32\1\76\20\32\1\33\33\32\1\77"+
    "\32\32\1\33\33\32\1\100\32\32\1\33\27\32\1\101"+
    "\3\32\1\102\3\32\1\103\26\32\1\33\27\32\1\104"+
    "\36\32\1\33\45\32\1\105\20\32\1\33\37\32\1\106"+
    "\26\32\1\33\37\32\1\107\26\32\1\33\27\32\1\110"+
    "\36\32\1\111\13\32\1\112\52\32\1\113\13\32\1\114"+
    "\47\32\17\0\12\60\2\0\31\60\57\0\1\115\65\0"+
    "\1\116\56\0\1\117\23\0\3\32\1\120\5\32\1\65"+
    "\21\32\31\65\1\32\1\65\4\32\1\33\24\32\1\121"+
    "\30\32\1\121\10\32\1\33\31\32\1\122\34\32\1\33"+
    "\51\32\1\123\14\32\1\33\27\32\1\124\36\32\1\33"+
    "\42\32\1\125\3\32\1\126\17\32\1\33\51\32\1\127"+
    "\14\32\1\33\50\32\1\130\15\32\1\33\44\32\1\131"+
    "\1\132\20\32\1\33\27\32\1\133\36\32\1\33\56\32"+
    "\1\134\7\32\1\33\30\32\1\135\35\32\1\33\35\32"+
    "\1\136\30\32\1\33\44\32\1\137\21\32\1\33\43\32"+
    "\1\140\22\32\1\33\37\32\1\141\26\32\1\33\57\32"+
    "\1\142\6\32\1\33\51\32\1\143\14\32\1\33\42\32"+
    "\1\144\23\32\1\33\55\32\1\145\10\32\1\33\55\32"+
    "\1\146\5\32\37\0\1\147\75\0\1\150\20\0\3\32"+
    "\1\151\66\32\1\33\41\32\1\152\24\32\1\33\33\32"+
    "\1\153\32\32\1\33\47\32\1\154\16\32\1\33\45\32"+
    "\1\155\20\32\1\33\56\32\1\156\7\32\1\33\27\32"+
    "\1\157\36\32\1\33\31\32\1\160\34\32\1\33\51\32"+
    "\1\161\14\32\1\33\51\32\1\162\14\32\1\33\32\32"+
    "\1\163\33\32\1\33\54\32\1\164\11\32\1\33\33\32"+
    "\1\165\32\32\1\33\33\32\1\166\32\32\1\33\33\32"+
    "\1\167\32\32\1\33\33\32\1\170\32\32\1\33\44\32"+
    "\1\171\21\32\1\33\33\32\1\172\32\32\1\33\42\32"+
    "\1\173\23\32\1\33\52\32\1\174\13\32\1\33\37\32"+
    "\1\175\26\32\1\33\37\32\1\176\23\32\37\0\1\177"+
    "\27\0\3\32\1\33\35\32\1\200\30\32\1\33\35\32"+
    "\1\201\30\32\1\33\51\32\1\202\14\32\1\33\47\32"+
    "\1\203\16\32\1\33\47\32\1\204\16\32\1\205\66\32"+
    "\1\33\47\32\1\206\16\32\1\33\17\32\1\207\3\32"+
    "\1\210\42\32\1\33\33\32\1\211\32\32\1\33\33\32"+
    "\1\212\32\32\1\33\45\32\1\213\20\32\1\33\42\32"+
    "\1\214\23\32\1\33\44\32\1\215\21\32\1\33\23\32"+
    "\1\216\42\32\1\217\66\32\1\33\51\32\1\220\14\32"+
    "\1\221\66\32\1\33\33\32\1\222\32\32\1\33\33\32"+
    "\1\223\32\32\1\33\50\32\1\224\15\32\1\33\50\32"+
    "\1\225\15\32\1\33\47\32\1\226\16\32\1\33\45\32"+
    "\1\227\20\32\1\230\66\32\1\231\66\32\1\33\37\32"+
    "\1\232\26\32\1\33\37\32\1\233\26\32\1\33\27\32"+
    "\1\234\36\32\1\33\37\32\1\235\26\32\1\33\47\32"+
    "\1\236\16\32\1\33\47\32\1\237\16\32\1\33\47\32"+
    "\1\240\16\32\1\241\66\32\1\33\32\32\1\242\33\32"+
    "\1\33\51\32\1\243\14\32\1\33\50\32\1\244\15\32"+
    "\1\245\66\32\1\246\66\32\1\33\21\32\1\247\44\32"+
    "\1\33\21\32\1\250\44\32\1\33\45\32\1\251\20\32"+
    "\1\33\47\32\1\252\16\32\1\33\35\32\1\253\30\32"+
    "\1\33\46\32\1\254\17\32\1\33\43\32\1\255\22\32"+
    "\1\33\57\32\1\256\6\32\1\257\66\32\1\260\66\32"+
    "\1\33\32\32\1\261\33\32\1\33\22\32\1\262\43\32"+
    "\1\33\56\32\1\263\7\32\1\264\66\32\1\33\27\32"+
    "\1\265\36\32\1\33\27\32\1\266\36\32\1\33\52\32"+
    "\1\267\13\32\1\33\56\32\1\270\7\32\1\33\36\32"+
    "\1\271\27\32\1\33\51\32\1\272\14\32\1\33\37\32"+
    "\1\273\26\32\1\33\33\32\1\274\32\32\1\33\50\32"+
    "\1\275\15\32\1\33\45\32\1\276\20\32\1\33\42\32"+
    "\1\277\23\32\1\33\30\32\1\300\35\32\1\33\30\32"+
    "\1\301\35\32\1\33\44\32\1\302\21\32\1\303\66\32"+
    "\1\33\51\32\1\304\14\32\1\33\37\32\1\305\26\32"+
    "\1\33\42\32\1\306\23\32\1\307\66\32\1\310\66\32"+
    "\1\33\50\32\1\311\15\32\1\33\33\32\1\312\32\32"+
    "\1\33\33\32\1\313\32\32\1\33\33\32\1\314\32\32"+
    "\1\33\32\32\1\315\33\32\1\316\66\32\1\33\45\32"+
    "\1\317\20\32\1\33\56\32\1\320\7\32\1\33\37\32"+
    "\1\321\26\32\1\322\66\32\1\33\42\32\1\323\23\32"+
    "\1\33\42\32\1\324\23\32\1\33\15\32\1\325\50\32"+
    "\1\33\44\32\1\326\21\32\1\327\66\32\1\33\51\32"+
    "\1\330\14\32\1\331\66\32\1\332\66\32\1\33\45\32"+
    "\1\333\20\32\1\334\66\32\1\33\37\32\1\335\26\32"+
    "\1\33\42\32\1\336\23\32\1\33\45\32\1\337\20\32"+
    "\1\33\45\32\1\340\20\32\1\33\44\32\1\341\21\32"+
    "\1\33\47\32\1\342\16\32\1\343\66\32\1\344\63\32";

  private static int [] zzUnpacktrans() {
    int [] result = new int[9955];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\2\1\4\11\1\1\2\11\4\1\2\11"+
    "\4\1\3\11\1\0\1\11\21\0\3\11\1\1\2\0"+
    "\1\11\3\0\1\11\21\0\1\11\1\0\1\11\2\0"+
    "\1\11\1\0\1\11\26\0\1\11\1\0\1\11\25\0"+
    "\1\11\5\0\1\11\11\0\1\11\1\0\1\11\6\0"+
    "\2\11\7\0\1\11\3\0\2\11\10\0\2\11\3\0"+
    "\1\11\16\0\1\11\3\0\2\11\5\0\1\11\3\0"+
    "\1\11\4\0\1\11\1\0\2\11\1\0\1\11\6\0"+
    "\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[228];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexicoKoltlin(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {     return symbol(sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new Error("Error Léxico caracter Invalido en la linea " + (yyline+1) + ", columna " + (yycolumn+1) + ": " + yytext());
            }
          // fall through
          case 54: break;
          case 2:
            { /* ignoramos */
            }
          // fall through
          case 55: break;
          case 3:
            { return symbol(sym.PARENTESIS_I, yytext());
            }
          // fall through
          case 56: break;
          case 4:
            { return symbol(sym.PARENTESIS_D, yytext());
            }
          // fall through
          case 57: break;
          case 5:
            { return symbol(sym.MAS, yytext());
            }
          // fall through
          case 58: break;
          case 6:
            { return symbol(sym.COMA, yytext());
            }
          // fall through
          case 59: break;
          case 7:
            { return symbol(sym.NUMERO, yytext());
            }
          // fall through
          case 60: break;
          case 8:
            { return symbol(sym.DOS_PUNTOS, yytext());
            }
          // fall through
          case 61: break;
          case 9:
            { return symbol(sym.PUNTO_Y_COMA, yytext());
            }
          // fall through
          case 62: break;
          case 10:
            { return symbol(sym.MENOR, yytext());
            }
          // fall through
          case 63: break;
          case 11:
            { return symbol(sym.IGUAL, yytext());
            }
          // fall through
          case 64: break;
          case 12:
            { return symbol(sym.MAYOR, yytext());
            }
          // fall through
          case 65: break;
          case 13:
            { return symbol(sym.CORCHETE_I, yytext());
            }
          // fall through
          case 66: break;
          case 14:
            { return symbol(sym.CORCHETE_D, yytext());
            }
          // fall through
          case 67: break;
          case 15:
            { return symbol(sym.LLAVE_I, yytext());
            }
          // fall through
          case 68: break;
          case 16:
            { return symbol(sym.LLAVE_D, yytext());
            }
          // fall through
          case 69: break;
          case 17:
            { return symbol(sym.NO_IGUAL, yytext());
            }
          // fall through
          case 70: break;
          case 18:
            { return symbol(sym.PALABRA, yytext());
            }
          // fall through
          case 71: break;
          case 19:
            { return symbol(sym.MENOR_IGUAL, yytext());
            }
          // fall through
          case 72: break;
          case 20:
            { return symbol(sym.DOBLE_IGUAL, yytext());
            }
          // fall through
          case 73: break;
          case 21:
            { return symbol(sym.MAYOR_IGUAL, yytext());
            }
          // fall through
          case 74: break;
          case 22:
            { return symbol(sym.IDENTIFICADOR, yytext());
            }
          // fall through
          case 75: break;
          case 23:
            { return symbol(sym.IF, yytext());
            }
          // fall through
          case 76: break;
          case 24:
            { return symbol(sym.TIPO, yytext());
            }
          // fall through
          case 77: break;
          case 25:
            { return symbol(sym.X, yytext());
            }
          // fall through
          case 78: break;
          case 26:
            { return symbol(sym.Y, yytext());
            }
          // fall through
          case 79: break;
          case 27:
            { return symbol(sym.FOR, yytext());
            }
          // fall through
          case 80: break;
          case 28:
            { return symbol(sym.NUMERO_COLOR, yytext());
            }
          // fall through
          case 81: break;
          case 29:
            { return symbol(sym.ELSE, yytext());
            }
          // fall through
          case 82: break;
          case 30:
            { return symbol(sym.PIXEL, yytext());
            }
          // fall through
          case 83: break;
          case 31:
            { return symbol(sym.WHILE, yytext());
            }
          // fall through
          case 84: break;
          case 32:
            { return symbol(sym.DATA, yytext());
            }
          // fall through
          case 85: break;
          case 33:
            { return symbol(sym.NOMBRE, yytext());
            }
          // fall through
          case 86: break;
          case 34:
            { return symbol(sym.TAMANIO, yytext());
            }
          // fall through
          case 87: break;
          case 35:
            { return symbol(sym.CHART, yytext());
            }
          // fall through
          case 88: break;
          case 36:
            { return symbol(sym.COLOR, yytext());
            }
          // fall through
          case 89: break;
          case 37:
            { return symbol(sym.LABEL, yytext());
            }
          // fall through
          case 90: break;
          case 38:
            { return symbol(sym.TITULO, yytext());
            }
          // fall through
          case 91: break;
          case 39:
            { return symbol(sym.VALOR, yytext());
            }
          // fall through
          case 92: break;
          case 40:
            { return symbol(sym.PIE, yytext());
            }
          // fall through
          case 93: break;
          case 41:
            { return symbol(sym.ENCABEZADO, yytext());
            }
          // fall through
          case 94: break;
          case 42:
            { return symbol(sym.PUNTOS, yytext());
            }
          // fall through
          case 95: break;
          case 43:
            { return symbol(sym.CATEGORIA, yytext());
            }
          // fall through
          case 96: break;
          case 44:
            { return symbol(sym.TAMANIO_FUENTE, yytext());
            }
          // fall through
          case 97: break;
          case 45:
            { return symbol(sym.PALABRA_CLAVE, yytext());
            }
          // fall through
          case 98: break;
          case 46:
            { return symbol(sym.COPYRIGHT, yytext());
            }
          // fall through
          case 99: break;
          case 47:
            { return symbol(sym.LINEA_ESTILO, yytext());
            }
          // fall through
          case 100: break;
          case 48:
            { return symbol(sym.FUENTE, yytext());
            }
          // fall through
          case 101: break;
          case 49:
            { return symbol(sym.X_BARRA, yytext());
            }
          // fall through
          case 102: break;
          case 50:
            { return symbol(sym.Y_BARRA, yytext());
            }
          // fall through
          case 103: break;
          case 51:
            { return symbol(sym.DESCRIPCION, yytext());
            }
          // fall through
          case 104: break;
          case 52:
            { return symbol(sym.POSICION, yytext());
            }
          // fall through
          case 105: break;
          case 53:
            { return symbol(sym.FONDO, yytext());
            }
          // fall through
          case 106: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}