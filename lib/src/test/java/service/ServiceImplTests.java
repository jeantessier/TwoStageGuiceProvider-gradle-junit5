package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceImplTests {
    private final Service sut = new ServiceImpl();

    @Test
    void default_StateEqualsGeneric() {
        assertEquals("generic", sut.getState());
    }

    @Test
    void setupClient1_StateEqualsClient1() {
        sut.setupClient1();
        assertEquals("client1", sut.getState());
    }

    @Test
    void setupClient2_StateEqualsClient2() {
        sut.setupClient2();
        assertEquals("client2", sut.getState());
    }
}
