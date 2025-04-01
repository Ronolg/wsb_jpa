package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.AddressDao;
import com.jpacourse.persistance.entity.AddressEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AddressEntity findOne(Long id) {
        return entityManager.find(AddressEntity.class, id);
    }


}
