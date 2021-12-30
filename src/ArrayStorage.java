import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume r : storage) {
            if (r != null) {
                if (uuid.equals(r.toString())) {
                    return r;
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].toString())) {
                storage[i] = null;

                for (int j = i; j < storage.length - i - 1; j++) {
                    if (storage[j + 1] != null) {
                        storage[j] = storage[j + 1];
                        storage[j + 1] = null;
                    }
                    else {
                        break;
                    }
                }

                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return Arrays.copyOfRange(storage, 0, i);
            }
        }
        return new Resume[0];
    }

    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
