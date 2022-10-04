package org.example;

import java.util.Objects;

public class StringListImpl implements StringList{

    private static final int INITIAL_SIZE = 20;

    private final String[] data;

    private int capacity;

    public StringListImpl() {
        if (INITIAL_SIZE <= 0) {
            throw new IllegalArgumentException("Размер списка должен быть положительным");
        }
        data = new String[INITIAL_SIZE];
        capacity = 0;
    }

    @Override
    public String add(String item) {
        theListIsFull();
        doNotAddNull(item);
        data[capacity] = item;
        capacity++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        theListIsFull();
        doNotAddNull(item);
        indexError(index);
        // Копирует и сдвигает
        // Пример. а б в г д null null null ... null
        // а б в в г д null ... null
        System.arraycopy(data, index, data, index + 1, capacity - index);
        // Ставим ш вместо первой в
        // а б ш в г д null ... null
        data[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        doNotAddNull(item);
        indexError(index);
        // Пишем вместо старого значения новое на тоже место
        return data[index] = item;
    }

    @Override
    public String remove(String item) {
        int removing = indexOf(item);
        return remove(removing);
        // Возвращаем remove(index) и работаем в следующем remove (public String remove (int index))
    }

    @Override
    public String remove(int index) {
        indexError(index);
        String removed = data[index];
        // Копирует и сдвигает
        // Пример. а б в г д null null ... null
        // Удаляем в, копируем и сдвигаем г д: а б г д д null null ... null
        System.arraycopy(data, index + 1, data, index, capacity - 1 - index);
        capacity--;
        // Ставим вместо второй д null
        // Получилось: а б г д null null null ... null
        data[capacity] = null;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        doNotAddNull(item);
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        doNotAddNull(item);
        int index = -1;
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        doNotAddNull(item);
        int index = -1;
        for (int i = capacity - 1; i >= 0; i--) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        indexError(index);
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList, Object list) {
        if (Objects.isNull(otherList)) {
            throw new IllegalArgumentException("null не проверяем");
        }
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!data[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        // Если это условие выполняется, то возвращается true
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            data[i] = null;
        }
        capacity = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[capacity];
        System.arraycopy(data, 0, result, 0, capacity);
        return result;
    }

    private void theListIsFull() {
        if (capacity >= data.length) {
            throw new IllegalArgumentException("Список полон");
        }
    }

    private void doNotAddNull(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Добавлять null нельзя");
        }
    }

    private void indexError(int index) {
        if (index < 0 || index > capacity) {
            throw new IllegalArgumentException("Неверный индекс");
        }
    }
}
