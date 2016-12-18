package org.yurkiss.antlr;

import org.yurkiss.antlr.eval.*;
import org.yurkiss.antlr.eval.operations.BinaryOperation;
import org.yurkiss.antlr.formulas.FormulasBaseVisitor;
import org.yurkiss.antlr.formulas.FormulasParser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurkiss on 12/16/16.
 */
public class FormulasVisitorImpl extends FormulasBaseVisitor<Expression> {

//    @Override
//    public Expression visitConcatenation(FormulasParser.ConcatenationContext ctx) {
////        return super.visitConcatenation(ctx);
//    }

    @Override
    public Expression visitLiter(FormulasParser.LiterContext ctx) {

        try {
            if (ctx.literal().NUMBER() != null) {
                return new Literal(Value.parseNumericValue(ctx.getText()));
            } else if (ctx.literal().STRING() != null) {
                return new Literal(Value.parseValue(ctx.getText(), Value.Type.BOOLEAN, Value.Type.DATE));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Literal(Value.parseValue(ctx.getText(), Value.Type.NUMERIC, Value.Type.BOOLEAN, Value.Type.DATE));
    }

    @Override
    public Expression visitAddSub(FormulasParser.AddSubContext ctx) {
        return createBinaryOperation(ctx);
    }

    private Expression createBinaryOperation(FormulasParser.ExprContext ctx) {
        try {
            BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());

            Expression leftOperand = visit(ctx.getChild(0));
            Expression rightOperand = visit(ctx.getChild(2));

            return new BinaryOperation(leftOperand, operator, rightOperand);

//            return operator;
        } catch (UnknownElementException e) {
            e.printStackTrace();
        }

        return new Literal(new Value("Error"));
    }

    @Override
    public Expression visitMulDiv(FormulasParser.MulDivContext ctx) {
        return createBinaryOperation(ctx);
    }

    //
//    @Override
    public Expression visitComparison(FormulasParser.ComparisonContext ctx) {
        return createBinaryOperation(ctx);
    }
//
//    @Override
//    public Expression visitParens(FormulasParser.ParensContext ctx) {
////        return super.visitParens(ctx);
//    }
//
//    @Override
//    public Expression visitComparisonOR(FormulasParser.ComparisonORContext ctx) {
////        return super.visitComparisonOR(ctx);
//    }
//
    @Override
    public Expression visitFunctionCall(FormulasParser.FunctionCallContext ctx) {
        // Convert function call
        Function function = null;
        try {
            function = Language.getInstance().getFunction(ctx.function().IDENTIFIER().getText());
        } catch (UnknownElementException e) {
        }

        if (function != null) {
            List<Expression> args = new ArrayList<>();
            for (FormulasParser.ExprContext context : ctx.function().expr()) {
                args.add(visit(context));
            }

            Expression[] argArray = args.toArray(new Expression[args.size()]);
            try {
                return new FunctionCall(function, argArray);
            } catch (IllegalFunctionCallException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Expression visitComparisonEquals(FormulasParser.ComparisonEqualsContext ctx) {

        return createBinaryOperation(ctx);
    }
//
//    @Override
//    public Expression visitPower(FormulasParser.PowerContext ctx) {
////        return super.visitPower(ctx);
//    }
//
//    @Override
//    public Expression visitName(FormulasParser.NameContext ctx) {
////        return super.visitName(ctx);
//    }
//
//    @Override
//    public Expression visitComparisonAnd(FormulasParser.ComparisonAndContext ctx) {
////        return super.visitComparisonAnd(ctx);
//    }
//
//    @Override
//    public Expression visitFunction(FormulasParser.FunctionContext ctx) {
////        return super.visitFunction(ctx);
//    }
//
//    @Override
//    public Expression visitQualifiedName(FormulasParser.QualifiedNameContext ctx) {
////        return super.visitQualifiedName(ctx);
//    }
//
//    @Override
//    public Expression visitLiteral(FormulasParser.LiteralContext ctx) {
////        return super.visitLiteral(ctx);
//    }
}
