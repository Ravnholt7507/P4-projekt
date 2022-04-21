// Generated from Grammar.g4 by ANTLR 4.9.2

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
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ID=2, INT_TYPE=3, FLOAT_TYPE=4, INT=5, FLOAT=6, COMMENT=7, NEWLINE=8, 
		WS=9, PLUS=10, MINUS=11, MULT=12, DIV=13, MOD=14, POW=15, NOT=16, SCOL=17, 
		OPAR=18, CPAR=19, OBRACE=20, CBRACE=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "ID", "INT_TYPE", "FLOAT_TYPE", "INT", "FLOAT", "COMMENT", "NEWLINE", 
			"WS", "PLUS", "MINUS", "MULT", "DIV", "MOD", "POW", "NOT", "SCOL", "OPAR", 
			"CPAR", "OBRACE", "CBRACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", null, "'int'", "'float'", null, null, null, null, null, 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "';'", "'('", "')'", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "ID", "INT_TYPE", "FLOAT_TYPE", "INT", "FLOAT", "COMMENT", 
			"NEWLINE", "WS", "PLUS", "MINUS", "MULT", "DIV", "MOD", "POW", "NOT", 
			"SCOL", "OPAR", "CPAR", "OBRACE", "CBRACE"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0087\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\7\3\62\n"+
		"\3\f\3\16\3\65\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6B\n"+
		"\6\r\6\16\6C\3\7\6\7G\n\7\r\7\16\7H\3\7\3\7\7\7M\n\7\f\7\16\7P\13\7\3"+
		"\7\3\7\6\7T\n\7\r\7\16\7U\5\7X\n\7\3\b\3\b\3\b\3\b\7\b^\n\b\f\b\16\ba"+
		"\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\6\nj\n\n\r\n\16\nk\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4\2\f\f\17\17\4\2\13\f\"\""+
		"\2\u008e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2"+
		"\5/\3\2\2\2\7\66\3\2\2\2\t:\3\2\2\2\13A\3\2\2\2\rW\3\2\2\2\17Y\3\2\2\2"+
		"\21d\3\2\2\2\23i\3\2\2\2\25o\3\2\2\2\27q\3\2\2\2\31s\3\2\2\2\33u\3\2\2"+
		"\2\35w\3\2\2\2\37y\3\2\2\2!{\3\2\2\2#}\3\2\2\2%\177\3\2\2\2\'\u0081\3"+
		"\2\2\2)\u0083\3\2\2\2+\u0085\3\2\2\2-.\7?\2\2.\4\3\2\2\2/\63\t\2\2\2\60"+
		"\62\t\3\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64"+
		"\6\3\2\2\2\65\63\3\2\2\2\66\67\7k\2\2\678\7p\2\289\7v\2\29\b\3\2\2\2:"+
		";\7h\2\2;<\7n\2\2<=\7q\2\2=>\7c\2\2>?\7v\2\2?\n\3\2\2\2@B\t\4\2\2A@\3"+
		"\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\f\3\2\2\2EG\t\4\2\2FE\3\2\2\2GH"+
		"\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JN\7\60\2\2KM\t\4\2\2LK\3\2\2\2"+
		"MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OX\3\2\2\2PN\3\2\2\2QS\7\60\2\2RT\t\4\2"+
		"\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WF\3\2\2\2WQ\3\2\2"+
		"\2X\16\3\2\2\2YZ\7/\2\2Z[\7/\2\2[_\3\2\2\2\\^\n\5\2\2]\\\3\2\2\2^a\3\2"+
		"\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\b\b\2\2c\20\3\2\2\2de\t"+
		"\5\2\2ef\3\2\2\2fg\b\t\2\2g\22\3\2\2\2hj\t\6\2\2ih\3\2\2\2jk\3\2\2\2k"+
		"i\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\b\n\2\2n\24\3\2\2\2op\7-\2\2p\26\3\2\2"+
		"\2qr\7/\2\2r\30\3\2\2\2st\7,\2\2t\32\3\2\2\2uv\7\61\2\2v\34\3\2\2\2wx"+
		"\7\'\2\2x\36\3\2\2\2yz\7`\2\2z \3\2\2\2{|\7#\2\2|\"\3\2\2\2}~\7=\2\2~"+
		"$\3\2\2\2\177\u0080\7*\2\2\u0080&\3\2\2\2\u0081\u0082\7+\2\2\u0082(\3"+
		"\2\2\2\u0083\u0084\7}\2\2\u0084*\3\2\2\2\u0085\u0086\7\177\2\2\u0086,"+
		"\3\2\2\2\13\2\63CHNUW_k\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}