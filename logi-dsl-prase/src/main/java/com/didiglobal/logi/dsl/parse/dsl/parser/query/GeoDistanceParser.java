package com.didiglobal.logi.dsl.parse.dsl.parser.query;

import com.alibaba.fastjson.JSONObject;
import com.didiglobal.logi.dsl.parse.dsl.ast.common.KeyWord;
import com.didiglobal.logi.dsl.parse.dsl.ast.common.key.FieldNode;
import com.didiglobal.logi.dsl.parse.dsl.ast.common.key.StringNode;
import com.didiglobal.logi.dsl.parse.dsl.ast.common.multi.NodeMap;
import com.didiglobal.logi.dsl.parse.dsl.ast.common.value.ValueNode;
import com.didiglobal.logi.dsl.parse.dsl.ast.query.GeoDistance;
import com.didiglobal.logi.dsl.parse.dsl.parser.DslParser;
import com.didiglobal.logi.dsl.parse.dsl.parser.ParserType;

import java.util.HashSet;
import java.util.Set;

public class GeoDistanceParser extends DslParser {
    private static final Set<String> keyWords = new HashSet<>();

    static {
        keyWords.add("distance");
        keyWords.add("distance_type");
        keyWords.add("optimize_bbox");
        keyWords.add("_name");
        keyWords.add("ignore_malformed");
        keyWords.add("validation_method");
    }

    public GeoDistanceParser(ParserType type) {
        super(type);
    }

    @Override
    public KeyWord parse(String name, Object root) throws Exception {
        GeoDistance node = new GeoDistance(name);
        NodeMap nm = new NodeMap();

        JSONObject obj = (JSONObject) root;
        boolean haveField = false;
        for (String key : obj.keySet()) {
            if (keyWords.contains(key.toLowerCase())) {
                nm.m.put(new StringNode(key), ValueNode.getValueNode(obj.get(key)));

            } else {
                if (haveField) {
                    throw new Exception("wrong geo, json:" + root);
                }

                haveField = true;
                nm.m.put(new FieldNode(key), ValueNode.getValueNode(obj.get(key)));
            }
        }

        node.n = nm;
        return node;
    }
}
