/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The JAVATUPLES team (http://www.javatuples.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.javatuples;

import java.util.Collection;
import java.util.Iterator;

public final class KeyValue<A,B> extends Tuple {

    private static final long serialVersionUID = 5055574980300695706L;

    private static final int SIZE = 2;

    private final A key;
    private final B value;
    
    
    
    public static <A,B> KeyValue<A,B> with(final A key, final B value) {
        return new KeyValue<A,B>(key,value);
    }

    
    public static <X> KeyValue<X,X> fromArray(final X[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (array.length != 2) {
            throw new IllegalArgumentException("Array must have exactly 2 elements in order to create a KeyValue. Size is " + array.length);
        }
        return new KeyValue<X,X>(array[0],array[1]);
    }

    
    public static <X> KeyValue<X,X> fromCollection(final Collection<X> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        if (collection.size() != 2) {
            throw new IllegalArgumentException("Collection must have exactly 2 elements in order to create a KeyValue. Size is " + collection.size());
        }
        final Iterator<X> iter = collection.iterator();
        return new KeyValue<X,X>(iter.next(),iter.next());
    }
    
    
    public KeyValue(
            final A key, 
            final B value) {
        super(SIZE, key, value);
        this.key = key;
        this.value = value;
    }


    public A getKey() {
        return this.key;
    }


    public B getValue() {
        return this.value;
    }


    @Override
    public int getSize() {
        return SIZE;
    }
    
    
    
    public <X> KeyValue<X,B> setKey(final X key) {
        return new KeyValue<X,B>(key, this.value);
    }
    
    
    public <Y> KeyValue<A,Y> setValue(final Y value) {
        return new KeyValue<A,Y>(this.key, value);
    }
    
    
    
    
    
}
