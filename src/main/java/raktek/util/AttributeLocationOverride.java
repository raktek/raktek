package raktek.util;

import elemental3.gl.WebGL2RenderingContext;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * Class containing a mapping between an attribute name and an attribute location.
 * This is passed into Attribute
 */
public final class AttributeLocationOverride
{
  @Nonnull
  private final String _name;
  private final int _index;

  public AttributeLocationOverride( @Nonnull final String name, final int index )
  {
    assert WebGL2RenderingContext.INVALID_INDEX != index;
    _name = Objects.requireNonNull( name );
    _index = index;
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  public int getIndex()
  {
    return _index;
  }
}