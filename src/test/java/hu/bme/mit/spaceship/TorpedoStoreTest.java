package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }
    @Test
    void initialTorpedoCount() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        assertEquals(10, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    @Test
    void fire_DecreasesTorpedoCount() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        boolean result = store.fire(1);

        assertTrue(result);
        assertEquals(9, store.getTorpedoCount());
    }

    @Test
    void fire_MultipleTorpedoes() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        boolean result = store.fire(5);

        assertTrue(result);
        assertEquals(5, store.getTorpedoCount());
    }

    @Test
    void fire_AllTorpedoes() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        boolean result = store.fire(5);

        assertTrue(result);
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void fire_Failure() {
        TorpedoStore store = new TorpedoStore(10, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
        assertEquals(10, store.getTorpedoCount());
    }

    @Test
    void fire_ZeroTorpedoes() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        assertThrows(IllegalArgumentException.class,
                () -> store.fire(0));
    }

    @Test
    void fire_NegativeTorpedoes() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        assertThrows(IllegalArgumentException.class,
                () -> store.fire(-1));
    }

    @Test
    void fire_TooManyTorpedoes() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertThrows(IllegalArgumentException.class,
                () -> store.fire(6));
    }

    @Test
    void isEmpty_WhenEmpty() {
        TorpedoStore store = new TorpedoStore(0, 0.0);

        assertTrue(store.isEmpty());
    }

    @Test
    void isEmpty_WhenNotEmpty() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertFalse(store.isEmpty());
    }

    @Test
    void fire_MultipleTimes() {
        TorpedoStore store = new TorpedoStore(3, 0.0);

        assertTrue(store.fire(1));
        assertTrue(store.fire(1));
        assertTrue(store.fire(1));

        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }
}
