// Generated from /Users/yurkiss/IdeaProjects/AntlrSample/src/org/yurkiss/antlr/Formulas.g4 by ANTLR 4.5.3
package org.yurkiss.antlr.formulas;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormulasParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormulasVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Unar}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnar(FormulasParser.UnarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Liter}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiter(FormulasParser.LiterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(FormulasParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(FormulasParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(FormulasParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonOR}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOR(FormulasParser.ComparisonORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Name}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(FormulasParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonAnd}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonAnd(FormulasParser.ComparisonAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concatenation}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(FormulasParser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FormulasParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(FormulasParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonEquals}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonEquals(FormulasParser.ComparisonEqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link FormulasParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(FormulasParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulasParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(FormulasParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulasParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(FormulasParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulasParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(FormulasParser.LiteralContext ctx);
}