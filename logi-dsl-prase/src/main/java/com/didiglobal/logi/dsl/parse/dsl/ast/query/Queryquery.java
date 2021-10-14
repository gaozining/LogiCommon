package com.didiglobal.logi.dsl.parse.dsl.ast.query;

import com.didiglobal.logi.dsl.parse.dsl.ast.common.KeyWord;
import com.didiglobal.logi.dsl.parse.dsl.ast.common.multi.NodeMap;
import com.didiglobal.logi.dsl.parse.dsl.visitor.basic.Visitor;

public class Queryquery extends KeyWord {
    public NodeMap m = new NodeMap();

    public Queryquery(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor vistor) {
        vistor.visit(this);
    }
}
