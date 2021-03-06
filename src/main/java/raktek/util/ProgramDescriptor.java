package raktek.util;

import akasha.gl.AttributeDataType;
import akasha.gl.UniformDataType;
import akasha.gl.WebGL2RenderingContext;
import akasha.gl.WebGLActiveInfo;
import akasha.gl.WebGLProgram;
import akasha.gl.WebGLUniformLocation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import jsinterop.base.Any;
import raktek.Raktek;

public final class ProgramDescriptor
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final AttributeDescriptor[] _attributes;
  @Nonnull
  private final UniformDescriptor[] _uniforms;

  private ProgramDescriptor( @Nonnull final String name,
                             @Nonnull final AttributeDescriptor[] attributes,
                             @Nonnull final UniformDescriptor[] uniforms )
  {
    _name = Objects.requireNonNull( name );
    _attributes = Objects.requireNonNull( attributes );
    _uniforms = Objects.requireNonNull( uniforms );
    assert Arrays.stream( _attributes ).allMatch( Objects::nonNull );
    assert Arrays.stream( _uniforms ).allMatch( Objects::nonNull );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  public int getAttributeCount()
  {
    return _attributes.length;
  }

  @Nonnull
  public AttributeDescriptor getAttribute( final int index )
  {
    return _attributes[ index ];
  }

  @Nonnull
  public AttributeDescriptor getAttributeByName( @Nonnull final String name )
    throws NoSuchAttributeException
  {
    for ( final AttributeDescriptor attribute : _attributes )
    {
      if ( name.equals( attribute.getName() ) )
      {
        return attribute;
      }
    }
    throw new NoSuchAttributeException( name );
  }

  public int getUniformCount()
  {
    return _uniforms.length;
  }

  @Nonnull
  public UniformDescriptor getUniform( final int index )
  {
    return _uniforms[ index ];
  }

  @Nonnull
  public UniformDescriptor getUniformByName( @Nonnull final String name )
    throws NoSuchUniformException
  {
    for ( final UniformDescriptor uniform : _uniforms )
    {
      if ( name.equals( uniform.getName() ) )
      {
        return uniform;
      }
    }
    throw new NoSuchUniformException( name );
  }

  @Override
  public String toString()
  {
    return Raktek.shouldSupportDebugToString() ? toDebugString() : super.toString();
  }

  @Nonnull
  public String toDebugString()
  {
    final StringBuilder sb = new StringBuilder();
    sb.append( "Program " );
    sb.append( getName() );
    sb.append( "\n" );
    sb.append( "  Attributes:\n" );
    for ( final AttributeDescriptor attribute : _attributes )
    {
      sb.append( "    " );
      final String index = String.valueOf( attribute.getIndex() );
      StringUtil.padRight( sb, index, 3 - index.length() );
      sb.append( ": " );
      sb.append( AttributeDataType.Util.describe( attribute.getType() ) );
      sb.append( " " );
      sb.append( attribute.getName() );
      sb.append( "\n" );
    }
    if ( _uniforms.length > 0 )
    {
      sb.append( "  Uniforms:\n" );
      for ( final UniformDescriptor uniform : _uniforms )
      {
        sb.append( "      " );
        sb.append( UniformDataType.Util.describe( uniform.getType() ) );
        final int elementCount = uniform.getElementCount();
        if ( elementCount > 1 )
        {
          sb.append( "[" );
          sb.append( elementCount );
          sb.append( "]" );
        }
        sb.append( " " );
        sb.append( uniform.getName() );
        sb.append( "\n" );
      }
    }
    return sb.toString();
  }

  @Nonnull
  static ProgramDescriptor create( @Nonnull final WebGL2RenderingContext gl,
                                   @Nonnull final String programName,
                                   @Nonnull final AttributeLocation[] attributeLocations,
                                   @Nonnull final WebGLProgram program )
  {
    final Any activeUniforms = gl.getProgramParameter( program, WebGL2RenderingContext.ACTIVE_UNIFORMS );
    assert null != activeUniforms;
    final int uniformCount = activeUniforms.asInt();
    final List<UniformDescriptor> uniforms = new ArrayList<>();
    for ( int i = 0; i < uniformCount; i++ )
    {
      final WebGLActiveInfo info = gl.getActiveUniform( program, i );
      assert null != info;
      final String name = info.name();
      final WebGLUniformLocation location = gl.getUniformLocation( program, name );
      assert null != location;
      uniforms.add( new UniformDescriptor( name,
                                           UniformDataType.Util.requireValid( info.type() ),
                                           info.size(),
                                           location ) );
    }
    final Any activeAttributes = gl.getProgramParameter( program, WebGL2RenderingContext.ACTIVE_ATTRIBUTES );
    assert null != activeAttributes;
    final int attributeCount = activeAttributes.asInt();
    final List<AttributeDescriptor> attributes = new ArrayList<>();
    for ( int i = 0; i < attributeCount; i++ )
    {
      final WebGLActiveInfo info = gl.getActiveAttrib( program, i );
      assert null != info;

      int index = WebGL2RenderingContext.INVALID_INDEX;
      final String name = info.name();
      for ( final AttributeLocation location : attributeLocations )
      {
        if ( location.getName().equals( name ) )
        {
          index = location.getIndex();
        }
      }
      if ( WebGL2RenderingContext.INVALID_INDEX == index )
      {
        index = gl.getAttribLocation( program, name );
        assert WebGL2RenderingContext.INVALID_INDEX != index;
      }
      attributes.add( new AttributeDescriptor( name, AttributeDataType.Util.requireValid( info.type() ), index ) );
    }
    return new ProgramDescriptor( programName,
                                  attributes.toArray( new AttributeDescriptor[ 0 ] ),
                                  uniforms.toArray( new UniformDescriptor[ 0 ] ) );
  }
}
