package demo

import slinky.core.facade.ReactElement
import slinky.core.{BuildingComponent, ReactComponentClass}
import typings.historyLib.historyMod.{Location, LocationState}
import typings.reactDashRouterDashDomLib.reactDashRouterDashDomLibComponents.Route
import typings.reactDashRouterLib.reactDashRouterMod.{
  RouteChildrenProps,
  RouteComponentProps,
  RouteProps,
  StaticContext
}
import typings.reactLib.ScalableSlinky._

import scala.scalajs.js
import scala.scalajs.js.|

/** The description of the `Route` component is somewhat rough, so this is a somewhat better slinky wrapper.
  *
  * The main problematic issue is the type parameter `T` which ends up in `match`, which is awkward in
  * typescript jsx, in slinky, and in ScalablyTyped for three different reasons.
  *
  * Note that this could be developed much further, probably the only way to make a somewhat sane API
  *  would be to use a builder.
  */
object RouteFacade {
  def apply[T](
      alwaysRender: js.Function1[ /* props */ RouteChildrenProps[T, LocationState], ReactElement]    = null,
      component:    ReactComponentClass[RouteComponentProps[T, StaticContext, LocationState]]        = null,
      exact:        js.UndefOr[scala.Boolean]                                                        = js.undefined,
      location:     Location[LocationState]                                                          = null,
      path:         String | js.Array[String]                                                        = null,
      render:       /* props */ RouteComponentProps[T, StaticContext, LocationState] => ReactElement = null,
      sensitive:    js.UndefOr[Boolean]                                                              = js.undefined,
      strict:       js.UndefOr[Boolean]                                                              = js.undefined
  ): BuildingComponent[Nothing, js.Object] = {

    val props = js.Dynamic.literal()
    if (alwaysRender != null) props.updateDynamic("children")(alwaysRender.asInstanceOf[js.Any])
    if (component != null) props.updateDynamic("component")(component.asInstanceOf[js.Any])
    if (!js.isUndefined(exact)) props.updateDynamic("exact")(exact)
    if (location != null) props.updateDynamic("location")(location)
    if (path != null) props.updateDynamic("path")(path.asInstanceOf[js.Any])
    if (render != null) props.updateDynamic("render")(js.Any.fromFunction1(render))
    if (!js.isUndefined(sensitive)) props.updateDynamic("sensitive")(sensitive)
    if (!js.isUndefined(strict)) props.updateDynamic("strict")(strict)

    Route[RouteProps].props(props.asInstanceOf[RouteProps])
  }
}
