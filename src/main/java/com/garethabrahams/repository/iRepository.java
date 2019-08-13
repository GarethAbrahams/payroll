package com.garethabrahams.repository;

public interface iRepository <Entity,EntityID>{
    Entity create(Entity e);
    Entity update(Entity e);
    void delete(EntityID id);
    Entity read (EntityID id);
}
