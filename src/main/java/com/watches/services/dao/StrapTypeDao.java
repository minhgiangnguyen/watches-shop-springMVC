package com.watches.services.dao;

import java.util.List;

import com.watches.entities.StrapType;

public interface StrapTypeDao {
   public List<StrapType> getAll();
   public boolean insert(StrapType st);
   public boolean update(StrapType st);
   public boolean delete(int stkey);
   public StrapType getById(int stkey);
   public List<StrapType> search(String name);
}
