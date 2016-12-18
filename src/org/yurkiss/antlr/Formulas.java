package org.yurkiss.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.yurkiss.antlr.eval.Expression;
import org.yurkiss.antlr.eval.IllegalValueTypeException;
import org.yurkiss.antlr.formulas.FormulasLexer;
import org.yurkiss.antlr.formulas.FormulasParser;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by yurkiss on 12/16/16.
 */
public class Formulas {
    public static void main(String[] args) throws IOException {

        String s = "4 / 2 + Sum(1,2,4)";
        ANTLRInputStream input = new ANTLRInputStream(new StringReader(s));
        FormulasLexer lexer = new FormulasLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulasParser parser = new FormulasParser(tokens);
        ParseTree tree = parser.expr(); // parse; start at expr

        FormulasVisitorImpl visitor = new FormulasVisitorImpl();
        Expression expr = visitor.visit(tree);

        System.out.println(tree.toStringTree(parser)); // print tree as text
        try {
            System.out.println(expr.evaluate());
        } catch (IllegalValueTypeException e) {
            e.printStackTrace();
        }


//        ParseTreeWalker walker = new ParseTreeWalker();
//        walker.walk(new FormulasVisitorImpl(), tree);

    }
}
