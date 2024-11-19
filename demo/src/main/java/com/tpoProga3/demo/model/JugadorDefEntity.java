package com.tpoProga3.demo.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
@Node("JugadorDef")
public class JugadorDefEntity {
    @Id
    private final String name;

    public JugadorDefEntity(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
