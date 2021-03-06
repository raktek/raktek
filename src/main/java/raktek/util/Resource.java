package raktek.util;

import akasha.gl.WebGL2RenderingContext;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Resource<T>
  extends Component
{
  @Nullable
  private T _handle;
  private boolean _verified;

  protected Resource( @Nonnull final WebGL2RenderingContext gl )
  {
    super( gl );
  }

  public final boolean isAllocated()
  {
    return null != _handle;
  }

  public boolean isVerified()
  {
    return _verified;
  }

  @Nonnull
  protected final T getHandle()
  {
    assert null != _handle;
    return _handle;
  }

  protected final void setHandle( @Nullable final T handle )
  {
    _handle = handle;
    _verified = false;
  }

  /**
   * Allocate the underlying resource on the GPU and transfer data required to
   * initialize the resource. If a resource is already allocated then the existing
   * resource is {@link #release() released} and a new resource is allocated.
   *
   * @throws ResourceException if there is an unrecoverable error allocating resource.
   */
  public void allocate()
    throws ResourceException
  {
    release();
    setHandle( allocateResource() );
  }

  /**
   * Allocate the underlying resource unless it has already been allocated.
   *
   * @throws ResourceException if there is an unrecoverable error allocating resource.
   */
  public void allocateIfNecessary()
    throws ResourceException
  {
    if ( !isAllocated() )
    {
      allocate();
    }
  }

  /**
   * If a resource has been allocated then deallocate the resource.
   *
   * @throws ResourceException if there is an unrecoverable error releasing resource.
   */
  public final void release()
    throws ResourceException
  {
    if ( isAllocated() )
    {
      final T handle = getHandle();
      setHandle( null );
      releaseResource( handle );
    }
  }

  /**
   * If a resource has been allocated then verify the resource was allocated correctly.
   * If verification fails then the resource will be released and this method will thow a ResourceException.
   *
   * @throws ResourceException if the resource was not successfully allocated.
   */
  public final void verify()
    throws ResourceException
  {
    if ( !isVerified() )
    {
      final T handle = getHandle();
      try
      {
        verifyResource( handle );
        markAsVerified();
      }
      catch ( final ResourceException re )
      {
        try
        {
          release();
        }
        catch ( final ResourceException ignored )
        {
        }
        throw re;
      }
    }
  }

  private void markAsVerified()
  {
    _verified = true;
  }

  /**
   * Allocate the underlying resource.
   * The allocation may be asynchronous and may not be completed until verify is invoked.
   *
   * @return the resource handle.
   * @throws ResourceException if there is an unrecoverable error allocating resource.
   */
  @Nonnull
  protected abstract T allocateResource()
    throws ResourceException;

  /**
   * Actually perform the release of the underlying resource.
   *
   * @param handle the resource handle.
   * @throws ResourceException if there is an unrecoverable error releasing resource.
   */
  protected abstract void releaseResource( @Nonnull T handle )
    throws ResourceException;

  /**
   * Verify the underlying resource was allocated successfully.
   * This method will complete and an asynchronous allocation if allocateResource was asynchronous
   * and will check the state of any resource that is asynchronously allocated. If this method throws
   * a ResourceException then the caller will release the udnerlying resource.
   *
   * @param handle the resource handle.
   * @throws ResourceException if there is an unrecoverable error allocating resource.
   */
  protected void verifyResource( @Nonnull T handle )
    throws ResourceException
  {
  }
}
