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
		RULE_attributeIndex = 52, RULE_associativeIndex = 53, RULE_tableIndex = 54, 
		RULE_hierPostfix = 55, RULE_tableId = 56, RULE_extendsList = 57, RULE_implementsList = 58, 
		RULE_primitiveType = 59, RULE_typeType = 60, RULE_aisType = 61, RULE_associativeType = 62, 
		RULE_vector = 63, RULE_flatVector = 64, RULE_fieldType = 65, RULE_enumType = 66, 
		RULE_childComponentType = 67, RULE_expression = 68, RULE_primary = 69, 
		RULE_funcCall = 70, RULE_funcName = 71, RULE_funcArg = 72, RULE_literal = 73;
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
		"attributeIndex", "associativeIndex", "tableIndex", "hierPostfix", "tableId", 
		"extendsList", "implementsList", "primitiveType", "typeType", "aisType", 
		"associativeType", "vector", "flatVector", "fieldType", "enumType", "childComponentType", 
		"expression", "primary", "funcCall", "funcName", "funcArg", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'<'", "'>'", "':'", "':='", "'='", "'{'", "','", "'}'", 
		"'['", "']'", "'''", "'#'", "'.'", "'..'", "'+'", "'-'", "'~'", "'!'", 
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
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148);
				typeDeclaration();
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPONENT) | (1L << ENVIRONMENT) | (1L << REQUIREMENT) | (1L << TEMPLATE))) != 0) );
			setState(153);
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
			setState(159);
			switch (_input.LA(1)) {
			case COMPONENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				componentDeclaration();
				}
				break;
			case TEMPLATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				templateDeclaration();
				}
				break;
			case ENVIRONMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				environmentDeclaration();
				}
				break;
			case REQUIREMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
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
			setState(161);
			match(COMPONENT);
			setState(162);
			match(Identifier);
			setState(164);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(163);
				extendsList();
				}
			}

			setState(167);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(166);
				implementsList();
				}
			}

			setState(169);
			match(T__0);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & ((1L << (CHILD_COMPONENT - 41)) | (1L << (FAIL_MODE - 41)) | (1L << (ASSIGN - 41)) | (1L << (ASSERT - 41)) | (1L << (PARAMETER - 41)) | (1L << (CONSTANT - 41)) | (1L << (SET - 41)))) != 0)) {
				{
				{
				setState(170);
				componentBodyElement();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
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
			setState(184);
			switch (_input.LA(1)) {
			case PARAMETER:
			case CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				fieldDeclaration();
				}
				break;
			case CHILD_COMPONENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				childComponentDeclaration();
				}
				break;
			case FAIL_MODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				failModeDeclaration();
				}
				break;
			case ASSIGN:
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				assignmentDeclaration();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				setDeclaration();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 6);
				{
				setState(183);
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
			setState(186);
			fieldType();
			setState(187);
			fieldDeclaratorType();
			setState(188);
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
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				primitiveFieldDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				associativeIndexDeclarator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				tableFieldDeclarator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
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
			setState(196);
			match(CHILD_COMPONENT);
			setState(197);
			childComponentDeclarator();
			setState(198);
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
			setState(200);
			match(FAIL_MODE);
			setState(201);
			failModeDeclarator();
			setState(202);
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
			setState(204);
			match(ASSIGN);
			setState(205);
			aisDeclarator();
			setState(206);
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
			setState(208);
			match(SET);
			setState(209);
			aisDeclarator();
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
			setState(212);
			_la = _input.LA(1);
			if ( !(((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (ASSIGN - 44)) | (1L << (IMPOSE - 44)) | (1L << (SET - 44)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(213);
			aisDeclarator();
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
			setState(216);
			match(ASSERT);
			{
			setState(217);
			attributeId();
			}
			setState(218);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(219);
			expression(0);
			setState(220);
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
			setState(222);
			match(TEMPLATE);
			setState(223);
			match(Identifier);
			setState(225);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(224);
				extendsList();
				}
			}

			setState(227);
			match(T__0);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPOSE || _la==ABSTRACT) {
				{
				{
				setState(228);
				templateBodyElement();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
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
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				abstractFieldDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				abstractFailModeDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				abstractChildComponentDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(239);
				abstractPlatformDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
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
			setState(243);
			match(ABSTRACT);
			setState(244);
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
			setState(246);
			match(ABSTRACT);
			setState(247);
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
			setState(249);
			match(ABSTRACT);
			setState(250);
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
			setState(252);
			match(ABSTRACT);
			setState(253);
			match(PLATFORM);
			setState(254);
			match(Identifier);
			setState(255);
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
			setState(257);
			match(IMPOSE);
			setState(258);
			aisDeclarator();
			setState(259);
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
			setState(261);
			match(ENVIRONMENT);
			setState(262);
			match(Identifier);
			setState(263);
			match(T__0);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << INPUT) | (1L << OUTPUT))) != 0)) {
				{
				{
				setState(264);
				environmentBodyElement();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
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
			setState(274);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				assignment();
				}
				break;
			case INPUT:
			case OUTPUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
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
			setState(276);
			match(ASSIGN);
			setState(277);
			aisDeclarator();
			setState(278);
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
			setState(280);
			_la = _input.LA(1);
			if ( !(_la==INPUT || _la==OUTPUT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(281);
			match(PARAMETER);
			setState(282);
			variableId();
			setState(283);
			match(T__3);
			setState(284);
			primitiveType();
			setState(287);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(285);
				match(T__4);
				setState(286);
				expression(0);
				}
			}

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
		enterRule(_localctx, 46, RULE_requirementDeclaration);
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
			setState(302);
			primitiveFieldDeclaratorId();
			{
			setState(303);
			match(T__3);
			setState(304);
			primitiveType();
			}
			setState(308);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(306);
				match(T__4);
				setState(307);
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
			setState(310);
			associativeIndexDeclaratorId();
			setState(313);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(311);
				match(T__4);
				setState(312);
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
			setState(315);
			tableFieldDeclaratorId();
			setState(316);
			match(T__3);
			setState(317);
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
			setState(319);
			listFieldDeclaratorId();
			setState(320);
			match(T__4);
			setState(321);
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
			setState(323);
			childComponentType();
			setState(324);
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
			setState(326);
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
		enterRule(_localctx, 60, RULE_aisDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			aisDeclaratorId();
			setState(329);
			match(T__5);
			setState(330);
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
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				listInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				arrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				arrayInitializerWrapper();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(335);
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
			setState(338);
			match(T__6);
			setState(339);
			arrayInitializer();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(340);
				match(T__7);
				setState(341);
				arrayInitializer();
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(347);
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
			setState(349);
			match(T__9);
			setState(350);
			arrayItem();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(351);
				match(T__7);
				setState(352);
				arrayItem();
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(358);
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
			setState(360);
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
			setState(362);
			match(T__6);
			setState(363);
			listItem();
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(364);
				match(T__7);
				setState(365);
				listItem();
				}
				}
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(371);
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
			setState(376);
			switch (_input.LA(1)) {
			case DecimalLiteral:
				_localctx = new ListItemDecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				match(DecimalLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new ListItemFloatingPointLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				match(FloatingPointLiteral);
				}
				break;
			case Identifier:
				_localctx = new ListItemIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(375);
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
			setState(378);
			match(T__6);
			setState(379);
			row();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(380);
				match(T__7);
				setState(381);
				row();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
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
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new RowArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				match(T__9);
				setState(390);
				rowItem();
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(391);
					match(T__7);
					setState(392);
					rowItem();
					}
					}
					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(398);
				match(T__10);
				}
				break;
			case 2:
				_localctx = new RowExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
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
			setState(405);
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
				setState(403);
				expression(0);
				}
				break;
			case T__6:
				_localctx = new RowItemListInitializerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
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
			setState(411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				listInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(409);
				arrayInitializerWrapper();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(410);
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
			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new PrimitiveFieldDeclaratorId1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				match(Identifier);
				setState(415);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(414);
					typeType();
					}
				}

				setState(418);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(417);
					attributeIndex();
					}
				}

				}
				break;
			case 2:
				_localctx = new PrimitiveFieldDeclaratorId2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				match(Identifier);
				setState(421);
				associativeIndex();
				setState(422);
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
			setState(426);
			match(Identifier);
			setState(427);
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
			setState(429);
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
			setState(431);
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
			setState(433);
			match(Identifier);
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(434);
				typeType();
				}
				break;
			case 2:
				{
				setState(435);
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
			setState(450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new FailModeDeclaratorId1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				match(Identifier);
				setState(440);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(439);
					typeType();
					}
				}

				setState(443);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(442);
					attributeIndex();
					}
				}

				}
				break;
			case 2:
				_localctx = new FailModeDeclaratorId2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				match(Identifier);
				setState(446);
				associativeIndex();
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
		enterRule(_localctx, 94, RULE_aisDeclaratorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			primitiveId(0);
			setState(455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(453);
				aisType();
				}
				break;
			case 2:
				{
				setState(454);
				associativeIndex();
				}
				break;
			}
			setState(458);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(457);
				hierPostfix();
				}
				break;
			}
			setState(461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(460);
				attributeIndex();
				}
				break;
			}
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(463);
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

			setState(467);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(473);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrimitiveIdIdContext(new PrimitiveIdContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_primitiveId);
					setState(469);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(470);
					hierPostfix();
					}
					}
					} 
				}
				setState(475);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
			setState(476);
			primitiveId(0);
			setState(477);
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
			setState(485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new AttributePrimitiveIdIndexContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				primitiveId(0);
				setState(480);
				attributeIndex();
				}
				break;
			case 2:
				_localctx = new AttributeAssociativeIdIndexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(482);
				associativeId();
				setState(483);
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
			setState(491);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				primitiveId(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				associativeId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(489);
				attributeId();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(490);
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
			setState(493);
			match(T__11);
			setState(494);
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
			setState(496);
			match(T__9);
			setState(497);
			match(Identifier);
			setState(498);
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
		enterRule(_localctx, 108, RULE_tableIndex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			match(T__9);
			setState(501);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(502);
			match(T__10);
			setState(503);
			match(T__9);
			setState(504);
			match(Identifier);
			setState(505);
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
		enterRule(_localctx, 110, RULE_hierPostfix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(T__13);
			setState(508);
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
		enterRule(_localctx, 112, RULE_tableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			attributeId();
			setState(511);
			match(T__9);
			setState(514);
			switch (_input.LA(1)) {
			case T__12:
				{
				setState(512);
				((TableIdContext)_localctx).op = match(T__12);
				}
				break;
			case Identifier:
				{
				setState(513);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(516);
			match(T__10);
			setState(517);
			match(T__9);
			setState(518);
			match(Identifier);
			setState(519);
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
		enterRule(_localctx, 114, RULE_extendsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			match(EXTENDS);
			setState(522);
			match(Identifier);
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(523);
				match(T__7);
				setState(524);
				match(Identifier);
				}
				}
				setState(529);
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
		enterRule(_localctx, 116, RULE_implementsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(IMPLEMENTS);
			setState(531);
			match(Identifier);
			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(532);
				match(T__7);
				setState(533);
				match(Identifier);
				}
				}
				setState(538);
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
		enterRule(_localctx, 118, RULE_primitiveType);
		try {
			setState(546);
			switch (_input.LA(1)) {
			case TYPE_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				match(TYPE_FLOAT);
				}
				break;
			case TYPE_INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				match(TYPE_INTEGER);
				}
				break;
			case TYPE_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(541);
				match(TYPE_STRING);
				}
				break;
			case TYPE_BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(542);
				match(TYPE_BOOLEAN);
				}
				break;
			case TYPE_TIME:
				enterOuterAlt(_localctx, 5);
				{
				setState(543);
				match(TYPE_TIME);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 6);
				{
				setState(544);
				match(Identifier);
				}
				break;
			case TYPE_ENUM:
				enterOuterAlt(_localctx, 7);
				{
				setState(545);
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
		enterRule(_localctx, 120, RULE_typeType);
		try {
			setState(550);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				associativeType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
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
		enterRule(_localctx, 122, RULE_aisType);
		try {
			setState(554);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(552);
				flatVector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
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
		enterRule(_localctx, 124, RULE_associativeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			match(T__9);
			setState(557);
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
		enterRule(_localctx, 126, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(T__9);
			setState(560);
			expression(0);
			setState(561);
			match(T__3);
			setState(562);
			expression(0);
			setState(563);
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
		enterRule(_localctx, 128, RULE_flatVector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			match(T__9);
			setState(566);
			expression(0);
			setState(567);
			match(T__14);
			setState(568);
			expression(0);
			setState(569);
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
		enterRule(_localctx, 130, RULE_fieldType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
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
		enterRule(_localctx, 132, RULE_enumType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			match(TYPE_ENUM);
			setState(574);
			match(T__6);
			setState(575);
			match(Identifier);
			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(576);
				match(T__7);
				setState(577);
				match(Identifier);
				}
				}
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(583);
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
		enterRule(_localctx, 134, RULE_childComponentType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
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
		int _startState = 136;
		enterRecursionRule(_localctx, 136, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
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

				setState(588);
				primary();
				}
				break;
			case T__15:
			case T__16:
				{
				_localctx = new ExpPositiveOrNegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(589);
				((ExpPositiveOrNegativeContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
					((ExpPositiveOrNegativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(590);
				expression(13);
				}
				break;
			case T__17:
			case T__18:
				{
				_localctx = new ExpWaveOrNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(591);
				((ExpWaveOrNotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
					((ExpWaveOrNotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(592);
				expression(12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(633);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(631);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new ExpStarOrDivOrModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(595);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(596);
						((ExpStarOrDivOrModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((ExpStarOrDivOrModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(597);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpMinusOrPlusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(598);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(599);
						((ExpMinusOrPlusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((ExpMinusOrPlusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(600);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpCmpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(601);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(602);
						((ExpCmpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((ExpCmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(603);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpEqOrNotEqContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(604);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(605);
						((ExpEqOrNotEqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((ExpEqOrNotEqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(606);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpSingleAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(607);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(608);
						((ExpSingleAndContext)_localctx).op = match(T__26);
						setState(609);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpPowerContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(610);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(611);
						((ExpPowerContext)_localctx).op = match(T__27);
						setState(612);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpSingleOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(613);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(614);
						((ExpSingleOrContext)_localctx).op = match(T__28);
						setState(615);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpDoubleAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(616);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(617);
						((ExpDoubleAndContext)_localctx).op = match(T__29);
						setState(618);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpDoubleOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(619);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(620);
						((ExpDoubleOrContext)_localctx).op = match(T__30);
						setState(621);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpIfElseContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(622);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(623);
						((ExpIfElseContext)_localctx).op = match(T__31);
						setState(624);
						expression(0);
						setState(625);
						((ExpIfElseContext)_localctx).op = match(T__3);
						setState(626);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExpAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(628);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(629);
						((ExpAssignContext)_localctx).op = match(T__5);
						setState(630);
						expression(1);
						}
						break;
					}
					} 
				}
				setState(635);
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
		enterRule(_localctx, 138, RULE_primary);
		try {
			setState(647);
			switch (_input.LA(1)) {
			case T__32:
				_localctx = new PrimaryParenthesesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(636);
				match(T__32);
				setState(637);
				expression(0);
				setState(638);
				match(T__33);
				}
				break;
			case SELF:
				_localctx = new PrimarySelfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(640);
				match(SELF);
				}
				break;
			case TRUE:
				_localctx = new PrimaryTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(641);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new PrimaryFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(642);
				match(FALSE);
				}
				break;
			case Identifier:
				_localctx = new PrimaryAisDeclaratorIdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(643);
				aisDeclaratorId();
				}
				break;
			case StringLiteral:
			case FloatingPointLiteral:
			case DecimalLiteral:
				_localctx = new PrimaryLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(644);
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
				setState(645);
				funcCall();
				}
				break;
			case T__9:
				_localctx = new PrimaryArrayInitializerContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(646);
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
		enterRule(_localctx, 140, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			funcName();
			setState(650);
			match(T__32);
			setState(651);
			funcArg();
			setState(654);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(652);
				match(T__7);
				setState(653);
				funcArg();
				}
			}

			setState(656);
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
		enterRule(_localctx, 142, RULE_funcName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
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
		enterRule(_localctx, 144, RULE_funcArg);
		try {
			setState(664);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(660);
				aisDeclaratorId();
				setState(661);
				vector();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(663);
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
		enterRule(_localctx, 146, RULE_literal);
		try {
			setState(669);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new LiteralStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(666);
				match(StringLiteral);
				}
				break;
			case DecimalLiteral:
				_localctx = new LiteralDecimalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(667);
				match(DecimalLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new LiteralFloatingPointContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(668);
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
		case 68:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3O\u02a2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\3\2\6\2\u0098\n\2\r\2\16\2\u0099\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\5\3\u00a2\n\3\3\4\3\4\3\4\5\4\u00a7\n\4\3\4\5\4\u00aa\n\4\3\4\3\4\7"+
		"\4\u00ae\n\4\f\4\16\4\u00b1\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00bb"+
		"\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u00c5\n\7\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u00e4\n\16\3\16\3\16\7\16\u00e8"+
		"\n\16\f\16\16\16\u00eb\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00f4"+
		"\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u010c\n\25\f\25\16"+
		"\25\u010f\13\25\3\25\3\25\3\26\3\26\5\26\u0115\n\26\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0122\n\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\7\31\u012a\n\31\f\31\16\31\u012d\13\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u0137\n\32\3\33\3\33\3\33\5\33\u013c\n\33\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 "+
		"\3 \3 \3!\3!\3!\3!\5!\u0153\n!\3\"\3\"\3\"\3\"\7\"\u0159\n\"\f\"\16\""+
		"\u015c\13\"\3\"\3\"\3#\3#\3#\3#\7#\u0164\n#\f#\16#\u0167\13#\3#\3#\3$"+
		"\3$\3%\3%\3%\3%\7%\u0171\n%\f%\16%\u0174\13%\3%\3%\3&\3&\3&\5&\u017b\n"+
		"&\3\'\3\'\3\'\3\'\7\'\u0181\n\'\f\'\16\'\u0184\13\'\3\'\3\'\3(\3(\3(\3"+
		"(\7(\u018c\n(\f(\16(\u018f\13(\3(\3(\3(\5(\u0194\n(\3)\3)\5)\u0198\n)"+
		"\3*\3*\3*\3*\5*\u019e\n*\3+\3+\5+\u01a2\n+\3+\5+\u01a5\n+\3+\3+\3+\3+"+
		"\5+\u01ab\n+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\5/\u01b7\n/\3\60\3\60\5\60"+
		"\u01bb\n\60\3\60\5\60\u01be\n\60\3\60\3\60\3\60\5\60\u01c3\n\60\5\60\u01c5"+
		"\n\60\3\61\3\61\3\61\5\61\u01ca\n\61\3\61\5\61\u01cd\n\61\3\61\5\61\u01d0"+
		"\n\61\3\61\5\61\u01d3\n\61\3\62\3\62\3\62\3\62\3\62\7\62\u01da\n\62\f"+
		"\62\16\62\u01dd\13\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\5\64"+
		"\u01e8\n\64\3\65\3\65\3\65\3\65\5\65\u01ee\n\65\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\3\67\38\38\38\38\38\38\38\39\39\39\3:\3:\3:\3:\5:\u0205\n:\3"+
		":\3:\3:\3:\3:\3;\3;\3;\3;\7;\u0210\n;\f;\16;\u0213\13;\3<\3<\3<\3<\7<"+
		"\u0219\n<\f<\16<\u021c\13<\3=\3=\3=\3=\3=\3=\3=\5=\u0225\n=\3>\3>\5>\u0229"+
		"\n>\3?\3?\5?\u022d\n?\3@\3@\3@\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3C"+
		"\3C\3D\3D\3D\3D\3D\7D\u0245\nD\fD\16D\u0248\13D\3D\3D\3E\3E\3F\3F\3F\3"+
		"F\3F\3F\5F\u0254\nF\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3"+
		"F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\7F\u027a\n"+
		"F\fF\16F\u027d\13F\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u028a\nG\3H\3H"+
		"\3H\3H\3H\5H\u0291\nH\3H\3H\3I\3I\3J\3J\3J\3J\5J\u029b\nJ\3K\3K\3K\5K"+
		"\u02a0\nK\3K\2\4b\u008aL\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\2\r\5\2..@@DD\3\2\4\5"+
		"\3\2\60\61\4\2\17\17II\3\2\62\63\3\2\22\23\3\2\24\25\3\2\26\30\4\2\4\5"+
		"\31\32\3\2\33\34\3\2:=\u02b8\2\u0097\3\2\2\2\4\u00a1\3\2\2\2\6\u00a3\3"+
		"\2\2\2\b\u00ba\3\2\2\2\n\u00bc\3\2\2\2\f\u00c4\3\2\2\2\16\u00c6\3\2\2"+
		"\2\20\u00ca\3\2\2\2\22\u00ce\3\2\2\2\24\u00d2\3\2\2\2\26\u00d6\3\2\2\2"+
		"\30\u00da\3\2\2\2\32\u00e0\3\2\2\2\34\u00f3\3\2\2\2\36\u00f5\3\2\2\2 "+
		"\u00f8\3\2\2\2\"\u00fb\3\2\2\2$\u00fe\3\2\2\2&\u0103\3\2\2\2(\u0107\3"+
		"\2\2\2*\u0114\3\2\2\2,\u0116\3\2\2\2.\u011a\3\2\2\2\60\u0125\3\2\2\2\62"+
		"\u0130\3\2\2\2\64\u0138\3\2\2\2\66\u013d\3\2\2\28\u0141\3\2\2\2:\u0145"+
		"\3\2\2\2<\u0148\3\2\2\2>\u014a\3\2\2\2@\u0152\3\2\2\2B\u0154\3\2\2\2D"+
		"\u015f\3\2\2\2F\u016a\3\2\2\2H\u016c\3\2\2\2J\u017a\3\2\2\2L\u017c\3\2"+
		"\2\2N\u0193\3\2\2\2P\u0197\3\2\2\2R\u019d\3\2\2\2T\u01aa\3\2\2\2V\u01ac"+
		"\3\2\2\2X\u01af\3\2\2\2Z\u01b1\3\2\2\2\\\u01b3\3\2\2\2^\u01c4\3\2\2\2"+
		"`\u01c6\3\2\2\2b\u01d4\3\2\2\2d\u01de\3\2\2\2f\u01e7\3\2\2\2h\u01ed\3"+
		"\2\2\2j\u01ef\3\2\2\2l\u01f2\3\2\2\2n\u01f6\3\2\2\2p\u01fd\3\2\2\2r\u0200"+
		"\3\2\2\2t\u020b\3\2\2\2v\u0214\3\2\2\2x\u0224\3\2\2\2z\u0228\3\2\2\2|"+
		"\u022c\3\2\2\2~\u022e\3\2\2\2\u0080\u0231\3\2\2\2\u0082\u0237\3\2\2\2"+
		"\u0084\u023d\3\2\2\2\u0086\u023f\3\2\2\2\u0088\u024b\3\2\2\2\u008a\u0253"+
		"\3\2\2\2\u008c\u0289\3\2\2\2\u008e\u028b\3\2\2\2\u0090\u0294\3\2\2\2\u0092"+
		"\u029a\3\2\2\2\u0094\u029f\3\2\2\2\u0096\u0098\5\4\3\2\u0097\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009c\7\2\2\3\u009c\3\3\2\2\2\u009d\u00a2\5\6\4\2"+
		"\u009e\u00a2\5\32\16\2\u009f\u00a2\5(\25\2\u00a0\u00a2\5\60\31\2\u00a1"+
		"\u009d\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2"+
		"\2\2\u00a2\5\3\2\2\2\u00a3\u00a4\7%\2\2\u00a4\u00a6\7I\2\2\u00a5\u00a7"+
		"\5t;\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00aa\5v<\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2"+
		"\2\u00ab\u00af\7\3\2\2\u00ac\u00ae\5\b\5\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00b3\7&\2\2\u00b3\7\3\2\2\2\u00b4\u00bb\5\n\6\2"+
		"\u00b5\u00bb\5\16\b\2\u00b6\u00bb\5\20\t\2\u00b7\u00bb\5\22\n\2\u00b8"+
		"\u00bb\5\24\13\2\u00b9\u00bb\5\30\r\2\u00ba\u00b4\3\2\2\2\u00ba\u00b5"+
		"\3\2\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\t\3\2\2\2\u00bc\u00bd\5\u0084C\2\u00bd\u00be\5\f"+
		"\7\2\u00be\u00bf\7\3\2\2\u00bf\13\3\2\2\2\u00c0\u00c5\5\62\32\2\u00c1"+
		"\u00c5\5\64\33\2\u00c2\u00c5\5\66\34\2\u00c3\u00c5\58\35\2\u00c4\u00c0"+
		"\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5"+
		"\r\3\2\2\2\u00c6\u00c7\7+\2\2\u00c7\u00c8\5:\36\2\u00c8\u00c9\7\3\2\2"+
		"\u00c9\17\3\2\2\2\u00ca\u00cb\7,\2\2\u00cb\u00cc\5<\37\2\u00cc\u00cd\7"+
		"\3\2\2\u00cd\21\3\2\2\2\u00ce\u00cf\7.\2\2\u00cf\u00d0\5> \2\u00d0\u00d1"+
		"\7\3\2\2\u00d1\23\3\2\2\2\u00d2\u00d3\7D\2\2\u00d3\u00d4\5> \2\u00d4\u00d5"+
		"\7\3\2\2\u00d5\25\3\2\2\2\u00d6\u00d7\t\2\2\2\u00d7\u00d8\5> \2\u00d8"+
		"\u00d9\7\3\2\2\u00d9\27\3\2\2\2\u00da\u00db\7/\2\2\u00db\u00dc\5f\64\2"+
		"\u00dc\u00dd\t\3\2\2\u00dd\u00de\5\u008aF\2\u00de\u00df\7\3\2\2\u00df"+
		"\31\3\2\2\2\u00e0\u00e1\7>\2\2\u00e1\u00e3\7I\2\2\u00e2\u00e4\5t;\2\u00e3"+
		"\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e9\7\3"+
		"\2\2\u00e6\u00e8\5\34\17\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00ec\u00ed\7?\2\2\u00ed\33\3\2\2\2\u00ee\u00f4\5\36\20\2\u00ef\u00f4"+
		"\5 \21\2\u00f0\u00f4\5\"\22\2\u00f1\u00f4\5$\23\2\u00f2\u00f4\5&\24\2"+
		"\u00f3\u00ee\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\35\3\2\2\2\u00f5\u00f6\7A\2\2\u00f6"+
		"\u00f7\5\n\6\2\u00f7\37\3\2\2\2\u00f8\u00f9\7A\2\2\u00f9\u00fa\5\20\t"+
		"\2\u00fa!\3\2\2\2\u00fb\u00fc\7A\2\2\u00fc\u00fd\5\16\b\2\u00fd#\3\2\2"+
		"\2\u00fe\u00ff\7A\2\2\u00ff\u0100\7F\2\2\u0100\u0101\7I\2\2\u0101\u0102"+
		"\7\3\2\2\u0102%\3\2\2\2\u0103\u0104\7@\2\2\u0104\u0105\5> \2\u0105\u0106"+
		"\7\3\2\2\u0106\'\3\2\2\2\u0107\u0108\7\'\2\2\u0108\u0109\7I\2\2\u0109"+
		"\u010d\7\3\2\2\u010a\u010c\5*\26\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2"+
		"\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0111\7(\2\2\u0111)\3\2\2\2\u0112\u0115\5,\27\2\u0113"+
		"\u0115\5.\30\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115+\3\2\2\2"+
		"\u0116\u0117\7.\2\2\u0117\u0118\5> \2\u0118\u0119\7\3\2\2\u0119-\3\2\2"+
		"\2\u011a\u011b\t\4\2\2\u011b\u011c\7\62\2\2\u011c\u011d\5h\65\2\u011d"+
		"\u011e\7\6\2\2\u011e\u0121\5x=\2\u011f\u0120\7\7\2\2\u0120\u0122\5\u008a"+
		"F\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0124\7\3\2\2\u0124/\3\2\2\2\u0125\u0126\7)\2\2\u0126\u0127\7I\2\2\u0127"+
		"\u012b\7\3\2\2\u0128\u012a\5\30\r\2\u0129\u0128\3\2\2\2\u012a\u012d\3"+
		"\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012e\u012f\7*\2\2\u012f\61\3\2\2\2\u0130\u0131\5T+\2\u0131"+
		"\u0132\7\6\2\2\u0132\u0133\5x=\2\u0133\u0136\3\2\2\2\u0134\u0135\7\7\2"+
		"\2\u0135\u0137\5@!\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\63"+
		"\3\2\2\2\u0138\u013b\5V,\2\u0139\u013a\7\7\2\2\u013a\u013c\5@!\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\65\3\2\2\2\u013d\u013e\5X-\2"+
		"\u013e\u013f\7\6\2\2\u013f\u0140\7E\2\2\u0140\67\3\2\2\2\u0141\u0142\5"+
		"Z.\2\u0142\u0143\7\7\2\2\u0143\u0144\5H%\2\u01449\3\2\2\2\u0145\u0146"+
		"\5\u0088E\2\u0146\u0147\5\\/\2\u0147;\3\2\2\2\u0148\u0149\5^\60\2\u0149"+
		"=\3\2\2\2\u014a\u014b\5`\61\2\u014b\u014c\7\b\2\2\u014c\u014d\5R*\2\u014d"+
		"?\3\2\2\2\u014e\u0153\5H%\2\u014f\u0153\5D#\2\u0150\u0153\5B\"\2\u0151"+
		"\u0153\5\u008aF\2\u0152\u014e\3\2\2\2\u0152\u014f\3\2\2\2\u0152\u0150"+
		"\3\2\2\2\u0152\u0151\3\2\2\2\u0153A\3\2\2\2\u0154\u0155\7\t\2\2\u0155"+
		"\u015a\5D#\2\u0156\u0157\7\n\2\2\u0157\u0159\5D#\2\u0158\u0156\3\2\2\2"+
		"\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d"+
		"\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\7\13\2\2\u015eC\3\2\2\2\u015f"+
		"\u0160\7\f\2\2\u0160\u0165\5F$\2\u0161\u0162\7\n\2\2\u0162\u0164\5F$\2"+
		"\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166"+
		"\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\7\r\2\2\u0169"+
		"E\3\2\2\2\u016a\u016b\5\u008aF\2\u016bG\3\2\2\2\u016c\u016d\7\t\2\2\u016d"+
		"\u0172\5J&\2\u016e\u016f\7\n\2\2\u016f\u0171\5J&\2\u0170\u016e\3\2\2\2"+
		"\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175"+
		"\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176\7\13\2\2\u0176I\3\2\2\2\u0177"+
		"\u017b\7L\2\2\u0178\u017b\7K\2\2\u0179\u017b\7I\2\2\u017a\u0177\3\2\2"+
		"\2\u017a\u0178\3\2\2\2\u017a\u0179\3\2\2\2\u017bK\3\2\2\2\u017c\u017d"+
		"\7\t\2\2\u017d\u0182\5N(\2\u017e\u017f\7\n\2\2\u017f\u0181\5N(\2\u0180"+
		"\u017e\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\7\13\2\2\u0186"+
		"M\3\2\2\2\u0187\u0188\7\f\2\2\u0188\u018d\5P)\2\u0189\u018a\7\n\2\2\u018a"+
		"\u018c\5P)\2\u018b\u0189\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2"+
		"\2\u018d\u018e\3\2\2\2\u018e\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191"+
		"\7\r\2\2\u0191\u0194\3\2\2\2\u0192\u0194\5\u008aF\2\u0193\u0187\3\2\2"+
		"\2\u0193\u0192\3\2\2\2\u0194O\3\2\2\2\u0195\u0198\5\u008aF\2\u0196\u0198"+
		"\5H%\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198Q\3\2\2\2\u0199\u019e"+
		"\5H%\2\u019a\u019e\5\u008aF\2\u019b\u019e\5B\"\2\u019c\u019e\5L\'\2\u019d"+
		"\u0199\3\2\2\2\u019d\u019a\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019c\3\2"+
		"\2\2\u019eS\3\2\2\2\u019f\u01a1\7I\2\2\u01a0\u01a2\5z>\2\u01a1\u01a0\3"+
		"\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a5\5j\66\2\u01a4"+
		"\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01ab\3\2\2\2\u01a6\u01a7\7I"+
		"\2\2\u01a7\u01a8\5l\67\2\u01a8\u01a9\5j\66\2\u01a9\u01ab\3\2\2\2\u01aa"+
		"\u019f\3\2\2\2\u01aa\u01a6\3\2\2\2\u01abU\3\2\2\2\u01ac\u01ad\7I\2\2\u01ad"+
		"\u01ae\5l\67\2\u01aeW\3\2\2\2\u01af\u01b0\7I\2\2\u01b0Y\3\2\2\2\u01b1"+
		"\u01b2\7I\2\2\u01b2[\3\2\2\2\u01b3\u01b6\7I\2\2\u01b4\u01b7\5z>\2\u01b5"+
		"\u01b7\5l\67\2\u01b6\u01b4\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7]\3\2\2\2\u01b8\u01ba\7I\2\2\u01b9\u01bb\5z>\2\u01ba\u01b9\3"+
		"\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01be\5j\66\2\u01bd"+
		"\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c5\3\2\2\2\u01bf\u01c0\7I"+
		"\2\2\u01c0\u01c2\5l\67\2\u01c1\u01c3\5j\66\2\u01c2\u01c1\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01b8\3\2\2\2\u01c4\u01bf\3\2"+
		"\2\2\u01c5_\3\2\2\2\u01c6\u01c9\5b\62\2\u01c7\u01ca\5|?\2\u01c8\u01ca"+
		"\5l\67\2\u01c9\u01c7\3\2\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"+
		"\u01cc\3\2\2\2\u01cb\u01cd\5p9\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2"+
		"\2\u01cd\u01cf\3\2\2\2\u01ce\u01d0\5j\66\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01d3\5n8\2\u01d2\u01d1\3\2\2\2\u01d2"+
		"\u01d3\3\2\2\2\u01d3a\3\2\2\2\u01d4\u01d5\b\62\1\2\u01d5\u01d6\7I\2\2"+
		"\u01d6\u01db\3\2\2\2\u01d7\u01d8\f\3\2\2\u01d8\u01da\5p9\2\u01d9\u01d7"+
		"\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"c\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\5b\62\2\u01df\u01e0\5l\67\2"+
		"\u01e0e\3\2\2\2\u01e1\u01e2\5b\62\2\u01e2\u01e3\5j\66\2\u01e3\u01e8\3"+
		"\2\2\2\u01e4\u01e5\5d\63\2\u01e5\u01e6\5j\66\2\u01e6\u01e8\3\2\2\2\u01e7"+
		"\u01e1\3\2\2\2\u01e7\u01e4\3\2\2\2\u01e8g\3\2\2\2\u01e9\u01ee\5b\62\2"+
		"\u01ea\u01ee\5d\63\2\u01eb\u01ee\5f\64\2\u01ec\u01ee\5r:\2\u01ed\u01e9"+
		"\3\2\2\2\u01ed\u01ea\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ec\3\2\2\2\u01ee"+
		"i\3\2\2\2\u01ef\u01f0\7\16\2\2\u01f0\u01f1\7I\2\2\u01f1k\3\2\2\2\u01f2"+
		"\u01f3\7\f\2\2\u01f3\u01f4\7I\2\2\u01f4\u01f5\7\r\2\2\u01f5m\3\2\2\2\u01f6"+
		"\u01f7\7\f\2\2\u01f7\u01f8\t\5\2\2\u01f8\u01f9\7\r\2\2\u01f9\u01fa\7\f"+
		"\2\2\u01fa\u01fb\7I\2\2\u01fb\u01fc\7\r\2\2\u01fco\3\2\2\2\u01fd\u01fe"+
		"\7\20\2\2\u01fe\u01ff\7I\2\2\u01ffq\3\2\2\2\u0200\u0201\5f\64\2\u0201"+
		"\u0204\7\f\2\2\u0202\u0205\7\17\2\2\u0203\u0205\7I\2\2\u0204\u0202\3\2"+
		"\2\2\u0204\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\7\r\2\2\u0207"+
		"\u0208\7\f\2\2\u0208\u0209\7I\2\2\u0209\u020a\7\r\2\2\u020as\3\2\2\2\u020b"+
		"\u020c\7-\2\2\u020c\u0211\7I\2\2\u020d\u020e\7\n\2\2\u020e\u0210\7I\2"+
		"\2\u020f\u020d\3\2\2\2\u0210\u0213\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212"+
		"\3\2\2\2\u0212u\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0215\7B\2\2\u0215\u021a"+
		"\7I\2\2\u0216\u0217\7\n\2\2\u0217\u0219\7I\2\2\u0218\u0216\3\2\2\2\u0219"+
		"\u021c\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021bw\3\2\2\2"+
		"\u021c\u021a\3\2\2\2\u021d\u0225\7\64\2\2\u021e\u0225\7\65\2\2\u021f\u0225"+
		"\7\66\2\2\u0220\u0225\78\2\2\u0221\u0225\79\2\2\u0222\u0225\7I\2\2\u0223"+
		"\u0225\5\u0086D\2\u0224\u021d\3\2\2\2\u0224\u021e\3\2\2\2\u0224\u021f"+
		"\3\2\2\2\u0224\u0220\3\2\2\2\u0224\u0221\3\2\2\2\u0224\u0222\3\2\2\2\u0224"+
		"\u0223\3\2\2\2\u0225y\3\2\2\2\u0226\u0229\5~@\2\u0227\u0229\5\u0080A\2"+
		"\u0228\u0226\3\2\2\2\u0228\u0227\3\2\2\2\u0229{\3\2\2\2\u022a\u022d\5"+
		"\u0082B\2\u022b\u022d\5~@\2\u022c\u022a\3\2\2\2\u022c\u022b\3\2\2\2\u022d"+
		"}\3\2\2\2\u022e\u022f\7\f\2\2\u022f\u0230\7\r\2\2\u0230\177\3\2\2\2\u0231"+
		"\u0232\7\f\2\2\u0232\u0233\5\u008aF\2\u0233\u0234\7\6\2\2\u0234\u0235"+
		"\5\u008aF\2\u0235\u0236\7\r\2\2\u0236\u0081\3\2\2\2\u0237\u0238\7\f\2"+
		"\2\u0238\u0239\5\u008aF\2\u0239\u023a\7\21\2\2\u023a\u023b\5\u008aF\2"+
		"\u023b\u023c\7\r\2\2\u023c\u0083\3\2\2\2\u023d\u023e\t\6\2\2\u023e\u0085"+
		"\3\2\2\2\u023f\u0240\7\67\2\2\u0240\u0241\7\t\2\2\u0241\u0246\7I\2\2\u0242"+
		"\u0243\7\n\2\2\u0243\u0245\7I\2\2\u0244\u0242\3\2\2\2\u0245\u0248\3\2"+
		"\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0249\3\2\2\2\u0248"+
		"\u0246\3\2\2\2\u0249\u024a\7\13\2\2\u024a\u0087\3\2\2\2\u024b\u024c\7"+
		"I\2\2\u024c\u0089\3\2\2\2\u024d\u024e\bF\1\2\u024e\u0254\5\u008cG\2\u024f"+
		"\u0250\t\7\2\2\u0250\u0254\5\u008aF\17\u0251\u0252\t\b\2\2\u0252\u0254"+
		"\5\u008aF\16\u0253\u024d\3\2\2\2\u0253\u024f\3\2\2\2\u0253\u0251\3\2\2"+
		"\2\u0254\u027b\3\2\2\2\u0255\u0256\f\r\2\2\u0256\u0257\t\t\2\2\u0257\u027a"+
		"\5\u008aF\16\u0258\u0259\f\f\2\2\u0259\u025a\t\7\2\2\u025a\u027a\5\u008a"+
		"F\r\u025b\u025c\f\13\2\2\u025c\u025d\t\n\2\2\u025d\u027a\5\u008aF\f\u025e"+
		"\u025f\f\n\2\2\u025f\u0260\t\13\2\2\u0260\u027a\5\u008aF\13\u0261\u0262"+
		"\f\t\2\2\u0262\u0263\7\35\2\2\u0263\u027a\5\u008aF\n\u0264\u0265\f\b\2"+
		"\2\u0265\u0266\7\36\2\2\u0266\u027a\5\u008aF\t\u0267\u0268\f\7\2\2\u0268"+
		"\u0269\7\37\2\2\u0269\u027a\5\u008aF\b\u026a\u026b\f\6\2\2\u026b\u026c"+
		"\7 \2\2\u026c\u027a\5\u008aF\7\u026d\u026e\f\5\2\2\u026e\u026f\7!\2\2"+
		"\u026f\u027a\5\u008aF\6\u0270\u0271\f\4\2\2\u0271\u0272\7\"\2\2\u0272"+
		"\u0273\5\u008aF\2\u0273\u0274\7\6\2\2\u0274\u0275\5\u008aF\5\u0275\u027a"+
		"\3\2\2\2\u0276\u0277\f\3\2\2\u0277\u0278\7\b\2\2\u0278\u027a\5\u008aF"+
		"\3\u0279\u0255\3\2\2\2\u0279\u0258\3\2\2\2\u0279\u025b\3\2\2\2\u0279\u025e"+
		"\3\2\2\2\u0279\u0261\3\2\2\2\u0279\u0264\3\2\2\2\u0279\u0267\3\2\2\2\u0279"+
		"\u026a\3\2\2\2\u0279\u026d\3\2\2\2\u0279\u0270\3\2\2\2\u0279\u0276\3\2"+
		"\2\2\u027a\u027d\3\2\2\2\u027b\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c"+
		"\u008b\3\2\2\2\u027d\u027b\3\2\2\2\u027e\u027f\7#\2\2\u027f\u0280\5\u008a"+
		"F\2\u0280\u0281\7$\2\2\u0281\u028a\3\2\2\2\u0282\u028a\7C\2\2\u0283\u028a"+
		"\7G\2\2\u0284\u028a\7H\2\2\u0285\u028a\5`\61\2\u0286\u028a\5\u0094K\2"+
		"\u0287\u028a\5\u008eH\2\u0288\u028a\5D#\2\u0289\u027e\3\2\2\2\u0289\u0282"+
		"\3\2\2\2\u0289\u0283\3\2\2\2\u0289\u0284\3\2\2\2\u0289\u0285\3\2\2\2\u0289"+
		"\u0286\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u0288\3\2\2\2\u028a\u008d\3\2"+
		"\2\2\u028b\u028c\5\u0090I\2\u028c\u028d\7#\2\2\u028d\u0290\5\u0092J\2"+
		"\u028e\u028f\7\n\2\2\u028f\u0291\5\u0092J\2\u0290\u028e\3\2\2\2\u0290"+
		"\u0291\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\7$\2\2\u0293\u008f\3\2"+
		"\2\2\u0294\u0295\t\f\2\2\u0295\u0091\3\2\2\2\u0296\u0297\5`\61\2\u0297"+
		"\u0298\5\u0080A\2\u0298\u029b\3\2\2\2\u0299\u029b\5\u008aF\2\u029a\u0296"+
		"\3\2\2\2\u029a\u0299\3\2\2\2\u029b\u0093\3\2\2\2\u029c\u02a0\7J\2\2\u029d"+
		"\u02a0\7L\2\2\u029e\u02a0\7K\2\2\u029f\u029c\3\2\2\2\u029f\u029d\3\2\2"+
		"\2\u029f\u029e\3\2\2\2\u02a0\u0095\3\2\2\29\u0099\u00a1\u00a6\u00a9\u00af"+
		"\u00ba\u00c4\u00e3\u00e9\u00f3\u010d\u0114\u0121\u012b\u0136\u013b\u0152"+
		"\u015a\u0165\u0172\u017a\u0182\u018d\u0193\u0197\u019d\u01a1\u01a4\u01aa"+
		"\u01b6\u01ba\u01bd\u01c2\u01c4\u01c9\u01cc\u01cf\u01d2\u01db\u01e7\u01ed"+
		"\u0204\u0211\u021a\u0224\u0228\u022c\u0246\u0253\u0279\u027b\u0289\u0290"+
		"\u029a\u029f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}