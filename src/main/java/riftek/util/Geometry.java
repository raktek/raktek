package riftek.util;

import elemental3.gl.DrawPrimitiveType;
import elemental3.gl.WebGL2RenderingContext;
import elemental3.gl.WebGLVertexArrayObject;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Geometry
{
  @DrawPrimitiveType
  private final int _mode;
  private final int _offset;
  private final int _count;
  @Nonnull
  private final Attribute[] _attributes;
  @Nullable
  private final ElementBuffer _elementBuffer;
  @Nullable
  private WebGLVertexArrayObject _vertexArrayObject;

  public Geometry( final int count, @Nonnull final Attribute... attributes )
  {
    this( WebGL2RenderingContext.TRIANGLES, 0, count, null, attributes );
  }

  public Geometry( @DrawPrimitiveType final int mode,
                   final int offset,
                   final int count,
                   @Nullable final ElementBuffer elementBuffer,
                   @Nonnull final Attribute... attributes )
  {
    _mode = mode;
    _offset = offset;
    _count = count;
    _elementBuffer = elementBuffer;
    _attributes = Objects.requireNonNull( attributes );
  }

  public void uploadToGpu()
  {
    final AppState appState = AppState.get();
    appState.in( () -> {
      uploadBuffers();
      buildVertexArrayObject( appState );
    } );
  }

  private void buildVertexArrayObject( @Nonnull final AppState appState )
  {
    final WebGL2RenderingContext gl = appState.gl();
    final WebGLVertexArrayObject vertexArrayObject = gl.createVertexArray();
    assert null != vertexArrayObject;
    appState.bindVertexArrayObject( vertexArrayObject );

    if ( null != _elementBuffer )
    {
      _elementBuffer.bind();
    }

    for ( final Attribute attribute : _attributes )
    {
      // TODO: Maybe we should assume attribute is valid by here
      if ( attribute.isLocationValid() )
      {
        attribute.sendToGpu();
      }
    }
    appState.bindVertexArrayObject( null );
    for ( final Attribute attribute : _attributes )
    {
      // TODO: Maybe we should assume attribute is valid by here
      if ( attribute.isLocationValid() )
      {
        // TODO: It is unclear whether there is any value in performing disable here?
        //  did this as part of experiment to detect errors but left it in to potentially
        //  guard against similar errors. Maybe this should be optionally done behind compile
        //  time constant
        gl.disableVertexAttribArray( attribute.getLocation() );
      }
    }
    _vertexArrayObject = vertexArrayObject;
  }

  private void uploadBuffers()
  {
    if ( null != _elementBuffer )
    {
      _elementBuffer.allocate();
    }
    for ( final Attribute attribute : _attributes )
    {
      // TODO: Maybe we should assume attribute is valid by here
      if ( attribute.isLocationValid() )
      {
        attribute.getBuffer().allocate();
      }
    }
  }

  @Nonnull
  public Attribute getAttribute( final int index )
  {
    return _attributes[ index ];
  }

  public void draw()
  {
    assert null != _vertexArrayObject;
    final AppState appState = AppState.get();
    appState.bindVertexArrayObject( _vertexArrayObject );

    final WebGL2RenderingContext gl = appState.gl();
    if ( null == _elementBuffer )
    {
      gl.drawArrays( _mode, _offset, _count );
    }
    else
    {
      gl.drawElements( _mode, _count, _elementBuffer.getType(), _offset );
    }
    appState.bindVertexArrayObject( null );
  }
}