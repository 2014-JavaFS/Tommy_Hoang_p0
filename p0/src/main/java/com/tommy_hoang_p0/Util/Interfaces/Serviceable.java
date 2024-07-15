package com.tommy_hoang_p0.Util.Interfaces;

import java.util.List;

import com.tommy_hoang_p0.Util.Exceptions.InvalidInputException;

public interface Serviceable<O> {
     List<O> findAll();
     O create(O newObject) throws InvalidInputException;
     O findById(int number);
}
