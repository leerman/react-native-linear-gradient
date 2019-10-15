package com.BV.LinearGradient;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.yoga.YogaConstants;

import android.view.View;

public class LinearGradientManager extends SimpleViewManager<LinearGradientView> {

    public static final String REACT_CLASS = "BVLinearGradient";
    public static final String PROP_COLORS = "colors";
    public static final String PROP_LOCATIONS = "locations";
    public static final String PROP_START_POS = "startPoint";
    public static final String PROP_END_POS = "endPoint";
    public static final String PROP_USE_ANGLE = "useAngle";
    public static final String PROP_ANGLE_CENTER = "angleCenter";
    public static final String PROP_ANGLE = "angle";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected LinearGradientView createViewInstance(ThemedReactContext context) {
        return new LinearGradientView(context);
    }

    @ReactProp(name=PROP_COLORS)
    public void setColors(LinearGradientView gradientView, ReadableArray colors) {
        gradientView.setColors(colors);
    }

    @ReactProp(name=PROP_LOCATIONS)
    public void setLocations(LinearGradientView gradientView, ReadableArray locations) {
        if (locations != null) {
            gradientView.setLocations(locations);
        }
    }

    @ReactProp(name=PROP_START_POS)
    public void setStartPosition(LinearGradientView gradientView, ReadableArray startPos) {
        gradientView.setStartPosition(startPos);
    }

    @ReactProp(name=PROP_END_POS)
    public void setEndPosition(LinearGradientView gradientView, ReadableArray endPos) {
        gradientView.setEndPosition(endPos);
    }

    @ReactProp(name=PROP_USE_ANGLE, defaultBoolean = false)
    public void setUseAngle(LinearGradientView gradientView, boolean useAngle) {
        gradientView.setUseAngle(useAngle);
    }

    @ReactProp(name=PROP_ANGLE_CENTER)
    public void setAngleCenter(LinearGradientView gradientView, ReadableArray in) {
        gradientView.setAngleCenter(in);
    }

    @ReactProp(name=PROP_ANGLE, defaultFloat = 45.0f)
    public void setAngle(LinearGradientView gradientView, float angle) {
        gradientView.setAngle(angle);
    }

    // border radius props
    @ReactPropGroup(names = {
      ViewProps.BORDER_RADIUS,
      ViewProps.BORDER_TOP_LEFT_RADIUS,
      ViewProps.BORDER_TOP_RIGHT_RADIUS,
      ViewProps.BORDER_BOTTOM_RIGHT_RADIUS,
      ViewProps.BORDER_BOTTOM_LEFT_RADIUS
  }, defaultFloat = YogaConstants.UNDEFINED)
    public void setBorderRadius(LinearGradientView gradientView, int index, float borderRadius) {
        if (!YogaConstants.isUndefined(borderRadius)) {
            borderRadius = PixelUtil.toPixelFromDIP(borderRadius);
        }

        if (index == 0) {
            gradientView.setBorderRadius(borderRadius);
        } else {
            gradientView.setBorderRadius(borderRadius, index - 1);
        }
    }
}
