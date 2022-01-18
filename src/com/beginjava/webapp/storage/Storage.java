package com.beginjava.webapp.storage;

import com.beginjava.webapp.model.Resume;

public interface Storage {
    void save(Resume r);
    void update(Resume r);
    void delete(String uuid);
    void clear();
    Resume get(String uuid);
    Resume[] getAll();
    int size();
}
