package org.yurkiss.antlr.expr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yurkiss on 10/11/16.
 */
public class AntlrSample {
    public static void main(String[] args) throws IOException {
        InputStream is = (args.length == 0)
                ?  System.in
                : new FileInputStream(args[0]);

//        ANTLRInputStream input = new ANTLRInputStream(is);
        CharStream input = new ANTLRInputStream("a=3 + 3 * (2+2)\n b=5\n a+b\n");
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);

        ParseTree tree = parser.prog();

        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);

        System.out.println(eval.memory);

    }

}

