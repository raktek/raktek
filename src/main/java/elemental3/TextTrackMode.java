package elemental3;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = TextTrackMode.class
)
public @interface TextTrackMode {
  @Nonnull
  String disabled = "disabled";

  @Nonnull
  String hidden = "hidden";

  @Nonnull
  String showing = "showing";

  final class Validator {
    private Validator() {
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return TextTrackMode.disabled.equals( value ) || TextTrackMode.hidden.equals( value ) || TextTrackMode.showing.equals( value );
    }
  }
}