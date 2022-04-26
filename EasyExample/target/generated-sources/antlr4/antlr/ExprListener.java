// Generated from Expr.g4 by ANTLR 4.4

package antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull ExprParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull ExprParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(@NotNull ExprParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(@NotNull ExprParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition(@NotNull ExprParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition(@NotNull ExprParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull ExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull ExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull ExprParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull ExprParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull ExprParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull ExprParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(@NotNull ExprParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(@NotNull ExprParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(@NotNull ExprParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(@NotNull ExprParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull ExprParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull ExprParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Float}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloat(@NotNull ExprParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloat(@NotNull ExprParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull ExprParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull ExprParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(@NotNull ExprParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(@NotNull ExprParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(@NotNull ExprParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(@NotNull ExprParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stat(@NotNull ExprParser.While_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stat(@NotNull ExprParser.While_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull ExprParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull ExprParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull ExprParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull ExprParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivision(@NotNull ExprParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivision(@NotNull ExprParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(@NotNull ExprParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(@NotNull ExprParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(@NotNull ExprParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(@NotNull ExprParser.Stat_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull ExprParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull ExprParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(@NotNull ExprParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(@NotNull ExprParser.ElementContext ctx);
}