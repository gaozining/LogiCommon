package com.didiglobal.logi.dsl.parse.dsl.ast.aggr;

import com.didiglobal.logi.dsl.parse.dsl.ast.common.KeyWord;
import com.didiglobal.logi.dsl.parse.dsl.ast.common.Node;
import com.didiglobal.logi.dsl.parse.dsl.visitor.basic.Visitor;

public class PercentileRanks extends KeyWord {

    public Node n;

    public PercentileRanks(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor vistor) {
        vistor.visit(this);
    }


}
