package org.acme.repositories;

import java.util.UUID;

import org.acme.models.UserModel;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<UserModel, UUID>{
    
}
