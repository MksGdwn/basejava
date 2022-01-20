package com.beginjava.webapp.storage;

import com.beginjava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{
    @Override
    public void save(Resume r) {
        storage[getIndex(r.getUuid())] = r;
    }

    @Override
    public void update(Resume r) {
        save(r);
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    protected int getIndex(String uuid) {
        Resume key = new Resume();
        key.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, key);
    }
}
