package elemental3;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    intValues = {
        PerformanceNavigation.TYPE_NAVIGATE,
        PerformanceNavigation.TYPE_RELOAD,
        PerformanceNavigation.TYPE_BACK_FORWARD,
        PerformanceNavigation.TYPE_RESERVED
    }
)
public @interface PerformanceNavigationType {
  final class Validator {
    private Validator() {
    }

    public static void assertValid(final int value) {
      assert isValid( value );
    }

    public static boolean isValid(final int value) {
      return PerformanceNavigation.TYPE_NAVIGATE == value || PerformanceNavigation.TYPE_RELOAD == value || PerformanceNavigation.TYPE_BACK_FORWARD == value || PerformanceNavigation.TYPE_RESERVED == value;
    }
  }
}