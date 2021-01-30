package elemental3;

import elemental3.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The Event interface represents an event which takes place in the DOM.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event">Event - MDN</a>
 * @see <a href="https://dom.spec.whatwg.org/#interface-event">The definition of 'Event' in the 'DOM' specification.</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Event"
)
public class Event {
  @JsOverlay
  public static final int AT_TARGET = 2;

  @JsOverlay
  public static final int BUBBLING_PHASE = 3;

  @JsOverlay
  public static final int CAPTURING_PHASE = 1;

  @JsOverlay
  public static final int NONE = 0;

  /**
   * The cancelBubble property of the Event interface is a historical alias to Event.stopPropagation(). Setting its value to true before returning from an event handler prevents propagation of the event. In later implementations, setting this to false does nothing. See Browser compatibility for details.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/cancelBubble">Event.cancelBubble - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-cancelbubble">The definition of 'cancelBubble' in the 'DOM' specification.</a>
   */
  public boolean cancelBubble;

  /**
   * The Event property returnValue indicates whether the default action for this event has been prevented or not.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/returnValue">Event.returnValue - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-returnvalue">The definition of 'returnValue' in the 'DOM' specification.</a>
   */
  public boolean returnValue;

  /**
   * The Event() constructor creates a new Event.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/Event">Event.Event - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-event">The definition of 'Event()' in the 'DOM' specification.</a>
   */
  public Event(@Nonnull final String type, @Nonnull final EventInit eventInitDict) {
  }

  /**
   * The Event() constructor creates a new Event.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/Event">Event.Event - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-event">The definition of 'Event()' in the 'DOM' specification.</a>
   */
  public Event(@Nonnull final String type) {
  }

  /**
   * The bubbles read-only property of the Event interface indicates whether the event bubbles up through the DOM or not.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/bubbles">Event.bubbles - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-bubbles">The definition of 'Event.bubbles' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-canBubble">The definition of 'Event.bubbles' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  @JsProperty(
      name = "bubbles"
  )
  public native boolean bubbles();

  /**
   * The cancelable read-only property of the Event interface indicates whether the event can be canceled, and therefore prevented as if the event never happened.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/cancelable">Event.cancelable - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-cancelable">The definition of 'Event.cancelable' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-canCancel">The definition of 'Event.cancelable' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  @JsProperty(
      name = "cancelable"
  )
  public native boolean cancelable();

  /**
   * The read-only composed property of the Event interface returns a Boolean which indicates whether or not the event will propagate across the shadow DOM boundary into the standard DOM.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/composed">Event.composed - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-composed">The definition of 'composed' in the 'DOM' specification.</a>
   */
  @JsProperty(
      name = "composed"
  )
  public native boolean composed();

  /**
   * The currentTarget read-only property of the Event interface identifies the current target for the event, as the event traverses the DOM. It always refers to the element to which the event handler has been attached, as opposed to Event.target, which identifies the element on which the event occurred and which may be its descendant.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/currentTarget">Event.currentTarget - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-currenttarget">The definition of 'Event.currentTarget' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/dom/#dom-event-currenttarget">The definition of 'Event.currentTarget' in the 'DOM4' specification.</a>
   * @see <a href="https://www.w3.org/TR/2014/WD-DOM-Level-3-Events-20140925/#dfn-current-event-target">The definition of 'current event target' in the 'Document Object Model (DOM) Level 3 Events Specification' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-currentTarget">The definition of 'Event.currentTarget' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  @JsProperty(
      name = "currentTarget"
  )
  @Nullable
  public native EventTarget currentTarget();

  /**
   * The defaultPrevented read-only property of the Event interface returns a Boolean indicating whether or not the call to Event.preventDefault() canceled the event.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/defaultPrevented">Event.defaultPrevented - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-defaultprevented">The definition of 'Event.defaultPrevented()' in the 'DOM' specification.</a>
   */
  @JsProperty(
      name = "defaultPrevented"
  )
  public native boolean defaultPrevented();

  /**
   * The eventPhase read-only property of the Event interface indicates which phase of the event flow is currently being evaluated.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/eventPhase">Event.eventPhase - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-eventphase">The definition of 'Event.eventPhase' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/dom/#dom-event-eventphase">The definition of 'Event.eventPhase' in the 'DOM4' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-eventPhase">The definition of 'Event.eventPhase' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  @JsProperty(
      name = "eventPhase"
  )
  @EventPhase
  public native int eventPhase();

  /**
   * The isTrusted read-only property of the Event interface is a Boolean that is true when the event was generated by a user action, and false when the event was created or modified by a script or dispatched via EventTarget.dispatchEvent().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/isTrusted">Event.isTrusted - MDN</a>
   */
  @JsProperty(
      name = "isTrusted"
  )
  public native boolean isTrusted();

  /**
   * Initially implemented in Internet Explorer, Event.srcElement is a now-standard alias (defined in the DOM Standard but flagged as &quot;historical&quot;) for the Event.target property. It's supported in all major browser engines, but only for compatibility reasons. Use Event.target instead.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/srcElement">Event.srcElement - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-srcelement">The definition of 'Event.srcElement' in the 'DOM' specification.</a>
   */
  @JsProperty(
      name = "srcElement"
  )
  @Nullable
  public native EventTarget srcElement();

  /**
   * The target property of the Event interface is a reference to the object onto which the event was dispatched. It is different from Event.currentTarget when the event handler is called during the bubbling or capturing phase of the event.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/target">Event.target - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-target">The definition of 'Event.target' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/dom/#dom-event-target">The definition of 'Event.target' in the 'DOM4' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-target">The definition of 'Event.target' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  @JsProperty(
      name = "target"
  )
  @Nullable
  public native EventTarget target();

  /**
   * The timeStamp read-only property of the Event interface returns the time (in milliseconds) at which the event was created.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/timeStamp">Event.timeStamp - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-timestamp">The definition of 'Event.timeStamp' in the 'DOM' specification.</a>
   */
  @JsProperty(
      name = "timeStamp"
  )
  public native double timeStamp();

  /**
   * The type read-only property of the Event interface returns a string containing the event's type. It is set when the event is constructed and is the name commonly used to refer to the specific event, such as click, load, or error.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/type">Event.type - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-type">The definition of 'Event.type' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-type">The definition of 'Event.type' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  @JsProperty(
      name = "type"
  )
  @Nonnull
  public native String type();

  /**
   * The composedPath() method of the Event interface returns the event&rsquo;s path which is an array of the objects on which listeners will be invoked. This does not include nodes in shadow trees if the shadow root was created with its ShadowRoot.mode closed.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/composedPath">Event.composedPath - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-composedpath">The definition of 'composedPath()' in the 'DOM' specification.</a>
   */
  @Nonnull
  public native JsArray<EventTarget> composedPath();

  /**
   * The Event.initEvent() method is used to initialize the value of an event created using Document.createEvent().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/initEvent">Event.initEvent - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-initevent">The definition of 'Event.initEvent()' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-initEvent">The definition of 'Event.initEvent()' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  public native void initEvent(@Nonnull String type, boolean bubbles, boolean cancelable);

  /**
   * The Event.initEvent() method is used to initialize the value of an event created using Document.createEvent().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/initEvent">Event.initEvent - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-initevent">The definition of 'Event.initEvent()' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-initEvent">The definition of 'Event.initEvent()' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  public native void initEvent(@Nonnull String type, boolean bubbles);

  /**
   * The Event.initEvent() method is used to initialize the value of an event created using Document.createEvent().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/initEvent">Event.initEvent - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-initevent">The definition of 'Event.initEvent()' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-initEvent">The definition of 'Event.initEvent()' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  public native void initEvent(@Nonnull String type);

  /**
   * The Event interface's preventDefault() method tells the user agent that if the event does not get explicitly handled, its default action should not be taken as it normally would be.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/preventDefault">Event.preventDefault - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-preventdefault">The definition of 'Event.preventDefault()' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-preventDefault">The definition of 'Event.preventDefault()' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  public native void preventDefault();

  /**
   * The stopImmediatePropagation() method of the Event interface prevents other listeners of the same event from being called.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/stopImmediatePropagation">Event.stopImmediatePropagation - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-stopimmediatepropagation">The definition of 'Event.stopImmediatePropagation()' in the 'DOM' specification.</a>
   */
  public native void stopImmediatePropagation();

  /**
   * The stopPropagation() method of the Event interface prevents further propagation of the current event in the capturing and bubbling phases. It does not, however, prevent any default behaviors from occurring; for instance, clicks on links are still processed. If you want to stop those behaviors, see the preventDefault() method.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/stopPropagation">Event.stopPropagation - MDN</a>
   * @see <a href="https://dom.spec.whatwg.org/#dom-event-stoppropagation">The definition of 'Event.stopPropagation()' in the 'DOM' specification.</a>
   * @see <a href="https://www.w3.org/TR/dom/#dom-event-stoppropagation">The definition of 'Event.stopPropagation()' in the 'DOM4' specification.</a>
   * @see <a href="https://www.w3.org/TR/DOM-Level-2-Events/events.html#Events-Event-stopPropagation">The definition of 'Event.stopPropagation()' in the 'Document Object Model (DOM) Level 2 Events Specification' specification.</a>
   */
  public native void stopPropagation();
}