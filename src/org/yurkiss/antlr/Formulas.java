package org.yurkiss.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.yurkiss.antlr.formulas.FormulasLexer;
import org.yurkiss.antlr.formulas.FormulasParser;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by yurkiss on 12/16/16.
 */
public class Formulas {
    public static void main(String[] args) throws IOException {

        String s = "Sum(1,2)";
        ANTLRInputStream input = new ANTLRInputStream(new StringReader(s));
        FormulasLexer lexer = new FormulasLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulasParser parser = new FormulasParser(tokens);
        ParseTree tree = parser.expr(); // parse; start at expr

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new FormulasVisitorImpl(), tree);

        System.out.println(tree.toStringTree(parser)); // print tree as text
    }
}
