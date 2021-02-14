package raktek.util;

import elemental3.gl.KHR_parallel_shader_compile;
import elemental3.gl.WebGL2RenderingContext;
import elemental3.gl.WebGLProgram;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Any;
import raktek.Raktek;

public final class Program
  extends Resource<WebGLProgram>
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Shader _vertexShader;
  @Nonnull
  private final Shader _fragmentShader;
  @Nonnull
  private final AttributeLocation[] _attributeLocations;
  @Nullable
  private String _error;

  public Program( @Nonnull final WebGL2RenderingContext gl,
                  @Nonnull final String name,
                  @Nonnull final Shader vertexShader,
                  @Nonnull final Shader fragmentShader )
  {
    this(gl, name, vertexShader, fragmentShader, new AttributeLocation[0] );
  }
  public Program( @Nonnull final WebGL2RenderingContext gl,
                  @Nonnull final String name,
                  @Nonnull final Shader vertexShader,
                  @Nonnull final Shader fragmentShader,
                  @Nonnull final AttributeLocation[] attributeLocations )
  {
    super( gl, false );
    _name = Objects.requireNonNull( name );
    _vertexShader = Objects.requireNonNull( vertexShader );
    _fragmentShader = Objects.requireNonNull( fragmentShader );
    _attributeLocations = Objects.requireNonNull( attributeLocations );
    assert Arrays.stream( _attributeLocations ).allMatch( Objects::nonNull );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public String getLabel()
  {
    return "program " + getName();
  }

  @Nonnull
  public Shader getVertexShader()
  {
    return _vertexShader;
  }

  @Nonnull
  public Shader getFragmentShader()
  {
    return _fragmentShader;
  }

  @Nonnull
  public WebGLProgram getWebGLProgram()
  {
    return getHandle();
  }

  public boolean hasError()
  {
    return null != _error;
  }

  /**
   * Return the an error description when the program could not be allocated.
   * This is only set after the {@link #allocate()} or {@link #verify()} methods are called and
   * only if an error occurred. This error is the raw form emitted by the underlying API.
   *
   * @return the error message resulting from the last attempt to allocate the program.
   */
  @Nullable
  public String getError()
  {
    return _error;
  }

  /**
   * Return the an error description when the program could not be allocated.
   * This is only set after the {@link #allocate()} or {@link #verify()} methods are called and
   * only if an error occurred. This error is formatted to be easier to consume by the developer
   * compared to #{@link #getError()} and includes formatted errors for the shaders if any errors
   * or warnings are generated by the shaders.
   *
   * @return the error message resulting from the last attempt to allocate the program.
   */
  @Nullable
  public String getFormattedErrorLog()
  {
    if ( null == _error )
    {
      return null;
    }
    else
    {
      String error = getLabel() + ":\n" + _error;
      final String vertexShaderError = _vertexShader.getError();
      if ( null != vertexShaderError )
      {
        error += "\n\n" +
                 ShaderUtil.formatInfoLog( vertexShaderError,
                                           _vertexShader.getLabel() + ":\n",
                                           _vertexShader.getSource() );
      }
      final String fragmentShaderError = _fragmentShader.getError();
      if ( null != fragmentShaderError )
      {
        error += "\n\n" +
                 ShaderUtil.formatInfoLog( fragmentShaderError,
                                           _fragmentShader.getLabel() + ":\n",
                                           _fragmentShader.getSource() );
      }
      return error;
    }
  }

  /**
   * Return the completion status. This relies on the <code>KHR_parallel_shader_compile</code> extension and will return
   * {@link CompletionStatus#UNKNOWN} if the extension is not present.
   *
   * @return the completion status.
   */
  @CompletionStatus
  public int getCompletionStatus()
  {
    final WebGL2RenderingContext gl = gl();
    final KHR_parallel_shader_compile extension =
      (KHR_parallel_shader_compile) gl.getExtension( "KHR_parallel_shader_compile" );
    if ( null == extension )
    {
      return CompletionStatus.UNKNOWN;
    }
    else
    {
      final Any parameter =
        gl.getProgramParameter( getHandle(), KHR_parallel_shader_compile.COMPLETION_STATUS_KHR );
      assert null != parameter;
      return parameter.asBoolean() ? CompletionStatus.COMPLETE : CompletionStatus.INCOMPLETE;
    }
  }

  /**
   * Return true if verify should be invoked.
   * If the KHR_parallel_shader_compile is present then this method will only return true when
   * accessing the program LINK_STATUS will not block. If the extension is not present then this method
   * always returns true but verify may block.
   *
   * @return true if verify should be invoked.
   */
  public boolean shouldVerify()
  {
    return CompletionStatus.INCOMPLETE != getCompletionStatus();
  }

  @Nonnull
  @Override
  protected WebGLProgram allocateResource()
    throws ResourceException
  {
    _error = null;
    final WebGL2RenderingContext gl = gl();
    final WebGLProgram program = gl.createProgram();
    if ( null == program )
    {
      throw new ResourceException( ErrorCode.PROGRAM_CREATE_FAILED, gl.getError() );
    }
    _vertexShader.allocateIfNecessary();
    _fragmentShader.allocateIfNecessary();
    gl.attachShader( program, _vertexShader.getHandle() );
    gl.attachShader( program, _fragmentShader.getHandle() );

    for ( final AttributeLocation attributeLocation : _attributeLocations )
    {
      gl.bindAttribLocation( program, attributeLocation.getIndex(), attributeLocation.getName() );
    }
    gl.linkProgram( program );

    if ( Raktek.shouldCheckSProgramLinkAtAllocate() )
    {
      checkProgramLink( program );
    }
    return program;
  }

  @Override
  protected void releaseResource( @Nonnull final WebGLProgram handle )
  {
    gl().deleteProgram( handle );
    //TODO: Assert context has no errors in debug mode
  }

  @Override
  protected void verifyResource( @Nonnull final WebGLProgram handle )
    throws ResourceException
  {
    if ( !Raktek.shouldCheckSProgramLinkAtAllocate() )
    {
      checkProgramLink( handle );
    }
  }

  private void checkProgramLink( @Nonnull final WebGLProgram program )
  {
    if ( Raktek.shouldCheckProgramLink() )
    {
      final WebGL2RenderingContext gl = gl();
      final Any parameter = gl.getProgramParameter( program, WebGL2RenderingContext.LINK_STATUS );
      assert null != parameter;
      if ( !parameter.asBoolean() )
      {
        _error = gl.getProgramInfoLog( program );
        release();
        // Explicitly check compile status for shaders. Depending on compile time settings the shaders
        // may not have had their compile status already checked and thus will have null errors. This
        // will ensure that if the shaders have errors or warnings then these stings are present on shaders
        _vertexShader.checkCompileStatus();
        _fragmentShader.checkCompileStatus();
        throw new ResourceException( ErrorCode.PROGRAM_LINK_FAILED, gl.getError(), _error );
      }
    }
  }
}
