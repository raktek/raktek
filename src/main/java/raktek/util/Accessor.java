package raktek.util;

import akasha.core.Float32Array;
import akasha.core.Int16Array;
import akasha.core.Int8Array;
import akasha.core.Uint16Array;
import akasha.core.Uint8Array;
import akasha.gl.AttributeComponentDataType;
import akasha.gl.AttributeComponentIntegerDataType;
import akasha.gl.VertexDimensions;
import akasha.gl.WebGL2RenderingContext;

/**
 * The Accessor class describes how a buffers memory is structured and should be accessed.
 * Multiple Accessor instances can be used to define different "views" of the data in a single
 * buffer. Accessors are immutable by design.
 */
public final class Accessor
{
  @VertexDimensions
  private final int _componentCount;
  @AttributeComponentDataType
  private final int _componentType;
  private final boolean _normalize;
  private final boolean _integer;
  private final int _stride;
  private final int _offset;
  private final int _divisor;

  public Accessor( @VertexDimensions final int componentCount )
  {
    this( componentCount, WebGL2RenderingContext.FLOAT );
  }

  public Accessor( @VertexDimensions final int componentCount, @AttributeComponentDataType final int componentType )
  {
    this( componentCount, componentType, 0, 0 );
  }

  public Accessor( @VertexDimensions final int componentCount,
                   @AttributeComponentDataType final int componentType,
                   final int stride,
                   final int offset )
  {
    this( componentCount, componentType, false, false, stride, offset, 0 );
  }

  public Accessor( @VertexDimensions final int componentCount,
                   @AttributeComponentDataType final int componentType,
                   final boolean normalize,
                   final boolean integer,
                   final int stride,
                   final int offset,
                   final int divisor )
  {
    assert componentCount > 0 && componentCount <= 4;
    assert stride >= 0 && stride <= 255;
    assert offset >= 0;
    // Normalize and integer flags should only be set to true for integer data types
    assert !normalize || AttributeComponentIntegerDataType.Util.isValid( componentType );
    assert !integer || AttributeComponentIntegerDataType.Util.isValid( componentType );
    assert !normalize || !integer;
    assert divisor >= 0;
    _componentCount = componentCount;
    _componentType = AttributeComponentDataType.Util.requireValid( componentType );
    _normalize = normalize;
    _integer = integer;
    _stride = stride;
    _offset = offset;
    _divisor = divisor;
    assert 0 == stride || stride >= getBytesPerVertex() :
      "Stride must be 0 or be greater the the bytesPerVertex. " +
      "stride=" + stride + " bytesPerVertex=" + getBytesPerVertex();
  }

  /**
   * @return the number of components per vertex attribute.
   */
  @VertexDimensions
  public int getComponentCount()
  {
    return _componentCount;
  }

  /**
   * @return the data type of each component in the vertex attribute.
   */
  @AttributeComponentDataType
  public int getComponentType()
  {
    return _componentType;
  }

  /**
   * @return true to normalize integers to [-1,1] if signed, or [0,1] if unsigned.
   * @see <a href="https://www.khronos.org/registry/webgl/specs/latest/1.0/#6.40">Vertex attribute conversions from normalized signed integers to floating point</a>
   */
  public boolean shouldNormalize()
  {
    return _normalize;
  }

  /**
   * Return true if the attribute data is integer data and should not be converted to floating point data.
   * In practical terms this means using {@link WebGL2RenderingContext#vertexAttribIPointer(int, int, int, int, int)}
   * rather than {@link WebGL2RenderingContext#vertexAttribPointer(int, int, int, boolean, int, int)} when passing
   * data to the GPU.
   *
   * @return return true to treat the attribute data as integer values, false to convert to floating point data.
   */
  public boolean isInteger()
  {
    return _integer;
  }

  /**
   * The offset in bytes between the beginning of consecutive vertex attributes.
   * Cannot be larger than 255. If the stride is 0 then the attribute is tightly
   * packed in the buffer. (i.e. the attributes are not interleaved but each attribute
   * is in a separate block, and the next vertex attribute follows immediately after
   * the current vertex.)
   *
   * @return the byte offset between consecutive vertex attributes. If the stride is 0, then the vertex attributes are tightly packed in the buffer.
   */
  public int getStride()
  {
    return _stride;
  }

  /**
   * @return the offset in bytes of the first vertex attribute in the vertex attribute buffer. Must be a multiple of the byte length of type.
   */
  public int getOffset()
  {
    return _offset;
  }

  public int getDivisor()
  {
    return _divisor;
  }

  /**
   * Return true if the attribute data is "instanced".
   * Attributes that have divisor N where N is other than zero advance once every N instances
   * of a draw*Instanced call. Thus in a {@link WebGL2RenderingContext#drawElementsInstanced(int, int, int, int, int)}
   * call the element transferred from instanced vertex attributes is given by: <code>instance/divisor</code>
   *
   * @return true if the attribute data is "instanced" otherwise false.
   */
  public boolean isInstanced()
  {
    return 0 != _divisor;
  }

  /**
   * Return the number of bytes used to represent each component.
   *
   * @return the number of bytes used to represent each component.
   */
  public int getBytesPerComponent()
  {
    if ( WebGL2RenderingContext.FLOAT == _componentType )
    {
      return Float32Array.BYTES_PER_ELEMENT;
    }
    else if ( WebGL2RenderingContext.UNSIGNED_SHORT == _componentType )
    {
      return Uint16Array.BYTES_PER_ELEMENT;
    }
    else if ( WebGL2RenderingContext.UNSIGNED_BYTE == _componentType )
    {
      return Uint8Array.BYTES_PER_ELEMENT;
    }
    else if ( WebGL2RenderingContext.BYTE == _componentType )
    {
      return Int8Array.BYTES_PER_ELEMENT;
    }
    else if ( WebGL2RenderingContext.SHORT == _componentType )
    {
      return Int16Array.BYTES_PER_ELEMENT;
    }
    else
    {
      assert WebGL2RenderingContext.HALF_FLOAT == _componentType;
      return Float32Array.BYTES_PER_ELEMENT / 2;
    }
  }

  /**
   * Returns the number of bytes per "vertex" attribute.
   * This is based on the component type and component count and ignores stride.
   *
   * @return the number of bytes per "vertex" attribute.
   */
  public int getBytesPerVertex()
  {
    return getBytesPerComponent() * _componentCount;
  }
}
