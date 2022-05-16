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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, TRAIN=15, ACTFUNC=16, 
		ARRAY=17, NEURALNETWORK=18, SETUP=19, DATASET=20, ADDDATA=21, READDATA=22, 
		PREDICT=23, READIMAGE=24, MULT=25, DIV=26, ADD=27, SUB=28, OR=29, AND=30, 
		EQ=31, NEQ=32, GT=33, LT=34, GTEQ=35, LTEQ=36, LPAR=37, RPAR=38, BOOL=39, 
		INT=40, DOUBLE=41, ID=42, STRING=43, INT_TYPE=44, COMMENT=45, NEWLINE=46, 
		WS=47;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_if_stat = 2, RULE_condition_block = 3, 
		RULE_stat_block = 4, RULE_while_stat = 5, RULE_neural_network = 6, RULE_setup = 7, 
		RULE_dataset = 8, RULE_add_data = 9, RULE_read_data = 10, RULE_read_image_data = 11, 
		RULE_predict = 12, RULE_train = 13, RULE_epochs = 14, RULE_arraydecl = 15, 
		RULE_array = 16, RULE_value = 17, RULE_expr = 18, RULE_print = 19, RULE_read = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "if_stat", "condition_block", "stat_block", "while_stat", 
			"neural_network", "setup", "dataset", "add_data", "read_data", "read_image_data", 
			"predict", "train", "epochs", "arraydecl", "array", "value", "expr", 
			"print", "read"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'if'", "'else if'", "'else'", "'{'", "'}'", "'while'", 
			"','", "'.'", "'['", "']'", "'Print'", "'read'", "'train'", null, null, 
			"'NeuralNetwork'", null, null, null, null, null, null, "'*'", "'/'", 
			"'+'", "'-'", "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", 
			"'('", "')'", null, null, null, null, null, "'INT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "TRAIN", "ACTFUNC", "ARRAY", "NEURALNETWORK", "SETUP", 
			"DATASET", "ADDDATA", "READDATA", "PREDICT", "READIMAGE", "MULT", "DIV", 
			"ADD", "SUB", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "LPAR", 
			"RPAR", "BOOL", "INT", "DOUBLE", "ID", "STRING", "INT_TYPE", "COMMENT", 
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
		public List<ArraydeclContext> arraydecl() {
			return getRuleContexts(ArraydeclContext.class);
		}
		public ArraydeclContext arraydecl(int i) {
			return getRuleContext(ArraydeclContext.class,i);
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
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(57);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(42);
					decl();
					}
					break;
				case 2:
					{
					setState(43);
					expr(0);
					}
					break;
				case 3:
					{
					setState(44);
					print();
					}
					break;
				case 4:
					{
					setState(45);
					if_stat();
					}
					break;
				case 5:
					{
					setState(46);
					while_stat();
					}
					break;
				case 6:
					{
					setState(47);
					train();
					}
					break;
				case 7:
					{
					setState(48);
					read();
					}
					break;
				case 8:
					{
					setState(49);
					neural_network();
					}
					break;
				case 9:
					{
					setState(50);
					read_image_data();
					}
					break;
				case 10:
					{
					setState(51);
					setup();
					}
					break;
				case 11:
					{
					setState(52);
					dataset();
					}
					break;
				case 12:
					{
					setState(53);
					add_data();
					}
					break;
				case 13:
					{
					setState(54);
					read_data();
					}
					break;
				case 14:
					{
					setState(55);
					predict();
					}
					break;
				case 15:
					{
					setState(56);
					arraydecl();
					}
					break;
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << NEURALNETWORK) | (1L << DATASET) | (1L << LPAR) | (1L << BOOL) | (1L << INT) | (1L << DOUBLE) | (1L << ID) | (1L << STRING))) != 0) );
			setState(61);
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
			setState(63);
			match(ID);
			setState(64);
			match(T__0);
			setState(65);
			expr(0);
			setState(66);
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
		enterRule(_localctx, 4, RULE_if_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__2);
			setState(69);
			condition_block();
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					match(T__3);
					setState(71);
					condition_block();
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(77);
				match(T__4);
				setState(78);
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

	public static class Condition_blockContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
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
		enterRule(_localctx, 6, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(LPAR);
			setState(82);
			expr(0);
			setState(83);
			match(RPAR);
			setState(84);
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
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__5);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << NEURALNETWORK) | (1L << DATASET) | (1L << LPAR) | (1L << BOOL) | (1L << INT) | (1L << DOUBLE) | (1L << ID) | (1L << STRING))) != 0)) {
					{
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(87);
						expr(0);
						}
						break;
					case 2:
						{
						setState(88);
						decl();
						}
						break;
					case 3:
						{
						setState(89);
						print();
						}
						break;
					case 4:
						{
						setState(90);
						if_stat();
						}
						break;
					case 5:
						{
						setState(91);
						while_stat();
						}
						break;
					case 6:
						{
						setState(92);
						train();
						}
						break;
					case 7:
						{
						setState(93);
						read();
						}
						break;
					case 8:
						{
						setState(94);
						neural_network();
						}
						break;
					case 9:
						{
						setState(95);
						read_image_data();
						}
						break;
					case 10:
						{
						setState(96);
						setup();
						}
						break;
					case 11:
						{
						setState(97);
						train();
						}
						break;
					case 12:
						{
						setState(98);
						dataset();
						}
						break;
					case 13:
						{
						setState(99);
						add_data();
						}
						break;
					case 14:
						{
						setState(100);
						read_data();
						}
						break;
					case 15:
						{
						setState(101);
						predict();
						}
						break;
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				match(T__6);
				}
				break;
			case T__2:
			case T__7:
			case T__12:
			case T__13:
			case NEURALNETWORK:
			case DATASET:
			case LPAR:
			case BOOL:
			case INT:
			case DOUBLE:
			case ID:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(108);
					expr(0);
					}
					break;
				case 2:
					{
					setState(109);
					decl();
					}
					break;
				case 3:
					{
					setState(110);
					print();
					}
					break;
				case 4:
					{
					setState(111);
					if_stat();
					}
					break;
				case 5:
					{
					setState(112);
					while_stat();
					}
					break;
				case 6:
					{
					setState(113);
					train();
					}
					break;
				case 7:
					{
					setState(114);
					read();
					}
					break;
				case 8:
					{
					setState(115);
					neural_network();
					}
					break;
				case 9:
					{
					setState(116);
					read_image_data();
					}
					break;
				case 10:
					{
					setState(117);
					setup();
					}
					break;
				case 11:
					{
					setState(118);
					train();
					}
					break;
				case 12:
					{
					setState(119);
					dataset();
					}
					break;
				case 13:
					{
					setState(120);
					add_data();
					}
					break;
				case 14:
					{
					setState(121);
					read_data();
					}
					break;
				case 15:
					{
					setState(122);
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
		enterRule(_localctx, 10, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__7);
			setState(128);
			match(LPAR);
			setState(129);
			expr(0);
			setState(130);
			match(RPAR);
			setState(131);
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
		enterRule(_localctx, 12, RULE_neural_network);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(NEURALNETWORK);
			setState(134);
			match(ID);
			setState(135);
			match(LPAR);
			setState(136);
			expr(0);
			setState(137);
			match(T__8);
			setState(138);
			expr(0);
			setState(139);
			match(T__8);
			setState(140);
			expr(0);
			setState(141);
			match(RPAR);
			setState(142);
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
		public TerminalNode DATASET() { return getToken(ExprParser.DATASET, 0); }
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
		enterRule(_localctx, 14, RULE_setup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(ID);
			setState(145);
			match(T__9);
			setState(146);
			match(SETUP);
			setState(147);
			match(LPAR);
			setState(148);
			match(DATASET);
			setState(149);
			match(ID);
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(150);
				match(T__8);
				setState(151);
				match(ACTFUNC);
				}
				break;
			}
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(154);
				match(T__8);
				setState(155);
				expr(0);
				}
			}

			setState(158);
			match(RPAR);
			setState(159);
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
		enterRule(_localctx, 16, RULE_dataset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(DATASET);
			setState(162);
			match(ID);
			setState(163);
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
		enterRule(_localctx, 18, RULE_add_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(ID);
			setState(166);
			match(T__9);
			setState(167);
			match(ADDDATA);
			setState(168);
			match(LPAR);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(169);
				array();
				setState(170);
				match(T__8);
				setState(171);
				array();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(172);
					match(T__1);
					setState(173);
					array();
					setState(174);
					match(T__8);
					setState(175);
					array();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(184);
			match(RPAR);
			setState(185);
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
		enterRule(_localctx, 20, RULE_read_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(ID);
			setState(188);
			match(T__9);
			setState(189);
			match(READDATA);
			setState(190);
			match(LPAR);
			setState(191);
			match(ID);
			setState(192);
			match(T__8);
			setState(193);
			match(ID);
			setState(194);
			match(T__8);
			setState(195);
			match(STRING);
			setState(196);
			match(T__8);
			setState(197);
			match(STRING);
			setState(198);
			match(RPAR);
			setState(199);
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
		enterRule(_localctx, 22, RULE_read_image_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(ID);
			setState(202);
			match(T__9);
			setState(203);
			match(READIMAGE);
			setState(204);
			match(LPAR);
			setState(205);
			match(ID);
			setState(206);
			match(T__8);
			setState(207);
			match(ID);
			setState(208);
			match(T__8);
			setState(209);
			match(STRING);
			setState(210);
			match(T__8);
			setState(211);
			match(STRING);
			setState(212);
			match(RPAR);
			setState(213);
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
		enterRule(_localctx, 24, RULE_predict);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(ID);
			setState(216);
			match(T__9);
			setState(217);
			match(PREDICT);
			setState(218);
			match(LPAR);
			setState(219);
			match(ID);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(220);
				match(T__8);
				setState(221);
				match(ID);
				}
			}

			setState(224);
			match(RPAR);
			setState(225);
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
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
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
		enterRule(_localctx, 26, RULE_train);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(ID);
			setState(228);
			match(T__9);
			setState(229);
			match(TRAIN);
			setState(230);
			match(LPAR);
			setState(231);
			expr(0);
			setState(232);
			match(RPAR);
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
			setState(234);
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
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(ExprParser.DOUBLE, 0); }
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
		enterRule(_localctx, 30, RULE_arraydecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(ID);
			setState(237);
			match(T__10);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==DOUBLE) {
				{
				setState(238);
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

			setState(241);
			match(T__11);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(242);
				match(T__0);
				setState(243);
				array();
				}
			}

			setState(246);
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
		enterRule(_localctx, 32, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__5);
			setState(249);
			value();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(250);
				match(T__8);
				setState(251);
				value();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257);
			match(T__6);
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
		enterRule(_localctx, 34, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(262);
				match(LPAR);
				setState(263);
				expr(0);
				setState(264);
				match(RPAR);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				match(BOOL);
				}
				break;
			case ID:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				match(ID);
				}
				break;
			case DOUBLE:
				{
				_localctx = new DoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				match(DOUBLE);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269);
				match(INT);
				}
				break;
			case STRING:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(291);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MultiOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(274);
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
						setState(275);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(277);
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
						setState(278);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(280);
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
						setState(281);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(283);
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
						setState(284);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(285);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(286);
						match(AND);
						setState(287);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(289);
						match(OR);
						setState(290);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public TerminalNode LPAR() { return getToken(ExprParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ExprParser.RPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
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
		enterRule(_localctx, 38, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(T__12);
			setState(297);
			match(LPAR);
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(298);
				expr(0);
				}
				break;
			case 2:
				{
				setState(299);
				match(ID);
				}
				break;
			}
			setState(302);
			match(RPAR);
			setState(303);
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
		enterRule(_localctx, 40, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(T__13);
			setState(306);
			match(LPAR);
			setState(307);
			match(STRING);
			setState(308);
			match(T__8);
			setState(309);
			match(STRING);
			setState(310);
			match(T__8);
			setState(311);
			match(STRING);
			setState(312);
			match(RPAR);
			setState(313);
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
		case 18:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u013e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2<\n\2\r\2\16\2=\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\4\3\4\5\4R\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6i\n\6\f\6\16\6l\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6~\n\6\5\6\u0080\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u009b\n\t\3\t\3\t\5\t\u009f\n\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00b4\n\13\f\13\16\13\u00b7\13\13\5\13\u00b9\n\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00e1\n\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\5\21\u00f2\n\21\3\21\3\21\3\21\5\21\u00f7\n"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u00ff\n\22\f\22\16\22\u0102\13"+
		"\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\5\24\u0112\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0126\n\24\f\24\16\24\u0129"+
		"\13\24\3\25\3\25\3\25\3\25\5\25\u012f\n\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\2\3&\27\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*\2\7\3\2*+\3\2\33\34\3\2\35\36\3\2#&\3\2!"+
		"\"\2\u016b\2;\3\2\2\2\4A\3\2\2\2\6F\3\2\2\2\bS\3\2\2\2\n\177\3\2\2\2\f"+
		"\u0081\3\2\2\2\16\u0087\3\2\2\2\20\u0092\3\2\2\2\22\u00a3\3\2\2\2\24\u00a7"+
		"\3\2\2\2\26\u00bd\3\2\2\2\30\u00cb\3\2\2\2\32\u00d9\3\2\2\2\34\u00e5\3"+
		"\2\2\2\36\u00ec\3\2\2\2 \u00ee\3\2\2\2\"\u00fa\3\2\2\2$\u0105\3\2\2\2"+
		"&\u0111\3\2\2\2(\u012a\3\2\2\2*\u0133\3\2\2\2,<\5\4\3\2-<\5&\24\2.<\5"+
		"(\25\2/<\5\6\4\2\60<\5\f\7\2\61<\5\34\17\2\62<\5*\26\2\63<\5\16\b\2\64"+
		"<\5\30\r\2\65<\5\20\t\2\66<\5\22\n\2\67<\5\24\13\28<\5\26\f\29<\5\32\16"+
		"\2:<\5 \21\2;,\3\2\2\2;-\3\2\2\2;.\3\2\2\2;/\3\2\2\2;\60\3\2\2\2;\61\3"+
		"\2\2\2;\62\3\2\2\2;\63\3\2\2\2;\64\3\2\2\2;\65\3\2\2\2;\66\3\2\2\2;\67"+
		"\3\2\2\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>"+
		"?\3\2\2\2?@\7\2\2\3@\3\3\2\2\2AB\7,\2\2BC\7\3\2\2CD\5&\24\2DE\7\4\2\2"+
		"E\5\3\2\2\2FG\7\5\2\2GL\5\b\5\2HI\7\6\2\2IK\5\b\5\2JH\3\2\2\2KN\3\2\2"+
		"\2LJ\3\2\2\2LM\3\2\2\2MQ\3\2\2\2NL\3\2\2\2OP\7\7\2\2PR\5\n\6\2QO\3\2\2"+
		"\2QR\3\2\2\2R\7\3\2\2\2ST\7\'\2\2TU\5&\24\2UV\7(\2\2VW\5\n\6\2W\t\3\2"+
		"\2\2Xj\7\b\2\2Yi\5&\24\2Zi\5\4\3\2[i\5(\25\2\\i\5\6\4\2]i\5\f\7\2^i\5"+
		"\34\17\2_i\5*\26\2`i\5\16\b\2ai\5\30\r\2bi\5\20\t\2ci\5\34\17\2di\5\22"+
		"\n\2ei\5\24\13\2fi\5\26\f\2gi\5\32\16\2hY\3\2\2\2hZ\3\2\2\2h[\3\2\2\2"+
		"h\\\3\2\2\2h]\3\2\2\2h^\3\2\2\2h_\3\2\2\2h`\3\2\2\2ha\3\2\2\2hb\3\2\2"+
		"\2hc\3\2\2\2hd\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2"+
		"\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2m\u0080\7\t\2\2n~\5&\24\2o~\5\4\3\2p~"+
		"\5(\25\2q~\5\6\4\2r~\5\f\7\2s~\5\34\17\2t~\5*\26\2u~\5\16\b\2v~\5\30\r"+
		"\2w~\5\20\t\2x~\5\34\17\2y~\5\22\n\2z~\5\24\13\2{~\5\26\f\2|~\5\32\16"+
		"\2}n\3\2\2\2}o\3\2\2\2}p\3\2\2\2}q\3\2\2\2}r\3\2\2\2}s\3\2\2\2}t\3\2\2"+
		"\2}u\3\2\2\2}v\3\2\2\2}w\3\2\2\2}x\3\2\2\2}y\3\2\2\2}z\3\2\2\2}{\3\2\2"+
		"\2}|\3\2\2\2~\u0080\3\2\2\2\177X\3\2\2\2\177}\3\2\2\2\u0080\13\3\2\2\2"+
		"\u0081\u0082\7\n\2\2\u0082\u0083\7\'\2\2\u0083\u0084\5&\24\2\u0084\u0085"+
		"\7(\2\2\u0085\u0086\5\n\6\2\u0086\r\3\2\2\2\u0087\u0088\7\24\2\2\u0088"+
		"\u0089\7,\2\2\u0089\u008a\7\'\2\2\u008a\u008b\5&\24\2\u008b\u008c\7\13"+
		"\2\2\u008c\u008d\5&\24\2\u008d\u008e\7\13\2\2\u008e\u008f\5&\24\2\u008f"+
		"\u0090\7(\2\2\u0090\u0091\7\4\2\2\u0091\17\3\2\2\2\u0092\u0093\7,\2\2"+
		"\u0093\u0094\7\f\2\2\u0094\u0095\7\25\2\2\u0095\u0096\7\'\2\2\u0096\u0097"+
		"\7\26\2\2\u0097\u009a\7,\2\2\u0098\u0099\7\13\2\2\u0099\u009b\7\22\2\2"+
		"\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009d"+
		"\7\13\2\2\u009d\u009f\5&\24\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u00a1\7(\2\2\u00a1\u00a2\7\4\2\2\u00a2\21\3"+
		"\2\2\2\u00a3\u00a4\7\26\2\2\u00a4\u00a5\7,\2\2\u00a5\u00a6\7\4\2\2\u00a6"+
		"\23\3\2\2\2\u00a7\u00a8\7,\2\2\u00a8\u00a9\7\f\2\2\u00a9\u00aa\7\27\2"+
		"\2\u00aa\u00b8\7\'\2\2\u00ab\u00ac\5\"\22\2\u00ac\u00ad\7\13\2\2\u00ad"+
		"\u00b5\5\"\22\2\u00ae\u00af\7\4\2\2\u00af\u00b0\5\"\22\2\u00b0\u00b1\7"+
		"\13\2\2\u00b1\u00b2\5\"\22\2\u00b2\u00b4\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ab\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\7(\2\2\u00bb\u00bc\7\4\2\2\u00bc\25\3\2\2\2"+
		"\u00bd\u00be\7,\2\2\u00be\u00bf\7\f\2\2\u00bf\u00c0\7\30\2\2\u00c0\u00c1"+
		"\7\'\2\2\u00c1\u00c2\7,\2\2\u00c2\u00c3\7\13\2\2\u00c3\u00c4\7,\2\2\u00c4"+
		"\u00c5\7\13\2\2\u00c5\u00c6\7-\2\2\u00c6\u00c7\7\13\2\2\u00c7\u00c8\7"+
		"-\2\2\u00c8\u00c9\7(\2\2\u00c9\u00ca\7\4\2\2\u00ca\27\3\2\2\2\u00cb\u00cc"+
		"\7,\2\2\u00cc\u00cd\7\f\2\2\u00cd\u00ce\7\32\2\2\u00ce\u00cf\7\'\2\2\u00cf"+
		"\u00d0\7,\2\2\u00d0\u00d1\7\13\2\2\u00d1\u00d2\7,\2\2\u00d2\u00d3\7\13"+
		"\2\2\u00d3\u00d4\7-\2\2\u00d4\u00d5\7\13\2\2\u00d5\u00d6\7-\2\2\u00d6"+
		"\u00d7\7(\2\2\u00d7\u00d8\7\4\2\2\u00d8\31\3\2\2\2\u00d9\u00da\7,\2\2"+
		"\u00da\u00db\7\f\2\2\u00db\u00dc\7\31\2\2\u00dc\u00dd\7\'\2\2\u00dd\u00e0"+
		"\7,\2\2\u00de\u00df\7\13\2\2\u00df\u00e1\7,\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7(\2\2\u00e3\u00e4\7\4"+
		"\2\2\u00e4\33\3\2\2\2\u00e5\u00e6\7,\2\2\u00e6\u00e7\7\f\2\2\u00e7\u00e8"+
		"\7\21\2\2\u00e8\u00e9\7\'\2\2\u00e9\u00ea\5&\24\2\u00ea\u00eb\7(\2\2\u00eb"+
		"\35\3\2\2\2\u00ec\u00ed\7*\2\2\u00ed\37\3\2\2\2\u00ee\u00ef\7,\2\2\u00ef"+
		"\u00f1\7\r\2\2\u00f0\u00f2\t\2\2\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f6\7\16\2\2\u00f4\u00f5\7\3\2\2\u00f5"+
		"\u00f7\5\"\22\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3"+
		"\2\2\2\u00f8\u00f9\7\4\2\2\u00f9!\3\2\2\2\u00fa\u00fb\7\b\2\2\u00fb\u0100"+
		"\5$\23\2\u00fc\u00fd\7\13\2\2\u00fd\u00ff\5$\23\2\u00fe\u00fc\3\2\2\2"+
		"\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\7\t\2\2\u0104#\3\2\2\2\u0105"+
		"\u0106\t\2\2\2\u0106%\3\2\2\2\u0107\u0108\b\24\1\2\u0108\u0109\7\'\2\2"+
		"\u0109\u010a\5&\24\2\u010a\u010b\7(\2\2\u010b\u0112\3\2\2\2\u010c\u0112"+
		"\7)\2\2\u010d\u0112\7,\2\2\u010e\u0112\7+\2\2\u010f\u0112\7*\2\2\u0110"+
		"\u0112\7-\2\2\u0111\u0107\3\2\2\2\u0111\u010c\3\2\2\2\u0111\u010d\3\2"+
		"\2\2\u0111\u010e\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112"+
		"\u0127\3\2\2\2\u0113\u0114\f\16\2\2\u0114\u0115\t\3\2\2\u0115\u0126\5"+
		"&\24\17\u0116\u0117\f\r\2\2\u0117\u0118\t\4\2\2\u0118\u0126\5&\24\16\u0119"+
		"\u011a\f\f\2\2\u011a\u011b\t\5\2\2\u011b\u0126\5&\24\r\u011c\u011d\f\13"+
		"\2\2\u011d\u011e\t\6\2\2\u011e\u0126\5&\24\f\u011f\u0120\f\n\2\2\u0120"+
		"\u0121\7 \2\2\u0121\u0126\5&\24\13\u0122\u0123\f\t\2\2\u0123\u0124\7\37"+
		"\2\2\u0124\u0126\5&\24\n\u0125\u0113\3\2\2\2\u0125\u0116\3\2\2\2\u0125"+
		"\u0119\3\2\2\2\u0125\u011c\3\2\2\2\u0125\u011f\3\2\2\2\u0125\u0122\3\2"+
		"\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\'\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\7\17\2\2\u012b\u012e\7\'\2"+
		"\2\u012c\u012f\5&\24\2\u012d\u012f\7,\2\2\u012e\u012c\3\2\2\2\u012e\u012d"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\7(\2\2\u0131\u0132\7\4\2\2\u0132"+
		")\3\2\2\2\u0133\u0134\7\20\2\2\u0134\u0135\7\'\2\2\u0135\u0136\7-\2\2"+
		"\u0136\u0137\7\13\2\2\u0137\u0138\7-\2\2\u0138\u0139\7\13\2\2\u0139\u013a"+
		"\7-\2\2\u013a\u013b\7(\2\2\u013b\u013c\7\4\2\2\u013c+\3\2\2\2\26;=LQh"+
		"j}\177\u009a\u009e\u00b5\u00b8\u00e0\u00f1\u00f6\u0100\u0111\u0125\u0127"+
		"\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}