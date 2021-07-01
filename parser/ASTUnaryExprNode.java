package parser;

import parser.*;
import parser.visitor.Visitor;
import java.util.*;

public class ASTUnaryExprNode implements ASTExprNode{

    public ASTUnaryExprNode(String unary_op, ASTExprNode expr, int line_number) {
        this.unary_op = unary_op;
        this.expr = expr;
		this.line_number = line_number;
	}

    public String unary_op;
    ASTExprNode expr;
	public int line_number;

    @Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
