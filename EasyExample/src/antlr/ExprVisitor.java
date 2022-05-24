// Generated from Expr.g4 by ANTLR 4.9.3

package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(ExprParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(ExprParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(ExprParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(ExprParser.Stat_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_block_NN}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block_NN(ExprParser.Stat_block_NNContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#while_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(ExprParser.While_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#neural_network}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeural_network(ExprParser.Neural_networkContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(ExprParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#dataset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataset(ExprParser.DatasetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#add_data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_data(ExprParser.Add_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#read_data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_data(ExprParser.Read_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#read_image_data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_image_data(ExprParser.Read_image_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#predict}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredict(ExprParser.PredictContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#train}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrain(ExprParser.TrainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#epochs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpochs(ExprParser.EpochsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#arraydecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraydecl(ExprParser.ArraydeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(ExprParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ExprParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(ExprParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(ExprParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ExprParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(ExprParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ExprParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiOp}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiOp(ExprParser.MultiOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveOp}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOp(ExprParser.AdditiveOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ExprParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(ExprParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(ExprParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(ExprParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(ExprParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ExprParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(ExprParser.ReadContext ctx);
}