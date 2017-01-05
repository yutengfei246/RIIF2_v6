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
		T__31=32, T__32=33, T__33=34, COMPONENT=35, END_COMPONENT=36, ENVIRONMENT=37, 
		END_ENVIRONMENT=38, REQUIREMENT=39, END_REQUIREMENT=40, CHILD_COMPONENT=41, 
		FAIL_MODE=42, EXTENDS=43, ASSIGN=44, ASSERT=45, INPUT=46, OUTPUT=47, PARAMETER=48, 
		CONSTANT=49, TYPE_FLOAT=50, TYPE_INTEGER=51, TYPE_STRING=52, TYPE_ENUM=53, 
		TYPE_BOOLEAN=54, TYPE_TIME=55, FUNC_AGG_SINGLE=56, FUNC_GT_N_FAIL=57, 
		FUNC_LOG=58, FUNC_EXP=59, TEMPLATE=60, END_TEMPLATE=61, IMPOSE=62, ABSTRACT=63, 
		IMPLEMENTS=64, SELF=65, SET=66, TYPE_TABLE=67, PLATFORM=68, TRUE=69, FALSE=70, 
		Identifier=71, StringLiteral=72, FloatingPointLiteral=73, DecimalLiteral=74, 
		WS=75, COMMENT=76, LINE_COMMENT=77;
	public static final int
		RULE_program = 0, RULE_typeDeclaration = 1, RULE_componentDeclaration = 2, 
		RULE_componentBodyElement = 3, RULE_fieldDeclaration = 4, RULE_fieldDeclaratorType = 5, 
		RULE_childComponentDeclaration = 6, RULE_failModeDeclaration = 7, RULE_assignmentDeclaration = 8, 
		RULE_setDeclaration = 9, RULE_aisDeclaration = 10, RULE_assertion = 11, 
		RULE_templateDeclaration = 12, RULE_templateBodyElement = 13, RULE_abstractFieldDeclaration = 14, 
		RULE_abstractFailModeDeclaration = 15, RULE_abstractChildComponentDeclaration = 16, 
		RULE_abstractPlatformDeclaration = 17, RULE_imposeDeclaration = 18, RULE_environmentDeclaration = 19, 
		RULE_environmentBodyElement = 20, RULE_assignment = 21, RULE_envParameterDeclaration = 22, 
		RULE_requirementDeclaration = 23, RULE_primitiveFieldDeclarator = 24, 
		RULE_associativeIndexDeclarator = 25, RULE_tableFieldDeclarator = 26, 
		RULE_listFieldDeclarator = 27, RULE_childComponentDeclarator = 28, RULE_failModeDeclarator = 29, 
		RULE_aisDeclarator = 30, RULE_fieldInitializer = 31, RULE_arrayInitializerWrapper = 32, 
		RULE_arrayInitializer = 33, RULE_arrayItem = 34, RULE_listInitializer = 35, 
		RULE_listItem = 36, RULE_tableItemInitializer = 37, RULE_row = 38, RULE_rowItem = 39, 
		RULE_aisInitializer = 40, RULE_primitiveFieldDeclaratorId = 41, RULE_associativeIndexDeclaratorId = 42, 
		RULE_tableFieldDeclaratorId = 43, RULE_listFieldDeclaratorId = 44, RULE_childComponentDeclaratorId = 45, 
		RULE_failModeDeclaratorId = 46, RULE_aisDeclaratorId = 47, RULE_primitiveId = 48, 
		RULE_associativeId = 49, RULE_attributeId = 50, RULE_variableId = 51, 
		RULE_attributeIndex = 52, RULE_associativeIndex = 53, RULE_hierPostfix = 54, 
		RULE_tableId = 55, RULE_extendsList = 56, RULE_implementsList = 57, RULE_primitiveType = 58, 
		RULE_typeType = 59, RULE_aisType = 60, RULE_associativeType = 61, RULE_vector = 62, 
		RULE_flatVector = 63, RULE_fieldType = 64, RULE_enumType = 65, RULE_childComponentType = 66, 
		RULE_expression = 67, RULE_primary = 68, RULE_funcCall = 69, RULE_funcName = 70, 
		RULE_funcArg = 71, RULE_literal = 72;
	public static final String[] ruleNames = {
		"program", "typeDeclaration", "componentDeclaration", "componentBodyElement", 
		"fieldDeclaration", "fieldDeclaratorType", "childComponentDeclaration", 
		"failModeDeclaration", "assignmentDeclaration", "setDeclaration", "aisDeclaration", 
		"assertion", "templateDeclaration", "templateBodyElement", "abstractFieldDeclaration", 
		"abstractFailModeDeclaration", "abstractChildComponentDeclaration", "abstractPlatformDeclaration", 
		"imposeDeclaration", "environmentDeclaration", "environmentBodyElement", 
		"assignment", "envParameterDeclaration", "requirementDeclaration", "primitiveFieldDeclarator", 
		"associativeIndexDeclarator", "tableFieldDeclarator", "listFieldDeclarator", 
		"childComponentDeclarator", "failModeDeclarator", "aisDeclarator", "fieldInitializer", 
		"arrayInitializerWrapper", "arrayInitializer", "arrayItem", "listInitializer", 
		"listItem", "tableItemInitializer", "row", "rowItem", "aisInitializer", 
		"primitiveFieldDeclaratorId", "associativeIndexDeclaratorId", "tableFieldDeclaratorId", 
		"listFieldDeclaratorId", "childComponentDeclaratorId", "failModeDeclaratorId", 
		"aisDeclaratorId", "primitiveId", "associativeId", "attributeId", "variableId", 
		"attributeIndex", "associativeIndex", "hierPostfix", "tableId", "extendsList", 
		"implementsList", "primitiveType", "typeType", "aisType", "associativeType", 
		"vector", "flatVector", "fieldType", "enumType", "childComponentType", 
		"expression", "primary", "funcCall", "funcName", "funcArg", "literal"
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
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(146);
				typeDeclaration();
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPONENT) | (1L << ENVIRONMENT) | (1L << REQUIREMENT) | (1L << TEMPLATE))) != 0) );
			setState(151);
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
			setState(157);
			switch (_input.LA(1)) {
			case COMPONENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				componentDeclaration();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				templateDeclaration();
				}
				break;
			case ENVIRONMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				environmentDeclaration();
				}
				break;
			case REQUIREMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				requirementDeclaration();
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
			setState(159);
			match(COMPONENT);
			setState(160);
			match(Identifier);
			setState(162);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(161);
				extendsList();
				}
			}

			setState(165);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(164);
				implementsList();
				}
			}

			setState(167);
			match(T__0);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & ((1L << (CHILD_COMPONENT - 41)) | (1L << (FAIL_MODE - 41)) | (1L << (ASSIGN - 41)) | (1L << (ASSERT - 41)) | (1L << (PARAMETER - 41)) | (1L << (CONSTANT - 41)) | (1L << (SET - 41)))) != 0)) {
				{
				{
				setState(168);
				componentBodyElement();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
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
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
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
			setState(182);
			switch (_input.LA(1)) {
			case PARAMETER:
			case CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				fieldDeclaration();
				}
				break;
			case CHILD_COMPONENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				childComponentDeclaration();
				}
				break;
			case FAIL_MODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				failModeDeclaration();
				}
				break;
			case ASSIGN:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				assignmentDeclaration();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				setDeclaration();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				assertion();
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
			setState(184);
			fieldType();
			setState(185);
			fieldDeclaratorType();
			setState(186);
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
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				primitiveFieldDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				associativeIndexDeclarator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				tableFieldDeclarator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(191);
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
			setState(194);
			match(CHILD_COMPONENT);
			setState(195);
			childComponentDeclarator();
			setState(196);
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
			setState(198);
			match(FAIL_MODE);
			setState(199);
			failModeDeclarator();
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
			setState(202);
			match(ASSIGN);
			setState(203);
			aisDeclarator();
			setState(204);
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
			setState(206);
			match(SET);
			setState(207);
			aisDeclarator();
			setState(208);
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
			setState(210);
			_la = _input.LA(1);
			if ( !(((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (ASSIGN - 44)) | (1L << (IMPOSE - 44)) | (1L << (SET - 44)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(211);
			aisDeclarator();
			setState(212);
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

	public static class AssertionContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(RIIF2Parser.ASSERT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AttributeIdContext attributeId() {
			return getRuleContext(AttributeIdContext.class,0);
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
		enterRule(_localctx, 22, RULE_assertion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(ASSERT);
			{
			setState(215);
			attributeId();
			}
			setState(216);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(217);
			expression(0);
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
		enterRule(_localctx, 24, RULE_templateDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(TEMPLATE);
			setState(221);
			match(Identifier);
			setState(223);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(222);
				extendsList();
				}
			}

			setState(225);
			match(T__0);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPOSE || _la==ABSTRACT) {
				{
				{
				setState(226);
				templateBodyElement();
				}
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(232);
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
		enterRule(_localctx, 26, RULE_templateBodyElement);
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				abstractFieldDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				abstractFailModeDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				abstractChildComponentDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				abstractPlatformDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(238);
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
		enterRule(_localctx, 28, RULE_abstractFieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(ABSTRACT);
			setState(242);
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
		enterRule(_localctx, 30, RULE_abstractFailModeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(ABSTRACT);
			setState(245);
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
		enterRule(_localctx, 32, RULE_abstractChildComponentDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(ABSTRACT);
			setState(248);
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
		enterRule(_localctx, 34, RULE_abstractPlatformDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(ABSTRACT);
			setState(251);
			match(PLATFORM);
			setState(252);
			match(Identifier);
			setState(253);
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
		enterRule(_localctx, 36, RULE_imposeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(IMPOSE);
			setState(256);
			aisDeclarator();
			setState(257);
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
		enterRule(_localctx, 38, RULE_environmentDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(ENVIRONMENT);
			setState(260);
			match(Identifier);
			setState(261);
			match(T__0);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << INPUT) | (1L << OUTPUT))) != 0)) {
				{
				{
				setState(262);
				environmentBodyElement();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
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
		enterRule(_localctx, 40, RULE_environmentBodyElement);
		try {
			setState(272);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				assignment();
				}
				break;
			case INPUT:
			case OUTPUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
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
		enterRule(_localctx, 42, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(ASSIGN);
			setState(275);
			aisDeclarator();
			setState(276);
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
		public TerminalNode PARAMETER() { return getToken(RIIF2Parser.PARAMETER, 0); }
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode INPUT() { return getToken(RIIF2Parser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(RIIF2Parser.OUTPUT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 44, RULE_envParameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !(_la==INPUT || _la==OUTPUT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(279);
			match(PARAMETER);
			setState(280);
			variableId();
			setState(281);
			match(T__3);
			setState(282);
			primitiveType();
			setState(285);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(283);
				match(T__4);
				setState(284);
				expression(0);
				}
			}

			setState(287);
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
		enterRule(_localctx, 46, RULE_requirementDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(REQUIREMENT);
			setState(290);
			match(Identifier);
			setState(291);
			match(T__0);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ASSERT) {
				{
				{
				setState(292);
				assertion();
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
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
		enterRule(_localctx, 48, RULE_primitiveFieldDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			primitiveFieldDeclaratorId();
			{
			setState(301);
			match(T__3);
			setState(302);
			primitiveType();
			}
			setState(306);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(304);
				match(T__4);
				setState(305);
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
		enterRule(_localctx, 50, RULE_associativeIndexDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			associativeIndexDeclaratorId();
			setState(311);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(309);
				match(T__4);
				setState(310);
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
		enterRule(_localctx, 52, RULE_tableFieldDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			tableFieldDeclaratorId();
			setState(314);
			match(T__3);
			setState(315);
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
		enterRule(_localctx, 54, RULE_listFieldDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			listFieldDeclaratorId();
			setState(318);
			match(T__4);
			setState(319);
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
		enterRule(_localctx, 56, RULE_childComponentDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			childComponentType();
			setState(322);
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
		enterRule(_localctx, 58, RULE_failModeDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
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
		public AisTypeContext aisType() {
			return getRuleContext(AisTypeContext.class,0);
		}
		public AssociativeIndexContext associativeIndex() {
			return getRuleContext(AssociativeIndexContext.class,0);
		}
		public AttributeIndexContext attributeIndex() {
			return getRuleContext(AttributeIndexContext.class,0);
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
		enterRule(_localctx, 60, RULE_aisDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			aisDeclaratorId();
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(327);
				aisType();
				}
				break;
			case 2:
				{
				setState(328);
				associativeIndex();
				}
				break;
			}
			setState(332);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(331);
				attributeIndex();
				}
			}

			setState(334);
			match(T__5);
			setState(335);
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
		enterRule(_localctx, 62, RULE_fieldInitializer);
		try {
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				listInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				arrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(339);
				arrayInitializerWrapper();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(340);
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
		enterRule(_localctx, 64, RULE_arrayInitializerWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(T__6);
			setState(344);
			arrayInitializer();
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(345);
				match(T__7);
				setState(346);
				arrayInitializer();
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
			match(T__8);
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
		enterRule(_localctx, 66, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(T__9);
			setState(355);
			arrayItem();
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(356);
				match(T__7);
				setState(357);
				arrayItem();
				}
				}
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(363);
			match(T__10);
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
		enterRule(_localctx, 68, RULE_arrayItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
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
		enterRule(_localctx, 70, RULE_listInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(T__6);
			setState(368);
			listItem();
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(369);
				match(T__7);
				setState(370);
				listItem();
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(376);
			match(T__8);
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
		enterRule(_localctx, 72, RULE_listItem);
		try {
			setState(381);
			switch (_input.LA(1)) {
			case DecimalLiteral:
				_localctx = new ListItemDecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(378);
				match(DecimalLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new ListItemFloatingPointLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				match(FloatingPointLiteral);
				}
				break;
			case Identifier:
				_localctx = new ListItemIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
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
		enterRule(_localctx, 74, RULE_tableItemInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(T__6);
			setState(384);
			row();
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(385);
				match(T__7);
				setState(386);
				row();
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(392);
			match(T__8);
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
		enterRule(_localctx, 76, RULE_row);
		int _la;
		try {
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new RowArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				match(T__9);
				setState(395);
				rowItem();
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(396);
					match(T__7);
					setState(397);
					rowItem();
					}
					}
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(403);
				match(T__10);
				}
				break;
			case 2:
				_localctx = new RowExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
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
		enterRule(_localctx, 78, RULE_rowItem);
		try {
			setState(410);
			switch (_input.LA(1)) {
			case T__9:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__32:
			case FUNC_AGG_SINGLE:
			case FUNC_GT_N_FAIL:
			case FUNC_LOG:
			case FUNC_EXP:
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
				setState(408);
				expression(0);
				}
				break;
			case T__6:
				_localctx = new RowItemListInitializerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
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
		enterRule(_localctx, 80, RULE_aisInitializer);
		try {
			setState(416);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(412);
				listInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(414);
				arrayInitializerWrapper();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(415);
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
		enterRule(_localctx, 82, RULE_primitiveFieldDeclaratorId);
		int _la;
		try {
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new PrimitiveFieldDeclaratorId1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				match(Identifier);
				setState(420);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(419);
					typeType();
					}
				}

				setState(423);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(422);
					attributeIndex();
					}
				}

				}
				break;
			case 2:
				_localctx = new PrimitiveFieldDeclaratorId2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
				match(Identifier);
				setState(426);
				associativeIndex();
				setState(427);
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
		enterRule(_localctx, 84, RULE_associativeIndexDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(Identifier);
			setState(432);
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
		enterRule(_localctx, 86, RULE_tableFieldDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
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
		enterRule(_localctx, 88, RULE_listFieldDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
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
		enterRule(_localctx, 90, RULE_childComponentDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(Identifier);
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(439);
				typeType();
				}
				break;
			case 2:
				{
				setState(440);
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
		enterRule(_localctx, 92, RULE_failModeDeclaratorId);
		int _la;
		try {
			setState(455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new FailModeDeclaratorId1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				match(Identifier);
				setState(445);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(444);
					typeType();
					}
				}

				setState(448);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(447);
					attributeIndex();
					}
				}

				}
				break;
			case 2:
				_localctx = new FailModeDeclaratorId2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				match(Identifier);
				setState(451);
				associativeIndex();
				setState(453);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(452);
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
		public AisDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aisDeclaratorId; }
	 
		public AisDeclaratorIdContext() { }
		public void copyFrom(AisDeclaratorIdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AisDeclaratorId2Context extends AisDeclaratorIdContext {
		public TableIdContext tableId() {
			return getRuleContext(TableIdContext.class,0);
		}
		public AisDeclaratorId2Context(AisDeclaratorIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAisDeclaratorId2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAisDeclaratorId2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAisDeclaratorId2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AisDeclaratorId1Context extends AisDeclaratorIdContext {
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
		public AisDeclaratorId1Context(AisDeclaratorIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAisDeclaratorId1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAisDeclaratorId1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAisDeclaratorId1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AisDeclaratorIdContext aisDeclaratorId() throws RecognitionException {
		AisDeclaratorIdContext _localctx = new AisDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_aisDeclaratorId);
		int _la;
		try {
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new AisDeclaratorId1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				primitiveId(0);
				setState(460);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(458);
					aisType();
					}
					break;
				case 2:
					{
					setState(459);
					associativeIndex();
					}
					break;
				}
				setState(463);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(462);
					hierPostfix();
					}
				}

				setState(466);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(465);
					attributeIndex();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new AisDeclaratorId2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
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

	public final PrimitiveIdContext primitiveId() throws RecognitionException {
		return primitiveId(0);
	}

	private PrimitiveIdContext primitiveId(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimitiveIdContext _localctx = new PrimitiveIdContext(_ctx, _parentState);
		PrimitiveIdContext _prevctx = _localctx;
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_primitiveId, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimitiveIdIdentifierContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(472);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(478);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrimitiveIdIdContext(new PrimitiveIdContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_primitiveId);
					setState(474);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(475);
					hierPostfix();
					}
					}
					} 
				}
				setState(480);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
		enterRule(_localctx, 98, RULE_associativeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			primitiveId(0);
			setState(482);
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
	public static class AttributeAssociativeIdIndexContext extends AttributeIdContext {
		public AssociativeIdContext associativeId() {
			return getRuleContext(AssociativeIdContext.class,0);
		}
		public AttributeIndexContext attributeIndex() {
			return getRuleContext(AttributeIndexContext.class,0);
		}
		public AttributeAssociativeIdIndexContext(AttributeIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterAttributeAssociativeIdIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitAttributeAssociativeIdIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitAttributeAssociativeIdIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeIdContext attributeId() throws RecognitionException {
		AttributeIdContext _localctx = new AttributeIdContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_attributeId);
		try {
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new AttributePrimitiveIdIndexContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				primitiveId(0);
				setState(485);
				attributeIndex();
				}
				break;
			case 2:
				_localctx = new AttributeAssociativeIdIndexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				associativeId();
				setState(488);
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
		enterRule(_localctx, 102, RULE_variableId);
		try {
			setState(496);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				primitiveId(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				associativeId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(494);
				attributeId();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(495);
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
		enterRule(_localctx, 104, RULE_attributeIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(T__11);
			setState(499);
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
		enterRule(_localctx, 106, RULE_associativeIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(T__9);
			setState(502);
			match(Identifier);
			setState(503);
			match(T__10);
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
		enterRule(_localctx, 108, RULE_hierPostfix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(T__12);
			setState(506);
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
		enterRule(_localctx, 110, RULE_tableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			attributeId();
			setState(509);
			match(T__9);
			setState(512);
			switch (_input.LA(1)) {
			case T__13:
				{
				setState(510);
				((TableIdContext)_localctx).op = match(T__13);
				}
				break;
			case Identifier:
				{
				setState(511);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(514);
			match(T__10);
			setState(515);
			match(T__9);
			setState(516);
			match(Identifier);
			setState(517);
			match(T__10);
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
		enterRule(_localctx, 112, RULE_extendsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			match(EXTENDS);
			setState(520);
			match(Identifier);
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(521);
				match(T__7);
				setState(522);
				match(Identifier);
				}
				}
				setState(527);
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
		enterRule(_localctx, 114, RULE_implementsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			match(IMPLEMENTS);
			setState(529);
			match(Identifier);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(530);
				match(T__7);
				setState(531);
				match(Identifier);
				}
				}
				setState(536);
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
		enterRule(_localctx, 116, RULE_primitiveType);
		try {
			setState(544);
			switch (_input.LA(1)) {
			case TYPE_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(537);
				match(TYPE_FLOAT);
				}
				break;
			case TYPE_INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(538);
				match(TYPE_INTEGER);
				}
				break;
			case TYPE_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(539);
				match(TYPE_STRING);
				}
				break;
			case TYPE_BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(540);
				match(TYPE_BOOLEAN);
				}
				break;
			case TYPE_TIME:
				enterOuterAlt(_localctx, 5);
				{
				setState(541);
				match(TYPE_TIME);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 6);
				{
				setState(542);
				match(Identifier);
				}
				break;
			case TYPE_ENUM:
				enterOuterAlt(_localctx, 7);
				{
				setState(543);
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
		enterRule(_localctx, 118, RULE_typeType);
		try {
			setState(548);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				associativeType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(547);
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
		public AssociativeTypeContext associativeType() {
			return getRuleContext(AssociativeTypeContext.class,0);
		}
		public FlatVectorContext flatVector() {
			return getRuleContext(FlatVectorContext.class,0);
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
		enterRule(_localctx, 120, RULE_aisType);
		try {
			setState(552);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(550);
				associativeType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(551);
				flatVector();
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
		enterRule(_localctx, 122, RULE_associativeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(T__9);
			setState(555);
			match(T__10);
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
		enterRule(_localctx, 124, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(T__9);
			setState(558);
			expression(0);
			setState(559);
			match(T__3);
			setState(560);
			expression(0);
			setState(561);
			match(T__10);
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
		enterRule(_localctx, 126, RULE_flatVector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(T__9);
			setState(564);
			expression(0);
			setState(565);
			match(T__14);
			setState(566);
			expression(0);
			setState(567);
			match(T__10);
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
		enterRule(_localctx, 128, RULE_fieldType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
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
		enterRule(_localctx, 130, RULE_enumType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(TYPE_ENUM);
			setState(572);
			match(T__6);
			setState(573);
			match(Identifier);
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(574);
				match(T__7);
				setState(575);
				match(Identifier);
				}
				}
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(581);
			match(T__8);
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
		enterRule(_localctx, 132, RULE_childComponentType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
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
		int _startState = 134;
		enterRecursionRule(_localctx, 134, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			switch (_input.LA(1)) {
			case T__9:
			case T__32:
			case FUNC_AGG_SINGLE:
			case FUNC_GT_N_FAIL:
			case FUNC_LOG:
			case FUNC_EXP:
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

				setState(586);
				primary();
				}
				break;
			case T__15:
			case T__16:
				{
				_localctx = new ExpPositiveOrNegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(587);
				((ExpPositiveOrNegativeContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
					((ExpPositiveOrNegativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(588);
				expression(13);
				}
				break;
			case T__17:
			case T__18:
				{
				_localctx = new ExpWaveOrNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(589);
				((ExpWaveOrNotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
					((ExpWaveOrNotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(590);
				expression(12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(631);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(629);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						_localctx = new ExpStarOrDivOrModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(593);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(594);
						((ExpStarOrDivOrModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((ExpStarOrDivOrModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(595);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpMinusOrPlusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(596);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(597);
						((ExpMinusOrPlusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((ExpMinusOrPlusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(598);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(599);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(600);
						((ExpCmpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((ExpCmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(601);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpEqOrNotEqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(602);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(603);
						((ExpEqOrNotEqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((ExpEqOrNotEqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(604);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpSingleAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(605);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(606);
						((ExpSingleAndContext)_localctx).op = match(T__26);
						setState(607);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpPowerContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(608);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(609);
						((ExpPowerContext)_localctx).op = match(T__27);
						setState(610);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpSingleOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(611);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(612);
						((ExpSingleOrContext)_localctx).op = match(T__28);
						setState(613);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpDoubleAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(614);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(615);
						((ExpDoubleAndContext)_localctx).op = match(T__29);
						setState(616);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpDoubleOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(617);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(618);
						((ExpDoubleOrContext)_localctx).op = match(T__30);
						setState(619);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpIfElseContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(620);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(621);
						((ExpIfElseContext)_localctx).op = match(T__31);
						setState(622);
						expression(0);
						setState(623);
						((ExpIfElseContext)_localctx).op = match(T__3);
						setState(624);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExpAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(626);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(627);
						((ExpAssignContext)_localctx).op = match(T__5);
						setState(628);
						expression(1);
						}
						break;
					}
					} 
				}
				setState(633);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
	public static class PrimaryVariableIdContext extends PrimaryContext {
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public PrimaryVariableIdContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).enterPrimaryVariableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIIF2Listener ) ((RIIF2Listener)listener).exitPrimaryVariableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIIF2Visitor ) return ((RIIF2Visitor<? extends T>)visitor).visitPrimaryVariableId(this);
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
		enterRule(_localctx, 136, RULE_primary);
		try {
			setState(645);
			switch (_input.LA(1)) {
			case T__32:
				_localctx = new PrimaryParenthesesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(634);
				match(T__32);
				setState(635);
				expression(0);
				setState(636);
				match(T__33);
				}
				break;
			case SELF:
				_localctx = new PrimarySelfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(638);
				match(SELF);
				}
				break;
			case TRUE:
				_localctx = new PrimaryTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(639);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new PrimaryFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(640);
				match(FALSE);
				}
				break;
			case Identifier:
				_localctx = new PrimaryVariableIdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(641);
				variableId();
				}
				break;
			case StringLiteral:
			case FloatingPointLiteral:
			case DecimalLiteral:
				_localctx = new PrimaryLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(642);
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
				setState(643);
				funcCall();
				}
				break;
			case T__9:
				_localctx = new PrimaryArrayInitializerContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(644);
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
		enterRule(_localctx, 138, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			funcName();
			setState(648);
			match(T__32);
			setState(649);
			funcArg();
			setState(652);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(650);
				match(T__7);
				setState(651);
				funcArg();
				}
			}

			setState(654);
			match(T__33);
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
		enterRule(_localctx, 140, RULE_funcName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
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
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public AisDeclaratorIdContext aisDeclaratorId() {
			return getRuleContext(AisDeclaratorIdContext.class,0);
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
		enterRule(_localctx, 142, RULE_funcArg);
		try {
			setState(662);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(658);
				aisDeclaratorId();
				}
				setState(659);
				vector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(661);
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
		enterRule(_localctx, 144, RULE_literal);
		try {
			setState(667);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new LiteralStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(664);
				match(StringLiteral);
				}
				break;
			case DecimalLiteral:
				_localctx = new LiteralDecimalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(665);
				match(DecimalLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new LiteralFloatingPointContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(666);
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
		case 48:
			return primitiveId_sempred((PrimitiveIdContext)_localctx, predIndex);
		case 67:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean primitiveId_sempred(PrimitiveIdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3O\u02a0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\6\2\u0096\n\2\r\2\16\2\u0097\3\2\3\2\3\3\3\3\3\3\3\3\5\3"+
		"\u00a0\n\3\3\4\3\4\3\4\5\4\u00a5\n\4\3\4\5\4\u00a8\n\4\3\4\3\4\7\4\u00ac"+
		"\n\4\f\4\16\4\u00af\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00b9\n\5"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u00c3\n\7\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u00e2\n\16\3\16\3\16\7\16\u00e6\n\16"+
		"\f\16\16\16\u00e9\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00f2"+
		"\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u010a\n\25\f\25\16"+
		"\25\u010d\13\25\3\25\3\25\3\26\3\26\5\26\u0113\n\26\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0120\n\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\7\31\u0128\n\31\f\31\16\31\u012b\13\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u0135\n\32\3\33\3\33\3\33\5\33\u013a\n\33\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 "+
		"\3 \5 \u014c\n \3 \5 \u014f\n \3 \3 \3 \3!\3!\3!\3!\5!\u0158\n!\3\"\3"+
		"\"\3\"\3\"\7\"\u015e\n\"\f\"\16\"\u0161\13\"\3\"\3\"\3#\3#\3#\3#\7#\u0169"+
		"\n#\f#\16#\u016c\13#\3#\3#\3$\3$\3%\3%\3%\3%\7%\u0176\n%\f%\16%\u0179"+
		"\13%\3%\3%\3&\3&\3&\5&\u0180\n&\3\'\3\'\3\'\3\'\7\'\u0186\n\'\f\'\16\'"+
		"\u0189\13\'\3\'\3\'\3(\3(\3(\3(\7(\u0191\n(\f(\16(\u0194\13(\3(\3(\3("+
		"\5(\u0199\n(\3)\3)\5)\u019d\n)\3*\3*\3*\3*\5*\u01a3\n*\3+\3+\5+\u01a7"+
		"\n+\3+\5+\u01aa\n+\3+\3+\3+\3+\5+\u01b0\n+\3,\3,\3,\3-\3-\3.\3.\3/\3/"+
		"\3/\5/\u01bc\n/\3\60\3\60\5\60\u01c0\n\60\3\60\5\60\u01c3\n\60\3\60\3"+
		"\60\3\60\5\60\u01c8\n\60\5\60\u01ca\n\60\3\61\3\61\3\61\5\61\u01cf\n\61"+
		"\3\61\5\61\u01d2\n\61\3\61\5\61\u01d5\n\61\3\61\5\61\u01d8\n\61\3\62\3"+
		"\62\3\62\3\62\3\62\7\62\u01df\n\62\f\62\16\62\u01e2\13\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u01ed\n\64\3\65\3\65\3\65\3\65"+
		"\5\65\u01f3\n\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\38\38\39\39\39"+
		"\39\59\u0203\n9\39\39\39\39\39\3:\3:\3:\3:\7:\u020e\n:\f:\16:\u0211\13"+
		":\3;\3;\3;\3;\7;\u0217\n;\f;\16;\u021a\13;\3<\3<\3<\3<\3<\3<\3<\5<\u0223"+
		"\n<\3=\3=\5=\u0227\n=\3>\3>\5>\u022b\n>\3?\3?\3?\3@\3@\3@\3@\3@\3@\3A"+
		"\3A\3A\3A\3A\3A\3B\3B\3C\3C\3C\3C\3C\7C\u0243\nC\fC\16C\u0246\13C\3C\3"+
		"C\3D\3D\3E\3E\3E\3E\3E\3E\5E\u0252\nE\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\3E\3E\7E\u0278\nE\fE\16E\u027b\13E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F"+
		"\5F\u0288\nF\3G\3G\3G\3G\3G\5G\u028f\nG\3G\3G\3H\3H\3I\3I\3I\3I\5I\u0299"+
		"\nI\3J\3J\3J\5J\u029e\nJ\3J\2\4b\u0088K\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\2\f\5\2..@@DD\3"+
		"\2\4\5\3\2\60\61\3\2\62\63\3\2\22\23\3\2\24\25\3\2\26\30\4\2\4\5\31\32"+
		"\3\2\33\34\3\2:=\u02ba\2\u0095\3\2\2\2\4\u009f\3\2\2\2\6\u00a1\3\2\2\2"+
		"\b\u00b8\3\2\2\2\n\u00ba\3\2\2\2\f\u00c2\3\2\2\2\16\u00c4\3\2\2\2\20\u00c8"+
		"\3\2\2\2\22\u00cc\3\2\2\2\24\u00d0\3\2\2\2\26\u00d4\3\2\2\2\30\u00d8\3"+
		"\2\2\2\32\u00de\3\2\2\2\34\u00f1\3\2\2\2\36\u00f3\3\2\2\2 \u00f6\3\2\2"+
		"\2\"\u00f9\3\2\2\2$\u00fc\3\2\2\2&\u0101\3\2\2\2(\u0105\3\2\2\2*\u0112"+
		"\3\2\2\2,\u0114\3\2\2\2.\u0118\3\2\2\2\60\u0123\3\2\2\2\62\u012e\3\2\2"+
		"\2\64\u0136\3\2\2\2\66\u013b\3\2\2\28\u013f\3\2\2\2:\u0143\3\2\2\2<\u0146"+
		"\3\2\2\2>\u0148\3\2\2\2@\u0157\3\2\2\2B\u0159\3\2\2\2D\u0164\3\2\2\2F"+
		"\u016f\3\2\2\2H\u0171\3\2\2\2J\u017f\3\2\2\2L\u0181\3\2\2\2N\u0198\3\2"+
		"\2\2P\u019c\3\2\2\2R\u01a2\3\2\2\2T\u01af\3\2\2\2V\u01b1\3\2\2\2X\u01b4"+
		"\3\2\2\2Z\u01b6\3\2\2\2\\\u01b8\3\2\2\2^\u01c9\3\2\2\2`\u01d7\3\2\2\2"+
		"b\u01d9\3\2\2\2d\u01e3\3\2\2\2f\u01ec\3\2\2\2h\u01f2\3\2\2\2j\u01f4\3"+
		"\2\2\2l\u01f7\3\2\2\2n\u01fb\3\2\2\2p\u01fe\3\2\2\2r\u0209\3\2\2\2t\u0212"+
		"\3\2\2\2v\u0222\3\2\2\2x\u0226\3\2\2\2z\u022a\3\2\2\2|\u022c\3\2\2\2~"+
		"\u022f\3\2\2\2\u0080\u0235\3\2\2\2\u0082\u023b\3\2\2\2\u0084\u023d\3\2"+
		"\2\2\u0086\u0249\3\2\2\2\u0088\u0251\3\2\2\2\u008a\u0287\3\2\2\2\u008c"+
		"\u0289\3\2\2\2\u008e\u0292\3\2\2\2\u0090\u0298\3\2\2\2\u0092\u029d\3\2"+
		"\2\2\u0094\u0096\5\4\3\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\2"+
		"\2\3\u009a\3\3\2\2\2\u009b\u00a0\5\6\4\2\u009c\u00a0\5\32\16\2\u009d\u00a0"+
		"\5(\25\2\u009e\u00a0\5\60\31\2\u009f\u009b\3\2\2\2\u009f\u009c\3\2\2\2"+
		"\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\5\3\2\2\2\u00a1\u00a2\7"+
		"%\2\2\u00a2\u00a4\7I\2\2\u00a3\u00a5\5r:\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a8\5t;\2\u00a7\u00a6\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ad\7\3\2\2\u00aa\u00ac\5\b"+
		"\5\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7&"+
		"\2\2\u00b1\7\3\2\2\2\u00b2\u00b9\5\n\6\2\u00b3\u00b9\5\16\b\2\u00b4\u00b9"+
		"\5\20\t\2\u00b5\u00b9\5\22\n\2\u00b6\u00b9\5\24\13\2\u00b7\u00b9\5\30"+
		"\r\2\u00b8\u00b2\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8"+
		"\u00b5\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\t\3\2\2\2"+
		"\u00ba\u00bb\5\u0082B\2\u00bb\u00bc\5\f\7\2\u00bc\u00bd\7\3\2\2\u00bd"+
		"\13\3\2\2\2\u00be\u00c3\5\62\32\2\u00bf\u00c3\5\64\33\2\u00c0\u00c3\5"+
		"\66\34\2\u00c1\u00c3\58\35\2\u00c2\u00be\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\r\3\2\2\2\u00c4\u00c5\7+\2\2"+
		"\u00c5\u00c6\5:\36\2\u00c6\u00c7\7\3\2\2\u00c7\17\3\2\2\2\u00c8\u00c9"+
		"\7,\2\2\u00c9\u00ca\5<\37\2\u00ca\u00cb\7\3\2\2\u00cb\21\3\2\2\2\u00cc"+
		"\u00cd\7.\2\2\u00cd\u00ce\5> \2\u00ce\u00cf\7\3\2\2\u00cf\23\3\2\2\2\u00d0"+
		"\u00d1\7D\2\2\u00d1\u00d2\5> \2\u00d2\u00d3\7\3\2\2\u00d3\25\3\2\2\2\u00d4"+
		"\u00d5\t\2\2\2\u00d5\u00d6\5> \2\u00d6\u00d7\7\3\2\2\u00d7\27\3\2\2\2"+
		"\u00d8\u00d9\7/\2\2\u00d9\u00da\5f\64\2\u00da\u00db\t\3\2\2\u00db\u00dc"+
		"\5\u0088E\2\u00dc\u00dd\7\3\2\2\u00dd\31\3\2\2\2\u00de\u00df\7>\2\2\u00df"+
		"\u00e1\7I\2\2\u00e0\u00e2\5r:\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2"+
		"\2\u00e2\u00e3\3\2\2\2\u00e3\u00e7\7\3\2\2\u00e4\u00e6\5\34\17\2\u00e5"+
		"\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\7?\2\2\u00eb"+
		"\33\3\2\2\2\u00ec\u00f2\5\36\20\2\u00ed\u00f2\5 \21\2\u00ee\u00f2\5\""+
		"\22\2\u00ef\u00f2\5$\23\2\u00f0\u00f2\5&\24\2\u00f1\u00ec\3\2\2\2\u00f1"+
		"\u00ed\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2"+
		"\2\2\u00f2\35\3\2\2\2\u00f3\u00f4\7A\2\2\u00f4\u00f5\5\n\6\2\u00f5\37"+
		"\3\2\2\2\u00f6\u00f7\7A\2\2\u00f7\u00f8\5\20\t\2\u00f8!\3\2\2\2\u00f9"+
		"\u00fa\7A\2\2\u00fa\u00fb\5\16\b\2\u00fb#\3\2\2\2\u00fc\u00fd\7A\2\2\u00fd"+
		"\u00fe\7F\2\2\u00fe\u00ff\7I\2\2\u00ff\u0100\7\3\2\2\u0100%\3\2\2\2\u0101"+
		"\u0102\7@\2\2\u0102\u0103\5> \2\u0103\u0104\7\3\2\2\u0104\'\3\2\2\2\u0105"+
		"\u0106\7\'\2\2\u0106\u0107\7I\2\2\u0107\u010b\7\3\2\2\u0108\u010a\5*\26"+
		"\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c"+
		"\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\7(\2\2\u010f"+
		")\3\2\2\2\u0110\u0113\5,\27\2\u0111\u0113\5.\30\2\u0112\u0110\3\2\2\2"+
		"\u0112\u0111\3\2\2\2\u0113+\3\2\2\2\u0114\u0115\7.\2\2\u0115\u0116\5>"+
		" \2\u0116\u0117\7\3\2\2\u0117-\3\2\2\2\u0118\u0119\t\4\2\2\u0119\u011a"+
		"\7\62\2\2\u011a\u011b\5h\65\2\u011b\u011c\7\6\2\2\u011c\u011f\5v<\2\u011d"+
		"\u011e\7\7\2\2\u011e\u0120\5\u0088E\2\u011f\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7\3\2\2\u0122/\3\2\2\2\u0123"+
		"\u0124\7)\2\2\u0124\u0125\7I\2\2\u0125\u0129\7\3\2\2\u0126\u0128\5\30"+
		"\r\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7*"+
		"\2\2\u012d\61\3\2\2\2\u012e\u012f\5T+\2\u012f\u0130\7\6\2\2\u0130\u0131"+
		"\5v<\2\u0131\u0134\3\2\2\2\u0132\u0133\7\7\2\2\u0133\u0135\5@!\2\u0134"+
		"\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\63\3\2\2\2\u0136\u0139\5V,\2"+
		"\u0137\u0138\7\7\2\2\u0138\u013a\5@!\2\u0139\u0137\3\2\2\2\u0139\u013a"+
		"\3\2\2\2\u013a\65\3\2\2\2\u013b\u013c\5X-\2\u013c\u013d\7\6\2\2\u013d"+
		"\u013e\7E\2\2\u013e\67\3\2\2\2\u013f\u0140\5Z.\2\u0140\u0141\7\7\2\2\u0141"+
		"\u0142\5H%\2\u01429\3\2\2\2\u0143\u0144\5\u0086D\2\u0144\u0145\5\\/\2"+
		"\u0145;\3\2\2\2\u0146\u0147\5^\60\2\u0147=\3\2\2\2\u0148\u014b\5`\61\2"+
		"\u0149\u014c\5z>\2\u014a\u014c\5l\67\2\u014b\u0149\3\2\2\2\u014b\u014a"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014f\5j\66\2\u014e"+
		"\u014d\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\7\b"+
		"\2\2\u0151\u0152\5R*\2\u0152?\3\2\2\2\u0153\u0158\5H%\2\u0154\u0158\5"+
		"D#\2\u0155\u0158\5B\"\2\u0156\u0158\5\u0088E\2\u0157\u0153\3\2\2\2\u0157"+
		"\u0154\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0156\3\2\2\2\u0158A\3\2\2\2"+
		"\u0159\u015a\7\t\2\2\u015a\u015f\5D#\2\u015b\u015c\7\n\2\2\u015c\u015e"+
		"\5D#\2\u015d\u015b\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\7\13"+
		"\2\2\u0163C\3\2\2\2\u0164\u0165\7\f\2\2\u0165\u016a\5F$\2\u0166\u0167"+
		"\7\n\2\2\u0167\u0169\5F$\2\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u016a\3\2"+
		"\2\2\u016d\u016e\7\r\2\2\u016eE\3\2\2\2\u016f\u0170\5\u0088E\2\u0170G"+
		"\3\2\2\2\u0171\u0172\7\t\2\2\u0172\u0177\5J&\2\u0173\u0174\7\n\2\2\u0174"+
		"\u0176\5J&\2\u0175\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2"+
		"\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b"+
		"\7\13\2\2\u017bI\3\2\2\2\u017c\u0180\7L\2\2\u017d\u0180\7K\2\2\u017e\u0180"+
		"\7I\2\2\u017f\u017c\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u017e\3\2\2\2\u0180"+
		"K\3\2\2\2\u0181\u0182\7\t\2\2\u0182\u0187\5N(\2\u0183\u0184\7\n\2\2\u0184"+
		"\u0186\5N(\2\u0185\u0183\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2"+
		"\2\u0187\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b"+
		"\7\13\2\2\u018bM\3\2\2\2\u018c\u018d\7\f\2\2\u018d\u0192\5P)\2\u018e\u018f"+
		"\7\n\2\2\u018f\u0191\5P)\2\u0190\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0195\u0196\7\r\2\2\u0196\u0199\3\2\2\2\u0197\u0199\5\u0088E\2\u0198"+
		"\u018c\3\2\2\2\u0198\u0197\3\2\2\2\u0199O\3\2\2\2\u019a\u019d\5\u0088"+
		"E\2\u019b\u019d\5H%\2\u019c\u019a\3\2\2\2\u019c\u019b\3\2\2\2\u019dQ\3"+
		"\2\2\2\u019e\u01a3\5H%\2\u019f\u01a3\5\u0088E\2\u01a0\u01a3\5B\"\2\u01a1"+
		"\u01a3\5L\'\2\u01a2\u019e\3\2\2\2\u01a2\u019f\3\2\2\2\u01a2\u01a0\3\2"+
		"\2\2\u01a2\u01a1\3\2\2\2\u01a3S\3\2\2\2\u01a4\u01a6\7I\2\2\u01a5\u01a7"+
		"\5x=\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8"+
		"\u01aa\5j\66\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01b0\3\2"+
		"\2\2\u01ab\u01ac\7I\2\2\u01ac\u01ad\5l\67\2\u01ad\u01ae\5j\66\2\u01ae"+
		"\u01b0\3\2\2\2\u01af\u01a4\3\2\2\2\u01af\u01ab\3\2\2\2\u01b0U\3\2\2\2"+
		"\u01b1\u01b2\7I\2\2\u01b2\u01b3\5l\67\2\u01b3W\3\2\2\2\u01b4\u01b5\7I"+
		"\2\2\u01b5Y\3\2\2\2\u01b6\u01b7\7I\2\2\u01b7[\3\2\2\2\u01b8\u01bb\7I\2"+
		"\2\u01b9\u01bc\5x=\2\u01ba\u01bc\5l\67\2\u01bb\u01b9\3\2\2\2\u01bb\u01ba"+
		"\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc]\3\2\2\2\u01bd\u01bf\7I\2\2\u01be\u01c0"+
		"\5x=\2\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c2\3\2\2\2\u01c1"+
		"\u01c3\5j\66\2\u01c2\u01c1\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01ca\3\2"+
		"\2\2\u01c4\u01c5\7I\2\2\u01c5\u01c7\5l\67\2\u01c6\u01c8\5j\66\2\u01c7"+
		"\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01bd\3\2"+
		"\2\2\u01c9\u01c4\3\2\2\2\u01ca_\3\2\2\2\u01cb\u01ce\5b\62\2\u01cc\u01cf"+
		"\5z>\2\u01cd\u01cf\5l\67\2\u01ce\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01ce"+
		"\u01cf\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01d2\5n8\2\u01d1\u01d0\3\2\2"+
		"\2\u01d1\u01d2\3\2\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d5\5j\66\2\u01d4\u01d3"+
		"\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d8\5p9\2\u01d7"+
		"\u01cb\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8a\3\2\2\2\u01d9\u01da\b\62\1\2"+
		"\u01da\u01db\7I\2\2\u01db\u01e0\3\2\2\2\u01dc\u01dd\f\3\2\2\u01dd\u01df"+
		"\5n8\2\u01de\u01dc\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0"+
		"\u01e1\3\2\2\2\u01e1c\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3\u01e4\5b\62\2"+
		"\u01e4\u01e5\5l\67\2\u01e5e\3\2\2\2\u01e6\u01e7\5b\62\2\u01e7\u01e8\5"+
		"j\66\2\u01e8\u01ed\3\2\2\2\u01e9\u01ea\5d\63\2\u01ea\u01eb\5j\66\2\u01eb"+
		"\u01ed\3\2\2\2\u01ec\u01e6\3\2\2\2\u01ec\u01e9\3\2\2\2\u01edg\3\2\2\2"+
		"\u01ee\u01f3\5b\62\2\u01ef\u01f3\5d\63\2\u01f0\u01f3\5f\64\2\u01f1\u01f3"+
		"\5p9\2\u01f2\u01ee\3\2\2\2\u01f2\u01ef\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2"+
		"\u01f1\3\2\2\2\u01f3i\3\2\2\2\u01f4\u01f5\7\16\2\2\u01f5\u01f6\7I\2\2"+
		"\u01f6k\3\2\2\2\u01f7\u01f8\7\f\2\2\u01f8\u01f9\7I\2\2\u01f9\u01fa\7\r"+
		"\2\2\u01fam\3\2\2\2\u01fb\u01fc\7\17\2\2\u01fc\u01fd\7I\2\2\u01fdo\3\2"+
		"\2\2\u01fe\u01ff\5f\64\2\u01ff\u0202\7\f\2\2\u0200\u0203\7\20\2\2\u0201"+
		"\u0203\7I\2\2\u0202\u0200\3\2\2\2\u0202\u0201\3\2\2\2\u0203\u0204\3\2"+
		"\2\2\u0204\u0205\7\r\2\2\u0205\u0206\7\f\2\2\u0206\u0207\7I\2\2\u0207"+
		"\u0208\7\r\2\2\u0208q\3\2\2\2\u0209\u020a\7-\2\2\u020a\u020f\7I\2\2\u020b"+
		"\u020c\7\n\2\2\u020c\u020e\7I\2\2\u020d\u020b\3\2\2\2\u020e\u0211\3\2"+
		"\2\2\u020f\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210s\3\2\2\2\u0211\u020f"+
		"\3\2\2\2\u0212\u0213\7B\2\2\u0213\u0218\7I\2\2\u0214\u0215\7\n\2\2\u0215"+
		"\u0217\7I\2\2\u0216\u0214\3\2\2\2\u0217\u021a\3\2\2\2\u0218\u0216\3\2"+
		"\2\2\u0218\u0219\3\2\2\2\u0219u\3\2\2\2\u021a\u0218\3\2\2\2\u021b\u0223"+
		"\7\64\2\2\u021c\u0223\7\65\2\2\u021d\u0223\7\66\2\2\u021e\u0223\78\2\2"+
		"\u021f\u0223\79\2\2\u0220\u0223\7I\2\2\u0221\u0223\5\u0084C\2\u0222\u021b"+
		"\3\2\2\2\u0222\u021c\3\2\2\2\u0222\u021d\3\2\2\2\u0222\u021e\3\2\2\2\u0222"+
		"\u021f\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0221\3\2\2\2\u0223w\3\2\2\2"+
		"\u0224\u0227\5|?\2\u0225\u0227\5~@\2\u0226\u0224\3\2\2\2\u0226\u0225\3"+
		"\2\2\2\u0227y\3\2\2\2\u0228\u022b\5|?\2\u0229\u022b\5\u0080A\2\u022a\u0228"+
		"\3\2\2\2\u022a\u0229\3\2\2\2\u022b{\3\2\2\2\u022c\u022d\7\f\2\2\u022d"+
		"\u022e\7\r\2\2\u022e}\3\2\2\2\u022f\u0230\7\f\2\2\u0230\u0231\5\u0088"+
		"E\2\u0231\u0232\7\6\2\2\u0232\u0233\5\u0088E\2\u0233\u0234\7\r\2\2\u0234"+
		"\177\3\2\2\2\u0235\u0236\7\f\2\2\u0236\u0237\5\u0088E\2\u0237\u0238\7"+
		"\21\2\2\u0238\u0239\5\u0088E\2\u0239\u023a\7\r\2\2\u023a\u0081\3\2\2\2"+
		"\u023b\u023c\t\5\2\2\u023c\u0083\3\2\2\2\u023d\u023e\7\67\2\2\u023e\u023f"+
		"\7\t\2\2\u023f\u0244\7I\2\2\u0240\u0241\7\n\2\2\u0241\u0243\7I\2\2\u0242"+
		"\u0240\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2"+
		"\2\2\u0245\u0247\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0248\7\13\2\2\u0248"+
		"\u0085\3\2\2\2\u0249\u024a\7I\2\2\u024a\u0087\3\2\2\2\u024b\u024c\bE\1"+
		"\2\u024c\u0252\5\u008aF\2\u024d\u024e\t\6\2\2\u024e\u0252\5\u0088E\17"+
		"\u024f\u0250\t\7\2\2\u0250\u0252\5\u0088E\16\u0251\u024b\3\2\2\2\u0251"+
		"\u024d\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0279\3\2\2\2\u0253\u0254\f\r"+
		"\2\2\u0254\u0255\t\b\2\2\u0255\u0278\5\u0088E\16\u0256\u0257\f\f\2\2\u0257"+
		"\u0258\t\6\2\2\u0258\u0278\5\u0088E\r\u0259\u025a\f\13\2\2\u025a\u025b"+
		"\t\t\2\2\u025b\u0278\5\u0088E\f\u025c\u025d\f\n\2\2\u025d\u025e\t\n\2"+
		"\2\u025e\u0278\5\u0088E\13\u025f\u0260\f\t\2\2\u0260\u0261\7\35\2\2\u0261"+
		"\u0278\5\u0088E\n\u0262\u0263\f\b\2\2\u0263\u0264\7\36\2\2\u0264\u0278"+
		"\5\u0088E\t\u0265\u0266\f\7\2\2\u0266\u0267\7\37\2\2\u0267\u0278\5\u0088"+
		"E\b\u0268\u0269\f\6\2\2\u0269\u026a\7 \2\2\u026a\u0278\5\u0088E\7\u026b"+
		"\u026c\f\5\2\2\u026c\u026d\7!\2\2\u026d\u0278\5\u0088E\6\u026e\u026f\f"+
		"\4\2\2\u026f\u0270\7\"\2\2\u0270\u0271\5\u0088E\2\u0271\u0272\7\6\2\2"+
		"\u0272\u0273\5\u0088E\5\u0273\u0278\3\2\2\2\u0274\u0275\f\3\2\2\u0275"+
		"\u0276\7\b\2\2\u0276\u0278\5\u0088E\3\u0277\u0253\3\2\2\2\u0277\u0256"+
		"\3\2\2\2\u0277\u0259\3\2\2\2\u0277\u025c\3\2\2\2\u0277\u025f\3\2\2\2\u0277"+
		"\u0262\3\2\2\2\u0277\u0265\3\2\2\2\u0277\u0268\3\2\2\2\u0277\u026b\3\2"+
		"\2\2\u0277\u026e\3\2\2\2\u0277\u0274\3\2\2\2\u0278\u027b\3\2\2\2\u0279"+
		"\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u0089\3\2\2\2\u027b\u0279\3\2"+
		"\2\2\u027c\u027d\7#\2\2\u027d\u027e\5\u0088E\2\u027e\u027f\7$\2\2\u027f"+
		"\u0288\3\2\2\2\u0280\u0288\7C\2\2\u0281\u0288\7G\2\2\u0282\u0288\7H\2"+
		"\2\u0283\u0288\5h\65\2\u0284\u0288\5\u0092J\2\u0285\u0288\5\u008cG\2\u0286"+
		"\u0288\5D#\2\u0287\u027c\3\2\2\2\u0287\u0280\3\2\2\2\u0287\u0281\3\2\2"+
		"\2\u0287\u0282\3\2\2\2\u0287\u0283\3\2\2\2\u0287\u0284\3\2\2\2\u0287\u0285"+
		"\3\2\2\2\u0287\u0286\3\2\2\2\u0288\u008b\3\2\2\2\u0289\u028a\5\u008eH"+
		"\2\u028a\u028b\7#\2\2\u028b\u028e\5\u0090I\2\u028c\u028d\7\n\2\2\u028d"+
		"\u028f\5\u0090I\2\u028e\u028c\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0290"+
		"\3\2\2\2\u0290\u0291\7$\2\2\u0291\u008d\3\2\2\2\u0292\u0293\t\13\2\2\u0293"+
		"\u008f\3\2\2\2\u0294\u0295\5`\61\2\u0295\u0296\5~@\2\u0296\u0299\3\2\2"+
		"\2\u0297\u0299\5\u0088E\2\u0298\u0294\3\2\2\2\u0298\u0297\3\2\2\2\u0299"+
		"\u0091\3\2\2\2\u029a\u029e\7J\2\2\u029b\u029e\7L\2\2\u029c\u029e\7K\2"+
		"\2\u029d\u029a\3\2\2\2\u029d\u029b\3\2\2\2\u029d\u029c\3\2\2\2\u029e\u0093"+
		"\3\2\2\2;\u0097\u009f\u00a4\u00a7\u00ad\u00b8\u00c2\u00e1\u00e7\u00f1"+
		"\u010b\u0112\u011f\u0129\u0134\u0139\u014b\u014e\u0157\u015f\u016a\u0177"+
		"\u017f\u0187\u0192\u0198\u019c\u01a2\u01a6\u01a9\u01af\u01bb\u01bf\u01c2"+
		"\u01c7\u01c9\u01ce\u01d1\u01d4\u01d7\u01e0\u01ec\u01f2\u0202\u020f\u0218"+
		"\u0222\u0226\u022a\u0244\u0251\u0277\u0279\u0287\u028e\u0298\u029d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}