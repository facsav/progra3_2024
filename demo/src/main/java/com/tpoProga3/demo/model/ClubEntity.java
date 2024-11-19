package com.tpoProga3.demo.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("Club")
public class ClubEntity {
    @Id
    private final String name;
    @Relationship(type = "Jugador_Defensor", direction = INCOMING)
    private Set<JugadorDefEntity> jdefensor = new HashSet<>();

    @Relationship(type = "Jugador_Delantero", direction = INCOMING)
    private Set<JugadorDelEntity> jdelantero = new HashSet<>();

    @Relationship(type = "Jugador_Arquero", direction = INCOMING)
    private Set<JugadorArqEntity> jarquero = new HashSet<>();

    @Relationship(type = "Jugador_Centrocampista", direction = INCOMING)
    private Set<JugadorCentCampEntity> jcentrocampista = new HashSet<>();
    @Relationship(type = "Director_Tecnico", direction = INCOMING)
    private Set<DirectorTecnicoEntity> directors = new HashSet<>();
    public ClubEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Set<JugadorDefEntity> getJdefensor() {
        return jdefensor;
    }

    public void setJdefensor(Set<JugadorDefEntity> jdefensor) {
        this.jdefensor = jdefensor;
    }

    public Set<JugadorDelEntity> getJdelantero() {
        return jdelantero;
    }

    public void setJdelantero(Set<JugadorDelEntity> jdelantero) {
        this.jdelantero = jdelantero;
    }

    public Set<JugadorCentCampEntity> getJcentrocampista() {
        return jcentrocampista;
    }

    public void setJcentrocampista(Set<JugadorCentCampEntity> jcentrocampista) {
        this.jcentrocampista = jcentrocampista;
    }

    public Set<JugadorArqEntity> getJarquero() {
        return jarquero;
    }

    public void setJarquero(Set<JugadorArqEntity> jarquero) {
        this.jarquero = jarquero;
    }

    public Set<DirectorTecnicoEntity> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<DirectorTecnicoEntity> directors) {
        this.directors = directors;
    }
}
