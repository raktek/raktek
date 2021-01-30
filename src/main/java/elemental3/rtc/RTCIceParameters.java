package elemental3.rtc;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * The RTCIceParameters dictionary specifies the username fragment and password assigned to an ICE session.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCIceParameters">RTCIceParameters - MDN</a>
 * @see <a href="https://w3c.github.io/webrtc-pc/#rtciceparameters">The definition of 'RTCIceParameters' in the 'WebRTC 1.0: Real-time Communication Between Browsers' specification.</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface RTCIceParameters {
  @JsOverlay
  @Nonnull
  static RTCIceParameters create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  /**
   * The RTCIceParameters dictionary's password property specifies the ICE password that, in tandem with the usernameFragment, uniquely identifies an ICE session for its entire duration.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCIceParameters/password">RTCIceParameters.password - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtciceparameters-password">The definition of 'RTCIceParameters.password' in the 'WebRTC 1.0: Real-time Communication Between Browsers' specification.</a>
   */
  @JsProperty(
      name = "password"
  )
  String password();

  /**
   * The RTCIceParameters dictionary's password property specifies the ICE password that, in tandem with the usernameFragment, uniquely identifies an ICE session for its entire duration.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCIceParameters/password">RTCIceParameters.password - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtciceparameters-password">The definition of 'RTCIceParameters.password' in the 'WebRTC 1.0: Real-time Communication Between Browsers' specification.</a>
   */
  @JsProperty
  void setPassword(@Nonnull String password);

  /**
   * The RTCIceParameters dictionary's password property specifies the ICE password that, in tandem with the usernameFragment, uniquely identifies an ICE session for its entire duration.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCIceParameters/password">RTCIceParameters.password - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtciceparameters-password">The definition of 'RTCIceParameters.password' in the 'WebRTC 1.0: Real-time Communication Between Browsers' specification.</a>
   */
  @JsOverlay
  @Nonnull
  default RTCIceParameters password(@Nonnull final String password) {
    setPassword( password );
    return this;
  }

  /**
   * The RTCIceParameters dictionary's usernameFragment property specifies the username fragment (&quot;ufrag&quot;) that uniquely identifies the corresponding ICE session for the duration of the current ICE session.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCIceParameters/usernameFragment">RTCIceParameters.usernameFragment - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtciceparameters-usernamefragment">The definition of 'RTCIceParameters.usernameFragment' in the 'WebRTC 1.0: Real-time Communication Between Browsers' specification.</a>
   */
  @JsProperty(
      name = "usernameFragment"
  )
  String usernameFragment();

  /**
   * The RTCIceParameters dictionary's usernameFragment property specifies the username fragment (&quot;ufrag&quot;) that uniquely identifies the corresponding ICE session for the duration of the current ICE session.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCIceParameters/usernameFragment">RTCIceParameters.usernameFragment - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtciceparameters-usernamefragment">The definition of 'RTCIceParameters.usernameFragment' in the 'WebRTC 1.0: Real-time Communication Between Browsers' specification.</a>
   */
  @JsProperty
  void setUsernameFragment(@Nonnull String usernameFragment);

  /**
   * The RTCIceParameters dictionary's usernameFragment property specifies the username fragment (&quot;ufrag&quot;) that uniquely identifies the corresponding ICE session for the duration of the current ICE session.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/RTCIceParameters/usernameFragment">RTCIceParameters.usernameFragment - MDN</a>
   * @see <a href="https://w3c.github.io/webrtc-pc/#dom-rtciceparameters-usernamefragment">The definition of 'RTCIceParameters.usernameFragment' in the 'WebRTC 1.0: Real-time Communication Between Browsers' specification.</a>
   */
  @JsOverlay
  @Nonnull
  default RTCIceParameters usernameFragment(@Nonnull final String usernameFragment) {
    setUsernameFragment( usernameFragment );
    return this;
  }
}