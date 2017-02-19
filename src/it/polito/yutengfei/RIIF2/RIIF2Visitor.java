// Generated from /usr/Intellij/ANtlr4WorkSpace/RIIF2_v6/RIIF2.g4 by ANTLR 4.5.3
package it.polito.yutengfei.RIIF2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RIIF2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RIIF2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(RIIF2Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(RIIF2Parser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#componentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDeclaration(RIIF2Parser.ComponentDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#componentBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentBodyElement(RIIF2Parser.ComponentBodyElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(RIIF2Parser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#fieldDeclaratorType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaratorType(RIIF2Parser.FieldDeclaratorTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#childComponentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildComponentDeclaration(RIIF2Parser.ChildComponentDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#failModeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailModeDeclaration(RIIF2Parser.FailModeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#assignmentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentDeclaration(RIIF2Parser.AssignmentDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#setDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDeclaration(RIIF2Parser.SetDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(RIIF2Parser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#aisDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAisDeclaration(RIIF2Parser.AisDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#templateDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateDeclaration(RIIF2Parser.TemplateDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#templateBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateBodyElement(RIIF2Parser.TemplateBodyElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#abstractFieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractFieldDeclaration(RIIF2Parser.AbstractFieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#abstractFailModeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractFailModeDeclaration(RIIF2Parser.AbstractFailModeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#abstractChildComponentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractChildComponentDeclaration(RIIF2Parser.AbstractChildComponentDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#abstractPlatformDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractPlatformDeclaration(RIIF2Parser.AbstractPlatformDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#imposeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImposeDeclaration(RIIF2Parser.ImposeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#environmentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironmentDeclaration(RIIF2Parser.EnvironmentDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#environmentBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironmentBodyElement(RIIF2Parser.EnvironmentBodyElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(RIIF2Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#envParameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvParameterDeclaration(RIIF2Parser.EnvParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#requirementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirementDeclaration(RIIF2Parser.RequirementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#primitiveFieldDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveFieldDeclarator(RIIF2Parser.PrimitiveFieldDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#associativeIndexDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociativeIndexDeclarator(RIIF2Parser.AssociativeIndexDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#tableFieldDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFieldDeclarator(RIIF2Parser.TableFieldDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#listFieldDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListFieldDeclarator(RIIF2Parser.ListFieldDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#childComponentDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildComponentDeclarator(RIIF2Parser.ChildComponentDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#failModeDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailModeDeclarator(RIIF2Parser.FailModeDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#aisDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAisDeclarator(RIIF2Parser.AisDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#fieldInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldInitializer(RIIF2Parser.FieldInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#arrayInitializerWrapper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializerWrapper(RIIF2Parser.ArrayInitializerWrapperContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(RIIF2Parser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#arrayItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayItem(RIIF2Parser.ArrayItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#listInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListInitializer(RIIF2Parser.ListInitializerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listItemDecimalLiteral}
	 * labeled alternative in {@link RIIF2Parser#listItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListItemDecimalLiteral(RIIF2Parser.ListItemDecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listItemFloatingPointLiteral}
	 * labeled alternative in {@link RIIF2Parser#listItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListItemFloatingPointLiteral(RIIF2Parser.ListItemFloatingPointLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listItemIdentifier}
	 * labeled alternative in {@link RIIF2Parser#listItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListItemIdentifier(RIIF2Parser.ListItemIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#tableItemInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableItemInitializer(RIIF2Parser.TableItemInitializerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowArray}
	 * labeled alternative in {@link RIIF2Parser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowArray(RIIF2Parser.RowArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowExpression}
	 * labeled alternative in {@link RIIF2Parser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowExpression(RIIF2Parser.RowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowItemExpression}
	 * labeled alternative in {@link RIIF2Parser#rowItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowItemExpression(RIIF2Parser.RowItemExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowItemListInitializer}
	 * labeled alternative in {@link RIIF2Parser#rowItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowItemListInitializer(RIIF2Parser.RowItemListInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#aisInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAisInitializer(RIIF2Parser.AisInitializerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primitiveFieldDeclaratorId1}
	 * labeled alternative in {@link RIIF2Parser#primitiveFieldDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveFieldDeclaratorId1(RIIF2Parser.PrimitiveFieldDeclaratorId1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code primitiveFieldDeclaratorId2}
	 * labeled alternative in {@link RIIF2Parser#primitiveFieldDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveFieldDeclaratorId2(RIIF2Parser.PrimitiveFieldDeclaratorId2Context ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#associativeIndexDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociativeIndexDeclaratorId(RIIF2Parser.AssociativeIndexDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#tableFieldDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFieldDeclaratorId(RIIF2Parser.TableFieldDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#listFieldDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListFieldDeclaratorId(RIIF2Parser.ListFieldDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#childComponentDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildComponentDeclaratorId(RIIF2Parser.ChildComponentDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code failModeDeclaratorId1}
	 * labeled alternative in {@link RIIF2Parser#failModeDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailModeDeclaratorId1(RIIF2Parser.FailModeDeclaratorId1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code failModeDeclaratorId2}
	 * labeled alternative in {@link RIIF2Parser#failModeDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailModeDeclaratorId2(RIIF2Parser.FailModeDeclaratorId2Context ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#aisDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAisDeclaratorId(RIIF2Parser.AisDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primitiveIdId}
	 * labeled alternative in {@link RIIF2Parser#primitiveId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveIdId(RIIF2Parser.PrimitiveIdIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primitiveIdIdentifier}
	 * labeled alternative in {@link RIIF2Parser#primitiveId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveIdIdentifier(RIIF2Parser.PrimitiveIdIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#associativeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociativeId(RIIF2Parser.AssociativeIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributePrimitiveIdIndex}
	 * labeled alternative in {@link RIIF2Parser#attributeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributePrimitiveIdIndex(RIIF2Parser.AttributePrimitiveIdIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeAssociativeIdIndex}
	 * labeled alternative in {@link RIIF2Parser#attributeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeAssociativeIdIndex(RIIF2Parser.AttributeAssociativeIdIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#variableId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableId(RIIF2Parser.VariableIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#attributeIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeIndex(RIIF2Parser.AttributeIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#associativeIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociativeIndex(RIIF2Parser.AssociativeIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#tableIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableIndex(RIIF2Parser.TableIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#hierPostfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierPostfix(RIIF2Parser.HierPostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#tableId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableId(RIIF2Parser.TableIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#extendsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsList(RIIF2Parser.ExtendsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#implementsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplementsList(RIIF2Parser.ImplementsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(RIIF2Parser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#typeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(RIIF2Parser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#aisType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAisType(RIIF2Parser.AisTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#associativeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociativeType(RIIF2Parser.AssociativeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(RIIF2Parser.VectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#flatVector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlatVector(RIIF2Parser.FlatVectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldType(RIIF2Parser.FieldTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#enumType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(RIIF2Parser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#childComponentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildComponentType(RIIF2Parser.ChildComponentTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expCmp}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpCmp(RIIF2Parser.ExpCmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expPrimary}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPrimary(RIIF2Parser.ExpPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expEqOrNotEq}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpEqOrNotEq(RIIF2Parser.ExpEqOrNotEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expIfElse}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpIfElse(RIIF2Parser.ExpIfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expDoubleOr}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDoubleOr(RIIF2Parser.ExpDoubleOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expPositiveOrNegative}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPositiveOrNegative(RIIF2Parser.ExpPositiveOrNegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expAssign}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAssign(RIIF2Parser.ExpAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expSingleOr}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpSingleOr(RIIF2Parser.ExpSingleOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expPower}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPower(RIIF2Parser.ExpPowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expMinusOrPlus}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpMinusOrPlus(RIIF2Parser.ExpMinusOrPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expDoubleAnd}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDoubleAnd(RIIF2Parser.ExpDoubleAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expSingleAnd}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpSingleAnd(RIIF2Parser.ExpSingleAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expWaveOrNot}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpWaveOrNot(RIIF2Parser.ExpWaveOrNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expStarOrDivOrMod}
	 * labeled alternative in {@link RIIF2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpStarOrDivOrMod(RIIF2Parser.ExpStarOrDivOrModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryParentheses}
	 * labeled alternative in {@link RIIF2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryParentheses(RIIF2Parser.PrimaryParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primarySelf}
	 * labeled alternative in {@link RIIF2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimarySelf(RIIF2Parser.PrimarySelfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryTrue}
	 * labeled alternative in {@link RIIF2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryTrue(RIIF2Parser.PrimaryTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryFalse}
	 * labeled alternative in {@link RIIF2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryFalse(RIIF2Parser.PrimaryFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryAisDeclaratorId}
	 * labeled alternative in {@link RIIF2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryAisDeclaratorId(RIIF2Parser.PrimaryAisDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link RIIF2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryLiteral(RIIF2Parser.PrimaryLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryFuncCall}
	 * labeled alternative in {@link RIIF2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryFuncCall(RIIF2Parser.PrimaryFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryArrayInitializer}
	 * labeled alternative in {@link RIIF2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryArrayInitializer(RIIF2Parser.PrimaryArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(RIIF2Parser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(RIIF2Parser.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIIF2Parser#funcArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArg(RIIF2Parser.FuncArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalString}
	 * labeled alternative in {@link RIIF2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralString(RIIF2Parser.LiteralStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalDecimal}
	 * labeled alternative in {@link RIIF2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralDecimal(RIIF2Parser.LiteralDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalFloatingPoint}
	 * labeled alternative in {@link RIIF2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralFloatingPoint(RIIF2Parser.LiteralFloatingPointContext ctx);
}