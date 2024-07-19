package com.tommy_hoang_p0.Util.Interfaces;

public interface Crudable<O> extends Serviceable<O>{
    boolean update(O updatedObject);
    boolean delete(int id);
}