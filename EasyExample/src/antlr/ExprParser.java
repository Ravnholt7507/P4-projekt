// Generated from Expr.g4 by ANTLR 4.9.2

package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TRAIN=21, ACTFUNC=22, ARRAY=23, NEURALNETWORK=24, 
		SETUP=25, DATASET=26, ADDDATA=27, READDATA=28, OR=29, AND=30, EQ=31, NEQ=32, 
		GT=33, LT=34, GTEQ=35, LTEQ=36, BOOL=37, INT=38, DOUBLE=39, ID=40, STRING=41, 
		INT_TYPE=42, COMMENT=43, NEWLINE=44, WS=45;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_arraydecl = 2, RULE_array_init = 3, 
		RULE_if_stat = 4, RULE_neural_network = 5, RULE_setup = 6, RULE_dataset = 7, 
		RULE_add_data = 8, RULE_read_data = 9, RULE_condition_block = 10, RULE_stat_block = 11, 
		RULE_while_stat = 12, RULE_train = 13, RULE_epochs = 14, RULE_array = 15, 
		RULE_value = 16, RULE_expr = 17, RULE_print = 18, RULE_read = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "arraydecl", "array_init", "if_stat", "neural_network", 
			"setup", "dataset", "add_data", "read_data", "condition_block", "stat_block", 
			"while_stat", "train", "epochs", "array", "value", "expr", "print", "read"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'['", "']'", "'{'", "'}'", "','", "'if'", "'else if'", 
			"'else'", "'('", "')'", "'.'", "'while'", "'*'", "'/'", "'+'", "'-'", 
			"'Print'", "'read'", "'train'", null, null, "'NeuralNetwork'", null, 
			null, null, null, "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", null, null, null, null, null, "'INT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TRAIN", "ACTFUNC", 
			"ARRAY", "NEURALNETWORK", "SETUP", "DATASET", "ADDDATA", "READDATA", 
			"OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "BOOL", "INT", 
			"DOUBLE", "ID", "STRING", "INT_TYPE", "COMMENT", "NEWLINE", "WS"
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

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramContext extends ProgContext {
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<PrintContext> print() {
			return getRuleContexts(PrintContext.class);
		}
		public PrintContext print(int i) {
			return getRuleContext(PrintContext.class,i);
		}
		public List<If_statContext> if_stat() {
			return getRuleContexts(If_statContext.class);
		}
		public If_statContext if_stat(int i) {
			return getRuleContext(If_statContext.class,i);
		}
		public List<While_statContext> while_stat() {
			return getRuleContexts(While_statContext.class);
		}
		public While_statContext while_stat(int i) {
			return getRuleContext(While_statContext.class,i);
		}
		public List<TrainContext> train() {
			return getRuleContexts(TrainContext.class);
		}
		public TrainContext train(int i) {
			return getRuleContext(TrainContext.class,i);
		}
		public List<ReadContext> read() {
			return getRuleContexts(ReadContext.class);
		}
		public ReadContext read(int i) {
			return getRuleContext(ReadContext.class,i);
		}
		public List<Neural_networkContext> neural_network() {
			return getRuleContexts(Neural_networkContext.class);
		}
		public Neural_networkContext neural_network(int i) {
			return getRuleContext(Neural_networkContext.class,i);
		}
		public List<SetupContext> setup() {
			return getRuleContexts(SetupContext.class);
		}
		public SetupContext setup(int i) {
			return getRuleContext(SetupContext.class,i);
		}
		public List<DatasetContext> dataset() {
			return getRuleContexts(DatasetContext.class);
		}
		public DatasetContext dataset(int i) {
			return getRuleContext(DatasetContext.class,i);
		}
		public List<Add_dataContext> add_data() {
			return getRuleContexts(Add_dataContext.class);
		}
		public Add_dataContext add_data(int i) {
			return getRuleContext(Add_dataContext.class,i);
		}
		public List<Read_dataContext> read_data() {
			return getRuleContexts(Read_dataContext.class);
		}
		public Read_dataContext read_data(int i) {
			return getRuleContext(Read_dataContext.class,i);
		}
		public ProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new ProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(53);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(40);
					decl();
					}
					break;
				case 2:
					{
					setState(41);
					expr(0);
					}
					break;
				case 3:
					{
					setState(42);
					print();
					}
					break;
				case 4:
					{
					setState(43);
					if_stat();
					}
					break;
				case 5:
					{
					setState(44);
					while_stat();
					}
					break;
				case 6:
					{
					setState(45);
					train();
					}
					break;
				case 7:
					{
					setState(46);
					read();
					}
					break;
				case 8:
					{
					setState(47);
					neural_network();
					}
					break;
				case 9:
					{
					setState(48);
					setup();
					}
					break;
				case 10:
					{
					setState(49);
					train();
					}
					break;
				case 11:
					{
					setState(50);
					dataset();
					}
					break;
				case 12:
					{
					setState(51);
					add_data();
					}
					break;
				case 13:
					{
					setState(52);
					read_data();
					}
					break;
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__13) | (1L << T__18) | (1L << T__19) | (1L << NEURALNETWORK) | (1L << DATASET) | (1L << BOOL) | (1L << INT) | (1L << DOUBLE) | (1L << ID) | (1L << STRING))) != 0) );
			setState(57);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ID);
			setState(60);
			match(T__0);
			setState(61);
			expr(0);
			setState(62);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArraydeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public ArraydeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraydecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitArraydecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraydeclContext arraydecl() throws RecognitionException {
		ArraydeclContext _localctx = new ArraydeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arraydecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(ID);
			setState(65);
			match(T__2);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(66);
				match(INT);
				}
			}

			setState(69);
			match(T__3);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(70);
				match(T__0);
				setState(71);
				match(T__4);
				setState(72);
				array_init();
				setState(73);
				match(T__5);
				}
			}

			setState(77);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_initContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLE() { return getTokens(ExprParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(ExprParser.DOUBLE, i);
		}
		public Array_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitArray_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_initContext array_init() throws RecognitionException {
		Array_initContext _localctx = new Array_initContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_array_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(DOUBLE);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(80);
				match(T__6);
				setState(81);
				match(DOUBLE);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statContext extends ParserRuleContext {
		public List<Condition_blockContext> condition_block() {
			return getRuleContexts(Condition_blockContext.class);
		}
		public Condition_blockContext condition_block(int i) {
			return getRuleContext(Condition_blockContext.class,i);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitIf_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__7);
			setState(88);
			condition_block();
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(89);
					match(T__8);
					setState(90);
					condition_block();
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(96);
				match(T__9);
				setState(97);
				stat_block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Neural_networkContext extends ParserRuleContext {
		public TerminalNode NEURALNETWORK() { return getToken(ExprParser.NEURALNETWORK, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public List<TerminalNode> INT() { return getTokens(ExprParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ExprParser.INT, i);
		}
		public Neural_networkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neural_network; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitNeural_network(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Neural_networkContext neural_network() throws RecognitionException {
		Neural_networkContext _localctx = new Neural_networkContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_neural_network);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(NEURALNETWORK);
			setState(101);
			match(ID);
			setState(102);
			match(T__10);
			setState(103);
			match(INT);
			setState(104);
			match(T__6);
			setState(105);
			match(INT);
			setState(106);
			match(T__6);
			setState(107);
			match(INT);
			setState(108);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetupContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public TerminalNode SETUP() { return getToken(ExprParser.SETUP, 0); }
		public TerminalNode DATASET() { return getToken(ExprParser.DATASET, 0); }
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(ID);
			setState(111);
			match(T__12);
			setState(112);
			match(SETUP);
			setState(113);
			match(T__10);
			setState(114);
			match(DATASET);
			setState(115);
			match(ID);
			setState(116);
			match(T__11);
			setState(117);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatasetContext extends ParserRuleContext {
		public TerminalNode DATASET() { return getToken(ExprParser.DATASET, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public DatasetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataset; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitDataset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatasetContext dataset() throws RecognitionException {
		DatasetContext _localctx = new DatasetContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(DATASET);
			setState(120);
			match(ID);
			setState(121);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Add_dataContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode ADDDATA() { return getToken(ExprParser.ADDDATA, 0); }
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
		}
		public Add_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_data; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitAdd_data(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_dataContext add_data() throws RecognitionException {
		Add_dataContext _localctx = new Add_dataContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_add_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(ID);
			setState(124);
			match(T__12);
			setState(125);
			match(ADDDATA);
			setState(126);
			match(T__10);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARRAY) {
				{
				setState(127);
				array();
				setState(128);
				match(T__6);
				setState(129);
				array();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(130);
					match(T__1);
					setState(131);
					array();
					setState(132);
					match(T__6);
					setState(133);
					array();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(142);
			match(T__11);
			setState(143);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_dataContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode READDATA() { return getToken(ExprParser.READDATA, 0); }
		public List<TerminalNode> STRING() { return getTokens(ExprParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ExprParser.STRING, i);
		}
		public Read_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_data; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitRead_data(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_dataContext read_data() throws RecognitionException {
		Read_dataContext _localctx = new Read_dataContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_read_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ID);
			setState(146);
			match(T__12);
			setState(147);
			match(READDATA);
			setState(148);
			match(T__10);
			setState(149);
			match(STRING);
			setState(150);
			match(T__6);
			setState(151);
			match(STRING);
			setState(152);
			match(T__6);
			setState(153);
			match(STRING);
			setState(154);
			match(T__11);
			setState(155);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Condition_blockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public Condition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitCondition_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_blockContext condition_block() throws RecognitionException {
		Condition_blockContext _localctx = new Condition_blockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__10);
			setState(158);
			expr(0);
			setState(159);
			match(T__11);
			setState(160);
			stat_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stat_blockContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<PrintContext> print() {
			return getRuleContexts(PrintContext.class);
		}
		public PrintContext print(int i) {
			return getRuleContext(PrintContext.class,i);
		}
		public List<If_statContext> if_stat() {
			return getRuleContexts(If_statContext.class);
		}
		public If_statContext if_stat(int i) {
			return getRuleContext(If_statContext.class,i);
		}
		public List<While_statContext> while_stat() {
			return getRuleContexts(While_statContext.class);
		}
		public While_statContext while_stat(int i) {
			return getRuleContext(While_statContext.class,i);
		}
		public Stat_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitStat_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_blockContext stat_block() throws RecognitionException {
		Stat_blockContext _localctx = new Stat_blockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stat_block);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(T__4);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__13) | (1L << T__18) | (1L << BOOL) | (1L << INT) | (1L << DOUBLE) | (1L << ID) | (1L << STRING))) != 0)) {
					{
					setState(168);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(163);
						expr(0);
						}
						break;
					case 2:
						{
						setState(164);
						decl();
						}
						break;
					case 3:
						{
						setState(165);
						print();
						}
						break;
					case 4:
						{
						setState(166);
						if_stat();
						}
						break;
					case 5:
						{
						setState(167);
						while_stat();
						}
						break;
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(T__5);
				}
				break;
			case T__7:
			case T__13:
			case T__18:
			case BOOL:
			case INT:
			case DOUBLE:
			case ID:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(174);
					expr(0);
					}
					break;
				case 2:
					{
					setState(175);
					decl();
					}
					break;
				case 3:
					{
					setState(176);
					print();
					}
					break;
				case 4:
					{
					setState(177);
					if_stat();
					}
					break;
				case 5:
					{
					setState(178);
					while_stat();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_statContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public While_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitWhile_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statContext while_stat() throws RecognitionException {
		While_statContext _localctx = new While_statContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__13);
			setState(184);
			match(T__10);
			setState(185);
			expr(0);
			setState(186);
			match(T__11);
			setState(187);
			stat_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrainContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode TRAIN() { return getToken(ExprParser.TRAIN, 0); }
		public EpochsContext epochs() {
			return getRuleContext(EpochsContext.class,0);
		}
		public TrainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_train; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitTrain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrainContext train() throws RecognitionException {
		TrainContext _localctx = new TrainContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_train);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(ID);
			setState(190);
			match(T__12);
			setState(191);
			match(TRAIN);
			setState(192);
			match(T__10);
			setState(193);
			epochs();
			setState(194);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EpochsContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public EpochsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_epochs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitEpochs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EpochsContext epochs() throws RecognitionException {
		EpochsContext _localctx = new EpochsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_epochs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(ExprParser.ARRAY, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(ARRAY);
			setState(199);
			match(T__2);
			setState(200);
			value();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(201);
				match(T__6);
				setState(202);
				value();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(ExprParser.DOUBLE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(ExprParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultiplicationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AdditionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends ExprContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(ExprParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(ExprParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(ExprParser.LT, 0); }
		public TerminalNode GT() { return getToken(ExprParser.GT, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleContext extends ExprContext {
		public TerminalNode DOUBLE() { return getToken(ExprParser.DOUBLE, 0); }
		public DoubleContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(ExprParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubtractionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ExprParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ExprParser.NEQ, 0); }
		public EqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(ExprParser.BOOL, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DivisionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(213);
				match(BOOL);
				}
				break;
			case ID:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(ID);
				}
				break;
			case DOUBLE:
				{
				_localctx = new DoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(DOUBLE);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(INT);
				}
				break;
			case STRING:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(246);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(244);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(221);
						match(T__14);
						setState(222);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new DivisionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(224);
						match(T__15);
						setState(225);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new AdditionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(227);
						match(T__16);
						setState(228);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new SubtractionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(230);
						match(T__17);
						setState(231);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(232);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(233);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(234);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(236);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(237);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(238);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(239);
						match(AND);
						setState(240);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(242);
						match(OR);
						setState(243);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(T__18);
			setState(250);
			match(T__10);
			setState(251);
			expr(0);
			setState(252);
			match(T__11);
			setState(253);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(ExprParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ExprParser.STRING, i);
		}
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__19);
			setState(256);
			match(T__10);
			setState(257);
			match(STRING);
			setState(258);
			match(T__6);
			setState(259);
			match(STRING);
			setState(260);
			match(T__6);
			setState(261);
			match(STRING);
			setState(262);
			match(T__11);
			setState(263);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u010c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\6\28\n\2\r\2\16\29\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\5\4F\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4N\n\4\3\4\3\4\3\5\3\5\3\5\7\5U"+
		"\n\5\f\5\16\5X\13\5\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\6\3\6\5"+
		"\6e\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\7\n\u008a\n\n\f\n\16\n\u008d\13\n\5\n\u008f\n\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ab\n\r\f\r\16\r\u00ae\13\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00b6\n\r\5\r\u00b8\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\7\21\u00ce\n\21\f\21\16\21\u00d1\13\21\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u00dd\n\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u00f7\n\23\f\23\16\23\u00fa\13\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\2\3$\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\5\3"+
		"\2()\3\2#&\3\2!\"\2\u0122\2\67\3\2\2\2\4=\3\2\2\2\6B\3\2\2\2\bQ\3\2\2"+
		"\2\nY\3\2\2\2\ff\3\2\2\2\16p\3\2\2\2\20y\3\2\2\2\22}\3\2\2\2\24\u0093"+
		"\3\2\2\2\26\u009f\3\2\2\2\30\u00b7\3\2\2\2\32\u00b9\3\2\2\2\34\u00bf\3"+
		"\2\2\2\36\u00c6\3\2\2\2 \u00c8\3\2\2\2\"\u00d4\3\2\2\2$\u00dc\3\2\2\2"+
		"&\u00fb\3\2\2\2(\u0101\3\2\2\2*8\5\4\3\2+8\5$\23\2,8\5&\24\2-8\5\n\6\2"+
		".8\5\32\16\2/8\5\34\17\2\608\5(\25\2\618\5\f\7\2\628\5\16\b\2\638\5\34"+
		"\17\2\648\5\20\t\2\658\5\22\n\2\668\5\24\13\2\67*\3\2\2\2\67+\3\2\2\2"+
		"\67,\3\2\2\2\67-\3\2\2\2\67.\3\2\2\2\67/\3\2\2\2\67\60\3\2\2\2\67\61\3"+
		"\2\2\2\67\62\3\2\2\2\67\63\3\2\2\2\67\64\3\2\2\2\67\65\3\2\2\2\67\66\3"+
		"\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7\2\2\3<\3\3\2\2\2"+
		"=>\7*\2\2>?\7\3\2\2?@\5$\23\2@A\7\4\2\2A\5\3\2\2\2BC\7*\2\2CE\7\5\2\2"+
		"DF\7(\2\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GM\7\6\2\2HI\7\3\2\2IJ\7\7\2\2"+
		"JK\5\b\5\2KL\7\b\2\2LN\3\2\2\2MH\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\4\2\2"+
		"P\7\3\2\2\2QV\7)\2\2RS\7\t\2\2SU\7)\2\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2"+
		"VW\3\2\2\2W\t\3\2\2\2XV\3\2\2\2YZ\7\n\2\2Z_\5\26\f\2[\\\7\13\2\2\\^\5"+
		"\26\f\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`d\3\2\2\2a_\3\2\2\2bc"+
		"\7\f\2\2ce\5\30\r\2db\3\2\2\2de\3\2\2\2e\13\3\2\2\2fg\7\32\2\2gh\7*\2"+
		"\2hi\7\r\2\2ij\7(\2\2jk\7\t\2\2kl\7(\2\2lm\7\t\2\2mn\7(\2\2no\7\16\2\2"+
		"o\r\3\2\2\2pq\7*\2\2qr\7\17\2\2rs\7\33\2\2st\7\r\2\2tu\7\34\2\2uv\7*\2"+
		"\2vw\7\16\2\2wx\7\4\2\2x\17\3\2\2\2yz\7\34\2\2z{\7*\2\2{|\7\4\2\2|\21"+
		"\3\2\2\2}~\7*\2\2~\177\7\17\2\2\177\u0080\7\35\2\2\u0080\u008e\7\r\2\2"+
		"\u0081\u0082\5 \21\2\u0082\u0083\7\t\2\2\u0083\u008b\5 \21\2\u0084\u0085"+
		"\7\4\2\2\u0085\u0086\5 \21\2\u0086\u0087\7\t\2\2\u0087\u0088\5 \21\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0084\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008b\u008c\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\u0081\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\16"+
		"\2\2\u0091\u0092\7\4\2\2\u0092\23\3\2\2\2\u0093\u0094\7*\2\2\u0094\u0095"+
		"\7\17\2\2\u0095\u0096\7\36\2\2\u0096\u0097\7\r\2\2\u0097\u0098\7+\2\2"+
		"\u0098\u0099\7\t\2\2\u0099\u009a\7+\2\2\u009a\u009b\7\t\2\2\u009b\u009c"+
		"\7+\2\2\u009c\u009d\7\16\2\2\u009d\u009e\7\4\2\2\u009e\25\3\2\2\2\u009f"+
		"\u00a0\7\r\2\2\u00a0\u00a1\5$\23\2\u00a1\u00a2\7\16\2\2\u00a2\u00a3\5"+
		"\30\r\2\u00a3\27\3\2\2\2\u00a4\u00ac\7\7\2\2\u00a5\u00ab\5$\23\2\u00a6"+
		"\u00ab\5\4\3\2\u00a7\u00ab\5&\24\2\u00a8\u00ab\5\n\6\2\u00a9\u00ab\5\32"+
		"\16\2\u00aa\u00a5\3\2\2\2\u00aa\u00a6\3\2\2\2\u00aa\u00a7\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u00b8\7\b\2\2\u00b0\u00b6\5$\23\2\u00b1\u00b6\5\4\3\2\u00b2\u00b6\5&"+
		"\24\2\u00b3\u00b6\5\n\6\2\u00b4\u00b6\5\32\16\2\u00b5\u00b0\3\2\2\2\u00b5"+
		"\u00b1\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2"+
		"\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00a4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8"+
		"\31\3\2\2\2\u00b9\u00ba\7\20\2\2\u00ba\u00bb\7\r\2\2\u00bb\u00bc\5$\23"+
		"\2\u00bc\u00bd\7\16\2\2\u00bd\u00be\5\30\r\2\u00be\33\3\2\2\2\u00bf\u00c0"+
		"\7*\2\2\u00c0\u00c1\7\17\2\2\u00c1\u00c2\7\27\2\2\u00c2\u00c3\7\r\2\2"+
		"\u00c3\u00c4\5\36\20\2\u00c4\u00c5\7\16\2\2\u00c5\35\3\2\2\2\u00c6\u00c7"+
		"\7(\2\2\u00c7\37\3\2\2\2\u00c8\u00c9\7\31\2\2\u00c9\u00ca\7\5\2\2\u00ca"+
		"\u00cf\5\"\22\2\u00cb\u00cc\7\t\2\2\u00cc\u00ce\5\"\22\2\u00cd\u00cb\3"+
		"\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7\6\2\2\u00d3!\3\2\2\2"+
		"\u00d4\u00d5\t\2\2\2\u00d5#\3\2\2\2\u00d6\u00d7\b\23\1\2\u00d7\u00dd\7"+
		"\'\2\2\u00d8\u00dd\7*\2\2\u00d9\u00dd\7)\2\2\u00da\u00dd\7(\2\2\u00db"+
		"\u00dd\7+\2\2\u00dc\u00d6\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00d9\3\2"+
		"\2\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00f8\3\2\2\2\u00de"+
		"\u00df\f\17\2\2\u00df\u00e0\7\21\2\2\u00e0\u00f7\5$\23\20\u00e1\u00e2"+
		"\f\16\2\2\u00e2\u00e3\7\22\2\2\u00e3\u00f7\5$\23\17\u00e4\u00e5\f\r\2"+
		"\2\u00e5\u00e6\7\23\2\2\u00e6\u00f7\5$\23\16\u00e7\u00e8\f\f\2\2\u00e8"+
		"\u00e9\7\24\2\2\u00e9\u00f7\5$\23\r\u00ea\u00eb\f\13\2\2\u00eb\u00ec\t"+
		"\3\2\2\u00ec\u00f7\5$\23\f\u00ed\u00ee\f\n\2\2\u00ee\u00ef\t\4\2\2\u00ef"+
		"\u00f7\5$\23\13\u00f0\u00f1\f\t\2\2\u00f1\u00f2\7 \2\2\u00f2\u00f7\5$"+
		"\23\n\u00f3\u00f4\f\b\2\2\u00f4\u00f5\7\37\2\2\u00f5\u00f7\5$\23\t\u00f6"+
		"\u00de\3\2\2\2\u00f6\u00e1\3\2\2\2\u00f6\u00e4\3\2\2\2\u00f6\u00e7\3\2"+
		"\2\2\u00f6\u00ea\3\2\2\2\u00f6\u00ed\3\2\2\2\u00f6\u00f0\3\2\2\2\u00f6"+
		"\u00f3\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9%\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7\25\2\2\u00fc\u00fd"+
		"\7\r\2\2\u00fd\u00fe\5$\23\2\u00fe\u00ff\7\16\2\2\u00ff\u0100\7\4\2\2"+
		"\u0100\'\3\2\2\2\u0101\u0102\7\26\2\2\u0102\u0103\7\r\2\2\u0103\u0104"+
		"\7+\2\2\u0104\u0105\7\t\2\2\u0105\u0106\7+\2\2\u0106\u0107\7\t\2\2\u0107"+
		"\u0108\7+\2\2\u0108\u0109\7\16\2\2\u0109\u010a\7\4\2\2\u010a)\3\2\2\2"+
		"\23\679EMV_d\u008b\u008e\u00aa\u00ac\u00b5\u00b7\u00cf\u00dc\u00f6\u00f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}