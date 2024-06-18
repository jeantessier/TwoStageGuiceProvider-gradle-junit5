package service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestServiceImpl {
    private final Service sut = new ServiceImpl();

    @Test
    public void testDefault_StateEqualsGeneric() {
        assertThat(sut.getState(), is(equalTo("generic")));
    }

    @Test
    public void testSetupClient1_StateEqualsClient1() {
        sut.setupClient1();
        assertThat(sut.getState(), is(equalTo("client1")));
    }

    @Test
    public void testSetupClient2_StateEqualsClient2() {
        sut.setupClient2();
        assertThat(sut.getState(), is(equalTo("client2")));
    }
}
