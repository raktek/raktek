package elemental3.gl;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    intValues = {
        WebGL2RenderingContext.RGB,
        WebGL2RenderingContext.RGBA,
        WebGL2RenderingContext.RED,
        WebGL2RenderingContext.RED_INTEGER,
        WebGL2RenderingContext.RG,
        WebGL2RenderingContext.RG_INTEGER,
        WebGL2RenderingContext.RGB_INTEGER,
        WebGL2RenderingContext.RGBA_INTEGER
    }
)
public @interface PixelFormat {
  final class Validator {
    private Validator() {
    }

    public static void assertValid(final int value) {
      assert isValid( value );
    }

    public static boolean isValid(final int value) {
      return WebGL2RenderingContext.RGB == value || WebGL2RenderingContext.RGBA == value || WebGL2RenderingContext.RED == value || WebGL2RenderingContext.RED_INTEGER == value || WebGL2RenderingContext.RG == value || WebGL2RenderingContext.RG_INTEGER == value || WebGL2RenderingContext.RGB_INTEGER == value || WebGL2RenderingContext.RGBA_INTEGER == value;
    }
  }
}