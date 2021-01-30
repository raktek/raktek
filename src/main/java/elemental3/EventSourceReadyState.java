package elemental3;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    intValues = {
        EventSource.CONNECTING,
        EventSource.OPEN,
        EventSource.CLOSED
    }
)
public @interface EventSourceReadyState {
  final class Validator {
    private Validator() {
    }

    public static void assertValid(final int value) {
      assert isValid( value );
    }

    public static boolean isValid(final int value) {
      return EventSource.CONNECTING == value || EventSource.OPEN == value || EventSource.CLOSED == value;
    }
  }
}