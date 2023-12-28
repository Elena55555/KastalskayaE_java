import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.example.BalancedBracketService.isBalancedBrackets;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BalancedBracketServiceTest {


    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testParametersFromMethod(boolean expected, String input) {
        boolean actual = isBalancedBrackets(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(false, "[((())()(())]]"),
                Arguments.of(true, "[((())()(()))]"),
                Arguments.of(true, "[[(())()(())]]"),
                Arguments.of(false, "[[(())a()(())]]"),
                Arguments.of(false, "[[(())aa()(())]]"),
                Arguments.of(false, ")()[]")
        );
    }
}


