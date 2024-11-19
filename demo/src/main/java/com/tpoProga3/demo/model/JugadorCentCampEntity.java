package com.tpoProga3.demo.model;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
@Node("JugadorCentCamp")
public class JugadorCentCampEntity {
    @Id
    private final String name;

    public JugadorCentCampEntity(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
