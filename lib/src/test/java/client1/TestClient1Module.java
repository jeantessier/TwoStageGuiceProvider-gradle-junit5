package client1;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import service.Service;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestClient1Module {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

    private final Client1Module sut = new Client1Module();

    @Test
    public void testProvideService() {
        final Service mockService = context.mock(Service.class);

        context.checking(new Expectations() {{
            oneOf (mockService).setupClient1();
        }});

        Service actualService = sut.provideService(mockService);
        assertThat(actualService, is(sameInstance(mockService)));
    }
}
