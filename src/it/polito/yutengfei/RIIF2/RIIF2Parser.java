// Generated from /usr/Intellij/ANtlr4WorkSpace/RIIF2_v6/RIIF2.g4 by ANTLR 4.5.3
package it.polito.yutengfei.RIIF2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RIIF2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, COMPONENT=36, END_COMPONENT=37, 
		ENVIRONMENT=38, END_ENVIRONMENT=39, REQUIREMENT=40, END_REQUIREMENT=41, 
		CHILD_COMPONENT=42, FAIL_MODE=43, EXTENDS=44, ASSIGN=45, ASSERT=46, INPUT=47, 
		OUTPUT=48, PARAMETER=49, CONSTANT=50, TYPE_FLOAT=51, TYPE_INTEGER=52, 
		TYPE_STRING=53, TYPE_ENUM=54, TYPE_BOOLEAN=55, TYPE_TIME=56, FUNC_AGG_SINGLE=57, 
		FUNC_GT_N_FAIL=58, FUNC_LOG=59, FUNC_EXP=60, NULL=61, TEMPLATE=62, END_TEMPLATE=63, 
		IMPOSE=64, ABSTRACT=65, IMPLEMENTS=66, SELF=67, SET=68, TYPE_TABLE=69, 
		PLATFORM=70, TRUE=71, FALSE=72, BIND=73, Identifier=74, StringLiteral=75, 
		FloatingPointLiteral=76, DecimalLiteral=77, WS=78, COMMENT=79, LINE_COMMENT=80;
	public static final int
		RULE_program = 0, RULE_typeDeclaration = 1, RULE_componentDeclaration = 2, 
		RULE_componentBodyElement = 3, RULE_fieldDeclaration = 4, RULE_fieldDeclaratorType = 5, 
		RULE_childComponentDeclaration = 6, RULE_failModeDeclaration = 7, RULE_assignmentDeclaration = 8, 
		RULE_setDeclaration = 9, RULE_aisDeclaration = 10, RULE_templateDeclaration = 11, 
		RULE_templateBodyElement = 12, RULE_abstractFieldDeclaration = 13, RULE_abstractFailModeDeclaration = 14, 
		RULE_abstractChildComponentDeclaration = 15, RULE_abstractPlatformDeclaration = 16, 
		RULE_imposeDeclaration = 17, RULE_environmentDeclaration = 18, RULE_environmentBodyElement = 19, 
		RULE_assignment = 20, RULE_envParameterDeclaration = 21, RULE_requirementDeclaration = 22, 
		RULE_assertion = 23, RULE_bindDeclaration = 24, RULE_bindDeclarator = 25, 
		RULE_bindDeclaratorId = 26, RULE_bindContract = 27, RULE_primitiveFieldDeclarator = 28, 
		RULE_associativeIndexDeclarator = 29, RULE_tableFieldDeclarator = 30, 
		RULE_listFieldDeclarator = 31, RULE_childComponentDeclarator = 32, RULE_failModeDeclarator = 33, 
		RULE_aisDeclarator = 34, RULE_assertionDeclarator = 35, RULE_fieldInitializer = 36, 
		RULE_arrayInitializerWrapper = 37, RULE_arrayInitializer = 38, RULE_arrayItem = 39, 
		RULE_listInitializer = 40, RULE_listItem = 41, RULE_tableItemInitializer = 42, 
		RULE_row = 43, RULE_rowItem = 44, RULE_aisInitializer = 45, RULE_primitiveFieldDeclaratorId = 46, 
		RULE_associativeIndexDeclaratorId = 47, RULE_tableFieldDeclaratorId = 48, 
		RULE_listFieldDeclaratorId = 49, RULE_childComponentDeclaratorId = 50, 
		RULE_failModeDeclaratorId = 51, RULE_aisDeclaratorId = 52, RULE_primitiveId = 53, 
		RULE_associativeId = 54, RULE_attributeId = 55, RULE_variableId = 56, 
		RULE_attributeIndex = 57, RULE_associativeIndex = 58, RULE_tableIndex = 59, 
		RULE_hierPostfix = 60, RULE_tableId = 61, RULE_extendsList = 62, RULE_implementsList = 63, 
		RULE_primitiveType = 64, RULE_typeType = 65, RULE_aisType = 66, RULE_associativeType = 67, 
		RULE_vector = 68, RULE_flatVector = 69, RULE_inputOutput = 70, RULE_fieldType = 71, 
		RULE_enumType = 72, RULE_childComponentType = 73, RULE_expression = 74, 
		RULE_primary = 75, RULE_funcCall = 76, RULE_funcName = 77, RULE_funcArg = 78, 
		RULE_literal = 79;
	public static final String[] ruleNames = {
		"program", "typeDeclaration", "componentDeclaration", "componentBodyElement", 
		"fieldDeclaration", "fieldDeclaratorType", "childComponentDeclaration", 
		"failModeDeclaration", "assignmentDeclaration", "setDeclaration", "aisDeclaration", 
		"templateDeclaration", "templateBodyElement", "abstractFieldDeclaration", 
		"abstractFailModeDeclaration", "abstractChildComponentDeclaration", "abstractPlatformDeclaration", 
		"imposeDeclaration", "environmentDeclaration", "environmentBodyElement", 
		"assignment", "envParameterDeclaration", "requirementDeclaration", "assertion", 
		"bindDeclaration", "bindDeclarator", "bindDeclaratorId", "bindContract", 
		"primitiveFieldDeclarator", "associativeIndexDeclarator", "tableFieldDeclarator", 
		"listFieldDeclarator", "childComponentDeclarator", "failModeDeclarator", 
		"aisDeclarator", "assertionDeclarator", "fieldInitializer", "arrayInitializerWrapper", 
		"arrayInitializer", "arrayItem", "listInitializer", "listItem", "tableItemInitializer", 
		"row", "rowItem", "aisInitializer", "primitiveFieldDeclaratorId", "associativeIndexDeclaratorId", 
		"tableFieldDeclaratorId", "listFieldDeclaratorId", "childComponentDeclaratorId", 
		"failModeDeclaratorId", "aisDeclaratorId", "primitiveId", "associativeId", 
		"attributeId", "variableId", "attributeIndex", "associativeIndex", "tableIndex", 
		"hierPostfix", "tableId", "extendsList", "implementsList", "primitiveType", 
		"typeType", "aisType", "associativeType", "vector", "flatVector", "inputOutput", 
		"fieldType", "enumType", "childComponentType", "expression", "primary", 
		"funcCall", "funcName", "funcArg", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "':'", "'=>'", "':='", "'='", "'<'", "'>'", 
		"'{'", "','", "'}'", "'['", "']'", "'''", "'#'", "'.'", "'..'", "'+'", 
		"'-'", "'~'", "'!'", "'*'", "'/'", "'%'", "'<='", "'>='", "'=='", "'!='", 
		"'&'", "'^'", "'|'", "'&&'", "'||'", "'?'", "'component'", "'endcomponent'", 
		"'environment'", "'endenvironment'", "'requirement'", "'endrequirement'", 
		"'child_component'", "'fail_mode'", "'extends'", "'assign'", "'assert'", 
		"'input'", "'output'", "'parameter'", "'constant'", "'float'", "'integer'", 
		"'string'", "'enum'", "'boolean'", "'time'", "'agg_single_fail'", "'agg_gt_n_fail'", 
		"'LOG'", "'EXP'", "'null'", "'template'", "'endtemplate'", "'impose'", 
		"'abstract'", "'implements'", "'self'", "'set'", "'table'", "'platform'", 
		"'true'", "'false'", "'bind'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"COMPONENT", "END_COMPONENT", "ENVIRONMENT", "END_ENVIRONMENT", "REQUIREMENT", 
		"END_REQUIREMENT", "CHILD_COMPONENT", "FAIL_MODE", "EXTENDS", "ASSIGN", 
		"ASSERT", "INPUT", "OUTPUT", "PARAMETER", "CONSTANT", "TYPE_FLOAT", "TYPE_INTEGER", 
		"TYPE_STRING", "TYPE_ENUM", "TYPE_BOOLEAN", "TYPE_TIME", "FUNC_AGG_SINGLE", 
		"FUNC_GT_N_FAIL", "FUNC_LOG", "FUNC_EXP", "NULL", "TEMPLATE", "END_TEMPLATE", 
		"IMPOSE", "ABSTRACT", "IMPLEMENTS", "SELF", "SET", "TYPE_TABLE", "PLATFORM", 
		"TRUE", "FALSE", "BIND", "Identifier", "StringLiteral", "FloatingPointLiteral", 
		"DecimalLiteral", "WS", "COMMENT", "LINE_COMMENT"
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

	@Override
	public String getGrammarFileName() { return "RIIF2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RIIF2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RIIF2Parser.EOF, 0); }
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				typeDeclaration();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (COMPONENT - 36)) | (1L << (ENVIRONMENT - 36)) | (1L << (REQUIREMENT - 36)) | (1L << (TEMPLATE - 36)) | (1L << (BIND - 36)))) != 0) );
			setState(165);
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

	public static class TypeDeclarationContext extends ParserRuleContext {
		public ComponentDeclarationContext componentDeclaration() {
			return getRuleContext(ComponentDeclarationContext.class,0);
		}
		public TemplateDeclarationContext templateDeclaration() {
			return getRuleContext(TemplateDeclarationContext.class,0);
		}
		public EnvironmentDeclarationContext environmentDeclaration() {
			return getRuleContext(EnvironmentDeclarationContext.class,0);
		}
		public RequirementDeclarationContext requirementDeclaration() {
			return getRuleContext(RequirementDeclarationContext.class,0);
		}
		public BindDeclarationContext bindDeclaration() {
			return getRuleContext(BindDeclarationContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typeDeclaration);
		try {
			setState(172);
			switch (_input.LA(1)) {
			case COMPONENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				componentDeclaration();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				templateDeclaration();
				}
				break;
			case ENVIRONMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				environmentDeclaration();
				}
				break;
			case REQUIREMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				requirementDeclaration();
				}
				break;
			case BIND:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				bindDeclaration();
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

	public static class ComponentDeclarationContext extends ParserRuleContext {
		public TerminalNode COMPONENT() { return getToken(RIIF2Parser.COMPONENT, 0); }
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public TerminalNode END_COMPONENT() { return getToken(RIIF2Parser.END_COMPONENT, 0); }
		public ExtendsListContext extendsList() {
			return getRuleContext(ExtendsListContext.class,0);
		}
		public ImplementsListContext implementsList() {
			return getRuleContext(ImplementsListContext.class,0);
		}
		public List<ComponentBodyElementContext> componentBodyElement() {
			return getRuleContexts(ComponentBodyElementContext.class);
		}
		public ComponentBodyElementContext componentBodyElement(int i) {
			return getRuleContext(ComponentBodyElementContext.class,i);
		}
		public ComponentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterComponentDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitComponentDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitComponentDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentDeclarationContext componentDeclaration() throws RecognitionException {
		ComponentDeclarationContext _localctx = new ComponentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_componentDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(COMPONENT);
			setState(175);
			match(Identifier);
			setState(177);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(176);
				extendsList();
				}
			}

			setState(180);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(179);
				implementsList();
				}
			}

			setState(182);
			match(T__0);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (CHILD_COMPONENT - 42)) | (1L << (FAIL_MODE - 42)) | (1L << (ASSIGN - 42)) | (1L << (PARAMETER - 42)) | (1L << (CONSTANT - 42)) | (1L << (SET - 42)))) != 0)) {
				{
				{
				setState(183);
				componentBodyElement();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(189);
			match(END_COMPONENT);
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

	public static class ComponentBodyElementContext extends ParserRuleContext {
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ChildComponentDeclarationContext childComponentDeclaration() {
			return getRuleContext(ChildComponentDeclarationContext.class,0);
		}
		public FailModeDeclarationContext failModeDeclaration() {
			return getRuleContext(FailModeDeclarationContext.class,0);
		}
		public AssignmentDeclarationContext assignmentDeclaration() {
			return getRuleContext(AssignmentDeclarationContext.class,0);
		}
		public SetDeclarationContext setDeclaration() {
			return getRuleContext(SetDeclarationContext.class,0);
		}
		public ComponentBodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentBodyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterComponentBodyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitComponentBodyElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitComponentBodyElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentBodyElementContext componentBodyElement() throws RecognitionException {
		ComponentBodyElementContext _localctx = new ComponentBodyElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_componentBodyElement);
		try {
			setState(196);
			switch (_input.LA(1)) {
			case PARAMETER:
			case CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				fieldDeclaration();
				}
				break;
			case CHILD_COMPONENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				childComponentDeclaration();
				}
				break;
			case FAIL_MODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				failModeDeclaration();
				}
				break;
			case ASSIGN:
				enterOuterAlt(_localctx, 4);
				{
				setState(194);
				assignmentDeclaration();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 5);
				{
				setState(195);
				setDeclaration();
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public FieldDeclaratorTypeContext fieldDeclaratorType() {
			return getRuleContext(FieldDeclaratorTypeContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			fieldType();
			setState(199);
			fieldDeclaratorType();
			setState(200);
			match(T__0);
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

	public static class FieldDeclaratorTypeContext extends ParserRuleContext {
		public PrimitiveFieldDeclaratorContext primitiveFieldDeclarator() {
			return getRuleContext(PrimitiveFieldDeclaratorContext.class,0);
		}
		public AssociativeIndexDeclaratorContext associativeIndexDeclarator() {
			return getRuleContext(AssociativeIndexDeclaratorContext.class,0);
		}
		public TableFieldDeclaratorContext tableFieldDeclarator() {
			return getRuleContext(TableFieldDeclaratorContext.class,0);
		}
		public ListFieldDeclaratorContext listFieldDeclarator() {
			return getRuleContext(ListFieldDeclaratorContext.class,0);
		}
		public FieldDeclaratorTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaratorType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFieldDeclaratorType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFieldDeclaratorType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFieldDeclaratorType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclaratorTypeContext fieldDeclaratorType() throws RecognitionException {
		FieldDeclaratorTypeContext _localctx = new FieldDeclaratorTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldDeclaratorType);
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				primitiveFieldDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				associativeIndexDeclarator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				tableFieldDeclarator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(205);
				listFieldDeclarator();
				}
				break;
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

	public static class ChildComponentDeclarationContext extends ParserRuleContext {
		public TerminalNode CHILD_COMPONENT() { return getToken(RIIF2Parser.CHILD_COMPONENT, 0); }
		public ChildComponentDeclaratorContext childComponentDeclarator() {
			return getRuleContext(ChildComponentDeclaratorContext.class,0);
		}
		public ChildComponentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_childComponentDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterChildComponentDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitChildComponentDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitChildComponentDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChildComponentDeclarationContext childComponentDeclaration() throws RecognitionException {
		ChildComponentDeclarationContext _localctx = new ChildComponentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_childComponentDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(CHILD_COMPONENT);
			setState(209);
			childComponentDeclarator();
			setState(210);
			match(T__0);
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

	public static class FailModeDeclarationContext extends ParserRuleContext {
		public TerminalNode FAIL_MODE() { return getToken(RIIF2Parser.FAIL_MODE, 0); }
		public FailModeDeclaratorContext failModeDeclarator() {
			return getRuleContext(FailModeDeclaratorContext.class,0);
		}
		public FailModeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_failModeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFailModeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFailModeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFailModeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FailModeDeclarationContext failModeDeclaration() throws RecognitionException {
		FailModeDeclarationContext _localctx = new FailModeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_failModeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(FAIL_MODE);
			setState(213);
			failModeDeclarator();
			setState(214);
			match(T__0);
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

	public static class AssignmentDeclarationContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(RIIF2Parser.ASSIGN, 0); }
		public AisDeclaratorContext aisDeclarator() {
			return getRuleContext(AisDeclaratorContext.class,0);
		}
		public AssignmentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssignmentDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssignmentDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssignmentDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentDeclarationContext assignmentDeclaration() throws RecognitionException {
		AssignmentDeclarationContext _localctx = new AssignmentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignmentDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(ASSIGN);
			setState(217);
			aisDeclarator();
			setState(218);
			match(T__0);
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

	public static class SetDeclarationContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(RIIF2Parser.SET, 0); }
		public AisDeclaratorContext aisDeclarator() {
			return getRuleContext(AisDeclaratorContext.class,0);
		}
		public SetDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterSetDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitSetDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitSetDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetDeclarationContext setDeclaration() throws RecognitionException {
		SetDeclarationContext _localctx = new SetDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_setDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(SET);
			setState(221);
			aisDeclarator();
			setState(222);
			match(T__0);
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

	public static class AisDeclarationContext extends ParserRuleContext {
		public AisDeclaratorContext aisDeclarator() {
			return getRuleContext(AisDeclaratorContext.class,0);
		}
		public TerminalNode IMPOSE() { return getToken(RIIF2Parser.IMPOSE, 0); }
		public TerminalNode ASSIGN() { return getToken(RIIF2Parser.ASSIGN, 0); }
		public TerminalNode SET() { return getToken(RIIF2Parser.SET, 0); }
		public AisDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aisDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAisDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAisDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAisDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AisDeclarationContext aisDeclaration() throws RecognitionException {
		AisDeclarationContext _localctx = new AisDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_aisDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_la = _input.LA(1);
			if ( !(((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (ASSIGN - 45)) | (1L << (IMPOSE - 45)) | (1L << (SET - 45)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(225);
			aisDeclarator();
			setState(226);
			match(T__0);
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

	public static class TemplateDeclarationContext extends ParserRuleContext {
		public TerminalNode TEMPLATE() { return getToken(RIIF2Parser.TEMPLATE, 0); }
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public TerminalNode END_TEMPLATE() { return getToken(RIIF2Parser.END_TEMPLATE, 0); }
		public ExtendsListContext extendsList() {
			return getRuleContext(ExtendsListContext.class,0);
		}
		public List<TemplateBodyElementContext> templateBodyElement() {
			return getRuleContexts(TemplateBodyElementContext.class);
		}
		public TemplateBodyElementContext templateBodyElement(int i) {
			return getRuleContext(TemplateBodyElementContext.class,i);
		}
		public TemplateDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTemplateDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTemplateDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTemplateDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateDeclarationContext templateDeclaration() throws RecognitionException {
		TemplateDeclarationContext _localctx = new TemplateDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_templateDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(TEMPLATE);
			setState(229);
			match(Identifier);
			setState(231);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(230);
				extendsList();
				}
			}

			setState(233);
			match(T__0);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPOSE || _la==ABSTRACT) {
				{
				{
				setState(234);
				templateBodyElement();
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(240);
			match(END_TEMPLATE);
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

	public static class TemplateBodyElementContext extends ParserRuleContext {
		public AbstractFieldDeclarationContext abstractFieldDeclaration() {
			return getRuleContext(AbstractFieldDeclarationContext.class,0);
		}
		public AbstractFailModeDeclarationContext abstractFailModeDeclaration() {
			return getRuleContext(AbstractFailModeDeclarationContext.class,0);
		}
		public AbstractChildComponentDeclarationContext abstractChildComponentDeclaration() {
			return getRuleContext(AbstractChildComponentDeclarationContext.class,0);
		}
		public AbstractPlatformDeclarationContext abstractPlatformDeclaration() {
			return getRuleContext(AbstractPlatformDeclarationContext.class,0);
		}
		public ImposeDeclarationContext imposeDeclaration() {
			return getRuleContext(ImposeDeclarationContext.class,0);
		}
		public TemplateBodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateBodyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTemplateBodyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTemplateBodyElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTemplateBodyElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateBodyElementContext templateBodyElement() throws RecognitionException {
		TemplateBodyElementContext _localctx = new TemplateBodyElementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_templateBodyElement);
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				abstractFieldDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				abstractFailModeDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				abstractChildComponentDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(245);
				abstractPlatformDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(246);
				imposeDeclaration();
				}
				break;
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

	public static class AbstractFieldDeclarationContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(RIIF2Parser.ABSTRACT, 0); }
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public AbstractFieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractFieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAbstractFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAbstractFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAbstractFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractFieldDeclarationContext abstractFieldDeclaration() throws RecognitionException {
		AbstractFieldDeclarationContext _localctx = new AbstractFieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_abstractFieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(ABSTRACT);
			setState(250);
			fieldDeclaration();
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

	public static class AbstractFailModeDeclarationContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(RIIF2Parser.ABSTRACT, 0); }
		public FailModeDeclarationContext failModeDeclaration() {
			return getRuleContext(FailModeDeclarationContext.class,0);
		}
		public AbstractFailModeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractFailModeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAbstractFailModeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAbstractFailModeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAbstractFailModeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractFailModeDeclarationContext abstractFailModeDeclaration() throws RecognitionException {
		AbstractFailModeDeclarationContext _localctx = new AbstractFailModeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_abstractFailModeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(ABSTRACT);
			setState(253);
			failModeDeclaration();
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

	public static class AbstractChildComponentDeclarationContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(RIIF2Parser.ABSTRACT, 0); }
		public ChildComponentDeclarationContext childComponentDeclaration() {
			return getRuleContext(ChildComponentDeclarationContext.class,0);
		}
		public AbstractChildComponentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractChildComponentDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAbstractChildComponentDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAbstractChildComponentDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAbstractChildComponentDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractChildComponentDeclarationContext abstractChildComponentDeclaration() throws RecognitionException {
		AbstractChildComponentDeclarationContext _localctx = new AbstractChildComponentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_abstractChildComponentDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(ABSTRACT);
			setState(256);
			childComponentDeclaration();
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

	public static class AbstractPlatformDeclarationContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(RIIF2Parser.ABSTRACT, 0); }
		public TerminalNode PLATFORM() { return getToken(RIIF2Parser.PLATFORM, 0); }
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public AbstractPlatformDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractPlatformDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAbstractPlatformDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAbstractPlatformDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAbstractPlatformDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractPlatformDeclarationContext abstractPlatformDeclaration() throws RecognitionException {
		AbstractPlatformDeclarationContext _localctx = new AbstractPlatformDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_abstractPlatformDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(ABSTRACT);
			setState(259);
			match(PLATFORM);
			setState(260);
			match(Identifier);
			setState(261);
			match(T__0);
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

	public static class ImposeDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPOSE() { return getToken(RIIF2Parser.IMPOSE, 0); }
		public AisDeclaratorContext aisDeclarator() {
			return getRuleContext(AisDeclaratorContext.class,0);
		}
		public ImposeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imposeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterImposeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitImposeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitImposeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImposeDeclarationContext imposeDeclaration() throws RecognitionException {
		ImposeDeclarationContext _localctx = new ImposeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_imposeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(IMPOSE);
			setState(264);
			aisDeclarator();
			setState(265);
			match(T__0);
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

	public static class EnvironmentDeclarationContext extends ParserRuleContext {
		public TerminalNode ENVIRONMENT() { return getToken(RIIF2Parser.ENVIRONMENT, 0); }
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public TerminalNode END_ENVIRONMENT() { return getToken(RIIF2Parser.END_ENVIRONMENT, 0); }
		public List<EnvironmentBodyElementContext> environmentBodyElement() {
			return getRuleContexts(EnvironmentBodyElementContext.class);
		}
		public EnvironmentBodyElementContext environmentBodyElement(int i) {
			return getRuleContext(EnvironmentBodyElementContext.class,i);
		}
		public EnvironmentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environmentDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterEnvironmentDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitEnvironmentDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitEnvironmentDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentDeclarationContext environmentDeclaration() throws RecognitionException {
		EnvironmentDeclarationContext _localctx = new EnvironmentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_environmentDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(ENVIRONMENT);
			setState(268);
			match(Identifier);
			setState(269);
			match(T__0);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << INPUT) | (1L << OUTPUT))) != 0)) {
				{
				{
				setState(270);
				environmentBodyElement();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			match(END_ENVIRONMENT);
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

	public static class EnvironmentBodyElementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public EnvParameterDeclarationContext envParameterDeclaration() {
			return getRuleContext(EnvParameterDeclarationContext.class,0);
		}
		public EnvironmentBodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environmentBodyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterEnvironmentBodyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitEnvironmentBodyElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitEnvironmentBodyElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentBodyElementContext environmentBodyElement() throws RecognitionException {
		EnvironmentBodyElementContext _localctx = new EnvironmentBodyElementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_environmentBodyElement);
		try {
			setState(280);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				assignment();
				}
				break;
			case INPUT:
			case OUTPUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				envParameterDeclaration();
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(RIIF2Parser.ASSIGN, 0); }
		public AisDeclaratorContext aisDeclarator() {
			return getRuleContext(AisDeclaratorContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(ASSIGN);
			setState(283);
			aisDeclarator();
			setState(284);
			match(T__0);
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

	public static class EnvParameterDeclarationContext extends ParserRuleContext {
		public InputOutputContext inputOutput() {
			return getRuleContext(InputOutputContext.class,0);
		}
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public PrimitiveFieldDeclaratorContext primitiveFieldDeclarator() {
			return getRuleContext(PrimitiveFieldDeclaratorContext.class,0);
		}
		public EnvParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_envParameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterEnvParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitEnvParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitEnvParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvParameterDeclarationContext envParameterDeclaration() throws RecognitionException {
		EnvParameterDeclarationContext _localctx = new EnvParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_envParameterDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			inputOutput();
			setState(287);
			fieldType();
			setState(288);
			primitiveFieldDeclarator();
			setState(289);
			match(T__0);
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

	public static class RequirementDeclarationContext extends ParserRuleContext {
		public TerminalNode REQUIREMENT() { return getToken(RIIF2Parser.REQUIREMENT, 0); }
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public TerminalNode END_REQUIREMENT() { return getToken(RIIF2Parser.END_REQUIREMENT, 0); }
		public List<AssertionContext> assertion() {
			return getRuleContexts(AssertionContext.class);
		}
		public AssertionContext assertion(int i) {
			return getRuleContext(AssertionContext.class,i);
		}
		public RequirementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterRequirementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitRequirementDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitRequirementDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementDeclarationContext requirementDeclaration() throws RecognitionException {
		RequirementDeclarationContext _localctx = new RequirementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_requirementDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(REQUIREMENT);
			setState(292);
			match(Identifier);
			setState(293);
			match(T__0);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ASSERT) {
				{
				{
				setState(294);
				assertion();
				}
				}
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
			match(END_REQUIREMENT);
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

	public static class AssertionContext extends ParserRuleContext {
		public AssertionDeclaratorContext assertionDeclarator() {
			return getRuleContext(AssertionDeclaratorContext.class,0);
		}
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssertion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			assertionDeclarator();
			setState(303);
			match(T__0);
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

	public static class BindDeclarationContext extends ParserRuleContext {
		public BindDeclaratorContext bindDeclarator() {
			return getRuleContext(BindDeclaratorContext.class,0);
		}
		public BindDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterBindDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitBindDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitBindDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindDeclarationContext bindDeclaration() throws RecognitionException {
		BindDeclarationContext _localctx = new BindDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bindDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			bindDeclarator();
			setState(306);
			match(T__0);
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

	public static class BindDeclaratorContext extends ParserRuleContext {
		public TerminalNode BIND() { return getToken(RIIF2Parser.BIND, 0); }
		public BindDeclaratorIdContext bindDeclaratorId() {
			return getRuleContext(BindDeclaratorIdContext.class,0);
		}
		public List<BindContractContext> bindContract() {
			return getRuleContexts(BindContractContext.class);
		}
		public BindContractContext bindContract(int i) {
			return getRuleContext(BindContractContext.class,i);
		}
		public BindDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterBindDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitBindDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitBindDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindDeclaratorContext bindDeclarator() throws RecognitionException {
		BindDeclaratorContext _localctx = new BindDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_bindDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(BIND);
			setState(309);
			bindDeclaratorId();
			setState(310);
			match(T__1);
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(311);
				bindContract();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			match(T__2);
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

	public static class BindDeclaratorIdContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(RIIF2Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(RIIF2Parser.Identifier, i);
		}
		public BindDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterBindDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitBindDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitBindDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindDeclaratorIdContext bindDeclaratorId() throws RecognitionException {
		BindDeclaratorIdContext _localctx = new BindDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_bindDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(Identifier);
			setState(320);
			match(T__3);
			setState(321);
			match(Identifier);
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

	public static class BindContractContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(RIIF2Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(RIIF2Parser.Identifier, i);
		}
		public BindContractContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindContract; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterBindContract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitBindContract(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitBindContract(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindContractContext bindContract() throws RecognitionException {
		BindContractContext _localctx = new BindContractContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_bindContract);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(Identifier);
			setState(324);
			match(T__4);
			setState(325);
			match(Identifier);
			setState(326);
			match(T__0);
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

	public static class PrimitiveFieldDeclaratorContext extends ParserRuleContext {
		public PrimitiveFieldDeclaratorIdContext primitiveFieldDeclaratorId() {
			return getRuleContext(PrimitiveFieldDeclaratorIdContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public FieldInitializerContext fieldInitializer() {
			return getRuleContext(FieldInitializerContext.class,0);
		}
		public PrimitiveFieldDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveFieldDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimitiveFieldDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimitiveFieldDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimitiveFieldDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveFieldDeclaratorContext primitiveFieldDeclarator() throws RecognitionException {
		PrimitiveFieldDeclaratorContext _localctx = new PrimitiveFieldDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_primitiveFieldDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			primitiveFieldDeclaratorId();
			{
			setState(329);
			match(T__3);
			setState(330);
			primitiveType();
			}
			setState(334);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(332);
				match(T__5);
				setState(333);
				fieldInitializer();
				}
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

	public static class AssociativeIndexDeclaratorContext extends ParserRuleContext {
		public AssociativeIndexDeclaratorIdContext associativeIndexDeclaratorId() {
			return getRuleContext(AssociativeIndexDeclaratorIdContext.class,0);
		}
		public FieldInitializerContext fieldInitializer() {
			return getRuleContext(FieldInitializerContext.class,0);
		}
		public AssociativeIndexDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associativeIndexDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssociativeIndexDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssociativeIndexDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssociativeIndexDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociativeIndexDeclaratorContext associativeIndexDeclarator() throws RecognitionException {
		AssociativeIndexDeclaratorContext _localctx = new AssociativeIndexDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_associativeIndexDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			associativeIndexDeclaratorId();
			setState(339);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(337);
				match(T__5);
				setState(338);
				fieldInitializer();
				}
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

	public static class TableFieldDeclaratorContext extends ParserRuleContext {
		public TableFieldDeclaratorIdContext tableFieldDeclaratorId() {
			return getRuleContext(TableFieldDeclaratorIdContext.class,0);
		}
		public TerminalNode TYPE_TABLE() { return getToken(RIIF2Parser.TYPE_TABLE, 0); }
		public TableFieldDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableFieldDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTableFieldDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTableFieldDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTableFieldDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableFieldDeclaratorContext tableFieldDeclarator() throws RecognitionException {
		TableFieldDeclaratorContext _localctx = new TableFieldDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_tableFieldDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			tableFieldDeclaratorId();
			setState(342);
			match(T__3);
			setState(343);
			match(TYPE_TABLE);
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

	public static class ListFieldDeclaratorContext extends ParserRuleContext {
		public ListFieldDeclaratorIdContext listFieldDeclaratorId() {
			return getRuleContext(ListFieldDeclaratorIdContext.class,0);
		}
		public ListInitializerContext listInitializer() {
			return getRuleContext(ListInitializerContext.class,0);
		}
		public ListFieldDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listFieldDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterListFieldDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitListFieldDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitListFieldDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListFieldDeclaratorContext listFieldDeclarator() throws RecognitionException {
		ListFieldDeclaratorContext _localctx = new ListFieldDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_listFieldDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			listFieldDeclaratorId();
			setState(346);
			match(T__5);
			setState(347);
			listInitializer();
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

	public static class ChildComponentDeclaratorContext extends ParserRuleContext {
		public ChildComponentTypeContext childComponentType() {
			return getRuleContext(ChildComponentTypeContext.class,0);
		}
		public ChildComponentDeclaratorIdContext childComponentDeclaratorId() {
			return getRuleContext(ChildComponentDeclaratorIdContext.class,0);
		}
		public ChildComponentDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_childComponentDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterChildComponentDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitChildComponentDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitChildComponentDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChildComponentDeclaratorContext childComponentDeclarator() throws RecognitionException {
		ChildComponentDeclaratorContext _localctx = new ChildComponentDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_childComponentDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			childComponentType();
			setState(350);
			childComponentDeclaratorId();
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

	public static class FailModeDeclaratorContext extends ParserRuleContext {
		public FailModeDeclaratorIdContext failModeDeclaratorId() {
			return getRuleContext(FailModeDeclaratorIdContext.class,0);
		}
		public FailModeDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_failModeDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFailModeDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFailModeDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFailModeDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FailModeDeclaratorContext failModeDeclarator() throws RecognitionException {
		FailModeDeclaratorContext _localctx = new FailModeDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_failModeDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			failModeDeclaratorId();
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

	public static class AisDeclaratorContext extends ParserRuleContext {
		public AisDeclaratorIdContext aisDeclaratorId() {
			return getRuleContext(AisDeclaratorIdContext.class,0);
		}
		public AisInitializerContext aisInitializer() {
			return getRuleContext(AisInitializerContext.class,0);
		}
		public AisDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aisDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAisDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAisDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAisDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AisDeclaratorContext aisDeclarator() throws RecognitionException {
		AisDeclaratorContext _localctx = new AisDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_aisDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			aisDeclaratorId();
			setState(355);
			match(T__6);
			setState(356);
			aisInitializer();
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

	public static class AssertionDeclaratorContext extends ParserRuleContext {
		public Token op;
		public TerminalNode ASSERT() { return getToken(RIIF2Parser.ASSERT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public AttributeIdContext attributeId() {
			return getRuleContext(AttributeIdContext.class,0);
		}
		public AssertionDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertionDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssertionDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssertionDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssertionDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertionDeclaratorContext assertionDeclarator() throws RecognitionException {
		AssertionDeclaratorContext _localctx = new AssertionDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_assertionDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(ASSERT);
			{
			setState(359);
			attributeId();
			}
			setState(360);
			((AssertionDeclaratorContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
				((AssertionDeclaratorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(361);
			expression(0);
			setState(362);
			match(Identifier);
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

	public static class FieldInitializerContext extends ParserRuleContext {
		public ListInitializerContext listInitializer() {
			return getRuleContext(ListInitializerContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayInitializerWrapperContext arrayInitializerWrapper() {
			return getRuleContext(ArrayInitializerWrapperContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFieldInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFieldInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFieldInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldInitializerContext fieldInitializer() throws RecognitionException {
		FieldInitializerContext _localctx = new FieldInitializerContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_fieldInitializer);
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				listInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				arrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(366);
				arrayInitializerWrapper();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(367);
				expression(0);
				}
				break;
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

	public static class ArrayInitializerWrapperContext extends ParserRuleContext {
		public List<ArrayInitializerContext> arrayInitializer() {
			return getRuleContexts(ArrayInitializerContext.class);
		}
		public ArrayInitializerContext arrayInitializer(int i) {
			return getRuleContext(ArrayInitializerContext.class,i);
		}
		public ArrayInitializerWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializerWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterArrayInitializerWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitArrayInitializerWrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitArrayInitializerWrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerWrapperContext arrayInitializerWrapper() throws RecognitionException {
		ArrayInitializerWrapperContext _localctx = new ArrayInitializerWrapperContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_arrayInitializerWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(T__9);
			setState(371);
			arrayInitializer();
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(372);
				match(T__10);
				setState(373);
				arrayInitializer();
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(379);
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

	public static class ArrayInitializerContext extends ParserRuleContext {
		public List<ArrayItemContext> arrayItem() {
			return getRuleContexts(ArrayItemContext.class);
		}
		public ArrayItemContext arrayItem(int i) {
			return getRuleContext(ArrayItemContext.class,i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(T__12);
			setState(382);
			arrayItem();
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(383);
				match(T__10);
				setState(384);
				arrayItem();
				}
				}
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(390);
			match(T__13);
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

	public static class ArrayItemContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterArrayItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitArrayItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitArrayItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayItemContext arrayItem() throws RecognitionException {
		ArrayItemContext _localctx = new ArrayItemContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arrayItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			expression(0);
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

	public static class ListInitializerContext extends ParserRuleContext {
		public List<ListItemContext> listItem() {
			return getRuleContexts(ListItemContext.class);
		}
		public ListItemContext listItem(int i) {
			return getRuleContext(ListItemContext.class,i);
		}
		public ListInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterListInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitListInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitListInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListInitializerContext listInitializer() throws RecognitionException {
		ListInitializerContext _localctx = new ListInitializerContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_listInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(T__9);
			setState(395);
			listItem();
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(396);
				match(T__10);
				setState(397);
				listItem();
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(403);
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

	public static class ListItemContext extends ParserRuleContext {
		public ListItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listItem; }
	 
		public ListItemContext() { }
		public void copyFrom(ListItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ListItemIdentifierContext extends ListItemContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public ListItemIdentifierContext(ListItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterListItemIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitListItemIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitListItemIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListItemFloatingPointLiteralContext extends ListItemContext {
		public TerminalNode FloatingPointLiteral() { return getToken(RIIF2Parser.FloatingPointLiteral, 0); }
		public ListItemFloatingPointLiteralContext(ListItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterListItemFloatingPointLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitListItemFloatingPointLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitListItemFloatingPointLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListItemDecimalLiteralContext extends ListItemContext {
		public TerminalNode DecimalLiteral() { return getToken(RIIF2Parser.DecimalLiteral, 0); }
		public ListItemDecimalLiteralContext(ListItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterListItemDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitListItemDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitListItemDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListItemContext listItem() throws RecognitionException {
		ListItemContext _localctx = new ListItemContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_listItem);
		try {
			setState(408);
			switch (_input.LA(1)) {
			case DecimalLiteral:
				_localctx = new ListItemDecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
				match(DecimalLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new ListItemFloatingPointLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(406);
				match(FloatingPointLiteral);
				}
				break;
			case Identifier:
				_localctx = new ListItemIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(407);
				match(Identifier);
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

	public static class TableItemInitializerContext extends ParserRuleContext {
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public TableItemInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableItemInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTableItemInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTableItemInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTableItemInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableItemInitializerContext tableItemInitializer() throws RecognitionException {
		TableItemInitializerContext _localctx = new TableItemInitializerContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_tableItemInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(T__9);
			setState(411);
			row();
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(412);
				match(T__10);
				setState(413);
				row();
				}
				}
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(419);
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

	public static class RowContext extends ParserRuleContext {
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
	 
		public RowContext() { }
		public void copyFrom(RowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RowArrayContext extends RowContext {
		public List<RowItemContext> rowItem() {
			return getRuleContexts(RowItemContext.class);
		}
		public RowItemContext rowItem(int i) {
			return getRuleContext(RowItemContext.class,i);
		}
		public RowArrayContext(RowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterRowArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitRowArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitRowArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowExpressionContext extends RowContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RowExpressionContext(RowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterRowExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitRowExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitRowExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_row);
		int _la;
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new RowArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				match(T__12);
				setState(422);
				rowItem();
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(423);
					match(T__10);
					setState(424);
					rowItem();
					}
					}
					setState(429);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(430);
				match(T__13);
				}
				break;
			case 2:
				_localctx = new RowExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				expression(0);
				}
				break;
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

	public static class RowItemContext extends ParserRuleContext {
		public RowItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowItem; }
	 
		public RowItemContext() { }
		public void copyFrom(RowItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RowItemListInitializerContext extends RowItemContext {
		public ListInitializerContext listInitializer() {
			return getRuleContext(ListInitializerContext.class,0);
		}
		public RowItemListInitializerContext(RowItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterRowItemListInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitRowItemListInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitRowItemListInitializer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowItemExpressionContext extends RowItemContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RowItemExpressionContext(RowItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterRowItemExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitRowItemExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitRowItemExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowItemContext rowItem() throws RecognitionException {
		RowItemContext _localctx = new RowItemContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_rowItem);
		try {
			setState(437);
			switch (_input.LA(1)) {
			case T__1:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case FUNC_AGG_SINGLE:
			case FUNC_GT_N_FAIL:
			case FUNC_LOG:
			case FUNC_EXP:
			case NULL:
			case SELF:
			case TRUE:
			case FALSE:
			case Identifier:
			case StringLiteral:
			case FloatingPointLiteral:
			case DecimalLiteral:
				_localctx = new RowItemExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				expression(0);
				}
				break;
			case T__9:
				_localctx = new RowItemListInitializerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				listInitializer();
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

	public static class AisInitializerContext extends ParserRuleContext {
		public ListInitializerContext listInitializer() {
			return getRuleContext(ListInitializerContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerWrapperContext arrayInitializerWrapper() {
			return getRuleContext(ArrayInitializerWrapperContext.class,0);
		}
		public TableItemInitializerContext tableItemInitializer() {
			return getRuleContext(TableItemInitializerContext.class,0);
		}
		public AisInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aisInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAisInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAisInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAisInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AisInitializerContext aisInitializer() throws RecognitionException {
		AisInitializerContext _localctx = new AisInitializerContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_aisInitializer);
		try {
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				listInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(440);
				arrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(441);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(442);
				arrayInitializerWrapper();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(443);
				tableItemInitializer();
				}
				break;
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

	public static class PrimitiveFieldDeclaratorIdContext extends ParserRuleContext {
		public PrimitiveFieldDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveFieldDeclaratorId; }
	 
		public PrimitiveFieldDeclaratorIdContext() { }
		public void copyFrom(PrimitiveFieldDeclaratorIdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimitiveFieldDeclaratorId1Context extends PrimitiveFieldDeclaratorIdContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AttributeIndexContext attributeIndex() {
			return getRuleContext(AttributeIndexContext.class,0);
		}
		public PrimitiveFieldDeclaratorId1Context(PrimitiveFieldDeclaratorIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimitiveFieldDeclaratorId1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimitiveFieldDeclaratorId1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimitiveFieldDeclaratorId1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveFieldDeclaratorId2Context extends PrimitiveFieldDeclaratorIdContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public AssociativeIndexContext associativeIndex() {
			return getRuleContext(AssociativeIndexContext.class,0);
		}
		public AttributeIndexContext attributeIndex() {
			return getRuleContext(AttributeIndexContext.class,0);
		}
		public PrimitiveFieldDeclaratorId2Context(PrimitiveFieldDeclaratorIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimitiveFieldDeclaratorId2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimitiveFieldDeclaratorId2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimitiveFieldDeclaratorId2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveFieldDeclaratorIdContext primitiveFieldDeclaratorId() throws RecognitionException {
		PrimitiveFieldDeclaratorIdContext _localctx = new PrimitiveFieldDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_primitiveFieldDeclaratorId);
		int _la;
		try {
			setState(457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new PrimitiveFieldDeclaratorId1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				match(Identifier);
				setState(448);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(447);
					typeType();
					}
				}

				setState(451);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(450);
					attributeIndex();
					}
				}

				}
				break;
			case 2:
				_localctx = new PrimitiveFieldDeclaratorId2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				match(Identifier);
				setState(454);
				associativeIndex();
				setState(455);
				attributeIndex();
				}
				break;
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

	public static class AssociativeIndexDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public AssociativeIndexContext associativeIndex() {
			return getRuleContext(AssociativeIndexContext.class,0);
		}
		public AssociativeIndexDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associativeIndexDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssociativeIndexDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssociativeIndexDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssociativeIndexDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociativeIndexDeclaratorIdContext associativeIndexDeclaratorId() throws RecognitionException {
		AssociativeIndexDeclaratorIdContext _localctx = new AssociativeIndexDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_associativeIndexDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(Identifier);
			setState(460);
			associativeIndex();
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

	public static class TableFieldDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public TableFieldDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableFieldDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTableFieldDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTableFieldDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTableFieldDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableFieldDeclaratorIdContext tableFieldDeclaratorId() throws RecognitionException {
		TableFieldDeclaratorIdContext _localctx = new TableFieldDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_tableFieldDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(Identifier);
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

	public static class ListFieldDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public ListFieldDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listFieldDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterListFieldDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitListFieldDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitListFieldDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListFieldDeclaratorIdContext listFieldDeclaratorId() throws RecognitionException {
		ListFieldDeclaratorIdContext _localctx = new ListFieldDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_listFieldDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(Identifier);
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

	public static class ChildComponentDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AssociativeIndexContext associativeIndex() {
			return getRuleContext(AssociativeIndexContext.class,0);
		}
		public ChildComponentDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_childComponentDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterChildComponentDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitChildComponentDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitChildComponentDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChildComponentDeclaratorIdContext childComponentDeclaratorId() throws RecognitionException {
		ChildComponentDeclaratorIdContext _localctx = new ChildComponentDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_childComponentDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(Identifier);
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(467);
				typeType();
				}
				break;
			case 2:
				{
				setState(468);
				associativeIndex();
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

	public static class FailModeDeclaratorIdContext extends ParserRuleContext {
		public FailModeDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_failModeDeclaratorId; }
	 
		public FailModeDeclaratorIdContext() { }
		public void copyFrom(FailModeDeclaratorIdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FailModeDeclaratorId2Context extends FailModeDeclaratorIdContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public AssociativeIndexContext associativeIndex() {
			return getRuleContext(AssociativeIndexContext.class,0);
		}
		public AttributeIndexContext attributeIndex() {
			return getRuleContext(AttributeIndexContext.class,0);
		}
		public FailModeDeclaratorId2Context(FailModeDeclaratorIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFailModeDeclaratorId2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFailModeDeclaratorId2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFailModeDeclaratorId2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FailModeDeclaratorId1Context extends FailModeDeclaratorIdContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AttributeIndexContext attributeIndex() {
			return getRuleContext(AttributeIndexContext.class,0);
		}
		public FailModeDeclaratorId1Context(FailModeDeclaratorIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFailModeDeclaratorId1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFailModeDeclaratorId1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFailModeDeclaratorId1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FailModeDeclaratorIdContext failModeDeclaratorId() throws RecognitionException {
		FailModeDeclaratorIdContext _localctx = new FailModeDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_failModeDeclaratorId);
		int _la;
		try {
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new FailModeDeclaratorId1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(471);
				match(Identifier);
				setState(473);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(472);
					typeType();
					}
				}

				setState(476);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(475);
					attributeIndex();
					}
				}

				}
				break;
			case 2:
				_localctx = new FailModeDeclaratorId2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(478);
				match(Identifier);
				setState(479);
				associativeIndex();
				setState(481);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(480);
					attributeIndex();
					}
				}

				}
				break;
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

	public static class AisDeclaratorIdContext extends ParserRuleContext {
		public PrimitiveIdContext primitiveId() {
			return getRuleContext(PrimitiveIdContext.class,0);
		}
		public AisTypeContext aisType() {
			return getRuleContext(AisTypeContext.class,0);
		}
		public AssociativeIndexContext associativeIndex() {
			return getRuleContext(AssociativeIndexContext.class,0);
		}
		public HierPostfixContext hierPostfix() {
			return getRuleContext(HierPostfixContext.class,0);
		}
		public AttributeIndexContext attributeIndex() {
			return getRuleContext(AttributeIndexContext.class,0);
		}
		public TableIndexContext tableIndex() {
			return getRuleContext(TableIndexContext.class,0);
		}
		public AisDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aisDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAisDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAisDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAisDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AisDeclaratorIdContext aisDeclaratorId() throws RecognitionException {
		AisDeclaratorIdContext _localctx = new AisDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_aisDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			primitiveId(0);
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(486);
				aisType();
				}
				break;
			case 2:
				{
				setState(487);
				associativeIndex();
				}
				break;
			}
			setState(491);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(490);
				hierPostfix();
				}
				break;
			}
			setState(494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(493);
				attributeIndex();
				}
				break;
			}
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(496);
				tableIndex();
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

	public static class PrimitiveIdContext extends ParserRuleContext {
		public PrimitiveIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveId; }
	 
		public PrimitiveIdContext() { }
		public void copyFrom(PrimitiveIdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimitiveIdIdContext extends PrimitiveIdContext {
		public PrimitiveIdContext primitiveId() {
			return getRuleContext(PrimitiveIdContext.class,0);
		}
		public HierPostfixContext hierPostfix() {
			return getRuleContext(HierPostfixContext.class,0);
		}
		public PrimitiveIdIdContext(PrimitiveIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimitiveIdId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimitiveIdId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimitiveIdId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveIdIdentifierContext extends PrimitiveIdContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public PrimitiveIdIdentifierContext(PrimitiveIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimitiveIdIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimitiveIdIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimitiveIdIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryNULLContext extends PrimitiveIdContext {
		public TerminalNode NULL() { return getToken(RIIF2Parser.NULL, 0); }
		public PrimaryNULLContext(PrimitiveIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryNULL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryNULL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryNULL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveIdContext primitiveId() throws RecognitionException {
		return primitiveId(0);
	}

	private PrimitiveIdContext primitiveId(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimitiveIdContext _localctx = new PrimitiveIdContext(_ctx, _parentState);
		PrimitiveIdContext _prevctx = _localctx;
		int _startState = 106;
		enterRecursionRule(_localctx, 106, RULE_primitiveId, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			switch (_input.LA(1)) {
			case Identifier:
				{
				_localctx = new PrimitiveIdIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(500);
				match(Identifier);
				}
				break;
			case NULL:
				{
				_localctx = new PrimaryNULLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(501);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(508);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrimitiveIdIdContext(new PrimitiveIdContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_primitiveId);
					setState(504);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					{
					setState(505);
					hierPostfix();
					}
					}
					} 
				}
				setState(510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class AssociativeIdContext extends ParserRuleContext {
		public PrimitiveIdContext primitiveId() {
			return getRuleContext(PrimitiveIdContext.class,0);
		}
		public AssociativeIndexContext associativeIndex() {
			return getRuleContext(AssociativeIndexContext.class,0);
		}
		public AssociativeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associativeId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssociativeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssociativeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssociativeId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociativeIdContext associativeId() throws RecognitionException {
		AssociativeIdContext _localctx = new AssociativeIdContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_associativeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			primitiveId(0);
			setState(512);
			associativeIndex();
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

	public static class AttributeIdContext extends ParserRuleContext {
		public AttributeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeId; }
	 
		public AttributeIdContext() { }
		public void copyFrom(AttributeIdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributePrimitiveIdIndexContext extends AttributeIdContext {
		public PrimitiveIdContext primitiveId() {
			return getRuleContext(PrimitiveIdContext.class,0);
		}
		public AttributeIndexContext attributeIndex() {
			return getRuleContext(AttributeIndexContext.class,0);
		}
		public AttributePrimitiveIdIndexContext(AttributeIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAttributePrimitiveIdIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAttributePrimitiveIdIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAttributePrimitiveIdIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeIdContext attributeId() throws RecognitionException {
		AttributeIdContext _localctx = new AttributeIdContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_attributeId);
		try {
			_localctx = new AttributePrimitiveIdIndexContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			primitiveId(0);
			setState(515);
			attributeIndex();
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

	public static class VariableIdContext extends ParserRuleContext {
		public PrimitiveIdContext primitiveId() {
			return getRuleContext(PrimitiveIdContext.class,0);
		}
		public AssociativeIdContext associativeId() {
			return getRuleContext(AssociativeIdContext.class,0);
		}
		public AttributeIdContext attributeId() {
			return getRuleContext(AttributeIdContext.class,0);
		}
		public TableIdContext tableId() {
			return getRuleContext(TableIdContext.class,0);
		}
		public VariableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterVariableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitVariableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitVariableId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIdContext variableId() throws RecognitionException {
		VariableIdContext _localctx = new VariableIdContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_variableId);
		try {
			setState(521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				primitiveId(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
				associativeId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(519);
				attributeId();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(520);
				tableId();
				}
				break;
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

	public static class AttributeIndexContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public AttributeIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAttributeIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAttributeIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAttributeIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeIndexContext attributeIndex() throws RecognitionException {
		AttributeIndexContext _localctx = new AttributeIndexContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_attributeIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			match(T__14);
			setState(524);
			match(Identifier);
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

	public static class AssociativeIndexContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public AssociativeIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associativeIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssociativeIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssociativeIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssociativeIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociativeIndexContext associativeIndex() throws RecognitionException {
		AssociativeIndexContext _localctx = new AssociativeIndexContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_associativeIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(T__12);
			setState(527);
			match(Identifier);
			setState(528);
			match(T__13);
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

	public static class TableIndexContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(RIIF2Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(RIIF2Parser.Identifier, i);
		}
		public TableIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTableIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTableIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTableIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableIndexContext tableIndex() throws RecognitionException {
		TableIndexContext _localctx = new TableIndexContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_tableIndex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(T__12);
			setState(531);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(532);
			match(T__13);
			setState(533);
			match(T__12);
			setState(534);
			match(Identifier);
			setState(535);
			match(T__13);
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

	public static class HierPostfixContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public HierPostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hierPostfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterHierPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitHierPostfix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitHierPostfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HierPostfixContext hierPostfix() throws RecognitionException {
		HierPostfixContext _localctx = new HierPostfixContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_hierPostfix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(T__16);
			setState(538);
			match(Identifier);
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

	public static class TableIdContext extends ParserRuleContext {
		public Token op;
		public AttributeIdContext attributeId() {
			return getRuleContext(AttributeIdContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(RIIF2Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(RIIF2Parser.Identifier, i);
		}
		public TableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTableId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableIdContext tableId() throws RecognitionException {
		TableIdContext _localctx = new TableIdContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_tableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			attributeId();
			setState(541);
			match(T__12);
			setState(544);
			switch (_input.LA(1)) {
			case T__15:
				{
				setState(542);
				((TableIdContext)_localctx).op = match(T__15);
				}
				break;
			case Identifier:
				{
				setState(543);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(546);
			match(T__13);
			setState(547);
			match(T__12);
			setState(548);
			match(Identifier);
			setState(549);
			match(T__13);
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

	public static class ExtendsListContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(RIIF2Parser.EXTENDS, 0); }
		public List<TerminalNode> Identifier() { return getTokens(RIIF2Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(RIIF2Parser.Identifier, i);
		}
		public ExtendsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExtendsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExtendsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExtendsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendsListContext extendsList() throws RecognitionException {
		ExtendsListContext _localctx = new ExtendsListContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_extendsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			match(EXTENDS);
			setState(552);
			match(Identifier);
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(553);
				match(T__10);
				setState(554);
				match(Identifier);
				}
				}
				setState(559);
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

	public static class ImplementsListContext extends ParserRuleContext {
		public TerminalNode IMPLEMENTS() { return getToken(RIIF2Parser.IMPLEMENTS, 0); }
		public List<TerminalNode> Identifier() { return getTokens(RIIF2Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(RIIF2Parser.Identifier, i);
		}
		public ImplementsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implementsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterImplementsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitImplementsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitImplementsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplementsListContext implementsList() throws RecognitionException {
		ImplementsListContext _localctx = new ImplementsListContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_implementsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(IMPLEMENTS);
			setState(561);
			match(Identifier);
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(562);
				match(T__10);
				setState(563);
				match(Identifier);
				}
				}
				setState(568);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode TYPE_FLOAT() { return getToken(RIIF2Parser.TYPE_FLOAT, 0); }
		public TerminalNode TYPE_INTEGER() { return getToken(RIIF2Parser.TYPE_INTEGER, 0); }
		public TerminalNode TYPE_STRING() { return getToken(RIIF2Parser.TYPE_STRING, 0); }
		public TerminalNode TYPE_BOOLEAN() { return getToken(RIIF2Parser.TYPE_BOOLEAN, 0); }
		public TerminalNode TYPE_TIME() { return getToken(RIIF2Parser.TYPE_TIME, 0); }
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public EnumTypeContext enumType() {
			return getRuleContext(EnumTypeContext.class,0);
		}
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_primitiveType);
		try {
			setState(576);
			switch (_input.LA(1)) {
			case TYPE_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(569);
				match(TYPE_FLOAT);
				}
				break;
			case TYPE_INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(570);
				match(TYPE_INTEGER);
				}
				break;
			case TYPE_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(571);
				match(TYPE_STRING);
				}
				break;
			case TYPE_BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(572);
				match(TYPE_BOOLEAN);
				}
				break;
			case TYPE_TIME:
				enterOuterAlt(_localctx, 5);
				{
				setState(573);
				match(TYPE_TIME);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 6);
				{
				setState(574);
				match(Identifier);
				}
				break;
			case TYPE_ENUM:
				enterOuterAlt(_localctx, 7);
				{
				setState(575);
				enumType();
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

	public static class TypeTypeContext extends ParserRuleContext {
		public AssociativeTypeContext associativeType() {
			return getRuleContext(AssociativeTypeContext.class,0);
		}
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitTypeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_typeType);
		try {
			setState(580);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(578);
				associativeType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				vector();
				}
				break;
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

	public static class AisTypeContext extends ParserRuleContext {
		public FlatVectorContext flatVector() {
			return getRuleContext(FlatVectorContext.class,0);
		}
		public AssociativeTypeContext associativeType() {
			return getRuleContext(AssociativeTypeContext.class,0);
		}
		public AisTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aisType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAisType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAisType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAisType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AisTypeContext aisType() throws RecognitionException {
		AisTypeContext _localctx = new AisTypeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_aisType);
		try {
			setState(584);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				flatVector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(583);
				associativeType();
				}
				break;
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

	public static class AssociativeTypeContext extends ParserRuleContext {
		public AssociativeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associativeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAssociativeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAssociativeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAssociativeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociativeTypeContext associativeType() throws RecognitionException {
		AssociativeTypeContext _localctx = new AssociativeTypeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_associativeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			match(T__12);
			setState(587);
			match(T__13);
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

	public static class VectorContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(T__12);
			setState(590);
			expression(0);
			setState(591);
			match(T__3);
			setState(592);
			expression(0);
			setState(593);
			match(T__13);
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

	public static class FlatVectorContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FlatVectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flatVector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFlatVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFlatVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFlatVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlatVectorContext flatVector() throws RecognitionException {
		FlatVectorContext _localctx = new FlatVectorContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_flatVector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			match(T__12);
			setState(596);
			expression(0);
			setState(597);
			match(T__17);
			setState(598);
			expression(0);
			setState(599);
			match(T__13);
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

	public static class InputOutputContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(RIIF2Parser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(RIIF2Parser.OUTPUT, 0); }
		public InputOutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputOutput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterInputOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitInputOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitInputOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputOutputContext inputOutput() throws RecognitionException {
		InputOutputContext _localctx = new InputOutputContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_inputOutput);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			_la = _input.LA(1);
			if ( !(_la==INPUT || _la==OUTPUT) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class FieldTypeContext extends ParserRuleContext {
		public TerminalNode PARAMETER() { return getToken(RIIF2Parser.PARAMETER, 0); }
		public TerminalNode CONSTANT() { return getToken(RIIF2Parser.CONSTANT, 0); }
		public FieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFieldType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFieldType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFieldType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_fieldType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			_la = _input.LA(1);
			if ( !(_la==PARAMETER || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class EnumTypeContext extends ParserRuleContext {
		public TerminalNode TYPE_ENUM() { return getToken(RIIF2Parser.TYPE_ENUM, 0); }
		public List<TerminalNode> Identifier() { return getTokens(RIIF2Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(RIIF2Parser.Identifier, i);
		}
		public EnumTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterEnumType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitEnumType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitEnumType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumTypeContext enumType() throws RecognitionException {
		EnumTypeContext _localctx = new EnumTypeContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_enumType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			match(TYPE_ENUM);
			setState(606);
			match(T__9);
			setState(607);
			match(Identifier);
			setState(612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(608);
				match(T__10);
				setState(609);
				match(Identifier);
				}
				}
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(615);
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

	public static class ChildComponentTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RIIF2Parser.Identifier, 0); }
		public ChildComponentTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_childComponentType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterChildComponentType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitChildComponentType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitChildComponentType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChildComponentTypeContext childComponentType() throws RecognitionException {
		ChildComponentTypeContext _localctx = new ChildComponentTypeContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_childComponentType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(Identifier);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpCmpContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpCmpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpCmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpCmp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpPrimaryContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpPrimaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpEqOrNotEqContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpEqOrNotEqContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpEqOrNotEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpEqOrNotEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpEqOrNotEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIfElseContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpIfElseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpDoubleOrContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpDoubleOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpDoubleOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpDoubleOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpDoubleOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpPositiveOrNegativeContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpPositiveOrNegativeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpPositiveOrNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpPositiveOrNegative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpPositiveOrNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAssignContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpSingleOrContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpSingleOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpSingleOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpSingleOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpSingleOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpPowerContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpPowerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpPower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpMinusOrPlusContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpMinusOrPlusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpMinusOrPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpMinusOrPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpMinusOrPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpDoubleAndContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpDoubleAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpDoubleAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpDoubleAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpDoubleAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpSingleAndContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpSingleAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpSingleAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpSingleAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpSingleAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpWaveOrNotContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpWaveOrNotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpWaveOrNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpWaveOrNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpWaveOrNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpStarOrDivOrModContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpStarOrDivOrModContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterExpStarOrDivOrMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitExpStarOrDivOrMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitExpStarOrDivOrMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 148;
		enterRecursionRule(_localctx, 148, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			switch (_input.LA(1)) {
			case T__1:
			case T__12:
			case FUNC_AGG_SINGLE:
			case FUNC_GT_N_FAIL:
			case FUNC_LOG:
			case FUNC_EXP:
			case NULL:
			case SELF:
			case TRUE:
			case FALSE:
			case Identifier:
			case StringLiteral:
			case FloatingPointLiteral:
			case DecimalLiteral:
				{
				_localctx = new ExpPrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(620);
				primary();
				}
				break;
			case T__18:
			case T__19:
				{
				_localctx = new ExpPositiveOrNegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(621);
				((ExpPositiveOrNegativeContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
					((ExpPositiveOrNegativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(622);
				expression(13);
				}
				break;
			case T__20:
			case T__21:
				{
				_localctx = new ExpWaveOrNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(623);
				((ExpWaveOrNotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
					((ExpWaveOrNotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(624);
				expression(12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(665);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(663);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new ExpStarOrDivOrModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(627);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(628);
						((ExpStarOrDivOrModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
							((ExpStarOrDivOrModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(629);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpMinusOrPlusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(630);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(631);
						((ExpMinusOrPlusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((ExpMinusOrPlusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(632);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(633);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(634);
						((ExpCmpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((ExpCmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(635);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpEqOrNotEqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(636);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(637);
						((ExpEqOrNotEqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((ExpEqOrNotEqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(638);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpSingleAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(639);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(640);
						((ExpSingleAndContext)_localctx).op = match(T__29);
						setState(641);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpPowerContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(642);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(643);
						((ExpPowerContext)_localctx).op = match(T__30);
						setState(644);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpSingleOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(645);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(646);
						((ExpSingleOrContext)_localctx).op = match(T__31);
						setState(647);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpDoubleAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(648);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(649);
						((ExpDoubleAndContext)_localctx).op = match(T__32);
						setState(650);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpDoubleOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(651);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(652);
						((ExpDoubleOrContext)_localctx).op = match(T__33);
						setState(653);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpIfElseContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(654);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(655);
						((ExpIfElseContext)_localctx).op = match(T__34);
						setState(656);
						expression(0);
						setState(657);
						((ExpIfElseContext)_localctx).op = match(T__3);
						setState(658);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExpAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(660);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(661);
						((ExpAssignContext)_localctx).op = match(T__6);
						setState(662);
						expression(1);
						}
						break;
					}
					} 
				}
				setState(667);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimaryArrayInitializerContext extends PrimaryContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public PrimaryArrayInitializerContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryAisDeclaratorIdContext extends PrimaryContext {
		public AisDeclaratorIdContext aisDeclaratorId() {
			return getRuleContext(AisDeclaratorIdContext.class,0);
		}
		public PrimaryAisDeclaratorIdContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryAisDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryAisDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryAisDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimarySelfContext extends PrimaryContext {
		public TerminalNode SELF() { return getToken(RIIF2Parser.SELF, 0); }
		public PrimarySelfContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimarySelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimarySelf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimarySelf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryTrueContext extends PrimaryContext {
		public TerminalNode TRUE() { return getToken(RIIF2Parser.TRUE, 0); }
		public PrimaryTrueContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryFalseContext extends PrimaryContext {
		public TerminalNode FALSE() { return getToken(RIIF2Parser.FALSE, 0); }
		public PrimaryFalseContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryParenthesesContext extends PrimaryContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimaryParenthesesContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryLiteralContext extends PrimaryContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryFuncCallContext extends PrimaryContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public PrimaryFuncCallContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_primary);
		try {
			setState(679);
			switch (_input.LA(1)) {
			case T__1:
				_localctx = new PrimaryParenthesesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(668);
				match(T__1);
				setState(669);
				expression(0);
				setState(670);
				match(T__2);
				}
				break;
			case SELF:
				_localctx = new PrimarySelfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
				match(SELF);
				}
				break;
			case TRUE:
				_localctx = new PrimaryTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(673);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new PrimaryFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(674);
				match(FALSE);
				}
				break;
			case NULL:
			case Identifier:
				_localctx = new PrimaryAisDeclaratorIdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(675);
				aisDeclaratorId();
				}
				break;
			case StringLiteral:
			case FloatingPointLiteral:
			case DecimalLiteral:
				_localctx = new PrimaryLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(676);
				literal();
				}
				break;
			case FUNC_AGG_SINGLE:
			case FUNC_GT_N_FAIL:
			case FUNC_LOG:
			case FUNC_EXP:
				_localctx = new PrimaryFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(677);
				funcCall();
				}
				break;
			case T__12:
				_localctx = new PrimaryArrayInitializerContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(678);
				arrayInitializer();
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

	public static class FuncCallContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public List<FuncArgContext> funcArg() {
			return getRuleContexts(FuncArgContext.class);
		}
		public FuncArgContext funcArg(int i) {
			return getRuleContext(FuncArgContext.class,i);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
			funcName();
			setState(682);
			match(T__1);
			setState(683);
			funcArg();
			setState(686);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(684);
				match(T__10);
				setState(685);
				funcArg();
				}
			}

			setState(688);
			match(T__2);
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

	public static class FuncNameContext extends ParserRuleContext {
		public TerminalNode FUNC_LOG() { return getToken(RIIF2Parser.FUNC_LOG, 0); }
		public TerminalNode FUNC_EXP() { return getToken(RIIF2Parser.FUNC_EXP, 0); }
		public TerminalNode FUNC_AGG_SINGLE() { return getToken(RIIF2Parser.FUNC_AGG_SINGLE, 0); }
		public TerminalNode FUNC_GT_N_FAIL() { return getToken(RIIF2Parser.FUNC_GT_N_FAIL, 0); }
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFuncName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_funcName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNC_AGG_SINGLE) | (1L << FUNC_GT_N_FAIL) | (1L << FUNC_LOG) | (1L << FUNC_EXP))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class FuncArgContext extends ParserRuleContext {
		public AisDeclaratorIdContext aisDeclaratorId() {
			return getRuleContext(AisDeclaratorIdContext.class,0);
		}
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FuncArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterFuncArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitFuncArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitFuncArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgContext funcArg() throws RecognitionException {
		FuncArgContext _localctx = new FuncArgContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_funcArg);
		try {
			setState(696);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(692);
				aisDeclaratorId();
				setState(693);
				vector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(695);
				expression(0);
				}
				break;
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LiteralStringContext extends LiteralContext {
		public TerminalNode StringLiteral() { return getToken(RIIF2Parser.StringLiteral, 0); }
		public LiteralStringContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterLiteralString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitLiteralString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitLiteralString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralFloatingPointContext extends LiteralContext {
		public TerminalNode FloatingPointLiteral() { return getToken(RIIF2Parser.FloatingPointLiteral, 0); }
		public LiteralFloatingPointContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterLiteralFloatingPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitLiteralFloatingPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitLiteralFloatingPoint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralDecimalContext extends LiteralContext {
		public TerminalNode DecimalLiteral() { return getToken(RIIF2Parser.DecimalLiteral, 0); }
		public LiteralDecimalContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterLiteralDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitLiteralDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitLiteralDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_literal);
		try {
			setState(701);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new LiteralStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(698);
				match(StringLiteral);
				}
				break;
			case DecimalLiteral:
				_localctx = new LiteralDecimalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(699);
				match(DecimalLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new LiteralFloatingPointContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(700);
				match(FloatingPointLiteral);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 53:
			return primitiveId_sempred((PrimitiveIdContext)_localctx, predIndex);
		case 74:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean primitiveId_sempred(PrimitiveIdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
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
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3R\u02c2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\6\2\u00a4\n\2"+
		"\r\2\16\2\u00a5\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\u00af\n\3\3\4\3\4\3\4"+
		"\5\4\u00b4\n\4\3\4\5\4\u00b7\n\4\3\4\3\4\7\4\u00bb\n\4\f\4\16\4\u00be"+
		"\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5\u00c7\n\5\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\5\7\u00d1\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u00ea\n\r\3\r\3"+
		"\r\7\r\u00ee\n\r\f\r\16\r\u00f1\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00fa\n\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0112\n\24"+
		"\f\24\16\24\u0115\13\24\3\24\3\24\3\25\3\25\5\25\u011b\n\25\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u012a\n\30"+
		"\f\30\16\30\u012d\13\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\7\33\u013b\n\33\f\33\16\33\u013e\13\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5"+
		"\36\u0151\n\36\3\37\3\37\3\37\5\37\u0156\n\37\3 \3 \3 \3 \3!\3!\3!\3!"+
		"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\5&\u0173"+
		"\n&\3\'\3\'\3\'\3\'\7\'\u0179\n\'\f\'\16\'\u017c\13\'\3\'\3\'\3(\3(\3"+
		"(\3(\7(\u0184\n(\f(\16(\u0187\13(\3(\3(\3)\3)\3*\3*\3*\3*\7*\u0191\n*"+
		"\f*\16*\u0194\13*\3*\3*\3+\3+\3+\5+\u019b\n+\3,\3,\3,\3,\7,\u01a1\n,\f"+
		",\16,\u01a4\13,\3,\3,\3-\3-\3-\3-\7-\u01ac\n-\f-\16-\u01af\13-\3-\3-\3"+
		"-\5-\u01b4\n-\3.\3.\5.\u01b8\n.\3/\3/\3/\3/\3/\5/\u01bf\n/\3\60\3\60\5"+
		"\60\u01c3\n\60\3\60\5\60\u01c6\n\60\3\60\3\60\3\60\3\60\5\60\u01cc\n\60"+
		"\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\5\64\u01d8\n\64\3\65"+
		"\3\65\5\65\u01dc\n\65\3\65\5\65\u01df\n\65\3\65\3\65\3\65\5\65\u01e4\n"+
		"\65\5\65\u01e6\n\65\3\66\3\66\3\66\5\66\u01eb\n\66\3\66\5\66\u01ee\n\66"+
		"\3\66\5\66\u01f1\n\66\3\66\5\66\u01f4\n\66\3\67\3\67\3\67\5\67\u01f9\n"+
		"\67\3\67\3\67\7\67\u01fd\n\67\f\67\16\67\u0200\13\67\38\38\38\39\39\3"+
		"9\3:\3:\3:\3:\5:\u020c\n:\3;\3;\3;\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3"+
		">\3>\3>\3?\3?\3?\3?\5?\u0223\n?\3?\3?\3?\3?\3?\3@\3@\3@\3@\7@\u022e\n"+
		"@\f@\16@\u0231\13@\3A\3A\3A\3A\7A\u0237\nA\fA\16A\u023a\13A\3B\3B\3B\3"+
		"B\3B\3B\3B\5B\u0243\nB\3C\3C\5C\u0247\nC\3D\3D\5D\u024b\nD\3E\3E\3E\3"+
		"F\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3H\3H\3I\3I\3J\3J\3J\3J\3J\7J\u0265"+
		"\nJ\fJ\16J\u0268\13J\3J\3J\3K\3K\3L\3L\3L\3L\3L\3L\5L\u0274\nL\3L\3L\3"+
		"L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3"+
		"L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\7L\u029a\nL\fL\16L\u029d\13L\3M\3M\3M"+
		"\3M\3M\3M\3M\3M\3M\3M\3M\5M\u02aa\nM\3N\3N\3N\3N\3N\5N\u02b1\nN\3N\3N"+
		"\3O\3O\3P\3P\3P\3P\5P\u02bb\nP\3Q\3Q\3Q\5Q\u02c0\nQ\3Q\2\4l\u0096R\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\2\r\5\2//BBFF\3"+
		"\2\n\13\4\2\22\22LL\3\2\61\62\3\2\63\64\3\2\25\26\3\2\27\30\3\2\31\33"+
		"\4\2\n\13\34\35\3\2\36\37\3\2;>\u02d3\2\u00a3\3\2\2\2\4\u00ae\3\2\2\2"+
		"\6\u00b0\3\2\2\2\b\u00c6\3\2\2\2\n\u00c8\3\2\2\2\f\u00d0\3\2\2\2\16\u00d2"+
		"\3\2\2\2\20\u00d6\3\2\2\2\22\u00da\3\2\2\2\24\u00de\3\2\2\2\26\u00e2\3"+
		"\2\2\2\30\u00e6\3\2\2\2\32\u00f9\3\2\2\2\34\u00fb\3\2\2\2\36\u00fe\3\2"+
		"\2\2 \u0101\3\2\2\2\"\u0104\3\2\2\2$\u0109\3\2\2\2&\u010d\3\2\2\2(\u011a"+
		"\3\2\2\2*\u011c\3\2\2\2,\u0120\3\2\2\2.\u0125\3\2\2\2\60\u0130\3\2\2\2"+
		"\62\u0133\3\2\2\2\64\u0136\3\2\2\2\66\u0141\3\2\2\28\u0145\3\2\2\2:\u014a"+
		"\3\2\2\2<\u0152\3\2\2\2>\u0157\3\2\2\2@\u015b\3\2\2\2B\u015f\3\2\2\2D"+
		"\u0162\3\2\2\2F\u0164\3\2\2\2H\u0168\3\2\2\2J\u0172\3\2\2\2L\u0174\3\2"+
		"\2\2N\u017f\3\2\2\2P\u018a\3\2\2\2R\u018c\3\2\2\2T\u019a\3\2\2\2V\u019c"+
		"\3\2\2\2X\u01b3\3\2\2\2Z\u01b7\3\2\2\2\\\u01be\3\2\2\2^\u01cb\3\2\2\2"+
		"`\u01cd\3\2\2\2b\u01d0\3\2\2\2d\u01d2\3\2\2\2f\u01d4\3\2\2\2h\u01e5\3"+
		"\2\2\2j\u01e7\3\2\2\2l\u01f8\3\2\2\2n\u0201\3\2\2\2p\u0204\3\2\2\2r\u020b"+
		"\3\2\2\2t\u020d\3\2\2\2v\u0210\3\2\2\2x\u0214\3\2\2\2z\u021b\3\2\2\2|"+
		"\u021e\3\2\2\2~\u0229\3\2\2\2\u0080\u0232\3\2\2\2\u0082\u0242\3\2\2\2"+
		"\u0084\u0246\3\2\2\2\u0086\u024a\3\2\2\2\u0088\u024c\3\2\2\2\u008a\u024f"+
		"\3\2\2\2\u008c\u0255\3\2\2\2\u008e\u025b\3\2\2\2\u0090\u025d\3\2\2\2\u0092"+
		"\u025f\3\2\2\2\u0094\u026b\3\2\2\2\u0096\u0273\3\2\2\2\u0098\u02a9\3\2"+
		"\2\2\u009a\u02ab\3\2\2\2\u009c\u02b4\3\2\2\2\u009e\u02ba\3\2\2\2\u00a0"+
		"\u02bf\3\2\2\2\u00a2\u00a4\5\4\3\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\7\2\2\3\u00a8\3\3\2\2\2\u00a9\u00af\5\6\4\2\u00aa\u00af\5\30\r"+
		"\2\u00ab\u00af\5&\24\2\u00ac\u00af\5.\30\2\u00ad\u00af\5\62\32\2\u00ae"+
		"\u00a9\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00ad\3\2\2\2\u00af\5\3\2\2\2\u00b0\u00b1\7&\2\2\u00b1\u00b3"+
		"\7L\2\2\u00b2\u00b4\5~@\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b6\3\2\2\2\u00b5\u00b7\5\u0080A\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bc\7\3\2\2\u00b9\u00bb\5\b\5\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\'\2\2\u00c0"+
		"\7\3\2\2\2\u00c1\u00c7\5\n\6\2\u00c2\u00c7\5\16\b\2\u00c3\u00c7\5\20\t"+
		"\2\u00c4\u00c7\5\22\n\2\u00c5\u00c7\5\24\13\2\u00c6\u00c1\3\2\2\2\u00c6"+
		"\u00c2\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2"+
		"\2\2\u00c7\t\3\2\2\2\u00c8\u00c9\5\u0090I\2\u00c9\u00ca\5\f\7\2\u00ca"+
		"\u00cb\7\3\2\2\u00cb\13\3\2\2\2\u00cc\u00d1\5:\36\2\u00cd\u00d1\5<\37"+
		"\2\u00ce\u00d1\5> \2\u00cf\u00d1\5@!\2\u00d0\u00cc\3\2\2\2\u00d0\u00cd"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\r\3\2\2\2\u00d2"+
		"\u00d3\7,\2\2\u00d3\u00d4\5B\"\2\u00d4\u00d5\7\3\2\2\u00d5\17\3\2\2\2"+
		"\u00d6\u00d7\7-\2\2\u00d7\u00d8\5D#\2\u00d8\u00d9\7\3\2\2\u00d9\21\3\2"+
		"\2\2\u00da\u00db\7/\2\2\u00db\u00dc\5F$\2\u00dc\u00dd\7\3\2\2\u00dd\23"+
		"\3\2\2\2\u00de\u00df\7F\2\2\u00df\u00e0\5F$\2\u00e0\u00e1\7\3\2\2\u00e1"+
		"\25\3\2\2\2\u00e2\u00e3\t\2\2\2\u00e3\u00e4\5F$\2\u00e4\u00e5\7\3\2\2"+
		"\u00e5\27\3\2\2\2\u00e6\u00e7\7@\2\2\u00e7\u00e9\7L\2\2\u00e8\u00ea\5"+
		"~@\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ef\7\3\2\2\u00ec\u00ee\5\32\16\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3"+
		"\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\7A\2\2\u00f3\31\3\2\2\2\u00f4\u00fa\5\34\17"+
		"\2\u00f5\u00fa\5\36\20\2\u00f6\u00fa\5 \21\2\u00f7\u00fa\5\"\22\2\u00f8"+
		"\u00fa\5$\23\2\u00f9\u00f4\3\2\2\2\u00f9\u00f5\3\2\2\2\u00f9\u00f6\3\2"+
		"\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\33\3\2\2\2\u00fb\u00fc"+
		"\7C\2\2\u00fc\u00fd\5\n\6\2\u00fd\35\3\2\2\2\u00fe\u00ff\7C\2\2\u00ff"+
		"\u0100\5\20\t\2\u0100\37\3\2\2\2\u0101\u0102\7C\2\2\u0102\u0103\5\16\b"+
		"\2\u0103!\3\2\2\2\u0104\u0105\7C\2\2\u0105\u0106\7H\2\2\u0106\u0107\7"+
		"L\2\2\u0107\u0108\7\3\2\2\u0108#\3\2\2\2\u0109\u010a\7B\2\2\u010a\u010b"+
		"\5F$\2\u010b\u010c\7\3\2\2\u010c%\3\2\2\2\u010d\u010e\7(\2\2\u010e\u010f"+
		"\7L\2\2\u010f\u0113\7\3\2\2\u0110\u0112\5(\25\2\u0111\u0110\3\2\2\2\u0112"+
		"\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\3\2"+
		"\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7)\2\2\u0117\'\3\2\2\2\u0118\u011b"+
		"\5*\26\2\u0119\u011b\5,\27\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b"+
		")\3\2\2\2\u011c\u011d\7/\2\2\u011d\u011e\5F$\2\u011e\u011f\7\3\2\2\u011f"+
		"+\3\2\2\2\u0120\u0121\5\u008eH\2\u0121\u0122\5\u0090I\2\u0122\u0123\5"+
		":\36\2\u0123\u0124\7\3\2\2\u0124-\3\2\2\2\u0125\u0126\7*\2\2\u0126\u0127"+
		"\7L\2\2\u0127\u012b\7\3\2\2\u0128\u012a\5\60\31\2\u0129\u0128\3\2\2\2"+
		"\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e"+
		"\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7+\2\2\u012f/\3\2\2\2\u0130\u0131"+
		"\5H%\2\u0131\u0132\7\3\2\2\u0132\61\3\2\2\2\u0133\u0134\5\64\33\2\u0134"+
		"\u0135\7\3\2\2\u0135\63\3\2\2\2\u0136\u0137\7K\2\2\u0137\u0138\5\66\34"+
		"\2\u0138\u013c\7\4\2\2\u0139\u013b\58\35\2\u013a\u0139\3\2\2\2\u013b\u013e"+
		"\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013f\u0140\7\5\2\2\u0140\65\3\2\2\2\u0141\u0142\7L\2\2"+
		"\u0142\u0143\7\6\2\2\u0143\u0144\7L\2\2\u0144\67\3\2\2\2\u0145\u0146\7"+
		"L\2\2\u0146\u0147\7\7\2\2\u0147\u0148\7L\2\2\u0148\u0149\7\3\2\2\u0149"+
		"9\3\2\2\2\u014a\u014b\5^\60\2\u014b\u014c\7\6\2\2\u014c\u014d\5\u0082"+
		"B\2\u014d\u0150\3\2\2\2\u014e\u014f\7\b\2\2\u014f\u0151\5J&\2\u0150\u014e"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151;\3\2\2\2\u0152\u0155\5`\61\2\u0153"+
		"\u0154\7\b\2\2\u0154\u0156\5J&\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2"+
		"\2\u0156=\3\2\2\2\u0157\u0158\5b\62\2\u0158\u0159\7\6\2\2\u0159\u015a"+
		"\7G\2\2\u015a?\3\2\2\2\u015b\u015c\5d\63\2\u015c\u015d\7\b\2\2\u015d\u015e"+
		"\5R*\2\u015eA\3\2\2\2\u015f\u0160\5\u0094K\2\u0160\u0161\5f\64\2\u0161"+
		"C\3\2\2\2\u0162\u0163\5h\65\2\u0163E\3\2\2\2\u0164\u0165\5j\66\2\u0165"+
		"\u0166\7\t\2\2\u0166\u0167\5\\/\2\u0167G\3\2\2\2\u0168\u0169\7\60\2\2"+
		"\u0169\u016a\5p9\2\u016a\u016b\t\3\2\2\u016b\u016c\5\u0096L\2\u016c\u016d"+
		"\7L\2\2\u016dI\3\2\2\2\u016e\u0173\5R*\2\u016f\u0173\5N(\2\u0170\u0173"+
		"\5L\'\2\u0171\u0173\5\u0096L\2\u0172\u016e\3\2\2\2\u0172\u016f\3\2\2\2"+
		"\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173K\3\2\2\2\u0174\u0175\7"+
		"\f\2\2\u0175\u017a\5N(\2\u0176\u0177\7\r\2\2\u0177\u0179\5N(\2\u0178\u0176"+
		"\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017d\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\7\16\2\2\u017eM\3\2\2\2"+
		"\u017f\u0180\7\17\2\2\u0180\u0185\5P)\2\u0181\u0182\7\r\2\2\u0182\u0184"+
		"\5P)\2\u0183\u0181\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7\20"+
		"\2\2\u0189O\3\2\2\2\u018a\u018b\5\u0096L\2\u018bQ\3\2\2\2\u018c\u018d"+
		"\7\f\2\2\u018d\u0192\5T+\2\u018e\u018f\7\r\2\2\u018f\u0191\5T+\2\u0190"+
		"\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2"+
		"\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0196\7\16\2\2\u0196"+
		"S\3\2\2\2\u0197\u019b\7O\2\2\u0198\u019b\7N\2\2\u0199\u019b\7L\2\2\u019a"+
		"\u0197\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u0199\3\2\2\2\u019bU\3\2\2\2"+
		"\u019c\u019d\7\f\2\2\u019d\u01a2\5X-\2\u019e\u019f\7\r\2\2\u019f\u01a1"+
		"\5X-\2\u01a0\u019e\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\7\16"+
		"\2\2\u01a6W\3\2\2\2\u01a7\u01a8\7\17\2\2\u01a8\u01ad\5Z.\2\u01a9\u01aa"+
		"\7\r\2\2\u01aa\u01ac\5Z.\2\u01ab\u01a9\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af\u01ad\3\2"+
		"\2\2\u01b0\u01b1\7\20\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b4\5\u0096L\2\u01b3"+
		"\u01a7\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4Y\3\2\2\2\u01b5\u01b8\5\u0096"+
		"L\2\u01b6\u01b8\5R*\2\u01b7\u01b5\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8[\3"+
		"\2\2\2\u01b9\u01bf\5R*\2\u01ba\u01bf\5N(\2\u01bb\u01bf\5\u0096L\2\u01bc"+
		"\u01bf\5L\'\2\u01bd\u01bf\5V,\2\u01be\u01b9\3\2\2\2\u01be\u01ba\3\2\2"+
		"\2\u01be\u01bb\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bd\3\2\2\2\u01bf]"+
		"\3\2\2\2\u01c0\u01c2\7L\2\2\u01c1\u01c3\5\u0084C\2\u01c2\u01c1\3\2\2\2"+
		"\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c6\5t;\2\u01c5\u01c4"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01cc\3\2\2\2\u01c7\u01c8\7L\2\2\u01c8"+
		"\u01c9\5v<\2\u01c9\u01ca\5t;\2\u01ca\u01cc\3\2\2\2\u01cb\u01c0\3\2\2\2"+
		"\u01cb\u01c7\3\2\2\2\u01cc_\3\2\2\2\u01cd\u01ce\7L\2\2\u01ce\u01cf\5v"+
		"<\2\u01cfa\3\2\2\2\u01d0\u01d1\7L\2\2\u01d1c\3\2\2\2\u01d2\u01d3\7L\2"+
		"\2\u01d3e\3\2\2\2\u01d4\u01d7\7L\2\2\u01d5\u01d8\5\u0084C\2\u01d6\u01d8"+
		"\5v<\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"g\3\2\2\2\u01d9\u01db\7L\2\2\u01da\u01dc\5\u0084C\2\u01db\u01da\3\2\2"+
		"\2\u01db\u01dc\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01df\5t;\2\u01de\u01dd"+
		"\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e6\3\2\2\2\u01e0\u01e1\7L\2\2\u01e1"+
		"\u01e3\5v<\2\u01e2\u01e4\5t;\2\u01e3\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2"+
		"\u01e4\u01e6\3\2\2\2\u01e5\u01d9\3\2\2\2\u01e5\u01e0\3\2\2\2\u01e6i\3"+
		"\2\2\2\u01e7\u01ea\5l\67\2\u01e8\u01eb\5\u0086D\2\u01e9\u01eb\5v<\2\u01ea"+
		"\u01e8\3\2\2\2\u01ea\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ed\3\2"+
		"\2\2\u01ec\u01ee\5z>\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01f0"+
		"\3\2\2\2\u01ef\u01f1\5t;\2\u01f0\u01ef\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01f3\3\2\2\2\u01f2\u01f4\5x=\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4\3\2\2"+
		"\2\u01f4k\3\2\2\2\u01f5\u01f6\b\67\1\2\u01f6\u01f9\7L\2\2\u01f7\u01f9"+
		"\7?\2\2\u01f8\u01f5\3\2\2\2\u01f8\u01f7\3\2\2\2\u01f9\u01fe\3\2\2\2\u01fa"+
		"\u01fb\f\4\2\2\u01fb\u01fd\5z>\2\u01fc\u01fa\3\2\2\2\u01fd\u0200\3\2\2"+
		"\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ffm\3\2\2\2\u0200\u01fe"+
		"\3\2\2\2\u0201\u0202\5l\67\2\u0202\u0203\5v<\2\u0203o\3\2\2\2\u0204\u0205"+
		"\5l\67\2\u0205\u0206\5t;\2\u0206q\3\2\2\2\u0207\u020c\5l\67\2\u0208\u020c"+
		"\5n8\2\u0209\u020c\5p9\2\u020a\u020c\5|?\2\u020b\u0207\3\2\2\2\u020b\u0208"+
		"\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020a\3\2\2\2\u020cs\3\2\2\2\u020d"+
		"\u020e\7\21\2\2\u020e\u020f\7L\2\2\u020fu\3\2\2\2\u0210\u0211\7\17\2\2"+
		"\u0211\u0212\7L\2\2\u0212\u0213\7\20\2\2\u0213w\3\2\2\2\u0214\u0215\7"+
		"\17\2\2\u0215\u0216\t\4\2\2\u0216\u0217\7\20\2\2\u0217\u0218\7\17\2\2"+
		"\u0218\u0219\7L\2\2\u0219\u021a\7\20\2\2\u021ay\3\2\2\2\u021b\u021c\7"+
		"\23\2\2\u021c\u021d\7L\2\2\u021d{\3\2\2\2\u021e\u021f\5p9\2\u021f\u0222"+
		"\7\17\2\2\u0220\u0223\7\22\2\2\u0221\u0223\7L\2\2\u0222\u0220\3\2\2\2"+
		"\u0222\u0221\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u0225\7\20\2\2\u0225\u0226"+
		"\7\17\2\2\u0226\u0227\7L\2\2\u0227\u0228\7\20\2\2\u0228}\3\2\2\2\u0229"+
		"\u022a\7.\2\2\u022a\u022f\7L\2\2\u022b\u022c\7\r\2\2\u022c\u022e\7L\2"+
		"\2\u022d\u022b\3\2\2\2\u022e\u0231\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230"+
		"\3\2\2\2\u0230\177\3\2\2\2\u0231\u022f\3\2\2\2\u0232\u0233\7D\2\2\u0233"+
		"\u0238\7L\2\2\u0234\u0235\7\r\2\2\u0235\u0237\7L\2\2\u0236\u0234\3\2\2"+
		"\2\u0237\u023a\3\2\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u0081"+
		"\3\2\2\2\u023a\u0238\3\2\2\2\u023b\u0243\7\65\2\2\u023c\u0243\7\66\2\2"+
		"\u023d\u0243\7\67\2\2\u023e\u0243\79\2\2\u023f\u0243\7:\2\2\u0240\u0243"+
		"\7L\2\2\u0241\u0243\5\u0092J\2\u0242\u023b\3\2\2\2\u0242\u023c\3\2\2\2"+
		"\u0242\u023d\3\2\2\2\u0242\u023e\3\2\2\2\u0242\u023f\3\2\2\2\u0242\u0240"+
		"\3\2\2\2\u0242\u0241\3\2\2\2\u0243\u0083\3\2\2\2\u0244\u0247\5\u0088E"+
		"\2\u0245\u0247\5\u008aF\2\u0246\u0244\3\2\2\2\u0246\u0245\3\2\2\2\u0247"+
		"\u0085\3\2\2\2\u0248\u024b\5\u008cG\2\u0249\u024b\5\u0088E\2\u024a\u0248"+
		"\3\2\2\2\u024a\u0249\3\2\2\2\u024b\u0087\3\2\2\2\u024c\u024d\7\17\2\2"+
		"\u024d\u024e\7\20\2\2\u024e\u0089\3\2\2\2\u024f\u0250\7\17\2\2\u0250\u0251"+
		"\5\u0096L\2\u0251\u0252\7\6\2\2\u0252\u0253\5\u0096L\2\u0253\u0254\7\20"+
		"\2\2\u0254\u008b\3\2\2\2\u0255\u0256\7\17\2\2\u0256\u0257\5\u0096L\2\u0257"+
		"\u0258\7\24\2\2\u0258\u0259\5\u0096L\2\u0259\u025a\7\20\2\2\u025a\u008d"+
		"\3\2\2\2\u025b\u025c\t\5\2\2\u025c\u008f\3\2\2\2\u025d\u025e\t\6\2\2\u025e"+
		"\u0091\3\2\2\2\u025f\u0260\78\2\2\u0260\u0261\7\f\2\2\u0261\u0266\7L\2"+
		"\2\u0262\u0263\7\r\2\2\u0263\u0265\7L\2\2\u0264\u0262\3\2\2\2\u0265\u0268"+
		"\3\2\2\2\u0266\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2\2\2\u0268"+
		"\u0266\3\2\2\2\u0269\u026a\7\16\2\2\u026a\u0093\3\2\2\2\u026b\u026c\7"+
		"L\2\2\u026c\u0095\3\2\2\2\u026d\u026e\bL\1\2\u026e\u0274\5\u0098M\2\u026f"+
		"\u0270\t\7\2\2\u0270\u0274\5\u0096L\17\u0271\u0272\t\b\2\2\u0272\u0274"+
		"\5\u0096L\16\u0273\u026d\3\2\2\2\u0273\u026f\3\2\2\2\u0273\u0271\3\2\2"+
		"\2\u0274\u029b\3\2\2\2\u0275\u0276\f\r\2\2\u0276\u0277\t\t\2\2\u0277\u029a"+
		"\5\u0096L\16\u0278\u0279\f\f\2\2\u0279\u027a\t\7\2\2\u027a\u029a\5\u0096"+
		"L\r\u027b\u027c\f\13\2\2\u027c\u027d\t\n\2\2\u027d\u029a\5\u0096L\f\u027e"+
		"\u027f\f\n\2\2\u027f\u0280\t\13\2\2\u0280\u029a\5\u0096L\13\u0281\u0282"+
		"\f\t\2\2\u0282\u0283\7 \2\2\u0283\u029a\5\u0096L\n\u0284\u0285\f\b\2\2"+
		"\u0285\u0286\7!\2\2\u0286\u029a\5\u0096L\t\u0287\u0288\f\7\2\2\u0288\u0289"+
		"\7\"\2\2\u0289\u029a\5\u0096L\b\u028a\u028b\f\6\2\2\u028b\u028c\7#\2\2"+
		"\u028c\u029a\5\u0096L\7\u028d\u028e\f\5\2\2\u028e\u028f\7$\2\2\u028f\u029a"+
		"\5\u0096L\6\u0290\u0291\f\4\2\2\u0291\u0292\7%\2\2\u0292\u0293\5\u0096"+
		"L\2\u0293\u0294\7\6\2\2\u0294\u0295\5\u0096L\5\u0295\u029a\3\2\2\2\u0296"+
		"\u0297\f\3\2\2\u0297\u0298\7\t\2\2\u0298\u029a\5\u0096L\3\u0299\u0275"+
		"\3\2\2\2\u0299\u0278\3\2\2\2\u0299\u027b\3\2\2\2\u0299\u027e\3\2\2\2\u0299"+
		"\u0281\3\2\2\2\u0299\u0284\3\2\2\2\u0299\u0287\3\2\2\2\u0299\u028a\3\2"+
		"\2\2\u0299\u028d\3\2\2\2\u0299\u0290\3\2\2\2\u0299\u0296\3\2\2\2\u029a"+
		"\u029d\3\2\2\2\u029b\u0299\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u0097\3\2"+
		"\2\2\u029d\u029b\3\2\2\2\u029e\u029f\7\4\2\2\u029f\u02a0\5\u0096L\2\u02a0"+
		"\u02a1\7\5\2\2\u02a1\u02aa\3\2\2\2\u02a2\u02aa\7E\2\2\u02a3\u02aa\7I\2"+
		"\2\u02a4\u02aa\7J\2\2\u02a5\u02aa\5j\66\2\u02a6\u02aa\5\u00a0Q\2\u02a7"+
		"\u02aa\5\u009aN\2\u02a8\u02aa\5N(\2\u02a9\u029e\3\2\2\2\u02a9\u02a2\3"+
		"\2\2\2\u02a9\u02a3\3\2\2\2\u02a9\u02a4\3\2\2\2\u02a9\u02a5\3\2\2\2\u02a9"+
		"\u02a6\3\2\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02a8\3\2\2\2\u02aa\u0099\3\2"+
		"\2\2\u02ab\u02ac\5\u009cO\2\u02ac\u02ad\7\4\2\2\u02ad\u02b0\5\u009eP\2"+
		"\u02ae\u02af\7\r\2\2\u02af\u02b1\5\u009eP\2\u02b0\u02ae\3\2\2\2\u02b0"+
		"\u02b1\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3\7\5\2\2\u02b3\u009b\3\2"+
		"\2\2\u02b4\u02b5\t\f\2\2\u02b5\u009d\3\2\2\2\u02b6\u02b7\5j\66\2\u02b7"+
		"\u02b8\5\u008aF\2\u02b8\u02bb\3\2\2\2\u02b9\u02bb\5\u0096L\2\u02ba\u02b6"+
		"\3\2\2\2\u02ba\u02b9\3\2\2\2\u02bb\u009f\3\2\2\2\u02bc\u02c0\7M\2\2\u02bd"+
		"\u02c0\7O\2\2\u02be\u02c0\7N\2\2\u02bf\u02bc\3\2\2\2\u02bf\u02bd\3\2\2"+
		"\2\u02bf\u02be\3\2\2\2\u02c0\u00a1\3\2\2\29\u00a5\u00ae\u00b3\u00b6\u00bc"+
		"\u00c6\u00d0\u00e9\u00ef\u00f9\u0113\u011a\u012b\u013c\u0150\u0155\u0172"+
		"\u017a\u0185\u0192\u019a\u01a2\u01ad\u01b3\u01b7\u01be\u01c2\u01c5\u01cb"+
		"\u01d7\u01db\u01de\u01e3\u01e5\u01ea\u01ed\u01f0\u01f3\u01f8\u01fe\u020b"+
		"\u0222\u022f\u0238\u0242\u0246\u024a\u0266\u0273\u0299\u029b\u02a9\u02b0"+
		"\u02ba\u02bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}