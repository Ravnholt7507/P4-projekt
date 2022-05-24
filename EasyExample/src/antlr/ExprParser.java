// Generated from Expr.g4 by ANTLR 4.9.3

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
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TRAIN=13, ACTFUNC=14, NEURALNETWORK=15, SETUP=16, 
		DATASET=17, ADDDATA=18, READDATA=19, PREDICT=20, READIMAGE=21, PRINT=22, 
		MULT=23, DIV=24, ADD=25, SUB=26, OR=27, AND=28, EQ=29, NEQ=30, GT=31, 
		LT=32, GTEQ=33, LTEQ=34, LPAR=35, RPAR=36, BOOL=37, INT=38, DOUBLE=39, 
		ID=40, STRING=41, INT_TYPE=42, COMMENT=43, NEWLINE=44, WS=45;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_if_stat = 2, RULE_condition_block = 3, 
		RULE_stat_block = 4, RULE_stat_block_NN = 5, RULE_while_stat = 6, RULE_neural_network = 7, 
		RULE_setup = 8, RULE_dataset = 9, RULE_add_data = 10, RULE_read_data = 11, 
		RULE_read_image_data = 12, RULE_predict = 13, RULE_train = 14, RULE_epochs = 15, 
		RULE_arraydecl = 16, RULE_array = 17, RULE_value = 18, RULE_expr = 19, 
		RULE_print = 20, RULE_read = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "if_stat", "condition_block", "stat_block", "stat_block_NN", 
			"while_stat", "neural_network", "setup", "dataset", "add_data", "read_data", 
			"read_image_data", "predict", "train", "epochs", "arraydecl", "array", 
			"value", "expr", "print", "read"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'if'", "'else'", "'{'", "'}'", "'while'", "','", 
			"'.'", "'['", "']'", "'read'", "'train'", null, "'NeuralNetwork'", null, 
			null, null, null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'||'", 
			"'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'('", "')'", null, 
			null, null, null, null, "'INT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TRAIN", "ACTFUNC", "NEURALNETWORK", "SETUP", "DATASET", "ADDDATA", 
			"READDATA", "PREDICT", "READIMAGE", "PRINT", "MULT", "DIV", "ADD", "SUB", 
			"OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "LPAR", "RPAR", 
			"BOOL", "INT", "DOUBLE", "ID", "STRING", "INT_TYPE", "COMMENT", "NEWLINE", 
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
		public List<Stat_blockContext> stat_block() {
			return getRuleContexts(Stat_blockContext.class);
		}
		public Stat_blockContext stat_block(int i) {
			return getRuleContext(Stat_blockContext.class,i);
		}
		public List<Stat_block_NNContext> stat_block_NN() {
			return getRuleContexts(Stat_block_NNContext.class);
		}
		public Stat_block_NNContext stat_block_NN(int i) {
			return getRuleContext(Stat_block_NNContext.class,i);
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
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(46);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(44);
					stat_block();
					}
					break;
				case 2:
					{
					setState(45);
					stat_block_NN();
					}
					break;
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__6) | (1L << NEURALNETWORK) | (1L << DATASET) | (1L << PRINT) | (1L << LPAR) | (1L << BOOL) | (1L << INT) | (1L << DOUBLE) | (1L << ID) | (1L << STRING))) != 0) );
			setState(50);
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
			setState(52);
			match(ID);
			setState(53);
			match(T__0);
			setState(54);
			expr(0);
			setState(55);
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

	public static class If_statContext extends ParserRuleContext {
		public Condition_blockContext condition_block() {
			return getRuleContext(Condition_blockContext.class,0);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public Stat_block_NNContext stat_block_NN() {
			return getRuleContext(Stat_block_NNContext.class,0);
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
		enterRule(_localctx, 4, RULE_if_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__2);
			setState(58);
			condition_block();
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(59);
				match(T__3);
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(60);
					stat_block();
					}
					break;
				case 2:
					{
					setState(61);
					stat_block_NN();
					}
					break;
				}
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

	public static class Condition_blockContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public Stat_block_NNContext stat_block_NN() {
			return getRuleContext(Stat_block_NNContext.class,0);
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
		enterRule(_localctx, 6, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(LPAR);
			setState(67);
			expr(0);
			setState(68);
			match(RPAR);
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(69);
				stat_block();
				}
				break;
			case 2:
				{
				setState(70);
				stat_block_NN();
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
		enterRule(_localctx, 8, RULE_stat_block);
		int _la;
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(T__4);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << PRINT) | (1L << LPAR) | (1L << BOOL) | (1L << INT) | (1L << DOUBLE) | (1L << ID) | (1L << STRING))) != 0)) {
					{
					setState(79);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(74);
						expr(0);
						}
						break;
					case 2:
						{
						setState(75);
						decl();
						}
						break;
					case 3:
						{
						setState(76);
						print();
						}
						break;
					case 4:
						{
						setState(77);
						if_stat();
						}
						break;
					case 5:
						{
						setState(78);
						while_stat();
						}
						break;
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(T__5);
				}
				break;
			case T__2:
			case T__6:
			case PRINT:
			case LPAR:
			case BOOL:
			case INT:
			case DOUBLE:
			case ID:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(85);
					expr(0);
					}
					break;
				case 2:
					{
					setState(86);
					decl();
					}
					break;
				case 3:
					{
					setState(87);
					print();
					}
					break;
				case 4:
					{
					setState(88);
					if_stat();
					}
					break;
				case 5:
					{
					setState(89);
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

	public static class Stat_block_NNContext extends ParserRuleContext {
		public List<TrainContext> train() {
			return getRuleContexts(TrainContext.class);
		}
		public TrainContext train(int i) {
			return getRuleContext(TrainContext.class,i);
		}
		public List<Neural_networkContext> neural_network() {
			return getRuleContexts(Neural_networkContext.class);
		}
		public Neural_networkContext neural_network(int i) {
			return getRuleContext(Neural_networkContext.class,i);
		}
		public List<Read_image_dataContext> read_image_data() {
			return getRuleContexts(Read_image_dataContext.class);
		}
		public Read_image_dataContext read_image_data(int i) {
			return getRuleContext(Read_image_dataContext.class,i);
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
		public List<PredictContext> predict() {
			return getRuleContexts(PredictContext.class);
		}
		public PredictContext predict(int i) {
			return getRuleContext(PredictContext.class,i);
		}
		public Stat_block_NNContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block_NN; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitStat_block_NN(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_block_NNContext stat_block_NN() throws RecognitionException {
		Stat_block_NNContext _localctx = new Stat_block_NNContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stat_block_NN);
		int _la;
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(T__4);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEURALNETWORK) | (1L << DATASET) | (1L << ID))) != 0)) {
					{
					setState(103);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(95);
						train();
						}
						break;
					case 2:
						{
						setState(96);
						neural_network();
						}
						break;
					case 3:
						{
						setState(97);
						read_image_data();
						}
						break;
					case 4:
						{
						setState(98);
						setup();
						}
						break;
					case 5:
						{
						setState(99);
						dataset();
						}
						break;
					case 6:
						{
						setState(100);
						add_data();
						}
						break;
					case 7:
						{
						setState(101);
						read_data();
						}
						break;
					case 8:
						{
						setState(102);
						predict();
						}
						break;
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(108);
				match(T__5);
				}
				break;
			case NEURALNETWORK:
			case DATASET:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(109);
					train();
					}
					break;
				case 2:
					{
					setState(110);
					neural_network();
					}
					break;
				case 3:
					{
					setState(111);
					read_image_data();
					}
					break;
				case 4:
					{
					setState(112);
					setup();
					}
					break;
				case 5:
					{
					setState(113);
					dataset();
					}
					break;
				case 6:
					{
					setState(114);
					add_data();
					}
					break;
				case 7:
					{
					setState(115);
					read_data();
					}
					break;
				case 8:
					{
					setState(116);
					predict();
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
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
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
		enterRule(_localctx, 12, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__6);
			setState(122);
			match(LPAR);
			setState(123);
			expr(0);
			setState(124);
			match(RPAR);
			setState(125);
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

	public static class Neural_networkContext extends ParserRuleContext {
		public TerminalNode NEURALNETWORK() { return getToken(ExprParser.NEURALNETWORK, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
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
		enterRule(_localctx, 14, RULE_neural_network);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(NEURALNETWORK);
			setState(128);
			match(ID);
			setState(129);
			match(LPAR);
			setState(130);
			expr(0);
			setState(131);
			match(T__7);
			setState(132);
			expr(0);
			setState(133);
			match(T__7);
			setState(134);
			expr(0);
			setState(135);
			match(RPAR);
			setState(136);
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

	public static class SetupContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public TerminalNode SETUP() { return getToken(ExprParser.SETUP, 0); }
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
		public TerminalNode ACTFUNC() { return getToken(ExprParser.ACTFUNC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_setup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ID);
			setState(139);
			match(T__8);
			setState(140);
			match(SETUP);
			setState(141);
			match(LPAR);
			setState(142);
			match(ID);
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(143);
				match(T__7);
				setState(144);
				match(ACTFUNC);
				}
				break;
			}
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(147);
				match(T__7);
				setState(148);
				expr(0);
				}
			}

			setState(151);
			match(RPAR);
			setState(152);
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
		enterRule(_localctx, 18, RULE_dataset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(DATASET);
			setState(155);
			match(ID);
			setState(156);
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
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
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
		enterRule(_localctx, 20, RULE_add_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(ID);
			setState(159);
			match(T__8);
			setState(160);
			match(ADDDATA);
			setState(161);
			match(LPAR);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(162);
				array();
				setState(163);
				match(T__7);
				setState(164);
				array();
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(165);
					match(T__1);
					setState(166);
					array();
					setState(167);
					match(T__7);
					setState(168);
					array();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(177);
			match(RPAR);
			setState(178);
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
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public TerminalNode READDATA() { return getToken(ExprParser.READDATA, 0); }
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public List<TerminalNode> STRING() { return getTokens(ExprParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ExprParser.STRING, i);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
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
		enterRule(_localctx, 22, RULE_read_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(ID);
			setState(181);
			match(T__8);
			setState(182);
			match(READDATA);
			setState(183);
			match(LPAR);
			setState(184);
			match(ID);
			setState(185);
			match(T__7);
			setState(186);
			match(ID);
			setState(187);
			match(T__7);
			setState(188);
			match(STRING);
			setState(189);
			match(T__7);
			setState(190);
			match(STRING);
			setState(191);
			match(RPAR);
			setState(192);
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

	public static class Read_image_dataContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public TerminalNode READIMAGE() { return getToken(ExprParser.READIMAGE, 0); }
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public List<TerminalNode> STRING() { return getTokens(ExprParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ExprParser.STRING, i);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
		public Read_image_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_image_data; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitRead_image_data(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_image_dataContext read_image_data() throws RecognitionException {
		Read_image_dataContext _localctx = new Read_image_dataContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_read_image_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(ID);
			setState(195);
			match(T__8);
			setState(196);
			match(READIMAGE);
			setState(197);
			match(LPAR);
			setState(198);
			match(ID);
			setState(199);
			match(T__7);
			setState(200);
			match(ID);
			setState(201);
			match(T__7);
			setState(202);
			match(STRING);
			setState(203);
			match(T__7);
			setState(204);
			match(STRING);
			setState(205);
			match(RPAR);
			setState(206);
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

	public static class PredictContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public TerminalNode PREDICT() { return getToken(ExprParser.PREDICT, 0); }
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
		public PredictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predict; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitPredict(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredictContext predict() throws RecognitionException {
		PredictContext _localctx = new PredictContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_predict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(ID);
			setState(209);
			match(T__8);
			setState(210);
			match(PREDICT);
			setState(211);
			match(LPAR);
			setState(212);
			match(ID);
			setState(213);
			match(RPAR);
			setState(214);
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

	public static class TrainContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public TerminalNode TRAIN() { return getToken(ExprParser.TRAIN, 0); }
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
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
		enterRule(_localctx, 28, RULE_train);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(ID);
			setState(217);
			match(T__8);
			setState(218);
			match(TRAIN);
			setState(219);
			match(LPAR);
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(220);
				match(ID);
				setState(221);
				match(T__7);
				}
				break;
			}
			setState(224);
			expr(0);
			setState(225);
			match(RPAR);
			setState(226);
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
		enterRule(_localctx, 30, RULE_epochs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
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

	public static class ArraydeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
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
		enterRule(_localctx, 32, RULE_arraydecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(ID);
			setState(231);
			match(T__9);
			setState(232);
			expr(0);
			setState(233);
			match(T__10);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(234);
				match(T__0);
				setState(235);
				array();
				}
			}

			setState(238);
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

	public static class ArrayContext extends ParserRuleContext {
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
		enterRule(_localctx, 34, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__4);
			setState(241);
			value();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(242);
				match(T__7);
				setState(243);
				value();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249);
			match(T__5);
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
		enterRule(_localctx, 36, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
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
	public static class ParExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitParExpr(this);
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
	public static class MultiOpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(ExprParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(ExprParser.DIV, 0); }
		public MultiOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitMultiOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveOpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ExprParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ExprParser.SUB, 0); }
		public AdditiveOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitAdditiveOp(this);
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

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(254);
				match(LPAR);
				setState(255);
				expr(0);
				setState(256);
				match(RPAR);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(BOOL);
				}
				break;
			case ID:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(259);
				match(ID);
				}
				break;
			case DOUBLE:
				{
				_localctx = new DoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
				match(DOUBLE);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261);
				match(INT);
				}
				break;
			case STRING:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(283);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new MultiOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(266);
						((MultiOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((MultiOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(267);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(269);
						((AdditiveOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AdditiveOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(270);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(272);
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
						setState(273);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(275);
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
						setState(276);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(278);
						match(AND);
						setState(279);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(280);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(281);
						match(OR);
						setState(282);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		public TerminalNode PRINT() { return getToken(ExprParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
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
		enterRule(_localctx, 40, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(PRINT);
			setState(289);
			match(LPAR);
			setState(290);
			expr(0);
			setState(291);
			match(RPAR);
			setState(292);
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
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public List<TerminalNode> STRING() { return getTokens(ExprParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ExprParser.STRING, i);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
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
		enterRule(_localctx, 42, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__11);
			setState(295);
			match(LPAR);
			setState(296);
			match(STRING);
			setState(297);
			match(T__7);
			setState(298);
			match(STRING);
			setState(299);
			match(T__7);
			setState(300);
			match(STRING);
			setState(301);
			match(RPAR);
			setState(302);
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
		case 19:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0133\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\6\2\61\n\2"+
		"\r\2\16\2\62\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4A\n\4"+
		"\5\4C\n\4\3\5\3\5\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6R\n"+
		"\6\f\6\16\6U\13\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6]\n\6\5\6_\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7x\n\7\5\7z\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0094"+
		"\n\n\3\n\3\n\5\n\u0098\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ad\n\f\f\f\16\f\u00b0\13\f"+
		"\5\f\u00b2\n\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u00e1\n\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00ef\n\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23"+
		"\u00f7\n\23\f\23\16\23\u00fa\13\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u010a\n\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\7\25\u011e\n\25\f\25\16\25\u0121\13\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\2\3(\30\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\7\3\2()\3\2\31\32\3\2\33\34"+
		"\3\2!$\3\2\37 \2\u014d\2\60\3\2\2\2\4\66\3\2\2\2\6;\3\2\2\2\bD\3\2\2\2"+
		"\n^\3\2\2\2\fy\3\2\2\2\16{\3\2\2\2\20\u0081\3\2\2\2\22\u008c\3\2\2\2\24"+
		"\u009c\3\2\2\2\26\u00a0\3\2\2\2\30\u00b6\3\2\2\2\32\u00c4\3\2\2\2\34\u00d2"+
		"\3\2\2\2\36\u00da\3\2\2\2 \u00e6\3\2\2\2\"\u00e8\3\2\2\2$\u00f2\3\2\2"+
		"\2&\u00fd\3\2\2\2(\u0109\3\2\2\2*\u0122\3\2\2\2,\u0128\3\2\2\2.\61\5\n"+
		"\6\2/\61\5\f\7\2\60.\3\2\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62"+
		"\63\3\2\2\2\63\64\3\2\2\2\64\65\7\2\2\3\65\3\3\2\2\2\66\67\7*\2\2\678"+
		"\7\3\2\289\5(\25\29:\7\4\2\2:\5\3\2\2\2;<\7\5\2\2<B\5\b\5\2=@\7\6\2\2"+
		">A\5\n\6\2?A\5\f\7\2@>\3\2\2\2@?\3\2\2\2AC\3\2\2\2B=\3\2\2\2BC\3\2\2\2"+
		"C\7\3\2\2\2DE\7%\2\2EF\5(\25\2FI\7&\2\2GJ\5\n\6\2HJ\5\f\7\2IG\3\2\2\2"+
		"IH\3\2\2\2J\t\3\2\2\2KS\7\7\2\2LR\5(\25\2MR\5\4\3\2NR\5*\26\2OR\5\6\4"+
		"\2PR\5\16\b\2QL\3\2\2\2QM\3\2\2\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2RU\3\2"+
		"\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2V_\7\b\2\2W]\5(\25\2X]\5\4"+
		"\3\2Y]\5*\26\2Z]\5\6\4\2[]\5\16\b\2\\W\3\2\2\2\\X\3\2\2\2\\Y\3\2\2\2\\"+
		"Z\3\2\2\2\\[\3\2\2\2]_\3\2\2\2^K\3\2\2\2^\\\3\2\2\2_\13\3\2\2\2`k\7\7"+
		"\2\2aj\5\36\20\2bj\5\20\t\2cj\5\32\16\2dj\5\22\n\2ej\5\24\13\2fj\5\26"+
		"\f\2gj\5\30\r\2hj\5\34\17\2ia\3\2\2\2ib\3\2\2\2ic\3\2\2\2id\3\2\2\2ie"+
		"\3\2\2\2if\3\2\2\2ig\3\2\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l"+
		"n\3\2\2\2mk\3\2\2\2nz\7\b\2\2ox\5\36\20\2px\5\20\t\2qx\5\32\16\2rx\5\22"+
		"\n\2sx\5\24\13\2tx\5\26\f\2ux\5\30\r\2vx\5\34\17\2wo\3\2\2\2wp\3\2\2\2"+
		"wq\3\2\2\2wr\3\2\2\2ws\3\2\2\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2xz\3\2\2\2"+
		"y`\3\2\2\2yw\3\2\2\2z\r\3\2\2\2{|\7\t\2\2|}\7%\2\2}~\5(\25\2~\177\7&\2"+
		"\2\177\u0080\5\n\6\2\u0080\17\3\2\2\2\u0081\u0082\7\21\2\2\u0082\u0083"+
		"\7*\2\2\u0083\u0084\7%\2\2\u0084\u0085\5(\25\2\u0085\u0086\7\n\2\2\u0086"+
		"\u0087\5(\25\2\u0087\u0088\7\n\2\2\u0088\u0089\5(\25\2\u0089\u008a\7&"+
		"\2\2\u008a\u008b\7\4\2\2\u008b\21\3\2\2\2\u008c\u008d\7*\2\2\u008d\u008e"+
		"\7\13\2\2\u008e\u008f\7\22\2\2\u008f\u0090\7%\2\2\u0090\u0093\7*\2\2\u0091"+
		"\u0092\7\n\2\2\u0092\u0094\7\20\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0097\3\2\2\2\u0095\u0096\7\n\2\2\u0096\u0098\5(\25\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7&"+
		"\2\2\u009a\u009b\7\4\2\2\u009b\23\3\2\2\2\u009c\u009d\7\23\2\2\u009d\u009e"+
		"\7*\2\2\u009e\u009f\7\4\2\2\u009f\25\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1"+
		"\u00a2\7\13\2\2\u00a2\u00a3\7\24\2\2\u00a3\u00b1\7%\2\2\u00a4\u00a5\5"+
		"$\23\2\u00a5\u00a6\7\n\2\2\u00a6\u00ae\5$\23\2\u00a7\u00a8\7\4\2\2\u00a8"+
		"\u00a9\5$\23\2\u00a9\u00aa\7\n\2\2\u00aa\u00ab\5$\23\2\u00ab\u00ad\3\2"+
		"\2\2\u00ac\u00a7\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00a4\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7&\2\2\u00b4"+
		"\u00b5\7\4\2\2\u00b5\27\3\2\2\2\u00b6\u00b7\7*\2\2\u00b7\u00b8\7\13\2"+
		"\2\u00b8\u00b9\7\25\2\2\u00b9\u00ba\7%\2\2\u00ba\u00bb\7*\2\2\u00bb\u00bc"+
		"\7\n\2\2\u00bc\u00bd\7*\2\2\u00bd\u00be\7\n\2\2\u00be\u00bf\7+\2\2\u00bf"+
		"\u00c0\7\n\2\2\u00c0\u00c1\7+\2\2\u00c1\u00c2\7&\2\2\u00c2\u00c3\7\4\2"+
		"\2\u00c3\31\3\2\2\2\u00c4\u00c5\7*\2\2\u00c5\u00c6\7\13\2\2\u00c6\u00c7"+
		"\7\27\2\2\u00c7\u00c8\7%\2\2\u00c8\u00c9\7*\2\2\u00c9\u00ca\7\n\2\2\u00ca"+
		"\u00cb\7*\2\2\u00cb\u00cc\7\n\2\2\u00cc\u00cd\7+\2\2\u00cd\u00ce\7\n\2"+
		"\2\u00ce\u00cf\7+\2\2\u00cf\u00d0\7&\2\2\u00d0\u00d1\7\4\2\2\u00d1\33"+
		"\3\2\2\2\u00d2\u00d3\7*\2\2\u00d3\u00d4\7\13\2\2\u00d4\u00d5\7\26\2\2"+
		"\u00d5\u00d6\7%\2\2\u00d6\u00d7\7*\2\2\u00d7\u00d8\7&\2\2\u00d8\u00d9"+
		"\7\4\2\2\u00d9\35\3\2\2\2\u00da\u00db\7*\2\2\u00db\u00dc\7\13\2\2\u00dc"+
		"\u00dd\7\17\2\2\u00dd\u00e0\7%\2\2\u00de\u00df\7*\2\2\u00df\u00e1\7\n"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e3\5(\25\2\u00e3\u00e4\7&\2\2\u00e4\u00e5\7\4\2\2\u00e5\37\3\2\2\2"+
		"\u00e6\u00e7\7(\2\2\u00e7!\3\2\2\2\u00e8\u00e9\7*\2\2\u00e9\u00ea\7\f"+
		"\2\2\u00ea\u00eb\5(\25\2\u00eb\u00ee\7\r\2\2\u00ec\u00ed\7\3\2\2\u00ed"+
		"\u00ef\5$\23\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f1\7\4\2\2\u00f1#\3\2\2\2\u00f2\u00f3\7\7\2\2\u00f3\u00f8"+
		"\5&\24\2\u00f4\u00f5\7\n\2\2\u00f5\u00f7\5&\24\2\u00f6\u00f4\3\2\2\2\u00f7"+
		"\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2"+
		"\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7\b\2\2\u00fc%\3\2\2\2\u00fd\u00fe"+
		"\t\2\2\2\u00fe\'\3\2\2\2\u00ff\u0100\b\25\1\2\u0100\u0101\7%\2\2\u0101"+
		"\u0102\5(\25\2\u0102\u0103\7&\2\2\u0103\u010a\3\2\2\2\u0104\u010a\7\'"+
		"\2\2\u0105\u010a\7*\2\2\u0106\u010a\7)\2\2\u0107\u010a\7(\2\2\u0108\u010a"+
		"\7+\2\2\u0109\u00ff\3\2\2\2\u0109\u0104\3\2\2\2\u0109\u0105\3\2\2\2\u0109"+
		"\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\u011f\3\2"+
		"\2\2\u010b\u010c\f\16\2\2\u010c\u010d\t\3\2\2\u010d\u011e\5(\25\17\u010e"+
		"\u010f\f\r\2\2\u010f\u0110\t\4\2\2\u0110\u011e\5(\25\16\u0111\u0112\f"+
		"\f\2\2\u0112\u0113\t\5\2\2\u0113\u011e\5(\25\r\u0114\u0115\f\13\2\2\u0115"+
		"\u0116\t\6\2\2\u0116\u011e\5(\25\f\u0117\u0118\f\n\2\2\u0118\u0119\7\36"+
		"\2\2\u0119\u011e\5(\25\13\u011a\u011b\f\t\2\2\u011b\u011c\7\35\2\2\u011c"+
		"\u011e\5(\25\n\u011d\u010b\3\2\2\2\u011d\u010e\3\2\2\2\u011d\u0111\3\2"+
		"\2\2\u011d\u0114\3\2\2\2\u011d\u0117\3\2\2\2\u011d\u011a\3\2\2\2\u011e"+
		"\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120)\3\2\2\2"+
		"\u0121\u011f\3\2\2\2\u0122\u0123\7\30\2\2\u0123\u0124\7%\2\2\u0124\u0125"+
		"\5(\25\2\u0125\u0126\7&\2\2\u0126\u0127\7\4\2\2\u0127+\3\2\2\2\u0128\u0129"+
		"\7\16\2\2\u0129\u012a\7%\2\2\u012a\u012b\7+\2\2\u012b\u012c\7\n\2\2\u012c"+
		"\u012d\7+\2\2\u012d\u012e\7\n\2\2\u012e\u012f\7+\2\2\u012f\u0130\7&\2"+
		"\2\u0130\u0131\7\4\2\2\u0131-\3\2\2\2\31\60\62@BIQS\\^ikwy\u0093\u0097"+
		"\u00ae\u00b1\u00e0\u00ee\u00f8\u0109\u011d\u011f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}