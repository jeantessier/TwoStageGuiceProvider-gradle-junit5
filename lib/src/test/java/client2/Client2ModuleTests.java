package client2;

import org.jmock.Expectations;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import service.Service;

import static org.junit.jupiter.api.Assertions.assertSame;

class Client2ModuleTests {
    @RegisterExtension
    JUnit5Mockery context = new JUnit5Mockery();

    private final Client2Module sut = new Client2Module();

    @Test
    void provideService() {
        final Service mockService = context.mock(Service.class);

        context.checking(new Expectations() {{
            oneOf (mockService).setupClient2();
        }});

        Service actualService = sut.provideService(mockService);
        assertSame(mockService, actualService);
    }
}
