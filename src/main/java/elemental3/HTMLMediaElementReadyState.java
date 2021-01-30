package elemental3;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    intValues = {
        HTMLMediaElement.HAVE_NOTHING,
        HTMLMediaElement.HAVE_CURRENT_DATA,
        HTMLMediaElement.HAVE_METADATA,
        HTMLMediaElement.HAVE_FUTURE_DATA,
        HTMLMediaElement.HAVE_ENOUGH_DATA
    }
)
public @interface HTMLMediaElementReadyState {
  final class Validator {
    private Validator() {
    }

    public static void assertValid(final int value) {
      assert isValid( value );
    }

    public static boolean isValid(final int value) {
      return HTMLMediaElement.HAVE_NOTHING == value || HTMLMediaElement.HAVE_CURRENT_DATA == value || HTMLMediaElement.HAVE_METADATA == value || HTMLMediaElement.HAVE_FUTURE_DATA == value || HTMLMediaElement.HAVE_ENOUGH_DATA == value;
    }
  }
}