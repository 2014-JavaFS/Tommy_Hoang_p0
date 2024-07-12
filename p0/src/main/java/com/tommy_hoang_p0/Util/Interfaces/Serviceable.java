package com.tommy_hoang_p0.Util.Interfaces;

import com.tommy_hoang_p0.Util.Exceptions.InvalidInputException;

public interface Serviceable<O> {
     O[] findAll();
     O create(O newObject) throws InvalidInputException;
     O findById(int number);
}
