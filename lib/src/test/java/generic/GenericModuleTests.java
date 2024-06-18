package generic;

import org.junit.jupiter.api.Test;
import service.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GenericModuleTests {
    private final GenericModule sut = new GenericModule();

    @Test
    void provideService() {
        Service actualService = sut.provideService();
        assertNotNull(actualService);
        assertEquals("generic", actualService.getState());
    }
}
