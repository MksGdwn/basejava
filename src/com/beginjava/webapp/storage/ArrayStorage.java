package com.beginjava.webapp.storage;

import com.beginjava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size > storage.length) {
            System.out.println("The storage is full");
            return;
        }

        if(findResume(r.getUuid()) < 0) {
            storage[size++] = r;
        }
        System.out.println("The storage already has this resume.");
    }

    public Resume get(String uuid) {
        int index = findResume(uuid);
        if (index > 0) {
            return storage[index];
        }

        System.out.println("Resume not found.");
        return null;
    }

    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index > 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
        else {
            System.out.println("Resume not found.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        if (size > 0) {
            return Arrays.copyOfRange(storage, 0, size);
        }

        return new Resume[0];
    }

    public int size() {
        return size;
    }

    private int findResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }
}
