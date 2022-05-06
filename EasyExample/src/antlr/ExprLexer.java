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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TRAIN=21, ACTFUNC=22, ARRAY=23, NEURALNETWORK=24, 
		SETUP=25, DATASET=26, ADDDATA=27, READDATA=28, PREDICT=29, READIMAGE=30, 
		OR=31, AND=32, EQ=33, NEQ=34, GT=35, LT=36, GTEQ=37, LTEQ=38, BOOL=39, 
		INT=40, DOUBLE=41, ID=42, STRING=43, INT_TYPE=44, COMMENT=45, NEWLINE=46, 
		WS=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "TRAIN", "ACTFUNC", "ARRAY", "NEURALNETWORK", 
			"SETUP", "DATASET", "ADDDATA", "READDATA", "PREDICT", "READIMAGE", "OR", 
			"AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "BOOL", "INT", "DOUBLE", 
			"ID", "STRING", "INT_TYPE", "COMMENT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'if'", "'else if'", "'else'", "'('", "','", "')'", 
			"'.'", "'{'", "'}'", "'while'", "'['", "']'", "'*'", "'/'", "'+'", "'-'", 
			"'Print'", "'read'", "'train'", null, null, "'NeuralNetwork'", null, 
			null, null, null, null, null, "'||'", "'&&'", "'=='", "'!='", "'>'", 
			"'<'", "'>='", "'<='", null, null, null, null, null, "'INT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TRAIN", "ACTFUNC", 
			"ARRAY", "NEURALNETWORK", "SETUP", "DATASET", "ADDDATA", "READDATA", 
			"PREDICT", "READIMAGE", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", 
			"LTEQ", "BOOL", "INT", "DOUBLE", "ID", "STRING", "INT_TYPE", "COMMENT", 
			"NEWLINE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u01bf\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00cd\n\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00d9\n\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00f3\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0103\n\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u0113\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u012d"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u013d\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0151\n\37\3 \3 \3 \3!\3"+
		"!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\5(\u0172\n(\3)\3)\5)\u0176\n)\3)\3)\7)\u017a\n)\f)\16"+
		")\u017d\13)\5)\u017f\n)\3*\6*\u0182\n*\r*\16*\u0183\3*\3*\7*\u0188\n*"+
		"\f*\16*\u018b\13*\3*\3*\6*\u018f\n*\r*\16*\u0190\5*\u0193\n*\3+\7+\u0196"+
		"\n+\f+\16+\u0199\13+\3,\3,\3,\3,\7,\u019f\n,\f,\16,\u01a2\13,\3,\3,\3"+
		"-\3-\3-\3-\3.\3.\3.\3.\7.\u01ae\n.\f.\16.\u01b1\13.\3.\3.\3/\3/\3/\3/"+
		"\3\60\6\60\u01ba\n\60\r\60\16\60\u01bb\3\60\3\60\2\2\61\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\b\3\2\63;\3\2\62;\5\2\62;C\\c|\5\2"+
		"\f\f\17\17$$\4\2\f\f\17\17\4\2\13\f\"\"\2\u01d9\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7e\3"+
		"\2\2\2\th\3\2\2\2\13p\3\2\2\2\ru\3\2\2\2\17w\3\2\2\2\21y\3\2\2\2\23{\3"+
		"\2\2\2\25}\3\2\2\2\27\177\3\2\2\2\31\u0081\3\2\2\2\33\u0087\3\2\2\2\35"+
		"\u0089\3\2\2\2\37\u008b\3\2\2\2!\u008d\3\2\2\2#\u008f\3\2\2\2%\u0091\3"+
		"\2\2\2\'\u0093\3\2\2\2)\u0099\3\2\2\2+\u009e\3\2\2\2-\u00cc\3\2\2\2/\u00d8"+
		"\3\2\2\2\61\u00da\3\2\2\2\63\u00f2\3\2\2\2\65\u0102\3\2\2\2\67\u0112\3"+
		"\2\2\29\u012c\3\2\2\2;\u013c\3\2\2\2=\u0150\3\2\2\2?\u0152\3\2\2\2A\u0155"+
		"\3\2\2\2C\u0158\3\2\2\2E\u015b\3\2\2\2G\u015e\3\2\2\2I\u0160\3\2\2\2K"+
		"\u0162\3\2\2\2M\u0165\3\2\2\2O\u0171\3\2\2\2Q\u017e\3\2\2\2S\u0192\3\2"+
		"\2\2U\u0197\3\2\2\2W\u019a\3\2\2\2Y\u01a5\3\2\2\2[\u01a9\3\2\2\2]\u01b4"+
		"\3\2\2\2_\u01b9\3\2\2\2ab\7?\2\2b\4\3\2\2\2cd\7=\2\2d\6\3\2\2\2ef\7k\2"+
		"\2fg\7h\2\2g\b\3\2\2\2hi\7g\2\2ij\7n\2\2jk\7u\2\2kl\7g\2\2lm\7\"\2\2m"+
		"n\7k\2\2no\7h\2\2o\n\3\2\2\2pq\7g\2\2qr\7n\2\2rs\7u\2\2st\7g\2\2t\f\3"+
		"\2\2\2uv\7*\2\2v\16\3\2\2\2wx\7.\2\2x\20\3\2\2\2yz\7+\2\2z\22\3\2\2\2"+
		"{|\7\60\2\2|\24\3\2\2\2}~\7}\2\2~\26\3\2\2\2\177\u0080\7\177\2\2\u0080"+
		"\30\3\2\2\2\u0081\u0082\7y\2\2\u0082\u0083\7j\2\2\u0083\u0084\7k\2\2\u0084"+
		"\u0085\7n\2\2\u0085\u0086\7g\2\2\u0086\32\3\2\2\2\u0087\u0088\7]\2\2\u0088"+
		"\34\3\2\2\2\u0089\u008a\7_\2\2\u008a\36\3\2\2\2\u008b\u008c\7,\2\2\u008c"+
		" \3\2\2\2\u008d\u008e\7\61\2\2\u008e\"\3\2\2\2\u008f\u0090\7-\2\2\u0090"+
		"$\3\2\2\2\u0091\u0092\7/\2\2\u0092&\3\2\2\2\u0093\u0094\7R\2\2\u0094\u0095"+
		"\7t\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p\2\2\u0097\u0098\7v\2\2\u0098"+
		"(\3\2\2\2\u0099\u009a\7t\2\2\u009a\u009b\7g\2\2\u009b\u009c\7c\2\2\u009c"+
		"\u009d\7f\2\2\u009d*\3\2\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7t\2\2\u00a0"+
		"\u00a1\7c\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7p\2\2\u00a3,\3\2\2\2\u00a4"+
		"\u00a5\7u\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7i\2\2\u00a7\u00a8\7o\2\2"+
		"\u00a8\u00a9\7q\2\2\u00a9\u00aa\7k\2\2\u00aa\u00cd\7f\2\2\u00ab\u00ac"+
		"\7U\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7i\2\2\u00ae\u00af\7o\2\2\u00af"+
		"\u00b0\7q\2\2\u00b0\u00b1\7k\2\2\u00b1\u00cd\7f\2\2\u00b2\u00b3\7U\2\2"+
		"\u00b3\u00b4\7q\2\2\u00b4\u00b5\7h\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7"+
		"\7o\2\2\u00b7\u00b8\7c\2\2\u00b8\u00cd\7z\2\2\u00b9\u00ba\7U\2\2\u00ba"+
		"\u00bb\7q\2\2\u00bb\u00bc\7h\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7O\2\2"+
		"\u00be\u00bf\7c\2\2\u00bf\u00cd\7z\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2"+
		"\7g\2\2\u00c2\u00c3\7n\2\2\u00c3\u00cd\7w\2\2\u00c4\u00c5\7T\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6\u00c7\7n\2\2\u00c7\u00cd\7w\2\2\u00c8\u00c9\7T\2\2"+
		"\u00c9\u00ca\7g\2\2\u00ca\u00cb\7N\2\2\u00cb\u00cd\7w\2\2\u00cc\u00a4"+
		"\3\2\2\2\u00cc\u00ab\3\2\2\2\u00cc\u00b2\3\2\2\2\u00cc\u00b9\3\2\2\2\u00cc"+
		"\u00c0\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd.\3\2\2\2"+
		"\u00ce\u00cf\7c\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2"+
		"\7c\2\2\u00d2\u00d9\7{\2\2\u00d3\u00d4\7C\2\2\u00d4\u00d5\7t\2\2\u00d5"+
		"\u00d6\7t\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d9\7{\2\2\u00d8\u00ce\3\2\2"+
		"\2\u00d8\u00d3\3\2\2\2\u00d9\60\3\2\2\2\u00da\u00db\7P\2\2\u00db\u00dc"+
		"\7g\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7c\2\2\u00df"+
		"\u00e0\7n\2\2\u00e0\u00e1\7P\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7v\2\2"+
		"\u00e3\u00e4\7y\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7"+
		"\7m\2\2\u00e7\62\3\2\2\2\u00e8\u00e9\7U\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb"+
		"\7v\2\2\u00eb\u00ec\7w\2\2\u00ec\u00f3\7r\2\2\u00ed\u00ee\7u\2\2\u00ee"+
		"\u00ef\7g\2\2\u00ef\u00f0\7v\2\2\u00f0\u00f1\7w\2\2\u00f1\u00f3\7r\2\2"+
		"\u00f2\u00e8\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f3\64\3\2\2\2\u00f4\u00f5"+
		"\7F\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7c\2\2\u00f8"+
		"\u00f9\7u\2\2\u00f9\u00fa\7g\2\2\u00fa\u0103\7v\2\2\u00fb\u00fc\7f\2\2"+
		"\u00fc\u00fd\7c\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100"+
		"\7u\2\2\u0100\u0101\7g\2\2\u0101\u0103\7v\2\2\u0102\u00f4\3\2\2\2\u0102"+
		"\u00fb\3\2\2\2\u0103\66\3\2\2\2\u0104\u0105\7C\2\2\u0105\u0106\7f\2\2"+
		"\u0106\u0107\7f\2\2\u0107\u0108\7F\2\2\u0108\u0109\7c\2\2\u0109\u010a"+
		"\7v\2\2\u010a\u0113\7c\2\2\u010b\u010c\7c\2\2\u010c\u010d\7f\2\2\u010d"+
		"\u010e\7f\2\2\u010e\u010f\7F\2\2\u010f\u0110\7c\2\2\u0110\u0111\7v\2\2"+
		"\u0111\u0113\7c\2\2\u0112\u0104\3\2\2\2\u0112\u010b\3\2\2\2\u01138\3\2"+
		"\2\2\u0114\u0115\7T\2\2\u0115\u0116\7g\2\2\u0116\u0117\7c\2\2\u0117\u0118"+
		"\7f\2\2\u0118\u0119\7F\2\2\u0119\u011a\7c\2\2\u011a\u011b\7v\2\2\u011b"+
		"\u012d\7c\2\2\u011c\u011d\7T\2\2\u011d\u011e\7g\2\2\u011e\u011f\7c\2\2"+
		"\u011f\u0120\7f\2\2\u0120\u0121\7f\2\2\u0121\u0122\7c\2\2\u0122\u0123"+
		"\7v\2\2\u0123\u012d\7c\2\2\u0124\u0125\7t\2\2\u0125\u0126\7g\2\2\u0126"+
		"\u0127\7c\2\2\u0127\u0128\7f\2\2\u0128\u0129\7f\2\2\u0129\u012a\7c\2\2"+
		"\u012a\u012b\7v\2\2\u012b\u012d\7c\2\2\u012c\u0114\3\2\2\2\u012c\u011c"+
		"\3\2\2\2\u012c\u0124\3\2\2\2\u012d:\3\2\2\2\u012e\u012f\7r\2\2\u012f\u0130"+
		"\7t\2\2\u0130\u0131\7g\2\2\u0131\u0132\7f\2\2\u0132\u0133\7k\2\2\u0133"+
		"\u0134\7e\2\2\u0134\u013d\7v\2\2\u0135\u0136\7R\2\2\u0136\u0137\7t\2\2"+
		"\u0137\u0138\7g\2\2\u0138\u0139\7f\2\2\u0139\u013a\7k\2\2\u013a\u013b"+
		"\7e\2\2\u013b\u013d\7v\2\2\u013c\u012e\3\2\2\2\u013c\u0135\3\2\2\2\u013d"+
		"<\3\2\2\2\u013e\u013f\7T\2\2\u013f\u0140\7g\2\2\u0140\u0141\7c\2\2\u0141"+
		"\u0142\7f\2\2\u0142\u0143\7k\2\2\u0143\u0144\7o\2\2\u0144\u0145\7c\2\2"+
		"\u0145\u0146\7i\2\2\u0146\u0151\7g\2\2\u0147\u0148\7t\2\2\u0148\u0149"+
		"\7g\2\2\u0149\u014a\7c\2\2\u014a\u014b\7f\2\2\u014b\u014c\7k\2\2\u014c"+
		"\u014d\7o\2\2\u014d\u014e\7c\2\2\u014e\u014f\7i\2\2\u014f\u0151\7g\2\2"+
		"\u0150\u013e\3\2\2\2\u0150\u0147\3\2\2\2\u0151>\3\2\2\2\u0152\u0153\7"+
		"~\2\2\u0153\u0154\7~\2\2\u0154@\3\2\2\2\u0155\u0156\7(\2\2\u0156\u0157"+
		"\7(\2\2\u0157B\3\2\2\2\u0158\u0159\7?\2\2\u0159\u015a\7?\2\2\u015aD\3"+
		"\2\2\2\u015b\u015c\7#\2\2\u015c\u015d\7?\2\2\u015dF\3\2\2\2\u015e\u015f"+
		"\7@\2\2\u015fH\3\2\2\2\u0160\u0161\7>\2\2\u0161J\3\2\2\2\u0162\u0163\7"+
		"@\2\2\u0163\u0164\7?\2\2\u0164L\3\2\2\2\u0165\u0166\7>\2\2\u0166\u0167"+
		"\7?\2\2\u0167N\3\2\2\2\u0168\u0169\7v\2\2\u0169\u016a\7t\2\2\u016a\u016b"+
		"\7w\2\2\u016b\u0172\7g\2\2\u016c\u016d\7h\2\2\u016d\u016e\7c\2\2\u016e"+
		"\u016f\7n\2\2\u016f\u0170\7u\2\2\u0170\u0172\7g\2\2\u0171\u0168\3\2\2"+
		"\2\u0171\u016c\3\2\2\2\u0172P\3\2\2\2\u0173\u017f\7\62\2\2\u0174\u0176"+
		"\7/\2\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"\u017b\t\2\2\2\u0178\u017a\t\3\2\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2"+
		"\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017f\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017e\u0173\3\2\2\2\u017e\u0175\3\2\2\2\u017fR\3\2\2\2"+
		"\u0180\u0182\t\3\2\2\u0181\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0181"+
		"\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0189\7\60\2\2"+
		"\u0186\u0188\t\3\2\2\u0187\u0186\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187"+
		"\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0193\3\2\2\2\u018b\u0189\3\2\2\2\u018c"+
		"\u018e\7\60\2\2\u018d\u018f\t\3\2\2\u018e\u018d\3\2\2\2\u018f\u0190\3"+
		"\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192"+
		"\u0181\3\2\2\2\u0192\u018c\3\2\2\2\u0193T\3\2\2\2\u0194\u0196\t\4\2\2"+
		"\u0195\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198"+
		"\3\2\2\2\u0198V\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u01a0\7$\2\2\u019b\u019f"+
		"\n\5\2\2\u019c\u019d\7$\2\2\u019d\u019f\7$\2\2\u019e\u019b\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a4\7$\2\2\u01a4"+
		"X\3\2\2\2\u01a5\u01a6\7K\2\2\u01a6\u01a7\7P\2\2\u01a7\u01a8\7V\2\2\u01a8"+
		"Z\3\2\2\2\u01a9\u01aa\7/\2\2\u01aa\u01ab\7/\2\2\u01ab\u01af\3\2\2\2\u01ac"+
		"\u01ae\n\6\2\2\u01ad\u01ac\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2"+
		"\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2"+
		"\u01b3\b.\2\2\u01b3\\\3\2\2\2\u01b4\u01b5\t\6\2\2\u01b5\u01b6\3\2\2\2"+
		"\u01b6\u01b7\b/\2\2\u01b7^\3\2\2\2\u01b8\u01ba\t\7\2\2\u01b9\u01b8\3\2"+
		"\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01be\b\60\2\2\u01be`\3\2\2\2\30\2\u00cc\u00d8\u00f2"+
		"\u0102\u0112\u012c\u013c\u0150\u0171\u0175\u017b\u017e\u0183\u0189\u0190"+
		"\u0192\u0197\u019e\u01a0\u01af\u01bb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}