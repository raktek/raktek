package raktek.util;

import javax.annotation.Nonnull;
import org.realityforge.vecmath.Matrix4d;
import org.realityforge.vecmath.Vector3d;

public final class Camera
{
  /**
   * The world to camera space transform.
   */
  @Nonnull
  private final Matrix4d _viewMatrix = new Matrix4d();
  // Position of the eye
  @Nonnull
  private final Vector3d _position = new Vector3d( 0, 0, 0 );
  // Position of the target we are looking at
  @Nonnull
  private final Vector3d _direction = new Vector3d( 0, 0, -1.0F );
  // The up vector
  @Nonnull
  private final Vector3d _up = new Vector3d( 0, 1, 0 );
  private double _pitch = 0.0;
  private double _yaw = -Math.PI / 2.0;

  @Nonnull
  public Vector3d getPosition()
  {
    return _position;
  }

  @Nonnull
  public Vector3d getDirection()
  {
    return _direction;
  }

  @Nonnull
  public Vector3d getUp()
  {
    return _up;
  }

  @Nonnull
  public Matrix4d getViewMatrix()
  {
    return _viewMatrix;
  }

  public void updateViewMatrix()
  {
    _viewMatrix.setIdentity();
    _viewMatrix.lookAt( _position, _position.dup().add( _direction ), _up );
  }

  public double getPitch()
  {
    return _pitch;
  }

  public void setPitch( final double pitch )
  {
    _pitch = pitch;
  }

  public double getYaw()
  {
    return _yaw;
  }

  public void setYaw( final double yaw )
  {
    _yaw = yaw;
  }

  public void computeDirection()
  {
    _direction.x = (float) ( Math.cos( _pitch ) * Math.cos( _yaw ) );
    _direction.y = (float) Math.sin( _pitch );
    _direction.z = (float) ( Math.cos( _pitch ) * Math.sin( _yaw ) );
  }
}
