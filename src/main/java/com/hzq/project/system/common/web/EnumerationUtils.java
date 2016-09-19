package com.hzq.project.system.common.web;

import org.springframework.util.CollectionUtils;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Supplier;

/**
 * EnumerationUtils
 * Created by hzq on 16/9/19.
 */
public class EnumerationUtils {
    public static <T> Iterable<T> toIterable(final Supplier<Enumeration<T>> enumerationSupplier) {
        return new Iterable() {
            public Iterator<T> iterator() {
                return CollectionUtils.toIterator((Enumeration)enumerationSupplier.get());
            }
        };
    }
}
