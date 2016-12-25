// Generated from /usr/Intellij/ANtlr4WorkSpace/RIIF2_v6/RIIF2.g4 by ANTLR 4.5.3
package it.polito.yutengfei.RIIF2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RIIF2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, COMPONENT=35, END_COMPONENT=36, ENVIRONMENT=37, 
		END_ENVIRONMENT=38, REQUIREMENT=39, END_REQUIREMENT=40, CHILD_COMPONENT=41, 
		FAIL_MODE=42, EXTENDS=43, ASSIGN=44, ASSERT=45, INPUT=46, OUTPUT=47, PARAMETER=48, 
		CONSTANT=49, TYPE_FLOAT=50, TYPE_INTEGER=51, TYPE_STRING=52, TYPE_ENUM=53, 
		TYPE_BOOLEAN=54, TYPE_TIME=55, FUNC_AGG_SINGLE=56, FUNC_GT_N_FAIL=57, 
		FUNC_LOG=58, FUNC_EXP=59, TEMPLATE=60, END_TEMPLATE=61, IMPOSE=62, ABSTRACT=63, 
		IMPLEMENTS=64, SELF=65, SET=66, TYPE_TABLE=67, PLATFORM=68, TRUE=69, FALSE=70, 
		Identifier=71, StringLiteral=72, FloatingPointLiteral=73, DecimalLiteral=74, 
		WS=75, COMMENT=76, LINE_COMMENT=77;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "COMPONENT", "END_COMPONENT", "ENVIRONMENT", "END_ENVIRONMENT", 
		"REQUIREMENT", "END_REQUIREMENT", "CHILD_COMPONENT", "FAIL_MODE", "EXTENDS", 
		"ASSIGN", "ASSERT", "INPUT", "OUTPUT", "PARAMETER", "CONSTANT", "TYPE_FLOAT", 
		"TYPE_INTEGER", "TYPE_STRING", "TYPE_ENUM", "TYPE_BOOLEAN", "TYPE_TIME", 
		"FUNC_AGG_SINGLE", "FUNC_GT_N_FAIL", "FUNC_LOG", "FUNC_EXP", "TEMPLATE", 
		"END_TEMPLATE", "IMPOSE", "ABSTRACT", "IMPLEMENTS", "SELF", "SET", "TYPE_TABLE", 
		"PLATFORM", "TRUE", "FALSE", "Identifier", "StringLiteral", "FloatingPointLiteral", 
		"DecimalLiteral", "WS", "COMMENT", "LINE_COMMENT", "DIGIT", "LETTER", 
		"UNDERSCORE", "EscapeSequence", "OctalEscape", "HexDigit", "UnicodeEscape", 
		"Exponent", "FloatTypeSuffix"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'<'", "'>'", "':'", "':='", "'='", "'{'", "','", "'}'", 
		"'['", "']'", "'''", "'.'", "'#'", "' .. '", "'+'", "'-'", "'~'", "'!'", 
		"'*'", "'/'", "'%'", "'<='", "'>='", "'=='", "'!='", "'&'", "'^'", "'|'", 
		"'&&'", "'||'", "'?'", "'('", "')'", "'component'", "'endcomponent'", 
		"'environment'", "'endenvironment'", "'requirement'", "'endrequirement'", 
		"'child_component'", "'fail_mode'", "'extends'", "'assign'", "'assert'", 
		"'input'", "'output'", "'parameter'", "'constant'", "'float'", "'integer'", 
		"'string'", "'enum'", "'boolean'", "'time'", "'agg_single_fail'", "'agg_gt_n_fail'", 
		"'LOG'", "'EXP'", "'template'", "'endtemplate'", "'impose'", "'abstract'", 
		"'implements'", "'self'", "'set'", "'table'", "'platform'", "'true'", 
		"'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "COMPONENT", 
		"END_COMPONENT", "ENVIRONMENT", "END_ENVIRONMENT", "REQUIREMENT", "END_REQUIREMENT", 
		"CHILD_COMPONENT", "FAIL_MODE", "EXTENDS", "ASSIGN", "ASSERT", "INPUT", 
		"OUTPUT", "PARAMETER", "CONSTANT", "TYPE_FLOAT", "TYPE_INTEGER", "TYPE_STRING", 
		"TYPE_ENUM", "TYPE_BOOLEAN", "TYPE_TIME", "FUNC_AGG_SINGLE", "FUNC_GT_N_FAIL", 
		"FUNC_LOG", "FUNC_EXP", "TEMPLATE", "END_TEMPLATE", "IMPOSE", "ABSTRACT", 
		"IMPLEMENTS", "SELF", "SET", "TYPE_TABLE", "PLATFORM", "TRUE", "FALSE", 
		"Identifier", "StringLiteral", "FloatingPointLiteral", "DecimalLiteral", 
		"WS", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public RIIF2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RIIF2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2O\u02cb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3"+
		"/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:"+
		"\3;\3;\3;\3;\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3A"+
		"\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3C\3C\3C\3C\3D\3D\3D\3D"+
		"\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3H"+
		"\3H\3H\3H\7H\u023f\nH\fH\16H\u0242\13H\3I\3I\7I\u0246\nI\fI\16I\u0249"+
		"\13I\3I\3I\3J\6J\u024e\nJ\rJ\16J\u024f\3J\3J\7J\u0254\nJ\fJ\16J\u0257"+
		"\13J\3J\5J\u025a\nJ\3J\5J\u025d\nJ\3J\3J\6J\u0261\nJ\rJ\16J\u0262\3J\5"+
		"J\u0266\nJ\3J\5J\u0269\nJ\3J\6J\u026c\nJ\rJ\16J\u026d\3J\3J\5J\u0272\n"+
		"J\5J\u0274\nJ\3K\6K\u0277\nK\rK\16K\u0278\3L\3L\3L\3L\5L\u027f\nL\3L\3"+
		"L\3M\3M\3M\3M\7M\u0287\nM\fM\16M\u028a\13M\3M\3M\3M\3M\3M\3N\3N\3N\3N"+
		"\7N\u0295\nN\fN\16N\u0298\13N\3N\5N\u029b\nN\3N\3N\3N\3N\3O\3O\3P\3P\3"+
		"Q\3Q\3R\3R\3R\3R\5R\u02ab\nR\3S\3S\3S\3S\3S\3S\3S\3S\3S\5S\u02b6\nS\3"+
		"T\3T\3U\3U\3U\3U\3U\3U\3U\3V\3V\5V\u02c3\nV\3V\6V\u02c6\nV\rV\16V\u02c7"+
		"\3W\3W\3\u0288\2X\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089"+
		"F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009d"+
		"\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad\2\3\2"+
		"\13\4\2$$^^\5\2\13\13\17\17\"\"\4\2\f\f\17\17\4\2C\\c|\n\2$$))^^ddhhp"+
		"pttvv\5\2\62;CHch\4\2GGgg\4\2--//\6\2FFHHffhh\u02dc\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3"+
		"\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2"+
		"\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087"+
		"\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2"+
		"\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\3\u00af\3\2\2\2\5\u00b1\3\2\2\2\7\u00b3\3\2\2"+
		"\2\t\u00b5\3\2\2\2\13\u00b7\3\2\2\2\r\u00ba\3\2\2\2\17\u00bc\3\2\2\2\21"+
		"\u00be\3\2\2\2\23\u00c0\3\2\2\2\25\u00c2\3\2\2\2\27\u00c4\3\2\2\2\31\u00c6"+
		"\3\2\2\2\33\u00c8\3\2\2\2\35\u00ca\3\2\2\2\37\u00cc\3\2\2\2!\u00d1\3\2"+
		"\2\2#\u00d3\3\2\2\2%\u00d5\3\2\2\2\'\u00d7\3\2\2\2)\u00d9\3\2\2\2+\u00db"+
		"\3\2\2\2-\u00dd\3\2\2\2/\u00df\3\2\2\2\61\u00e2\3\2\2\2\63\u00e5\3\2\2"+
		"\2\65\u00e8\3\2\2\2\67\u00eb\3\2\2\29\u00ed\3\2\2\2;\u00ef\3\2\2\2=\u00f1"+
		"\3\2\2\2?\u00f4\3\2\2\2A\u00f7\3\2\2\2C\u00f9\3\2\2\2E\u00fb\3\2\2\2G"+
		"\u00fd\3\2\2\2I\u0107\3\2\2\2K\u0114\3\2\2\2M\u0120\3\2\2\2O\u012f\3\2"+
		"\2\2Q\u013b\3\2\2\2S\u014a\3\2\2\2U\u015a\3\2\2\2W\u0164\3\2\2\2Y\u016c"+
		"\3\2\2\2[\u0173\3\2\2\2]\u017a\3\2\2\2_\u0180\3\2\2\2a\u0187\3\2\2\2c"+
		"\u0191\3\2\2\2e\u019a\3\2\2\2g\u01a0\3\2\2\2i\u01a8\3\2\2\2k\u01af\3\2"+
		"\2\2m\u01b4\3\2\2\2o\u01bc\3\2\2\2q\u01c1\3\2\2\2s\u01d1\3\2\2\2u\u01df"+
		"\3\2\2\2w\u01e3\3\2\2\2y\u01e7\3\2\2\2{\u01f0\3\2\2\2}\u01fc\3\2\2\2\177"+
		"\u0203\3\2\2\2\u0081\u020c\3\2\2\2\u0083\u0217\3\2\2\2\u0085\u021c\3\2"+
		"\2\2\u0087\u0220\3\2\2\2\u0089\u0226\3\2\2\2\u008b\u022f\3\2\2\2\u008d"+
		"\u0234\3\2\2\2\u008f\u023a\3\2\2\2\u0091\u0243\3\2\2\2\u0093\u0273\3\2"+
		"\2\2\u0095\u0276\3\2\2\2\u0097\u027e\3\2\2\2\u0099\u0282\3\2\2\2\u009b"+
		"\u0290\3\2\2\2\u009d\u02a0\3\2\2\2\u009f\u02a2\3\2\2\2\u00a1\u02a4\3\2"+
		"\2\2\u00a3\u02aa\3\2\2\2\u00a5\u02b5\3\2\2\2\u00a7\u02b7\3\2\2\2\u00a9"+
		"\u02b9\3\2\2\2\u00ab\u02c0\3\2\2\2\u00ad\u02c9\3\2\2\2\u00af\u00b0\7="+
		"\2\2\u00b0\4\3\2\2\2\u00b1\u00b2\7>\2\2\u00b2\6\3\2\2\2\u00b3\u00b4\7"+
		"@\2\2\u00b4\b\3\2\2\2\u00b5\u00b6\7<\2\2\u00b6\n\3\2\2\2\u00b7\u00b8\7"+
		"<\2\2\u00b8\u00b9\7?\2\2\u00b9\f\3\2\2\2\u00ba\u00bb\7?\2\2\u00bb\16\3"+
		"\2\2\2\u00bc\u00bd\7}\2\2\u00bd\20\3\2\2\2\u00be\u00bf\7.\2\2\u00bf\22"+
		"\3\2\2\2\u00c0\u00c1\7\177\2\2\u00c1\24\3\2\2\2\u00c2\u00c3\7]\2\2\u00c3"+
		"\26\3\2\2\2\u00c4\u00c5\7_\2\2\u00c5\30\3\2\2\2\u00c6\u00c7\7)\2\2\u00c7"+
		"\32\3\2\2\2\u00c8\u00c9\7\60\2\2\u00c9\34\3\2\2\2\u00ca\u00cb\7%\2\2\u00cb"+
		"\36\3\2\2\2\u00cc\u00cd\7\"\2\2\u00cd\u00ce\7\60\2\2\u00ce\u00cf\7\60"+
		"\2\2\u00cf\u00d0\7\"\2\2\u00d0 \3\2\2\2\u00d1\u00d2\7-\2\2\u00d2\"\3\2"+
		"\2\2\u00d3\u00d4\7/\2\2\u00d4$\3\2\2\2\u00d5\u00d6\7\u0080\2\2\u00d6&"+
		"\3\2\2\2\u00d7\u00d8\7#\2\2\u00d8(\3\2\2\2\u00d9\u00da\7,\2\2\u00da*\3"+
		"\2\2\2\u00db\u00dc\7\61\2\2\u00dc,\3\2\2\2\u00dd\u00de\7\'\2\2\u00de."+
		"\3\2\2\2\u00df\u00e0\7>\2\2\u00e0\u00e1\7?\2\2\u00e1\60\3\2\2\2\u00e2"+
		"\u00e3\7@\2\2\u00e3\u00e4\7?\2\2\u00e4\62\3\2\2\2\u00e5\u00e6\7?\2\2\u00e6"+
		"\u00e7\7?\2\2\u00e7\64\3\2\2\2\u00e8\u00e9\7#\2\2\u00e9\u00ea\7?\2\2\u00ea"+
		"\66\3\2\2\2\u00eb\u00ec\7(\2\2\u00ec8\3\2\2\2\u00ed\u00ee\7`\2\2\u00ee"+
		":\3\2\2\2\u00ef\u00f0\7~\2\2\u00f0<\3\2\2\2\u00f1\u00f2\7(\2\2\u00f2\u00f3"+
		"\7(\2\2\u00f3>\3\2\2\2\u00f4\u00f5\7~\2\2\u00f5\u00f6\7~\2\2\u00f6@\3"+
		"\2\2\2\u00f7\u00f8\7A\2\2\u00f8B\3\2\2\2\u00f9\u00fa\7*\2\2\u00faD\3\2"+
		"\2\2\u00fb\u00fc\7+\2\2\u00fcF\3\2\2\2\u00fd\u00fe\7e\2\2\u00fe\u00ff"+
		"\7q\2\2\u00ff\u0100\7o\2\2\u0100\u0101\7r\2\2\u0101\u0102\7q\2\2\u0102"+
		"\u0103\7p\2\2\u0103\u0104\7g\2\2\u0104\u0105\7p\2\2\u0105\u0106\7v\2\2"+
		"\u0106H\3\2\2\2\u0107\u0108\7g\2\2\u0108\u0109\7p\2\2\u0109\u010a\7f\2"+
		"\2\u010a\u010b\7e\2\2\u010b\u010c\7q\2\2\u010c\u010d\7o\2\2\u010d\u010e"+
		"\7r\2\2\u010e\u010f\7q\2\2\u010f\u0110\7p\2\2\u0110\u0111\7g\2\2\u0111"+
		"\u0112\7p\2\2\u0112\u0113\7v\2\2\u0113J\3\2\2\2\u0114\u0115\7g\2\2\u0115"+
		"\u0116\7p\2\2\u0116\u0117\7x\2\2\u0117\u0118\7k\2\2\u0118\u0119\7t\2\2"+
		"\u0119\u011a\7q\2\2\u011a\u011b\7p\2\2\u011b\u011c\7o\2\2\u011c\u011d"+
		"\7g\2\2\u011d\u011e\7p\2\2\u011e\u011f\7v\2\2\u011fL\3\2\2\2\u0120\u0121"+
		"\7g\2\2\u0121\u0122\7p\2\2\u0122\u0123\7f\2\2\u0123\u0124\7g\2\2\u0124"+
		"\u0125\7p\2\2\u0125\u0126\7x\2\2\u0126\u0127\7k\2\2\u0127\u0128\7t\2\2"+
		"\u0128\u0129\7q\2\2\u0129\u012a\7p\2\2\u012a\u012b\7o\2\2\u012b\u012c"+
		"\7g\2\2\u012c\u012d\7p\2\2\u012d\u012e\7v\2\2\u012eN\3\2\2\2\u012f\u0130"+
		"\7t\2\2\u0130\u0131\7g\2\2\u0131\u0132\7s\2\2\u0132\u0133\7w\2\2\u0133"+
		"\u0134\7k\2\2\u0134\u0135\7t\2\2\u0135\u0136\7g\2\2\u0136\u0137\7o\2\2"+
		"\u0137\u0138\7g\2\2\u0138\u0139\7p\2\2\u0139\u013a\7v\2\2\u013aP\3\2\2"+
		"\2\u013b\u013c\7g\2\2\u013c\u013d\7p\2\2\u013d\u013e\7f\2\2\u013e\u013f"+
		"\7t\2\2\u013f\u0140\7g\2\2\u0140\u0141\7s\2\2\u0141\u0142\7w\2\2\u0142"+
		"\u0143\7k\2\2\u0143\u0144\7t\2\2\u0144\u0145\7g\2\2\u0145\u0146\7o\2\2"+
		"\u0146\u0147\7g\2\2\u0147\u0148\7p\2\2\u0148\u0149\7v\2\2\u0149R\3\2\2"+
		"\2\u014a\u014b\7e\2\2\u014b\u014c\7j\2\2\u014c\u014d\7k\2\2\u014d\u014e"+
		"\7n\2\2\u014e\u014f\7f\2\2\u014f\u0150\7a\2\2\u0150\u0151\7e\2\2\u0151"+
		"\u0152\7q\2\2\u0152\u0153\7o\2\2\u0153\u0154\7r\2\2\u0154\u0155\7q\2\2"+
		"\u0155\u0156\7p\2\2\u0156\u0157\7g\2\2\u0157\u0158\7p\2\2\u0158\u0159"+
		"\7v\2\2\u0159T\3\2\2\2\u015a\u015b\7h\2\2\u015b\u015c\7c\2\2\u015c\u015d"+
		"\7k\2\2\u015d\u015e\7n\2\2\u015e\u015f\7a\2\2\u015f\u0160\7o\2\2\u0160"+
		"\u0161\7q\2\2\u0161\u0162\7f\2\2\u0162\u0163\7g\2\2\u0163V\3\2\2\2\u0164"+
		"\u0165\7g\2\2\u0165\u0166\7z\2\2\u0166\u0167\7v\2\2\u0167\u0168\7g\2\2"+
		"\u0168\u0169\7p\2\2\u0169\u016a\7f\2\2\u016a\u016b\7u\2\2\u016bX\3\2\2"+
		"\2\u016c\u016d\7c\2\2\u016d\u016e\7u\2\2\u016e\u016f\7u\2\2\u016f\u0170"+
		"\7k\2\2\u0170\u0171\7i\2\2\u0171\u0172\7p\2\2\u0172Z\3\2\2\2\u0173\u0174"+
		"\7c\2\2\u0174\u0175\7u\2\2\u0175\u0176\7u\2\2\u0176\u0177\7g\2\2\u0177"+
		"\u0178\7t\2\2\u0178\u0179\7v\2\2\u0179\\\3\2\2\2\u017a\u017b\7k\2\2\u017b"+
		"\u017c\7p\2\2\u017c\u017d\7r\2\2\u017d\u017e\7w\2\2\u017e\u017f\7v\2\2"+
		"\u017f^\3\2\2\2\u0180\u0181\7q\2\2\u0181\u0182\7w\2\2\u0182\u0183\7v\2"+
		"\2\u0183\u0184\7r\2\2\u0184\u0185\7w\2\2\u0185\u0186\7v\2\2\u0186`\3\2"+
		"\2\2\u0187\u0188\7r\2\2\u0188\u0189\7c\2\2\u0189\u018a\7t\2\2\u018a\u018b"+
		"\7c\2\2\u018b\u018c\7o\2\2\u018c\u018d\7g\2\2\u018d\u018e\7v\2\2\u018e"+
		"\u018f\7g\2\2\u018f\u0190\7t\2\2\u0190b\3\2\2\2\u0191\u0192\7e\2\2\u0192"+
		"\u0193\7q\2\2\u0193\u0194\7p\2\2\u0194\u0195\7u\2\2\u0195\u0196\7v\2\2"+
		"\u0196\u0197\7c\2\2\u0197\u0198\7p\2\2\u0198\u0199\7v\2\2\u0199d\3\2\2"+
		"\2\u019a\u019b\7h\2\2\u019b\u019c\7n\2\2\u019c\u019d\7q\2\2\u019d\u019e"+
		"\7c\2\2\u019e\u019f\7v\2\2\u019ff\3\2\2\2\u01a0\u01a1\7k\2\2\u01a1\u01a2"+
		"\7p\2\2\u01a2\u01a3\7v\2\2\u01a3\u01a4\7g\2\2\u01a4\u01a5\7i\2\2\u01a5"+
		"\u01a6\7g\2\2\u01a6\u01a7\7t\2\2\u01a7h\3\2\2\2\u01a8\u01a9\7u\2\2\u01a9"+
		"\u01aa\7v\2\2\u01aa\u01ab\7t\2\2\u01ab\u01ac\7k\2\2\u01ac\u01ad\7p\2\2"+
		"\u01ad\u01ae\7i\2\2\u01aej\3\2\2\2\u01af\u01b0\7g\2\2\u01b0\u01b1\7p\2"+
		"\2\u01b1\u01b2\7w\2\2\u01b2\u01b3\7o\2\2\u01b3l\3\2\2\2\u01b4\u01b5\7"+
		"d\2\2\u01b5\u01b6\7q\2\2\u01b6\u01b7\7q\2\2\u01b7\u01b8\7n\2\2\u01b8\u01b9"+
		"\7g\2\2\u01b9\u01ba\7c\2\2\u01ba\u01bb\7p\2\2\u01bbn\3\2\2\2\u01bc\u01bd"+
		"\7v\2\2\u01bd\u01be\7k\2\2\u01be\u01bf\7o\2\2\u01bf\u01c0\7g\2\2\u01c0"+
		"p\3\2\2\2\u01c1\u01c2\7c\2\2\u01c2\u01c3\7i\2\2\u01c3\u01c4\7i\2\2\u01c4"+
		"\u01c5\7a\2\2\u01c5\u01c6\7u\2\2\u01c6\u01c7\7k\2\2\u01c7\u01c8\7p\2\2"+
		"\u01c8\u01c9\7i\2\2\u01c9\u01ca\7n\2\2\u01ca\u01cb\7g\2\2\u01cb\u01cc"+
		"\7a\2\2\u01cc\u01cd\7h\2\2\u01cd\u01ce\7c\2\2\u01ce\u01cf\7k\2\2\u01cf"+
		"\u01d0\7n\2\2\u01d0r\3\2\2\2\u01d1\u01d2\7c\2\2\u01d2\u01d3\7i\2\2\u01d3"+
		"\u01d4\7i\2\2\u01d4\u01d5\7a\2\2\u01d5\u01d6\7i\2\2\u01d6\u01d7\7v\2\2"+
		"\u01d7\u01d8\7a\2\2\u01d8\u01d9\7p\2\2\u01d9\u01da\7a\2\2\u01da\u01db"+
		"\7h\2\2\u01db\u01dc\7c\2\2\u01dc\u01dd\7k\2\2\u01dd\u01de\7n\2\2\u01de"+
		"t\3\2\2\2\u01df\u01e0\7N\2\2\u01e0\u01e1\7Q\2\2\u01e1\u01e2\7I\2\2\u01e2"+
		"v\3\2\2\2\u01e3\u01e4\7G\2\2\u01e4\u01e5\7Z\2\2\u01e5\u01e6\7R\2\2\u01e6"+
		"x\3\2\2\2\u01e7\u01e8\7v\2\2\u01e8\u01e9\7g\2\2\u01e9\u01ea\7o\2\2\u01ea"+
		"\u01eb\7r\2\2\u01eb\u01ec\7n\2\2\u01ec\u01ed\7c\2\2\u01ed\u01ee\7v\2\2"+
		"\u01ee\u01ef\7g\2\2\u01efz\3\2\2\2\u01f0\u01f1\7g\2\2\u01f1\u01f2\7p\2"+
		"\2\u01f2\u01f3\7f\2\2\u01f3\u01f4\7v\2\2\u01f4\u01f5\7g\2\2\u01f5\u01f6"+
		"\7o\2\2\u01f6\u01f7\7r\2\2\u01f7\u01f8\7n\2\2\u01f8\u01f9\7c\2\2\u01f9"+
		"\u01fa\7v\2\2\u01fa\u01fb\7g\2\2\u01fb|\3\2\2\2\u01fc\u01fd\7k\2\2\u01fd"+
		"\u01fe\7o\2\2\u01fe\u01ff\7r\2\2\u01ff\u0200\7q\2\2\u0200\u0201\7u\2\2"+
		"\u0201\u0202\7g\2\2\u0202~\3\2\2\2\u0203\u0204\7c\2\2\u0204\u0205\7d\2"+
		"\2\u0205\u0206\7u\2\2\u0206\u0207\7v\2\2\u0207\u0208\7t\2\2\u0208\u0209"+
		"\7c\2\2\u0209\u020a\7e\2\2\u020a\u020b\7v\2\2\u020b\u0080\3\2\2\2\u020c"+
		"\u020d\7k\2\2\u020d\u020e\7o\2\2\u020e\u020f\7r\2\2\u020f\u0210\7n\2\2"+
		"\u0210\u0211\7g\2\2\u0211\u0212\7o\2\2\u0212\u0213\7g\2\2\u0213\u0214"+
		"\7p\2\2\u0214\u0215\7v\2\2\u0215\u0216\7u\2\2\u0216\u0082\3\2\2\2\u0217"+
		"\u0218\7u\2\2\u0218\u0219\7g\2\2\u0219\u021a\7n\2\2\u021a\u021b\7h\2\2"+
		"\u021b\u0084\3\2\2\2\u021c\u021d\7u\2\2\u021d\u021e\7g\2\2\u021e\u021f"+
		"\7v\2\2\u021f\u0086\3\2\2\2\u0220\u0221\7v\2\2\u0221\u0222\7c\2\2\u0222"+
		"\u0223\7d\2\2\u0223\u0224\7n\2\2\u0224\u0225\7g\2\2\u0225\u0088\3\2\2"+
		"\2\u0226\u0227\7r\2\2\u0227\u0228\7n\2\2\u0228\u0229\7c\2\2\u0229\u022a"+
		"\7v\2\2\u022a\u022b\7h\2\2\u022b\u022c\7q\2\2\u022c\u022d\7t\2\2\u022d"+
		"\u022e\7o\2\2\u022e\u008a\3\2\2\2\u022f\u0230\7v\2\2\u0230\u0231\7t\2"+
		"\2\u0231\u0232\7w\2\2\u0232\u0233\7g\2\2\u0233\u008c\3\2\2\2\u0234\u0235"+
		"\7h\2\2\u0235\u0236\7c\2\2\u0236\u0237\7n\2\2\u0237\u0238\7u\2\2\u0238"+
		"\u0239\7g\2\2\u0239\u008e\3\2\2\2\u023a\u0240\5\u009fP\2\u023b\u023f\5"+
		"\u009fP\2\u023c\u023f\5\u009dO\2\u023d\u023f\5\u00a1Q\2\u023e\u023b\3"+
		"\2\2\2\u023e\u023c\3\2\2\2\u023e\u023d\3\2\2\2\u023f\u0242\3\2\2\2\u0240"+
		"\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0090\3\2\2\2\u0242\u0240\3\2"+
		"\2\2\u0243\u0247\7$\2\2\u0244\u0246\n\2\2\2\u0245\u0244\3\2\2\2\u0246"+
		"\u0249\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u024a\3\2"+
		"\2\2\u0249\u0247\3\2\2\2\u024a\u024b\7$\2\2\u024b\u0092\3\2\2\2\u024c"+
		"\u024e\5\u009dO\2\u024d\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u024d"+
		"\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0255\7\60\2\2"+
		"\u0252\u0254\5\u009dO\2\u0253\u0252\3\2\2\2\u0254\u0257\3\2\2\2\u0255"+
		"\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0259\3\2\2\2\u0257\u0255\3\2"+
		"\2\2\u0258\u025a\5\u00abV\2\u0259\u0258\3\2\2\2\u0259\u025a\3\2\2\2\u025a"+
		"\u025c\3\2\2\2\u025b\u025d\5\u00adW\2\u025c\u025b\3\2\2\2\u025c\u025d"+
		"\3\2\2\2\u025d\u0274\3\2\2\2\u025e\u0260\7\60\2\2\u025f\u0261\5\u009d"+
		"O\2\u0260\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0260\3\2\2\2\u0262"+
		"\u0263\3\2\2\2\u0263\u0265\3\2\2\2\u0264\u0266\5\u00abV\2\u0265\u0264"+
		"\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0268\3\2\2\2\u0267\u0269\5\u00adW"+
		"\2\u0268\u0267\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u0274\3\2\2\2\u026a\u026c"+
		"\5\u009dO\2\u026b\u026a\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026b\3\2\2"+
		"\2\u026d\u026e\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\5\u00abV\2\u0270"+
		"\u0272\5\u00adW\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0274"+
		"\3\2\2\2\u0273\u024d\3\2\2\2\u0273\u025e\3\2\2\2\u0273\u026b\3\2\2\2\u0274"+
		"\u0094\3\2\2\2\u0275\u0277\5\u009dO\2\u0276\u0275\3\2\2\2\u0277\u0278"+
		"\3\2\2\2\u0278\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u0096\3\2\2\2\u027a"+
		"\u027f\t\3\2\2\u027b\u027c\7\"\2\2\u027c\u027f\7\16\2\2\u027d\u027f\7"+
		"\f\2\2\u027e\u027a\3\2\2\2\u027e\u027b\3\2\2\2\u027e\u027d\3\2\2\2\u027f"+
		"\u0280\3\2\2\2\u0280\u0281\bL\2\2\u0281\u0098\3\2\2\2\u0282\u0283\7\61"+
		"\2\2\u0283\u0284\7,\2\2\u0284\u0288\3\2\2\2\u0285\u0287\13\2\2\2\u0286"+
		"\u0285\3\2\2\2\u0287\u028a\3\2\2\2\u0288\u0289\3\2\2\2\u0288\u0286\3\2"+
		"\2\2\u0289\u028b\3\2\2\2\u028a\u0288\3\2\2\2\u028b\u028c\7,\2\2\u028c"+
		"\u028d\7\61\2\2\u028d\u028e\3\2\2\2\u028e\u028f\bM\2\2\u028f\u009a\3\2"+
		"\2\2\u0290\u0291\7\61\2\2\u0291\u0292\7\61\2\2\u0292\u0296\3\2\2\2\u0293"+
		"\u0295\n\4\2\2\u0294\u0293\3\2\2\2\u0295\u0298\3\2\2\2\u0296\u0294\3\2"+
		"\2\2\u0296\u0297\3\2\2\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0299"+
		"\u029b\7\17\2\2\u029a\u0299\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\3"+
		"\2\2\2\u029c\u029d\7\f\2\2\u029d\u029e\3\2\2\2\u029e\u029f\bN\2\2\u029f"+
		"\u009c\3\2\2\2\u02a0\u02a1\4\62;\2\u02a1\u009e\3\2\2\2\u02a2\u02a3\t\5"+
		"\2\2\u02a3\u00a0\3\2\2\2\u02a4\u02a5\7a\2\2\u02a5\u00a2\3\2\2\2\u02a6"+
		"\u02a7\7^\2\2\u02a7\u02ab\t\6\2\2\u02a8\u02ab\5\u00a9U\2\u02a9\u02ab\5"+
		"\u00a5S\2\u02aa\u02a6\3\2\2\2\u02aa\u02a8\3\2\2\2\u02aa\u02a9\3\2\2\2"+
		"\u02ab\u00a4\3\2\2\2\u02ac\u02ad\7^\2\2\u02ad\u02ae\4\62\65\2\u02ae\u02af"+
		"\4\629\2\u02af\u02b6\4\629\2\u02b0\u02b1\7^\2\2\u02b1\u02b2\4\629\2\u02b2"+
		"\u02b6\4\629\2\u02b3\u02b4\7^\2\2\u02b4\u02b6\4\629\2\u02b5\u02ac\3\2"+
		"\2\2\u02b5\u02b0\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b6\u00a6\3\2\2\2\u02b7"+
		"\u02b8\t\7\2\2\u02b8\u00a8\3\2\2\2\u02b9\u02ba\7^\2\2\u02ba\u02bb\7w\2"+
		"\2\u02bb\u02bc\5\u00a7T\2\u02bc\u02bd\5\u00a7T\2\u02bd\u02be\5\u00a7T"+
		"\2\u02be\u02bf\5\u00a7T\2\u02bf\u00aa\3\2\2\2\u02c0\u02c2\t\b\2\2\u02c1"+
		"\u02c3\t\t\2\2\u02c2\u02c1\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c5\3\2"+
		"\2\2\u02c4\u02c6\5\u009dO\2\u02c5\u02c4\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7"+
		"\u02c5\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u00ac\3\2\2\2\u02c9\u02ca\t\n"+
		"\2\2\u02ca\u00ae\3\2\2\2\31\2\u023e\u0240\u0247\u024f\u0255\u0259\u025c"+
		"\u0262\u0265\u0268\u026d\u0271\u0273\u0278\u027e\u0288\u0296\u029a\u02aa"+
		"\u02b5\u02c2\u02c7\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}