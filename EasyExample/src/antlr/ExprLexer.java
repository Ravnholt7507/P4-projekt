// Generated from Expr.g4 by ANTLR 4.9.2

package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, OR=16, AND=17, 
		EQ=18, NEQ=19, GT=20, LT=21, GTEQ=22, LTEQ=23, BOOL=24, INT=25, DOUBLE=26, 
		ID=27, INT_TYPE=28, COMMENT=29, NEWLINE=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "OR", "AND", "EQ", 
			"NEQ", "GT", "LT", "GTEQ", "LTEQ", "BOOL", "INT", "DOUBLE", "ID", "INT_TYPE", 
			"COMMENT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'if'", "'else if'", "'else'", "'('", "')'", "'{'", 
			"'}'", "'while'", "'*'", "'/'", "'+'", "'-'", "'Print'", "'||'", "'&&'", 
			"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", null, null, null, null, 
			"'INT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", 
			"LTEQ", "BOOL", "INT", "DOUBLE", "ID", "INT_TYPE", "COMMENT", "NEWLINE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00d4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u0091\n\31\3\32\3\32\5\32\u0095\n\32\3\32\3\32\7\32\u0099"+
		"\n\32\f\32\16\32\u009c\13\32\5\32\u009e\n\32\3\33\6\33\u00a1\n\33\r\33"+
		"\16\33\u00a2\3\33\3\33\7\33\u00a7\n\33\f\33\16\33\u00aa\13\33\3\33\3\33"+
		"\6\33\u00ae\n\33\r\33\16\33\u00af\5\33\u00b2\n\33\3\34\3\34\7\34\u00b6"+
		"\n\34\f\34\16\34\u00b9\13\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7"+
		"\36\u00c3\n\36\f\36\16\36\u00c6\13\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		" \6 \u00cf\n \r \16 \u00d0\3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\b\3\2\63;\3\2\62;\3\2c|\5"+
		"\2\62;C\\c|\4\2\f\f\17\17\4\2\13\f\"\"\2\u00de\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tH\3\2\2\2\13P\3\2\2\2\rU\3\2\2"+
		"\2\17W\3\2\2\2\21Y\3\2\2\2\23[\3\2\2\2\25]\3\2\2\2\27c\3\2\2\2\31e\3\2"+
		"\2\2\33g\3\2\2\2\35i\3\2\2\2\37k\3\2\2\2!q\3\2\2\2#t\3\2\2\2%w\3\2\2\2"+
		"\'z\3\2\2\2)}\3\2\2\2+\177\3\2\2\2-\u0081\3\2\2\2/\u0084\3\2\2\2\61\u0090"+
		"\3\2\2\2\63\u009d\3\2\2\2\65\u00b1\3\2\2\2\67\u00b3\3\2\2\29\u00ba\3\2"+
		"\2\2;\u00be\3\2\2\2=\u00c9\3\2\2\2?\u00ce\3\2\2\2AB\7?\2\2B\4\3\2\2\2"+
		"CD\7=\2\2D\6\3\2\2\2EF\7k\2\2FG\7h\2\2G\b\3\2\2\2HI\7g\2\2IJ\7n\2\2JK"+
		"\7u\2\2KL\7g\2\2LM\7\"\2\2MN\7k\2\2NO\7h\2\2O\n\3\2\2\2PQ\7g\2\2QR\7n"+
		"\2\2RS\7u\2\2ST\7g\2\2T\f\3\2\2\2UV\7*\2\2V\16\3\2\2\2WX\7+\2\2X\20\3"+
		"\2\2\2YZ\7}\2\2Z\22\3\2\2\2[\\\7\177\2\2\\\24\3\2\2\2]^\7y\2\2^_\7j\2"+
		"\2_`\7k\2\2`a\7n\2\2ab\7g\2\2b\26\3\2\2\2cd\7,\2\2d\30\3\2\2\2ef\7\61"+
		"\2\2f\32\3\2\2\2gh\7-\2\2h\34\3\2\2\2ij\7/\2\2j\36\3\2\2\2kl\7R\2\2lm"+
		"\7t\2\2mn\7k\2\2no\7p\2\2op\7v\2\2p \3\2\2\2qr\7~\2\2rs\7~\2\2s\"\3\2"+
		"\2\2tu\7(\2\2uv\7(\2\2v$\3\2\2\2wx\7?\2\2xy\7?\2\2y&\3\2\2\2z{\7#\2\2"+
		"{|\7?\2\2|(\3\2\2\2}~\7@\2\2~*\3\2\2\2\177\u0080\7>\2\2\u0080,\3\2\2\2"+
		"\u0081\u0082\7@\2\2\u0082\u0083\7?\2\2\u0083.\3\2\2\2\u0084\u0085\7>\2"+
		"\2\u0085\u0086\7?\2\2\u0086\60\3\2\2\2\u0087\u0088\7v\2\2\u0088\u0089"+
		"\7t\2\2\u0089\u008a\7w\2\2\u008a\u0091\7g\2\2\u008b\u008c\7h\2\2\u008c"+
		"\u008d\7c\2\2\u008d\u008e\7n\2\2\u008e\u008f\7u\2\2\u008f\u0091\7g\2\2"+
		"\u0090\u0087\3\2\2\2\u0090\u008b\3\2\2\2\u0091\62\3\2\2\2\u0092\u009e"+
		"\7\62\2\2\u0093\u0095\7/\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u009a\t\2\2\2\u0097\u0099\t\3\2\2\u0098\u0097\3\2"+
		"\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u0092\3\2\2\2\u009d\u0094\3\2"+
		"\2\2\u009e\64\3\2\2\2\u009f\u00a1\t\3\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a8\7\60\2\2\u00a5\u00a7\t\3\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00b2\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ad\7\60\2\2\u00ac\u00ae\t\3\2\2\u00ad\u00ac\3"+
		"\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b2\3\2\2\2\u00b1\u00a0\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b2\66\3\2\2"+
		"\2\u00b3\u00b7\t\4\2\2\u00b4\u00b6\t\5\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b88\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\7K\2\2\u00bb\u00bc\7P\2\2\u00bc\u00bd\7V\2"+
		"\2\u00bd:\3\2\2\2\u00be\u00bf\7/\2\2\u00bf\u00c0\7/\2\2\u00c0\u00c4\3"+
		"\2\2\2\u00c1\u00c3\n\6\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00c8\b\36\2\2\u00c8<\3\2\2\2\u00c9\u00ca\t\6\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00cc\b\37\2\2\u00cc>\3\2\2\2\u00cd\u00cf\t\7\2\2\u00ce"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b \2\2\u00d3@\3\2\2\2\16\2\u0090"+
		"\u0094\u009a\u009d\u00a2\u00a8\u00af\u00b1\u00b7\u00c4\u00d0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}