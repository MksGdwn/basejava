package com.beginjava.webapp.storage;

import com.beginjava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{
    protected final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume[] getAll() {
        if (size > 0) {
            return Arrays.copyOfRange(storage, 0, size);
        }

        return new Resume[0];
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume not found.");
            return null;
        }

        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}
