package com.garethabrahams.Services;

public interface iService <Entity,EntityID>{
    Entity create(Entity e);
    Entity read(EntityID id);
    Entity update (Entity e);
    void delete (EntityID id);
}
