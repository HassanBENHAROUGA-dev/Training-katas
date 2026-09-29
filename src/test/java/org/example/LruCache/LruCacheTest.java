package org.example.LruCache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LruCacheTest {
    @Test
    void ShouldReturnValue(){
        LruCache lruCache = new LruCache(1);
        lruCache.put(1,10);

        assertEquals(10, lruCache.cache.get(1));
    }
    @Test
    void ShouldCheckMapSize(){
        LruCache lruCache = new LruCache(1);
        lruCache.put(1,10);
        lruCache.put(2,20);

        assertEquals(1, lruCache.cache.size());
    }
    @Test
    void ShouldReturnRecentValue(){
        LruCache lruCache = new LruCache(2);
        lruCache.put(1,10);
        lruCache.put(2,20);
        lruCache.get(1);
        lruCache.put(3,30);

        assertNull(lruCache.cache.get(2));
    }

    @Test
    void ShouldReturnRecentValue2(){
        LruCache lruCache = new LruCache(2);
        lruCache.put(1,10);
        lruCache.put(2,20);
        lruCache.get(1);
        lruCache.put(3,30);
        lruCache.put(4,40);

        assertNull(lruCache.cache.get(1));
    }

    @Test
    void ShouldUpdateExistingKeyFullCapacity(){
        LruCache lruCache = new LruCache(2);
        lruCache.put(1,10);
        lruCache.put(2,20);
        lruCache.put(1,30);

        assertEquals(30, lruCache.get(1));
        assertEquals(20, lruCache.get(2));
    }

    @Test
    void ShouldUpdateExistingKeyNotFullCapacity(){
        LruCache lruCache = new LruCache(3);
        lruCache.put(1,10);
        lruCache.put(2,20);
        lruCache.put(1,30);

        assertEquals(30, lruCache.get(1));
        assertEquals(2, lruCache.cache.size());
    }

    @Test
    void ShouldReturnNullIfKeyDoesNotExist(){
        LruCache lruCache = new LruCache(2);
        lruCache.put(1,10);
        lruCache.put(2,20);
        lruCache.put(1,30);

        assertNull(lruCache.get(3));
    }

    @Test
    void ShouldReturnNullIfKeyIsRemoved(){
        LruCache lruCache = new LruCache(2);
        lruCache.put(1,10);
        lruCache.put(2,20);
        lruCache.get(1);
        lruCache.put(3,30);

        assertNull(lruCache.get(2));
    }

    @Test
    void ShouldReturnTheRecentValueOfUpdatedKey(){
        LruCache lruCache = new LruCache(2);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(1, 30);
        lruCache.put(3, 40);

        assertNull(lruCache.get(2));
        assertEquals(30, lruCache.get(1));
        assertEquals(40, lruCache.get(3));
    }

    @Test
    void shouldRejectZeroCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new LruCache(0));
    }
}
