import { PropTypes } from 'react';
import { requireNativeComponent, View } from 'react-native';

let viewInterface = {
    name: 'NumberPicker',
    propTypes: {
        ...View.propTypes,
        values: PropTypes.arrayOf(String),
        selected: PropTypes.number
    }
};

module.exports = requireNativeComponent('NumberPicker', viewInterface, {
    nativeOnly: {
        onChange: true
    }
});