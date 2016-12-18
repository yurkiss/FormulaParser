// Generated from /Users/yurkiss/IdeaProjects/AntlrSample/src/org/yurkiss/antlr/Formulas.g4 by ANTLR 4.5.3
package org.yurkiss.antlr.formulas;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulasLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENTIFIER=1, STRING=2, QUOT=3, NUMBER=4, DIGIT=5, AMP=6, ADD=7, MINUS=8, 
		MUL=9, DIV=10, POWER=11, PERCENT=12, ABS=13, EXCL=14, COLON=15, COMMA=16, 
		DOT=17, SEMI=18, LPAR=19, RPAR=20, EQ=21, NEQ=22, LTEQ=23, GTEQ=24, GT=25, 
		LT=26, AND_OP=27, OR_OP=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IDENTIFIER", "STRING", "QUOT", "NUMBER", "DIGIT", "AMP", "ADD", "MINUS", 
		"MUL", "DIV", "POWER", "PERCENT", "ABS", "EXCL", "COLON", "COMMA", "DOT", 
		"SEMI", "LPAR", "RPAR", "EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "AND_OP", 
		"OR_OP", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'\"'", null, null, "'&'", "'+'", "'-'", "'*'", "'/'", 
		"'^'", "'%'", "'$'", "'!'", "':'", "','", "'.'", "';'", "'('", "')'", 
		null, null, "'<='", "'>='", "'>'", "'<'", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IDENTIFIER", "STRING", "QUOT", "NUMBER", "DIGIT", "AMP", "ADD", 
		"MINUS", "MUL", "DIV", "POWER", "PERCENT", "ABS", "EXCL", "COLON", "COMMA", 
		"DOT", "SEMI", "LPAR", "RPAR", "EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", 
		"AND_OP", "OR_OP", "WS"
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


	public FormulasLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formulas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00a1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\7\2@\n"+
		"\2\f\2\16\2C\13\2\3\3\3\3\7\3G\n\3\f\3\16\3J\13\3\3\3\3\3\3\4\3\4\3\5"+
		"\6\5Q\n\5\r\5\16\5R\3\5\3\5\6\5W\n\5\r\5\16\5X\5\5[\n\5\3\6\6\6^\n\6\r"+
		"\6\16\6_\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\5\26\u0083\n\26\3\27\3\27\3\27\3\27\5\27\u0089\n"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\36\6\36\u009c\n\36\r\36\16\36\u009d\3\36\3\36\3H\2\37"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"\3\2\6\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\u00a9\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\3=\3\2\2\2\5D\3\2\2\2\7M\3\2\2\2\tP\3\2\2\2\13]\3\2\2\2\ra\3\2\2\2"+
		"\17c\3\2\2\2\21e\3\2\2\2\23g\3\2\2\2\25i\3\2\2\2\27k\3\2\2\2\31m\3\2\2"+
		"\2\33o\3\2\2\2\35q\3\2\2\2\37s\3\2\2\2!u\3\2\2\2#w\3\2\2\2%y\3\2\2\2\'"+
		"{\3\2\2\2)}\3\2\2\2+\u0082\3\2\2\2-\u0088\3\2\2\2/\u008a\3\2\2\2\61\u008d"+
		"\3\2\2\2\63\u0090\3\2\2\2\65\u0092\3\2\2\2\67\u0094\3\2\2\29\u0097\3\2"+
		"\2\2;\u009b\3\2\2\2=A\t\2\2\2>@\t\3\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2"+
		"AB\3\2\2\2B\4\3\2\2\2CA\3\2\2\2DH\5\7\4\2EG\13\2\2\2FE\3\2\2\2GJ\3\2\2"+
		"\2HI\3\2\2\2HF\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\5\7\4\2L\6\3\2\2\2MN\7$\2"+
		"\2N\b\3\2\2\2OQ\5\13\6\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2SZ\3\2"+
		"\2\2TV\5#\22\2UW\5\13\6\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3"+
		"\2\2\2ZT\3\2\2\2Z[\3\2\2\2[\n\3\2\2\2\\^\t\4\2\2]\\\3\2\2\2^_\3\2\2\2"+
		"_]\3\2\2\2_`\3\2\2\2`\f\3\2\2\2ab\7(\2\2b\16\3\2\2\2cd\7-\2\2d\20\3\2"+
		"\2\2ef\7/\2\2f\22\3\2\2\2gh\7,\2\2h\24\3\2\2\2ij\7\61\2\2j\26\3\2\2\2"+
		"kl\7`\2\2l\30\3\2\2\2mn\7\'\2\2n\32\3\2\2\2op\7&\2\2p\34\3\2\2\2qr\7#"+
		"\2\2r\36\3\2\2\2st\7<\2\2t \3\2\2\2uv\7.\2\2v\"\3\2\2\2wx\7\60\2\2x$\3"+
		"\2\2\2yz\7=\2\2z&\3\2\2\2{|\7*\2\2|(\3\2\2\2}~\7+\2\2~*\3\2\2\2\177\u0083"+
		"\7?\2\2\u0080\u0081\7?\2\2\u0081\u0083\7?\2\2\u0082\177\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083,\3\2\2\2\u0084\u0085\7>\2\2\u0085\u0089\7@\2\2\u0086"+
		"\u0087\7#\2\2\u0087\u0089\7?\2\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2"+
		"\2\u0089.\3\2\2\2\u008a\u008b\7>\2\2\u008b\u008c\7?\2\2\u008c\60\3\2\2"+
		"\2\u008d\u008e\7@\2\2\u008e\u008f\7?\2\2\u008f\62\3\2\2\2\u0090\u0091"+
		"\7@\2\2\u0091\64\3\2\2\2\u0092\u0093\7>\2\2\u0093\66\3\2\2\2\u0094\u0095"+
		"\7(\2\2\u0095\u0096\7(\2\2\u00968\3\2\2\2\u0097\u0098\7~\2\2\u0098\u0099"+
		"\7~\2\2\u0099:\3\2\2\2\u009a\u009c\t\5\2\2\u009b\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\b\36\2\2\u00a0<\3\2\2\2\f\2AHRXZ_\u0082\u0088\u009d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}