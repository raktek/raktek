package elemental3.rtc;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface RTCVideoSourceStats extends RTCMediaSourceStats {
  @JsOverlay
  @Nonnull
  static RTCVideoSourceStats create(@Nonnull final String id, final double timestamp,
      @RTCStatsType @Nonnull final String type, @Nonnull final String kind,
      @Nonnull final String trackIdentifier) {
    return Js.<RTCVideoSourceStats>uncheckedCast( JsPropertyMap.of() ).id( id ).timestamp( timestamp ).type( type ).kind( kind ).trackIdentifier( trackIdentifier );
  }

  @JsProperty(
      name = "bitDepth"
  )
  int bitDepth();

  @JsProperty
  void setBitDepth(int bitDepth);

  @JsOverlay
  @Nonnull
  default RTCVideoSourceStats bitDepth(final int bitDepth) {
    setBitDepth( bitDepth );
    return this;
  }

  @JsProperty(
      name = "frames"
  )
  int frames();

  @JsProperty
  void setFrames(int frames);

  @JsOverlay
  @Nonnull
  default RTCVideoSourceStats frames(final int frames) {
    setFrames( frames );
    return this;
  }

  @JsProperty(
      name = "framesPerSecond"
  )
  double framesPerSecond();

  @JsProperty
  void setFramesPerSecond(double framesPerSecond);

  @JsOverlay
  @Nonnull
  default RTCVideoSourceStats framesPerSecond(final double framesPerSecond) {
    setFramesPerSecond( framesPerSecond );
    return this;
  }

  @JsProperty(
      name = "height"
  )
  int height();

  @JsProperty
  void setHeight(int height);

  @JsOverlay
  @Nonnull
  default RTCVideoSourceStats height(final int height) {
    setHeight( height );
    return this;
  }

  @JsProperty(
      name = "width"
  )
  int width();

  @JsProperty
  void setWidth(int width);

  @JsOverlay
  @Nonnull
  default RTCVideoSourceStats width(final int width) {
    setWidth( width );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default RTCVideoSourceStats kind(@Nonnull final String kind) {
    setKind( kind );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default RTCVideoSourceStats relayedSource(final boolean relayedSource) {
    setRelayedSource( relayedSource );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default RTCVideoSourceStats trackIdentifier(@Nonnull final String trackIdentifier) {
    setTrackIdentifier( trackIdentifier );
    return this;
  }

  /**
   * The id property of the RTCStats dictionary is a string which uniquely identifies the object for which this RTCStats object provides statistics.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCStats/id">RTCStats.id - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtcstats-id">RTCStats.id - WebRTC 1.0: Real-time Communication Between Browsers</a>
   */
  @JsOverlay
  @Nonnull
  @Override
  default RTCVideoSourceStats id(@Nonnull final String id) {
    setId( id );
    return this;
  }

  /**
   * The timestamp property of the RTCStats dictionary is a DOMHighResTimeStamp object specifying the time at which the data in the object was sampled.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCStats/timestamp">RTCStats.timestamp - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtcstats-timestamp">RTCStats.timestamp - WebRTC 1.0: Real-time Communication Between Browsers</a>
   */
  @JsOverlay
  @Nonnull
  @Override
  default RTCVideoSourceStats timestamp(final double timestamp) {
    setTimestamp( timestamp );
    return this;
  }

  /**
   * The RTCStats dictionary's property type is a string which specifies the type of statistic represented by the object, where the permitted values are drawn from the enum type RTCStatsType.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCStats/type">RTCStats.type - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtcstats-type">RTCStats.type - WebRTC 1.0: Real-time Communication Between Browsers</a>
   */
  @JsOverlay
  @Nonnull
  @Override
  default RTCVideoSourceStats type(@RTCStatsType @Nonnull final String type) {
    setType( type );
    return this;
  }
}
