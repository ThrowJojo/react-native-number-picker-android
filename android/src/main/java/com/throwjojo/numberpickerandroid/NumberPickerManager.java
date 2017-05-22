package com.throwjojo.numberpickerandroid;

import android.support.annotation.Nullable;
import android.widget.NumberPicker;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Created by jordanholland on 2017/03/14.
 */

public class NumberPickerManager extends SimpleViewManager<NumberPicker> {

    private int selectedValue = 0;

    @Override
    protected NumberPicker createViewInstance(ThemedReactContext reactContext) {
        NumberPicker numberPicker = new NumberPicker(reactContext);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        return numberPicker;
    }

    // Binding for setDisplayedValues
    @ReactProp(name = "values")
    public void setValues(NumberPicker view, @Nullable ReadableArray values) {
        String[] displayValues = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            displayValues[i] = values.getString(i);
        }
        view.setMinValue(0);
        view.setMaxValue(displayValues.length - 1);
        view.setDisplayedValues(displayValues);
        if (selectedValue > 0) view.setValue(selectedValue);
    }

    // Binding for setValue
    @ReactProp(name = "selected")
    public void setSelected(NumberPicker view, int value) {
        this.selectedValue = value;
        view.setValue(value);
    }

    @Override
    protected void addEventEmitters(final ThemedReactContext reactContext, final NumberPicker view) {
        // Used to emit events for when a selection is changed
        view.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                WritableMap event = Arguments.createMap();
                event.putString("newValue", String.valueOf(newValue));
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                        view.getId(),
                        "topChange",
                        event
                );
            }
        });
    }

    @Override
    public String getName() {
        return "NumberPicker";
    }

}
